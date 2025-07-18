package mission.domain.fish.utils;

import java.util.Arrays;
import mission.domain.fish.FishType;

public class FishTypeMapper {

    public static FishType fromName(String name) {
        return Arrays.stream(FishType.values())
                .filter(fish -> fish.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 물고기 이름입니다: " + name));
    }
}
