package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.z90, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC24754z90 {
    public static final a a0 = a.a;

    /* renamed from: ir.nasim.z90$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    private default boolean C(ArrayList arrayList, ArrayList arrayList2) {
        Object next;
        if (arrayList == null || arrayList.isEmpty() || arrayList.size() != arrayList2.size()) {
            return true;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            BankCreditCard bankCreditCard = (BankCreditCard) it.next();
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (AbstractC13042fc3.d((BankCreditCard) next, bankCreditCard)) {
                    break;
                }
            }
            if (((BankCreditCard) next) == null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void K(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void n0(C20298rm4 c20298rm4, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(bankCreditCard));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void r0(C20298rm4 c20298rm4, Boolean bool) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(bool));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void t(InterfaceC24754z90 interfaceC24754z90, ArrayList arrayList, C20298rm4 c20298rm4, ArrayList arrayList2) {
        AbstractC13042fc3.i(interfaceC24754z90, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.f(arrayList2);
        if (interfaceC24754z90.C(arrayList, arrayList2)) {
            c20298rm4.n(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void v(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    default androidx.lifecycle.r Q(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "bankCard");
        final C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC5969Lp4.d().o2().y().H2(bankCreditCard).m0(new InterfaceC24449ye1() { // from class: ir.nasim.x90
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                InterfaceC24754z90.r0(c20298rm4, (Boolean) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.y90
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                InterfaceC24754z90.K(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    default C6517Nv5 V(int i) {
        return AbstractC5969Lp4.d().o2().y().e2(i);
    }

    default androidx.lifecycle.r c0() {
        final C20298rm4 c20298rm4 = new C20298rm4();
        final ArrayList arrayListZ1 = AbstractC5969Lp4.d().o2().y().Z1(BankCreditCard.c.a);
        c20298rm4.n(arrayListZ1);
        AbstractC5969Lp4.d().o2().y().R1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.u90
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                InterfaceC24754z90.t(this.a, arrayListZ1, c20298rm4, (ArrayList) obj);
            }
        });
        return c20298rm4;
    }

    default androidx.lifecycle.r e() {
        C20298rm4 c20298rm4 = new C20298rm4();
        ArrayList<BankCreditCard> arrayListZ1 = AbstractC5969Lp4.d().o2().y().Z1(BankCreditCard.c.a);
        if (arrayListZ1 != null) {
            for (BankCreditCard bankCreditCard : arrayListZ1) {
                if (bankCreditCard.isDefault()) {
                    c20298rm4.n(bankCreditCard.getNumber());
                }
            }
        }
        return c20298rm4;
    }

    default androidx.lifecycle.r getConfig() {
        C20298rm4 c20298rm4 = new C20298rm4();
        c20298rm4.n(new KS2().k(AbstractC5969Lp4.d().o2().S().b1(), CardToCardConfig.class));
        return c20298rm4;
    }

    default ArrayList o0() {
        return AbstractC5969Lp4.d().o2().y().Z1(BankCreditCard.c.a);
    }

    default androidx.lifecycle.r t0(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        final C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC5969Lp4.e().y().Y0(bankCreditCard).m0(new InterfaceC24449ye1() { // from class: ir.nasim.v90
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                InterfaceC24754z90.n0(c20298rm4, (BankCreditCard) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.w90
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                InterfaceC24754z90.v(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
