package mission.ui;

import java.util.Map;
import mission.domain.fish.FishType;

public interface InputView {
    Map<FishType, Integer> inputFishRain();
}
