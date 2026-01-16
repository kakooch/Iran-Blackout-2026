package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Hu0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5074Hu0 {
    public static final C5074Hu0 a = new C5074Hu0();

    /* renamed from: ir.nasim.Hu0$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC22288uz0.values().length];
            try {
                iArr[EnumC22288uz0.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC22288uz0.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC22288uz0.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC22288uz0.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC22288uz0.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC22288uz0.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    private C5074Hu0() {
    }

    public final void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 3)));
                return;
            } else {
                C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 5)));
                return;
            }
        }
        if (z) {
            C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 3)));
        } else {
            C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 5)));
        }
    }

    public final void b(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 2)));
                return;
            } else {
                C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 4)));
                return;
            }
        }
        if (z) {
            C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 2)));
        } else {
            C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 4)));
        }
    }

    public final void c(long j, long j2, long j3) {
        C3343Am.i("call_poor_connection", AbstractC20051rO3.n(AbstractC4616Fw7.a("call_id", Long.valueOf(j)), AbstractC4616Fw7.a("disconnect_time", Long.valueOf(j2)), AbstractC4616Fw7.a("reconnected_time", Long.valueOf(j3))));
    }

    public final void d(EnumC22288uz0 enumC22288uz0, boolean z) {
        AbstractC13042fc3.i(enumC22288uz0, "callStartOrigin");
        if (z) {
            switch (a.a[enumC22288uz0.ordinal()]) {
                case 1:
                    C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 0)));
                    return;
                case 2:
                    C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 1)));
                    return;
                case 3:
                    C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 6)));
                    return;
                case 4:
                    C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 7)));
                    return;
                case 5:
                    C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 9)));
                    return;
                case 6:
                    C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 10)));
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        switch (a.a[enumC22288uz0.ordinal()]) {
            case 1:
                C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 0)));
                return;
            case 2:
                C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 1)));
                return;
            case 3:
                C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 6)));
                return;
            case 4:
                C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 7)));
                return;
            case 5:
                C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 9)));
                return;
            case 6:
                C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 10)));
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void e(long j, long j2, boolean z) {
        C3343Am.i("call_start_to_connect", AbstractC20051rO3.n(AbstractC4616Fw7.a("call_id", Long.valueOf(j)), AbstractC4616Fw7.a("duration", Long.valueOf(j2)), AbstractC4616Fw7.a("connect", Boolean.valueOf(z))));
    }

    public final void f(long j, long j2, long j3) {
        C3343Am.i("call_reconnect", AbstractC20051rO3.n(AbstractC4616Fw7.a("call_id", Long.valueOf(j)), AbstractC4616Fw7.a("disconnect_time", Long.valueOf(j2)), AbstractC4616Fw7.a("reconnected_time", Long.valueOf(j3))));
    }

    public final void g(boolean z) {
        if (z) {
            C3343Am.i("video_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("video_call_action", 8)));
        } else {
            C3343Am.i("voice_call", AbstractC19460qO3.g(AbstractC4616Fw7.a("voice_call_action", 8)));
        }
    }
}
