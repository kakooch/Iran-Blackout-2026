package ir.nasim;

import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.aK0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9649aK0 {
    public static final C9649aK0 a;
    public static final char[] b;
    public static final byte[] c;

    static {
        C9649aK0 c9649aK0 = new C9649aK0();
        a = c9649aK0;
        b = new char[WKSRecord.Service.UUCP_PATH];
        c = new byte[126];
        c9649aK0.f();
        c9649aK0.e();
    }

    private C9649aK0() {
    }

    private final void a(char c2, char c3) {
        b(c2, c3);
    }

    private final void b(int i, char c2) {
        if (c2 != 'u') {
            b[c2] = (char) i;
        }
    }

    private final void c(char c2, byte b2) {
        d(c2, b2);
    }

    private final void d(int i, byte b2) {
        c[i] = b2;
    }

    private final void e() {
        for (int i = 0; i < 33; i++) {
            d(i, (byte) 127);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    private final void f() {
        for (int i = 0; i < 32; i++) {
            b(i, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}
