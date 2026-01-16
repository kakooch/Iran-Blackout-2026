package ir.nasim;

import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: ir.nasim.el3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C12523el3 implements Closeable {
    private final Reader a;
    private long i;
    private int j;
    private String k;
    private int[] l;
    private String[] n;
    private int[] o;
    private boolean b = false;
    private final char[] c = new char[1024];
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    int h = 0;
    private int m = 1;

    /* renamed from: ir.nasim.el3$a */
    class a extends AbstractC13159fl3 {
        a() {
        }

        @Override // ir.nasim.AbstractC13159fl3
        public void a(C12523el3 c12523el3) throws IOException {
            int iD = c12523el3.h;
            if (iD == 0) {
                iD = c12523el3.d();
            }
            if (iD == 13) {
                c12523el3.h = 9;
                return;
            }
            if (iD == 12) {
                c12523el3.h = 8;
                return;
            }
            if (iD == 14) {
                c12523el3.h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + c12523el3.G() + c12523el3.p());
        }
    }

    static {
        AbstractC13159fl3.a = new a();
    }

    public C12523el3(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.a = reader;
    }

    private int H() {
        String str;
        String str2;
        int i;
        char c = this.c[this.d];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.d + i2 >= this.e && !g(i2 + 1)) {
                return 0;
            }
            char c2 = this.c[this.d + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.d + length < this.e || g(length + 1)) && n(this.c[this.d + length])) {
            return 0;
        }
        this.d += length;
        this.h = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (n(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
    
        r18.i = r11;
        r18.d += r8;
        r18.h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c2, code lost:
    
        r18.j = r8;
        r18.h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c9, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int J() {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12523el3.J():int");
    }

    private void K(int i) {
        int i2 = this.m;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.l = Arrays.copyOf(iArr, i3);
            this.o = Arrays.copyOf(this.o, i3);
            this.n = (String[]) Arrays.copyOf(this.n, i3);
        }
        int[] iArr2 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr2[i4] = i;
    }

    private char M() throws IOException {
        int i;
        if (this.d == this.e && !g(1)) {
            throw X("Unterminated escape sequence");
        }
        char[] cArr = this.c;
        int i2 = this.d;
        int i3 = i2 + 1;
        this.d = i3;
        char c = cArr[i2];
        if (c == '\n') {
            this.f++;
            this.g = i3;
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
                throw X("Invalid escape sequence");
            }
            if (i2 + 5 > this.e && !g(4)) {
                throw X("Unterminated escape sequence");
            }
            int i4 = this.d;
            int i5 = i4 + 4;
            char c2 = 0;
            while (i4 < i5) {
                char c3 = this.c[i4];
                char c4 = (char) (c2 << 4);
                if (c3 >= '0' && c3 <= '9') {
                    i = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i = c3 - 'W';
                } else {
                    if (c3 < 'A' || c3 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.c, this.d, 4));
                    }
                    i = c3 - '7';
                }
                c2 = (char) (c4 + i);
                i4++;
            }
            this.d += 4;
            return c2;
        }
        return c;
    }

    private void P(char c) throws IOException {
        char[] cArr = this.c;
        do {
            int i = this.d;
            int i2 = this.e;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.d = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.d = i3;
                    M();
                    i = this.d;
                    i2 = this.e;
                } else {
                    if (c2 == '\n') {
                        this.f++;
                        this.g = i3;
                    }
                    i = i3;
                }
            }
            this.d = i;
        } while (g(1));
        throw X("Unterminated string");
    }

    private boolean S(String str) {
        int length = str.length();
        while (true) {
            if (this.d + length > this.e && !g(length)) {
                return false;
            }
            char[] cArr = this.c;
            int i = this.d;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.c[this.d + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.f++;
            this.g = i + 1;
            this.d++;
        }
    }

    private void T() {
        char c;
        do {
            if (this.d >= this.e && !g(1)) {
                return;
            }
            char[] cArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            c = cArr[i];
            if (c == '\n') {
                this.f++;
                this.g = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        b();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void U() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.d
            int r2 = r1 + r0
            int r3 = r4.e
            if (r2 >= r3) goto L51
            char[] r2 = r4.c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.b()
        L4b:
            int r1 = r4.d
            int r1 = r1 + r0
            r4.d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.d = r1
            r0 = 1
            boolean r0 = r4.g(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12523el3.U():void");
    }

    private IOException X(String str) throws MalformedJsonException {
        throw new MalformedJsonException(str + p());
    }

    private void b() throws IOException {
        if (!this.b) {
            throw X("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void c() throws IOException {
        s(true);
        int i = this.d;
        this.d = i - 1;
        if (i + 4 <= this.e || g(5)) {
            int i2 = this.d;
            char[] cArr = this.c;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.d = i2 + 5;
            }
        }
    }

    private boolean g(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.c;
        int i4 = this.g;
        int i5 = this.d;
        this.g = i4 - i5;
        int i6 = this.e;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.e = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.e = 0;
        }
        this.d = 0;
        do {
            Reader reader = this.a;
            int i8 = this.e;
            int i9 = reader.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.e + i9;
            this.e = i2;
            if (this.f == 0 && (i3 = this.g) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.d++;
                this.g = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private String j(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (true) {
            int i2 = this.m;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.l[i];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.o[i];
                if (z && i4 > 0 && i == i2 - 1) {
                    i4--;
                }
                sb.append('[');
                sb.append(i4);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.n[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private boolean n(char c) throws IOException {
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
        b();
        return false;
    }

    private int s(boolean z) throws IOException {
        char[] cArr = this.c;
        int i = this.d;
        int i2 = this.e;
        while (true) {
            if (i == i2) {
                this.d = i;
                if (!g(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + p());
                }
                i = this.d;
                i2 = this.e;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f++;
                this.g = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.d = i3;
                    if (i3 == i2) {
                        this.d = i;
                        boolean zG = g(2);
                        this.d++;
                        if (!zG) {
                            return c;
                        }
                    }
                    b();
                    int i4 = this.d;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.d = i4 + 1;
                        if (!S("*/")) {
                            throw X("Unterminated comment");
                        }
                        i = this.d + 2;
                        i2 = this.e;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.d = i4 + 1;
                        T();
                        i = this.d;
                        i2 = this.e;
                    }
                } else {
                    if (c != '#') {
                        this.d = i3;
                        return c;
                    }
                    this.d = i3;
                    b();
                    T();
                    i = this.d;
                    i2 = this.e;
                }
            }
            i = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String y(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.c
            r1 = 0
        L3:
            int r2 = r9.d
            int r3 = r9.e
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.d = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.M()
            r1.append(r2)
            int r2 = r9.d
            int r3 = r9.e
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.f
            int r2 = r2 + r6
            r9.f = r2
            r9.g = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.d = r2
            boolean r2 = r9.g(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.X(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12523el3.y(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        b();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String z() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.d
            int r4 = r3 + r2
            int r5 = r6.e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.b()
            goto L5c
        L4e:
            char[] r3 = r6.c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.g(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.c
            int r4 = r6.d
            r0.append(r3, r4, r2)
            int r3 = r6.d
            int r3 = r3 + r2
            r6.d = r3
            r2 = 1
            boolean r2 = r6.g(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.c
            int r3 = r6.d
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.c
            int r3 = r6.d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.d
            int r2 = r2 + r1
            r6.d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12523el3.z():java.lang.String");
    }

    public String A() {
        return j(false);
    }

    public void B() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 1) {
            K(3);
            this.h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + G() + p());
        }
    }

    public final void D(boolean z) {
        this.b = z;
    }

    public void F() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + G() + p());
        }
        int i = this.m;
        int i2 = i - 1;
        this.m = i2;
        this.n[i2] = null;
        int[] iArr = this.o;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.h = 0;
    }

    public EnumC16723ll3 G() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        switch (iD) {
            case 1:
                return EnumC16723ll3.BEGIN_OBJECT;
            case 2:
                return EnumC16723ll3.END_OBJECT;
            case 3:
                return EnumC16723ll3.BEGIN_ARRAY;
            case 4:
                return EnumC16723ll3.END_ARRAY;
            case 5:
            case 6:
                return EnumC16723ll3.BOOLEAN;
            case 7:
                return EnumC16723ll3.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return EnumC16723ll3.STRING;
            case 12:
            case 13:
            case 14:
                return EnumC16723ll3.NAME;
            case 15:
            case 16:
                return EnumC16723ll3.NUMBER;
            case 17:
                return EnumC16723ll3.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public long K1() throws IOException, NumberFormatException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iD == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (iD != 8 && iD != 9 && iD != 10) {
                throw new IllegalStateException("Expected a long but was " + G() + p());
            }
            if (iD == 10) {
                this.k = z();
            } else {
                this.k = y(iD == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i2 = this.m - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.k + p());
        }
        this.k = null;
        this.h = 0;
        int[] iArr3 = this.o;
        int i3 = this.m - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void R() throws IOException {
        int i = 0;
        do {
            int iD = this.h;
            if (iD == 0) {
                iD = d();
            }
            switch (iD) {
                case 1:
                    K(3);
                    i++;
                    this.h = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.n[this.m - 1] = null;
                    }
                    this.m--;
                    i--;
                    this.h = 0;
                    break;
                case 3:
                    K(1);
                    i++;
                    this.h = 0;
                    break;
                case 4:
                    this.m--;
                    i--;
                    this.h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.h = 0;
                    break;
                case 8:
                    P('\'');
                    this.h = 0;
                    break;
                case 9:
                    P('\"');
                    this.h = 0;
                    break;
                case 10:
                    U();
                    this.h = 0;
                    break;
                case 12:
                    P('\'');
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 13:
                    P('\"');
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 14:
                    U();
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 16:
                    this.d += this.j;
                    this.h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public String T0() throws IOException {
        String str;
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 10) {
            str = z();
        } else if (iD == 8) {
            str = y('\'');
        } else if (iD == 9) {
            str = y('\"');
        } else if (iD == 11) {
            str = this.k;
            this.k = null;
        } else if (iD == 15) {
            str = Long.toString(this.i);
        } else {
            if (iD != 16) {
                throw new IllegalStateException("Expected a string but was " + G() + p());
            }
            str = new String(this.c, this.d, this.j);
            this.d += this.j;
        }
        this.h = 0;
        int[] iArr = this.o;
        int i = this.m - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public void a() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 3) {
            K(1);
            this.o[this.m - 1] = 0;
            this.h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + G() + p());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h = 0;
        this.l[0] = 8;
        this.m = 1;
        this.a.close();
    }

    int d() throws IOException {
        int iS;
        int[] iArr = this.l;
        int i = this.m;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iS2 = s(true);
            if (iS2 != 44) {
                if (iS2 != 59) {
                    if (iS2 != 93) {
                        throw X("Unterminated array");
                    }
                    this.h = 4;
                    return 4;
                }
                b();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5 && (iS = s(true)) != 44) {
                    if (iS != 59) {
                        if (iS != 125) {
                            throw X("Unterminated object");
                        }
                        this.h = 2;
                        return 2;
                    }
                    b();
                }
                int iS3 = s(true);
                if (iS3 == 34) {
                    this.h = 13;
                    return 13;
                }
                if (iS3 == 39) {
                    b();
                    this.h = 12;
                    return 12;
                }
                if (iS3 == 125) {
                    if (i2 == 5) {
                        throw X("Expected name");
                    }
                    this.h = 2;
                    return 2;
                }
                b();
                this.d--;
                if (!n((char) iS3)) {
                    throw X("Expected name");
                }
                this.h = 14;
                return 14;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iS4 = s(true);
                if (iS4 != 58) {
                    if (iS4 != 61) {
                        throw X("Expected ':'");
                    }
                    b();
                    if (this.d < this.e || g(1)) {
                        char[] cArr = this.c;
                        int i3 = this.d;
                        if (cArr[i3] == '>') {
                            this.d = i3 + 1;
                        }
                    }
                }
            } else if (i2 == 6) {
                if (this.b) {
                    c();
                }
                this.l[this.m - 1] = 7;
            } else if (i2 == 7) {
                if (s(false) == -1) {
                    this.h = 17;
                    return 17;
                }
                b();
                this.d--;
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iS5 = s(true);
        if (iS5 == 34) {
            this.h = 9;
            return 9;
        }
        if (iS5 == 39) {
            b();
            this.h = 8;
            return 8;
        }
        if (iS5 != 44 && iS5 != 59) {
            if (iS5 == 91) {
                this.h = 3;
                return 3;
            }
            if (iS5 != 93) {
                if (iS5 == 123) {
                    this.h = 1;
                    return 1;
                }
                this.d--;
                int iH = H();
                if (iH != 0) {
                    return iH;
                }
                int iJ = J();
                if (iJ != 0) {
                    return iJ;
                }
                if (!n(this.c[this.d])) {
                    throw X("Expected value");
                }
                b();
                this.h = 10;
                return 10;
            }
            if (i2 == 1) {
                this.h = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw X("Unexpected value");
        }
        b();
        this.d--;
        this.h = 7;
        return 7;
    }

    public void e() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + G() + p());
        }
        int i = this.m;
        this.m = i - 1;
        int[] iArr = this.o;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.h = 0;
    }

    public double f1() throws IOException, NumberFormatException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iD == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else if (iD == 8 || iD == 9) {
            this.k = y(iD == 8 ? '\'' : '\"');
        } else if (iD == 10) {
            this.k = z();
        } else if (iD != 11) {
            throw new IllegalStateException("Expected a double but was " + G() + p());
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        if (!this.b && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + p());
        }
        this.k = null;
        this.h = 0;
        int[] iArr2 = this.o;
        int i2 = this.m - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public String k() {
        return j(true);
    }

    public boolean l() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        return (iD == 2 || iD == 4 || iD == 17) ? false : true;
    }

    public final boolean m() {
        return this.b;
    }

    public String n0() throws IOException {
        String strY;
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 14) {
            strY = z();
        } else if (iD == 12) {
            strY = y('\'');
        } else {
            if (iD != 13) {
                throw new IllegalStateException("Expected a name but was " + G() + p());
            }
            strY = y('\"');
        }
        this.h = 0;
        this.n[this.m - 1] = strY;
        return strY;
    }

    String p() {
        return " at line " + (this.f + 1) + " column " + ((this.d - this.g) + 1) + " path " + A();
    }

    public boolean q() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 5) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iD == 6) {
            this.h = 0;
            int[] iArr2 = this.o;
            int i2 = this.m - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + G() + p());
    }

    public int r0() throws IOException, NumberFormatException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            long j = this.i;
            int i = (int) j;
            if (j == i) {
                this.h = 0;
                int[] iArr = this.o;
                int i2 = this.m - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new NumberFormatException("Expected an int but was " + this.i + p());
        }
        if (iD == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (iD != 8 && iD != 9 && iD != 10) {
                throw new IllegalStateException("Expected an int but was " + G() + p());
            }
            if (iD == 10) {
                this.k = z();
            } else {
                this.k = y(iD == 8 ? '\'' : '\"');
            }
            try {
                int i3 = Integer.parseInt(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        int i5 = (int) d;
        if (i5 != d) {
            throw new NumberFormatException("Expected an int but was " + this.k + p());
        }
        this.k = null;
        this.h = 0;
        int[] iArr3 = this.o;
        int i6 = this.m - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public String toString() {
        return getClass().getSimpleName() + p();
    }

    public void u() throws IOException {
        int iD = this.h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 7) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + G() + p());
    }
}
