package ir.nasim;

import android.os.Handler;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.network.RpcException;
import java.util.List;

/* renamed from: ir.nasim.jg2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15490jg2 extends AbstractC4177Ea0 {
    private final InterfaceC16081kg2 f;
    private final SettingsModule g;
    private final BankingModule h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15490jg2(InterfaceC16081kg2 interfaceC16081kg2) {
        super(interfaceC16081kg2);
        AbstractC13042fc3.i(interfaceC16081kg2, "mvpView");
        this.f = interfaceC16081kg2;
        C5721Ko c5721Ko = C5721Ko.a;
        this.g = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).b1();
        this.h = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).g();
        new Handler().postDelayed(new Runnable() { // from class: ir.nasim.fg2
            @Override // java.lang.Runnable
            public final void run() {
                C15490jg2.j(this.a);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final C15490jg2 c15490jg2) {
        AbstractC13042fc3.i(c15490jg2, "this$0");
        c15490jg2.h.P1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.gg2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15490jg2.k(this.a, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(C15490jg2 c15490jg2, List list) {
        AbstractC13042fc3.i(c15490jg2, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            c15490jg2.f.I3();
        } else {
            c15490jg2.f.G4(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(C15490jg2 c15490jg2, Exception exc) {
        AbstractC13042fc3.i(c15490jg2, "this$0");
        RpcException rpcException = exc instanceof RpcException ? (RpcException) exc : null;
        if (rpcException != null) {
            if (AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "LOGIN_NEEDED")) {
                c15490jg2.f.m2(AbstractC20762sZ6.C0(((RpcException) exc).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String(), "PERMISSION_DENIED: "));
            } else {
                c15490jg2.f.Q3(((RpcException) exc).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(C15490jg2 c15490jg2, C16672lg2 c16672lg2) {
        AbstractC13042fc3.i(c15490jg2, "this$0");
        c15490jg2.g.O6(true);
        c15490jg2.f.R0();
    }

    public final C6517Nv5 l(C7792Tf2 c7792Tf2) {
        AbstractC13042fc3.i(c7792Tf2, "fastCharge");
        C6517Nv5 c6517Nv5M0 = this.h.e1(c7792Tf2).E(new InterfaceC24449ye1() { // from class: ir.nasim.hg2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15490jg2.m(this.a, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ig2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15490jg2.n(this.a, (C16672lg2) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    public final boolean o() {
        return this.g.A5();
    }
}
