package ir.nasim;

/* renamed from: ir.nasim.o16, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18065o16 {
    public static Object a(int i, Object obj, InterfaceC12187eB2 interfaceC12187eB2, InterfaceC22910w16 interfaceC22910w16) {
        Object objApply;
        if (i < 1) {
            return interfaceC12187eB2.apply(obj);
        }
        do {
            objApply = interfaceC12187eB2.apply(obj);
            obj = interfaceC22910w16.a(obj, objApply);
            if (obj == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return objApply;
    }
}
