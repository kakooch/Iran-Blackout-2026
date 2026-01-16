package ir.nasim;

import ir.nasim.AbstractC15890kL6;

/* loaded from: classes.dex */
final class BT extends AbstractC15890kL6.a {
    private final Throwable a;

    BT(Throwable th) {
        if (th == null) {
            throw new NullPointerException("Null error");
        }
        this.a = th;
    }

    @Override // ir.nasim.AbstractC15890kL6.a
    public Throwable a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC15890kL6.a) {
            return this.a.equals(((AbstractC15890kL6.a) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.a + "}";
    }
}
