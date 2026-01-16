package org.webrtc;

/* loaded from: classes3.dex */
public class StatsReport {
    public final String id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    public static class Value {
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String toString() {
            return "[" + this.name + ": " + this.value + "]";
        }
    }

    @CalledByNative
    public StatsReport(String id, String type, double timestamp, Value[] values) {
        this.id = id;
        this.type = type;
        this.timestamp = timestamp;
        this.values = values;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", timestamp: ");
        sb.append(this.timestamp);
        sb.append(", values: ");
        int i = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i < valueArr.length) {
                sb.append(valueArr[i].toString());
                sb.append(", ");
                i++;
            } else {
                return sb.toString();
            }
        }
    }
}
