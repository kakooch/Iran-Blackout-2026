package ir.nasim.features.root;

import ai.bale.proto.MarketOuterClass$ResponseGetCategories;
import android.os.Handler;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13554gQ7;
import ir.nasim.AbstractC4177Ea0;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11335cq;
import ir.nasim.C11458d25;
import ir.nasim.C14733iO2;
import ir.nasim.C17213mb2;
import ir.nasim.C19406qI3;
import ir.nasim.C23230wa2;
import ir.nasim.C5721Ko;
import ir.nasim.C6305Na3;
import ir.nasim.C7183Qq;
import ir.nasim.C8386Vt0;
import ir.nasim.C92;
import ir.nasim.C9248Zc6;
import ir.nasim.ED1;
import ir.nasim.EnumC11723dV1;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.InterfaceC14538i46;
import ir.nasim.InterfaceC14756iQ7;
import ir.nasim.InterfaceC22634va2;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC5620Kc6;
import ir.nasim.InterfaceC7298Rc6;
import ir.nasim.InterfaceC9291Zh4;
import ir.nasim.Q12;
import ir.nasim.SZ;
import ir.nasim.T12;
import ir.nasim.W06;
import ir.nasim.W12;
import ir.nasim.X25;
import ir.nasim.XY6;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes6.dex */
public final class G extends AbstractC4177Ea0 {
    public static final b l = new b(null);
    public static final int m = 8;
    private InterfaceC14538i46 f;
    private Handler g;
    private Runnable h;
    private InterfaceC22634va2 i;
    private final SettingsModule j;
    private final BankingModule k;

    public interface a {
        void a(ExPeerType exPeerType);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(InterfaceC14538i46 interfaceC14538i46) {
        super(interfaceC14538i46);
        AbstractC13042fc3.i(interfaceC14538i46, "presenterImp");
        this.f = interfaceC14538i46;
        this.g = new Handler();
        C5721Ko c5721Ko = C5721Ko.a;
        this.j = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).b1();
        this.k = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).g();
        B();
    }

    private final void A() {
        y().r0();
    }

    private final void B() {
        C11335cq c11335cqD;
        String strS;
        try {
            this.i = new C23230wa2((C8386Vt0.J5() || (c11335cqD = AbstractC5969Lp4.d()) == null || (strS = c11335cqD.S()) == null) ? "" : strS, C7183Qq.p().getLong("last_event_bar_visited_id", -1L), C7183Qq.p().getLong("event_bar_last_display_in_ms", 0L), (C8386Vt0.J5() || y().Z3()) ? false : this.j.R7());
        } catch (Exception e) {
            C19406qI3.a("RootFragmentMVPPresenter", e.getMessage(), new Object[0]);
        }
    }

    private final boolean C() {
        return this.j.z5() || this.j.x5() || this.j.y5() || this.j.w5();
    }

    private final void E() {
        AbstractC5969Lp4.e().F().O(0, 1, AbstractC5969Lp4.e().F().N(), true).m0(new InterfaceC24449ye1() { // from class: ir.nasim.f46
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.root.G.F(this.a, (MarketOuterClass$ResponseGetCategories) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final G g, final MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories) {
        AbstractC13042fc3.i(g, "this$0");
        AbstractC13042fc3.i(marketOuterClass$ResponseGetCategories, "responseGetCategories");
        C9248Zc6 c9248Zc6G = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.g46
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return ir.nasim.features.root.G.G(this.a, marketOuterClass$ResponseGetCategories);
            }
        }).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.h46
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                ir.nasim.features.root.G.H(this.a, ((Boolean) obj).booleanValue());
            }
        });
        AbstractC13042fc3.h(c9248Zc6G, "onSuccess(...)");
        SZ.e(c9248Zc6G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean G(G g, MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories) {
        AbstractC13042fc3.i(g, "this$0");
        AbstractC13042fc3.i(marketOuterClass$ResponseGetCategories, "$responseGetCategories");
        return Boolean.valueOf(g.q(marketOuterClass$ResponseGetCategories));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(G g, boolean z) {
        AbstractC13042fc3.i(g, "this$0");
        if (z) {
            g.y().p0();
        }
    }

    private final void L(Integer num) {
        if (num == null || num.intValue() <= 0) {
            A();
        } else {
            P(num.intValue());
        }
    }

    private final void N() {
        if (w().t() != 0) {
            C7183Qq.p().putLong("last_event_bar_visited_id", w().t());
        }
    }

    private final void P(int i) {
        y().b1(XY6.v(i > 99 ? "+99" : String.valueOf(i)));
    }

    private final void Q() {
        if (w().x()) {
            C7183Qq.p().putLong("event_bar_last_display_in_ms", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(G g) {
        AbstractC13042fc3.i(g, "this$0");
        if (C7183Qq.p().h("user_select_another_tab", false) && g.D()) {
            g.y().X1();
        }
    }

    private final void U() {
        if (w().x()) {
            C17213mb2.l("New_click_update_event_bar_link", "", "");
        } else if (w().y()) {
            C17213mb2.k("New_click_festival_event_bar_link", "id", Long.valueOf(w().t()));
        }
    }

    private final void V() {
        if (w().x()) {
            C17213mb2.l("New_close_update_event_bar", "", "");
        } else if (w().y()) {
            C17213mb2.k("New_close_festival_event_bar", "id", Long.valueOf(w().t()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(G g, Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(g, "this$0");
        AbstractC13042fc3.i(abstractC13554gQ7, "<unused var>");
        g.L(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(G g) {
        AbstractC13042fc3.i(g, "this$0");
        g.y().Z1();
    }

    private final void p() {
        if (!AbstractC5969Lp4.d().w0(EnumC4716Gg2.A)) {
            C7183Qq.p().remove("market_badge_was_shown");
        } else {
            if (C7183Qq.p().h("market_badge_was_shown", false)) {
                return;
            }
            y().p0();
        }
    }

    private final boolean q(MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories) {
        return marketOuterClass$ResponseGetCategories.getVersion().getValue() > AbstractC5969Lp4.e().F().N();
    }

    private final void r() {
        if (this.j.B5(EnumC4716Gg2.B)) {
            E();
        }
    }

    private final void s() {
        int iU1 = this.k.u1();
        int iC2 = this.k.c2();
        if (iC2 > iU1) {
            y().q3();
        } else if (iC2 < iU1) {
            this.k.Q2(iC2);
            y().k1();
        }
    }

    private final void u() {
        InterfaceC22634va2 interfaceC22634va2W = w();
        interfaceC22634va2W.j(false);
        interfaceC22634va2W.o(false);
    }

    public final boolean D() {
        int iX1 = this.j.x1();
        return C7183Qq.p().getInt("dialog_tab_click_after_default_tab", 0) >= iX1 || C7183Qq.p().getInt("my_bank_tab_click_after_default_tab", 0) >= iX1 || C7183Qq.p().getInt("vitrine_tab_click_after_default_tab", 0) >= iX1;
    }

    public final void I() {
        V();
        N();
        Q();
        u();
    }

    public final void J() {
        U();
    }

    public void K() {
        l();
        p();
        r();
        s();
    }

    public final void M() {
        Runnable runnable = this.h;
        if (runnable != null) {
            this.g.removeCallbacks(runnable);
        }
    }

    public final void O() {
        int iU1 = this.k.u1();
        int iC2 = this.k.c2();
        if (iC2 > iU1) {
            this.k.Q2(iC2);
            y().k1();
        }
    }

    public final boolean R(int i) {
        boolean zH = C7183Qq.p().h("isArbaeenUserFirstShow", false);
        boolean zK = w().k(i);
        if (!zK || !zH) {
            return zK && !zH;
        }
        C7183Qq.p().g("isArbaeenUserFirstShow", false);
        return false;
    }

    public final void S() {
        Runnable runnable = new Runnable() { // from class: ir.nasim.d46
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.root.G.T(this.a);
            }
        };
        Handler handler = this.g;
        Q12.a aVar = Q12.b;
        handler.postDelayed(runnable, Q12.A(T12.s(1, W12.e)));
        this.h = runnable;
    }

    public final void W() {
        if (w().x()) {
            C17213mb2.l("New_show_update_event_bar", "", "");
        } else if (w().y()) {
            C17213mb2.k("New_show_festival_event_bar", "id", Long.valueOf(w().t()));
        }
    }

    public final void l() {
        if (C()) {
            y().r0();
            return;
        }
        C6305Na3 c6305Na3D = AbstractC5969Lp4.d().U().d();
        AbstractC13042fc3.h(c6305Na3D, "getGlobalCounter(...)");
        a(c6305Na3D, new InterfaceC14756iQ7() { // from class: ir.nasim.e46
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                ir.nasim.features.root.G.m(this.a, (Integer) obj, abstractC13554gQ7);
            }
        });
    }

    public final void n() {
        if (this.j.I1() > 0) {
            this.g.postDelayed(new Runnable() { // from class: ir.nasim.c46
                @Override // java.lang.Runnable
                public final void run() {
                    ir.nasim.features.root.G.o(this.a);
                }
            }, this.j.I1());
        }
    }

    public final void t(C11458d25 c11458d25, a aVar) {
        C14733iO2 c14733iO2;
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(aVar, "checkPeer");
        ExPeerType exPeerTypeA = X25.a(c11458d25);
        if (exPeerTypeA == null) {
            y().L2(AbstractC12217eE5.toast_chat_not_found);
            return;
        }
        if (!c11458d25.z() || (c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c11458d25.getPeerId())) == null || c14733iO2.E().b() != W06.PRIVATE || ((Boolean) c14733iO2.F().b()).booleanValue()) {
            aVar.a(exPeerTypeA);
        } else {
            y().L2(AbstractC12217eE5.toast_permission_denied);
        }
    }

    public final C11458d25 v() {
        C11458d25 c11458d25R = C11458d25.r(42L);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        return c11458d25R;
    }

    public final InterfaceC22634va2 w() {
        InterfaceC22634va2 interfaceC22634va2 = this.i;
        if (interfaceC22634va2 != null) {
            return interfaceC22634va2;
        }
        AbstractC13042fc3.y("eventBarFactory");
        return null;
    }

    public final int x() {
        int iX1 = this.j.x1();
        if (C7183Qq.p().getInt("dialog_tab_click_after_default_tab", 0) >= iX1) {
            return 0;
        }
        if (C7183Qq.p().getInt("my_bank_tab_click_after_default_tab", 0) >= iX1) {
            return C8386Vt0.a.h4() ? AbstractC13089g.e1 - 1 : AbstractC13089g.e1;
        }
        return -1;
    }

    protected InterfaceC14538i46 y() {
        return this.f;
    }

    public final String z() {
        int iX1 = this.j.x1();
        return C7183Qq.p().getInt("dialog_tab_click_after_default_tab", 0) >= iX1 ? C5721Ko.a.d().getResources().getText(AbstractC12217eE5.tab_title_chat).toString() : C7183Qq.p().getInt("my_bank_tab_click_after_default_tab", 0) >= iX1 ? C5721Ko.a.d().getResources().getText(AbstractC12217eE5.tab_title_khadamat).toString() : C7183Qq.p().getInt("vitrine_tab_click_after_default_tab", 0) >= iX1 ? C5721Ko.a.d().getResources().getText(AbstractC12217eE5.tab_title_vitrine).toString() : "";
    }
}
