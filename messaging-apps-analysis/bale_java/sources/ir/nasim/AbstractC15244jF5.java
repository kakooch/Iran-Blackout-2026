package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import io.livekit.android.room.Room;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import livekit.LivekitMetrics$MetricSample;
import livekit.LivekitMetrics$TimeSeriesMetric;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.RTCStats;
import livekit.org.webrtc.RTCStatsCollectorCallback;
import livekit.org.webrtc.RTCStatsReport;

/* renamed from: ir.nasim.jF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC15244jF5 {
    private static final List a = AbstractC10360bX0.p(AbstractC4616Fw7.a(EnumC14646iF5.m, "cpu"), AbstractC4616Fw7.a(EnumC14646iF5.l, "bandwidth"), AbstractC4616Fw7.a(EnumC14646iF5.n, "other"));

    /* renamed from: ir.nasim.jF5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Room d;
        final /* synthetic */ io.livekit.android.room.f e;

        /* renamed from: ir.nasim.jF5$a$a, reason: collision with other inner class name */
        static final class C1311a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ Room c;
            final /* synthetic */ io.livekit.android.room.f d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1311a(Room room, io.livekit.android.room.f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = room;
                this.d = fVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1311a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Room room = this.c;
                    io.livekit.android.room.f fVar = this.d;
                    this.b = 1;
                    if (AbstractC15244jF5.d(room, fVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1311a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.jF5$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ Room c;
            final /* synthetic */ io.livekit.android.room.f d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Room room, io.livekit.android.room.f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = room;
                this.d = fVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Room room = this.c;
                    io.livekit.android.room.f fVar = this.d;
                    this.b = 1;
                    if (AbstractC15244jF5.e(room, fVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Room room, io.livekit.android.room.f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = room;
            this.e = fVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1311a(this.d, this.e, null), 3, null);
            return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(this.d, this.e, null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jF5$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC15244jF5.d(null, null, this);
        }
    }

    /* renamed from: ir.nasim.jF5$c */
    static final class c implements RTCStatsCollectorCallback {
        final /* synthetic */ HE0 a;

        c(HE0 he0) {
            this.a = he0;
        }

        @Override // livekit.org.webrtc.RTCStatsCollectorCallback
        public final void onStatsDelivered(RTCStatsReport rTCStatsReport) {
            this.a.resumeWith(C9475a16.b(rTCStatsReport));
        }
    }

    /* renamed from: ir.nasim.jF5$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC15244jF5.e(null, null, this);
        }
    }

    /* renamed from: ir.nasim.jF5$e */
    static final class e implements RTCStatsCollectorCallback {
        final /* synthetic */ HE0 a;

        e(HE0 he0) {
            this.a = he0;
        }

        @Override // livekit.org.webrtc.RTCStatsCollectorCallback
        public final void onStatsDelivered(RTCStatsReport rTCStatsReport) {
            this.a.resumeWith(C9475a16.b(rTCStatsReport));
        }
    }

    public static final Object c(Room room, io.livekit.android.room.f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new a(room, fVar, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:13|(2:52|14)|15|50|38|(3:40|23|(2:25|(1:27)(11:28|29|(1:31)|(1:33)|34|35|(1:37)|15|50|38|(1:41)(0)))(2:48|49))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0112, code lost:
    
        r14 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0108 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0111 A[Catch: Exception -> 0x0112, TRY_LEAVE, TryCatch #0 {Exception -> 0x0112, blocks: (B:38:0x0109, B:41:0x0111), top: B:50:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0106 -> B:15:0x003c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0121 -> B:23:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0127 -> B:23:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0129 -> B:23:0x006a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(io.livekit.android.room.Room r12, io.livekit.android.room.f r13, ir.nasim.InterfaceC20295rm1 r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15244jF5.d(io.livekit.android.room.Room, io.livekit.android.room.f, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:13|(2:52|14)|15|50|38|(3:40|23|(2:25|(1:27)(11:28|29|(1:31)|(1:33)|34|35|(1:37)|15|50|38|(1:41)(0)))(2:48|49))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0126, code lost:
    
        r14 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0125 A[Catch: Exception -> 0x0126, TRY_LEAVE, TryCatch #0 {Exception -> 0x0126, blocks: (B:38:0x011d, B:41:0x0125), top: B:50:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x011a -> B:15:0x003c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0135 -> B:23:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x013b -> B:23:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x013d -> B:23:0x006a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(io.livekit.android.room.Room r12, io.livekit.android.room.f r13, ir.nasim.InterfaceC20295rm1 r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15244jF5.e(io.livekit.android.room.Room, io.livekit.android.room.f, ir.nasim.rm1):java.lang.Object");
    }

    private static final LivekitMetrics$MetricSample f(long j, Number number) {
        LivekitMetrics$MetricSample.a aVarNewBuilder = LivekitMetrics$MetricSample.newBuilder();
        aVarNewBuilder.A(j);
        aVarNewBuilder.B(number.floatValue());
        LivekitMetrics$MetricSample livekitMetrics$MetricSample = (LivekitMetrics$MetricSample) aVarNewBuilder.a();
        AbstractC13042fc3.h(livekitMetrics$MetricSample, "with(...)");
        return livekitMetrics$MetricSample;
    }

    private static final LivekitMetrics$TimeSeriesMetric g(IE3 ie3, List list, List list2, String str, String str2, String str3) {
        LivekitMetrics$TimeSeriesMetric.a aVarNewBuilder = LivekitMetrics$TimeSeriesMetric.newBuilder();
        aVarNewBuilder.B(ie3.getNumber());
        if (str != null) {
            aVarNewBuilder.C(l(list, str));
        }
        if (str2 != null) {
            aVarNewBuilder.E(l(list, str2));
        }
        if (str3 != null) {
            aVarNewBuilder.D(l(list, str3));
        }
        aVarNewBuilder.A(list2);
        LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetric = (LivekitMetrics$TimeSeriesMetric) aVarNewBuilder.a();
        AbstractC13042fc3.h(livekitMetrics$TimeSeriesMetric, "with(...)");
        return livekitMetrics$TimeSeriesMetric;
    }

    private static final LivekitMetrics$TimeSeriesMetric h(RTCStats rTCStats, EnumC14646iF5 enumC14646iF5, List list, String str) {
        Object obj = rTCStats.getMembers().get(enumC14646iF5.p());
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number == null) {
            return null;
        }
        Object obj2 = rTCStats.getMembers().get("trackIdentifier");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null) {
            return null;
        }
        Object obj3 = rTCStats.getMembers().get(DialogEntity.COLUMN_RID);
        return g(enumC14646iF5.j(), list, AbstractC9766aX0.e(f(n(Double.valueOf(rTCStats.getTimestampUs())), number)), str, str2, obj3 instanceof String ? (String) obj3 : null);
    }

    private static final List i(List list, Room room, RTCStatsReport rTCStatsReport, String str) {
        Collection<RTCStats> collectionValues = rTCStatsReport.getStatsMap().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            RTCStats rTCStats = (RTCStats) obj;
            if (AbstractC13042fc3.d(rTCStats.getType(), "media-source") && AbstractC13042fc3.d(rTCStats.getMembers().get("kind"), MediaStreamTrack.VIDEO_TRACK_KIND)) {
                arrayList.add(obj);
            }
        }
        Collection<RTCStats> collectionValues2 = rTCStatsReport.getStatsMap().values();
        ArrayList<RTCStats> arrayList2 = new ArrayList();
        for (Object obj2 : collectionValues2) {
            RTCStats rTCStats2 = (RTCStats) obj2;
            if (AbstractC13042fc3.d(rTCStats2.getType(), "outbound-rtp") && AbstractC13042fc3.d(rTCStats2.getMembers().get("kind"), MediaStreamTrack.VIDEO_TRACK_KIND)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList<XV4> arrayList3 = new ArrayList();
        for (RTCStats rTCStats3 : arrayList2) {
            AbstractC13042fc3.f(rTCStats3);
            XV4 xv4A = AbstractC4616Fw7.a(rTCStats3, m(room, arrayList, rTCStats3));
            if (xv4A != null) {
                arrayList3.add(xv4A);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (XV4 xv4 : arrayList3) {
            RTCStats rTCStats4 = (RTCStats) xv4.a();
            String str2 = (String) xv4.b();
            Object obj3 = rTCStats4.getMembers().get("qualityLimitationDurations");
            Map map = obj3 instanceof Map ? (Map) obj3 : null;
            if (map == null) {
                return AbstractC10360bX0.m();
            }
            Object obj4 = rTCStats4.getMembers().get(DialogEntity.COLUMN_RID);
            String str3 = obj4 instanceof String ? (String) obj4 : null;
            List<XV4> list2 = a;
            ArrayList arrayList5 = new ArrayList();
            for (XV4 xv42 : list2) {
                EnumC14646iF5 enumC14646iF5 = (EnumC14646iF5) xv42.a();
                Object obj5 = map.get((String) xv42.b());
                Number number = obj5 instanceof Number ? (Number) obj5 : null;
                LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetricG = number == null ? null : g(enumC14646iF5.j(), list, AbstractC9766aX0.e(f(n(Double.valueOf(rTCStats4.getTimestampUs())), number)), str, str2, str3);
                if (livekitMetrics$TimeSeriesMetricG != null) {
                    arrayList5.add(livekitMetrics$TimeSeriesMetricG);
                }
            }
            AbstractC13610gX0.D(arrayList4, arrayList5);
        }
        return arrayList4;
    }

    private static final List j(List list, RTCStatsReport rTCStatsReport, String str) {
        Map<String, RTCStats> statsMap = rTCStatsReport.getStatsMap();
        AbstractC13042fc3.h(statsMap, "getStatsMap(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, RTCStats> entry : statsMap.entrySet()) {
            RTCStats value = entry.getValue();
            if (AbstractC13042fc3.d(value.getType(), "inbound-rtp") && AbstractC13042fc3.d(value.getMembers().get("kind"), MediaStreamTrack.AUDIO_TRACK_KIND)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection<RTCStats> collectionValues = linkedHashMap.values();
        ArrayList arrayList = new ArrayList();
        for (RTCStats rTCStats : collectionValues) {
            List<EnumC14646iF5> listP = AbstractC10360bX0.p(EnumC14646iF5.g, EnumC14646iF5.i, EnumC14646iF5.h, EnumC14646iF5.j, EnumC14646iF5.k);
            ArrayList arrayList2 = new ArrayList();
            for (EnumC14646iF5 enumC14646iF5 : listP) {
                AbstractC13042fc3.f(rTCStats);
                LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetricH = h(rTCStats, enumC14646iF5, list, str);
                if (livekitMetrics$TimeSeriesMetricH != null) {
                    arrayList2.add(livekitMetrics$TimeSeriesMetricH);
                }
            }
            AbstractC13610gX0.D(arrayList, arrayList2);
        }
        return arrayList;
    }

    private static final List k(List list, RTCStatsReport rTCStatsReport, String str) {
        Map<String, RTCStats> statsMap = rTCStatsReport.getStatsMap();
        AbstractC13042fc3.h(statsMap, "getStatsMap(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, RTCStats> entry : statsMap.entrySet()) {
            RTCStats value = entry.getValue();
            if (AbstractC13042fc3.d(value.getType(), "inbound-rtp") && AbstractC13042fc3.d(value.getMembers().get("kind"), MediaStreamTrack.VIDEO_TRACK_KIND)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection<RTCStats> collectionValues = linkedHashMap.values();
        ArrayList arrayList = new ArrayList();
        for (RTCStats rTCStats : collectionValues) {
            List<EnumC14646iF5> listP = AbstractC10360bX0.p(EnumC14646iF5.c, EnumC14646iF5.d, EnumC14646iF5.e, EnumC14646iF5.f, EnumC14646iF5.j, EnumC14646iF5.k);
            ArrayList arrayList2 = new ArrayList();
            for (EnumC14646iF5 enumC14646iF5 : listP) {
                AbstractC13042fc3.f(rTCStats);
                LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetricH = h(rTCStats, enumC14646iF5, list, str);
                if (livekitMetrics$TimeSeriesMetricH != null) {
                    arrayList2.add(livekitMetrics$TimeSeriesMetricH);
                }
            }
            AbstractC13610gX0.D(arrayList, arrayList2);
        }
        return arrayList;
    }

    private static final int l(List list, String str) {
        int iIndexOf = list.indexOf(str);
        if (iIndexOf == -1) {
            list.add(str);
            iIndexOf = list.size() - 1;
        }
        return iIndexOf + IE3.METRIC_LABEL_PREDEFINED_MAX_VALUE.getNumber();
    }

    private static final String m(Room room, List list, RTCStats rTCStats) {
        Object next;
        Object obj;
        Object next2;
        MediaStreamTrack mediaStreamTrackH;
        Object obj2 = rTCStats.getMembers().get("mediaSourceId");
        if (obj2 == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((RTCStats) next).getId(), obj2)) {
                break;
            }
        }
        RTCStats rTCStats2 = (RTCStats) next;
        if (rTCStats2 == null || (obj = rTCStats2.getMembers().get("trackIdentifier")) == null) {
            return null;
        }
        Iterator it2 = room.B0().s().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            AbstractC21649tt7 abstractC21649tt7 = (AbstractC21649tt7) ((XV4) next2).b();
            if (AbstractC13042fc3.d((abstractC21649tt7 == null || (mediaStreamTrackH = abstractC21649tt7.h()) == null) ? null : mediaStreamTrackH.id(), obj)) {
                break;
            }
        }
        XV4 xv4 = (XV4) next2;
        if (xv4 == null) {
            return null;
        }
        return ((AbstractC4838Gt7) xv4.a()).e();
    }

    private static final long n(Number number) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return timeUnit.convert(number.longValue(), timeUnit);
    }
}
