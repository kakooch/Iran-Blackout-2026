package ir.nasim;

import android.content.Context;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes5.dex */
public class NI5 extends E50 {
    private String c;
    private LI5 d;
    private TI5 e;
    private Boolean f;
    private C19811qz g;
    private C19811qz h;

    public NI5(C11909dl1 c11909dl1) {
        String str;
        super(c11909dl1);
        this.f = null;
        if (((C12038dw) c11909dl1.c()).u() instanceof C21142tB) {
            this.f = Boolean.FALSE;
            C21142tB c21142tB = (C21142tB) ((C12038dw) c11909dl1.c()).u();
            this.h = c21142tB.w();
            this.g = c21142tB.u();
            String strE = PH3.e();
            String lowerCase = strE == null ? "fa" : strE.toLowerCase();
            try {
                Iterator it = this.g.u().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C20420rz c20420rz = (C20420rz) it.next();
                    if (c20420rz != null && c20420rz.getKey() != null && c20420rz.getKey().equals(lowerCase)) {
                        AbstractC17566nB abstractC17566nBQ = c20420rz.q();
                        if (abstractC17566nBQ instanceof OC) {
                            this.c = ((OC) abstractC17566nBQ).u();
                        }
                    }
                }
                String str2 = this.c;
                if (str2 == null || str2.length() == 0) {
                    for (C20420rz c20420rz2 : c21142tB.u().u()) {
                        if (c20420rz2 != null && c20420rz2.getKey() != null && c20420rz2.getKey().equals("fa")) {
                            AbstractC17566nB abstractC17566nBQ2 = c20420rz2.q();
                            if (abstractC17566nBQ2 instanceof OC) {
                                this.c = ((OC) abstractC17566nBQ2).u();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                C19406qI3.d("receipt/Parser", e);
                return;
            }
        }
        if (!(((C12038dw) c11909dl1.c()).u() instanceof C21679tx)) {
            this.f = null;
            C19406qI3.a("receipt/Parser", "Unsupported receipt.", new Object[0]);
            return;
        }
        this.f = Boolean.TRUE;
        HashMap map = new HashMap();
        C21679tx c21679tx = (C21679tx) ((C12038dw) c11909dl1.c()).u();
        this.e = TI5.j(c21679tx.u().j());
        C19811qz c19811qzW = c21679tx.w();
        this.h = c19811qzW;
        for (C20420rz c20420rz3 : c19811qzW.u()) {
            map.put(c20420rz3.getKey(), c20420rz3.q());
        }
        try {
            TI5 ti5 = this.e;
            try {
                if (ti5 == TI5.MONEY_TRANSFER) {
                    C6872Pi4 c6872Pi4 = new C6872Pi4();
                    c6872Pi4.l(Boolean.valueOf(map.containsKey("isSuccess") && ((C19784qw) map.get("isSuccess")).u()));
                    c6872Pi4.u(map.containsKey("origin") ? ((OC) map.get("origin")).u() : "-404");
                    c6872Pi4.s(map.containsKey("dest") ? ((OC) map.get("dest")).u() : "-404");
                    c6872Pi4.m(map.containsKey("traceNo") ? ((OC) map.get("traceNo")).u() : "-404");
                    c6872Pi4.i(Long.valueOf(map.containsKey("amount") ? ((C5811Ky) map.get("amount")).u() : -404L));
                    c6872Pi4.v(map.containsKey("type") ? ((OC) map.get("type")).u() : "-404");
                    c6872Pi4.n(map.containsKey("transactionDate") ? ((OC) map.get("transactionDate")).u() : "-404");
                    c6872Pi4.r(map.containsKey("counterpartyName") ? ((OC) map.get("counterpartyName")).u() : "-404");
                    c6872Pi4.k(map.containsKey("responseCode") ? ((OC) map.get("responseCode")).u() : "-404");
                    c6872Pi4.t(Boolean.valueOf(map.containsKey("isExpenditure") && ((C19784qw) map.get("isExpenditure")).u()));
                    this.d = c6872Pi4;
                    return;
                }
                if (ti5 == TI5.CHARGE) {
                    C15875kK0 c15875kK0 = new C15875kK0();
                    c15875kK0.l(Boolean.valueOf(map.containsKey("isSuccess") && ((C19784qw) map.get("isSuccess")).u()));
                    c15875kK0.k(map.containsKey("responseCode") ? ((OC) map.get("responseCode")).u() : "-404");
                    c15875kK0.n(map.containsKey("transactionDate") ? ((OC) map.get("transactionDate")).u() : "-404");
                    c15875kK0.m(map.containsKey("traceNo") ? ((OC) map.get("traceNo")).u() : "-404");
                    c15875kK0.j(map.containsKey(DialogEntity.COLUMN_MESSAGE) ? ((OC) map.get(DialogEntity.COLUMN_MESSAGE)).u() : "-404");
                    c15875kK0.i(Long.valueOf(map.containsKey("amount") ? ((C5811Ky) map.get("amount")).u() : -404L));
                    c15875kK0.q(map.containsKey("pin") ? ((OC) map.get("pin")).u() : "-404");
                    c15875kK0.r(map.containsKey("providerId") ? ((OC) map.get("providerId")).u() : "-404");
                    this.d = c15875kK0;
                    return;
                }
                if (ti5 != TI5.BILL) {
                    if (ti5 == TI5.PURCHASE) {
                        return;
                    }
                    str = "receipt/Parser";
                    try {
                        C19406qI3.b(str, "Unsupported receipt type.");
                        return;
                    } catch (Exception e2) {
                        e = e2;
                        C19406qI3.d(str, e);
                        return;
                    }
                }
                C4213Ee0 c4213Ee0 = new C4213Ee0();
                c4213Ee0.l(Boolean.valueOf(map.containsKey("isSuccess") && ((C19784qw) map.get("isSuccess")).u()));
                c4213Ee0.k(map.containsKey("responseCode") ? ((OC) map.get("responseCode")).u() : "-404");
                c4213Ee0.n(map.containsKey("transactionDate") ? ((OC) map.get("transactionDate")).u() : "-404");
                c4213Ee0.m(map.containsKey("traceNo") ? ((OC) map.get("traceNo")).u() : "-404");
                c4213Ee0.j(map.containsKey(DialogEntity.COLUMN_MESSAGE) ? ((OC) map.get(DialogEntity.COLUMN_MESSAGE)).u() : "-404");
                c4213Ee0.i(Long.valueOf(map.containsKey("amount") ? ((C5811Ky) map.get("amount")).u() : -404L));
                this.d = c4213Ee0;
            } catch (Exception e3) {
                e = e3;
                str = "receipt/Parser";
            }
        } catch (Exception e4) {
            e = e4;
            str = "receipt/Parser";
        }
    }

    @Override // ir.nasim.E50, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_bank_receipt);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NI5 ni5 = (NI5) obj;
        return Objects.equals(this.c, ni5.c) && Objects.equals(this.d, ni5.d) && this.e == ni5.e && Objects.equals(this.f, ni5.f) && Objects.equals(this.g, ni5.g) && Objects.equals(this.h, ni5.h);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // ir.nasim.E50, ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return new C23345wl7(new C11909dl1(new ZC(this.c, new ArrayList(), null, null)));
    }

    public C19811qz r() {
        return this.g;
    }

    public C19811qz s() {
        return this.h;
    }

    public LI5 t() {
        return this.d;
    }

    public TI5 u() {
        return this.e;
    }

    public String v() {
        return this.c;
    }

    public Boolean w() {
        return this.f;
    }
}
