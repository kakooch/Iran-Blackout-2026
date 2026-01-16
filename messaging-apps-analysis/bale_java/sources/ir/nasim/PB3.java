package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC7392Rn1;

/* loaded from: classes3.dex */
public class PB3 implements InterfaceC12254eI6 {
    @Override // ir.nasim.InterfaceC12254eI6
    public Object a(C18332oU3 c18332oU3, InterfaceC17689nO5 interfaceC17689nO5) {
        if (AbstractC7392Rn1.a.BULLET == AbstractC7392Rn1.a.c(interfaceC17689nO5)) {
            return new C20294rm0(c18332oU3.b(), ((Integer) AbstractC7392Rn1.b.c(interfaceC17689nO5)).intValue());
        }
        StringBuilder sb = new StringBuilder();
        C17426mw5 c17426mw5 = AbstractC7392Rn1.c;
        sb.append(c17426mw5.c(interfaceC17689nO5));
        sb.append(Separators.DOT);
        sb.append((char) 160);
        return new QL4(c18332oU3.b(), sb.toString(), " ." + c17426mw5.c(interfaceC17689nO5));
    }
}
