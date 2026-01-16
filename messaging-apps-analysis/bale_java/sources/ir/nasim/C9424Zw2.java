package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Zw2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9424Zw2 {
    public static final C9424Zw2 c = new C9424Zw2("");
    private final C10027ax2 a;
    private transient C9424Zw2 b;

    public C9424Zw2(String str) {
        if (str == null) {
            a(1);
        }
        this.a = new C10027ax2(str, this);
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            case 8:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static C9424Zw2 k(C6432No4 c6432No4) {
        if (c6432No4 == null) {
            a(13);
        }
        return new C9424Zw2(C10027ax2.m(c6432No4));
    }

    public String b() {
        String strB = this.a.b();
        if (strB == null) {
            a(4);
        }
        return strB;
    }

    public C9424Zw2 c(C6432No4 c6432No4) {
        if (c6432No4 == null) {
            a(8);
        }
        return new C9424Zw2(this.a.c(c6432No4), this);
    }

    public boolean d() {
        return this.a.e();
    }

    public C9424Zw2 e() {
        C9424Zw2 c9424Zw2 = this.b;
        if (c9424Zw2 != null) {
            if (c9424Zw2 == null) {
                a(6);
            }
            return c9424Zw2;
        }
        if (d()) {
            throw new IllegalStateException("root");
        }
        C9424Zw2 c9424Zw22 = new C9424Zw2(this.a.g());
        this.b = c9424Zw22;
        return c9424Zw22;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9424Zw2) && this.a.equals(((C9424Zw2) obj).a);
    }

    public List f() {
        List listH = this.a.h();
        if (listH == null) {
            a(11);
        }
        return listH;
    }

    public C6432No4 g() {
        C6432No4 c6432No4I = this.a.i();
        if (c6432No4I == null) {
            a(9);
        }
        return c6432No4I;
    }

    public C6432No4 h() {
        C6432No4 c6432No4J = this.a.j();
        if (c6432No4J == null) {
            a(10);
        }
        return c6432No4J;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i(C6432No4 c6432No4) {
        if (c6432No4 == null) {
            a(12);
        }
        return this.a.k(c6432No4);
    }

    public C10027ax2 j() {
        C10027ax2 c10027ax2 = this.a;
        if (c10027ax2 == null) {
            a(5);
        }
        return c10027ax2;
    }

    public String toString() {
        return this.a.toString();
    }

    public C9424Zw2(C10027ax2 c10027ax2) {
        if (c10027ax2 == null) {
            a(2);
        }
        this.a = c10027ax2;
    }

    private C9424Zw2(C10027ax2 c10027ax2, C9424Zw2 c9424Zw2) {
        if (c10027ax2 == null) {
            a(3);
        }
        this.a = c10027ax2;
        this.b = c9424Zw2;
    }
}
