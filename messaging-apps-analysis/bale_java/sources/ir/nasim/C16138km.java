package ir.nasim;

/* renamed from: ir.nasim.km, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16138km extends C12092e16 {
    private final float c;

    C16138km(float f, float f2, float f3) {
        super(f, f2);
        this.c = f3;
    }

    boolean f(float f, float f2, float f3) {
        if (Math.abs(f2 - d()) > f || Math.abs(f3 - c()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.c);
        return fAbs <= 1.0f || fAbs <= this.c;
    }

    C16138km g(float f, float f2, float f3) {
        return new C16138km((c() + f2) / 2.0f, (d() + f) / 2.0f, (this.c + f3) / 2.0f);
    }
}
