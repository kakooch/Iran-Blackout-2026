package ir.nasim;

import ir.nasim.G73;
import ir.nasim.TO5;
import ir.nasim.U73;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ll1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16721ll1 implements InterfaceC14123hO3 {
    private final G73 b(C22149uk7 c22149uk7, U73 u73) {
        String strG = u73.g();
        if (strG != null && strG.length() != 0) {
            return new G73.g(c22149uk7.v(), u73.f(), u73.g());
        }
        String strH = u73.h();
        if (strH != null && strH.length() != 0) {
            return new G73.i(c22149uk7.v(), u73.f(), u73.h());
        }
        if (u73.a() != null) {
            return new G73.a(c22149uk7.v(), u73.f());
        }
        if (u73.c() != null) {
            long jV = c22149uk7.v();
            String strF = u73.f();
            U73.a aVarC = u73.c();
            String strA = aVarC != null ? aVarC.a() : null;
            if (strA == null) {
                strA = "";
            }
            return new G73.b(jV, strF, new C6680On1(strA));
        }
        if (u73.d() == null) {
            return u73.e() ? new G73.e(c22149uk7.v(), u73.f(), u73.b()) : C8386Vt0.k7() ? new G73.f(c22149uk7.v(), u73.f()) : new G73.e(c22149uk7.v(), u73.f(), u73.b());
        }
        long jV2 = c22149uk7.v();
        String strF2 = u73.f();
        String strQ = u73.d().q();
        AbstractC13042fc3.h(strQ, "getId(...)");
        return new G73.c(jV2, strF2, strQ, e(u73.d()));
    }

    private final List d(C22149uk7 c22149uk7) {
        ArrayList arrayList = new ArrayList();
        for (W73 w73 : c22149uk7.s().r()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = w73.a().iterator();
            while (it.hasNext()) {
                arrayList2.add(b(c22149uk7, (U73) it.next()));
            }
            arrayList.add(new C20281rk7(arrayList2));
        }
        return arrayList;
    }

    private final TO5 e(C18611ox c18611ox) {
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

    private final C19672qk7 f(J08 j08) {
        if (!j08.J().getIsReacted() && j08.J().getVoiceTranscriptState() == EnumC9477a18.d && C8386Vt0.a.Vb()) {
            return new C19672qk7(AbstractC9766aX0.e(new C20281rk7(AbstractC10360bX0.p(new G73.h(0L, "👍", true), new G73.h(1L, "👎", false)))));
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C19672qk7 a(AbstractC17457n0 abstractC17457n0) {
        C19672qk7 c19672qk7F;
        if ((abstractC17457n0 instanceof J08) && (c19672qk7F = f((J08) abstractC17457n0)) != null) {
            return c19672qk7F;
        }
        C22149uk7 c22149uk7 = abstractC17457n0 instanceof C22149uk7 ? (C22149uk7) abstractC17457n0 : null;
        if (c22149uk7 != null && c22149uk7.w()) {
            return new C19672qk7(d(c22149uk7));
        }
        return null;
    }
}
