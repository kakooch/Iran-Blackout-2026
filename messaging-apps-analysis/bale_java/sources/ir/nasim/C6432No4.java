package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.No4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6432No4 implements Comparable {
    private final String a;
    private final boolean b;

    private C6432No4(String str, boolean z) {
        if (str == null) {
            a(0);
        }
        this.a = str;
        this.b = z;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C6432No4 o(String str) {
        if (str == null) {
            a(6);
        }
        return str.startsWith(Separators.LESS_THAN) ? s(str) : p(str);
    }

    public static C6432No4 p(String str) {
        if (str == null) {
            a(3);
        }
        return new C6432No4(str, false);
    }

    public static boolean r(String str) {
        if (str == null) {
            a(4);
        }
        if (str.isEmpty() || str.startsWith(Separators.LESS_THAN)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static C6432No4 s(String str) {
        if (str == null) {
            a(5);
        }
        if (str.startsWith(Separators.LESS_THAN)) {
            return new C6432No4(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6432No4)) {
            return false;
        }
        C6432No4 c6432No4 = (C6432No4) obj;
        return this.b == c6432No4.b && this.a.equals(c6432No4.a);
    }

    public String h() {
        String str = this.a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(C6432No4 c6432No4) {
        return this.a.compareTo(c6432No4.a);
    }

    public String j() {
        if (this.b) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strH = h();
        if (strH == null) {
            a(2);
        }
        return strH;
    }

    public boolean q() {
        return this.b;
    }

    public String toString() {
        return this.a;
    }
}
