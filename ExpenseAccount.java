import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * The ExpenseAccount class keeps track of Bill objects and stores 
 * them in an ordered list.
 * 
 * @author Hoi Kin Cheng.
 * @date 3/2/2017.
 */
public class ExpenseAccount extends ArrayList {
    
    /**
    * This method inserts a Bill into a specified index. Will throw 
    * exception if argument is not of type Bill, or if index is negative 
    * or greater than the size of ExpenseAccount.
    * 
    * @param obj This is the Bill to be stored in ExpenseAccount.
    * @param index This is the index for which the object is to be stored 
    * in the ExpenseAccount.
    * @return Nothing.
    * @exception IndexOutOfBoundsException On negative index or index 
    * that is greater than the ExpenseAccount's size.
    * @exception IllegalArgumentException On inserting Object other than 
    * of type Bill.
    */
    @Override
    public void insert(Object obj, int index) throws 
                IndexOutOfBoundsException, IllegalArgumentException {
        if (obj instanceof Bill) {
            super.insert((Bill) obj, index);
        } else {
            throw new IllegalArgumentException
            ("Please only insert Bill objects for ExpenseAccount.");
        }
    }
    
    /**
    * This method sets a Bill to a specified index in the ExpenseAccount.
    * 
    * @param b This is the Bill to be set in ExpenseAccount.
    * @param index This is the index for which the Bill is to be stored 
    * in the ExpenseAccount.
    * @return Nothing.
    * @exception IndexOutOfBoundsException On negative index or index 
    * that is greater than or equal to the ExpenseAccount's size.
    */
    public void set(Bill b, int index) throws IndexOutOfBoundsException {
        insert(b, index);
        remove(index + 1);
    }
    
    /**
    * This method sorts Bills in ExpenseAccount by their due dates, from 
    * earliest to latest.
    * 
    * @param Nothing.
    * @return Nothing.
    */
    public void sort() {
        for (int index = 0; index < size(); index++) {
            int indexOfNextEarliest = indexOfEarliest(index);
            swap(index, indexOfNextEarliest);
        }
    }

    /**
    * This method helps the sort method to find the index of the Bill with 
    * the earliest due date given a start index.
    * 
    * @param startIndex This is the index to start looking for the Bill 
    * with the earliest due date.
    * @return int This is the index of the Bill that has the earliest due 
    * date.
    */
    private int indexOfEarliest(int startIndex) {
        Bill earliest = (Bill) get(startIndex);
        int indexOfEarliest = startIndex;
        for (int index = startIndex + 1; index < size(); index++) {
            if (((Bill) get(index)).compareTo(earliest) < 0) {
                earliest = (Bill) get(index);
                indexOfEarliest = index;
            }
        }
        return indexOfEarliest;
    }

    /**
    * This method helps the sort method to swap two elements in ExpenseAccount 
    * given their indices.
    * 
    * @param i This is one of the two indices of the elements to be swaped.
    * @param j This is one of the two indices of the elements to be swaped.
    * @return Nothing.
    */
    private void swap(int i, int j) {
        Bill temp = null;
        temp = (Bill) get(i);
        set((Bill) get(j), i);
        set(temp, j);
    }
    
    /**
    * This method returns the total amount of all the unpaid Bills in 
    * ExpenseAccount.
    * 
    * @param Nothing.
    * @return Money This is the total amount of all the unpaid Bills in 
    * ExpenseAccount.
    */
    public Money totalOutstanding() {
        Iterator i = iterator();
        Money total = new Money(0);
        while (i.hasNext()) {
            Bill b = (Bill) i.next();
            if (!b.isPaid()) {
                total.add(b.getAmount());
            }
        }
        return total;
    }
    
    /**
    * This method returns the total number of Bills that are unpaid in 
    * ExpenseAccount.
    * 
    * @param Nothing.
    * @return int This is the total number of Bills that are unpaid in 
    * ExpenseAccount.
    */
    public int numUnpaid() {
        int unpaid = 0;
        Iterator i = iterator();
        while (i.hasNext()) {
            Bill b = (Bill) i.next();
            if (!b.isPaid()) {
                unpaid++;
            }
        }
        return unpaid;
    }
    
    /**
    * This method returns the total number of Bills that are paid in 
    * ExpenseAccount.
    * 
    * @param Nothing.
    * @return int This is the total number of Bills that are paid in 
    * ExpenseAccount.
    */
    public int numPaid() {
        return size() - numUnpaid();
    }
    
    /**
    * This method returns the total amount of Bills that already has a paid 
    * date.
    * 
    * @param Nothing.
    * @return Money This is the total amount of Bills that already has a paid 
    * date.
    */
    public Money totalAmountPaid() {
        Money sum = new Money(0);
        Iterator i = iterator();
        while (i.hasNext()) {
            Bill b = (Bill) i.next();
            if (b.isPaid()) {
                sum.add(b.getAmount());
            }
        }
        return sum;
    }
    
    /**
    * This method checks if all the Bills in the ExpenseAccount have been 
    * paid.
    * 
    * @param Nothing.
    * @return boolean This returns true if all the Bills in the 
    * ExpenseAccount has been paid, returns false otherwise.
    */
    public boolean allPaid() {
        return totalOutstanding().equals(new Money(0));
    }
    
    /**
    * This method finds and returns the next closest due date that is 
    * not yet been paid.
    * 
    * @param Nothing.
    * @return Date This is the next closest due date that is not yet 
    * been paid.
    */
    public Date nextDueDate() {
        if (allPaid()) {
            return null;
        } else {
            Date earliest = new Date(12, 31, 2024);
            for (int i = 0; i < size(); i++) {
                if (earliest.compareTo(((Bill) get(i)).getDueDate()) > 0 && 
                   !((Bill) get(i)).isPaid()) {
                    earliest = ((Bill) get(i)).getDueDate();
                }
            }
            return earliest;
        }
    }

    /**
    * This method finds the total amount owed to a particular originator from 
    * all the Bills in ExpenseAccount.
    * 
    * @param originator This is the particular originator to whom we want 
    * to find the total amount owed.
    * @return Money Ths is the total amount owed to a particular originator 
    * in ExpenseAccount.
    */
    public Money amountOwedTo(String originator) {
        Money sum = new Money(0);
        Iterator i = iterator();
        while (i.hasNext()) {
            Bill b = (Bill) i.next();
            if (!b.isPaid() && b.getOriginator().equals(originator)) {
                sum.add(b.getAmount());
            }
        }
        return sum;
    }

    /**
    * This method finds the total amount that we will have to pay by the 
    * specified due date, exculding the Bills that have already been paid.
    * 
    * @param dueDate This specifies the latest date in which the total amount 
    * to pay is added up to.
    * @return Money Ths is the total amount that we will have to pay by the 
    * specified due date, exculding the Bills that have already been paid.
    */
    public Money amountDueBy(Date dueDate) {
        Money sum = new Money(0);
        Iterator i = iterator();
        while (i.hasNext()) {
            Bill b = (Bill) i.next();
            if (!b.isPaid() && b.getDueDate().compareTo(dueDate) <= 0) {
                sum.add(b.getAmount());
            }
        }
        return sum;
    }

    /**
    * This method returns all Bills in the ExpenseAccount as an organized 
    * String.
    * 
    * @param Nothing.
    * @return String This returns all Bills in the ExpenseAccount as an 
    * organized String.
    */
    @Override
    public String toString() {
        String str = "";
        if (size() != 0) {
            for (int i = 0; i < size() - 1; i++) {
                str += get(i) + "\n";
            }
            str += get(size() - 1);
        }
        return str;
    }
}
