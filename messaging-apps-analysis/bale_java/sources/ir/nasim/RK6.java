package ir.nasim;

/* loaded from: classes2.dex */
public final class RK6 {
    private final String a;
    private final boolean b;

    public RK6(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RK6)) {
            return false;
        }
        RK6 rk6 = (RK6) obj;
        return AbstractC13042fc3.d(this.a, rk6.a) && this.b == rk6.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "StartupTracingConfig(libFilePath=" + this.a + ", isPersistent=" + this.b + ')';
    }
}
