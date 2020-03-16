import java.util.List;
import java.util.Scanner;

public class ProteinBarsMain {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("******************************");
            System.out.println("Welcome to Bars Information ");
            System.out.println("******************************");

            // Provide options to user to choose
            System.out.println("Pick an option:");
            System.out.println("(1) Show the name of all bars");
            System.out.println("(2) Sort bars based on highest protein content");
            System.out.println("(3) Sort bars based on highest fat content");
            System.out.println("(4) Filter bars which has less than the user input value for fiber and sort them from highest to lowest");

            // get the option as an int
            int option=0;
            try{
                option = scanner.nextInt();
            } catch(Exception e) {
                System.out.println("Please enter only given options");
            }

            System.out.println("The user have selected option:" + option);

            ProteinBarsReader proteinBarsReader = new ProteinBarsReader();
            List<BarDataModel> barsInformation = proteinBarsReader.getBarsInformation();
            switch (option) {
                case 1:
                    System.out.println("Show the name of all bars");
                    proteinBarsReader.getBarsName(barsInformation);
                    break;
                case 2:
                    System.out.println("Sort bars based on highest protein content");
                    proteinBarsReader.sortByContent(barsInformation,"protein");
                    break;
                case 3:
                    System.out.println("Sort bars based on highest fatt content");
                    proteinBarsReader.sortByContent(barsInformation,"fatt");
                    break;
                case 4:
                    System.out.println("Please enter Fiber value:");
                    double fiberValue = scanner.nextDouble();
                    System.out.println(fiberValue);
                    // Write a function to get Fiber
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
