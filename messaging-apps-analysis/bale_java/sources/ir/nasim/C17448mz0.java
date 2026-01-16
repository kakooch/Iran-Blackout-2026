package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC12895fM2;
import ir.nasim.AbstractC7031Pz0;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.mz0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17448mz0 {
    public static final int m = 8;
    private final C8942Xx0 a;
    private final long b;
    private final AbstractC7031Pz0 c;
    private final a d;
    private final EN4 e;
    private final OM4 f;
    private final EnumC13941h47 g;
    private boolean h;
    private final InterfaceC4557Fq2 i;
    private final InterfaceC4557Fq2 j;
    private final InterfaceC9336Zm4 k;
    private final boolean l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.mz0$a */
    public static final class a {
        public static final a a = new a("OUTGOING_REQUESTED", 0);
        public static final a b = new a("OUTGOING_STARTED", 1);
        public static final a c = new a("OUTGOING_RECEIVED", 2);
        public static final a d = new a("OUTGOING_FAILED", 3);
        public static final a e = new a("INCOMING", 4);
        public static final a f = new a("INCOMING_ACCEPTED", 5);
        public static final a g = new a("IN_CALL", 6);
        public static final a h = new a("RECONNECTING", 7);
        public static final a i = new a("ON_HOLD", 8);
        public static final a j = new a("DECLINED", 9);
        public static final a k = new a("NOT_ANSWERED", 10);
        public static final a l = new a("BUSY", 11);
        public static final a m = new a("NOT_CONNECTED", 12);
        public static final a n = new a("FINISHED", 13);
        public static final a o = new a("INIT", 14);
        private static final /* synthetic */ a[] p;
        private static final /* synthetic */ F92 q;

        static {
            a[] aVarArrA = a();
            p = aVarArrA;
            q = G92.a(aVarArrA);
        }

        private a(String str, int i2) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) p.clone();
        }
    }

    /* renamed from: ir.nasim.mz0$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.g.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.o.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.n.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a.k.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[a.m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[a.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[a.l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[a.a.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[a.b.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[a.c.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[a.f.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[a.i.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[a.e.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            a = iArr;
        }
    }

    public C17448mz0(C8942Xx0 c8942Xx0, long j, AbstractC7031Pz0 abstractC7031Pz0, a aVar, EN4 en4, OM4 om4, EnumC13941h47 enumC13941h47, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC9336Zm4 interfaceC9336Zm4, boolean z2) {
        AbstractC13042fc3.i(aVar, "callState");
        AbstractC13042fc3.i(interfaceC9336Zm4, "invitedUser");
        this.a = c8942Xx0;
        this.b = j;
        this.c = abstractC7031Pz0;
        this.d = aVar;
        this.e = en4;
        this.f = om4;
        this.g = enumC13941h47;
        this.h = z;
        this.i = interfaceC4557Fq2;
        this.j = interfaceC4557Fq22;
        this.k = interfaceC9336Zm4;
        this.l = z2;
    }

    public final C17448mz0 a(C8942Xx0 c8942Xx0, long j, AbstractC7031Pz0 abstractC7031Pz0, a aVar, EN4 en4, OM4 om4, EnumC13941h47 enumC13941h47, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC9336Zm4 interfaceC9336Zm4, boolean z2) {
        AbstractC13042fc3.i(aVar, "callState");
        AbstractC13042fc3.i(interfaceC9336Zm4, "invitedUser");
        return new C17448mz0(c8942Xx0, j, abstractC7031Pz0, aVar, en4, om4, enumC13941h47, z, interfaceC4557Fq2, interfaceC4557Fq22, interfaceC9336Zm4, z2);
    }

    public final long c() {
        return this.b;
    }

    public final C8942Xx0 d() {
        return this.a;
    }

    public final a e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17448mz0)) {
            return false;
        }
        C17448mz0 c17448mz0 = (C17448mz0) obj;
        return AbstractC13042fc3.d(this.a, c17448mz0.a) && this.b == c17448mz0.b && AbstractC13042fc3.d(this.c, c17448mz0.c) && this.d == c17448mz0.d && AbstractC13042fc3.d(this.e, c17448mz0.e) && AbstractC13042fc3.d(this.f, c17448mz0.f) && this.g == c17448mz0.g && this.h == c17448mz0.h && AbstractC13042fc3.d(this.i, c17448mz0.i) && AbstractC13042fc3.d(this.j, c17448mz0.j) && AbstractC13042fc3.d(this.k, c17448mz0.k) && this.l == c17448mz0.l;
    }

    public final AbstractC7031Pz0 f() {
        return this.c;
    }

    public final InterfaceC9336Zm4 g() {
        return this.k;
    }

    public final InterfaceC4557Fq2 h() {
        return this.j;
    }

    public int hashCode() {
        C8942Xx0 c8942Xx0 = this.a;
        int iHashCode = (((c8942Xx0 == null ? 0 : c8942Xx0.hashCode()) * 31) + Long.hashCode(this.b)) * 31;
        AbstractC7031Pz0 abstractC7031Pz0 = this.c;
        int iHashCode2 = (((iHashCode + (abstractC7031Pz0 == null ? 0 : abstractC7031Pz0.hashCode())) * 31) + this.d.hashCode()) * 31;
        EN4 en4 = this.e;
        int iHashCode3 = (iHashCode2 + (en4 == null ? 0 : en4.hashCode())) * 31;
        OM4 om4 = this.f;
        int iHashCode4 = (iHashCode3 + (om4 == null ? 0 : om4.hashCode())) * 31;
        EnumC13941h47 enumC13941h47 = this.g;
        int iHashCode5 = (((iHashCode4 + (enumC13941h47 == null ? 0 : enumC13941h47.hashCode())) * 31) + Boolean.hashCode(this.h)) * 31;
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.i;
        int iHashCode6 = (iHashCode5 + (interfaceC4557Fq2 == null ? 0 : interfaceC4557Fq2.hashCode())) * 31;
        InterfaceC4557Fq2 interfaceC4557Fq22 = this.j;
        return ((((iHashCode6 + (interfaceC4557Fq22 != null ? interfaceC4557Fq22.hashCode() : 0)) * 31) + this.k.hashCode()) * 31) + Boolean.hashCode(this.l);
    }

    public final OM4 i() {
        return this.f;
    }

    public final EN4 j() {
        return this.e;
    }

    public final InterfaceC4557Fq2 k() {
        return this.i;
    }

    public final boolean l() {
        switch (b.a[this.d.ordinal()]) {
            case 1:
            case 2:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean m() {
        AbstractC7031Pz0 abstractC7031Pz0 = this.c;
        if (abstractC7031Pz0 != null) {
            return abstractC7031Pz0.a();
        }
        return false;
    }

    public final boolean n() {
        AbstractC7031Pz0 abstractC7031Pz0 = this.c;
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.b) {
            return AbstractC13042fc3.d(((AbstractC7031Pz0.b) abstractC7031Pz0).d(), AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.d) {
            return AbstractC13042fc3.d(((AbstractC7031Pz0.d) abstractC7031Pz0).d(), AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.h) {
            return AbstractC13042fc3.d(((AbstractC7031Pz0.h) abstractC7031Pz0).d(), AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.j) {
            return AbstractC13042fc3.d(((AbstractC7031Pz0.j) abstractC7031Pz0).d(), AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.f) {
            return AbstractC13042fc3.d(((AbstractC7031Pz0.f) abstractC7031Pz0).g(), AbstractC12895fM2.a.a);
        }
        if (AbstractC13042fc3.d(abstractC7031Pz0, AbstractC7031Pz0.e.b) || AbstractC13042fc3.d(abstractC7031Pz0, AbstractC7031Pz0.c.b) || (abstractC7031Pz0 instanceof AbstractC7031Pz0.i) || (abstractC7031Pz0 instanceof AbstractC7031Pz0.k) || abstractC7031Pz0 == null) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean o() {
        String strD;
        AbstractC7031Pz0 abstractC7031Pz0 = this.c;
        return (abstractC7031Pz0 instanceof AbstractC7031Pz0.f) && AbstractC13042fc3.d(((AbstractC7031Pz0.f) abstractC7031Pz0).g(), AbstractC12895fM2.a.a) && (strD = ((AbstractC7031Pz0.f) this.c).d()) != null && !AbstractC20762sZ6.n0(strD);
    }

    public final boolean p() {
        AbstractC7031Pz0 abstractC7031Pz0 = this.c;
        return (abstractC7031Pz0 == null || abstractC7031Pz0.a()) ? false : true;
    }

    public final boolean q() {
        return this.l;
    }

    public final boolean r() {
        AbstractC7031Pz0 abstractC7031Pz0 = this.c;
        return abstractC7031Pz0 != null && abstractC7031Pz0.b();
    }

    public final boolean s() {
        return this.h;
    }

    public String toString() {
        return "CallServiceState(callPeer=" + this.a + ", callId=" + this.b + ", callType=" + this.c + ", callState=" + this.d + ", outputHandler=" + this.e + ", outgoingCallFailure=" + this.f + ", switchType=" + this.g + ", isVideoCall=" + this.h + ", roomParticipants=" + this.i + ", localParticipant=" + this.j + ", invitedUser=" + this.k + ", isRecording=" + this.l + Separators.RPAREN;
    }

    public /* synthetic */ C17448mz0(C8942Xx0 c8942Xx0, long j, AbstractC7031Pz0 abstractC7031Pz0, a aVar, EN4 en4, OM4 om4, EnumC13941h47 enumC13941h47, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC9336Zm4 interfaceC9336Zm4, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : c8942Xx0, (i & 2) != 0 ? -1L : j, (i & 4) != 0 ? null : abstractC7031Pz0, (i & 8) != 0 ? a.o : aVar, (i & 16) != 0 ? null : en4, (i & 32) != 0 ? null : om4, (i & 64) != 0 ? null : enumC13941h47, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : interfaceC4557Fq2, (i & 512) == 0 ? interfaceC4557Fq22 : null, (i & 1024) != 0 ? AbstractC12281eL6.a(AbstractC10360bX0.m()) : interfaceC9336Zm4, (i & 2048) == 0 ? z2 : false);
    }
}
