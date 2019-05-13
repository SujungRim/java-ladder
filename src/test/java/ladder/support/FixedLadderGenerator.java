package ladder.support;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.LinkedType;
import ladder.domain.Point;
import ladder.domain.generator.LadderGenerator;

import java.util.Arrays;
import java.util.List;

public class FixedLadderGenerator implements LadderGenerator {
    @Override
    public Ladder generate(int countOfPerson, int height) {
        List<Point> firstLinkOfThreePoints = Arrays.asList(
                new Point(0, LinkedType.ONLY_RIGHT_LINKED),
                new Point(1, LinkedType.ONLY_LEFT_LINKED),
                new Point(2, LinkedType.NEITHER_LINKED));
        List<Point> secondLinkOfThreePoints = Arrays.asList(
                new Point(0, LinkedType.NEITHER_LINKED),
                new Point(1, LinkedType.ONLY_RIGHT_LINKED),
                new Point(2, LinkedType.ONLY_LEFT_LINKED));
        Line firstLinkOfLine = new Line(firstLinkOfThreePoints);
        Line secondLinkOfLine = new Line(secondLinkOfThreePoints);
        List<Line> lines = Arrays.asList(firstLinkOfLine, firstLinkOfLine, secondLinkOfLine, secondLinkOfLine);

        return new Ladder(lines);
    }
}
