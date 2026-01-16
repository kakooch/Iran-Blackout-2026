package io.livekit.android.room;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19039pg5;
import ir.nasim.AbstractC21618tq6;
import ir.nasim.ED1;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&%B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB7\b\u0011\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011HÁ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lio/livekit/android/room/RegionInfo;", "", "", "region", "url", "", "distance", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "", "seen1", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;JLir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "b", "(Lio/livekit/android/room/RegionInfo;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getRegion", "c", "J", "getDistance", "()J", "Companion", "$serializer", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final /* data */ class RegionInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final String region;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String url;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final long distance;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/livekit/android/room/RegionInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/livekit/android/room/RegionInfo;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer serializer() {
            return RegionInfo$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ RegionInfo(int i, String str, String str2, long j, AbstractC21618tq6 abstractC21618tq6) {
        if (7 != (i & 7)) {
            AbstractC19039pg5.a(i, 7, RegionInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.region = str;
        this.url = str2;
        this.distance = j;
    }

    public static final /* synthetic */ void b(RegionInfo self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        output.y(serialDesc, 0, self.region);
        output.y(serialDesc, 1, self.url);
        output.E(serialDesc, 2, self.distance);
    }

    /* renamed from: a, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegionInfo)) {
            return false;
        }
        RegionInfo regionInfo = (RegionInfo) other;
        return AbstractC13042fc3.d(this.region, regionInfo.region) && AbstractC13042fc3.d(this.url, regionInfo.url) && this.distance == regionInfo.distance;
    }

    public int hashCode() {
        return (((this.region.hashCode() * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.distance);
    }

    public String toString() {
        return "RegionInfo(region=" + this.region + ", url=" + this.url + ", distance=" + this.distance + ')';
    }

    public RegionInfo(String str, String str2, long j) {
        AbstractC13042fc3.i(str, "region");
        AbstractC13042fc3.i(str2, "url");
        this.region = str;
        this.url = str2;
        this.distance = j;
    }
}
