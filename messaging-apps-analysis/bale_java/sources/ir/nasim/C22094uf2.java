package ir.nasim;

/* renamed from: ir.nasim.uf2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22094uf2 {
    private final float a;
    private final InterfaceC4788Go2 b;

    public C22094uf2(float f, InterfaceC4788Go2 interfaceC4788Go2) {
        this.a = f;
        this.b = interfaceC4788Go2;
    }

    public final float a() {
        return this.a;
    }

    public final InterfaceC4788Go2 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22094uf2)) {
            return false;
        }
        C22094uf2 c22094uf2 = (C22094uf2) obj;
        return Float.compare(this.a, c22094uf2.a) == 0 && AbstractC13042fc3.d(this.b, c22094uf2.b);
    }

    public int hashCode() {
        return (Float.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Fade(alpha=" + this.a + ", animationSpec=" + this.b + ')';
    }
}
