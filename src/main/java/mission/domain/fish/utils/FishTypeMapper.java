package mission.domain.fish.utils;

import mission.domain.fish.FishType;

import java.util.Optional;

public class FishTypeMapper {

    public static Optional<FishType> map(String name) {
        try {
            return Optional.of(FishType.valueOf(name));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
