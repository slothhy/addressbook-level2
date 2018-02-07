package seedu.addressbook.data.person;

/**
 * Represents a Person's street in the address book.
 */

public class Unit {

    private String unit;

    public Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return unit;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.unit.equals(((Unit) other).unit)); // state check
    }
}
