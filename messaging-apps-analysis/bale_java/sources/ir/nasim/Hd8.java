package ir.nasim;

/* loaded from: classes5.dex */
public abstract class Hd8 {
    static int[] a = {-10913610, 13857413, -15372611, 6949391, 114729, -8787816, -6275908, -3247719, -18696448, -12055116};
    static int[] b = {-32595792, -7943725, 9377950, 3500415, 12389472, -272473, -25146209, -2005654, 326686, 11406482};

    static int a(Qd8 qd8, byte[] bArr) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        AbstractC20210rd8.a(qd8.b, bArr);
        AbstractC17239md8.a(qd8.c);
        Ad8.a(iArr, qd8.b);
        AbstractC23266wd8.a(iArr2, iArr, a);
        Bd8.a(iArr, iArr, qd8.c);
        AbstractC17830nd8.a(iArr2, iArr2, qd8.c);
        Ad8.a(iArr3, iArr2);
        AbstractC23266wd8.a(iArr3, iArr3, iArr2);
        Ad8.a(qd8.a, iArr3);
        int[] iArr6 = qd8.a;
        AbstractC23266wd8.a(iArr6, iArr6, iArr2);
        int[] iArr7 = qd8.a;
        AbstractC23266wd8.a(iArr7, iArr7, iArr);
        int[] iArr8 = qd8.a;
        AbstractC24446yd8.a(iArr8, iArr8);
        int[] iArr9 = qd8.a;
        AbstractC23266wd8.a(iArr9, iArr9, iArr3);
        int[] iArr10 = qd8.a;
        AbstractC23266wd8.a(iArr10, iArr10, iArr);
        Ad8.a(iArr4, qd8.a);
        AbstractC23266wd8.a(iArr4, iArr4, iArr2);
        Bd8.a(iArr5, iArr4, iArr);
        if (AbstractC22080ud8.a(iArr5) != 0) {
            AbstractC17830nd8.a(iArr5, iArr4, iArr);
            if (AbstractC22080ud8.a(iArr5) != 0) {
                return -1;
            }
            int[] iArr11 = qd8.a;
            AbstractC23266wd8.a(iArr11, iArr11, b);
        }
        if (AbstractC21423td8.a(qd8.a) == ((bArr[31] >>> 7) & 1)) {
            int[] iArr12 = qd8.a;
            AbstractC23856xd8.a(iArr12, iArr12);
        }
        AbstractC23266wd8.a(qd8.d, qd8.a, qd8.b);
        return 0;
    }
}
