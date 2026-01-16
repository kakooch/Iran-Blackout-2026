package ir.nasim;

/* renamed from: ir.nasim.io6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14984io6 {
    private static final int a = AbstractC11490d57.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
    private static final C14539i47 b = new C14539i47("PERMIT");
    private static final C14539i47 c = new C14539i47("TAKEN");
    private static final C14539i47 d = new C14539i47("BROKEN");
    private static final C14539i47 e = new C14539i47("CANCELLED");
    private static final int f = AbstractC11490d57.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final InterfaceC13783go6 a(int i, int i2) {
        return new C14376ho6(i, i2);
    }

    public static /* synthetic */ InterfaceC13783go6 b(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15574jo6 j(long j, C15574jo6 c15574jo6) {
        return new C15574jo6(j, c15574jo6, 0);
    }
}
