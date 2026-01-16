package io.sentry.vendor.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class c implements Closeable, Flushable {
    private static final String[] j = new String[128];
    private static final String[] k;
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
            j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        u(6);
        this.e = ":";
        this.i = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.a = writer;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void G(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = io.sentry.vendor.gson.stream.c.k
            goto L9
        L7:
            java.lang.String[] r0 = io.sentry.vendor.gson.stream.c.j
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
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.c.G(java.lang.String):void");
    }

    private void T() throws IOException {
        if (this.h != null) {
            a();
            G(this.h);
            this.h = null;
        }
    }

    private void a() throws IOException {
        int iS = s();
        if (iS == 5) {
            this.a.write(44);
        } else if (iS != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        n();
        y(4);
    }

    private void b() throws IOException {
        int iS = s();
        if (iS == 1) {
            y(2);
            n();
            return;
        }
        if (iS == 2) {
            this.a.append(',');
            n();
        } else {
            if (iS == 4) {
                this.a.append((CharSequence) this.e);
                y(5);
                return;
            }
            if (iS != 6) {
                if (iS != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            y(7);
        }
    }

    private c e(int i, int i2, char c) throws IOException {
        int iS = s();
        if (iS != i2 && iS != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.h != null) {
            throw new IllegalStateException("Dangling name: " + this.h);
        }
        this.c--;
        if (iS == i2) {
            n();
        }
        this.a.write(c);
        return this;
    }

    private void n() throws IOException {
        if (this.d == null) {
            return;
        }
        this.a.write(10);
        int i = this.c;
        for (int i2 = 1; i2 < i; i2++) {
            this.a.write(this.d);
        }
    }

    private c q(int i, char c) throws IOException {
        b();
        u(i);
        this.a.write(c);
        return this;
    }

    private int s() {
        int i = this.c;
        if (i != 0) {
            return this.b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void u(int i) {
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

    private void y(int i) {
        this.b[this.c - 1] = i;
    }

    public final void D(boolean z) {
        this.f = z;
    }

    public c H(double d) throws IOException {
        T();
        if (this.f || !(Double.isNaN(d) || Double.isInfinite(d))) {
            b();
            this.a.append((CharSequence) Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public c J(long j2) throws IOException {
        T();
        b();
        this.a.write(Long.toString(j2));
        return this;
    }

    public c K(Boolean bool) throws IOException {
        if (bool == null) {
            return p();
        }
        T();
        b();
        this.a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c M(Number number) throws IOException {
        if (number == null) {
            return p();
        }
        T();
        String string = number.toString();
        if (this.f || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            b();
            this.a.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c P(String str) throws IOException {
        if (str == null) {
            return p();
        }
        T();
        b();
        G(str);
        return this;
    }

    public c S(boolean z) throws IOException {
        T();
        b();
        this.a.write(z ? "true" : "false");
        return this;
    }

    public c c() throws IOException {
        T();
        return q(1, '[');
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

    public c d() throws IOException {
        T();
        return q(3, '{');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.a.flush();
    }

    public c g() {
        return e(1, 2, ']');
    }

    public c j() {
        return e(3, 5, '}');
    }

    public String k() {
        return this.d;
    }

    public c l(String str) throws IOException {
        if (str == null) {
            return p();
        }
        T();
        b();
        this.a.append((CharSequence) str);
        return this;
    }

    public c m(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.h != null) {
            throw new IllegalStateException();
        }
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.h = str;
        return this;
    }

    public c p() throws IOException {
        if (this.h != null) {
            if (!this.i) {
                this.h = null;
                return this;
            }
            T();
        }
        b();
        this.a.write("null");
        return this;
    }

    public final void z(String str) {
        if (str == null || str.length() == 0) {
            this.d = null;
            this.e = ":";
        } else {
            this.d = str;
            this.e = ": ";
        }
    }
}
