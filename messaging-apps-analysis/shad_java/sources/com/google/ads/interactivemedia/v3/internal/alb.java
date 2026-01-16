package com.google.ads.interactivemedia.v3.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class alb implements Closeable {
    private static final char[] b = ")]}'\n".toCharArray();
    private final Reader c;
    private long j;
    private int k;
    private String l;
    private int[] m;
    private String[] o;
    private int[] p;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    int a = 0;
    private int n = 1;

    static {
        aht.a = new ala();
    }

    public alb(Reader reader) {
        int[] iArr = new int[32];
        this.m = iArr;
        iArr[0] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.c = reader;
    }

    private final void A() throws IOException {
        if (!this.d) {
            throw D("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private final void B() throws IOException {
        char c;
        do {
            if (this.f >= this.g && !y(1)) {
                return;
            }
            char[] cArr = this.e;
            int i = this.f;
            int i2 = i + 1;
            this.f = i2;
            c = cArr[i];
            if (c == '\n') {
                this.h++;
                this.i = i2;
                return;
            }
        } while (c != '\r');
    }

    private final char C() throws IOException {
        int i;
        if (this.f == this.g && !y(1)) {
            throw D("Unterminated escape sequence");
        }
        char[] cArr = this.e;
        int i2 = this.f;
        int i3 = i2 + 1;
        this.f = i3;
        char c = cArr[i2];
        if (c == '\n') {
            this.h++;
            this.i = i3;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return '\r';
            }
            if (c == 't') {
                return '\t';
            }
            if (c != 'u') {
                throw D("Invalid escape sequence");
            }
            if (i3 + 4 > this.g && !y(4)) {
                throw D("Unterminated escape sequence");
            }
            int i4 = this.f;
            int i5 = i4 + 4;
            char c2 = 0;
            while (i4 < i5) {
                char c3 = this.e[i4];
                char c4 = (char) (c2 << 4);
                if (c3 >= '0' && c3 <= '9') {
                    i = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i = c3 - 'W';
                } else {
                    if (c3 < 'A' || c3 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                    }
                    i = c3 - '7';
                }
                c2 = (char) (c4 + i);
                i4++;
            }
            this.f += 4;
            return c2;
        }
        return c;
    }

    private final IOException D(String str) throws IOException {
        throw new ale(str + t());
    }

    private final boolean n(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        A();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        r1 = r2 - r3;
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r1 + r1, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String u(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.e
            r1 = 0
        L3:
            int r2 = r9.f
            int r3 = r9.g
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5d
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L29
            r9.f = r7
            int r7 = r7 - r3
            int r7 = r7 + (-1)
            if (r1 != 0) goto L21
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L21:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L29:
            r8 = 92
            if (r2 != r8) goto L50
            r9.f = r7
            int r7 = r7 - r3
            int r7 = r7 + (-1)
            if (r1 != 0) goto L41
            int r1 = r7 + 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + r1
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L41:
            r1.append(r0, r3, r7)
            char r2 = r9.C()
            r1.append(r2)
            int r2 = r9.f
            int r3 = r9.g
            goto L7
        L50:
            r5 = 10
            if (r2 != r5) goto L5b
            int r2 = r9.h
            int r2 = r2 + r6
            r9.h = r2
            r9.i = r7
        L5b:
            r2 = r7
            goto L9
        L5d:
            if (r1 != 0) goto L6c
            int r1 = r2 - r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = r1 + r1
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f = r2
            boolean r2 = r9.y(r6)
            if (r2 == 0) goto L7a
            goto L3
        L7a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.D(r10)
            goto L82
        L81:
            throw r10
        L82:
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.alb.u(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        A();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String v() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r5.f
            int r3 = r3 + r2
            int r4 = r5.g
            if (r3 >= r4) goto L4c
            char[] r4 = r5.e
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.A()
            goto L58
        L4c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r5.y(r3)
            if (r3 != 0) goto L3
        L58:
            r0 = r2
            goto L7a
        L5a:
            if (r1 != 0) goto L67
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L67:
            char[] r3 = r5.e
            int r4 = r5.f
            r1.append(r3, r4, r2)
            int r3 = r5.f
            int r3 = r3 + r2
            r5.f = r3
            r2 = 1
            boolean r2 = r5.y(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r1 != 0) goto L86
            java.lang.String r1 = new java.lang.String
            char[] r2 = r5.e
            int r3 = r5.f
            r1.<init>(r2, r3, r0)
            goto L91
        L86:
            char[] r2 = r5.e
            int r3 = r5.f
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L91:
            int r2 = r5.f
            int r2 = r2 + r0
            r5.f = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.alb.v():java.lang.String");
    }

    private final void w(char c) throws IOException {
        char[] cArr = this.e;
        do {
            int i = this.f;
            int i2 = this.g;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.f = i3;
                    C();
                    i = this.f;
                    i2 = this.g;
                } else {
                    if (c2 == '\n') {
                        this.h++;
                        this.i = i3;
                    }
                    i = i3;
                }
            }
            this.f = i;
        } while (y(1));
        throw D("Unterminated string");
    }

    private final void x(int i) {
        int i2 = this.n;
        int[] iArr = this.m;
        if (i2 == iArr.length) {
            int i3 = i2 + i2;
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            String[] strArr = new String[i3];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.p, 0, iArr3, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr2;
            this.p = iArr3;
            this.o = strArr;
        }
        int[] iArr4 = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iArr4[i4] = i;
    }

    private final boolean y(int i) throws IOException {
        int i2;
        char[] cArr = this.e;
        int i3 = this.i;
        int i4 = this.f;
        this.i = i3 - i4;
        int i5 = this.g;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.g = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            Reader reader = this.c;
            int i7 = this.g;
            int i8 = reader.read(cArr, i7, 1024 - i7);
            if (i8 == -1) {
                return false;
            }
            i2 = this.g + i8;
            this.g = i2;
            if (this.h == 0 && this.i == 0 && i2 > 0 && cArr[0] == 65279) {
                this.f++;
                this.i = 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private final int z(boolean z) throws IOException {
        int i;
        char[] cArr = this.e;
        int i2 = this.f;
        int i3 = this.g;
        while (true) {
            if (i2 == i3) {
                this.f = i2;
                if (!y(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + t());
                }
                i2 = this.f;
                i3 = this.g;
            }
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.h++;
                this.i = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f = i4;
                    if (i4 == i3) {
                        this.f = i4 - 1;
                        boolean zY = y(2);
                        this.f++;
                        if (!zY) {
                            return 47;
                        }
                    }
                    A();
                    int i5 = this.f;
                    char c2 = cArr[i5];
                    if (c2 == '*') {
                        this.f = i5 + 1;
                        while (true) {
                            if (this.f + 2 > this.g && !y(2)) {
                                throw D("Unterminated comment");
                            }
                            char[] cArr2 = this.e;
                            int i6 = this.f;
                            if (cArr2[i6] != '\n') {
                                while (i < 2) {
                                    i = this.e[this.f + i] == "*/".charAt(i) ? i + 1 : 0;
                                }
                                i2 = 2 + this.f;
                                i3 = this.g;
                                break;
                            }
                            this.h++;
                            this.i = i6 + 1;
                            this.f++;
                        }
                    } else {
                        if (c2 != '/') {
                            return 47;
                        }
                        this.f = i5 + 1;
                        B();
                        i2 = this.f;
                        i3 = this.g;
                    }
                } else {
                    if (c != '#') {
                        this.f = i4;
                        return c;
                    }
                    this.f = i4;
                    A();
                    B();
                    i2 = this.f;
                    i3 = this.g;
                }
            }
            i2 = i4;
        }
    }

    public void a() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 3) {
            x(1);
            this.p[this.n - 1] = 0;
            this.a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + ((Object) alc.a(p())) + t());
        }
    }

    public void b() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + ((Object) alc.a(p())) + t());
        }
        int i = this.n - 1;
        this.n = i;
        int[] iArr = this.p;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.a = 0;
    }

    public void c() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 1) {
            x(3);
            this.a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + ((Object) alc.a(p())) + t());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a = 0;
        this.m[0] = 8;
        this.n = 1;
        this.c.close();
    }

    public void d() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + ((Object) alc.a(p())) + t());
        }
        int i = this.n - 1;
        this.n = i;
        this.o[i] = null;
        int[] iArr = this.p;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.a = 0;
    }

    public boolean e() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        return (iS == 2 || iS == 4) ? false : true;
    }

    public String f() throws IOException {
        String strU;
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 14) {
            strU = v();
        } else if (iS == 12) {
            strU = u('\'');
        } else {
            if (iS != 13) {
                throw new IllegalStateException("Expected a name but was " + ((Object) alc.a(p())) + t());
            }
            strU = u('\"');
        }
        this.a = 0;
        this.o[this.n - 1] = strU;
        return strU;
    }

    public String g() throws IOException {
        String str;
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 10) {
            str = v();
        } else if (iS == 8) {
            str = u('\'');
        } else if (iS == 9) {
            str = u('\"');
        } else if (iS == 11) {
            str = this.l;
            this.l = null;
        } else if (iS == 15) {
            str = Long.toString(this.j);
        } else {
            if (iS != 16) {
                throw new IllegalStateException("Expected a string but was " + ((Object) alc.a(p())) + t());
            }
            str = new String(this.e, this.f, this.k);
            this.f += this.k;
        }
        this.a = 0;
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public boolean h() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 5) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iS == 6) {
            this.a = 0;
            int[] iArr2 = this.p;
            int i2 = this.n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + ((Object) alc.a(p())) + t());
    }

    public void i() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 7) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + ((Object) alc.a(p())) + t());
    }

    public double j() throws IOException, NumberFormatException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 15) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iS == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (iS == 8 || iS == 9) {
            this.l = u(iS == 8 ? '\'' : '\"');
        } else if (iS == 10) {
            this.l = v();
        } else if (iS != 11) {
            throw new IllegalStateException("Expected a double but was " + ((Object) alc.a(p())) + t());
        }
        this.a = 11;
        double d = Double.parseDouble(this.l);
        if (!this.d && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new ale("JSON forbids NaN and infinities: " + d + t());
        }
        this.l = null;
        this.a = 0;
        int[] iArr2 = this.p;
        int i2 = this.n - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public long k() throws IOException, NumberFormatException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 15) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iS == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else {
            if (iS != 8 && iS != 9 && iS != 10) {
                throw new IllegalStateException("Expected a long but was " + ((Object) alc.a(p())) + t());
            }
            if (iS == 10) {
                this.l = v();
            } else {
                this.l = u(iS == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.l);
                this.a = 0;
                int[] iArr2 = this.p;
                int i2 = this.n - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.a = 11;
        double d = Double.parseDouble(this.l);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.l + t());
        }
        this.l = null;
        this.a = 0;
        int[] iArr3 = this.p;
        int i3 = this.n - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    public int l() throws IOException, NumberFormatException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 15) {
            long j = this.j;
            int i = (int) j;
            if (j == i) {
                this.a = 0;
                int[] iArr = this.p;
                int i2 = this.n - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new NumberFormatException("Expected an int but was " + this.j + t());
        }
        if (iS == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else {
            if (iS != 8 && iS != 9 && iS != 10) {
                throw new IllegalStateException("Expected an int but was " + ((Object) alc.a(p())) + t());
            }
            if (iS == 10) {
                this.l = v();
            } else {
                this.l = u(iS == 8 ? '\'' : '\"');
            }
            try {
                int i3 = Integer.parseInt(this.l);
                this.a = 0;
                int[] iArr2 = this.p;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.a = 11;
        double d = Double.parseDouble(this.l);
        int i5 = (int) d;
        if (i5 != d) {
            throw new NumberFormatException("Expected an int but was " + this.l + t());
        }
        this.l = null;
        this.a = 0;
        int[] iArr3 = this.p;
        int i6 = this.n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        A();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:60:0x0097. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.alb.m():void");
    }

    public String o() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.n;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.m[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.p[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.o[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public int p() throws IOException {
        int iS = this.a;
        if (iS == 0) {
            iS = s();
        }
        switch (iS) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }

    public final void q(boolean z) {
        this.d = z;
    }

    public final boolean r() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0188 A[EDGE_INSN: B:263:0x0188->B:111:0x0188 BREAK  A[LOOP:0: B:107:0x0180->B:197:0x0263], EDGE_INSN: B:264:0x0188->B:111:0x0188 BREAK  A[LOOP:0: B:107:0x0180->B:197:0x0263], EDGE_INSN: B:265:0x0188->B:111:0x0188 BREAK  A[LOOP:0: B:107:0x0180->B:197:0x0263], EDGE_INSN: B:266:0x0188->B:111:0x0188 BREAK  A[LOOP:0: B:107:0x0180->B:197:0x0263], EDGE_INSN: B:267:0x0188->B:111:0x0188 BREAK  A[LOOP:0: B:107:0x0180->B:197:0x0263], EDGE_INSN: B:268:0x0188->B:111:0x0188 BREAK  A[LOOP:0: B:107:0x0180->B:197:0x0263]] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x026a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0286 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int s() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.alb.s():int");
    }

    String t() {
        return " at line " + (this.h + 1) + " column " + ((this.f - this.i) + 1) + " path " + o();
    }

    public String toString() {
        return getClass().getSimpleName() + t();
    }
}
