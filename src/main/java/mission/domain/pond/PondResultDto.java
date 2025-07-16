package mission.domain.pond;

public class PondResultDto {
    private final int survivalDays;

    public PondResultDto(int survivalDays) {
        this.survivalDays = survivalDays;
    }

    public int getSurvivalDays() {
        return survivalDays;
    }
}
