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
    
 // println(Ceaser_cipher("GaurangNaik","Kotlin"))

 /* 

 val x = arrayOf<Int>(1, 5, 7, 10, 12, 7)
if(7 == arrayAvg(x))
   println("Pass");
else
println("Fail");  
*/

//val arr = arrayOf<String>("Gaurang", "Kolin", "Naik", "Rex")

//println(arrayContains(arr,"Naik").toString());
val x = arrayOf<Int>(1, 5, 7, 10, 12, 7)
reverse(x);
//reverseArray(x)

}

fun Ceaser_cipher(text:String, shiftValue:String) :String {

   var output : String = ""

   for(i in text){
      
      for(j in shiftValue){
         output += (j +""+ i).toString()         
      }
   }
   return output.uppercase()
}

fun arrayAvg(inputArray:Array<Int>) :Int {

   //println(inputArray.count());
   var sum:Int =0;
   for(i in inputArray.indices)
   {
      sum += inputArray[i];
   }

   println(sum/inputArray.count());
   return sum/inputArray.count();   
}

fun arrayContains(inputStringArray:Array<String>, searchText:String) :Boolean {
   var found:Boolean = false
   
   for(i in inputStringArray.indices){
      
      if(inputStringArray[i] == searchText){
         found = true;
         break;
      }
   }
   return found;
}

fun reverse(inputIntArray:Array<Int>) : Array<Int>  {

   var output = Array(inputIntArray.size){0}
   var index :Int = 0;
  // println(inputIntArray.size)
  // println(inputIntArray.count())
   

  // for(i in inputIntArray.indices){
   for(i in inputIntArray.size downTo 1){
     // println(i.toString() + " " + index.toString());//print(index);
      //println(inputIntArray.get(i));
      output.set(index,inputIntArray.get(i-1)) // = inputIntArray[i];
     // output[inputIntArray.size - 1 - i] = inputIntArray[i];   
     index++;
   }
   for(i in output.indices){
      println(output[i]);
   }
   return output;

}

fun reverseArray(array: Array<Int>): Array<Int> {
   val result = Array(array.size) {0}
   for (i in array.indices) {
       result[array.size - 1 - i] = array[i]
   }
   print(result.indices);
   return result
}
