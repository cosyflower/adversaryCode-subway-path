package subway.domain.subwayWeight;

public class Distance extends AbstractWeight<Distance> {
    private final double distanceValue;

    public Distance(double distanceValue) {
        this.distanceValue = distanceValue;
    }

    @Override
    public int compareTo(Distance otherDistance) {
        return (int) (distanceValue - otherDistance.distanceValue);
    }

    public double getDistanceValue() {
        return distanceValue;
    }
}
