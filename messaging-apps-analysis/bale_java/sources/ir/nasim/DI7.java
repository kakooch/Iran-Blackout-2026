package ir.nasim;

/* loaded from: classes5.dex */
public class DI7 {
    private String a;
    private String b;

    public DI7(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DI7 di7 = (DI7) obj;
        String str = this.a;
        if (str == null ? di7.a != null : !str.equals(di7.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = di7.b;
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
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
