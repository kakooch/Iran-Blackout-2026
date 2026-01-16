package ir.nasim;

/* loaded from: classes5.dex */
public abstract class VL {
    private String a;
    private T74 b;
    private final J44 c;
    private final long d;

    public /* synthetic */ VL(String str, T74 t74, J44 j44, long j, ED1 ed1) {
        this(str, t74, j44, j);
    }

    public abstract J44 a();

    public abstract long b();

    public abstract String c();

    public abstract T74 d();

    public abstract void e(String str);

    public boolean equals(Object obj) {
        if (obj instanceof VL) {
            return AbstractC13042fc3.d(d(), ((VL) obj).d());
        }
        return false;
    }

    public int hashCode() {
        return d().hashCode();
    }

    private VL(String str, T74 t74, J44 j44, long j) {
        this.a = str;
        this.b = t74;
        this.c = j44;
        this.d = j;
    }
}
