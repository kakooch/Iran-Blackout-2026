package ir.nasim;

import com.google.zxing.NotFoundException;

/* renamed from: ir.nasim.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C24662z extends E {
    C24662z(C3988Df0 c3988Df0) {
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
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}
