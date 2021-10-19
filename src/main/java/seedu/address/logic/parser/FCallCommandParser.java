package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.FCallCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new FCallCommand object
 */
public class FCallCommandParser implements Parser<FCallCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FCallCommand
     * and returns a FCallCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FCallCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new FCallCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FCallCommand.MESSAGE_USAGE), pe);
        }
    }

}
