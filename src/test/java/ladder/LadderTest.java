package ladder;

import ladder.domain.Ladder;
import ladder.domain.generator.LadderGenerator;
import ladder.domain.generator.RandomLadderGenerator;
import ladder.domain.generator.RandomLineGenerator;
import ladder.domain.generator.RandomValueGenerator;
import ladder.support.FixedLadderGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 높이5_참여자5인_사다리() {
        // given
        LadderGenerator ladderGenerator = new RandomLadderGenerator(new RandomLineGenerator(new RandomValueGenerator()));
        // when
        Ladder ladder = ladderGenerator.generate(5, 5);
        // then
        System.out.println(ladder);
        assertThat(ladder.getNumberOfLines()).isEqualTo(5);
        assertThat(ladder.getCountOfPoints()).isEqualTo(5);
    }

    @Test
    public void 높이4_참여자3_고정사다리에서_이동하기() {
        // given
        LadderGenerator ladderGenerator = new FixedLadderGenerator();
        Ladder ladder = ladderGenerator.generate(3, 4);
        // then
        System.out.println(ladder);
        System.out.println(ladder.descend(1));
        assertThat(ladder.descend(1)).isEqualTo(1);
    }
}

