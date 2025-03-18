package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StudyCafeLockerPasses 테스트")
class StudyCafeLockerPassesTest {

    @Test
    @DisplayName("조건에 맞는 locker pass가 존재하면 반환한다.")
    void testFindLockerPassByFound() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 10, 200, 0.0);
        StudyCafeLockerPass lockerPass1 = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 5, 100);
        StudyCafeLockerPass lockerPass2 = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 10, 150);
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(
            List.of(lockerPass1, lockerPass2));

        // when
        Optional<StudyCafeLockerPass> found = lockerPasses.findLockerPassBy(seatPass);

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getDuration()).isEqualTo(10);
    }

    @Test
    @DisplayName("조건에 맞는 locker pass가 없으면 빈 Optional 반환한다.")
    void testFindLockerPassByNotFound() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 10, 200, 0.0);
        StudyCafeLockerPass lockerPass1 = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 5, 100);
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(List.of(lockerPass1));

        // when
        Optional<StudyCafeLockerPass> found = lockerPasses.findLockerPassBy(seatPass);

        // then
        assertThat(found).isNotPresent();
    }
}
