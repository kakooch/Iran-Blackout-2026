package ir.nasim;

/* renamed from: ir.nasim.bH4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10220bH4 extends C11465d32 {
    private final C11465d32 a;
    private final float b;

    public C10220bH4(C11465d32 c11465d32, float f) {
        this.a = c11465d32;
        this.b = f;
    }

    @Override // ir.nasim.C11465d32
    boolean b() {
        return this.a.b();
    }

    @Override // ir.nasim.C11465d32
    public void c(float f, float f2, float f3, C24052xx6 c24052xx6) {
        this.a.c(f, f2 - this.b, f3, c24052xx6);
    }
}
