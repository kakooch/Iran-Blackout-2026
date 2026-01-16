package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import ir.nasim.AbstractC6193Mo4;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.tV, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21339tV {
    public final List a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final String f;

    private C21339tV(List list, int i, int i2, int i3, float f, String str) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = str;
    }

    private static byte[] a(EW4 ew4) {
        int iL = ew4.L();
        int iF = ew4.f();
        ew4.T(iL);
        return GW0.d(ew4.e(), iF, iL);
    }

    public static C21339tV b(EW4 ew4) throws ParserException {
        int i;
        int i2;
        float f;
        String strA;
        try {
            ew4.T(4);
            int iF = (ew4.F() & 3) + 1;
            if (iF == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iF2 = ew4.F() & 31;
            for (int i3 = 0; i3 < iF2; i3++) {
                arrayList.add(a(ew4));
            }
            int iF3 = ew4.F();
            for (int i4 = 0; i4 < iF3; i4++) {
                arrayList.add(a(ew4));
            }
            if (iF2 > 0) {
                AbstractC6193Mo4.c cVarL = AbstractC6193Mo4.l((byte[]) arrayList.get(0), iF, ((byte[]) arrayList.get(0)).length);
                int i5 = cVarL.f;
                int i6 = cVarL.g;
                float f2 = cVarL.h;
                strA = GW0.a(cVarL.a, cVarL.b, cVarL.c);
                i = i5;
                i2 = i6;
                f = f2;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
                strA = null;
            }
            return new C21339tV(arrayList, iF, i, i2, f, strA);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.a("Error parsing AVC config", e);
        }
    }
}
