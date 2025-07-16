package mission.controller.implement;

import mission.controller.Controller;
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
            var fishCounts = inputView.inputFishRain();
            pondService.initializeFish(fishCounts);

            PondResultDto result = pondService.simulate();
            outputView.printSurvivalResult(result.getSurvivalDays());

        } catch (Exception e) {
            outputView.printError(e);
        }
    }
}
