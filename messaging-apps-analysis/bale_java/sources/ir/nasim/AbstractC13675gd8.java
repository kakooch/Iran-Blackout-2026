package ir.nasim;

/* renamed from: ir.nasim.gd8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13675gd8 {
    public static void a(byte[] bArr, byte[] bArr2) {
        Qd8 qd8 = new Qd8();
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        AbstractC10461be8.c(qd8, bArr2);
        AbstractC17830nd8.a(iArr, qd8.b, qd8.c);
        Bd8.a(iArr2, qd8.c, qd8.b);
        AbstractC20803sd8.a(iArr3, iArr2);
        AbstractC23266wd8.a(iArr4, iArr, iArr3);
        Cd8.a(bArr, iArr4);
    }

    public static int b(InterfaceC3913Cw6 interfaceC3913Cw6, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        int[] iArr6 = new int[10];
        byte[] bArr4 = new byte[32];
        int i2 = i + 64;
        byte[] bArr5 = new byte[i2];
        AbstractC20210rd8.a(iArr, bArr2);
        AbstractC17239md8.a(iArr5);
        Bd8.a(iArr2, iArr, iArr5);
        AbstractC17830nd8.a(iArr3, iArr, iArr5);
        AbstractC20803sd8.a(iArr4, iArr3);
        AbstractC23266wd8.a(iArr6, iArr2, iArr4);
        Cd8.a(bArr4, iArr6);
        byte b = (byte) (bArr4[31] & 127);
        bArr4[31] = b;
        bArr4[31] = (byte) (b | (bArr[63] & 128));
        System.arraycopy(bArr, 0, bArr5, 0, 64);
        bArr5[63] = (byte) (bArr5[63] & 127);
        System.arraycopy(bArr3, 0, bArr5, 64, i);
        return AbstractC22090ue8.a(interfaceC3913Cw6, new byte[i2], 0L, bArr5, i2, bArr4);
    }
}
