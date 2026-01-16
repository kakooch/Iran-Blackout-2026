package ir.nasim;

/* renamed from: ir.nasim.ue8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22090ue8 {
    public static int a(InterfaceC3913Cw6 interfaceC3913Cw6, byte[] bArr, long j, byte[] bArr2, long j2, byte[] bArr3) {
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[64];
        byte[] bArr8 = new byte[32];
        Qd8 qd8 = new Qd8();
        Nd8 nd8 = new Nd8();
        if (j2 < 64 || (bArr2[63] & 224) != 0 || Hd8.a(qd8, bArr3) != 0) {
            return -1;
        }
        interfaceC3913Cw6.a(new byte[64], bArr3, 32L);
        System.arraycopy(bArr3, 0, bArr4, 0, 32);
        System.arraycopy(bArr2, 0, bArr5, 0, 32);
        System.arraycopy(bArr2, 32, bArr6, 0, 32);
        System.arraycopy(bArr2, 0, bArr, 0, (int) j2);
        System.arraycopy(bArr4, 0, bArr, 32, 32);
        interfaceC3913Cw6.a(bArr7, bArr, j2);
        AbstractC24456ye8.c(bArr7);
        Gd8.a(nd8, bArr7, qd8, bArr6);
        AbstractC11846de8.a(bArr8, nd8);
        if (AbstractC13057fd8.a(bArr8, bArr5) != 0) {
            return -1;
        }
        System.arraycopy(bArr, 64, bArr, 0, (int) (j2 - 64));
        return 0;
    }
}
