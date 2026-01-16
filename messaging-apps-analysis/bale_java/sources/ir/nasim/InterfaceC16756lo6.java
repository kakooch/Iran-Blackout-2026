package ir.nasim;

/* renamed from: ir.nasim.lo6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC16756lo6 {

    /* renamed from: ir.nasim.lo6$a */
    public static final class a {
        public static /* synthetic */ boolean a(InterfaceC16756lo6 interfaceC16756lo6, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return interfaceC16756lo6.w(th);
        }
    }

    boolean A();

    void f(UA2 ua2);

    Object h(Object obj);

    Object o(Object obj, InterfaceC20295rm1 interfaceC20295rm1);

    boolean w(Throwable th);
}
