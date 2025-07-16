package mission.domain.pond;

import mission.domain.fish.Fish;
import mission.domain.fish.FishRepository;
import mission.domain.fish.FishType;

import java.util.Map;

public class Pond {

    private final FishRepository fishRepository;

    public Pond(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    public int simulate() {
        int days = 0;

        while (fishRepository.hasLivingPredators()) {
            Map<FishType, Integer> snapshot = fishRepository.getSnapshot();

            for (FishType predatorType : snapshot.keySet()) {
                int count = snapshot.get(predatorType);
                if (predatorType.getNutritionLevel().isExcludedFromSurvivalCalculation()) {
                    continue;
                }

                int fed = 0;
                for (int i = 0; i < count; i++) {
                    // 먹이를 먹은 경우만 fed++
                    if (fishRepository.feed(predatorType).isPresent()) {
                        fed++;
                    }
                }

                fishRepository.removeIfHungry(predatorType, fed);
            }

            days++;
        }

        return days;
    }
}
