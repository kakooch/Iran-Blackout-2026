package ir.nasim;

import ir.nasim.GJ0;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* renamed from: ir.nasim.gd1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C13668gd1 extends C6401Nl0 {
    private final int m;
    private final EnumC6162Ml0 n;

    public C13668gd1(int i, EnumC6162Ml0 enumC6162Ml0, UA2 ua2) {
        super(i, ua2);
        this.m = i;
        this.n = enumC6162Ml0;
        if (enumC6162Ml0 == EnumC6162Ml0.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + AbstractC10882cM5.b(C6401Nl0.class).p() + " instead").toString());
        }
        if (i >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
    }

    static /* synthetic */ Object Y0(C13668gd1 c13668gd1, Object obj, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionD;
        Object objB1 = c13668gd1.b1(obj, true);
        if (!(objB1 instanceof GJ0.a)) {
            return C19938rB7.a;
        }
        GJ0.e(objB1);
        UA2 ua2 = c13668gd1.b;
        if (ua2 == null || (undeliveredElementExceptionD = AbstractC16470lK4.d(ua2, obj, null, 2, null)) == null) {
            throw c13668gd1.X();
        }
        AbstractC16632lc2.a(undeliveredElementExceptionD, c13668gd1.X());
        throw undeliveredElementExceptionD;
    }

    private final Object Z0(Object obj, boolean z) {
        UA2 ua2;
        UndeliveredElementException undeliveredElementExceptionD;
        Object objH = super.h(obj);
        if (GJ0.i(objH) || GJ0.h(objH)) {
            return objH;
        }
        if (!z || (ua2 = this.b) == null || (undeliveredElementExceptionD = AbstractC16470lK4.d(ua2, obj, null, 2, null)) == null) {
            return GJ0.b.c(C19938rB7.a);
        }
        throw undeliveredElementExceptionD;
    }

    private final Object a1(Object obj) {
        JJ0 jj0;
        Object obj2 = AbstractC6661Ol0.d;
        JJ0 jj02 = (JJ0) C6401Nl0.h.get(this);
        while (true) {
            long andIncrement = C6401Nl0.d.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zH0 = h0(andIncrement);
            int i = AbstractC6661Ol0.b;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (jj02.c != j2) {
                JJ0 jj0R = R(j2, jj02);
                if (jj0R != null) {
                    jj0 = jj0R;
                } else if (zH0) {
                    return GJ0.b.a(X());
                }
            } else {
                jj0 = jj02;
            }
            int iT0 = T0(jj0, i2, obj, j, obj2, zH0);
            if (iT0 == 0) {
                jj0.b();
                return GJ0.b.c(C19938rB7.a);
            }
            if (iT0 == 1) {
                return GJ0.b.c(C19938rB7.a);
            }
            if (iT0 == 2) {
                if (zH0) {
                    jj0.p();
                    return GJ0.b.a(X());
                }
                InterfaceC21726u18 interfaceC21726u18 = obj2 instanceof InterfaceC21726u18 ? (InterfaceC21726u18) obj2 : null;
                if (interfaceC21726u18 != null) {
                    y0(interfaceC21726u18, jj0, i2);
                }
                N((jj0.c * i) + i2);
                return GJ0.b.c(C19938rB7.a);
            }
            if (iT0 == 3) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (iT0 == 4) {
                if (j < W()) {
                    jj0.b();
                }
                return GJ0.b.a(X());
            }
            if (iT0 == 5) {
                jj0.b();
            }
            jj02 = jj0;
        }
    }

    private final Object b1(Object obj, boolean z) {
        return this.n == EnumC6162Ml0.DROP_LATEST ? Z0(obj, z) : a1(obj);
    }

    @Override // ir.nasim.C6401Nl0, ir.nasim.InterfaceC16756lo6
    public Object h(Object obj) {
        return b1(obj, false);
    }

    @Override // ir.nasim.C6401Nl0
    protected boolean i0() {
        return this.n == EnumC6162Ml0.DROP_OLDEST;
    }

    @Override // ir.nasim.C6401Nl0, ir.nasim.InterfaceC16756lo6
    public Object o(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return Y0(this, obj, interfaceC20295rm1);
    }
}
