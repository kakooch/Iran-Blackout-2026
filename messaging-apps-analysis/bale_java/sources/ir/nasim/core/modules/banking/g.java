package ir.nasim.core.modules.banking;

import ir.nasim.AbstractC19902r80;
import ir.nasim.C13466gH0;
import ir.nasim.C14505i18;
import ir.nasim.C6517Nv5;
import ir.nasim.C7234Qv5;
import ir.nasim.DB3;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC6990Pv5;
import ir.nasim.KN6;
import ir.nasim.OG0;
import ir.nasim.Y50;

/* loaded from: classes5.dex */
class g {
    private InterfaceC3570Bk5 a;
    private DB3 b = KN6.l("card_masks", C13466gH0.i);

    g(InterfaceC3570Bk5 interfaceC3570Bk5) {
        this.a = interfaceC3570Bk5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(byte[] bArr, C7234Qv5 c7234Qv5) {
        c7234Qv5.b(new OG0(bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(C7234Qv5 c7234Qv5) {
        try {
            c7234Qv5.b(this.b.k());
        } catch (Exception e) {
            c7234Qv5.a(e);
        }
    }

    private void k(Long l) {
        this.a.remove(l + "");
        this.b.b(l.longValue());
    }

    C6517Nv5 c(OG0 og0) {
        if (!og0.j()) {
            return C6517Nv5.F(new Exception("CARD_NOT_VALID"));
        }
        C13466gH0 c13466gH0 = new C13466gH0(og0.d());
        c13466gH0.C(og0.h());
        byte[] bArrQ = og0.q();
        this.a.n(c13466gH0.s() + "", bArrQ);
        this.b.d(c13466gH0);
        return C6517Nv5.l0(C14505i18.a);
    }

    C6517Nv5 d(String str, String str2) {
        if (AbstractC19902r80.d(str2).equals(Y50.d)) {
            return C6517Nv5.F(new Exception("CARD_NOT_VALID"));
        }
        byte[] bArrQ = new OG0(str2, "0001", "1234").q();
        C13466gH0 c13466gH0 = new C13466gH0(str, str2);
        long jS = c13466gH0.s();
        String strValueOf = String.valueOf(jS);
        if (this.a.b(strValueOf) == null || this.b.a(jS) == null) {
            this.a.n(strValueOf, bArrQ);
            this.b.d(c13466gH0);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    C6517Nv5 e(C13466gH0 c13466gH0) {
        return c13466gH0 == null ? C6517Nv5.F(new Exception("NULL_CardMaskInfo")) : f(Long.valueOf(c13466gH0.s()));
    }

    C6517Nv5 f(Long l) {
        final byte[] bArrA = this.a.a(l + "");
        if (bArrA != null) {
            return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.core.modules.banking.f
                @Override // ir.nasim.InterfaceC6990Pv5
                public final void a(C7234Qv5 c7234Qv5) {
                    g.h(bArrA, c7234Qv5);
                }
            });
        }
        k(l);
        return C6517Nv5.F(new Exception("LOSTEDSource_CardMaskInfo"));
    }

    C6517Nv5 g() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.core.modules.banking.e
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.i(c7234Qv5);
            }
        });
    }

    C6517Nv5 j(C13466gH0 c13466gH0) {
        if (c13466gH0 == null) {
            return C6517Nv5.F(new Exception("NULL_CardMaskInfo"));
        }
        k(Long.valueOf(c13466gH0.s()));
        return C6517Nv5.l0(C14505i18.a);
    }
}
