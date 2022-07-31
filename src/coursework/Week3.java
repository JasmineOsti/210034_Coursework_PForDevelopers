package coursework;


import java.util.*;


class Week3 {

    int parent[];
    int rank[];


    Week3(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            rank[i] = 1;
        }
    }

   
    int find_set(int v) {

        
        if (parent[v] == -1)
            return v;

      
        return parent[v] = find_set(parent[v]);
    }

   
    void union_sets(int a, int b) {

        
        int p1 = find_set(a);
        int p2 = find_set(b);

        
        if (p1 != p2) {

            
            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }
        }
    }
}

class GFG {

    // Function to create a Minimum Cost
    // Spanning tree for given houses
    static void MST(int houses[][], int n) {
        int ans = 0;
        ArrayList<int[]> edges = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

               
                int p = Math.abs(houses[i][0] -
                        houses[j][0]);

                p += Math.abs(houses[i][1] -
                        houses[j][1]);

               
                edges.add(new int[] { p, i, j });
            }
        }

       
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

       
        Week3 d = new Week3(n);
        for (int i = 0; i < edges.size(); i++) {
            int from = edges.get(i)[1];
            int to = edges.get(i)[2];

          
            if (d.find_set(from) != d.find_set(to)) {

                
                d.union_sets(from, to);
                ans += edges.get(i)[0];
            }
        }

        
        System.out.println("The minimum cost is " + ans);
    }

   
    public static void main(String args[]) {

       
        int houses[][] = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 4, 4 }, { 5, 2 }, { 7, 0 } };
        int n = houses.length;

        // Function Call
        MST(houses, n);
    }
}