package racingcar.utils;

import racingcar.constant.ErrorMessage;

import java.util.Arrays;

public class ValidationUtil {
    private static final int MIN_RACING_CAR_COUNT = 2;
    private static final int MAX_LENGTH = 5;

    private ValidationUtil() {
    }

    public static String racingCarValidator(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
        }
        if(!isInMaxLength(input)){
            throw new IllegalArgumentException(ErrorMessage.MAX_LENGTH_ERROR_MESSAGE);
        }

        return input;
    }

    // 입력된 자동차가 2대보다 작을 경우
    public static void racingCarCountValidator(String[] catList) {
        if (catList.length < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.RACING_CAR_COUNT_ERROR_MESSAGE, MIN_RACING_CAR_COUNT));
        }
    }

    public static void duplicationValidator(String[] carList) {
        long distinctCount = Arrays.stream(carList)
                .distinct()
                .count();

        if (distinctCount < carList.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static boolean isEmpty(String input){
        return input.length() == 0;
    }

    private static boolean isInMaxLength(String input) {
        return input.length() <= MAX_LENGTH;
    }
}