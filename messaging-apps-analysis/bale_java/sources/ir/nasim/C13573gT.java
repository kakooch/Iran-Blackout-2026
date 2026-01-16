package ir.nasim;

/* renamed from: ir.nasim.gT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C13573gT extends I03 {
    private final Object a;

    C13573gT(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null value");
        }
        this.a = obj;
    }

    @Override // ir.nasim.I03
    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof I03) {
            return this.a.equals(((I03) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.a + "}";
    }
}
