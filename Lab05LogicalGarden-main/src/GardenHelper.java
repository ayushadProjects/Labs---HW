public class GardenHelper {
    private final GardenView view = new GardenView();

    GardenPlant daisy, carrot, rose, swissChard, begonia;
    GardenRow one, two, three;

    public void go() {
        view.printMenu();
        String action = view.getAction();
        while(!action.startsWith("n")) {
            if(action.startsWith("a")) {
                int row = view.getRow();
                int pH = Integer.parseInt(view.input("What is the pH of the row? "));
                String light = view.input("What is the sun coverage of the row? (full sun, partial sun, any) ");
                addRow(row, pH, light);
            }
            else if(action.startsWith("p")) {
                String plantName = view.input("What plant would you like to plant? (daisy, carrot, rose, swiss chard, begonia): ");
                int row = view.getRow();
                addPlant(plantName, row);
            }
            System.out.println("What would you like to do? ");
            action = view.getAction();
        }
    }
    /*
       BRAINSTORM FOR ADDROW() HERE
       The method will initialize a garden row by getting the specific row to be inatilized, the pH
       of the row, and the light level of the row as parameters from the user. If the addition was successful,
       a true will be returned while a false will be returned if the program was unsuccessful.
       
       Psuedocode:
       1. Initialize row by taking the first parameter and creating a new object
       2. Have to check if row is one, two , or three
            2.1. If not, return false
       3. Assign pH parameter as the pH value to be stored for the row
            3.1. If lower than 0 or higher than 14, return false
       4. Assign light parameter as the light valule to be stored for the row
       5. If the abpve steps pass, then return true
     */
    public boolean addRow(int row, int pH, String light) {
        if (row > 3) {
            return false;
        }
        GardenRow rowNum = searchRow(row);
        rowNum = new GardenRow(light, pH);
        return true;
    }
    /*
        DESCRIPTION OF ADDPLANT() HERE
        The addPlant method will check if, out of the five types of plants, a plant can be planted
        in a row that is passed in as a parameter to the canPlant method, which is the next method 
        in the program. If the returned boolean is true, then the method will add that plant to the 
        row after getting the row object and plant type from helper methods. After this, a message
        will be displayed that the plant was added to the row and return true. On the other hand, if
        the canPlant method returns a false, the plant is not added to the row, and instead returns
        a message saying the plant cannot be added.
     */
    public boolean addPlant(String plantName, int row) {
        if(canPlant(plantName, searchRow(row))){
            searchRow(row).setPlant(searchPlant(plantName));
            System.out.println(plantName.toUpperCase() + " added to row " + row + "!");
            return true;
        }
        else{
            System.out.println(plantName.toUpperCase() + " was unable to be planted.");
            return false;
        }
    }

   public boolean canPlant(String plantName, GardenRow row){
        GardenPlant plant = searchPlant(plantName);
         if (plant == null || row == null) return false;
         boolean goodSun = row.getLight().equals(plant.getAmountOfSunshine())
                     || plant.getAmountOfSunshine().equals("any");
         boolean correctPH = (plant.getpHLow() <= row.getPH()) && 
                       (row.getPH() <= plant.getpHHigh());


   // This next part is a very *robust* version
   // and you will notice more drawn out, so you can see the steps I took 
         GardenRow otherA = null, otherB = null;
         if (row.equals(one)) {
              otherA = two;
              otherB = three;
         } else if (row.equals(two)) {
               otherA = one;
               otherB = three;
          } else if (row.equals(three)) {
              otherA = one;
              otherB = two;
         }

         boolean rowCheck = plant.getType().equals("VEG") ||
                  otherA == null || otherB == null ||  // the other rows are empty
                  (otherA != null && otherA.getPlant() == null) || // the rows exist but no plants
                  (otherB != null && otherB.getPlant() == null) ||
                  (otherA != null && otherA.getPlant() != null && otherA.getPlant().getType().equals("VEG"))||
                  (otherB != null && otherB.getPlant() != null && otherB.getPlant().getType().equals("VEG"));
        
         return goodSun && correctPH && rowCheck;
}


    public void buildOptions() {
        daisy = new GardenPlant("daisy", 6, 8, "any", "FLOWER");
        carrot = new GardenPlant("carrot", 6, 7, "full sun", "VEG");
        rose = new GardenPlant("rose", 6, 7, "full sun", "FLOWER");
        swissChard = new GardenPlant("swiss chard", 6, 7, "partial sun", "VEG");
        begonia = new GardenPlant("begonia", 5, 6, "partial sun", "FLOWER");
    }


    public GardenPlant searchPlant(String plantName){
        if(plantName.equals(daisy.getName())){
            return daisy;
        }
        else if(plantName.equals(carrot.getName())){
            return carrot;
        }
        else if(plantName.equals(rose.getName())){
            return rose;
        }
        else if(plantName.equals(swissChard.getName())){
            return swissChard;
        }
        else{
            return begonia;
        }
    }


    public GardenRow searchRow(int row){
        if(row == 1){
            return one;
        }
        else if(row == 2){
            return two;
        }
        else{
            return three;
        }

    }


    public static void main(String[] args) {
        GardenHelper gardenHelperObj = new GardenHelper();
        gardenHelperObj.buildOptions();
        //Test 1 for addRow():
        System.out.println("Testing addRow(4, 6, any):");
        System.out.println("EXPECTING: false");
        System.out.println("ACTUAL   : " + gardenHelperObj.addRow(4, 6, "any"));
        System.out.println();

        //Test 2 for addRow():
        System.out.println("Testing addRow(2, 6, any):");
        System.out.println("EXPECTING: true");
        System.out.println("ACTUAL   : " + gardenHelperObj.addRow(2, 6, "any"));
        System.out.println();

        //Test 1 for canPlant():
        gardenHelperObj.addRow(2, 6, "full sun");
        System.out.println("Testing canPlant(carrot, 2):");
        System.out.println("EXPECTING: true");
        System.out.println("ACTUAL   : " + gardenHelperObj.addPlant("carrot", 2));
        System.out.println();

        //Test 2 for canPlant():
        gardenHelperObj.addRow(1, 2, "full sun");
        System.out.println("Testing canPlant(carrot, 2):");
        System.out.println("EXPECTING: false");
        System.out.println("ACTUAL   : " + gardenHelperObj.addPlant("carrot", 1));
        System.out.println();

    }

}
