package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.ax2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10027ax2 {
    private static final C6432No4 e = C6432No4.s("<root>");
    private static final Pattern f = Pattern.compile("\\.");
    private static final UA2 g = new a();
    private final String a;
    private transient C9424Zw2 b;
    private transient C10027ax2 c;
    private transient C6432No4 d;

    /* renamed from: ir.nasim.ax2$a */
    static class a implements UA2 {
        a() {
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C6432No4 invoke(String str) {
            return C6432No4.o(str);
        }
    }

    C10027ax2(String str, C9424Zw2 c9424Zw2) {
        if (str == null) {
            a(0);
        }
        if (c9424Zw2 == null) {
            a(1);
        }
        this.a = str;
        this.b = c9424Zw2;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    private void d() {
        int iLastIndexOf = this.a.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.d = C6432No4.o(this.a.substring(iLastIndexOf + 1));
            this.c = new C10027ax2(this.a.substring(0, iLastIndexOf));
        } else {
            this.d = C6432No4.o(this.a);
            this.c = C9424Zw2.c.j();
        }
    }

    public static C10027ax2 m(C6432No4 c6432No4) {
        if (c6432No4 == null) {
            a(16);
        }
        return new C10027ax2(c6432No4.h(), C9424Zw2.c.j(), c6432No4);
    }

    public String b() {
        String str = this.a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    public C10027ax2 c(C6432No4 c6432No4) {
        String strH;
        if (c6432No4 == null) {
            a(9);
        }
        if (e()) {
            strH = c6432No4.h();
        } else {
            strH = this.a + Separators.DOT + c6432No4.h();
        }
        return new C10027ax2(strH, this, c6432No4);
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C10027ax2) && this.a.equals(((C10027ax2) obj).a);
    }

    public boolean f() {
        return this.b != null || b().indexOf(60) < 0;
    }

    public C10027ax2 g() {
        C10027ax2 c10027ax2 = this.c;
        if (c10027ax2 != null) {
            if (c10027ax2 == null) {
                a(7);
            }
            return c10027ax2;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        C10027ax2 c10027ax22 = this.c;
        if (c10027ax22 == null) {
            a(8);
        }
        return c10027ax22;
    }

    public List h() {
        List listEmptyList = e() ? Collections.emptyList() : AbstractC10242bK.I0(f.split(this.a), g);
        if (listEmptyList == null) {
            a(14);
        }
        return listEmptyList;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public C6432No4 i() {
        C6432No4 c6432No4 = this.d;
        if (c6432No4 != null) {
            if (c6432No4 == null) {
                a(10);
            }
            return c6432No4;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        C6432No4 c6432No42 = this.d;
        if (c6432No42 == null) {
            a(11);
        }
        return c6432No42;
    }

    public C6432No4 j() {
        if (e()) {
            C6432No4 c6432No4 = e;
            if (c6432No4 == null) {
                a(12);
            }
            return c6432No4;
        }
        C6432No4 c6432No4I = i();
        if (c6432No4I == null) {
            a(13);
        }
        return c6432No4I;
    }

    public boolean k(C6432No4 c6432No4) {
        if (c6432No4 == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int iIndexOf = this.a.indexOf(46);
        String str = this.a;
        String strH = c6432No4.h();
        if (iIndexOf == -1) {
            iIndexOf = this.a.length();
        }
        return str.regionMatches(0, strH, 0, iIndexOf);
    }

    public C9424Zw2 l() {
        C9424Zw2 c9424Zw2 = this.b;
        if (c9424Zw2 != null) {
            if (c9424Zw2 == null) {
                a(5);
            }
            return c9424Zw2;
        }
        C9424Zw2 c9424Zw22 = new C9424Zw2(this);
        this.b = c9424Zw22;
        return c9424Zw22;
    }

    public String toString() {
        String strH = e() ? e.h() : this.a;
        if (strH == null) {
            a(17);
        }
        return strH;
    }

    public C10027ax2(String str) {
        if (str == null) {
            a(2);
        }
        this.a = str;
    }

    private C10027ax2(String str, C10027ax2 c10027ax2, C6432No4 c6432No4) {
        if (str == null) {
            a(3);
        }
        this.a = str;
        this.c = c10027ax2;
        this.d = c6432No4;
    }
}
