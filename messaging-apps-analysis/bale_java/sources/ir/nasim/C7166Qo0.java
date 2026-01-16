package ir.nasim;

import java.util.Map;
import livekit.LivekitModels$DataStream;

/* renamed from: ir.nasim.Qo0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7166Qo0 extends VX6 {
    private final String f;
    private final String g;
    private final long h;
    private final Long i;
    private final Map j;
    private final String k;
    private final String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7166Qo0(String str, String str2, long j, Long l, Map map, String str3, String str4) {
        super(str, str2, j, l, map, null);
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(str2, "topic");
        AbstractC13042fc3.i(map, "attributes");
        AbstractC13042fc3.i(str3, "mimeType");
        this.f = str;
        this.g = str2;
        this.h = j;
        this.i = l;
        this.j = map;
        this.k = str3;
        this.l = str4;
    }

    @Override // ir.nasim.VX6
    public String a() {
        return this.f;
    }

    @Override // ir.nasim.VX6
    public String b() {
        return this.g;
    }

    @Override // ir.nasim.VX6
    public Long c() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7166Qo0)) {
            return false;
        }
        C7166Qo0 c7166Qo0 = (C7166Qo0) obj;
        return AbstractC13042fc3.d(this.f, c7166Qo0.f) && AbstractC13042fc3.d(this.g, c7166Qo0.g) && this.h == c7166Qo0.h && AbstractC13042fc3.d(this.i, c7166Qo0.i) && AbstractC13042fc3.d(this.j, c7166Qo0.j) && AbstractC13042fc3.d(this.k, c7166Qo0.k) && AbstractC13042fc3.d(this.l, c7166Qo0.l);
    }

    public int hashCode() {
        int iHashCode = ((((this.f.hashCode() * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31;
        Long l = this.i;
        int iHashCode2 = (((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        String str = this.l;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ByteStreamInfo(id=" + this.f + ", topic=" + this.g + ", timestampMs=" + this.h + ", totalSize=" + this.i + ", attributes=" + this.j + ", mimeType=" + this.k + ", name=" + this.l + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C7166Qo0(LivekitModels$DataStream.Header header, LivekitModels$DataStream.ByteHeader byteHeader) {
        AbstractC13042fc3.i(header, "header");
        AbstractC13042fc3.i(byteHeader, "byteHeader");
        String streamId = header.getStreamId();
        AbstractC13042fc3.h(streamId, "getStreamId(...)");
        String topic = header.getTopic();
        AbstractC13042fc3.h(topic, "getTopic(...)");
        long timestamp = header.getTimestamp();
        Long lValueOf = header.hasTotalLength() ? Long.valueOf(header.getTotalLength()) : null;
        Map<String, String> attributesMap = header.getAttributesMap();
        AbstractC13042fc3.h(attributesMap, "getAttributesMap(...)");
        Map mapY = AbstractC20051rO3.y(attributesMap);
        String mimeType = header.getMimeType();
        AbstractC13042fc3.h(mimeType, "getMimeType(...)");
        this(streamId, topic, timestamp, lValueOf, mapY, mimeType, byteHeader.getName());
    }
}
