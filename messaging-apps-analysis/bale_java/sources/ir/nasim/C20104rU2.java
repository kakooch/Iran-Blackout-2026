package ir.nasim;

/* renamed from: ir.nasim.rU2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C20104rU2 {
    static int b = 31;
    private int a = 1;

    public C20104rU2 a(Object obj) {
        this.a = (b * this.a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.a;
    }

    public final C20104rU2 c(boolean z) {
        this.a = (b * this.a) + (z ? 1 : 0);
        return this;
    }
}
