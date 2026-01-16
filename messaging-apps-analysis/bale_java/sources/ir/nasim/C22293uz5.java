package ir.nasim;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.uz5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C22293uz5 implements BI5 {
    private static final C12092e16[] b = new C12092e16[0];
    private final HB1 a = new HB1();

    private static C4705Gf0 b(C4705Gf0 c4705Gf0) throws NotFoundException {
        int[] iArrL = c4705Gf0.l();
        int[] iArrF = c4705Gf0.f();
        if (iArrL == null || iArrF == null) {
            throw NotFoundException.a();
        }
        float fC = c(iArrL, c4705Gf0);
        int i = iArrL[1];
        int i2 = iArrF[1];
        int i3 = iArrL[0];
        int i4 = iArrF[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.a();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3 && (i4 = i3 + i5) >= c4705Gf0.m()) {
            throw NotFoundException.a();
        }
        int iRound = Math.round(((i4 - i3) + 1) / fC);
        int iRound2 = Math.round((i5 + 1) / fC);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.a();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.a();
        }
        int i6 = (int) (fC / 2.0f);
        int i7 = i + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * fC)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw NotFoundException.a();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * fC)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw NotFoundException.a();
            }
            i7 -= i10;
        }
        C4705Gf0 c4705Gf02 = new C4705Gf0(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * fC)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (c4705Gf0.e(((int) (i13 * fC)) + i8, i12)) {
                    c4705Gf02.o(i13, i11);
                }
            }
        }
        return c4705Gf02;
    }

    private static float c(int[] iArr, C4705Gf0 c4705Gf0) throws NotFoundException {
        int i = c4705Gf0.i();
        int iM = c4705Gf0.m();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < iM && i3 < i) {
            if (z != c4705Gf0.e(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 == iM || i3 == i) {
            throw NotFoundException.a();
        }
        return (i2 - iArr[0]) / 7.0f;
    }

    @Override // ir.nasim.BI5
    public final X06 a(C6338Ne0 c6338Ne0, Map map) throws NotFoundException, ChecksumException, FormatException {
        C12092e16[] c12092e16ArrB;
        LB1 lb1B;
        if (map == null || !map.containsKey(EnumC19932rB1.PURE_BARCODE)) {
            FJ1 fj1E = new DJ1(c6338Ne0.a()).e(map);
            LB1 lb1B2 = this.a.b(fj1E.a(), map);
            c12092e16ArrB = fj1E.b();
            lb1B = lb1B2;
        } else {
            lb1B = this.a.b(b(c6338Ne0.a()), map);
            c12092e16ArrB = b;
        }
        if (lb1B.d() instanceof C21703tz5) {
            ((C21703tz5) lb1B.d()).a(c12092e16ArrB);
        }
        X06 x06 = new X06(lb1B.h(), lb1B.e(), c12092e16ArrB, EnumC9549a90.QR_CODE);
        List listA = lb1B.a();
        if (listA != null) {
            x06.h(EnumC11449d16.BYTE_SEGMENTS, listA);
        }
        String strB = lb1B.b();
        if (strB != null) {
            x06.h(EnumC11449d16.ERROR_CORRECTION_LEVEL, strB);
        }
        if (lb1B.i()) {
            x06.h(EnumC11449d16.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(lb1B.g()));
            x06.h(EnumC11449d16.STRUCTURED_APPEND_PARITY, Integer.valueOf(lb1B.f()));
        }
        return x06;
    }

    @Override // ir.nasim.BI5
    public void reset() {
    }
}
