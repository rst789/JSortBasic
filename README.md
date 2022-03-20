# Basic Sorting App Requirement

Problem:
--------
You are required to write a program that will automate the analysis of the performance of the three 
different sorting algorithms on an experimental set of data. The data is stored in a file called data.txt. 
Each line will contain a set of positive integers. 


Proposed Solution:
-----------------
The driver class for your solution will be a class called SortingApp. When run, your program should read 
and perform the analysis on each line of the experimental data. Processing the data will mean


- performing each of the three sorting algorithms in turn (bubble sort, insertion sort and selection 
sort)
- outputting the number of operations that it took for each algorithm
- the algorithm that performed the best
- Your output should be sent to the screen and formatted as shown in the sample output. 


Your driver should include the following 4 methods:
- insertionSort that takes an array of integers, and returns an integer
- selectionSort that takes an array of integers and returns an integer
- bubbleSort that takes an array of integers and returns an integer
- main that processes the data file one line at a time
