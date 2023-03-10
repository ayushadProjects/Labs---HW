import java.util.ArrayList;

public class GroceryList {
    
    ArrayList<Grocery> grocList = new ArrayList<Grocery>();

    public ArrayList<Grocery> getGrocList() {
        return grocList;
    }

    public void addGrocery(Grocery groc) {
        grocList.add(groc);
    }

    /*
    * Student Self-Explanation:
    * The method is called after the user presses r. The program will then prompt the user to input which
    * item they want to remove from the list. The name of the product is passed to this method, which will
    * remove that product from the list if it is in the list.
    */
    public void removeGrocery(String grocName) {
        for(Grocery g: grocList) {
            if(g.getName().equals(grocName)) { //TODO Student
                grocList.remove(g);
                break;
            }
        }
    }
    //Create a for loop to loop through each element in the arraylist
    //Use the existing variable strList and add the toString of each element to that variable
    //Add a new line after each toString
    @Override
    public String toString() {
        String strList = "";
        for (Grocery g: grocList) {
            strList += g.toString() + "\n";
        }
        return strList;
    }
    //Create a for loop to iterate through each element in the arraylist
    //Check if the aisle in the parameter is in the arraylist by getting the aisle of each element
    //If the aisle exists, add the toString method of the class to the aisleString variable
    //Add a new line after the toString
    public String getAisleGroceries(int aisle) {
        String aisleString = "";
        for (Grocery g: grocList) {
            if (g.getAisle() == aisle) {
                aisleString += g.toString() + "\n";
            }
        }
        return aisleString;
    }

    public String getTotals() {
        double priceSum = 0;
        int caloriesSum = 0;
        for(Grocery g: grocList) {
            priceSum += g.getPrice();
            caloriesSum += g.getCalories();
        }
        String rtn = "The total price of this Grocery Trip: $" + priceSum + '\n';
        rtn += "The total calories of this Grocery Trip: " + caloriesSum + "cal\n";
        return rtn;
    }
}