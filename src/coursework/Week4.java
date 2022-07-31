package coursework;

public class Week4 {
    
    private static void sortArray(int array[]) {
        
        for (int i = 1; i < array.length; i++) {
            int j = i; 
            int a = array[i]; 
            while ((j > 0) && (array[j - 1] > a)) 
            {
                array[j] = array[j - 1]; 
                j--;
            }
            array[j] = a; 
        }
    }

    public static void TotalContainer(int array[]){
        int i; 
        int totalContainers = 0; 

      
        sortArray(array);

        int prevValue = 0; 
        int containerForCurrentVillage = 0; 

       
        for (i = 0; i < array.length; i++) {
            
            if (array[i] != prevValue) {
                prevValue = array[i];
                containerForCurrentVillage += 1;
                totalContainers += containerForCurrentVillage;
            }
           
             else {
                prevValue = array[i];
                totalContainers += containerForCurrentVillage;
            }
        }

        
        System.out.println(totalContainers);
    }
  
    public static void main(String[] args) {
       
        int array[] = { 5, 2, 2, 2, 4, 6 };

        TotalContainer(array);//calling the function to find the number of containers needed for each village
    }   
}
