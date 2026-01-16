package ir.nasim;

import ir.nasim.UK6;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class JY2 extends AbstractC12857fI0 {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UK6.b.values().length];
            a = iArr;
            try {
                iArr[UK6.b.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UK6.b.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UK6.b.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public JY2(UK6 uk6) {
        super(uk6, UK6.e.HORIZONTAL_CHAIN);
    }

    @Override // ir.nasim.C17749nV2, ir.nasim.C13060fe1, ir.nasim.InterfaceC14709iL5, ir.nasim.InterfaceC17844nf2
    public void apply() {
        Iterator it = this.l0.iterator();
        while (it.hasNext()) {
            this.j0.c(it.next()).l();
        }
        Iterator it2 = this.l0.iterator();
        C13060fe1 c13060fe1 = null;
        C13060fe1 c13060fe12 = null;
        while (it2.hasNext()) {
            C13060fe1 c13060fe1C = this.j0.c(it2.next());
            if (c13060fe12 == null) {
                Object obj = this.O;
                if (obj != null) {
                    c13060fe1C.Q(obj).A(this.m).C(this.s);
                } else {
                    Object obj2 = this.P;
                    if (obj2 != null) {
                        c13060fe1C.P(obj2).A(this.m).C(this.s);
                    } else {
                        Object obj3 = this.K;
                        if (obj3 != null) {
                            c13060fe1C.Q(obj3).A(this.k).C(this.q);
                        } else {
                            Object obj4 = this.L;
                            if (obj4 != null) {
                                c13060fe1C.P(obj4).A(this.k).C(this.q);
                            } else {
                                c13060fe1C.Q(UK6.f);
                            }
                        }
                    }
                }
                c13060fe12 = c13060fe1C;
            }
            if (c13060fe1 != null) {
                c13060fe1.r(c13060fe1C.getKey());
                c13060fe1C.P(c13060fe1.getKey());
            }
            c13060fe1 = c13060fe1C;
        }
        if (c13060fe1 != null) {
            Object obj5 = this.Q;
            if (obj5 != null) {
                c13060fe1.r(obj5).A(this.n).C(this.t);
            } else {
                Object obj6 = this.R;
                if (obj6 != null) {
                    c13060fe1.q(obj6).A(this.n).C(this.t);
                } else {
                    Object obj7 = this.M;
                    if (obj7 != null) {
                        c13060fe1.r(obj7).A(this.l).C(this.r);
                    } else {
                        Object obj8 = this.N;
                        if (obj8 != null) {
                            c13060fe1.q(obj8).A(this.l).C(this.r);
                        } else {
                            c13060fe1.q(UK6.f);
                        }
                    }
                }
            }
        }
        if (c13060fe12 == null) {
            return;
        }
        float f = this.n0;
        if (f != 0.5f) {
            c13060fe12.w(f);
        }
        int i = a.a[this.o0.ordinal()];
        if (i == 1) {
            c13060fe12.J(0);
        } else if (i == 2) {
            c13060fe12.J(1);
        } else {
            if (i != 3) {
                return;
            }
            c13060fe12.J(2);
        }
    }
}
