package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    static private final InputView inputView = new InputView();
    static private final OutputView outputView = new OutputView();
    static private final BridgeGame bridgeGame = new BridgeGame();
    static private final InputValidate inputValidate = new InputValidate();
    static private final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            bridgeGame.getBridge(new BridgeRandomNumberGenerator(), readBridgeSize());
            printResult(run());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
        }
    }

    private static void printResult(int counter) {
        outputView.printResult(bridgeGame.getString(), bridgeGame.gameResult());
        outputView.printChance(counter);
    }

    private static int readBridgeSize() {
        return inputValidate.validateBridgeSize(inputView.readBridgeSize());
    }

    private static String readGameCommand() {
        return inputValidate.validateRetry(inputView.readGameCommand());
    }

    private static String readMoving() {
        return inputValidate.validateMove(inputView.readMoving());
    }

    private static int run() {
        int counter = 0;
        do {
            move();
            counter++;
        } while (!bridgeGame.gameResult() && bridgeGame.retry(readGameCommand()));
        return counter;
    }

    private static void move() {
        boolean result;
        do {
            result = bridgeGame.move(readMoving());
            outputView.printMap(bridgeGame.getString());
        } while (result && !bridgeGame.gameResult());
    }
}
