import java.io.Serializable;
/**
 * The Bill class stores the amount, due date, paid date, and originator. 
 * It allows access and changes to the class. Class invariants: paid date 
 * should be on or earlier than the due date, and originator should never 
 * be empty (or null).
 * 
 * @author Hoi Kin Cheng.
 * @date 3/2/2017.
 */
public class Bill implements Comparable, Cloneable, Serializable {
    
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    
    /**
    * This constructor initializes using amount, due date, and originator as 
    * inputs, and assumes paid date is unpaid for now.
    * 
    * @param amount This is the amuont owed on the Bill.
    * @param dueDate This is the due date on the Bill.
    * @param originator This is to whom this Bill is owed to.
    * @return Nothing.
    * @exception IllegalArgumentException On null or empty originator.
    */
    public Bill(Money amount, Date dueDate, String originator) throws 
           IllegalArgumentException {
        this.amount = new Money(amount);
        this.dueDate = new Date(dueDate);
        this.paidDate = null;
        setOriginator(originator);
    }
    
    /**
    * This is the copy constructor.
    * 
    * @param toCopy This is the Bill object to be copied.
    * @return Nothing.
    * @exception IllegalArgumentException On null Bill object.
    */
    public Bill(Bill toCopy) {
        if (toCopy != null) {
            this.amount = new Money(toCopy.amount);
            this.dueDate = new Date(toCopy.dueDate);
            if (toCopy.paidDate == null) {
                this.paidDate = null;
            } else {
                this.paidDate = new Date(toCopy.paidDate);
            }
            this.originator = toCopy.originator;
        } else {
            throw new IllegalArgumentException
                      ("The other Bill cannot be null.");
        }
    }
    
    /**
    * This method returns the due date of the Bill.
    * 
    * @param Nothing.
    * @return Date This returns the due date of the Bill.
    */
    public Date getDueDate() {
        return dueDate.clone();
    }
    
    /**
    * This method returns the originator of the Bill.
    * 
    * @param Nothing.
    * @return String This returns the originator of the Bill.
    */
    public String getOriginator() {
        return originator;
    }
    
    /**
    * This method checks if Bill is paid (has a paid date).
    * 
    * @param Nothing.
    * @return boolean This returns true if the bill is paid (has a paid 
    * date), returns false otherwise.
    */
    public boolean isPaid() {
        return paidDate != null;
    }
    
    /**
    * This method sets the paid date in Bill.
    * 
    * @param onDay This is the Date that the Bill is paid.
    * @return Nothing.
    * @exception IllegalArgumentException On paid date later than the due date.
    */
    public void setPaid(Date onDay) throws IllegalArgumentException {
        if (onDay == null) {
            paidDate = null;
        } else if (onDay.precedes(this.dueDate) || 
                   this.dueDate.equals(onDay)) {
            paidDate = onDay.clone();
        } else {
            throw new IllegalArgumentException
            ("Paid date should be on or earlier than the due date.");
        }
    }
    
    /**
    * This method sets the paid date in Bill to unpaid status.
    * 
    * @param Nothing.
    * @return Nothing.
    */
    public void setUnpaid() {
        paidDate = null;
    }
    
    /**
    * This method sets the due date in Bill.
    * 
    * @param nextDate This is the Date that the Bill is due.
    * @return Nothing.
    * @exception IllegalArgumentException On due date earlier than the 
    * paid date.
    */
    public void setDueDate(Date nextDate) throws IllegalArgumentException {
        if (nextDate == null) {
            throw new IllegalArgumentException("Due date cannot be null.");
        } else if (paidDate == null || paidDate.precedes(nextDate) || 
                   paidDate.equals(nextDate)) {
            dueDate = nextDate.clone();
        } else {
            throw new IllegalArgumentException
            ("Due date should be on or after the paid date.");
        }
    }
    
    /**
    * This method sets the amount owed on the Bill.
    * 
    * @param amount This is the amount owed on the Bill.
    * @return Nothing.
    * @exception IllegalArgumentException On null Money object.
    */
    public void setAmount(Money amount) throws IllegalArgumentException {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null.");
        } else {
            this.amount = amount.clone();
        }
    }
    
    /**
    * This method returns the amount owed on the Bill.
    * 
    * @param Nothing.
    * @return Money This returns the amount owed on the Bill.
    */
    public Money getAmount() {
        return amount.clone();
    }
    
    /**
    * This method sets the originator on the Bill.
    * 
    * @param originator This is the originator to be set on the Bill.
    * @return Nothing.
    * @exception IllegalArgumentException On empty or null originator.
    */
    public void setOriginator(String originator) throws 
                IllegalArgumentException {
        if (originator != null && originator != "") {
            this.originator = originator;
        } else {
            throw new IllegalArgumentException
                      ("originator cannot be empty or null.");
        }
    }

    /**
    * This method returns the Bill as a String.
    * 
    * @param Nothing.
    * @return String This returns the Bill as a String, describing its amount 
    * owed, due date, owed to whom, and paid date.
    */
    @Override
    public String toString() {
        return "Amount owed: " + amount + ". Due date: " + dueDate + 
               ". Owed to: " + originator + ". Paid date: " + paidDate + ".";
    }
    
    /**
    * This method checks if this Bill is equal to another Bill.
    * 
    * @param toCompare This is the other Bill to compare.
    * @return boolean This returns true if the amount owed, due date, 
    * originator, and paid date in this Date equals to the amount owed, due 
    * date, originator, and paid date in the other Date, returns false 
    * otherwise.
    */
    public boolean equals(Bill toCompare) {
        if (toCompare != null && this.amount.equals(toCompare.amount) && 
            this.dueDate.equals(toCompare.dueDate) && 
            this.originator.equals(toCompare.originator)) {
            if (this.paidDate == null && toCompare.paidDate == null) {
                return true;
            } else if (isPaid() != toCompare.isPaid()) {
                return false;
            } else if (this.paidDate.equals(toCompare.paidDate)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
    * This method returns a clone of the existing Bill object (deep copy).
    * 
    * @param Nothing.
    * @return Clone This is the deep copy clone of the exisitng Bill object.
    * @exception CloneNotSupportedException On not supported class, this 
    * should never happen.
    */
    @Override
    public Bill clone() {
        try {
            Bill copy = (Bill) super.clone();
            copy.amount = amount.clone();
            copy.dueDate = dueDate.clone();
            if (paidDate != null) {
                copy.paidDate = paidDate.clone();
            } else {
                copy.paidDate = null;
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
    * This method compares the existing Bill object to another object. If 
    * they are of different types, throws exception. If they have the same 
    * due date, returns 0. If the existing due date precedes the other due 
    * date, returns -1. If the existing due date is after the other due date, 
    * returns 1.
    * 
    * @param other This is the other Bill to compare.
    * @return int This returns either 0, 1, or -1 depending on the comparison 
    * result. If the Bills have the same due date, returns 0. If the existing 
    * due date precedes the other due date, returns -1. If the existing due 
    * date is after the other due date, returns 1.
    * @exception IllegalArgumentException On passing in a null or non-Bill 
    * class object.
    */
    @Override
    public int compareTo(Object other) throws IllegalArgumentException {
        if (other == null) {
            throw new IllegalArgumentException
                      ("The other Object cannot be null");
        } else if (getClass() != other.getClass()) {
            throw new IllegalArgumentException
                      ("The other Object must be of class Bill.");
        }
        Bill otherBill = ((Bill) other).clone();
        if (this.dueDate.equals(otherBill.dueDate)) {
            return 0;
        } else if (this.dueDate.compareTo(otherBill.dueDate) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
