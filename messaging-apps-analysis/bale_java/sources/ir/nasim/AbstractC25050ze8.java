package ir.nasim;

/* renamed from: ir.nasim.ze8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC25050ze8 {
    public static int a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[32];
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        int[] iArr6 = new int[10];
        int[] iArr7 = new int[10];
        for (int i = 0; i < 32; i++) {
            bArr4[i] = bArr2[i];
        }
        AbstractC20210rd8.a(iArr, bArr3);
        AbstractC17239md8.a(iArr2);
        AbstractC16648ld8.a(iArr3);
        AbstractC19012pd8.a(iArr4, iArr);
        AbstractC17239md8.a(iArr5);
        int i2 = 254;
        int i3 = 0;
        while (i2 >= 0) {
            int i4 = (bArr4[i2 / 8] >>> (i2 & 7)) & 1;
            int i5 = i3 ^ i4;
            AbstractC19603qd8.a(iArr2, iArr4, i5);
            AbstractC19603qd8.a(iArr3, iArr5, i5);
            Bd8.a(iArr6, iArr4, iArr5);
            Bd8.a(iArr7, iArr2, iArr3);
            AbstractC17830nd8.a(iArr2, iArr2, iArr3);
            AbstractC17830nd8.a(iArr3, iArr4, iArr5);
            AbstractC23266wd8.a(iArr5, iArr6, iArr2);
            AbstractC23266wd8.a(iArr3, iArr3, iArr7);
            Ad8.a(iArr6, iArr7);
            Ad8.a(iArr7, iArr2);
            AbstractC17830nd8.a(iArr4, iArr5, iArr3);
            Bd8.a(iArr3, iArr5, iArr3);
            AbstractC23266wd8.a(iArr2, iArr7, iArr6);
            Bd8.a(iArr7, iArr7, iArr6);
            Ad8.a(iArr3, iArr3);
            AbstractC22670vd8.a(iArr5, iArr7);
            Ad8.a(iArr4, iArr4);
            AbstractC17830nd8.a(iArr6, iArr6, iArr5);
            AbstractC23266wd8.a(iArr5, iArr, iArr3);
            AbstractC23266wd8.a(iArr3, iArr7, iArr6);
            i2--;
            i3 = i4;
        }
        AbstractC19603qd8.a(iArr2, iArr4, i3);
        AbstractC19603qd8.a(iArr3, iArr5, i3);
        AbstractC20803sd8.a(iArr3, iArr3);
        AbstractC23266wd8.a(iArr2, iArr2, iArr3);
        Cd8.a(bArr, iArr2);
        return 0;
    }
}
