package ir.nasim;

import com.google.zxing.ChecksumException;
import com.google.zxing.NotFoundException;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.bz1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10660bz1 implements BI5 {
    private static final C12092e16[] b = new C12092e16[0];
    private final FB1 a = new FB1();

    private static C4705Gf0 b(C4705Gf0 c4705Gf0) throws NotFoundException {
        int[] iArrL = c4705Gf0.l();
        int[] iArrF = c4705Gf0.f();
        if (iArrL == null || iArrF == null) {
            throw NotFoundException.a();
        }
        int iC = c(iArrL, c4705Gf0);
        int i = iArrL[1];
        int i2 = iArrF[1];
        int i3 = iArrL[0];
        int i4 = ((iArrF[0] - i3) + 1) / iC;
        int i5 = ((i2 - i) + 1) / iC;
        if (i4 <= 0 || i5 <= 0) {
            throw NotFoundException.a();
        }
        int i6 = iC / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        C4705Gf0 c4705Gf02 = new C4705Gf0(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * iC) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (c4705Gf0.e((i11 * iC) + i8, i10)) {
                    c4705Gf02.o(i11, i9);
                }
            }
        }
        return c4705Gf02;
    }

    private static int c(int[] iArr, C4705Gf0 c4705Gf0) throws NotFoundException {
        int iM = c4705Gf0.m();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < iM && c4705Gf0.e(i, i2)) {
            i++;
        }
        if (i == iM) {
            throw NotFoundException.a();
        }
        int i3 = i - iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.BI5
    public X06 a(C6338Ne0 c6338Ne0, Map map) throws NotFoundException, ChecksumException {
        C12092e16[] c12092e16ArrB;
        LB1 lb1B;
        if (map == null || !map.containsKey(EnumC19932rB1.PURE_BARCODE)) {
            FJ1 fj1C = new BJ1(c6338Ne0.a()).c();
            LB1 lb1B2 = this.a.b(fj1C.a());
            c12092e16ArrB = fj1C.b();
            lb1B = lb1B2;
        } else {
            lb1B = this.a.b(b(c6338Ne0.a()));
            c12092e16ArrB = b;
        }
        X06 x06 = new X06(lb1B.h(), lb1B.e(), c12092e16ArrB, EnumC9549a90.DATA_MATRIX);
        List listA = lb1B.a();
        if (listA != null) {
            x06.h(EnumC11449d16.BYTE_SEGMENTS, listA);
        }
        String strB = lb1B.b();
        if (strB != null) {
            x06.h(EnumC11449d16.ERROR_CORRECTION_LEVEL, strB);
        }
        return x06;
    }

    @Override // ir.nasim.BI5
    public void reset() {
    }
}
