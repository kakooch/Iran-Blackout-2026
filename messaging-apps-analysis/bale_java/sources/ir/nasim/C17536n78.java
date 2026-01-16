package ir.nasim;

import ir.nasim.C17536n78;
import java.util.List;
import livekit.org.webrtc.RTCStatsCollectorCallback;
import livekit.org.webrtc.RTCStatsReport;

/* renamed from: ir.nasim.n78, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17536n78 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final InterfaceC20315ro1 a;
    private final C21786u78 b;
    private UA2 c;
    private UA2 d;

    /* renamed from: ir.nasim.n78$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.n78$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(C17536n78 c17536n78, RTCStatsReport rTCStatsReport) {
            c17536n78.f(rTCStatsReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(C17536n78 c17536n78, RTCStatsReport rTCStatsReport) {
            c17536n78.e(rTCStatsReport);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C17536n78.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
            }
            while (AbstractC20906so1.g(interfaceC20315ro1)) {
                UA2 ua2 = C17536n78.this.c;
                if (ua2 != null) {
                    final C17536n78 c17536n78 = C17536n78.this;
                    ua2.invoke(new RTCStatsCollectorCallback() { // from class: ir.nasim.o78
                        @Override // livekit.org.webrtc.RTCStatsCollectorCallback
                        public final void onStatsDelivered(RTCStatsReport rTCStatsReport) {
                            C17536n78.b.z(c17536n78, rTCStatsReport);
                        }
                    });
                }
                UA2 ua22 = C17536n78.this.d;
                if (ua22 != null) {
                    final C17536n78 c17536n782 = C17536n78.this;
                    ua22.invoke(new RTCStatsCollectorCallback() { // from class: ir.nasim.p78
                        @Override // livekit.org.webrtc.RTCStatsCollectorCallback
                        public final void onStatsDelivered(RTCStatsReport rTCStatsReport) {
                            C17536n78.b.D(c17536n782, rTCStatsReport);
                        }
                    });
                }
                this.c = interfaceC20315ro1;
                this.b = 1;
                if (HG1.b(2000L, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C17536n78(InterfaceC20315ro1 interfaceC20315ro1, C21786u78 c21786u78, boolean z) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(c21786u78, "webRtcStatsRepository");
        this.a = interfaceC20315ro1;
        this.b = c21786u78;
        if (z) {
            try {
                i();
            } catch (Exception e2) {
                C19406qI3.a("MetricLogger", "MetricLogger crashed! " + e2.getMessage(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(RTCStatsReport rTCStatsReport) {
        List listD = AbstractC19309q78.d(rTCStatsReport);
        C19406qI3.a("MetricLogger", String.valueOf(listD), new Object[0]);
        this.b.c(listD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(RTCStatsReport rTCStatsReport) {
        List listC = AbstractC19309q78.c(rTCStatsReport);
        C19406qI3.a("MetricLogger", String.valueOf(listC), new Object[0]);
        this.b.b(listC);
    }

    private final void i() {
        AbstractC10533bm0.d(this.a, null, null, new b(null), 3, null);
    }

    public final void g(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "getStats");
        this.c = ua2;
    }

    public final void h(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "getStats");
        this.d = ua2;
    }
}
