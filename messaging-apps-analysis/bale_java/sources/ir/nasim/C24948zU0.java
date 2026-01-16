package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.zU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24948zU0 {
    private final C9424Zw2 a;
    private final C9424Zw2 b;
    private final boolean c;

    public C24948zU0(C9424Zw2 c9424Zw2, C9424Zw2 c9424Zw22, boolean z) {
        if (c9424Zw2 == null) {
            a(1);
        }
        if (c9424Zw22 == null) {
            a(2);
        }
        this.a = c9424Zw2;
        this.b = c9424Zw22;
        this.c = z;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6 && i != 7 && i != 9 && i != 13 && i != 14) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C24948zU0 e(String str) {
        if (str == null) {
            a(11);
        }
        return f(str, false);
    }

    public static C24948zU0 f(String str, boolean z) {
        if (str == null) {
            a(12);
        }
        return new C24948zU0(new C9424Zw2(AbstractC20762sZ6.i1(str, '/', "").replace('/', '.')), new C9424Zw2(AbstractC20762sZ6.a1(str, '/', str)), z);
    }

    public static C24948zU0 m(C9424Zw2 c9424Zw2) {
        if (c9424Zw2 == null) {
            a(0);
        }
        return new C24948zU0(c9424Zw2.e(), c9424Zw2.g());
    }

    public C9424Zw2 b() {
        if (this.a.d()) {
            C9424Zw2 c9424Zw2 = this.b;
            if (c9424Zw2 == null) {
                a(9);
            }
            return c9424Zw2;
        }
        return new C9424Zw2(this.a.b() + Separators.DOT + this.b.b());
    }

    public String c() {
        if (this.a.d()) {
            String strB = this.b.b();
            if (strB == null) {
                a(13);
            }
            return strB;
        }
        String str = this.a.b().replace('.', '/') + Separators.SLASH + this.b.b();
        if (str == null) {
            a(14);
        }
        return str;
    }

    public C24948zU0 d(C6432No4 c6432No4) {
        if (c6432No4 == null) {
            a(8);
        }
        return new C24948zU0(h(), this.b.c(c6432No4), this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C24948zU0.class != obj.getClass()) {
            return false;
        }
        C24948zU0 c24948zU0 = (C24948zU0) obj;
        return this.a.equals(c24948zU0.a) && this.b.equals(c24948zU0.b) && this.c == c24948zU0.c;
    }

    public C24948zU0 g() {
        C9424Zw2 c9424Zw2E = this.b.e();
        if (c9424Zw2E.d()) {
            return null;
        }
        return new C24948zU0(h(), c9424Zw2E, this.c);
    }

    public C9424Zw2 h() {
        C9424Zw2 c9424Zw2 = this.a;
        if (c9424Zw2 == null) {
            a(5);
        }
        return c9424Zw2;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.valueOf(this.c).hashCode();
    }

    public C9424Zw2 i() {
        C9424Zw2 c9424Zw2 = this.b;
        if (c9424Zw2 == null) {
            a(6);
        }
        return c9424Zw2;
    }

    public C6432No4 j() {
        C6432No4 c6432No4G = this.b.g();
        if (c6432No4G == null) {
            a(7);
        }
        return c6432No4G;
    }

    public boolean k() {
        return this.c;
    }

    public boolean l() {
        return !this.b.e().d();
    }

    public String toString() {
        if (!this.a.d()) {
            return c();
        }
        return Separators.SLASH + c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C24948zU0(C9424Zw2 c9424Zw2, C6432No4 c6432No4) {
        this(c9424Zw2, C9424Zw2.k(c6432No4), false);
        if (c9424Zw2 == null) {
            a(3);
        }
        if (c6432No4 == null) {
            a(4);
        }
    }
}
