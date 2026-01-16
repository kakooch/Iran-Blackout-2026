package ir.nasim;

/* renamed from: ir.nasim.wj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23321wj3 {
    private static final C14539i47 a = new C14539i47("COMPLETING_ALREADY");
    public static final C14539i47 b = new C14539i47("COMPLETING_WAITING_CHILDREN");
    private static final C14539i47 c = new C14539i47("COMPLETING_RETRY");
    private static final C14539i47 d = new C14539i47("TOO_LATE_TO_CANCEL");
    private static final C14539i47 e = new C14539i47("SEALED");
    private static final C12148e72 f = new C12148e72(false);
    private static final C12148e72 g = new C12148e72(true);

    public static final Object g(Object obj) {
        return obj instanceof W53 ? new X53((W53) obj) : obj;
    }

    public static final Object h(Object obj) {
        W53 w53;
        X53 x53 = obj instanceof X53 ? (X53) obj : null;
        return (x53 == null || (w53 = x53.a) == null) ? obj : w53;
    }
}
