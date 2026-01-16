package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19531qW2;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC24063xz;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.BC5;
import ir.nasim.C11335cq;
import ir.nasim.C11458d25;
import ir.nasim.C11909dl1;
import ir.nasim.C12117e41;
import ir.nasim.C12150e74;
import ir.nasim.C16247kx;
import ir.nasim.C17285mi4;
import ir.nasim.C19024pf0;
import ir.nasim.C19938rB7;
import ir.nasim.C3343Am;
import ir.nasim.C4601Fv1;
import ir.nasim.C8199Uy2;
import ir.nasim.C9743aU4;
import ir.nasim.ED1;
import ir.nasim.EnumC16838lx;
import ir.nasim.GC6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC4367Ev1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J44;
import ir.nasim.KB5;
import ir.nasim.SA2;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.features.payment.view.activity.CrowdfundingActivity;
import ir.nasim.features.payment.view.fragment.C13081n;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13074g;
import ir.nasim.features.payment.view.fragment.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J)\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0004R\u001b\u0010%\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lir/nasim/features/payment/view/fragment/u;", "Lir/nasim/La0;", "Lir/nasim/Uy2;", "<init>", "()V", "I8", "()Lir/nasim/features/payment/view/fragment/u;", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", ParameterNames.INFO, "Lir/nasim/rB7;", "L8", "(Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)V", "M8", "H8", "N8", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "attachToParent", "F8", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lir/nasim/Uy2;", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "Lir/nasim/Ev1;", "d1", "Lir/nasim/Yu3;", "G8", "()Lir/nasim/Ev1;", "viewModel", "e1", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "content", "", "f1", "J", "peerUniqueId", "", "g1", "Ljava/lang/String;", "link", "Lir/nasim/aU4;", "h1", "Lir/nasim/aU4;", "adapter", "i1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class u extends AbstractC19531qW2<C8199Uy2> {

    /* renamed from: i1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j1 = 8;

    /* renamed from: e1, reason: from kotlin metadata */
    private CrowdfundingContentInfo content;

    /* renamed from: g1, reason: from kotlin metadata */
    private String link;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Cv1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ir.nasim.features.payment.view.fragment.u.O8(this.a);
        }
    });

    /* renamed from: f1, reason: from kotlin metadata */
    private long peerUniqueId = -1;

    /* renamed from: h1, reason: from kotlin metadata */
    private final C9743aU4 adapter = new C9743aU4();

    /* renamed from: ir.nasim.features.payment.view.fragment.u$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final u a(CrowdfundingContentInfo crowdfundingContentInfo, long j, String str) {
            AbstractC13042fc3.i(crowdfundingContentInfo, "contentInfo");
            u uVar = new u();
            Bundle bundle = new Bundle();
            bundle.putParcelable("param_data", crowdfundingContentInfo);
            bundle.putLong("param_unique_id", j);
            if (str != null) {
                bundle.putString("param_link", str);
            }
            uVar.a8(bundle);
            return uVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements CrowdfundingActivity.b {
        b() {
        }

        @Override // ir.nasim.features.payment.view.activity.CrowdfundingActivity.b
        public void a(int i, int i2) {
            if (i2 == 0) {
                u.this.H8();
            } else if (i2 == 1) {
                u.this.N8();
            } else {
                if (i2 != 2) {
                    return;
                }
                u.this.M8();
            }
        }
    }

    static final class c implements InterfaceC15796kB2 {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, u uVar) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(uVar, "this$0");
            dialog.dismiss();
            CrowdfundingContentInfo crowdfundingContentInfo = uVar.content;
            if (crowdfundingContentInfo == null) {
                AbstractC13042fc3.y("content");
                crowdfundingContentInfo = null;
            }
            J44 j44J = crowdfundingContentInfo.j();
            AbstractC17457n0 abstractC17457n0F = j44J.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.CrowdfundingContent");
            C11909dl1 c11909dl1V = ((ir.nasim.core.modules.messaging.entity.content.a) abstractC17457n0F).v();
            AbstractC13042fc3.f(c11909dl1V);
            AbstractC24063xz abstractC24063xzC = c11909dl1V.c();
            AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiCrowdFundingMessage");
            C16247kx c16247kx = (C16247kx) abstractC24063xzC;
            uVar.G8().a(uVar.peerUniqueId, j44J.i(), j44J.h(), new C16247kx(c16247kx.F(), c16247kx.u(), c16247kx.C(), c16247kx.E(), c16247kx.w(), c16247kx.y(), EnumC16838lx.STOPPED, c16247kx.z()));
            uVar.Q7().finish();
            C3343Am.g("crowdfunding_stop_dialog_yes");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            C3343Am.g("crowdfunding_stop_dialog_no");
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C12117e41 c12117e41 = C12117e41.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c12117e41.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c12117e41.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(754571631);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(u.this);
            final u uVar = u.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.v
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return u.c.d(dialog, uVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.crowdfunding_stop_the_crowdfunding;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(754604712);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.payment.view.fragment.w
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return u.c.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, cVar, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.card_payment_cancel, null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H8() {
        ViewOnClickListenerC13074g.Companion companion = ViewOnClickListenerC13074g.INSTANCE;
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        Q7().B0().s().q(BC5.fragment_container, companion.a(crowdfundingContentInfo, this.peerUniqueId)).g(null).h();
    }

    private final u I8() {
        ((C8199Uy2) r8()).b.setAdapter(this.adapter);
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        C11458d25 c11458d25R = C11458d25.r(this.peerUniqueId);
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        CrowdfundingContentInfo crowdfundingContentInfo2 = null;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        Long lValueOf = Long.valueOf(crowdfundingContentInfo.j().i());
        CrowdfundingContentInfo crowdfundingContentInfo3 = this.content;
        if (crowdfundingContentInfo3 == null) {
            AbstractC13042fc3.y("content");
        } else {
            crowdfundingContentInfo2 = crowdfundingContentInfo3;
        }
        c11335cqD.a0(c11458d25R, lValueOf, Long.valueOf(crowdfundingContentInfo2.j().h())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Av1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.payment.view.fragment.u.J8(this.a, (C17285mi4) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Bv1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.payment.view.fragment.u.K8(this.a, (Exception) obj);
            }
        });
        RecyclerView recyclerView = ((C8199Uy2) r8()).b;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_crowdfunding_divider_line));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J8(u uVar, C17285mi4 c17285mi4) {
        AbstractC13042fc3.i(uVar, "this$0");
        RecyclerView recyclerView = ((C8199Uy2) uVar.r8()).b;
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        C11458d25 c11458d25R = C11458d25.r(uVar.peerUniqueId);
        CrowdfundingContentInfo crowdfundingContentInfo = uVar.content;
        CrowdfundingContentInfo crowdfundingContentInfo2 = null;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        Long lValueOf = Long.valueOf(crowdfundingContentInfo.j().i());
        CrowdfundingContentInfo crowdfundingContentInfo3 = uVar.content;
        if (crowdfundingContentInfo3 == null) {
            AbstractC13042fc3.y("content");
        } else {
            crowdfundingContentInfo2 = crowdfundingContentInfo3;
        }
        C19024pf0 c19024pf0Q2 = c11335cqD.q2(c11458d25R, lValueOf, Long.valueOf(crowdfundingContentInfo2.j().h()));
        AbstractC13042fc3.h(c19024pf0Q2, "getPaymentList(...)");
        recyclerView.setAdapter(new C12150e74(c19024pf0Q2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K8(u uVar, Exception exc) {
        AbstractC13042fc3.i(uVar, "this$0");
        uVar.Q7().B0().k1();
    }

    private final void L8(CrowdfundingContentInfo info) {
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.g(fragmentActivityQ7, "null cannot be cast to non-null type ir.nasim.features.payment.view.activity.CrowdfundingActivity");
        CrowdfundingActivity crowdfundingActivity = (CrowdfundingActivity) fragmentActivityQ7;
        crowdfundingActivity.M1(true);
        if (!info.t() && info.p() != null) {
            crowdfundingActivity.O1(true, info.d(), this.link != null);
        }
        crowdfundingActivity.N1(new b());
        crowdfundingActivity.S1(h6(AbstractC12217eE5.crowdfunding_paid_list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M8() {
        C13081n.Companion companion = C13081n.INSTANCE;
        String str = this.link;
        AbstractC13042fc3.f(str);
        companion.a(str).K8(Q7().B0(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N8() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1939982954, true, new c()), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4601Fv1 O8(u uVar) {
        AbstractC13042fc3.i(uVar, "this$0");
        FragmentActivity fragmentActivityQ7 = uVar.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C4601Fv1) new androidx.lifecycle.G(fragmentActivityQ7).b(C4601Fv1.class);
    }

    @Override // ir.nasim.AbstractC5830La0
    /* renamed from: F8, reason: merged with bridge method [inline-methods] */
    public C8199Uy2 s8(LayoutInflater inflater, ViewGroup container, boolean attachToParent) {
        AbstractC13042fc3.i(inflater, "inflater");
        C8199Uy2 c8199Uy2C = C8199Uy2.c(inflater, container, attachToParent);
        AbstractC13042fc3.h(c8199Uy2C, "inflate(...)");
        return c8199Uy2C;
    }

    public final InterfaceC4367Ev1 G8() {
        return (InterfaceC4367Ev1) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            if (bundleE5.getParcelable("param_data") == null) {
                Q7().B0().k1();
            }
            Parcelable parcelable = bundleE5.getParcelable("param_data");
            AbstractC13042fc3.f(parcelable);
            this.content = (CrowdfundingContentInfo) parcelable;
            if (bundleE5.getLong("param_unique_id", -1L) == -1) {
                Q7().B0().k1();
            }
            this.peerUniqueId = bundleE5.getLong("param_unique_id");
            this.link = bundleE5.getString("param_link");
        }
    }

    @Override // ir.nasim.AbstractC5830La0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        L8(crowdfundingContentInfo);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        I8();
    }
}
