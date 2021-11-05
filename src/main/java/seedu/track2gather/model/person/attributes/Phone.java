package seedu.track2gather.model.person.attributes;

import static seedu.track2gather.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's phone number in the contacts list.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone extends Attribute<String> {

    public static final String MESSAGE_CONSTRAINTS =
            "Phone numbers should only contain integers, and should be at least 3 digits long";
    public static final String MESSAGE_CONSTRAINTS_KEYWORDS =
            "Phone number keywords should only contain integers, and should be at least 1 digit long";
    public static final String VALIDATION_REGEX = "\\d{3,}";
    public static final String VALIDATION_REGEX_KEYWORD = "\\d{1,}";

    /**
     * Constructs a {@code Phone}.
     *
     * @param phone A valid phone number.
     */
    public Phone(String phone) {
        super(phone);
        checkArgument(isValidPhone(phone), MESSAGE_CONSTRAINTS);
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidPhone(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid phone number keyword.
     */
    public static boolean isValidPhoneKeyword(String test) {
        return test.matches(VALIDATION_REGEX_KEYWORD);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && value.equals(((Phone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
