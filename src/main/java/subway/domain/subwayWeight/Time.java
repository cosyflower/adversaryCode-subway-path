package subway.domain.subwayWeight;

public class Time extends AbstractWeight<Time> {
    private final double timeValue;

    public Time(double timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public int compareTo(Time otherTime) {
        return (int) (timeValue - otherTime.timeValue);
    }

    public double getTimeValue() {
        return timeValue;
    }
}
