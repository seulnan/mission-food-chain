package mission.domain.fish.utils;

import mission.domain.fish.FishType;
import mission.domain.fish.exception.FishError;
import mission.domain.fish.exception.InvalidFishException;

import java.util.HashMap;
import java.util.Map;

public class FishParser {

    public static Map<FishType, Integer> toFishTypeMap(Map<String, Integer> input) {
        Map<FishType, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : input.entrySet()) {
            FishType type = validateAndMap(entry.getKey());
            result.put(type, entry.getValue());
        }

        return result;
    }

    private static FishType validateAndMap(String name) {
        return FishTypeMapper.map(name)
                .orElseThrow(() -> new InvalidFishException(FishError.INVALID_FISH_NAME));
    }
}
