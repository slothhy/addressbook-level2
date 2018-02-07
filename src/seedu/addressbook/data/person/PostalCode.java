package seedu.addressbook.data.person;

/**
 * Represents a Person's street in the address book.
 */

public class PostalCode {

    private String postal;

    public PostalCode(String block) {
        this.postal = block;
    }

    public String getPostal() {
        return postal;
    }

    @Override
    public String toString() {
        return postal;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.postal.equals(((PostalCode) other).postal)); // state check
    }
}
