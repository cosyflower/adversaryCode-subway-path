package subway.domain.subwayWeight;

public class Distance extends AbstractWeight<Distance> {
    private final int distanceValue;

    public Distance(int distanceValue) {
        this.distanceValue = distanceValue;
    }

    @Override
    public int compareTo(Distance otherDistance) {
        return distanceValue - otherDistance.distanceValue;
    }
}
