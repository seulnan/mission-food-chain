package mission.domain.pond;

import java.util.Comparator;
import mission.domain.fish.FishRepository;
import mission.domain.fish.FishType;


public class Pond {

    private final FishRepository fishRepository;

    public Pond(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    public int simulate() {
        int days = 0;

        while (fishRepository.hasLivingPredators()) {
            simulateOneDay();
            days++;
        }

        return days;
    }

    private void simulateOneDay() {
        fishRepository.getSnapshot().entrySet().stream()
                .filter(entry -> !entry.getKey().getNutritionLevel().isExcludedFromSurvivalCalculation())
                .sorted(Comparator.comparingInt(e -> e.getKey().getId()))
                .forEach(entry -> feedAndFilterHungryFish(entry.getKey(), entry.getValue()));
    }

    private void feedAndFilterHungryFish(FishType predatorType, int count) {
        long fedCount =
                java.util.stream.IntStream.range(0, count)
                        .filter(i -> fishRepository.feed(predatorType).isPresent())
                        .count();

        fishRepository.removeIfHungry(predatorType, (int) fedCount);
    }

}
