package ir.nasim;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes3.dex */
public final class XV3 implements BI5 {
    private static final C12092e16[] b = new C12092e16[0];
    private final GB1 a = new GB1();

    private static C4705Gf0 b(C4705Gf0 c4705Gf0) throws NotFoundException {
        int[] iArrH = c4705Gf0.h();
        if (iArrH == null) {
            throw NotFoundException.a();
        }
        int i = iArrH[0];
        int i2 = iArrH[1];
        int i3 = iArrH[2];
        int i4 = iArrH[3];
        C4705Gf0 c4705Gf02 = new C4705Gf0(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
            for (int i7 = 0; i7 < 30; i7++) {
                if (c4705Gf0.e(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    c4705Gf02.o(i7, i5);
                }
            }
        }
        return c4705Gf02;
    }

    @Override // ir.nasim.BI5
    public X06 a(C6338Ne0 c6338Ne0, Map map) throws NotFoundException, ChecksumException, FormatException {
        if (map == null || !map.containsKey(EnumC19932rB1.PURE_BARCODE)) {
            throw NotFoundException.a();
        }
        LB1 lb1B = this.a.b(b(c6338Ne0.a()), map);
        X06 x06 = new X06(lb1B.h(), lb1B.e(), b, EnumC9549a90.MAXICODE);
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
