package com.google.ads.interactivemedia.v3.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class ald implements Closeable, Flushable {
    private static final String[] a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private final String f;
    private boolean g;
    private boolean h;
    private String i;
    private boolean j;

    static {
        for (int i = 0; i <= 31; i++) {
            a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public ald(Writer writer) {
        a(6);
        this.f = ":";
        this.j = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.c = writer;
    }

    private final void a(int i) {
        int i2 = this.e;
        int[] iArr = this.d;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 + i2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.d = iArr2;
        }
        int[] iArr3 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        iArr3[i3] = i;
    }

    private final int s() {
        int i = this.e;
        if (i != 0) {
            return this.d[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final void t(int i) {
        this.d[this.e - 1] = i;
    }

    private final void u() throws IOException {
        if (this.i != null) {
            int iS = s();
            if (iS == 5) {
                this.c.write(44);
            } else if (iS != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            t(4);
            v(this.i);
            this.i = null;
        }
    }

    private final void w() throws IOException {
        int iS = s();
        if (iS == 1) {
            t(2);
            return;
        }
        if (iS == 2) {
            this.c.append(',');
            return;
        }
        if (iS == 4) {
            this.c.append((CharSequence) this.f);
            t(5);
            return;
        }
        if (iS != 6) {
            if (iS != 7) {
                throw new IllegalStateException("Nesting problem.");
            }
            if (!this.g) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        }
        t(7);
    }

    private final void x(int i, int i2, String str) throws IOException {
        int iS = s();
        if (iS != i2 && iS != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.i == null) {
            this.e--;
            this.c.write(str);
        } else {
            throw new IllegalStateException("Dangling name: " + this.i);
        }
    }

    private final void y(int i, String str) throws IOException {
        w();
        a(i);
        this.c.write(str);
    }

    public void b() throws IOException {
        u();
        y(1, "[");
    }

    public void c() throws IOException {
        u();
        y(3, "{");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
        int i = this.e;
        if (i > 1 || (i == 1 && this.d[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    public void d() throws IOException {
        x(1, 2, "]");
    }

    public void e() throws IOException {
        x(3, 5, "}");
    }

    public void f(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.i != null) {
            throw new IllegalStateException();
        }
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.i = str;
    }

    public void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public void g() throws IOException {
        if (this.i != null) {
            if (!this.j) {
                this.i = null;
                return;
            }
            u();
        }
        w();
        this.c.write("null");
    }

    public void h(long j) throws IOException {
        u();
        w();
        this.c.write(Long.toString(j));
    }

    public void i(Boolean bool) throws IOException {
        if (bool == null) {
            g();
            return;
        }
        u();
        w();
        this.c.write(true != bool.booleanValue() ? "false" : "true");
    }

    public void j(Number number) throws IOException {
        if (number == null) {
            g();
            return;
        }
        u();
        String string = number.toString();
        if (this.g || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            w();
            this.c.append((CharSequence) string);
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
    }

    public void k(String str) throws IOException {
        if (str == null) {
            g();
            return;
        }
        u();
        w();
        v(str);
    }

    public void l(boolean z) throws IOException {
        u();
        w();
        this.c.write(true != z ? "false" : "true");
    }

    public final void m(boolean z) {
        this.g = z;
    }

    public final boolean n() {
        return this.g;
    }

    public final void o(boolean z) {
        this.h = z;
    }

    public final boolean p() {
        return this.h;
    }

    public final void q(boolean z) {
        this.j = z;
    }

    public final boolean r() {
        return this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void v(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.h
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.ads.interactivemedia.v3.internal.ald.b
            goto L9
        L7:
            java.lang.String[] r0 = com.google.ads.interactivemedia.v3.internal.ald.a
        L9:
            java.io.Writer r1 = r8.c
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
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
            java.io.Writer r6 = r8.c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ald.v(java.lang.String):void");
    }
}
