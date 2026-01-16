package ir.nasim;

/* renamed from: ir.nasim.rS4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20088rS4 implements QS4 {
    @Override // ir.nasim.QS4
    public boolean a(byte[] bArr, int i, int i2) {
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            z &= bArr[i3 + i] == i2;
        }
        return z;
    }

    @Override // ir.nasim.QS4
    public void b(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3 + i] = (byte) i2;
        }
    }
}
