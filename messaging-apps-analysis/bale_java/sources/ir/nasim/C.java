package ir.nasim;

import com.google.zxing.NotFoundException;

/* loaded from: classes3.dex */
abstract class C extends F {
    C(C3988Df0 c3988Df0) {
        super(c3988Df0);
    }

    @Override // ir.nasim.P0
    public String d() throws NotFoundException {
        if (c().n() != 60) {
            throw NotFoundException.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 5);
        j(sb, 45, 15);
        return sb.toString();
    }
}
