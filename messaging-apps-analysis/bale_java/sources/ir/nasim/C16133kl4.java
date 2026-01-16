package ir.nasim;

/* renamed from: ir.nasim.kl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16133kl4 {
    private Class a;
    private Class b;
    private Class c;

    public C16133kl4() {
    }

    public void a(Class cls, Class cls2, Class cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C16133kl4 c16133kl4 = (C16133kl4) obj;
        return this.a.equals(c16133kl4.a) && this.b.equals(c16133kl4.b) && YM7.e(this.c, c16133kl4.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Class cls = this.c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }

    public C16133kl4(Class cls, Class cls2, Class cls3) {
        a(cls, cls2, cls3);
    }
}
