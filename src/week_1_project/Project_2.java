package week_1_project;

import java.util.ArrayList;
import java.util.Scanner;

public class Project_2 {
  public static Scanner ip = new Scanner(System.in);
  
  static ArrayList<String> History = new ArrayList<>();
  
  public static void main(String[] args) {
    int choice = 0;
    while (true) {
      System.out.println("\n\tEnter your choice");
      System.out.println("1. Length");
      System.out.println("2. Temperature");
      System.out.println("3. Weight");
      System.out.println("4. History");
      System.out.println("5. Exit\n");
      try {
        choice = Integer.parseInt(ip.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a number between 1 and 5.");
        continue;
      } 
      switch (choice) {
        case 1:
          length();
          continue;
        case 2:
          weight();
          continue;
        case 3:
          weight();
          continue;
        case 4:
          System.out.println("\tHistory");
          showHistory();
          continue;
        case 5:
          return;
      } 
      System.out.println("Choice should between 1 to 5");
    } 
  }
  
  public static void length() {
    int choice = 0;
    double d = 0.0D;
    double val = 0.0D;
    while (true) {
      System.out.println("\n\tEnter your choice");
      System.out.println("1. Inch to Meter");
      System.out.println("2. Inch to Yard");
      System.out.println("3. Meter to Inch");
      System.out.println("4. Meter to Yard");
      System.out.println("5. Yard to Inch");
      System.out.println("6. Yard to Meter");
      System.out.println("7. Other type of Conversion\n");
      try {
        choice = Integer.parseInt(ip.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a number between 1 and 7.");
        continue;
      } 
      if (choice > 0 && choice < 7) {
        System.out.print("Enter the value  ");
        try {
          d = ip.nextDouble();
          ip.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid value! Please enter a numeric value.");
          ip.nextLine();
          continue;
        } 
      } 
      switch (choice) {
        case 1:
          val = d / 39.3701D;
          System.out.println("The value of " + d + " in Inches = " + val + " Meters");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Inches = " + val + " Meters");
          continue;
        case 2:
          val = d / 36.0D;
          System.out.println("The value of " + d + " in Inches = " + val + " Yard");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Inches = " + val + " Yard");
          continue;
        case 3:
          val = d * 39.3701D;
          System.out.println("The value of " + d + " in Meters = " + val + " Inches");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Meters = " + val + " Inches");
          continue;
        case 4:
          val = d * 1.094D;
          System.out.println("The value of " + d + " in Meters = " + val + " Yard");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Meters = " + val + " Yard");
          continue;
        case 5:
          val = d * 39.0D;
          System.out.println("The value of " + d + " in Meters = " + val + " Yard");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Meters = " + val + " Yard");
          continue;
        case 6:
          val = d * 36.0D;
          System.out.println("The value of " + d + " in Yards = " + val + " Inches");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Yards = " + val + " Inches");
          continue;
        case 7:
          return;
      } 
      System.out.println("Choice should between 1 to 7");
    } 
  }
  
  public static void weight() {
    int choice = 0;
    double d = 0.0D;
    double val = 0.0D;
    while (true) {
      System.out.println("\n\tEnter your choice");
      System.out.println("1. Kilo Gram to Pound");
      System.out.println("2. Pound to Kilo Gram");
      System.out.println("3. Other type of Conversion\n");
      try {
        choice = Integer.parseInt(ip.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a number between 1 and 3.");
        continue;
      } 
      if (choice > 0 && choice < 3) {
        System.out.print("Enter the value  ");
        try {
          d = ip.nextDouble();
          ip.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid value! Please enter a numeric value.");
          ip.nextLine();
          continue;
        } 
      } 
      switch (choice) {
        case 1:
          val = d * 2.205D;
          System.out.println("The value of " + d + " in Kilo Grams = " + val + " Pounds");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Kilo Grams = " + val + " Pounds");
          continue;
        case 2:
          val = d / 2.205D;
          System.out.println("The value of " + d + " in Kilo Grams = " + val + " Pounds");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Kilo Grams = " + val + " Pounds");
          continue;
        case 3:
          return;
      } 
      System.out.println("Choice should between 1 to 3");
    } 
  }
  
  public static void temperature() {
    int choice = 0;
    double d = 0.0D;
    double val = 0.0D;
    while (true) {
      System.out.println("\n\tEnter your choice");
      System.out.println("1. Celsius to Fahrenheit");
      System.out.println("2. Fahrenheit to Celsius");
      System.out.println("3. Other type of Conversion\n");
      try {
        choice = Integer.parseInt(ip.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a number between 1 and 3.");
        continue;
      } 
      if (choice > 0 && choice < 3) {
        System.out.print("Enter the value  ");
        try {
          d = ip.nextDouble();
          ip.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid value! Please enter a numeric value.");
          ip.nextLine();
          continue;
        } 
      } 
      switch (choice) {
        case 1:
          val = d * 1.8D + 32.0D;
          System.out.println("The value of " + d + " in Celsius = " + val + " Fahrenheit");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Celsius = " + val + " Fahrenheit");
          continue;
        case 2:
          val = (d - 32.0D) * 5.0D / 9.0D;
          System.out.println("The value of " + d + " in Fahrenheit = " + val + " Celsius");
          System.out.println("+============================================+");
          addToHistory("The value of " + d + " in Fahrenheit = " + val + " Celsius");
          continue;
        case 3:
          return;
      } 
      System.out.println("Choice should between 1 to 3");
    } 
  }
  
  private static void addToHistory(String conversion) {
    History.add(conversion);
  }
  
  private static void showHistory() {
    if (History.isEmpty()) {
      System.out.println("No conversion history available.");
    } else {
      System.out.println("\nConversion History:");
      for (String record : History)
        System.out.println(record); 
    } 
  }
}
