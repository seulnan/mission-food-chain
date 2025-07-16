package mission.domain.fish.utils;

import mission.domain.fish.FishType;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FishParser {

    private static final Pattern pattern = Pattern.compile("\\[(.*?)-(\\d+)]");

    public static Map<FishType, Integer> parse(String input) {
        Matcher matcher = pattern.matcher(input);
        Map<FishType, Integer> fishCounts = new HashMap<>();

        while (matcher.find()) {
            String name = matcher.group(1).trim();
            int count = Integer.parseInt(matcher.group(2).trim());

            FishType type = FishType.fromName(name);
            fishCounts.put(type, fishCounts.getOrDefault(type, 0) + count);
        }

        return fishCounts;
    }
}
