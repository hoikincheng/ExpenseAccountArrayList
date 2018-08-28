import java.io.Serializable;
/**
 * The Money class stores the dollars and the cents. It allows access and 
 * changes to the class. Class invariants: dollars must be non-negative; 
 * cents must be non-negative and do not exceed 99.
 * 
 * @author Hoi Kin Cheng.
 * @date 3/2/2017.
 */
public class Money implements Comparable, Cloneable, Serializable {
    
    private int dollars;
    private int cents;
    
    /**
    * This constructor initializes using dollars input and assumes no cents.
    * 
    * @param dol This is the dollars to be stored in Money.
    * @return Nothing.
    * @exception IllegalArgumentException On negative dollars.
    */
    public Money(int dol) throws IllegalArgumentException {
        if (moneyOK(dol, cents)) {
            this.dollars = dol;
            cents = 0;
        } else {
            throw new IllegalArgumentException("Dollars cannot be negative.");
        }
    }
    
    /**
    * This constructor initializes dollars and cents accordingly.
    * 
    * @param dol This is the dollars to be stored in Money.
    * @param cent This is the cents to be stored in Money.
    * @return Nothing.
    * @exception IllegalArgumentException On negative dollars, negative 
    * cents, or cents greater than 99.
    */
    public Money(int dol, int cent) throws IllegalArgumentException {
        if (moneyOK(dol, cent)) {
            this.dollars = dol;
            this.cents = cent;
        } else {
            throw new IllegalArgumentException
            ("Dollars/cents cannot be negative, and cents must be < 100");
        }
    }
    
    /**
    * This is the copy constructor.
    * 
    * @param other This is the Money object to be copied.
    * @return Nothing.
    * @exception IllegalArgumentException On null Money object.
    */
    public Money(Money other) throws IllegalArgumentException {
        if (other != null) {
            this.dollars = other.dollars;
            this.cents = other.cents;
        } else {
            throw new IllegalArgumentException
                      ("The other Money cannot be null.");
        }
    }

    /**
    * This method returns a clone of the existing Money object.
    * 
    * @param Nothing.
    * @return Money This is the clone of the exisitng Money object.
    * @exception CloneNotSupportedException On not supported class, this 
    * should never happen.
    */
    @Override
    public Money clone() {
        try {
            return (Money) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    /**
    * This method returns the value of dollars.
    * 
    * @param Nothing.
    * @return int This returns the value of dollars.
    */
    public int getDollars() {
        return dollars;
    }
    
    /**
    * This method returns the value of cents.
    * 
    * @param Nothing.
    * @return int This returns the value of cents.
    */
    public int getCents() {
        return cents;
    }
    
    /**
    * This method returns the value of dollars + cents.
    * 
    * @param Nothing.
    * @return double This returns the value of dollars + cents.
    */
    public double getMoney() {
        return dollars + cents * 0.01;
    }
    
    /**
    * This method sets the dollars value in Money.
    * 
    * @param dol This is the dollars value to be set in Money.
    * @return Nothing.
    * @exception IllegalArgumentException On negative dollars.
    */
    public void setDollars(int dol) throws IllegalArgumentException {
        if (moneyOK(dol, cents)) {
            this.dollars = dol;
        } else {
            throw new IllegalArgumentException("Dollars cannot be negative.");
        }
    }
    
    /**
    * This method sets the cents value in Money.
    * 
    * @param cen This is the cents value to be set in Money.
    * @return Nothing.
    * @exception IllegalArgumentException On negative cents or cents
    * exceeding 99.
    */
    public void setCents(int cen) throws IllegalArgumentException {
        if (moneyOK(dollars, cen)) {
            this.cents = cen;
        } else {
            throw new IllegalArgumentException
            ("Cents cannot be negative, and cents must be < 100.");
        }
    }
    
    /**
    * This method sets the dollars and cents value in Money.
    * 
    * @param dol This is the dollars value to be set in Money.
    * @param cen This is the cents value to be set in Money.
    * @return Nothing.
    * @exception IllegalArgumentException On negative dollars/cents or cents
    * exceeding 99.
    */
    public void setMoney(int dol, int cent) throws IllegalArgumentException {
        setDollars(dol);
        setCents(cent);
    }
    
    /**
    * This method adds dollars to the current Money.
    * 
    * @param dol This is the dollars value to be added to Money.
    * @return Nothing.
    * @exception IllegalArgumentException On negative dollars.
    */
    public void add(int dol) throws IllegalArgumentException {
        if (moneyOK(dol, cents)) {
            dollars += dol;
        } else {
            throw new IllegalArgumentException
                      ("Does not add negative dollars.");
        }
    }

    /**
    * This method adds the dollars and cents value to the current Money.
    * 
    * @param dol This is the dollars value to be added to Money.
    * @param cents This is the cents value to be added to Money.
    * @return Nothing.
    * @exception IllegalArgumentException On negative dollars/cents or cents
    * exceeding 99.
    */
    public void add(int dol, int cents) throws IllegalArgumentException {
        if (moneyOK(dol, cents)) {
            int addedCents = this.cents + cents;
            if (addedCents > 99) {
                this.dollars += dol + 1;
                this.cents = addedCents - 100;
            } else {
                this.dollars += dol;
                this.cents += cents;
            }
        } else {
            throw new IllegalArgumentException
            ("Does not add negative dollars/cents, and cents must be < 100.");
        }
    }
    
    /**
    * This method adds another Money object to the current Money.
    * 
    * @param other This is the other Money object to be added to the 
    * current Money.
    * @return Nothing.
    * @exception IllegalArgumentException On null Money object.
    */
    public void add(Money other) throws IllegalArgumentException {
        if (other != null) {
            add(other.getDollars(), other.getCents());
        } else {
            throw new IllegalArgumentException
                      ("The other Money cannot be null.");
        }
    }

    /**
    * This method checks if this Money is equal to another Money.
    * 
    * @param o This is the other Money to compare.
    * @return boolean This returns true if dollars + cents in this Money  
    * equals to dollars + cents in the other Money, returns false otherwise.
    */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Money otherMoney = ((Money) o).clone();
            if (this.dollars == otherMoney.dollars 
                && this.cents == otherMoney.cents) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
    * This method returns the value of Money as a String.
    * 
    * @param Nothing.
    * @return String This returns value of Money as a String.
    */
    @Override
    public String toString() {
        String toPrint = "$" + dollars;
        if (cents < 10) {
            toPrint += ".0" + cents;
        } else {
            toPrint += "." + cents;
        }
        return toPrint;
    }
    
    /**
    * This method compares the existing Money object to another object. If 
    * they are of different types, throws exception. If they have the same 
    * amount, return 0. If the existing Money is less than the other Money, 
    * returns -1. If the existing Money is greater than the other Money, 
    * returns 1. 
    * 
    * @param other This is the other Money to compare.
    * @return int This returns either 0, 1, or -1 depending on the comparison 
    * result. If they have the same amount, return 0. If the existing Money 
    * is less than the other Money, returns -1. If the existing Money is 
    * greater than the other Money, returns 1. 
    * @exception IllegalArgumentException On passing in a null or non-Money 
    * class object.
    */
    @Override
    public int compareTo(Object other) throws IllegalArgumentException {
        if (other == null) {
            throw new IllegalArgumentException
                      ("The other Object cannot be null.");
        } else if (getClass() != other.getClass()) {
            throw new IllegalArgumentException
                      ("The other Object must be of class Money.");
        }
        Money otherMoney = ((Money) other).clone();
        if (dollars == otherMoney.dollars && cents == otherMoney.cents) {
            return 0;
        } else if (dollars > otherMoney.dollars || 
                  (dollars == otherMoney.dollars && 
                  cents > otherMoney.cents)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
    * This method checks if the dollars/cents are non-negative, and checks if 
    * the cents stays below 100.
    * 
    * @param d This is the dollars to be checked.
    * @param c This is the cents to be checked.
    * @return True if the dollars/cents are non-negative, and cents stays 
    * below 100, otherwise returns false.
    */
    private boolean moneyOK(int d, int c) {
        return (d >= 0 && c >= 0 && c <= 99);
    }
}
