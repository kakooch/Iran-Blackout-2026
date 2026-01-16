package ir.nasim;

/* renamed from: ir.nasim.sn4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20899sn4 {
    private static final C14539i47 a = new C14539i47("NO_OWNER");
    private static final C14539i47 b = new C14539i47("ALREADY_LOCKED_BY_OWNER");

    public static final InterfaceC19699qn4 a(boolean z) {
        return new C20308rn4(z);
    }

    public static /* synthetic */ InterfaceC19699qn4 b(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z);
    }
}
