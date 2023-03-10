import java.io.IOException;
import java.util.ArrayList;

public class StatePopulations {
   public static void main(String[] args) throws IOException { // Scanner object
      int myZipCode = 21044;
      int i;
      String stateAbb = "";
      String stateName = "";

      // ZIP code - state abbrev. pairs
      ArrayList<StatePair<Integer, String>> zipCodeState = new ArrayList<StatePair<Integer, String>>();

      // state abbrev. - state name pairs
      ArrayList<StatePair<String, String>> abbrevState = new ArrayList<StatePair<String, String>>();

      // state name - population pairs
      ArrayList<StatePair<String, Integer>> statePopulation = new ArrayList<StatePair<String, Integer>>();

      StatePair<Integer, String> ZipPair = new StatePair<Integer, String>(21044, "MY");
      zipCodeState.add(ZipPair);

      StatePair<String, String> StatePair = new StatePair<String, String>("MY", "Maryland");
      abbrevState.add(StatePair);

      StatePair<String, Integer> PopulationPair = new StatePair<String, Integer>("Maryland", 6079620);
      statePopulation.add(PopulationPair);

      for (i = 0; i < zipCodeState.size(); ++i) {
         if (zipCodeState.get(i).getType1().compareTo(myZipCode) == 0) {
            stateAbb = zipCodeState.get(i).getType2();
            break;
         }
      }

      for (i = 0; i < abbrevState.size(); ++i) {
         if (abbrevState.get(i).getType1().compareTo(stateAbb) == 0) {
            stateName = abbrevState.get(i).getType2();
            break;
         }
      }

      for (i = 0; i < statePopulation.size(); ++i) {
         if (statePopulation.get(i).getType1().compareTo(stateName) == 0) {
            System.out.println(statePopulation.get(i).printInfo());
            break;
         }
      }
   }
}