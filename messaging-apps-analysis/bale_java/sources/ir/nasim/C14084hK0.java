package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.hK0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14084hK0 extends AbstractC7511Sa3 {
    public C14084hK0(char c) {
        super(Character.valueOf(c));
    }

    private final String c(char c) {
        return c == '\b' ? "\\b" : c == '\t' ? "\\t" : c == '\n' ? "\\n" : c == '\f' ? "\\f" : c == '\r' ? "\\r" : e(c) ? String.valueOf(c) : Separators.QUESTION;
    }

    private final boolean e(char c) {
        byte type = (byte) Character.getType(c);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        XC6 xc6U = interfaceC8507Wg4.n().u();
        AbstractC13042fc3.h(xc6U, "module.builtIns.charType");
        return xc6U;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        String str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(((Character) b()).charValue()), c(((Character) b()).charValue())}, 2));
        AbstractC13042fc3.h(str, "java.lang.String.format(this, *args)");
        return str;
    }
}
