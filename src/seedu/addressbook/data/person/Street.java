package seedu.addressbook.data.person;

/**
 * Represents a Person's street in the address book.
 */

public class Street {

    private String street;

    public Street(String block) {
        this.street = block;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return street;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.street.equals(((Street) other).street)); // state check
    }
}
