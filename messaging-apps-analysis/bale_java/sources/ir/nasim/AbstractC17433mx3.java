package ir.nasim;

import ir.nasim.FG6;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.mx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17433mx3 {

    /* renamed from: ir.nasim.mx3$a */
    public static final class a implements CG6 {
        final /* synthetic */ C19206px3 a;
        final /* synthetic */ FG6 b;

        a(C19206px3 c19206px3, FG6 fg6) {
            this.a = c19206px3;
            this.b = fg6;
        }

        private final int c() {
            InterfaceC9425Zw3 interfaceC9425Zw3D = d();
            int iF = 0;
            if (interfaceC9425Zw3D.i().isEmpty()) {
                return 0;
            }
            int size = interfaceC9425Zw3D.i().size();
            Iterator it = interfaceC9425Zw3D.i().iterator();
            while (it.hasNext()) {
                iF += ((InterfaceC7948Tw3) it.next()).f();
            }
            return iF / size;
        }

        private final InterfaceC9425Zw3 d() {
            return this.a.x();
        }

        @Override // ir.nasim.CG6
        public float a(float f) {
            List listI = d().i();
            FG6 fg6 = this.b;
            int size = listI.size();
            float f2 = Float.NEGATIVE_INFINITY;
            float f3 = Float.POSITIVE_INFINITY;
            for (int i = 0; i < size; i++) {
                InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) listI.get(i);
                InterfaceC24630yw3 interfaceC24630yw3 = interfaceC7948Tw3 instanceof InterfaceC24630yw3 ? (InterfaceC24630yw3) interfaceC7948Tw3 : null;
                if (interfaceC24630yw3 == null || !interfaceC24630yw3.h()) {
                    float fA = GG6.a(AbstractC17433mx3.c(d()), d().e(), d().c(), interfaceC7948Tw3.f(), interfaceC7948Tw3.getOffset(), interfaceC7948Tw3.getIndex(), fg6, d().g());
                    if (fA <= 0.0f && fA > f2) {
                        f2 = fA;
                    }
                    if (fA >= 0.0f && fA < f3) {
                        f3 = fA;
                    }
                }
            }
            return AG6.j(AbstractC17433mx3.b(this.a.r(), f), f2, f3);
        }

        @Override // ir.nasim.CG6
        public float b(float f, float f2) {
            return AbstractC23053wG5.d(Math.abs(f2) - c(), 0.0f) * Math.signum(f2);
        }
    }

    public static final CG6 a(C19206px3 c19206px3, FG6 fg6) {
        return new a(c19206px3, fg6);
    }

    public static final int b(WH1 wh1, float f) {
        return Math.abs(f) < wh1.w1(AG6.m()) ? AbstractC22184uo2.a.a() : f > 0.0f ? AbstractC22184uo2.a.b() : AbstractC22184uo2.a.c();
    }

    public static final int c(InterfaceC9425Zw3 interfaceC9425Zw3) {
        return (int) (interfaceC9425Zw3.a() == EnumC24286yM4.a ? interfaceC9425Zw3.b() & 4294967295L : interfaceC9425Zw3.b() >> 32);
    }

    public static final InterfaceC7645Sp2 d(C19206px3 c19206px3, FG6 fg6, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            fg6 = FG6.a.a;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-338621290, i, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:115)");
        }
        boolean z = (((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(c19206px3)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = a(c19206px3, fg6);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC4031Dj7 interfaceC4031Dj7N = AG6.n((CG6) objB, interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC4031Dj7N;
    }
}
