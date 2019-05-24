package de.vermietet.vvecrm.infrastructure.serviceimpl;

import de.vermietet.vvecrm.domain.model.DurationData;
import de.vermietet.vvecrm.domain.service.DurationParserService;
import de.vermietet.vvecrm.infrastructure.exception.IllegalDurationPatternException;

import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
public class DurationParserServiceImpl implements DurationParserService {
    private final Pattern pattern = Pattern.compile("([0-9]+)([a-z]+)");

    @Override
    public DurationData parseDuration(String duration) {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime;

        Matcher matcher = pattern.matcher(duration);

        if (!matcher.find()) {
            throw new IllegalDurationPatternException(duration);
        }

        String timeUnit = matcher.group(2);
        String period = matcher.group(1);

        switch (timeUnit) {
            case "h":
                startTime = LocalDateTime.now().minusHours(Long.valueOf(period));
            case "m":
                startTime = LocalDateTime.now().minusMinutes(Long.valueOf(period));
            case "s":
                startTime = LocalDateTime.now().minusSeconds(Long.valueOf(period));
            case "mth":
                startTime = LocalDateTime.now().minusMonths(Long.valueOf(period));
            case "y":
                startTime = LocalDateTime.now().minusYears(Long.valueOf(period));
            case "w":
                startTime = LocalDateTime.now().minusWeeks(Long.valueOf(period));
            default:
                startTime = LocalDateTime.now();
        }

        return new DurationData(startTime, endTime);
    }
}
