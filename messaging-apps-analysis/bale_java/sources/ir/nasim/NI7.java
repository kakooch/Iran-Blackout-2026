package ir.nasim;

/* loaded from: classes5.dex */
public class NI7 {
    private long a;
    private String b;

    public NI7(long j, String str) {
        this.a = j;
        this.b = str;
    }

    public long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a == ((NI7) obj).a;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }
}
