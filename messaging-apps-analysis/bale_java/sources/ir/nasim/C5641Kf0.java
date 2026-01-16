package ir.nasim;

import java.nio.ByteBuffer;

/* renamed from: ir.nasim.Kf0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5641Kf0 {
    private ByteBuffer a;
    int b;
    int c;

    public C5641Kf0(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        this.b = byteBuffer.position();
    }

    public int a(int i) {
        int iA;
        int i2 = this.a.get(this.b + (this.c / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = this.c;
        int i4 = 8 - (i3 % 8);
        if (i <= i4) {
            iA = ((i2 << (i3 % 8)) & 255) >> ((i3 % 8) + (i4 - i));
            this.c = i3 + i;
        } else {
            int i5 = i - i4;
            iA = (a(i4) << i5) + a(i5);
        }
        this.a.position(this.b + ((int) Math.ceil(this.c / 8.0d)));
        return iA;
    }

    public boolean b() {
        return a(1) == 1;
    }

    public int c() {
        return (this.a.limit() * 8) - this.c;
    }
}
