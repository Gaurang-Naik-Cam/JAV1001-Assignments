/* 
Course Name - JAV-1001 - 11354 - App Development for Android - 202301 - 001
Student name - Gaurang Naik
Student # A00250808
==============================================================================================
Program description - This program takes a number and its unit of measurement to convert. 
The program converts the number into appropriate units and diplay the details of the conversion.
=============================================================================================== 
*/

import kotlin.text.lowercase

fun main() {
    
    //we are taking the number as a first input from the user.
    println("Enter a numeric value: - ");
    
    //Storing the number in 'number' variable
    val number = readLine()!!.toDouble();
   

    // Here we are asking for the second input from the user amonst the possible measurement units that are within the scope
    //of this program.
    println("Enter a unit of measurement to convert. Select any one from the below - ");
    println("KM , MI, CM, IN, KG, LB, G, OZ");
    
    //storing it in the 'unitOfMeasurement' variable
    val unitOfMeasurement = readLine();

    //declaring the 'result' as a string variable to render the output 
    val result:String;

    //using the 'when' statement to differentiate the calculations
    when(unitOfMeasurement!!.lowercase()){

        "km" -> result = "$number ($unitOfMeasurement) equals to  $number * 0.62  = " + (number * 0.62) + " (mi)";
        "mi" -> result = "$number ($unitOfMeasurement) equals to  $number * 1.61 = " + (number * 1.61) + " (km)";
        "cm" -> result = "$number ($unitOfMeasurement) equals to  $number * 0.39 = " + (number * 0.39) + " (in)";
        "in" -> result = "$number ($unitOfMeasurement) equals to  $number * 2.54 = " + (number * 2.54) + " (cm)";
        "kg" -> result = "$number ($unitOfMeasurement) equals to  $number * 2.2 = " + (number * 2.2) + " (lb)";
        "lb" -> result = "$number ($unitOfMeasurement) equals to  $number * 0.45 = " + (number * 0.45) + " (kg)" ;
        "g" -> result = "$number ($unitOfMeasurement) equals to  $number * 0.04 = " + (number * 0.04) + " (oz)";
        "oz" -> result = "$number ($unitOfMeasurement) equals to  $number * 28.35 = " + (number * 28.35) + " (g)";
       
        // returning the default result if we do not find a match
        else -> result = "Unable to process the request. Please try again."
    }

    //printing the final output
    println(result);
}