package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Hl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C4996Hl3 {
    private final String a;
    private C9424Zw2 b;

    private C4996Hl3(String str) {
        if (str == null) {
            a(5);
        }
        this.a = str;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C4996Hl3 b(C24948zU0 c24948zU0) {
        if (c24948zU0 == null) {
            a(1);
        }
        C9424Zw2 c9424Zw2H = c24948zU0.h();
        String strReplace = c24948zU0.i().b().replace('.', '$');
        if (c9424Zw2H.d()) {
            return new C4996Hl3(strReplace);
        }
        return new C4996Hl3(c9424Zw2H.b().replace('.', '/') + Separators.SLASH + strReplace);
    }

    public static C4996Hl3 c(C9424Zw2 c9424Zw2) {
        if (c9424Zw2 == null) {
            a(2);
        }
        C4996Hl3 c4996Hl3 = new C4996Hl3(c9424Zw2.b().replace('.', '/'));
        c4996Hl3.b = c9424Zw2;
        return c4996Hl3;
    }

    public static C4996Hl3 d(String str) {
        if (str == null) {
            a(0);
        }
        return new C4996Hl3(str);
    }

    public C9424Zw2 e() {
        return new C9424Zw2(this.a.replace('/', '.'));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((C4996Hl3) obj).a);
    }

    public String f() {
        String str = this.a;
        if (str == null) {
            a(8);
        }
        return str;
    }

    public C9424Zw2 g() {
        int iLastIndexOf = this.a.lastIndexOf(Separators.SLASH);
        if (iLastIndexOf != -1) {
            return new C9424Zw2(this.a.substring(0, iLastIndexOf).replace('/', '.'));
        }
        C9424Zw2 c9424Zw2 = C9424Zw2.c;
        if (c9424Zw2 == null) {
            a(7);
        }
        return c9424Zw2;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
