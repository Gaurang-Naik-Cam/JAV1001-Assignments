/* 
Course Name - JAV-1001 - 11354 - App Development for Android - 202301 - 001
Student name - Gaurang Naik
Student # A00250808
==============================================================================================
Lab 3  Classes/Objects
=============================================================================================== 
*/
// Create different sized dice using each constructor
// Roll the dice and display their results (before and after)
// Choose one Die object and set it to show it's highest value
// Create 5 six-sided dice. Roll each Die in a loop until you get 5 of a kind. Count and display the number of rolls.

package com.assignment3
import com.assignment3.Die

// function to print dice status
fun print_dice_status(diceName:String, status:String, side:Int) {

     println("$diceName :-> $status roll, The side was $side");
}


// function to get highest dice. we can use as many dice objects as we want with this function.
fun get_highest(dices:Array<Die>):Die {
     
     var highestDie:Die = Die(1);
     
     for (i in dices.indices) {

          if(highestDie.currentSideUp <= dices[i].currentSideUp)
               highestDie = dices[i];
          else 
               continue;
          }     
     return highestDie;
}


fun main() {

     //Default constructor
     val dice1 = Die();
     print_dice_status("dice1", "before", dice1.currentSideUp);
     dice1.Roll();
     print_dice_status("dice1", "after", dice1.currentSideUp);

     //second constructor
     val dice2 = Die(5);
     print_dice_status("dice2", "before", dice2.currentSideUp);
     dice2.Roll();
     print_dice_status("dice2", "after", dice2.currentSideUp);

     //third constructor
     val dice3 = Die(6,"Black");
     print_dice_status("dice3", "before", dice3.currentSideUp);
     dice3.Roll();
     print_dice_status("dice3", "after", dice3.currentSideUp);

     // ====== Finding the highest value ==========

     println("\nRolling again to find the highest side up");
     dice1.Roll();
     print_dice_status("dice1", "after", dice1.currentSideUp);
     dice2.Roll();
     print_dice_status("dice2", "after", dice2.currentSideUp);
     dice3.Roll();
     print_dice_status("dice3", "after", dice3.currentSideUp);

     var currentDices : Array<Die> = arrayOf(dice1, dice2, dice3);
     var highest = get_highest(currentDices);
     println("\nHighest type dice is : "+ highest.type);
     println("it's highest side is : "+ highest.currentSideUp+"\n");

     //========= End of highest value procedure =========

     //========= Five of a kind excercise ==============

          //declaring 5 six sided dice

      var dice_first:Die = Die(6,"Black");
      var dice_second:Die = Die(6,"White");
      var dice_third:Die = Die(6,"Yellow");
      var dice_fourth:Die = Die(6,"Red");
      var dice_fifth:Die = Die(6,"Green");
      var roll_attempt:Int = 0;
      

      do{
          
          dice_first.Roll();
          dice_second.Roll();
          dice_third.Roll();
          dice_fourth.Roll();
          dice_fifth.Roll();
          roll_attempt ++;
          println(" \n=== Roll attempt : $roll_attempt ===\n");
          println("First dice : "+dice_first.currentSideUp);
          println("Second dice : "+dice_second.currentSideUp);
          println("Third dice : "+dice_third.currentSideUp);
          println("Fourth dice : "+dice_fourth.currentSideUp);
          println("Fifth dice : "+dice_fifth.currentSideUp);


      } while(!(dice_first.currentSideUp == dice_second.currentSideUp && dice_second.currentSideUp == dice_third.currentSideUp && 
              dice_third.currentSideUp == dice_fourth.currentSideUp && dice_fourth.currentSideUp == dice_fifth.currentSideUp))
      

     //========= End of Five of a kind excercise ===========

}

