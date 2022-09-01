package GPA_Action;
import java.util.*;


public class GPA {

   public int point_confirmation(String grad_ent){
        int point;
        /*
         *This method performs a specific function which is to convert
         * our grades to the necessary
         * points.
         * it's more like rule never changes.
         */
        if(grad_ent.toUpperCase().equals("A")){
            return 4;
        }else if (grad_ent.toUpperCase().equals("B")){
           return 3;
        }else if(grad_ent.toUpperCase().equals("C")){
            return 2;
        }else if(grad_ent.toUpperCase().equals("D")){
            return 1;
        }else if(grad_ent.toUpperCase().equals("F")){
            return 0;
        }else{
            System.out.println("You entered an unknown grade");
            System.exit(0);
            return 000;
        }
    }
    //just to reduce the worked done in the add method i made the determined by this method
   public void GPA_Calc_done(double result1,double result2){

        System.out.println("Total multiple of Grade and unit: "+result1);
        System.out.println("Total unit: "+result2);
        //division of your GP is done here.
        double gpa_out=(result1/result2);
        System.out.println(String.format("Your GPA: %.2f ",gpa_out));
        System.out.println(class_grading(gpa_out));

    }

    //heavy duty method.
    public void Add_Courses_grade_unit(int nun_of_courses_offered) {
        //i handled two possible errors that could arise from using this program
        try{
            Scanner ent=new Scanner(System.in);
            //Confirms number of course enter at main method
            System.out.println("Total course confirmed as "+nun_of_courses_offered);
            int[] multi_point_unit=new int[nun_of_courses_offered];
            double add_of_unit=0;
            double add_of_multi_point_unit=0;
            String[] grade=new String[nun_of_courses_offered];
            int[] unit=new int[nun_of_courses_offered];
            String[] course=new String[nun_of_courses_offered];
           //asks for courses based on the number of entered and stores them in arrays
        for(int i=0;i<nun_of_courses_offered;i++) {
            System.out.println("Enter course");
            course[i] = ent.next();
            System.out.println("\tEnter unit: ");
            unit[i] = ent.nextInt();
            System.out.println("\tEnter your grade: ");
            grade[i] = ent.next().toUpperCase();
            //Stores the multiple of unit and grade in array multi_point_unit
            //but before doing that our grades are first converted to points
            multi_point_unit[i]= point_confirmation(grade[i])*unit[i];
        }

           for(int x=0;x<unit.length;x++){
               /*
               this loop does the most it adds all entry of unit and multiple of grade and unit.
                */
               add_of_multi_point_unit=add_of_multi_point_unit+multi_point_unit[x];
               add_of_unit=add_of_unit+unit[x];
           }
          //courses,grades and units entered are displayed by this loop
            //Used a linear data structure for the program.
            System.out.println("courses Entered:");
            for (int r=0;r<nun_of_courses_offered;r++){
                System.out.println(course[r]+" "+grade[r].toUpperCase()+" "+unit[r]);
            }
            //Answers gotten are sent to the method for better display
           GPA_Calc_done(add_of_multi_point_unit,add_of_unit);


        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Maximum number of courses already!!! ");
        }catch(InputMismatchException e){
            System.out.println("input type was wrong.");
        }
    }
    public String class_grading(double gpa_gotten){
        //This method grades in different category based on their GPA
        if(gpa_gotten>=4.5){
            return "first class student\n"+"category A student";
        }else if(gpa_gotten>=3.5){
            return "second class student(Upper Division)\n"+"category B student";
        }else if(gpa_gotten>=2.4){
            return "second class student(Lower Division)\n"+"category C student";
        }else if(gpa_gotten>=1.5){
            return "Third class student\n"+"category D student";
        }else if(gpa_gotten>=1.00){
            return "pass\n"+"category F student";
        }else{
            return "Fail\n"+"category FF student";
        }

    }
    public static void main(String[] args){
        int nun_of_courses_offered;

        //initialized scanner class to receive our input
        Scanner scan=new Scanner(System.in);
        GPA calc=new GPA();
        System.out.println("Enter Total number of coursed offered: ");
        nun_of_courses_offered=scan.nextInt();
        //The reason for our output
        // recall add_Course_grade_unit was created to be reusable as much as you can.
        calc.Add_Courses_grade_unit(nun_of_courses_offered);

    }
}
