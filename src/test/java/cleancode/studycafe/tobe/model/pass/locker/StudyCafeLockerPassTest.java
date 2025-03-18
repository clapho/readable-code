package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StudyCafeLockerPass 테스트")
class StudyCafeLockerPassTest {

    @Test
    @DisplayName("동일한 pass type 비교 시 true 반환한다.")
    void testIsSamePassTypeTrue() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 10, 150);

        // when
        boolean result = lockerPass.isSamePassType(StudyCafePassType.FIXED);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("기간 비교 시 동일하면 true, 다르면 false 반환한다.")
    void testIsSameDuration() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 10, 150);

        // when
        boolean resultMatching = lockerPass.isSameDuration(10);
        boolean resultDifferent = lockerPass.isSameDuration(5);

        // then
        assertThat(resultMatching).isTrue();
        assertThat(resultDifferent).isFalse();
    }
}
