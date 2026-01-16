package ir.nasim;

/* loaded from: classes2.dex */
public final class QW4 {
    public static final a e = new a(null);
    public static final int f = 8;
    private String a;
    private BD2 b;
    private int c = -1;
    private int d = -1;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public QW4(String str) {
        this.a = str;
    }

    public final char a(int i) {
        BD2 bd2 = this.b;
        if (bd2 == null) {
            return this.a.charAt(i);
        }
        if (i < this.c) {
            return this.a.charAt(i);
        }
        int iE = bd2.e();
        int i2 = this.c;
        return i < iE + i2 ? bd2.d(i - i2) : this.a.charAt(i - ((iE - this.d) + i2));
    }

    public final int b() {
        BD2 bd2 = this.b;
        return bd2 == null ? this.a.length() : (this.a.length() - (this.d - this.c)) + bd2.e();
    }

    public final void c(int i, int i2, String str) {
        if (!(i <= i2)) {
            N73.a("start index must be less than or equal to end index: " + i + " > " + i2);
        }
        if (!(i >= 0)) {
            N73.a("start must be non-negative, but was " + i);
        }
        BD2 bd2 = this.b;
        if (bd2 != null) {
            int i3 = this.c;
            int i4 = i - i3;
            int i5 = i2 - i3;
            if (i4 >= 0 && i5 <= bd2.e()) {
                bd2.g(i4, i5, str);
                return;
            }
            this.a = toString();
            this.b = null;
            this.c = -1;
            this.d = -1;
            c(i, i2, str);
            return;
        }
        int iMax = Math.max(255, str.length() + 128);
        char[] cArr = new char[iMax];
        int iMin = Math.min(i, 64);
        int iMin2 = Math.min(this.a.length() - i2, 64);
        int i6 = i - iMin;
        DD2.a(this.a, cArr, 0, i6, i);
        int i7 = iMax - iMin2;
        int i8 = iMin2 + i2;
        DD2.a(this.a, cArr, i7, i2, i8);
        CD2.b(str, cArr, iMin);
        this.b = new BD2(cArr, iMin + str.length(), i7);
        this.c = i6;
        this.d = i8;
    }

    public String toString() {
        BD2 bd2 = this.b;
        if (bd2 == null) {
            return this.a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.a, 0, this.c);
        bd2.a(sb);
        String str = this.a;
        sb.append((CharSequence) str, this.d, str.length());
        return sb.toString();
    }
}
