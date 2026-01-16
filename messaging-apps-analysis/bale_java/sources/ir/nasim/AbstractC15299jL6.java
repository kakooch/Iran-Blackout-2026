package ir.nasim;

/* renamed from: ir.nasim.jL6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15299jL6 implements InterfaceC14710iL6 {
    private final QL a = new QL(0);

    public final void A(int i) {
        int iA;
        do {
            iA = androidx.compose.runtime.snapshots.e.a(this.a.get());
            if ((iA & i) != 0) {
                return;
            }
        } while (!this.a.compareAndSet(iA, androidx.compose.runtime.snapshots.e.a(iA | i)));
    }

    public final boolean z(int i) {
        return (i & androidx.compose.runtime.snapshots.e.a(this.a.get())) != 0;
    }
}
