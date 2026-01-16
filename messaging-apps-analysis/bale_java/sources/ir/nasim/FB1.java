package ir.nasim;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: classes3.dex */
public final class FB1 {
    private final YK5 a = new YK5(UE2.m);

    private void a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.a();
        }
    }

    public LB1 b(C4705Gf0 c4705Gf0) throws ChecksumException {
        C5407Jf0 c5407Jf0 = new C5407Jf0(c4705Gf0);
        C7023Py1[] c7023Py1ArrB = C7023Py1.b(c5407Jf0.c(), c5407Jf0.b());
        int iC = 0;
        for (C7023Py1 c7023Py1 : c7023Py1ArrB) {
            iC += c7023Py1.c();
        }
        byte[] bArr = new byte[iC];
        int length = c7023Py1ArrB.length;
        for (int i = 0; i < length; i++) {
            C7023Py1 c7023Py12 = c7023Py1ArrB[i];
            byte[] bArrA = c7023Py12.a();
            int iC2 = c7023Py12.c();
            a(bArrA, iC2);
            for (int i2 = 0; i2 < iC2; i2++) {
                bArr[(i2 * length) + i] = bArrA[i2];
            }
        }
        return AbstractC21818uB1.a(bArr);
    }
}
