package ir.nasim;

/* loaded from: classes8.dex */
public final class MS4 implements InterfaceC17738nU0 {
    private final Class a;
    private final String b;

    public MS4(Class cls, String str) {
        AbstractC13042fc3.i(cls, "jClass");
        AbstractC13042fc3.i(str, "moduleName");
        this.a = cls;
        this.b = str;
    }

    @Override // ir.nasim.InterfaceC17738nU0
    public Class e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MS4) && AbstractC13042fc3.d(e(), ((MS4) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString() + " (Kotlin reflection is not available)";
    }
}
