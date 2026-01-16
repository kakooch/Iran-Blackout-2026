package ir.nasim;

/* renamed from: ir.nasim.dp0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11947dp0 {
    private static int[] b = b();
    private int a = 0;

    private static int[] b() {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            int i2 = 8;
            int i3 = i;
            while (true) {
                i2--;
                if (i2 >= 0) {
                    i3 = (i3 & 1) != 0 ? (i3 >>> 1) ^ (-306674912) : i3 >>> 1;
                }
            }
            iArr[i] = i3;
        }
        return iArr;
    }

    public long a() {
        return this.a & 4294967295L;
    }

    public C11947dp0 c() {
        this.a = 0;
        return this;
    }

    public C11947dp0 d(byte[] bArr) {
        e(bArr, 0, bArr.length);
        return this;
    }

    public C11947dp0 e(byte[] bArr, int i, int i2) {
        int i3 = ~this.a;
        while (true) {
            i2--;
            if (i2 < 0) {
                this.a = ~i3;
                return this;
            }
            i3 = (i3 >>> 8) ^ b[(bArr[i] ^ i3) & 255];
            i++;
        }
    }
}
