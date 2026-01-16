package ir.nasim;

/* renamed from: ir.nasim.yI7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24253yI7 {
    private String a;
    private String b;

    public C24253yI7(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        C24253yI7 c24253yI7;
        String str;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || (str = (c24253yI7 = (C24253yI7) obj).a) == null || !this.a.equals(str)) {
            return false;
        }
        String str2 = this.b;
        String str3 = c24253yI7.b;
        if (str2 != null) {
            if (str2.equals(str3)) {
                return true;
            }
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
