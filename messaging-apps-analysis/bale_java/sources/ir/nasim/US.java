package ir.nasim;

import ir.nasim.GD0;

/* loaded from: classes.dex */
final class US extends GD0.a {
    private final int a;
    private final Throwable b;

    US(int i, Throwable th) {
        this.a = i;
        this.b = th;
    }

    @Override // ir.nasim.GD0.a
    public Throwable c() {
        return this.b;
    }

    @Override // ir.nasim.GD0.a
    public int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GD0.a)) {
            return false;
        }
        GD0.a aVar = (GD0.a) obj;
        if (this.a == aVar.d()) {
            Throwable th = this.b;
            if (th == null) {
                if (aVar.c() == null) {
                    return true;
                }
            } else if (th.equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        Throwable th = this.b;
        return i ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "StateError{code=" + this.a + ", cause=" + this.b + "}";
    }
}
