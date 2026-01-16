package ir.nasim;

/* renamed from: ir.nasim.qn4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC19699qn4 {

    /* renamed from: ir.nasim.qn4$a */
    public static final class a {
        public static /* synthetic */ Object a(InterfaceC19699qn4 interfaceC19699qn4, Object obj, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            return interfaceC19699qn4.a(obj, interfaceC20295rm1);
        }

        public static /* synthetic */ boolean b(InterfaceC19699qn4 interfaceC19699qn4, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            return interfaceC19699qn4.c(obj);
        }

        public static /* synthetic */ void c(InterfaceC19699qn4 interfaceC19699qn4, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            interfaceC19699qn4.e(obj);
        }
    }

    Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1);

    boolean c(Object obj);

    boolean d();

    void e(Object obj);
}
