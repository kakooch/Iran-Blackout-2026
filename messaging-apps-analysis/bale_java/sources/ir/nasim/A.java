package ir.nasim;

import com.google.zxing.NotFoundException;

/* loaded from: classes3.dex */
final class A extends E {
    A(C3988Df0 c3988Df0) {
        super(c3988Df0);
    }

    @Override // ir.nasim.P0
    public String d() throws NotFoundException {
        if (c().n() < 48) {
            throw NotFoundException.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int iF = b().f(48, 2);
        sb.append("(393");
        sb.append(iF);
        sb.append(')');
        int iF2 = b().f(50, 10);
        if (iF2 / 100 == 0) {
            sb.append('0');
        }
        if (iF2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iF2);
        sb.append(b().c(60, null).b());
        return sb.toString();
    }
}
