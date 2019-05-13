package ladder;

import ladder.domain.*;
import ladder.domain.generator.LadderGenerator;
import ladder.support.FixedLadderGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 높이4_참여자3_사다리게임_플레이_결과() {
        // given
        Players players = Players.valueOfComma("일,이,삼");
        BetItems betItems = BetItems.valueOfComma("1,2,3");

        LadderGenerator ladderGenerator = new FixedLadderGenerator();
        LadderGame ladderGame = new LadderGame(ladderGenerator);
        ladderGame.init(3, 4);
        // when
        GameResults gameResults = ladderGame.play(players, betItems);
        // then
        assertThat(gameResults.match("일").size()).isEqualTo(1);
        assertThat(gameResults.match("이").size()).isEqualTo(1);
        assertThat(gameResults.match("삼").size()).isEqualTo(1);

        assertThat(gameResults.find("일").toString().trim()).isEqualTo("1");
        assertThat(gameResults.find("이").toString().trim()).isEqualTo("2");
        assertThat(gameResults.find("삼").toString().trim()).isEqualTo("3");
    }
}
