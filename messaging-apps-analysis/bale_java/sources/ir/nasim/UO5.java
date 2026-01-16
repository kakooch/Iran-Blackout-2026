package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC13790gp3;
import ir.nasim.TO5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class UO5 extends AbstractC17457n0 {
    private final List c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UO5(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        this.c = r(c11909dl1);
    }

    private final List r(C11909dl1 c11909dl1) {
        C24772zB c24772zBY;
        List listQ;
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        TC tc = abstractC24063xzC instanceof TC ? (TC) abstractC24063xzC : null;
        if (tc == null || (c24772zBY = tc.y()) == null || (listQ = c24772zBY.q()) == null) {
            return AbstractC10360bX0.m();
        }
        List<C15674jz> list = listQ;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (C15674jz c15674jz : list) {
            AbstractC13042fc3.f(c15674jz);
            arrayList.add(v(c15674jz));
        }
        return arrayList;
    }

    private final TO5 t(C18611ox c18611ox) {
        AbstractC19202px abstractC19202pxR = c18611ox.r();
        if (abstractC19202pxR instanceof C9214Yz) {
            String strQ = c18611ox.q();
            AbstractC13042fc3.h(strQ, "getId(...)");
            C9214Yz c9214Yz = (C9214Yz) abstractC19202pxR;
            String strZ = c9214Yz.z();
            AbstractC13042fc3.h(strZ, "getTitle(...)");
            String strW = c9214Yz.w();
            AbstractC13042fc3.h(strW, "getDescription(...)");
            String strU = c9214Yz.u();
            AbstractC13042fc3.h(strU, "getAgreeButton(...)");
            String strY = c9214Yz.y();
            AbstractC13042fc3.h(strY, "getDisagreeButton(...)");
            return new TO5.b(strQ, strZ, strW, strU, strY);
        }
        if (abstractC19202pxR instanceof AC) {
            String strQ2 = c18611ox.q();
            AbstractC13042fc3.h(strQ2, "getId(...)");
            String strU2 = ((AC) abstractC19202pxR).u();
            AbstractC13042fc3.h(strU2, "getText(...)");
            return new TO5.d(strQ2, strU2);
        }
        if (!(abstractC19202pxR instanceof C10152bA)) {
            if (abstractC19202pxR instanceof C4149Dx) {
                String strQ3 = c18611ox.q();
                AbstractC13042fc3.h(strQ3, "getId(...)");
                return new TO5.a(strQ3);
            }
            String strQ4 = c18611ox.q();
            AbstractC13042fc3.h(strQ4, "getId(...)");
            return new TO5.a(strQ4);
        }
        C10152bA c10152bA = (C10152bA) abstractC19202pxR;
        EnumC4140Dw enumC4140DwU = c10152bA.u();
        int iOrdinal = enumC4140DwU != null ? enumC4140DwU.ordinal() : 0;
        String strQ5 = c18611ox.q();
        AbstractC13042fc3.h(strQ5, "getId(...)");
        String strW2 = c10152bA.w();
        AbstractC13042fc3.h(strW2, "getUrl(...)");
        YO5 yo5 = (YO5) AbstractC15401jX0.t0(YO5.j(), iOrdinal);
        if (yo5 == null) {
            yo5 = YO5.a;
        }
        return new TO5.c(strQ5, strW2, yo5);
    }

    private final AbstractC13790gp3 u(C9439Zy c9439Zy) {
        String strQ;
        Boolean boolY = c9439Zy.y();
        Boolean bool = Boolean.TRUE;
        if (AbstractC13042fc3.d(boolY, bool)) {
            String strR = c9439Zy.r();
            AbstractC13042fc3.h(strR, "getText(...)");
            return new AbstractC13790gp3.e(strR);
        }
        if (AbstractC13042fc3.d(c9439Zy.u(), bool)) {
            String strR2 = c9439Zy.r();
            AbstractC13042fc3.h(strR2, "getText(...)");
            return new AbstractC13790gp3.c(strR2);
        }
        if (AbstractC13042fc3.d(c9439Zy.w(), bool)) {
            String strR3 = c9439Zy.r();
            AbstractC13042fc3.h(strR3, "getText(...)");
            return new AbstractC13790gp3.d(strR3);
        }
        C23610xD c23610xDS = c9439Zy.s();
        String strQ2 = c23610xDS != null ? c23610xDS.q() : null;
        if (strQ2 != null && !AbstractC20762sZ6.n0(strQ2)) {
            String strR4 = c9439Zy.r();
            AbstractC13042fc3.h(strR4, "getText(...)");
            C23610xD c23610xDS2 = c9439Zy.s();
            strQ = c23610xDS2 != null ? c23610xDS2.q() : null;
            return new AbstractC13790gp3.b(strR4, strQ != null ? strQ : "");
        }
        if (c9439Zy.q() == null) {
            if (C8386Vt0.N9()) {
                String strR5 = c9439Zy.r();
                AbstractC13042fc3.h(strR5, "getText(...)");
                return new AbstractC13790gp3.g(strR5);
            }
            String strR6 = c9439Zy.r();
            AbstractC13042fc3.h(strR6, "getText(...)");
            return new AbstractC13790gp3.e(strR6);
        }
        String strR7 = c9439Zy.r();
        AbstractC13042fc3.h(strR7, "getText(...)");
        C18611ox c18611oxQ = c9439Zy.q();
        strQ = c18611oxQ != null ? c18611oxQ.q() : null;
        String str = strQ != null ? strQ : "";
        C18611ox c18611oxQ2 = c9439Zy.q();
        AbstractC13042fc3.f(c18611oxQ2);
        return new AbstractC13790gp3.a(strR7, str, t(c18611oxQ2));
    }

    private final VO5 v(C15674jz c15674jz) {
        List listQ = c15674jz.q();
        AbstractC13042fc3.h(listQ, "getKeyboardList(...)");
        List<C9439Zy> list = listQ;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (C9439Zy c9439Zy : list) {
            AbstractC13042fc3.f(c9439Zy);
            arrayList.add(u(c9439Zy));
        }
        return new VO5(arrayList);
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return InterfaceC25103zk1.a.a(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(UO5.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.ReplyKeyboardMarkup");
        return AbstractC13042fc3.d(this.c, ((UO5) obj).c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final List s() {
        return this.c;
    }
}
