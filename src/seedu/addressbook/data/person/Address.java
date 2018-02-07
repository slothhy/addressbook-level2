package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be of format BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    public static final String SEPARATOR = ",";

    private static final int BLOCK = 0;
    private static final int STREET = 1;
    private static final int UNIT = 2;
    private static final int POSTALCODE = 3;

    public final String value;
    private boolean isPrivate;


    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = processAddress(trimmedAddress);
    }


    private String processAddress(String trimmedAddress) {
        String [] trimmedAddressParts = trimmedAddress.split(SEPARATOR);
        Block block = new Block(trimmedAddressParts[BLOCK]);
        Street street = new Street(trimmedAddressParts[STREET]);
        Unit unit = new Unit(trimmedAddressParts[UNIT]);
        PostalCode postal = new PostalCode((trimmedAddressParts[POSTALCODE]));
        return block.getBlock() + "," + street.getStreet() + "," + unit.getUnit() + "," + postal.getPostal();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
