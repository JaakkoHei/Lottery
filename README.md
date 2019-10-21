# Lottery
Description:
  Lottery contains a java program that simulates a 7 number lottery between numbers [1,40].
  The simulation runs until all numbers match within 120 years. One lottery takes a week.

Instructions:
  Compile and run the LottoApp.java file. When issuing the run command with command line
  you can choose to enter you lottery numbers in the command. (7 numbers and they have to be unique and between [1,40])
  Example: "LottoApp.java 1 2 3 4 5 6 7" 
  If you dont enter numbers in the command, the program will ask you to input the numbers.
  After the numbers have been accepted the program will ask if you want see the weekly lottery results.
  You can enter "y" to see the results or enter any character to hide them.
  After this the program will run and after all the numbers match it shows you how many years it took
  to get 1-7 matching numbers. The program will loop until all 7 match in under 120 years.
  
  You can change the amount of lottery numbers(static int numberCount = 7)
  and the random numbers(static int min = 1 and static int max = 40)
  in the LottoApp.java file under LottoApp Class.
