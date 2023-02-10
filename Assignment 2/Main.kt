/* 
Course Name - JAV-1001 - 11354 - App Development for Android - 202301 - 001
Student name - Gaurang Naik
Student # A00250808
==============================================================================================
Assignment 2
Program description - This program takes a number and its unit of measurement to convert. 
The program converts the number into appropriate units and diplay the details of the conversion.
=============================================================================================== 
*/

import kotlin.text.lowercase

fun main() {

   /* 1   === Ceaser_cipher example start ===   */
   println("\n\n/* === 1 Ceaser_cipher example start === */\n")
   
   //Taking user input for text
   println("Please enter text to encrypt: - ")
   
   //Storing the text in the variable
   val stringInput = readLine()!!
   
   //Taking user input for Shift value
   println("Please enter the Shift value: - ")
   
   //Storing the Shift value in the variable
   val stringShiftVal = readLine()!!
   
   //Calling my method to encrypt the given input and storing the output in 'encryptedString' variable
   val encryptedString = Ceaser_cipher(stringInput,stringShiftVal);
   
   //printing the output
   println("The encrypted value of given string is - $encryptedString")
   println("\n/*  ========== End =========  */")
   
   /*  ========== End =========  */

   /* 2 arrayAvg example start */
   println("\n\n/* === 2 arrayAvg example start === */\n")

   //As allowed and suggested in the question, using hard-coded array of 6 int values, averaging 7
   val x = arrayOf<Int>(1, 5, 7, 10, 12, 7)
   
   //Passing the value to my custom function to calculate the average of the values mentioned the array. Also Checking if output is correct.
   if(7 == arrayAvg(x))
      println("Passed the arrayAvg test.");
   else
      println("Failed the arrayAvg test.");

println("\n/*  ========== End =========  */")
/*  ========== End =========  */

/* === arrayContains example start === */
println("\n\n/* === 3 arrayContains example start === */\n")
//As allowed and suggested in the question, using hard-coded array of 4 string values
val arrayInput = arrayOf<String>("Gaurang", "Kotlin", "Naik", "Rex")

//Declaring value to be searched
val toBeSearched = "Kotlin"

//Passing this array and the value to be searched from the array in my custom function
val result:Boolean = arrayContains(arrayInput,toBeSearched)

//Printing the output True is value is found and False if value is not found.
if(result)
   println("arrayContains function test is passed.");
else
   println("arrayContains function test is failed.");

println("\n/*  ========== End =========  */")
/*  ========== End =========  */

/* === reverse example start === */
println("\n\n/* === 4 reverse example start === */\n")

//As allowed and suggested in the question, using hard-coded array of 6 int values.
val arrayInputForReverse = arrayOf<Int>(1, 5, 7, 10, 12, 7)

//declaring the desired output for the given test in array of int
val arrayResult = arrayOf<Int>(7, 12, 10, 7, 5, 1)

//Calling my custom function and returning an array
val arrayOutput = reverse(arrayInputForReverse);

//Checking each element if it reversed or not. Printing the value accordingly
for(i in arrayResult.indices){
      if(arrayResult[i]==arrayOutput[i])
         println("Reverse Test is passed for $i element.")
      else {
         println("Reverse Test is failed.")
         break;
      }
   }
   println("\n/*  ========== End =========  */")
}


fun Ceaser_cipher(text:String, shiftValue:String) :String {

   //declaring a blank output variable
   var output : String = ""

   //Loop 1  - looping through the each element in 'text'
   for(i in text){
      for(j in shiftValue){ //loop 2 - looping through each element of 'shiftValue'
         output += (j +""+ i).toString() // placing each element of 'shift value' recursively against every element of letter of 'text''
      }
   }

   //println(output.uppercase().replace(" ", ""))

   return output.uppercase().replace(" ", "") //converting the output in upper case and removing the spaces (if any)
}

fun arrayAvg(inputArray:Array<Int>) :Int {

  //declaring the sum variable
   var sum:Int =0;

   for(i in inputArray.indices)
   {
      sum += inputArray[i]; //looping through each element of 'inputArray' and summing it up.
   }

   //println(sum/inputArray.count())
   return sum/inputArray.count();   // calculating and returning the average.
}

fun arrayContains(inputStringArray:Array<String>, searchText:String) :Boolean {
   
   //declaring a 'found' variable as false
   var found:Boolean = false
   
   for(i in inputStringArray.indices){
      
      if(inputStringArray[i] == searchText){ //cheking if we find a match for each element in the array. 
         found = true;  //setting the 'found' variable to true
         break; // breaking the loop.
      }
   }
   return found;//returning the output.
}

fun reverse(inputIntArray:Array<Int>) : Array<Int>  {

   var output = Array(inputIntArray.size){0} //delcaring the output array and setting its size to the size of 'inputIntArray'
   var index :Int = 0; // declaring index as 0
  
   for(i in inputIntArray.size downTo 1){ // looping decrementally 
      output.set(index,inputIntArray.get(i-1))  //setting the value of 'output' array starting from last element of 'inputIntArray'
      index++; // incrementing the index with each iteration
   }

   // for(i in output.indices){
   //   println(output[i])
   // }
   
   return output;// returning the output
}