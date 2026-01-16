package ir.nasim;

import ir.nasim.C3419Au3;
import ir.nasim.C9760aW3;
import java.util.List;

/* renamed from: ir.nasim.Ru3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7457Ru3 {
    private final C3419Au3 a;
    private final C17631nI1 b;
    private final List c;

    public C7457Ru3(C3419Au3 c3419Au3, C17631nI1 c17631nI1, List list) {
        this.a = c3419Au3;
        this.b = c17631nI1;
        this.c = list;
    }

    private final boolean b(C3419Au3 c3419Au3) {
        Object obj;
        C3419Au3 c3419Au3A0 = c3419Au3.A0();
        Object obj2 = null;
        C3419Au3.e eVarG0 = c3419Au3A0 != null ? c3419Au3A0.g0() : null;
        if (c3419Au3.o() || (c3419Au3.B0() != Integer.MAX_VALUE && c3419Au3A0 != null && c3419Au3A0.o())) {
            if (c3419Au3.n0()) {
                List list = this.c;
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i);
                    C9760aW3.a aVar = (C9760aW3.a) obj;
                    if (AbstractC13042fc3.d(aVar.a(), c3419Au3) && !aVar.c()) {
                        break;
                    }
                    i++;
                }
                if (obj != null) {
                    return true;
                }
            }
            if (c3419Au3.u()) {
                return true;
            }
            if (c3419Au3.n0()) {
                return this.b.d(c3419Au3) || c3419Au3.g0() == C3419Au3.e.b || (c3419Au3A0 != null && c3419Au3A0.n0()) || ((c3419Au3A0 != null && c3419Au3A0.i0()) || eVarG0 == C3419Au3.e.a);
            }
            if (c3419Au3.f0()) {
                if (!this.b.d(c3419Au3) && c3419Au3A0 != null && !c3419Au3A0.n0() && !c3419Au3A0.f0() && eVarG0 != C3419Au3.e.a && eVarG0 != C3419Au3.e.c) {
                    List list2 = this.c;
                    int size2 = list2.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 < size2) {
                            if (AbstractC13042fc3.d(((C9760aW3.a) list2.get(i2)).a(), c3419Au3)) {
                                break;
                            }
                            i2++;
                        } else if (c3419Au3.g0() != C3419Au3.e.a) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        if (AbstractC13042fc3.d(c3419Au3.U0(), Boolean.TRUE)) {
            if (c3419Au3.i0()) {
                List list3 = this.c;
                int size3 = list3.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size3) {
                        break;
                    }
                    Object obj3 = list3.get(i3);
                    C9760aW3.a aVar2 = (C9760aW3.a) obj3;
                    if (AbstractC13042fc3.d(aVar2.a(), c3419Au3) && aVar2.c()) {
                        obj2 = obj3;
                        break;
                    }
                    i3++;
                }
                if (obj2 != null) {
                    return true;
                }
            }
            if (c3419Au3.i0()) {
                return this.b.e(c3419Au3, true) || (c3419Au3A0 != null && c3419Au3A0.i0()) || eVarG0 == C3419Au3.e.b || (c3419Au3A0 != null && c3419Au3A0.n0() && AbstractC13042fc3.d(c3419Au3.k0(), c3419Au3));
            }
            if (c3419Au3.h0()) {
                return this.b.e(c3419Au3, true) || c3419Au3A0 == null || c3419Au3A0.i0() || c3419Au3A0.h0() || eVarG0 == C3419Au3.e.b || eVarG0 == C3419Au3.e.d || (c3419Au3A0.f0() && AbstractC13042fc3.d(c3419Au3.k0(), c3419Au3));
            }
        }
        return true;
    }

    private final boolean c(C3419Au3 c3419Au3) {
        if (!b(c3419Au3)) {
            return false;
        }
        List listR = c3419Au3.R();
        int size = listR.size();
        for (int i = 0; i < size; i++) {
            if (!c((C3419Au3) listR.get(i))) {
                return false;
            }
        }
        return true;
    }

    private final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree state:");
        AbstractC13042fc3.h(sb, "append(...)");
        sb.append('\n');
        AbstractC13042fc3.h(sb, "append(...)");
        e(this, sb, this.a, 0);
        return sb.toString();
    }

    private static final void e(C7457Ru3 c7457Ru3, StringBuilder sb, C3419Au3 c3419Au3, int i) {
        String strF = c7457Ru3.f(c3419Au3);
        if (strF.length() > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("..");
            }
            sb.append(strF);
            AbstractC13042fc3.h(sb, "append(...)");
            sb.append('\n');
            AbstractC13042fc3.h(sb, "append(...)");
            i++;
        }
        List listR = c3419Au3.R();
        int size = listR.size();
        for (int i3 = 0; i3 < size; i3++) {
            e(c7457Ru3, sb, (C3419Au3) listR.get(i3), i);
        }
    }

    private final String f(C3419Au3 c3419Au3) {
        StringBuilder sb = new StringBuilder();
        sb.append(c3419Au3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(c3419Au3.g0());
        sb2.append(']');
        sb.append(sb2.toString());
        if (!c3419Au3.o()) {
            sb.append("[!isPlaced]");
        }
        sb.append("[measuredByParent=" + c3419Au3.p0() + ']');
        if (!b(c3419Au3)) {
            sb.append("[INCONSISTENT]");
        }
        return sb.toString();
    }

    public final void a() {
        if (!c(this.a)) {
            System.out.println((Object) d());
            throw new IllegalStateException("Inconsistency found!");
        }
    }
}
