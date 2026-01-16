package ir.nasim;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;

/* renamed from: ir.nasim.rC6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC19946rC6 implements InterfaceC16991mC6 {
    private static boolean h = true;
    static String[] i = new String[0];
    static Class[] j = new Class[0];
    int a;
    String b;
    String c;
    Class d;
    a e;
    private String f;
    ClassLoader g = null;

    /* renamed from: ir.nasim.rC6$a */
    private interface a {
        void a(int i, String str);

        String get(int i);
    }

    /* renamed from: ir.nasim.rC6$b */
    private static final class b implements a {
        private SoftReference a;

        public b() {
            c();
        }

        private String[] b() {
            return (String[]) this.a.get();
        }

        private String[] c() {
            String[] strArr = new String[3];
            this.a = new SoftReference(strArr);
            return strArr;
        }

        @Override // ir.nasim.AbstractC19946rC6.a
        public void a(int i, String str) {
            String[] strArrB = b();
            if (strArrB == null) {
                strArrB = c();
            }
            strArrB[i] = str;
        }

        @Override // ir.nasim.AbstractC19946rC6.a
        public String get(int i) {
            String[] strArrB = b();
            if (strArrB == null) {
                return null;
            }
            return strArrB[i];
        }
    }

    AbstractC19946rC6(int i2, String str, Class cls) {
        this.a = i2;
        this.b = str;
        this.d = cls;
    }

    private ClassLoader h() {
        if (this.g == null) {
            this.g = getClass().getClassLoader();
        }
        return this.g;
    }

    protected abstract String a(OY6 oy6);

    int b(int i2) {
        return Integer.parseInt(c(i2), 16);
    }

    String c(int i2) {
        int iIndexOf = this.f.indexOf(45);
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i3 = iIndexOf + 1;
            iIndexOf = this.f.indexOf(45, i3);
            i2 = i4;
        }
        if (iIndexOf == -1) {
            iIndexOf = this.f.length();
        }
        return this.f.substring(i3, iIndexOf);
    }

    Class d(int i2) {
        return C20224rf2.b(c(i2), h());
    }

    Class[] e(int i2) {
        StringTokenizer stringTokenizer = new StringTokenizer(c(i2), ":");
        int iCountTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[iCountTokens];
        for (int i3 = 0; i3 < iCountTokens; i3++) {
            clsArr[i3] = C20224rf2.b(stringTokenizer.nextToken(), h());
        }
        return clsArr;
    }

    public Class f() {
        if (this.d == null) {
            this.d = d(2);
        }
        return this.d;
    }

    public String g() {
        if (this.c == null) {
            this.c = f().getName();
        }
        return this.c;
    }

    public int i() {
        if (this.a == -1) {
            this.a = b(0);
        }
        return this.a;
    }

    public String j() {
        if (this.b == null) {
            this.b = c(1);
        }
        return this.b;
    }

    String k(OY6 oy6) {
        String strA;
        if (h) {
            a aVar = this.e;
            if (aVar == null) {
                try {
                    this.e = new b();
                } catch (Throwable unused) {
                    h = false;
                }
                strA = null;
            } else {
                strA = aVar.get(oy6.i);
            }
        } else {
            strA = null;
        }
        if (strA == null) {
            strA = a(oy6);
        }
        if (h) {
            this.e.a(oy6.i, strA);
        }
        return strA;
    }

    public final String toString() {
        return k(OY6.k);
    }
}
