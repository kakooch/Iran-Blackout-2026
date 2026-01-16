package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class XC6 extends AbstractC18174oC7 implements ZC6, InterfaceC9204Yx7 {
    public XC6() {
        super(null);
    }

    /* renamed from: R0 */
    public abstract XC6 O0(boolean z);

    /* renamed from: S0 */
    public abstract XC6 Q0(InterfaceC4356Eu interfaceC4356Eu);

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            AbstractC18380oZ6.j(sb, "[", FI1.t(FI1.j, (InterfaceC21651tu) it.next(), null, 2, null), "] ");
        }
        sb.append(K0());
        if (!J0().isEmpty()) {
            AbstractC15401jX0.x0(J0(), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : Separators.LESS_THAN, (124 & 8) == 0 ? Separators.GREATER_THAN : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (L0()) {
            sb.append(Separators.QUESTION);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
