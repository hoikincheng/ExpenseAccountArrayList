import java.io.Serializable;
/**
 * The Date class stores the day, month, and year values. It allows access 
 * and changes to the class. Class invariants: months between 1 and 12, 
 * days between 1 and 31, years between 2014 and 2024, and 31st, 30th, 
 * 29th day only occur on appropriate months in the calendar.
 * 
 * @author Hoi Kin Cheng.
 * @date 3/2/2017.
 */
public class Date implements Comparable, Cloneable, Serializable {
    
    private int day;
    private int month;
    private int year;
    
    /**
    * This constructor initializes using month, day, and year inputs.
    * 
    * @param m This is the month to be stored in Date.
    * @param d This is the day to be stored in Date.
    * @param y This is the year to be stored in Date.
    * @return Nothing.
    * @exception IllegalArgumentException On months not between 1 and 12, 
    * days not between 1 and 31, years not between 2014 and 2024, or 
    * 31st, 30th, 29th day occurring on inappropriate months.
    */
    public Date(int m, int d, int y) throws IllegalArgumentException {
        setDate(m, d, y);
    }
    
    /**
    * This constructor initializes using year inputs, and assumes both 
    * month and day are 1.
    * 
    * @param y This is the year to be stored in Date.
    * @return Nothing.
    * @exception IllegalArgumentException On years not between 2014 
    * and 2024.
    */
    public Date(int y) throws IllegalArgumentException {
        setDate(1, 1, y);
    }
    
    /**
    * This is the copy constructor.
    * 
    * @param other This is the Date object to be copied.
    * @return Nothing.
    * @exception IllegalArgumentException On null Date object.
    */
    public Date(Date other) throws IllegalArgumentException {
        if (other != null) {
            this.month = other.month;
            this.day = other.day;
            this.year = other.year;
        } else {
            throw new IllegalArgumentException
                      ("The other Date cannot be null.");
        }
    }
    
    /**
    * This method returns the month of the Date.
    * 
    * @param Nothing.
    * @return int This returns the month of the Date.
    */
    public int getMonth() {
        return month;
    }
    
    /**
    * This method returns the day of the Date.
    * 
    * @param Nothing.
    * @return int This returns the day of the Date.
    */
    public int getDay() {
        return day;
    }
    
    /**
    * This method returns the year of the Date.
    * 
    * @param Nothing.
    * @return int This returns the year of the Date.
    */
    public int getYear() {
        return year;
    }
    
    /**
    * This method sets the month, day, and year in Date.
    * 
    * @param m This is the month to be stored in Date.
    * @param d This is the day to be stored in Date.
    * @param y This is the year to be stored in Date.
    * @return Nothing.
    * @exception IllegalArgumentException On months not between 1 and 12, 
    * days not between 1 and 31, years not between 2014 and 2024, or 
    * 31st, 30th, 29th day occurring on inappropriate months.
    */
    public void setDate(int m, int d, int y) throws IllegalArgumentException {
        if (DateOK(m, d, y)) {
            this.month = m;
            this.day = d;
            this.year = y;
        } else {
            throw new IllegalArgumentException("Invalid Date.");
        }
    }
    
    /**
    * This method sets the year, and assumes both month and day are 1.
    * 
    * @param y This is the year to be stored in Date.
    * @return Nothing.
    * @exception IllegalArgumentException On years not between 2014 
    * and 2024.
    */
    public void setDate(int y) throws IllegalArgumentException {
        setDate(1, 1, y);
    }
    
    /**
    * This method sets the month in Date.
    * 
    * @param m This is the month to be stored in Date.
    * @return Nothing.
    * @exception IllegalArgumentException On months not between 1 and 12,
    * or 31st, 30th, 29th day occurring on inappropriate months.
    */
    public void setMonth(int m) throws IllegalArgumentException {
        setDate(m, day, year);
    }
    
    /**
    * This method sets the day in Date.
    * 
    * @param d This is the day to be stored in Date.
    * @return Nothing.
    * @exception IllegalArgumentException On days not between 1 and 31,
    * or 31st, 30th, 29th day occurring on inappropriate months.
    */
    public void setDay(int d) throws IllegalArgumentException {
        setDate(month, d, year);
    }
    
    /**
    * This method sets the year in Date.
    * 
    * @param y This is the year to be stored in Date.
    * @return Nothing.
    * @exception IllegalArgumentException On years not between 2014 and 
    * 2024, or 31st, 30th, 29th day occurring on inappropriate months.
    */
    public void setYear(int y) throws IllegalArgumentException {
        setDate(month, day, y);
    }
    
    /**
    * This method checks if this Date is equal to another Date.
    * 
    * @param o This is the other Date to compare.
    * @return boolean This returns true if month, day, and year in this Date 
    * equals to month, day, and year in the other Date, returns false 
    * otherwise.
    */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Date otherDate = ((Date) o).clone();
            if (this.month == otherDate.month && this.day == otherDate.day && 
                this.year == otherDate.year) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
    * This method returns the Date in m/d/y as a String.
    * 
    * @param Nothing.
    * @return String This returns the Date in m/d/y as a String.
    */
    @Override
    public String toString() {
        return (month + "/" + day + "/" + year);
    }
    
    /**
    * This method checks if this Date precedes another Date.
    * 
    * @param otheDate This is the other Date to compare.
    * @return boolean This returns true if this Date precedes the other Date, 
    * returns false otherwise.
    */
    public Boolean precedes(Date otherDate) {
        return ( (year < otherDate.year) || 
                 (year == otherDate.year && month < otherDate.month) ||
                 (year == otherDate.year && month == otherDate.month
                 && day < otherDate.day) );
    }
    
    /**
    * This method returns a clone of the existing Date object.
    * 
    * @param Nothing.
    * @return Date This is the clone of the exisitng Date object.
    * @exception CloneNotSupportedException On not supported class, this 
    * should never happen.
    */
    @Override
    public Date clone() {
        try {
            return (Date) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    /**
    * This method compares the existing Date object to another object. If 
    * they are of different types, throws exception. If they have the same 
    * date, return 0. If the existing Date precedes the other Date, 
    * returns -1. If the existing Date is after the other Date, returns 1.
    * 
    * @param other This is the other Date to compare.
    * @return int This returns either 0, 1, or -1 depending on the comparison 
    * result. If they have the same amount, return 0. If they have the same 
    * date, return 0. If the existing Date precedes the other Date, 
    * returns -1. If the existing Date is after the other Date, returns 1.
    * @exception IllegalArgumentException On passing in a null or non-Date 
    * class object.
    */
    @Override
    public int compareTo(Object other) throws IllegalArgumentException {
        if (other == null) {
            throw new IllegalArgumentException
                      ("The other Object cannot be null.");
        } else if (getClass() != other.getClass()) {
            throw new IllegalArgumentException
                      ("The other Object must be of class Date.");
        }
        Date otherDate = ((Date) other).clone();
        if (equals(otherDate)) {
            return 0;
        } else if (precedes(otherDate)) {
            return -1;
        } else {
            return 1;
        }
    }
    
    /**
    * This method checks if months are between 1 and 12, days are between 
    * 1 and 31, years are between 2014 and 2024, and 31st, 30th, 29th day 
    * only occurring in appropriate months on the calendar.
    * 
    * @param m This is the month to be checked.
    * @param d This is the day to be checked.
    * @param y This is the year to be checked.
    * @return True if months are between 1 and 12, days are between 1 and 31, 
    * years are between 2014 and 2024, and 31st, 30th, 29th day only 
    * occurring in appropriate months on the calendar, returns false 
    * otherwise.
    */
    private boolean DateOK(int m, int d, int y) {
        if ( (d >= 1) && (y >= 2014) && (y <= 2024) ) {
            if ( ( (m == 1 || m == 3 || m == 5 || m == 7 || m ==8 || m == 10 
                || m == 12) && (d <= 31) ) || ( (m == 4 || m == 6 || m == 9 
                || m == 11) && (d <= 30) ) || (m == 2 && d <= 28) ) {
                return true;
            } else if ( (m == 2 && y == 2016) || (m == 2 && y == 2020)  || 
                        (m == 2 && y == 2024) ) {
                if (d <= 29) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
