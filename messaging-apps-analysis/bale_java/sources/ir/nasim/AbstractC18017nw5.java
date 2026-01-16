package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.nw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18017nw5 {
    public static final List a(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        String strH = c6432No4.h();
        AbstractC13042fc3.h(strH, "name.asString()");
        return C23341wl3.b(strH) ? AbstractC10360bX0.q(b(c6432No4)) : C23341wl3.c(strH) ? f(c6432No4) : C19094pm0.a.b(c6432No4);
    }

    public static final C6432No4 b(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "methodName");
        C6432No4 c6432No4E = e(c6432No4, "get", false, null, 12, null);
        return c6432No4E == null ? e(c6432No4, "is", false, null, 8, null) : c6432No4E;
    }

    public static final C6432No4 c(C6432No4 c6432No4, boolean z) {
        AbstractC13042fc3.i(c6432No4, "methodName");
        return e(c6432No4, "set", false, z ? "is" : null, 4, null);
    }

    private static final C6432No4 d(C6432No4 c6432No4, String str, boolean z, String str2) {
        if (c6432No4.q()) {
            return null;
        }
        String strJ = c6432No4.j();
        AbstractC13042fc3.h(strJ, "methodName.identifier");
        if (!AbstractC20153rZ6.S(strJ, str, false, 2, null) || strJ.length() == str.length()) {
            return null;
        }
        char cCharAt = strJ.charAt(str.length());
        if ('a' <= cCharAt && cCharAt <= 'z') {
            return null;
        }
        if (str2 != null) {
            return C6432No4.p(AbstractC13042fc3.q(str2, AbstractC20762sZ6.C0(strJ, str)));
        }
        if (!z) {
            return c6432No4;
        }
        String strC = BF0.c(AbstractC20762sZ6.C0(strJ, str), true);
        if (C6432No4.r(strC)) {
            return C6432No4.p(strC);
        }
        return null;
    }

    static /* synthetic */ C6432No4 e(C6432No4 c6432No4, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return d(c6432No4, str, z, str2);
    }

    public static final List f(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "methodName");
        return AbstractC10360bX0.r(c(c6432No4, false), c(c6432No4, true));
    }
}
