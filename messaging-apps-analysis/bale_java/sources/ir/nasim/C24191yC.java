package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.yC, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24191yC implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CD4 a(C23011wC c23011wC) {
        AbstractC13042fc3.i(c23011wC, DialogEntity.COLUMN_MESSAGE);
        VB vbU = c23011wC.u();
        if (vbU instanceof C13420gC) {
            return new C24214yE4(c23011wC.w());
        }
        if (vbU instanceof C20548sC) {
            return new VD4(new C11909dl1(c23011wC));
        }
        if (vbU instanceof C21825uC) {
            return new XD4(new C11909dl1(c23011wC));
        }
        if (vbU instanceof C22415vC) {
            return new YD4(new C11909dl1(c23011wC), ((C22415vC) vbU).u());
        }
        if (vbU instanceof C21151tC) {
            return new WD4(new C11909dl1(c23011wC));
        }
        if (!(vbU instanceof C18757pC)) {
            return vbU instanceof C9576aC ? new MD4(new C11909dl1(c23011wC)) : vbU instanceof C15802kC ? new RD4(new C11909dl1(c23011wC)) : vbU instanceof C15211jC ? new QD4(new C11909dl1(c23011wC)) : vbU instanceof C14011hC ? new OD4(new C11909dl1(c23011wC)) : vbU instanceof C14613iC ? new PD4(new C11909dl1(c23011wC)) : vbU instanceof C16393lC ? new SD4(new C11909dl1(c23011wC)) : vbU instanceof C10786cC ? new ND4(new C11909dl1(c23011wC)) : vbU instanceof C17575nC ? new TD4(new C11909dl1(c23011wC)) : vbU instanceof YB ? new LD4(new C11909dl1(c23011wC)) : new C24214yE4(null);
        }
        C18757pC c18757pC = (C18757pC) vbU;
        if (c18757pC.u() != EnumC5091Hw.MISSED) {
            new C24214yE4(null);
        }
        Boolean boolZ = c18757pC.z();
        return new UD4(boolZ != null ? boolZ.booleanValue() : false);
    }
}
