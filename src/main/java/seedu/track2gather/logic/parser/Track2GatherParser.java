package seedu.track2gather.logic.parser;

import static seedu.track2gather.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.track2gather.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.track2gather.logic.commands.AddCommand;
import seedu.track2gather.logic.commands.ClearCommand;
import seedu.track2gather.logic.commands.Command;
import seedu.track2gather.logic.commands.DeleteCommand;
import seedu.track2gather.logic.commands.EditCommand;
import seedu.track2gather.logic.commands.ExitCommand;
import seedu.track2gather.logic.commands.FCallCommand;
import seedu.track2gather.logic.commands.FindCommand;
import seedu.track2gather.logic.commands.HelpCommand;
import seedu.track2gather.logic.commands.ListCommand;
import seedu.track2gather.logic.commands.SCallCommand;
import seedu.track2gather.logic.commands.ScheduleCommand;
import seedu.track2gather.logic.commands.SessionCommand;
import seedu.track2gather.logic.commands.SortCommand;
import seedu.track2gather.logic.commands.TShiftCommand;
import seedu.track2gather.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class Track2GatherParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case SortCommand.COMMAND_WORD:
            return new SortCommandParser().parse(arguments);

        case TShiftCommand.COMMAND_WORD:
            return new TShiftCommandParser().parse(arguments);

        case FCallCommand.COMMAND_WORD:
            return new FCallCommandParser().parse(arguments);

        case SCallCommand.COMMAND_WORD:
            return new SCallCommandParser().parse(arguments);

        case ScheduleCommand.COMMAND_WORD:
            return new ScheduleCommand();

        case SessionCommand.COMMAND_WORD:
            return new SessionCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
