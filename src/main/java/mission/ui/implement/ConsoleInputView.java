package mission.ui.implement;

import mission.domain.fish.utils.FishParser;
import mission.domain.fish.FishType;
import mission.ui.InputView;
import mission.ui.exception.InvalidInputException;

import java.util.Map;
import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Map<FishType, Integer> inputFishRain() {
        System.out.println("물고기 비로 내릴 물고기를 입력해주세요. (ex. [정어리-5],[고등어-2])");
        String input = scanner.nextLine();

        try {
            return FishParser.parse(input);
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
