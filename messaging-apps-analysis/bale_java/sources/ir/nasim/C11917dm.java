package ir.nasim;

import ir.nasim.UK6;
import java.util.Iterator;

/* renamed from: ir.nasim.dm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C11917dm extends C17749nV2 {
    private float n0;

    public C11917dm(UK6 uk6) {
        super(uk6, UK6.e.ALIGN_VERTICALLY);
        this.n0 = 0.5f;
    }

    @Override // ir.nasim.C17749nV2, ir.nasim.C13060fe1, ir.nasim.InterfaceC14709iL5, ir.nasim.InterfaceC17844nf2
    public void apply() {
        Iterator it = this.l0.iterator();
        while (it.hasNext()) {
            C13060fe1 c13060fe1C = this.j0.c(it.next());
            c13060fe1C.m();
            Object obj = this.S;
            if (obj != null) {
                c13060fe1C.T(obj);
            } else {
                Object obj2 = this.T;
                if (obj2 != null) {
                    c13060fe1C.S(obj2);
                } else {
                    c13060fe1C.T(UK6.f);
                }
            }
            Object obj3 = this.U;
            if (obj3 != null) {
                c13060fe1C.j(obj3);
            } else {
                Object obj4 = this.V;
                if (obj4 != null) {
                    c13060fe1C.i(obj4);
                } else {
                    c13060fe1C.i(UK6.f);
                }
            }
            float f = this.n0;
            if (f != 0.5f) {
                c13060fe1C.U(f);
            }
        }
    }
}
