package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import ir.nasim.AbstractC6193Mo4;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.qV2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19522qV2 {
    public final List a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final String f;

    private C19522qV2(List list, int i, int i2, int i3, float f, String str) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = str;
    }

    public static C19522qV2 a(EW4 ew4) throws ParserException {
        int i;
        int i2;
        try {
            ew4.T(21);
            int iF = ew4.F() & 3;
            int iF2 = ew4.F();
            int iF3 = ew4.f();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < iF2; i5++) {
                ew4.T(1);
                int iL = ew4.L();
                for (int i6 = 0; i6 < iL; i6++) {
                    int iL2 = ew4.L();
                    i4 += iL2 + 4;
                    ew4.T(iL2);
                }
            }
            ew4.S(iF3);
            byte[] bArr = new byte[i4];
            int i7 = -1;
            int i8 = -1;
            float f = 1.0f;
            String strC = null;
            int i9 = 0;
            int i10 = 0;
            while (i9 < iF2) {
                int iF4 = ew4.F() & 63;
                int iL3 = ew4.L();
                int i11 = i3;
                while (i11 < iL3) {
                    int iL4 = ew4.L();
                    byte[] bArr2 = AbstractC6193Mo4.a;
                    int i12 = iF2;
                    System.arraycopy(bArr2, i3, bArr, i10, bArr2.length);
                    int length = i10 + bArr2.length;
                    System.arraycopy(ew4.e(), ew4.f(), bArr, length, iL4);
                    if (iF4 == 33 && i11 == 0) {
                        AbstractC6193Mo4.a aVarH = AbstractC6193Mo4.h(bArr, length, length + iL4);
                        int i13 = aVarH.h;
                        i8 = aVarH.i;
                        f = aVarH.j;
                        i = iF4;
                        i2 = iL3;
                        i7 = i13;
                        strC = GW0.c(aVarH.a, aVarH.b, aVarH.c, aVarH.d, aVarH.e, aVarH.f);
                    } else {
                        i = iF4;
                        i2 = iL3;
                    }
                    i10 = length + iL4;
                    ew4.T(iL4);
                    i11++;
                    iF2 = i12;
                    iF4 = i;
                    iL3 = i2;
                    i3 = 0;
                }
                i9++;
                i3 = 0;
            }
            return new C19522qV2(i4 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iF + 1, i7, i8, f, strC);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.a("Error parsing HEVC config", e);
        }
    }
}
