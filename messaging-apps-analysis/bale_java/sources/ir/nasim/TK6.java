package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class TK6 extends UK6 {
    private final WH1 g;
    private long h;
    public EnumC12613eu3 i;
    private final List j;
    private boolean k;
    private final Set l;

    public TK6(WH1 wh1) {
        AbstractC13042fc3.i(wh1, "density");
        this.g = wh1;
        this.h = AbstractC19606qe1.b(0, 0, 0, 0, 15, null);
        this.j = new ArrayList();
        this.k = true;
        this.l = new LinkedHashSet();
    }

    @Override // ir.nasim.UK6
    public int d(Object obj) {
        return obj instanceof C17784nZ1 ? this.g.B0(((C17784nZ1) obj).v()) : super.d(obj);
    }

    @Override // ir.nasim.UK6
    public void k() {
        C16651le1 c16651le1A;
        HashMap map = this.a;
        AbstractC13042fc3.h(map, "mReferences");
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            InterfaceC14709iL5 interfaceC14709iL5 = (InterfaceC14709iL5) ((Map.Entry) it.next()).getValue();
            if (interfaceC14709iL5 != null && (c16651le1A = interfaceC14709iL5.a()) != null) {
                c16651le1A.u0();
            }
        }
        this.a.clear();
        HashMap map2 = this.a;
        AbstractC13042fc3.h(map2, "mReferences");
        map2.put(UK6.f, this.d);
        this.j.clear();
        this.k = true;
        super.k();
    }

    public final EnumC12613eu3 p() {
        EnumC12613eu3 enumC12613eu3 = this.i;
        if (enumC12613eu3 != null) {
            return enumC12613eu3;
        }
        AbstractC13042fc3.y("layoutDirection");
        throw null;
    }

    public final long q() {
        return this.h;
    }

    public final boolean r(C16651le1 c16651le1) {
        AbstractC13042fc3.i(c16651le1, "constraintWidget");
        if (this.k) {
            this.l.clear();
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                InterfaceC14709iL5 interfaceC14709iL5 = (InterfaceC14709iL5) this.a.get(it.next());
                C16651le1 c16651le1A = interfaceC14709iL5 == null ? null : interfaceC14709iL5.a();
                if (c16651le1A != null) {
                    this.l.add(c16651le1A);
                }
            }
            this.k = false;
        }
        return this.l.contains(c16651le1);
    }

    public final void s(EnumC12613eu3 enumC12613eu3) {
        AbstractC13042fc3.i(enumC12613eu3, "<set-?>");
        this.i = enumC12613eu3;
    }

    public final void t(long j) {
        this.h = j;
    }
}
