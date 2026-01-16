package ir.nasim;

/* renamed from: ir.nasim.lT, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C16546lT extends AbstractC9443Zy3 {
    private final String a;
    private final String b;

    C16546lT(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.b = str2;
    }

    @Override // ir.nasim.AbstractC9443Zy3
    public String b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC9443Zy3
    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC9443Zy3)) {
            return false;
        }
        AbstractC9443Zy3 abstractC9443Zy3 = (AbstractC9443Zy3) obj;
        return this.a.equals(abstractC9443Zy3.b()) && this.b.equals(abstractC9443Zy3.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.b + "}";
    }
}
