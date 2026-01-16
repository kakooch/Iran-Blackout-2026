package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class OnlineTimeObject {
    public ApproximatePeriodEnum approximate_period;
    public long exact_time;
    public Type type;

    public enum ApproximatePeriodEnum {
        Recently,
        WeekAgo,
        MonthAgo,
        LongAgo
    }

    public enum Type {
        Exact,
        Approximate
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnlineTimeObject)) {
            return false;
        }
        OnlineTimeObject onlineTimeObject = (OnlineTimeObject) obj;
        Type type = this.type;
        if (type == onlineTimeObject.type) {
            if (type == Type.Approximate && this.approximate_period == onlineTimeObject.approximate_period) {
                return true;
            }
            if (type == Type.Exact && this.exact_time == onlineTimeObject.exact_time) {
                return true;
            }
        }
        return false;
    }
}
