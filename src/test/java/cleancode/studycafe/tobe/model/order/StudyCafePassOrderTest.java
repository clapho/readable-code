package cleancode.studycafe.tobe.model.order;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StudyCafePassOrder 테스트")
class StudyCafePassOrderTest {

    @Test
    @DisplayName("locker pass가 있을 때, 총 결제 금액 계산이 올바르게 수행된다.")
    void testTotalPriceWithLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 10, 200, 0.25);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 10, 100);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(250);
    }

    @Test
    @DisplayName("locker pass가 없을 때, 총 결제 금액 계산이 올바르게 수행된다.")
    void testTotalPriceWithoutLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 5, 200, 0.25);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        // when
        int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(150);
    }

    @Test
    @DisplayName("할인 금액 반환 값을 검증한다.")
    void testGetDiscountPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 400, 0.1);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        // when
        int discountPrice = order.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(40);
    }
}
