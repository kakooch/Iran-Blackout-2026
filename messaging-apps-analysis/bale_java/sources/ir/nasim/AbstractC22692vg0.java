package ir.nasim;

import java.io.InputStream;

/* renamed from: ir.nasim.vg0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22692vg0 {
    protected static int f;
    private InputStream a;
    private int b;
    private int c;
    int d;
    protected WJ0 e = new WJ0(50);

    public AbstractC22692vg0(InputStream inputStream) {
        this.a = inputStream;
        this.b = inputStream.read();
        this.c = inputStream.read();
    }

    private void a() {
        this.b = this.c;
        this.c = this.a.read();
        this.d = 0;
    }

    public int b() {
        if (this.d == 8) {
            a();
            if (this.b == -1) {
                return -1;
            }
        }
        int i = this.b;
        int i2 = this.d;
        int i3 = (i >> (7 - i2)) & 1;
        this.d = i2 + 1;
        this.e.a(i3 == 0 ? '0' : '1');
        f++;
        return i3;
    }

    public boolean c() {
        return b() == 1;
    }

    public int d() {
        if (this.d > 0) {
            a();
        }
        int i = this.b;
        a();
        return i;
    }

    public long e(int i) {
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long jB = 0;
        for (int i2 = 0; i2 < i; i2++) {
            jB = (jB << 1) | b();
        }
        return jB;
    }
}
