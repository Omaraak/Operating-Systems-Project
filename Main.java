import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends Process{
 
    public static void main(String[] args) {

        Process[] processes = new Process[8];
        
        try {
            File file = new File("C:\\Users\\Omar\\Desktop\\CS-222 Project\\Processes.txt");
            Scanner scanner = new Scanner(file);

            scanner.nextLine();
            int counter=0;
            while(scanner.hasNextLine()){
                processes[counter] = new Process();
                processes[counter].setPid(scanner.nextInt());
                processes[counter].setPrior(scanner.nextInt());
                processes[counter].setAT(scanner.nextInt());
                processes[counter].setBT(scanner.nextInt());
                counter++;
            }
            scanner.close();
        } 

        catch (Exception e) {
            System.out.println("There is a Problem !!");
            return;
        }

        
        //FCFS
        System.out.println("\n1-  scheduling algorithm: FCFS\n");
        System.out.println("Process\t\tBT\t\tWT\t\tTAT");

        Arrays.sort(processes);
        int wt_f = 0;
        for(int i = 0 ; i<=processes.length-1 ; ++i) {
            processes[i].setWt(wt_f);
            processes[i].setTat(processes[i].getWt()+processes[i].getBT());
            System.out.println(processes[i].getPid() + "\t\t" + processes[i].getBT() + "\t\t" + processes[i].getWt() + "\t\t" + processes[i].getTat());
            wt_f+=processes[i].getBT();
        }
        int averageWt_f = 0;
        int averageTat_f = 0;
        for(int i = 0 ; i<=processes.length-1 ; ++i){
            averageWt_f+=processes[i].getWt();
            averageTat_f+=processes[i].getTat();
        }

        
        System.out.println("\nAverage waiting time = "+averageWt_f+" / "+processes.length+" = "+(averageWt_f/processes.length));
        System.out.println("Average turnaround time = "+averageTat_f+" / "+processes.length+" = "+(averageTat_f/processes.length));


        //Priority
        System.out.println("\n\n2-  scheduling algorithm: Priority\n");
        System.out.println("Process\t\tPrior\t\tBT\t\tWT\t\tTAT");
        int wt_p = 0;
        for(int i = 0 ; i<=processes.length-1 ; ++i) {
            processes[i].setWt(wt_p);
            processes[i].setTat(processes[i].getWt()+processes[i].getBT());
            System.out.println(processes[i].getPid() + "\t\t" + processes[i].getPrior() + "\t\t" + processes[i].getBT() + "\t\t" + processes[i].getWt() + "\t\t" + processes[i].getTat());
            wt_p+=processes[i].getBT();
        }
        int averageWt_p = 0;
        int averageTat_p = 0;
        for(int i = 0 ; i<=processes.length-1 ; ++i){
            averageWt_p+=processes[i].getWt();
            averageTat_p+=processes[i].getTat();
        }
        System.out.println("\nAverage waiting time = "+averageWt_p+" / "+processes.length+" = "+(averageWt_p/processes.length));
        System.out.println("Average turnaround time = "+averageTat_p+" / "+processes.length+" = "+(averageTat_p/processes.length)+"\n");
    }
}
