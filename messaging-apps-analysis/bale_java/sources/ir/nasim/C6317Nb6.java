package ir.nasim;

/* renamed from: ir.nasim.Nb6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6317Nb6 {
    private AbstractC20375ru1 a;
    private androidx.lifecycle.y b;
    private final boolean c;

    C6317Nb6(AbstractC20375ru1 abstractC20375ru1) {
        this.c = abstractC20375ru1 == null;
        this.a = abstractC20375ru1;
    }

    public void a() {
        this.a = null;
    }

    public boolean b() {
        return this.b == null && this.a == null;
    }

    public void c(AbstractC20375ru1 abstractC20375ru1) {
        if (this.b != null) {
            return;
        }
        this.a = abstractC20375ru1;
    }
}
