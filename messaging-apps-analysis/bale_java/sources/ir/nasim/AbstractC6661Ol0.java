package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.Ol0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC6661Ol0 {
    private static final JJ0 a = new JJ0(-1, null, null, 0);
    public static final int b = AbstractC11490d57.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
    private static final int c = AbstractC11490d57.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND, 0, 0, 12, null);
    public static final C14539i47 d = new C14539i47("BUFFERED");
    private static final C14539i47 e = new C14539i47("SHOULD_BUFFER");
    private static final C14539i47 f = new C14539i47("S_RESUMING_BY_RCV");
    private static final C14539i47 g = new C14539i47("RESUMING_BY_EB");
    private static final C14539i47 h = new C14539i47("POISONED");
    private static final C14539i47 i = new C14539i47("DONE_RCV");
    private static final C14539i47 j = new C14539i47("INTERRUPTED_SEND");
    private static final C14539i47 k = new C14539i47("INTERRUPTED_RCV");
    private static final C14539i47 l = new C14539i47("CHANNEL_CLOSED");
    private static final C14539i47 m = new C14539i47("SUSPEND");
    private static final C14539i47 n = new C14539i47("SUSPEND_NO_WAITER");
    private static final C14539i47 o = new C14539i47("FAILED");
    private static final C14539i47 p = new C14539i47("NO_RECEIVE_RESULT");
    private static final C14539i47 q = new C14539i47("CLOSE_HANDLER_CLOSED");
    private static final C14539i47 r = new C14539i47("CLOSE_HANDLER_INVOKED");
    private static final C14539i47 s = new C14539i47("NO_CLOSE_CAUSE");

    /* renamed from: ir.nasim.Ol0$a */
    /* synthetic */ class a extends EB2 implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
            super(2, AbstractC6661Ol0.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return y(((Number) obj).longValue(), (JJ0) obj2);
        }

        public final JJ0 y(long j, JJ0 jj0) {
            return AbstractC6661Ol0.x(j, jj0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i2) {
        if (i2 == 0) {
            return 0L;
        }
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(HE0 he0, Object obj, UA2 ua2) {
        Object objC = he0.C(obj, null, ua2);
        if (objC == null) {
            return false;
        }
        he0.W(objC);
        return true;
    }

    static /* synthetic */ boolean C(HE0 he0, Object obj, UA2 ua2, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            ua2 = null;
        }
        return B(he0, obj, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j2, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j2, int i2) {
        return (i2 << 60) + j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JJ0 x(long j2, JJ0 jj0) {
        return new JJ0(j2, jj0, jj0.u(), 0);
    }

    public static final InterfaceC16733lm3 y() {
        return a.a;
    }

    public static final C14539i47 z() {
        return l;
    }
}
