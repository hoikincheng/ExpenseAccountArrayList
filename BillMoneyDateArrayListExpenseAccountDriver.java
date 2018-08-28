import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 *  Driver for Money, Date, Bill, ArrayList, and ExpenseAccount classes. This 
 *  driver tests every public method in the Money, Date, and Bill, ArrayList, 
 *  and ExpenseAccount classes.
 * 
 * @author Hoi Kin Cheng.
 * @date 3/2/2017.
 */
public class BillMoneyDateArrayListExpenseAccountDriver {

    /**
    * This is the main method which calls methods to test the Money, Date, 
    * Bill classes, ArrayList, and ExpenseAccount classes.
    * 
    * @param args Unused.
    * @return Nothing.
    */
    public static void main(String[] args) {
        moneyTest();
        dateTest();
        billTest();
        arrayListTest();
        expenseAccountTest();
    }
    
    /**
    * This method tests all public methods inside the Money class and 
    * prints the results on the console.
    * 
    * @param Nothing.
    * @return Nothing.
    */
    public static void moneyTest() {
        System.out.println("moneyTest\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Money(int dol):\n");
        
        Money m1 = new Money(10);
        System.out.println("Constructing a legal Money m1: " + m1 + "\n");
        
        try {
            System.out.println
            ("Attempting to construct Money with -8 dollars...");
            Money test = new Money(-8);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Money(int dol, int cent):\n");
        
        Money m2 = new Money(10, 50);
        System.out.println("Constructing a legal Money m2: " + m2 + "\n");
        
        try {
            System.out.println
            ("Attempting to construct Money with 100 cents...");
            Money test = new Money(10, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to construct Money with -10 dollars");
            System.out.println("and 99 cents...");
            Money test = new Money(-10, 99);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to construct Money with -160 dollars");
            System.out.println("and -200 cents...");
            Money test = new Money(-160, -200);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Money(Money other):\n");
        
        Money m3 = new Money(14, 10);
        System.out.println("Constructing a legal Money m3: " + m3);
        Money m4 = new Money(m3);
        System.out.println
        ("Constructing a legal Money m4 that copies m3: " + m4 + "\n");
                
        try {
            System.out.println
            ("Attempting to copy from a null Money object...");
            Money test2 = new Money(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing clone():\n");
        
        Money m4A = new Money(108, 38);
        System.out.println("Constructing a legal Money m4A: " + m4A);
        
        Money m4B = m4A.clone();
        System.out.println("Cloning m4A to m4B: ");
        System.out.println("m4B is: " + m4B + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getDollars():");
        System.out.println("m1 has " + m1.getDollars() + " dollars.");
        System.out.println("m2 has " + m2.getDollars() + " dollars.");
        System.out.println("m3 has " + m3.getDollars() + " dollars.\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getCents():");
        System.out.println("m1 has " + m1.getCents() + " cents.");
        System.out.println("m2 has " + m2.getCents() + " cents.");
        System.out.println("m3 has " + m3.getCents() + " cents.\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getMoney():");
        System.out.println("m1 has " + m1.getMoney() + " dollars.");
        System.out.println("m2 has " + m2.getMoney() + " dollars.");
        System.out.println("m3 has " + m3.getMoney() + " dollars.");
        System.out.println("m4 has " + m4.getMoney() + " dollars.\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setDollars(int dol):\n");
        
        Money test1 = new Money(8, 27);
        System.out.println("Constructing a Money test1: " + test1);
        System.out.println("Setting test1's dollars to 4");
        test1.setDollars(4);
        System.out.println("test1 now has " + test1 + "\n");
        
        try {
            System.out.println
            ("Attempting to set -8 dollars...");
            test1.setDollars(-8);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setCents(int cen):\n");
        
        Money test2 = new Money(8, 27);
        System.out.println("Constructing a Money test2: " + test2);
        
        System.out.println("Setting test2's cents to 68");
        test2.setCents(68);
        System.out.println("test2 now has " + test2 + "\n");
        
        try {
            System.out.println
            ("Attempting to set -27 cents...");
            test2.setCents(-27);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set 106 cents...");
            test2.setCents(106);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set -100 cents...");
            test2.setCents(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setMoney(int dol, int cent):\n");
        
        Money m5 = new Money(5, 2);
        System.out.println("Constructing a legal Money m5: " + m5);
        System.out.println("Setting Money m5 to 64 dollars and 9 cents...");
        m5.setMoney(64, 9);
        System.out.println("Now m5 has " + m5 + "\n");
        
        try {
            System.out.println
            ("Attempting to set -100 dollars and 38 cents...");
            m5.setMoney(-100, 38);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set 100 dollars and -38 cents...");
            m5.setMoney(100, -38);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set 100 dollars and 100 cents...");
            m5.setMoney(100, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set -100 dollars and -100 cents...");
            m5.setMoney(-100, -100);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing add(int dol):\n");
        
        Money m6 = new Money(6, 12);
        System.out.println("Constructing a legal Money m6: " + m6);
        System.out.println("Adding 1920 dollars to Money m6...");
        m6.add(1920);
        System.out.println("Now m6 has " + m6 + "\n");
        
        try {
            System.out.println
            ("Attempting to add -1920 dollars to Money m6...");
            m6.add(-1920);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing add(int dol, int cents):\n");
        
        Money m7 = new Money(7, 14);
        System.out.println("Constructing a legal Money m7: " + m7);
        System.out.println("Adding 777 dollars and 14 cents to Money m7...");
        m7.add(777, 14);
        System.out.println("Now m7 has " + m7 + "\n");
        
        Money m8 = new Money(8, 80);
        System.out.println("Constructing a legal Money m8: " + m8);
        System.out.println("Adding 36 dollars and 20 cents to Money m8...");
        m8.add(36, 20);
        System.out.println("Now m8 has " + m8 + "\n");
        
        try {
            System.out.println
            ("Attempting to add -8 dollars and 99 cents to Money m8...");
            m8.add(-8, 99);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to add 8 dollars and -99 cents to Money m8...");
            m8.add(8, -99);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to add 8 dollars and 500 cents to Money m8...");
            m8.add(8, 500);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to add -8 dollars and -500 cents to Money m8...");
            m8.add(-8, -500);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing add(Money other):\n");
        
        Money m9 = new Money(9, 90);
        System.out.println("Constructing a legal Money m9: " + m9);
        Money m10 = new Money(10, 5);
        System.out.println("Constructing a legal Money m10: " + m10);
        System.out.println("Adding Money m10 to Money m9...");
        m9.add(m10);
        System.out.println("Now m9 has " + m9 + "\n");
        
        Money m11 = new Money(20, 99);
        System.out.println("Constructing a legal Money m11: " + m11);
        System.out.println("Adding Money m11 to Money m9...");
        m9.add(m11);
        System.out.println("Now m9 has " + m9 + "\n");
        
        try {
            System.out.println
            ("Attempting to add a null Money to Money m9...");
            m9.add(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing equals(Object o):\n");
        
        Money m12 = new Money(56, 89);
        System.out.println("Constructing a legal Money m12: " + m12 + "\n");
        
        Money m13 = m12.clone();
        System.out.println("Constructing a legal Money m13: " + m13);
        System.out.println("Is m12 equal to m13?  " + m12.equals(m13) + "\n");
        
        Money m14 = new Money(26, 89);
        System.out.println("Constructing a legal Money m14: " + m14);
        System.out.println("Is m12 equal to m14?  " + m12.equals(m14) + "\n");
        
        Money m15 = new Money(56, 99);
        System.out.println("Constructing a legal Money m15: " + m15);
        System.out.println("Is m12 equal to m15?  " + m12.equals(m15) + "\n");
        
        Money m16 = new Money(26, 99);
        System.out.println("Constructing a legal Money m16: " + m16);
        System.out.println("Is m12 equal to m16?  " + m12.equals(m16) + "\n");
        
        System.out.println
        ("Is m12 equal to a null Money?  " + m12.equals(null) + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing toString():\n");
        
        Money m17 = new Money(0, 10);
        System.out.println
        ("Constructing a legal Money m17 with 0 dollars and 10 cents:");
        System.out.println("m17's toString() is: " + m17.toString() + "\n");
        
        Money m18 = new Money(10, 1);
        System.out.println
        ("Constructing a legal Money m18 with 10 dollars and 1 cents:");
        System.out.println("m18's toString() is: " + m18.toString() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing compareTo(Object other):\n");
        
        Money m19 = new Money(58, 96);
        System.out.println("Constructing a legal Money m19: " + m19);
        
        Money m20 = m19.clone();
        System.out.println("Money m20 is a clone of m19: " + m20);
        
        Money m21 = new Money(58, 95);
        System.out.println("Constructing a legal Money m21: " + m21);
        
        Money m22 = new Money(58, 97);
        System.out.println("Constructing a legal Money m22: " + m22 + "\n");
        
        System.out.println("m19 compareTo m20 is: " + m19.compareTo(m20));
        System.out.println("m19 compareTo m21 is: " + m19.compareTo(m21));
        System.out.println
        ("m19 compareTo m22 is: " + m19.compareTo(m22) + "\n");
        
        try {
            System.out.println
            ("Attempting to compare a null to Money m19...");
            m19.compareTo(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to compare a non-Money to m19...");
            Integer i = new Integer(20);
            m19.compareTo(i);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
    }
    
    /**
    * This method tests all public methods inside the Date class and 
    * prints the results on the console.
    * 
    * @param Nothing.
    * @return Nothing.
    */
    public static void dateTest() {
        System.out.println("dateTest\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Date(int m, int d, int y):\n");
        
        Date d1 = new Date(8, 18, 2018);
        System.out.println("Constructing a legal Date d1: " + d1 + "\n");
        
        try {
            System.out.println
            ("Attempting to construct a Date of 13/18/2018...");
            Date test = new Date(13, 18, 2018);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to construct a Date of 8/0/2018...");
            Date test = new Date(8, 0, 2018);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to construct a Date of 8/18/2030...");
            Date test = new Date(8, 18, 2030);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to construct a Date of -8/0/-5...");
            Date test = new Date(-8, 0, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Date(int y):\n");
        
        Date d2 = new Date(2015);
        System.out.println("Constructing a legal Date d2: " + d2 + "\n");
        
        try {
            System.out.println
            ("Attempting to construct a Date with year 2500...");
            Date test = new Date(2500);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to construct a Date with year 0...");
            Date test = new Date(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Date(Date other):\n");
        
        Date d3 = new Date(5, 9, 2019);
        System.out.println("Constructing a legal Date d3: " + d3);
        Date d4 = new Date(d3);
        System.out.println
        ("Constructing a legal Date d4 that copies d3: " + d4 + "\n");
        
        try {
            System.out.println
            ("Attempting to construct a Date that copies null...");
            Date test = new Date(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getMonth():\n");
        System.out.println("The month of d1 is " + d1.getMonth());
        System.out.println("The month of d2 is " + d2.getMonth());
        System.out.println("The month of d3 is " + d3.getMonth() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getDay():\n");
        System.out.println("The day of d1 is " + d1.getDay());
        System.out.println("The day of d2 is " + d2.getDay());
        System.out.println("The day of d3 is " + d3.getDay() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getYear():\n");
        System.out.println("The year of d1 is " + d1.getYear());
        System.out.println("The year of d2 is " + d2.getYear());
        System.out.println("The year of d3 is " + d3.getYear() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setDate(int m, int d, int y):\n");
        
        Date sD1 = new Date(2, 29, 2016);
        System.out.println("Constructing a legal Date sD1: " + sD1 + "\n");
        
        try {
            System.out.println
            ("Attempting to set Date to 2/30/2016...");
            sD1.setDate(2, 30, 2016);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        sD1.setDate(4, 30, 2019);
        System.out.println("Setting Date to 4/30/2019: " + sD1 + "\n");
        
        try {
            System.out.println
            ("Attempting to set Date to 4/31/2019...");
            sD1.setDate(4, 31, 2019);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set Date to 2/29/2019...");
            sD1.setDate(2, 29, 2019);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setDate(int y):\n");
        
        Date d5 = new Date(2, 14, 2022);
        System.out.println("Constructing a legal Date d5: " + d5);
        System.out.println("Setting d5 to be 1/1/2014:");
        d5.setDate(2014);
        System.out.println("Now d5 is " + d5 + "\n");
        
        try {
            System.out.println
            ("Attempting to set a Date with year 2050...");
            d5.setDate(2050);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set a Date with year 2013...");
            d5.setDate(2013);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setMonth(int m):\n");
        
        Date d6 = new Date(5, 26, 2023);
        System.out.println("Constructing a legal Date d6: " + d6);
        System.out.println("Setting month of d6 to be 9:");
        d6.setMonth(9);
        System.out.println("Now d6 is " + d6 + "\n");
        
        try {
            System.out.println("Attempting to set the month to 0...");
            d6.setMonth(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println("Attempting to set the month to 13...");
            d6.setMonth(13);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setDay(int d):\n");
        
        Date d7 = new Date(11, 30, 2020);
        System.out.println("Constructing a legal Date d7: " + d7);
        System.out.println("Setting day of d7 to be 1:");
        d7.setDay(1);
        System.out.println("Now d7 is " + d7 + "\n");
        
        try {
            System.out.println("Attempting to set the day to 0...");
            d7.setDay(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set the day to 31 (month 11)...");
            d7.setDay(31);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println("Attempting to set the day to 32...");
            d7.setDay(32);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setYear(int y):\n");
        
        Date d8 = new Date(3, 12, 2017);
        System.out.println("Constructing a legal Date d8: " + d8);
        System.out.println("Setting year of d8 to be 2018:");
        d8.setYear(2018);
        System.out.println("Now d8 is " + d8 + "\n");
        
        try {
            System.out.println("Attempting to set the year to 2013...");
            d8.setYear(2013);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println("Attempting to set the year to 2025...");
            d8.setYear(2025);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing equals(Object o):\n");
        
        Date d9 = new Date(2, 18, 2017);
        System.out.println("Constructing a legal Date d9: " + d9 + "\n");
        
        Date d10 = new Date(d9);
        System.out.println("Constructing a legal Date d10: " + d10);
        System.out.println("Is d9 equal to d10?  " + d9.equals(d10) + "\n");
        
        Date d11 = new Date(3, 18, 2017);
        System.out.println("Constructing a legal Date d11: " + d11);
        System.out.println("Is d9 equal to d11?  " + d9.equals(d11) + "\n");
        
        Date d12 = new Date(2, 17, 2017);
        System.out.println("Constructing a legal Date d12: " + d12);
        System.out.println("Is d9 equal to d12?  " + d9.equals(d12) + "\n");
        
        Date d13 = new Date(2, 18, 2016);
        System.out.println("Constructing a legal Date d13: " + d13);
        System.out.println("Is d9 equal to d13?  " + d9.equals(d13) + "\n");
        
        Date d14 = new Date(5, 6, 2024);
        System.out.println("Constructing a legal Date d14: " + d14);
        System.out.println("Is d9 equal to d14?  " + d9.equals(d14) + "\n");
        
        System.out.println
        ("Is d9 equal to a null Date?  " + d9.equals(null) + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing toString():\n");
        
        Date d15 = new Date(9, 16, 2022);
        System.out.println
        ("Constructing a legal Date d15 with month 9, day 16, year 2022");
        System.out.println("d15's toString() is: " + d15.toString() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing precedes(Date otherDate):\n");
        
        Date d16 = new Date(7, 27, 2021);
        System.out.println("Constructing a legal Date d16: " + d16 + "\n");
        
        Date d17 = new Date(d16);
        System.out.println("Constructing a legal Date d17: " + d17);
        System.out.println
        ("Does d16 precede d17?  " + d16.precedes(d17));
        System.out.println
        ("Does d17 precede d16?  " + d17.precedes(d16) + "\n");
        
        Date d18 = new Date(7, 27, 2022);
        System.out.println("Constructing a legal Date d18: " + d18);
        System.out.println
        ("Does d16 precede d18?  " + d16.precedes(d18));
        System.out.println
        ("Does d18 precede d16?  " + d18.precedes(d16) + "\n");
        
        Date d19 = new Date(8, 27, 2021);
        System.out.println("Constructing a legal Date d19: " + d19);
        System.out.println
        ("Does d16 precede d19?  " + d16.precedes(d19));
        System.out.println
        ("Does d19 precede d16?  " + d19.precedes(d16) + "\n");
        
        Date d20 = new Date(7, 31, 2021);
        System.out.println("Constructing a legal Date d20: " + d20);
        System.out.println
        ("Does d16 precede d20?  " + d16.precedes(d20));
        System.out.println
        ("Does d20 precede d16?  " + d20.precedes(d16) + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing clone():\n");
        
        Date d21 = new Date(4, 28, 2016);
        System.out.println("Constructing a legal Date d21: " + d21);
        
        Date d22 = d21.clone();
        System.out.println("Cloning d21 to d22: ");
        System.out.println("d22 is: " + d22 + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing compareTo(Object other):\n");
        
        Date d23 = new Date(8, 15, 2018);
        System.out.println("Constructing a legal Date d23: " + d23);
        
        Date d24 = d23.clone();
        System.out.println("Date d24 is a clone of d23: " + d24);
        
        Date d25 = new Date(8, 16, 2018);
        System.out.println("Constructing a legal Date d25: " + d25);
        
        Date d26 = new Date(8, 14, 2018);
        System.out.println("Constructing a legal Date d26: " + d26 + "\n");
        
        System.out.println("d23 compareTo d24 is: " + d23.compareTo(d24));
        System.out.println("d23 compareTo d25 is: " + d23.compareTo(d25));
        System.out.println
        ("d23 compareTo m26 is: " + d23.compareTo(d26) + "\n");
        
        try {
            System.out.println
            ("Attempting to compare a null to Date d23...");
            d23.compareTo(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to compare a non-Date to d23...");
            Integer i = new Integer(20);
            d23.compareTo(i);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
    }
    
    /**
    * This method tests all public methods inside the Bill class and 
    * prints the results on the console.
    * 
    * @param args Nothing.
    * @return Nothing.
    */
    public static void billTest() {
        System.out.println("billTest\n");
        
        System.out.println("------------------------------------------");
        System.out.println
        ("Testing Bill(Money amount, Date dueDate, String originator):\n");
        
        Money mon1 = new Money(100, 99);
        Date due1 = new Date(9, 30, 2019);
        
        Bill b1 = new Bill(mon1, due1, "Utilities");
        System.out.println("Constructing a legal Bill b1: " + b1 + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Bill(Bill toCopy):\n");
        
        Bill b2 = new Bill
                (new Money(11, 8), new Date(1, 7, 2020), "Credit Card");
        System.out.println("Constructing a legal Bill b2: " + b2);
        Bill b3 = new Bill(b2);
        System.out.println
        ("Constructing a legal Date b3 that copies b2: " + b3 + "\n");
        
        b3.setPaid(new Date(1, 6, 2020));
        System.out.println
        ("Now setting b3's paid date to 1/6/2020: " + b3);
        Bill b4 = new Bill(b3);
        System.out.println
        ("Constructing a legal Date b4 that copies b3: " + b4 + "\n");
        
        try {
            System.out.println
            ("Attempting to construct a Bill that copies null...");
            Bill test = new Bill(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setUnpaid():\n");
        
        Bill b5 = new Bill
                (new Money(12, 80), new Date(9, 28, 2020), "Macy's");
        b5.setPaid(new Date(6, 30, 2020));
        System.out.println("Constructing a legal Bill b5: " + b5);
        b5.setUnpaid();
        System.out.println("b5 after being set to unpaid: " + b5);
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setDueDate(Date nextDate):\n");
        
        Bill b6 = new Bill
        (new Money(1000, 0), new Date(2, 29, 2020), "Peter Pan");
        System.out.println("Constructing a legal Bill b6: " + b6 + "\n");
        
        b6.setDueDate(new Date(3, 1, 2020));
        System.out.println("b6 after setting new due date: " + b6 + "\n");
        
        b6.setPaid(new Date(2, 28, 2020));
        System.out.println("Now b6 has a paid date at 2/28/2020: " + b6);
        b6.setDueDate(new Date(2, 29, 2020));
        System.out.println
        ("b6 after setting new due date at 2/29/2020: " + b6 + "\n");
        
        try {
            System.out.println
            ("Attempting to set new due date at 2/27/2020...");
            b6.setDueDate(new Date(2, 27, 2020));
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("Checking for privacy leak:");
        Date dTest = new Date(1, 1, 2021);
        System.out.println("Date dTest is " + dTest);
        Bill b7 = new Bill(new Money(5000, 50), dTest, "Snow White");
        System.out.println("Bill b7 using dTest is: " + b7);
        dTest.setDate(2, 1, 2021);
        System.out.println("Now dTest is set to " + dTest);
        System.out.println("Bill b7 is still: " + b7 + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setAmount(Money amount):\n");
        
        Money mon2 = new Money(600, 20);
        Bill b8 = new Bill
        (new Money(200, 6), new Date(8, 15, 2016), "Loan Shark");
        System.out.println("Constructing a legal Bill b8: " + b8);
        b8.setAmount(mon2);
        System.out.println
        ("After setting money to mon2 $600.20: " + b8 + "\n");
        
        System.out.println("Checking for privacy leak:");
        mon2.setMoney(400, 10);
        System.out.println("mon2 is now " + mon2);
        System.out.println
        ("After changing mon2, b8 is still: " + b8 + "\n");
        
        try {
            System.out.println
            ("Attempting to set amount to null...");
            b8.setAmount(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getAmount():\n");
        System.out.println("b8's amount is " + b8.getAmount() + "\n");
        
        System.out.println("Checking for privacy leak:");
        System.out.println("Saving b8's amount into Money get:");
        Money get = b8.getAmount();
        get.setMoney(1000, 10);
        System.out.println("Money get is changed to " + get);
        System.out.println
        ("After changing get, b8 is still: " + b8 + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setOriginator(String originator):\n");
        
        b8.setOriginator("Pikachu");
        System.out.println
        ("b8 after setting originator to Pikachu: " + b8 + "\n");
        
        try {
            System.out.println
            ("Attempting to set originator to null...");
            b8.setOriginator(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to set originator to empty String...");
            b8.setOriginator("");
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing toString():\n");
        
        System.out.println("b8's toString is: " + b8.toString() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing equals(Bill toCompare):\n");
        
        Money mon3 = new Money(650, 68);
        Date d1 = new Date(4, 7, 2018);
        
        Bill b9 = new Bill(mon3, d1, "Donkey Kong");
        System.out.println("Constructing a legal Bill b9: " + b9 + "\n");
        
        Bill b10 = new Bill(b9);
        System.out.println("Constructing a legal Bill b10: " + b10);
        System.out.println("Is b9 equal to b10? " + b9.equals(b10) + "\n");
        
        Bill b11 = new Bill(new Money(390, 26), d1, "Donkey Kong");
        System.out.println("Constructing a legal Bill b11: " + b11);
        System.out.println("Is b9 equal to b11? " + b9.equals(b11) + "\n");
        
        Bill b12 = new Bill(b11);
        b12.setPaid(new Date(3, 7, 2018));
        System.out.println("Constructing a legal Bill b12: " + b12);
        System.out.println("Is b11 equal to b12? " + b11.equals(b12) + "\n");
        
        Bill b13 = new Bill(b9);
        b13.setOriginator("Kraken");
        System.out.println("Constructing a legal Bill b13: " + b13);
        System.out.println("Is b9 equal to b13? " + b9.equals(b13) + "\n");
        
        Bill b14 = null;
        System.out.println("Constructing a legal Bill b14: " + b14);
        System.out.println("Is b9 equal to b14? " + b9.equals(b14) + "\n");
        
        Bill b15 = new Bill(b12);
        b15.setPaid(new Date(2, 7, 2018));
        System.out.println("Constructing a legal Bill b15: " + b15);
        System.out.println("Is b12 equal to b15? " + b12.equals(b15) + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getDueDate():\n");
        
        System.out.println("b15 is: " + b15);
        System.out.println("b15's due date is " + b15.getDueDate() + "\n");
        
        System.out.println("Checking for privacy leak:");
        Date gotDate = b15.getDueDate();
        System.out.println("Saving b15's due date to gotDate variable:");
        gotDate.setDate(2, 20, 2020);
        System.out.println("Setting gotDate to: " + gotDate);
        System.out.println
        ("After changing gotDate, b15 is still: " + b15 + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing getOriginator():\n");
        
        System.out.println("b15 is: " + b15);
        System.out.println("b15's originator is " + b15.getOriginator() 
                           + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing isPaid():\n");
        
        System.out.println("b9 is: " + b9);
        System.out.println("Is b9 paid? " + b9.isPaid() + "\n");
        
        System.out.println("b15 is: " + b15);
        System.out.println("Is b15 paid? " + b15.isPaid() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing setPaid():\n");

        Bill b16 = new Bill
                   (new Money(123, 59), new Date(6, 5, 2019), "Norman");
        System.out.println("Constructing a legal Bill b16: " + b16 + "\n");
        
        Date newPaid = new Date(8, 2, 2017);
        System.out.println("Constructing a Date called newPaid: " + newPaid);
        b16.setPaid(newPaid);
        System.out.println("Set b16's paid date to newPaid: " + b16 + "\n");
        
        System.out.println("Checking for privacy leak:");
        System.out.println("Setting newPaid's year to 2018:");
        newPaid.setYear(2018);
        System.out.println
        ("After changing newPaid, b16 is still: " + b16 + "\n");
        
        try {
            System.out.println
            ("Attempting to set b16's paid date to be later than due date...");
            b16.setPaid(new Date(6, 6, 2019));
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing clone():\n");
        
        Bill b17 = new Bill
                   (new Money(16, 22), new Date(9, 24, 2021), "Santa");
        System.out.println("Constructing a legal Date b17: " + b17);
        
        Bill b18 = b17.clone();
        System.out.println("Cloning b17 to b18: ");
        System.out.println("b18 is: " + b18 + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing compareTo(Object other):\n");
        
        Bill b19 = new Bill
                   (new Money(90, 99), new Date(9, 25, 2021), "Paul");
        System.out.println("Constructing a legal Bill b19: " + b19);
        
        Bill b20 = new Bill
                   (new Money(10, 29), new Date(9, 23, 2021), "Jane");
        System.out.println("Constructing a legal Bill b20: " + b20 + "\n");
        
        System.out.println("b17 compareTo b18 is: " + b17.compareTo(b18));
        System.out.println("b17 compareTo b19 is: " + b17.compareTo(b19));
        System.out.println
        ("b17 compareTo b20 is: " + b17.compareTo(b20) + "\n");
        
        try {
            System.out.println
            ("Attempting to compare a null to Bill b17...");
            b17.compareTo(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to compare a non-Bill to b17...");
            Integer i = new Integer(20);
            b17.compareTo(i);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
    }
    
    /**
    * This method tests all public methods inside the ArrayList class and 
    * prints the results on the console.
    * 
    * @param Nothing.
    * @return Nothing.
    */
    public static void arrayListTest() {
        System.out.println("Starting ArrayList test...\n");
        
        ArrayList a = new ArrayList();
        a.insert('B', 0);
        a.insert('a', 0);
        a.insert('t', 1);        
        System.out.println("ArrayList a: " + a.toString() + "\n");

        System.out.println("Index of 'a' in ArrayList a is " + a.indexOf('a'));
        System.out.println("Index of 't' in ArrayList a is " + a.indexOf('t'));
        System.out.println("Index of 'B' in ArrayList a is " + a.indexOf('B'));
        System.out.println("Index of 'j' in ArrayList a is " + a.indexOf('j'));
        System.out.println("The zeroth index of ArrayList a is " + a.get(0));
        System.out.println("The first index of ArrayList a is " + a.get(1));
        System.out.println("The second index of ArrayList a is " + a.get(2));
        System.out.println("Is ArrayList a empty? " + a.isEmpty());
        System.out.println("The size of ArrayList a is " + a.size() + "\n");

        System.out.println
        ("Trying to call get method using out of bounds index...");
        try {
            a.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("Trying to insert into an out of bounds index...");
        try {
            ArrayList exceptionTest = new ArrayList();
            exceptionTest.insert('T', 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        
        try {
            System.out.println("Trying to insert into a negative index...");
            ArrayList exceptionTest = new ArrayList();
            exceptionTest.insert('T', -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
                
        System.out.println("Removing elements from ArrayList a:");
        System.out.print(a.remove(0) + " ");
        System.out.print(a.remove(1) + " ");
        System.out.print(a.remove(0) + " ");
        System.out.println("\nArrayList a: " + a.toString());
        System.out.println("Is ArrayList a empty? " + a.isEmpty());
        System.out.println("The size of ArrayList a is " + a.size() + "\n");
        
        try {
            System.out.println("Trying to remove from an empty ArrayList...");
            a.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }

        try {
            System.out.println
            ("Trying to remove from a non-existent index...");
            ArrayList exceptionTest = new ArrayList();
            exceptionTest.insert('T', 0);
            exceptionTest.remove(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("Testing the equals method:\n");
        ArrayList b = new ArrayList();
        b.insert('r', 0);
        b.insert('a', 0);
        b.insert('B', 0);
        System.out.println("ArrayList b: " + b.toString() + "\n");
        
        ArrayList c = new ArrayList();
        c.insert('t', 0);
        c.insert('a', 0);
        c.insert('B', 0);
        System.out.println("ArrayList c: " + c.toString() + "\n");
        
        ArrayList d = new ArrayList();
        d.insert('t', 0);
        d.insert('a', 0);
        d.insert('B', 0);
        System.out.println("ArrayList d: " + c.toString() + "\n");
        
        System.out.println("Does b = c? " + b.equals(c));
        System.out.println("Does c = d? " + c.equals(d) + "\n");
        
        System.out.println("Comparing empty ArrayLists:");
        ArrayList e = new ArrayList();
        ArrayList f = new ArrayList();
        System.out.println("ArrayList e: " + e.toString());
        System.out.println("ArrayList f: " + f.toString());
        System.out.println("Does e = f? " + e.equals(f) + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing Iterable, Iterator methods:\n");
        
        ArrayList a2 = new ArrayList();
        a2.insert(0, 0);
        a2.insert(1, 1);
        a2.insert(2, 2);
        a2.insert(3, 3);
        a2.insert(4, 4);
        a2.insert(5, 5);
        System.out.println("Creating ArrayList a2:");
        System.out.println(a2.toString() + "\n");
        
        System.out.println
        ("Printing out each element in ArrayList using Iterator i:");
        Iterator i = a2.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println();

        System.out.println("Using i to remove the last iterated element:");
        i.remove();
        System.out.println("Now a2 is: " + a2 + "\n");
        
        try {
            System.out.println
            ("Attempting to remove immediately after removing...");
            i.remove();
        } catch (IllegalStateException g) {
            System.out.println("Response: " + g.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
    }
    
    /**
    * This method tests all public methods inside the ExpenseAccount class and 
    * prints the results on the console.
    * 
    * @param Nothing.
    * @return Nothing.
    */
    public static void expenseAccountTest() {
        System.out.println("expenseAccountTest\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing insert(Object obj, int index):\n");
        
        ExpenseAccount e1 = new ExpenseAccount();
        System.out.println("Constructing an empty ExpenseAccount e1:");
        System.out.println(e1.toString());
        
        Bill b0 = new Bill
        (new Money(120, 45), new Date(9, 29, 2019), "Charles");
        Bill b1 = new Bill
        (new Money(110, 25), new Date(2, 29, 2024), "Dora the Explorer");
        Bill b2 = new Bill
        (new Money(1009, 87), new Date(5, 30, 2023), "Dora the Explorer");
        Bill b3 = new Bill
        (new Money(450, 7), new Date(2, 14, 2017), "Dora the Murderer");
        System.out.println("Bill b0 is " + b0);
        System.out.println("Bill b1 is " + b1);
        System.out.println("Bill b2 is " + b2);
        System.out.println("Bill b3 is " + b3 + "\n");
        
        System.out.println("Inserting the Bills:");
        e1.insert(b1, 0);
        e1.insert(b2, 1);
        e1.insert(b3, 2);
        e1.insert(b0, 0);
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");
        
        try {
            System.out.println
            ("Attempting to insert a non-Bill object...");
            e1.insert(new Date(2, 9, 2017), 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        try {
            System.out.println
            ("Attempting to insert out of bounds...");
            e1.insert(b3, 7);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing set(Bill b, int index):\n");
        
        Bill b2New = new Bill
        (new Money(200, 4), new Date(1, 14, 2015), "Nemo");
        System.out.println("Bill b2New is: " + b2New + "\n");
        System.out.println("Setting b2New to index 2 of e1: ");
        e1.set(b2New, 2);
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");
        
        try {
            System.out.println
            ("Attempting to set out of bounds...");
            e1.insert(b3, 7);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }

        System.out.println("------------------------------------------");
        System.out.println
        ("Testing totalOutstanding(), numUnpaid(), numPaid(), ");
        System.out.println
        ("totalAmountPaid(), allPaid(), nextDueDate(), ");
        System.out.println("amountDueBy(Date dueDate):\n");
        
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");

        System.out.println
        ("e1's total outstanding amount is: " + e1.totalOutstanding());
        System.out.println
        ("e1's total number of unpaid Bills is: " + e1.numUnpaid());
        System.out.println
        ("e1's total number of paid Bills is: " + e1.numPaid());
        System.out.println
        ("e1's total amount paid is: " + e1.totalAmountPaid());
        System.out.println("Is e1 all paid up? " + e1.allPaid());
        System.out.println
        ("e1's next closest due date is: " + e1.nextDueDate());
        System.out.println("e1 will need to pay how much by 4/30/2020? " 
        + e1.amountDueBy(new Date(4, 30, 2020)) + "\n");
        
        System.out.println("Paying some Bills in e1: ");
        b2New.setPaid(new Date(1, 13, 2015));
        b0.setPaid(new Date(1, 13, 2015));
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");
        
        System.out.println
        ("e1's total outstanding amount is: " + e1.totalOutstanding());
        System.out.println
        ("e1's total number of unpaid Bills is: " + e1.numUnpaid());
        System.out.println
        ("e1's total number of paid Bills is: " + e1.numPaid());
        System.out.println
        ("e1's total amount paid is: " + e1.totalAmountPaid());
        System.out.println("Is e1 all paid up? " + e1.allPaid());
        System.out.println
        ("e1's next closest due date is: " + e1.nextDueDate());
        System.out.println("e1 will need to pay how much by 4/30/2020? " 
        + e1.amountDueBy(new Date(4, 30, 2020)) + "\n");
        
        System.out.println("Paying off the rest of the Bills in e1: ");
        b1.setPaid(new Date(1, 14, 2015));
        b3.setPaid(new Date(1, 14, 2015));
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");

        System.out.println
        ("e1's total outstanding amount is: " + e1.totalOutstanding());
        System.out.println
        ("e1's total number of unpaid Bills is: " + e1.numUnpaid());
        System.out.println
        ("e1's total number of paid Bills is: " + e1.numPaid());
        System.out.println
        ("e1's total amount paid is: " + e1.totalAmountPaid());
        System.out.println("Is e1 all paid up? " + e1.allPaid());
        System.out.println
        ("e1's next closest due date is: " + e1.nextDueDate());
        System.out.println("e1 will need to pay how much by 4/30/2020? " 
        + e1.amountDueBy(new Date(4, 30, 2020)) + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing amountOwedTo(String originator):\n");
        
        System.out.println("Finding non-existent originator...");
        System.out.println("How much does e1 owe to Nero? " 
        + e1.amountOwedTo("Nero") + "\n");
        
        e1.set(b2, 2);
        ((Bill) e1.get(1)).setUnpaid();
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");

        System.out.println("How much does e1 owe to Dora the Explorer? " 
        + e1.amountOwedTo("Dora the Explorer") + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing size(), isEmpty():\n");
        
        System.out.println("e1's size is: " + e1.size());
        System.out.println("Is e1 empty? " + e1.isEmpty() + "\n");
        
        System.out.println("Creating empty ExpenseAccount e2: ");
        ExpenseAccount e2 = new ExpenseAccount();
        System.out.println("e2's size is: " + e2.size());
        System.out.println("Is e2 empty? " + e2.isEmpty() + "\n");
        
        System.out.println("------------------------------------------");
        System.out.println("Testing remove(int index):\n");
        
        System.out.println("Removing from index 1 of e1: ");
        System.out.println(e1.remove(1));
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");
        
        try {
            System.out.println
            ("Attempting to remove from out of bounds index...");
            e1.remove(3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Testing iterator methods, get(int index), ");
        System.out.println("equals(Object other), indexOf(Object target):\n");
        
        System.out.println("Is e1 equal to e2? " + e1.equals(e2) + "\n");
        
        System.out.println("Using iterator to populate e2: ");
        Iterator i = e1.iterator();
        int j = 0;
        while (i.hasNext()) {
            e2.insert(i.next(), j);
            j++;
        }
        System.out.println("Now e2 is: ");
        System.out.println(e2.toString() + "\n");
        System.out.println("Is e1 equal to e2 now? " + e1.equals(e2) + "\n");
        
        System.out.println("Index 0 of e1 is: " + e1.get(0));
        System.out.println("Index 1 of e1 is: " + e1.get(1));
        System.out.println("Index 2 of e1 is: " + e1.get(2) + "\n");
        
        System.out.println("Index b0 of e1 is: " + e1.indexOf(b0));
        System.out.println("Index b1 of e1 is: " + e1.indexOf(b1));
        System.out.println("Index b2 of e1 is: " + e1.indexOf(b2) + "\n");
        
        System.out.println("Using i to remove the last iterated element:");
        i.remove();
        System.out.println("Now e1 is: ");
        System.out.println(e1.toString() + "\n");
        
        try {
            System.out.println
            ("Attempting to remove immediately after removing...");
            i.remove();
        } catch (IllegalStateException e) {
            System.out.println("Response: " + e.getMessage() + "\n");
        }
        
        System.out.println("------------------------------------------");
    }
}