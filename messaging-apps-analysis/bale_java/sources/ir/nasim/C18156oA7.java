package ir.nasim;

import com.google.zxing.FormatException;
import java.util.Map;

/* renamed from: ir.nasim.oA7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18156oA7 extends AbstractC20538sA7 {
    private final AbstractC20538sA7 i = new D22();

    private static X06 r(X06 x06) throws FormatException {
        String strF = x06.f();
        if (strF.charAt(0) != '0') {
            throw FormatException.a();
        }
        X06 x062 = new X06(strF.substring(1), null, x06.e(), EnumC9549a90.UPC_A);
        if (x06.d() != null) {
            x062.g(x06.d());
        }
        return x062;
    }

    @Override // ir.nasim.MK4, ir.nasim.BI5
    public X06 a(C6338Ne0 c6338Ne0, Map map) {
        return r(this.i.a(c6338Ne0, map));
    }

    @Override // ir.nasim.AbstractC20538sA7, ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) {
        return r(this.i.b(i, c3988Df0, map));
    }

    @Override // ir.nasim.AbstractC20538sA7
    protected int k(C3988Df0 c3988Df0, int[] iArr, StringBuilder sb) {
        return this.i.k(c3988Df0, iArr, sb);
    }

    @Override // ir.nasim.AbstractC20538sA7
    public X06 l(int i, C3988Df0 c3988Df0, int[] iArr, Map map) {
        return r(this.i.l(i, c3988Df0, iArr, map));
    }

    @Override // ir.nasim.AbstractC20538sA7
    EnumC9549a90 p() {
        return EnumC9549a90.UPC_A;
    }
}
