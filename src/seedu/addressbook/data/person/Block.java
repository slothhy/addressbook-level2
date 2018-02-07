package seedu.addressbook.data.person;

/**
 * Represents a Person's block in the address book.
 */

public class Block {

    private String block;

    public Block(String block) {
        this.block = block;
    }

    public String getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return block;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Block) other).block)); // state check
    }
}
