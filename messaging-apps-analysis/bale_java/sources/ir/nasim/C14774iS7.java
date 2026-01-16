package ir.nasim;

import ir.nasim.UK6;
import java.util.Iterator;

/* renamed from: ir.nasim.iS7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14774iS7 extends AbstractC12857fI0 {

    /* renamed from: ir.nasim.iS7$a */
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

    public C14774iS7(UK6 uk6) {
        super(uk6, UK6.e.VERTICAL_CHAIN);
    }

    @Override // ir.nasim.C17749nV2, ir.nasim.C13060fe1, ir.nasim.InterfaceC14709iL5, ir.nasim.InterfaceC17844nf2
    public void apply() {
        Iterator it = this.l0.iterator();
        while (it.hasNext()) {
            this.j0.c(it.next()).m();
        }
        Iterator it2 = this.l0.iterator();
        C13060fe1 c13060fe1 = null;
        C13060fe1 c13060fe12 = null;
        while (it2.hasNext()) {
            C13060fe1 c13060fe1C = this.j0.c(it2.next());
            if (c13060fe12 == null) {
                Object obj = this.S;
                if (obj != null) {
                    c13060fe1C.T(obj).A(this.o).C(this.u);
                } else {
                    Object obj2 = this.T;
                    if (obj2 != null) {
                        c13060fe1C.S(obj2).A(this.o).C(this.u);
                    } else {
                        c13060fe1C.T(UK6.f);
                    }
                }
                c13060fe12 = c13060fe1C;
            }
            if (c13060fe1 != null) {
                c13060fe1.j(c13060fe1C.getKey());
                c13060fe1C.S(c13060fe1.getKey());
            }
            c13060fe1 = c13060fe1C;
        }
        if (c13060fe1 != null) {
            Object obj3 = this.U;
            if (obj3 != null) {
                c13060fe1.j(obj3).A(this.p).C(this.v);
            } else {
                Object obj4 = this.V;
                if (obj4 != null) {
                    c13060fe1.i(obj4).A(this.p).C(this.v);
                } else {
                    c13060fe1.i(UK6.f);
                }
            }
        }
        if (c13060fe12 == null) {
            return;
        }
        float f = this.n0;
        if (f != 0.5f) {
            c13060fe12.U(f);
        }
        int i = a.a[this.o0.ordinal()];
        if (i == 1) {
            c13060fe12.L(0);
        } else if (i == 2) {
            c13060fe12.L(1);
        } else {
            if (i != 3) {
                return;
            }
            c13060fe12.L(2);
        }
    }
}
