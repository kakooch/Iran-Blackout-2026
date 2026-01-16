package ir.nasim;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.ul3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C22155ul3 implements Closeable, Flushable {
    private static final Pattern j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] k = new String[128];
    private static final String[] l;
    private final Writer a;
    private int[] b = new int[32];
    private int c = 0;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;

    static {
        for (int i = 0; i <= 31; i++) {
            k[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C22155ul3(Writer writer) {
        z(6);
        this.e = ":";
        this.i = true;
        Objects.requireNonNull(writer, "out == null");
        this.a = writer;
    }

    private void G(int i) {
        this.b[this.c - 1] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void M(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = ir.nasim.C22155ul3.l
            goto L9
        L7:
            java.lang.String[] r0 = ir.nasim.C22155ul3.k
        L9:
            java.io.Writer r1 = r8.a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22155ul3.M(java.lang.String):void");
    }

    private void a() throws IOException {
        int iY = y();
        if (iY == 5) {
            this.a.write(44);
        } else if (iY != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        q();
        G(4);
    }

    private void b() throws IOException {
        int iY = y();
        if (iY == 1) {
            G(2);
            q();
            return;
        }
        if (iY == 2) {
            this.a.append(',');
            q();
        } else {
            if (iY == 4) {
                this.a.append((CharSequence) this.e);
                G(5);
                return;
            }
            if (iY != 6) {
                if (iY != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            G(7);
        }
    }

    private void d0() throws IOException {
        if (this.h != null) {
            a();
            M(this.h);
            this.h = null;
        }
    }

    private C22155ul3 e(int i, int i2, char c) throws IOException {
        int iY = y();
        if (iY != i2 && iY != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.h != null) {
            throw new IllegalStateException("Dangling name: " + this.h);
        }
        this.c--;
        if (iY == i2) {
            q();
        }
        this.a.write(c);
        return this;
    }

    private static boolean n(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void q() throws IOException {
        if (this.d == null) {
            return;
        }
        this.a.write(10);
        int i = this.c;
        for (int i2 = 1; i2 < i; i2++) {
            this.a.write(this.d);
        }
    }

    private C22155ul3 u(int i, char c) throws IOException {
        b();
        z(i);
        this.a.write(c);
        return this;
    }

    private int y() {
        int i = this.c;
        if (i != 0) {
            return this.b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void z(int i) {
        int i2 = this.c;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            this.b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = i;
    }

    public final void D(boolean z) {
        this.f = z;
    }

    public final void H(boolean z) {
        this.g = z;
    }

    public final void J(String str) {
        if (str.length() == 0) {
            this.d = null;
            this.e = ":";
        } else {
            this.d = str;
            this.e = ": ";
        }
    }

    public final void K(boolean z) {
        this.i = z;
    }

    public C22155ul3 P(double d) throws IOException {
        d0();
        if (this.f || !(Double.isNaN(d) || Double.isInfinite(d))) {
            b();
            this.a.append((CharSequence) Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public C22155ul3 S(long j2) throws IOException {
        d0();
        b();
        this.a.write(Long.toString(j2));
        return this;
    }

    public C22155ul3 T(Boolean bool) throws IOException {
        if (bool == null) {
            return s();
        }
        d0();
        b();
        this.a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public C22155ul3 U(Number number) throws IOException {
        if (number == null) {
            return s();
        }
        d0();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!n(cls) && !j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        b();
        this.a.append((CharSequence) string);
        return this;
    }

    public C22155ul3 X(String str) throws IOException {
        if (str == null) {
            return s();
        }
        d0();
        b();
        M(str);
        return this;
    }

    public C22155ul3 Z(boolean z) throws IOException {
        d0();
        b();
        this.a.write(z ? "true" : "false");
        return this;
    }

    public C22155ul3 c() throws IOException {
        d0();
        return u(1, '[');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        int i = this.c;
        if (i > 1 || (i == 1 && this.b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.c = 0;
    }

    public C22155ul3 d() throws IOException {
        d0();
        return u(3, '{');
    }

    public void flush() throws IOException {
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.a.flush();
    }

    public C22155ul3 g() {
        return e(1, 2, ']');
    }

    public C22155ul3 j() {
        return e(3, 5, '}');
    }

    public final boolean k() {
        return this.i;
    }

    public final boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.f;
    }

    public C22155ul3 p(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.h != null) {
            throw new IllegalStateException();
        }
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.h = str;
        return this;
    }

    public C22155ul3 s() throws IOException {
        if (this.h != null) {
            if (!this.i) {
                this.h = null;
                return this;
            }
            d0();
        }
        b();
        this.a.write("null");
        return this;
    }
}
