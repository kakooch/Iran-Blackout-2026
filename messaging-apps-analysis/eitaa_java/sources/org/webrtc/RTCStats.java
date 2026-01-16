package org.webrtc;

import java.util.Map;

/* loaded from: classes3.dex */
public class RTCStats {
    private final String id;
    private final Map<String, Object> members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long timestampUs, String type, String id, Map<String, Object> members) {
        this.timestampUs = timestampUs;
        this.type = type;
        this.id = id;
        this.members = members;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public Map<String, Object> getMembers() {
        return this.members;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", id: ");
        sb.append(this.id);
        for (Map.Entry<String, Object> entry : this.members.entrySet()) {
            sb.append(", ");
            sb.append(entry.getKey());
            sb.append(": ");
            appendValue(sb, entry.getValue());
        }
        sb.append(" }");
        return sb.toString();
    }

    private static void appendValue(StringBuilder builder, Object value) {
        if (value instanceof Object[]) {
            Object[] objArr = (Object[]) value;
            builder.append('[');
            for (int i = 0; i < objArr.length; i++) {
                if (i != 0) {
                    builder.append(", ");
                }
                appendValue(builder, objArr[i]);
            }
            builder.append(']');
            return;
        }
        if (value instanceof String) {
            builder.append('\"');
            builder.append(value);
            builder.append('\"');
            return;
        }
        builder.append(value);
    }

    @CalledByNative
    static RTCStats create(long timestampUs, String type, String id, Map members) {
        return new RTCStats(timestampUs, type, id, members);
    }
}
