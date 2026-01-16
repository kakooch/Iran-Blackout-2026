package ir.nasim;

import java.nio.ByteBuffer;

/* renamed from: ir.nasim.Nf0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C6347Nf0 {
    private ByteBuffer a;
    int b;
    int c = 0;

    public C6347Nf0(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        this.b = byteBuffer.position();
    }

    public void a(int i, int i2) {
        int i3 = this.c;
        int i4 = 8 - (i3 % 8);
        if (i2 <= i4) {
            int i5 = this.a.get(this.b + (i3 / 8));
            if (i5 < 0) {
                i5 += 256;
            }
            int i6 = i5 + (i << (i4 - i2));
            ByteBuffer byteBuffer = this.a;
            int i7 = this.b + (this.c / 8);
            if (i6 > 127) {
                i6 -= 256;
            }
            byteBuffer.put(i7, (byte) i6);
            this.c += i2;
        } else {
            int i8 = i2 - i4;
            a(i >> i8, i4);
            a(i & ((1 << i8) - 1), i8);
        }
        ByteBuffer byteBuffer2 = this.a;
        int i9 = this.b;
        int i10 = this.c;
        byteBuffer2.position(i9 + (i10 / 8) + (i10 % 8 <= 0 ? 0 : 1));
    }
}
