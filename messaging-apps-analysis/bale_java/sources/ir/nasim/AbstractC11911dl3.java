package ir.nasim;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* renamed from: ir.nasim.dl3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11911dl3 implements Closeable {
    private static final String[] g = new String[128];
    int a;
    int[] b = new int[32];
    String[] c = new String[32];
    int[] d = new int[32];
    boolean e;
    boolean f;

    /* renamed from: ir.nasim.dl3$a */
    public static final class a {
        final String[] a;
        final Options b;

        private a(String[] strArr, Options options) {
            this.a = strArr;
            this.b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    AbstractC11911dl3.n(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* renamed from: ir.nasim.dl3$b */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i = 0; i <= 31; i++) {
            g[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    AbstractC11911dl3() {
    }

    public static AbstractC11911dl3 g(BufferedSource bufferedSource) {
        return new C20287rl3(bufferedSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(okio.BufferedSink r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = ir.nasim.AbstractC11911dl3.g
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11911dl3.n(okio.BufferedSink, java.lang.String):void");
    }

    public final String A() {
        return AbstractC14343hl3.a(this.a, this.b, this.c, this.d);
    }

    public abstract void B();

    public abstract void F();

    public abstract void R();

    public abstract String T0();

    public abstract void b();

    public abstract void c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract double f1();

    public abstract b j();

    final void k(int i) {
        int i2 = this.a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new C19077pk3("Nesting too deep at " + A());
            }
            this.b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.c;
            this.c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.d;
            this.d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.b;
        int i3 = this.a;
        this.a = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int l(a aVar);

    public abstract void m();

    public abstract String n0();

    final C3568Bk3 p(String str) throws C3568Bk3 {
        throw new C3568Bk3(str + " at path " + A());
    }

    public abstract int r0();
}
