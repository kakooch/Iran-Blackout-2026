package io.livekit.android.room;

import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19039pg5;
import ir.nasim.AbstractC21618tq6;
import ir.nasim.ED1;
import ir.nasim.JJ;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import livekit.LivekitRtc$RegionInfo;
import livekit.LivekitRtc$RegionSettings;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002\"!B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0011\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fHÁ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/livekit/android/room/RegionSettings;", "", "", "Lio/livekit/android/room/RegionInfo;", "regions", "<init>", "(Ljava/util/List;)V", "", "seen1", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/util/List;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "c", "(Lio/livekit/android/room/RegionSettings;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "Companion", "$serializer", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final /* data */ class RegionSettings {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] b = {new JJ(RegionInfo$$serializer.INSTANCE)};

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final List regions;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/livekit/android/room/RegionSettings$Companion;", "", "<init>", "()V", "Llivekit/LivekitRtc$RegionSettings;", "proto", "Lio/livekit/android/room/RegionSettings;", "a", "(Llivekit/LivekitRtc$RegionSettings;)Lio/livekit/android/room/RegionSettings;", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public final RegionSettings a(LivekitRtc$RegionSettings proto) {
            AbstractC13042fc3.i(proto, "proto");
            List<LivekitRtc$RegionInfo> regionsList = proto.getRegionsList();
            AbstractC13042fc3.h(regionsList, "getRegionsList(...)");
            List<LivekitRtc$RegionInfo> list = regionsList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (LivekitRtc$RegionInfo livekitRtc$RegionInfo : list) {
                String region = livekitRtc$RegionInfo.getRegion();
                AbstractC13042fc3.h(region, "getRegion(...)");
                String url = livekitRtc$RegionInfo.getUrl();
                AbstractC13042fc3.h(url, "getUrl(...)");
                arrayList.add(new RegionInfo(region, url, livekitRtc$RegionInfo.getDistance()));
            }
            return new RegionSettings(arrayList);
        }

        public final KSerializer serializer() {
            return RegionSettings$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ RegionSettings(int i, List list, AbstractC21618tq6 abstractC21618tq6) {
        if (1 != (i & 1)) {
            AbstractC19039pg5.a(i, 1, RegionSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.regions = list;
    }

    /* renamed from: b, reason: from getter */
    public final List getRegions() {
        return this.regions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RegionSettings) && AbstractC13042fc3.d(this.regions, ((RegionSettings) other).regions);
    }

    public int hashCode() {
        return this.regions.hashCode();
    }

    public String toString() {
        return "RegionSettings(regions=" + this.regions + ')';
    }

    public RegionSettings(List list) {
        AbstractC13042fc3.i(list, "regions");
        this.regions = list;
    }
}
