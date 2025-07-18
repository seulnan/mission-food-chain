package mission.controller.implement;

import java.util.Map;
import mission.controller.Controller;
import mission.domain.fish.FishType;
import mission.domain.fish.utils.FishParser;
import mission.domain.pond.PondResultDto;
import mission.domain.pond.PondService;
import mission.ui.InputView;
import mission.ui.OutputView;

public class FishController implements Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final PondService pondService;

    public FishController(InputView inputView, OutputView outputView, PondService pondService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pondService = pondService;
    }

    @Override
    public void run() {
        try {
            Map<String, Integer> nameToCount = inputView.inputFishRain();
            Map<FishType, Integer> fishCounts = FishParser.toFishTypeMap(nameToCount);

            pondService.initializeFish(fishCounts);

            PondResultDto result = pondService.simulate();
            outputView.printSurvivalResult(result.survivalDays());

        } catch (Exception e) {
            outputView.printError(e);
        }
    }
}
