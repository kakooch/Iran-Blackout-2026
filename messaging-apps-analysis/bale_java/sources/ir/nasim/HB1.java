package ir.nasim;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* loaded from: classes3.dex */
public final class HB1 {
    private final YK5 a = new YK5(UE2.l);

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

    private LB1 c(C5173If0 c5173If0, Map map) throws ChecksumException, FormatException {
        YR7 yr7E = c5173If0.e();
        X92 x92D = c5173If0.d().d();
        C6779Oy1[] c6779Oy1ArrB = C6779Oy1.b(c5173If0.c(), yr7E, x92D);
        int iC = 0;
        for (C6779Oy1 c6779Oy1 : c6779Oy1ArrB) {
            iC += c6779Oy1.c();
        }
        byte[] bArr = new byte[iC];
        int i = 0;
        for (C6779Oy1 c6779Oy12 : c6779Oy1ArrB) {
            byte[] bArrA = c6779Oy12.a();
            int iC2 = c6779Oy12.c();
            a(bArrA, iC2);
            int i2 = 0;
            while (i2 < iC2) {
                bArr[i] = bArrA[i2];
                i2++;
                i++;
            }
        }
        return AbstractC23594xB1.a(bArr, yr7E, x92D, map);
    }

    public LB1 b(C4705Gf0 c4705Gf0, Map map) throws ChecksumException, FormatException {
        ChecksumException e;
        C5173If0 c5173If0 = new C5173If0(c4705Gf0);
        FormatException formatException = null;
        try {
            return c(c5173If0, map);
        } catch (ChecksumException e2) {
            e = e2;
            try {
                c5173If0.f();
                c5173If0.g(true);
                c5173If0.e();
                c5173If0.d();
                c5173If0.b();
                LB1 lb1C = c(c5173If0, map);
                lb1C.m(new C21703tz5(true));
                return lb1C;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e;
            }
        } catch (FormatException e3) {
            e = null;
            formatException = e3;
            c5173If0.f();
            c5173If0.g(true);
            c5173If0.e();
            c5173If0.d();
            c5173If0.b();
            LB1 lb1C2 = c(c5173If0, map);
            lb1C2.m(new C21703tz5(true));
            return lb1C2;
        }
    }
}
