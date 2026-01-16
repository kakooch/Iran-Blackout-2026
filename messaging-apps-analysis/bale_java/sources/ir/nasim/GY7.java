package ir.nasim;

/* loaded from: classes8.dex */
public abstract class GY7 {
    private final String a;
    private final boolean b;

    protected GY7(String str, boolean z) {
        AbstractC13042fc3.i(str, "name");
        this.a = str;
        this.b = z;
    }

    public Integer a(GY7 gy7) {
        AbstractC13042fc3.i(gy7, "visibility");
        return EY7.a.a(this, gy7);
    }

    public String b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public final String toString() {
        return b();
    }

    public GY7 d() {
        return this;
    }
}
