package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19576qb1;
import ir.nasim.C17448mz0;

/* renamed from: ir.nasim.qb1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC19576qb1 {

    /* renamed from: ir.nasim.qb1$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ long a;
        final /* synthetic */ float b;

        a(long j, float f) {
            this.a = j;
            this.b = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(float f, long j, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - (f / 2);
            InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), f, 0, null, 0.0f, null, 0, 496, null);
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(-1500237793);
            final float fW1 = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(this.b);
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(394843088);
            boolean zC = interfaceC22053ub1.c(fW1) | interfaceC22053ub1.f(this.a);
            final long j = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zC || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.pb1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19576qb1.a.c(fW1, j, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarB = androidx.compose.ui.draw.b.b(aVar, (UA2) objB);
            interfaceC22053ub1.Q();
            return eVarB;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.qb1$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ long a;
        final /* synthetic */ float b;

        b(long j, float f) {
            this.a = j;
            this.b = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(long j, float f, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
            InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), f, 0, null, 0.0f, null, 0, 496, null);
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(-1514141146);
            final float fW1 = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(this.b);
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(1532226151);
            boolean zF = interfaceC22053ub1.f(this.a) | interfaceC22053ub1.c(fW1);
            final long j = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.rb1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19576qb1.b.c(j, fW1, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarB = androidx.compose.ui.draw.b.b(aVar, (UA2) objB);
            interfaceC22053ub1.Q();
            return eVarB;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final void b(final InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(interfaceC14603iB2, "content");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1815274904);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf(i2 & 14));
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mb1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19576qb1.c(interfaceC14603iB2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$content");
        b(interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e d(androidx.compose.ui.e eVar, float f, long j) {
        AbstractC13042fc3.i(eVar, "$this$endBoarder");
        return androidx.compose.ui.c.c(eVar, null, new a(j, f), 1, null);
    }

    public static final String e(double d, C17448mz0.a aVar) {
        AbstractC13042fc3.i(aVar, "callState");
        return (aVar != C17448mz0.a.g || d < 0.0d) ? "" : XY6.e(C17959nq7.a.d(d));
    }

    public static final androidx.compose.ui.e f(androidx.compose.ui.e eVar, float f, long j) {
        AbstractC13042fc3.i(eVar, "$this$topBorder");
        return androidx.compose.ui.c.c(eVar, null, new b(j, f), 1, null);
    }
}
