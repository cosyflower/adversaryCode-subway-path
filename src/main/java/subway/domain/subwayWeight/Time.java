package subway.domain.subwayWeight;

public class Time extends AbstractWeight<Time> {
    private final int timeValue;

    public Time(int timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public int compareTo(Time otherTime) {
        return timeValue - otherTime.timeValue;
    }
}
