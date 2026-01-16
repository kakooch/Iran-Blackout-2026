package ir.nasim;

/* loaded from: classes2.dex */
public class O47 {
    public final String a;
    public final int b;

    public O47(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O47)) {
            return false;
        }
        O47 o47 = (O47) obj;
        if (this.b != o47.b) {
            return false;
        }
        return this.a.equals(o47.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }
}
