package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19692qm7 {

    /* renamed from: ir.nasim.qm7$a */
    static final class a implements InterfaceC12243eH4 {
        final /* synthetic */ C19101pm7 a;
        final /* synthetic */ boolean b;

        a(C19101pm7 c19101pm7, boolean z) {
            this.a = c19101pm7;
            this.b = z;
        }

        @Override // ir.nasim.InterfaceC12243eH4
        public final long a() {
            return this.a.K(this.b);
        }
    }

    /* renamed from: ir.nasim.qm7$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC4766Gl7 a;

        b(InterfaceC4766Gl7 interfaceC4766Gl7) {
            this.a = interfaceC4766Gl7;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objC = AbstractC15869kJ3.c(interfaceC9049Yg5, this.a, interfaceC20295rm1);
            return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qm7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ AW5 f;
        final /* synthetic */ C19101pm7 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, AW5 aw5, C19101pm7 c19101pm7, int i) {
            super(2);
            this.e = z;
            this.f = aw5;
            this.g = c19101pm7;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC19692qm7.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qm7$d */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC10942cT2.values().length];
            try {
                iArr[EnumC10942cT2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC10942cT2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC10942cT2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final void a(boolean z, AW5 aw5, C19101pm7 c19101pm7, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1344558920);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(aw5) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(c19101pm7) ? 256 : 128;
        }
        if (interfaceC22053ub1J.o((i2 & 147) != 146, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1344558920, i2, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1029)");
            }
            int i3 = i2 & 14;
            boolean zV = (i3 == 4) | interfaceC22053ub1J.V(c19101pm7);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = c19101pm7.W(z);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC4766Gl7 interfaceC4766Gl7 = (InterfaceC4766Gl7) objB;
            boolean zD = interfaceC22053ub1J.D(c19101pm7) | (i3 == 4);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new a(c19101pm7, z);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC12243eH4 interfaceC12243eH4 = (InterfaceC12243eH4) objB2;
            boolean zM = C4301En7.m(c19101pm7.U().g());
            float fJ = c19101pm7.J(z);
            e.a aVar = androidx.compose.ui.e.a;
            boolean zD2 = interfaceC22053ub1J.D(interfaceC4766Gl7);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new b(interfaceC4766Gl7);
                interfaceC22053ub1J.s(objB3);
            }
            int i4 = i2 << 3;
            AbstractC9367Zq.b(interfaceC12243eH4, z, aw5, zM, 0L, fJ, AbstractC21071t37.c(aVar, interfaceC4766Gl7, (PointerInputEventHandler) objB3), interfaceC22053ub1J, (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 & 896), 16);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(z, aw5, c19101pm7, i));
        }
    }

    public static final long b(C19101pm7 c19101pm7, long j) {
        int iN;
        C14367hn7 c14367hn7L;
        C3342Al7 c3342Al7X;
        C13245fu c13245fuK;
        ZG4 zg4D = c19101pm7.D();
        if (zg4D == null) {
            return ZG4.b.b();
        }
        long jT = zg4D.t();
        C13245fu c13245fuS = c19101pm7.S();
        if (c13245fuS == null || c13245fuS.length() == 0) {
            return ZG4.b.b();
        }
        EnumC10942cT2 enumC10942cT2F = c19101pm7.F();
        int i = enumC10942cT2F == null ? -1 : d.a[enumC10942cT2F.ordinal()];
        if (i == -1) {
            return ZG4.b.b();
        }
        if (i == 1 || i == 2) {
            iN = C4301En7.n(c19101pm7.U().g());
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            iN = C4301En7.i(c19101pm7.U().g());
        }
        C6542Ny3 c6542Ny3P = c19101pm7.P();
        if (c6542Ny3P == null || (c14367hn7L = c6542Ny3P.l()) == null) {
            return ZG4.b.b();
        }
        C6542Ny3 c6542Ny3P2 = c19101pm7.P();
        if (c6542Ny3P2 == null || (c3342Al7X = c6542Ny3P2.x()) == null || (c13245fuK = c3342Al7X.k()) == null) {
            return ZG4.b.b();
        }
        int iM = AbstractC23053wG5.m(c19101pm7.N().b(iN), 0, c13245fuK.length());
        float fIntBitsToFloat = Float.intBitsToFloat((int) (c14367hn7L.j(jT) >> 32));
        C13774gn7 c13774gn7F = c14367hn7L.f();
        int iQ = c13774gn7F.q(iM);
        float fS = c13774gn7F.s(iQ);
        float fT = c13774gn7F.t(iQ);
        float fL = AbstractC23053wG5.l(fIntBitsToFloat, Math.min(fS, fT), Math.max(fS, fT));
        if (!C4414Fa3.e(j, C4414Fa3.b.a()) && Math.abs(fIntBitsToFloat - fL) > ((int) (j >> 32)) / 2) {
            return ZG4.b.b();
        }
        float fV = c13774gn7F.v(iQ);
        return ZG4.e((Float.floatToRawIntBits(fL) << 32) | (Float.floatToRawIntBits(((c13774gn7F.m(iQ) - fV) / 2) + fV) & 4294967295L));
    }

    public static final boolean c(C19101pm7 c19101pm7, boolean z) {
        InterfaceC11379cu3 interfaceC11379cu3K;
        CK5 ck5B;
        C6542Ny3 c6542Ny3P = c19101pm7.P();
        if (c6542Ny3P == null || (interfaceC11379cu3K = c6542Ny3P.k()) == null || (ck5B = AbstractC4783Gn6.b(interfaceC11379cu3K)) == null) {
            return false;
        }
        return AbstractC4783Gn6.a(ck5B, c19101pm7.K(z));
    }
}
