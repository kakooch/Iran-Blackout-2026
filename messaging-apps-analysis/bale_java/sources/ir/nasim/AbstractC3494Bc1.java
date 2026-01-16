package ir.nasim;

/* renamed from: ir.nasim.Bc1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3494Bc1 {
    private static final C14539i47 a = new C14539i47("CLOSED");

    public static final AbstractC3728Cc1 b(AbstractC3728Cc1 abstractC3728Cc1) {
        while (true) {
            Object objF = abstractC3728Cc1.f();
            if (objF == a) {
                return abstractC3728Cc1;
            }
            AbstractC3728Cc1 abstractC3728Cc12 = (AbstractC3728Cc1) objF;
            if (abstractC3728Cc12 != null) {
                abstractC3728Cc1 = abstractC3728Cc12;
            } else if (abstractC3728Cc1.j()) {
                return abstractC3728Cc1;
            }
        }
    }

    public static final Object c(AbstractC23344wl6 abstractC23344wl6, long j, InterfaceC14603iB2 interfaceC14603iB2) {
        while (true) {
            if (abstractC23344wl6.c >= j && !abstractC23344wl6.h()) {
                return AbstractC3341Al6.a(abstractC23344wl6);
            }
            Object objF = abstractC23344wl6.f();
            if (objF == a) {
                return AbstractC3341Al6.a(a);
            }
            AbstractC23344wl6 abstractC23344wl62 = (AbstractC23344wl6) ((AbstractC3728Cc1) objF);
            if (abstractC23344wl62 == null) {
                abstractC23344wl62 = (AbstractC23344wl6) interfaceC14603iB2.invoke(Long.valueOf(abstractC23344wl6.c + 1), abstractC23344wl6);
                if (abstractC23344wl6.l(abstractC23344wl62)) {
                    if (abstractC23344wl6.h()) {
                        abstractC23344wl6.k();
                    }
                }
            }
            abstractC23344wl6 = abstractC23344wl62;
        }
    }
}
