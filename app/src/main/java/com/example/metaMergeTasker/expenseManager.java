package com.example.metaMergeTasker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class expenseManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_manager_screen);
    }

    // Adam - Relocated this to top of file.... needs to be declaired before we extended it...
    public class expense {
        //instance variables
        private String expenseName;
        private int weeklyCostOfExpense;
        private double monthlyCostOfExpense, totalCostOfAllExpenses;

        //constructor
        public expense(String expenseName, int weeklyCostOfExpense, double monthlyCostOfExpense, double totalCostOfAllExpenses) {
            this.expenseName = expenseName;
            this.weeklyCostOfExpense = weeklyCostOfExpense;
            this.monthlyCostOfExpense = monthlyCostOfExpense;
            this.totalCostOfAllExpenses = totalCostOfAllExpenses;
        }

        //accessors
        public String getExpenseName()
        {
            return expenseName;
        }

        public int getWeeklyCostOfExpense()
        {
            return weeklyCostOfExpense;
        }

        public double getMonthlyCostOfExpense()
        {
            return monthlyCostOfExpense;
        }

        public double getTotalCostOfAllExpenses()
        {
            return totalCostOfAllExpenses;
        }

        public void printExpenseDetails() {
            System.out.printf("\n%-10s%s\n", "Expense Name:", expenseName);
            System.out.printf("\n%-10s%s\n", "Weekly Cost of Expense: $", weeklyCostOfExpense);
            System.out.printf("\n%-10s%s\n", "Monthly Cost of Expense: $", monthlyCostOfExpense);
        }
    }

    public class expensemanager extends expense {

        public expense[] personalExpenses = new expense[10];
        int numberOfExpenses = 0;
        int total;
        Double[] myArray = new Double[]{};
        List<Double> myArrayList = new ArrayList<Double>(Arrays.asList(myArray));

        //constructor
        public expensemanager(String expenseName, int weeklyCostOfExpense,
                              double monthlyCostOfExpense, double totalCostOfAllExpenses) {
            super(expenseName, weeklyCostOfExpense, monthlyCostOfExpense,
                    totalCostOfAllExpenses);
        }

        public void expenses() {
            Scanner sc = new Scanner(System.in);
            String expenseName, answer;
            int weeklyCostOfExpense;
            double monthlyCostOfExpense, totalCostOfAllExpenses;
            expense b;

            do {
                System.out.println("\nEnter the name of your expense, eg Netflix: ");
                expenseName = sc.nextLine();

                System.out.println("\nEnter the weekly cost of the expense: ");
                weeklyCostOfExpense = sc.nextInt();

                monthlyCostOfExpense = weeklyCostOfExpense * 4;
                System.out.println("The total cost of " + expenseName + " per month is " + monthlyCostOfExpense);
                double m = monthlyCostOfExpense;
                myArrayList.add(m);


                totalCostOfAllExpenses = monthlyCostOfExpense;

                b = new expense(expenseName, weeklyCostOfExpense, monthlyCostOfExpense, totalCostOfAllExpenses);

                if (numberOfExpenses == personalExpenses.length) {
                    System.out.println("ERROR, array is full. Unable to add more expenses");
                } else {
                    personalExpenses[numberOfExpenses] = b;
                    numberOfExpenses++;
                }

                System.out.println("Do you wish to continue (Y/N)? ");
                sc.nextLine();
                answer = sc.nextLine();

            } while (answer.equalsIgnoreCase("Y"));

            for (int i = 0; i < numberOfExpenses; i++) {
                personalExpenses[i].printExpenseDetails();
            }
        }

        public void printDetails() {
            for (int i = 0; i < numberOfExpenses; i++) {
                personalExpenses[i].printExpenseDetails();
            }
        }

        public void calcTotalMonthlyCost() {
            for (int j = 0; j < myArrayList.size(); j++) {
                total += myArrayList.get(j);
            }
            System.out.println("Total monthly expense of all expenses is equal to: $" + total);
        }
    } // Adam - Missing Brace ;-)

}