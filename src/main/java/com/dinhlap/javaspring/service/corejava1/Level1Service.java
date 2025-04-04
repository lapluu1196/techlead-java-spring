package com.dinhlap.javaspring.service.corejava1;

public interface Level1Service {
/** Write a program that takes two numbers as inputs and displays their sum.*/
    int sum(int a, int b);
    
/** Write a program that takes a string as input and displays the length of the string.*/
    int length(String s);
    
/** Write a program that takes a number as input and displays its square. ( Tính bình phương )*/
    int square(int a);

/** Write a program that takes a list of numbers as input and displays the largest number in the list.*/
    int max(int[] arr);
    
/** Write a program that takes a list of strings as input and displays the shortest string in the list.*/
    String shortest(String[] arr);
    
/** Write a program that takes a list of numbers as input and sorts the list in ascending order.*/
    int[] sort(int[] arr);
    
/** Write a program that takes a list of strings as input and sorts the list in alphabetical order.*/
    String[] sort(String[] arr);
    
/** Write a program that takes a list of numbers as input and returns the median of the numbers.
    ( Tìm số trung vị ( số trung vị không phải số trung bình cộng ))*/
    double median(int[] arr);
    
/** Write a program that takes a string as input and returns the number of words in the string.
    ( tìm số từ trong một chuỗi, VD: “Hello world" => 2 )*/
    int countWords(String s);
    
/** Write a program that takes a list of strings as input and returns the number of strings that contain the letter 'a'.*/
    int countA(String[] arr);
}
