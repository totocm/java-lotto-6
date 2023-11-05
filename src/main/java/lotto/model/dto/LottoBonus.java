package lotto.model.dto;

import lotto.service.exceptionhandler.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

@DisplayName("사용자가 구매하는 보너스 로또 번호 저장")
public class LottoBonus extends Lotto{
    private final List<Integer> number;
    public LottoBonus (List<Integer> number){
        super(number);
        validate(number);
        this.number = number;
    }
    private void validate(List<Integer> number){
        if(number.size() != LOTTO_BONUS_CHOICE_NUMBER_VALUE_OF_ONE){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_NOT_CHOICE_ONE_NUMBER_MESSAGE);
        }
        if(number.stream().distinct().count() != LOTTO_BONUS_CHOICE_NUMBER_VALUE_OF_ONE){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_NOT_CHOICE_ONE_NUMBER_MESSAGE);
        }
        number.forEach(this::validateRange);
    }
    @Override
    public void validateRange(int number){}
    @Override
    public String toString(){
        return String.valueOf(number.get(0));
    }
    private static final int LOTTO_BONUS_CHOICE_NUMBER_VALUE_OF_ONE = 1;
}
