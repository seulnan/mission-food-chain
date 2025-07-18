package mission.domain.fish.validate;

import mission.domain.fish.FishType;
import mission.domain.fish.exception.FishError;
import mission.domain.fish.exception.InvalidFishException;
import mission.domain.fish.utils.FishTypeMapper;

public class FishValidator {

    public static FishType mapAndValidate(String name) {
        return FishTypeMapper.map(name)
                .orElseThrow(() -> new InvalidFishException(FishError.INVALID_FISH_NAME));
    }
}
