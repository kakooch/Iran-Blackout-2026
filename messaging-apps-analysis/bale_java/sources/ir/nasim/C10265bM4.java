package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C10265bM4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.O98;
import ir.nasim.YL4;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u0018B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0013\u0010\b\u001a\u00020\u0004*\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lir/nasim/bM4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "V9", "ba", "Lir/nasim/components/appbar/view/BaleToolbar;", "Z9", "(Lir/nasim/components/appbar/view/BaleToolbar;)V", "Y9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "a", "()Z", "Lir/nasim/Sy2;", "h1", "Lir/nasim/bW7;", "W9", "()Lir/nasim/Sy2;", "binding", "Lir/nasim/jM4;", "i1", "Lir/nasim/Yu3;", "X9", "()Lir/nasim/jM4;", "viewModel", "j1", "contact_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.bM4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10265bM4 extends AbstractC18949pX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C10265bM4.class, "binding", "getBinding()Lir/nasim/contact/databinding/FragmentOrganizationContactsBinding;", 0))};

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: ir.nasim.bM4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C10265bM4 a() {
            return new C10265bM4();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bM4$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.bM4$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C10265bM4 a;

            /* renamed from: ir.nasim.bM4$b$a$a, reason: collision with other inner class name */
            static final class C0896a implements InterfaceC15796kB2 {
                final /* synthetic */ C10265bM4 a;

                C0896a(C10265bM4 c10265bM4) {
                    this.a = c10265bM4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C10265bM4 c10265bM4) {
                    AbstractC13042fc3.i(c10265bM4, "this$0");
                    c10265bM4.X9().Z0();
                    c10265bM4.X9().b1("");
                    return C19938rB7.a;
                }

                public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    InterfaceC12529em.a aVar = InterfaceC12529em.a;
                    InterfaceC12529em.c cVarI = aVar.i();
                    e.a aVar2 = androidx.compose.ui.e.a;
                    androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1, i2).y(), null, 2, null), g10.c(interfaceC22053ub1, i2).b().c(), C17784nZ1.q(9));
                    final C10265bM4 c10265bM4 = this.a;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
                    InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar3.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                    androidx.compose.ui.e eVarB = L66.b(M66.a, aVar2, 1.0f, false, 2, null);
                    String strC = UY6.c(ED5.contacts_sorted_by_name, interfaceC22053ub1, 0);
                    long jD = g10.a(interfaceC22053ub1, i2).D();
                    C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1, i2).o();
                    AbstractC9105Ym7.b(strC, eVarB, jD, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7O.b((16744447 & 1) != 0 ? c9348Zn7O.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7O.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7O.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O.b.k() : null), interfaceC22053ub1, 0, 0, 65528);
                    androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i2).b().f());
                    InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.o(), false);
                    int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarT);
                    SA2 sa2A2 = aVar3.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A2);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
                    DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                    InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                    if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                        interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                        interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                    }
                    DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                    androidx.compose.ui.e eVarE3 = androidx.compose.foundation.layout.h.a.e(aVar2);
                    interfaceC22053ub1.W(686046072);
                    boolean zD = interfaceC22053ub1.D(c10265bM4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.eM4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C10265bM4.b.a.C0896a.c(c10265bM4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC24077y03.b(FV4.c(AbstractC15799kB5.ic_refresh, interfaceC22053ub1, 0), null, androidx.compose.foundation.e.f(eVarE3, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).I(), interfaceC22053ub1, 48, 0);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.bM4$b$a$b, reason: collision with other inner class name */
            static final class C0897b implements InterfaceC16978mB2 {
                final /* synthetic */ YL4 a;

                /* renamed from: ir.nasim.bM4$b$a$b$a, reason: collision with other inner class name */
                static final class C0898a implements InterfaceC14603iB2 {
                    final /* synthetic */ WL4 a;

                    C0898a(WL4 wl4) {
                        this.a = wl4;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(this.a.b(), null, false, 0, interfaceC22053ub1, 0, 14), null, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(50)), N46.g()), this.a.a(), this.a.d(), 0.0f, false, null, 28, null), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24624, 104);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C0897b(YL4 yl4) {
                    this.a = yl4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(WL4 wl4) {
                    AbstractC13042fc3.i(wl4, "$it");
                    C18987pb3 c18987pb3 = C18987pb3.a;
                    C11458d25 c11458d25E = C11458d25.E(wl4.a());
                    AbstractC13042fc3.h(c11458d25E, "user(...)");
                    C18987pb3.x1(c18987pb3, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
                    String strC;
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                    if ((i2 & 48) == 0) {
                        i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
                    } else {
                        i3 = i2;
                    }
                    if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    final WL4 wl4 = (WL4) AbstractC15401jX0.t0(((YL4.d) this.a).a(), i);
                    if (wl4 == null) {
                        return;
                    }
                    if (wl4.f()) {
                        interfaceC22053ub1.W(-923213227);
                        strC = UY6.c(AbstractC12217eE5.members_adapter_bot_online_status, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else {
                        interfaceC22053ub1.W(-923054166);
                        strC = (String) AbstractC10222bH6.a(wl4.c(), "", null, interfaceC22053ub1, 48, 2).getValue();
                        interfaceC22053ub1.Q();
                    }
                    String str = strC;
                    e.a aVar = androidx.compose.ui.e.a;
                    interfaceC22053ub1.W(940066137);
                    Object objB = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
                    if (objB == aVar2.a()) {
                        objB = AbstractC23831xb3.a();
                        interfaceC22053ub1.s(objB);
                    }
                    InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
                    interfaceC22053ub1.Q();
                    InterfaceC17521n63 interfaceC17521n63F = androidx.compose.material.a.f(true, 0.0f, 0L, 6, null);
                    interfaceC22053ub1.W(940069312);
                    boolean zV = interfaceC22053ub1.V(wl4);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV || objB2 == aVar2.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.fM4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C10265bM4.b.a.C0897b.c(wl4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC24459yf1.u(androidx.compose.foundation.e.d(aVar, interfaceC18507om4, interfaceC17521n63F, false, null, null, (SA2) objB2, 28, null), wl4.d(), str, AbstractC19242q11.e(1970988351, true, new C0898a(wl4), interfaceC22053ub1, 54), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            a(C10265bM4 c10265bM4) {
                this.a = c10265bM4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(final YL4 yl4, C10265bM4 c10265bM4, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(yl4, "$uiState");
                AbstractC13042fc3.i(c10265bM4, "this$0");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1052310209, true, new C0896a(c10265bM4)), 3, null);
                YL4.d dVar = (YL4.d) yl4;
                if (!dVar.a().isEmpty()) {
                    InterfaceC15069ix3.g(interfaceC15069ix3, dVar.a().size(), new UA2() { // from class: ir.nasim.dM4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C10265bM4.b.a.f(yl4, ((Integer) obj).intValue());
                        }
                    }, null, AbstractC19242q11.c(811350309, true, new C0897b(yl4)), 4, null);
                } else {
                    InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C12147e71.a.a(), 3, null);
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Object f(YL4 yl4, int i) {
                AbstractC13042fc3.i(yl4, "$uiState");
                WL4 wl4 = (WL4) AbstractC15401jX0.t0(((YL4.d) yl4).a(), i);
                return Integer.valueOf(wl4 != null ? wl4.a() : AbstractC17026mG5.a.f());
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
                final C10265bM4 c10265bM4 = this.a;
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
                InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                final YL4 yl4 = (YL4) AbstractC10222bH6.b(c10265bM4.X9().Y0(), null, interfaceC22053ub1, 0, 1).getValue();
                if (yl4 instanceof YL4.d) {
                    interfaceC22053ub1.W(316593458);
                    interfaceC22053ub1.W(-128333515);
                    boolean zD = interfaceC22053ub1.D(c10265bM4) | interfaceC22053ub1.V(yl4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.cM4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C10265bM4.b.a.d(yl4, c10265bM4, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 511);
                    interfaceC22053ub1.Q();
                } else if (yl4 instanceof YL4.a) {
                    interfaceC22053ub1.W(321982808);
                    String strC = UY6.c(AbstractC12217eE5.auth_error_unknown, interfaceC22053ub1, 0);
                    androidx.compose.ui.e eVarH = hVar.h(aVar, aVar2.e());
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    AbstractC9105Ym7.b(strC, androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1, i2).b().c()), g10.a(interfaceC22053ub1, i2).t(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).a(), interfaceC22053ub1, 0, 0, 65528);
                    interfaceC22053ub1.Q();
                } else if (AbstractC13042fc3.d(yl4, YL4.b.a)) {
                    interfaceC22053ub1.W(322520906);
                    interfaceC22053ub1.Q();
                } else {
                    if (!AbstractC13042fc3.d(yl4, YL4.c.a)) {
                        interfaceC22053ub1.W(-128337576);
                        interfaceC22053ub1.Q();
                        throw new NoWhenBranchMatchedException();
                    }
                    interfaceC22053ub1.W(322588858);
                    AbstractC10628bv5.a(hVar.h(aVar, aVar2.e()), G10.a.a(interfaceC22053ub1, G10.b).I(), 0.0f, 0L, 0, interfaceC22053ub1, 0, 28);
                    interfaceC22053ub1.Q();
                }
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C10265bM4.this.X9().Z0();
            C10265bM4.this.X9().V0();
            M10.f(false, AbstractC19242q11.e(-1822144786, true, new a(C10265bM4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bM4$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.bM4$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C10265bM4 a;
            final /* synthetic */ String b;

            /* renamed from: ir.nasim.bM4$c$a$a, reason: collision with other inner class name */
            static final class C0899a implements InterfaceC14603iB2 {
                final /* synthetic */ C10265bM4 a;
                final /* synthetic */ String b;

                /* renamed from: ir.nasim.bM4$c$a$a$a, reason: collision with other inner class name */
                static final class C0900a implements InterfaceC14603iB2 {
                    final /* synthetic */ C10265bM4 a;
                    final /* synthetic */ String b;

                    /* renamed from: ir.nasim.bM4$c$a$a$a$a, reason: collision with other inner class name */
                    static final class C0901a implements InterfaceC14603iB2 {
                        final /* synthetic */ C10265bM4 a;
                        final /* synthetic */ String b;

                        /* renamed from: ir.nasim.bM4$c$a$a$a$a$a, reason: collision with other inner class name */
                        /* synthetic */ class C0902a extends EB2 implements UA2 {
                            C0902a(Object obj) {
                                super(1, obj, C15306jM4.class, "setQuery", "setQuery(Ljava/lang/String;)V", 0);
                            }

                            @Override // ir.nasim.UA2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                y((String) obj);
                                return C19938rB7.a;
                            }

                            public final void y(String str) {
                                AbstractC13042fc3.i(str, "p0");
                                ((C15306jM4) this.receiver).b1(str);
                            }
                        }

                        C0901a(C10265bM4 c10265bM4, String str) {
                            this.a = c10265bM4;
                            this.b = str;
                        }

                        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                                interfaceC22053ub1.L();
                                return;
                            }
                            String strC = UY6.c(AbstractC12217eE5.search_hint_chat, interfaceC22053ub1, 0);
                            C15306jM4 c15306jM4X9 = this.a.X9();
                            interfaceC22053ub1.W(-1661410116);
                            boolean zD = interfaceC22053ub1.D(c15306jM4X9);
                            Object objB = interfaceC22053ub1.B();
                            if (zD || objB == InterfaceC22053ub1.a.a()) {
                                objB = new C0902a(c15306jM4X9);
                                interfaceC22053ub1.s(objB);
                            }
                            interfaceC22053ub1.Q();
                            AbstractC16075kf6.j(strC, this.b, (UA2) ((InterfaceC16733lm3) objB), true, null, null, true, null, null, null, null, interfaceC22053ub1, 1575936, 0, 1968);
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                            return C19938rB7.a;
                        }
                    }

                    C0900a(C10265bM4 c10265bM4, String str) {
                        this.a = c10265bM4;
                        this.b = str;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().u(), 0.0f, 2, null);
                        InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                        C10265bM4 c10265bM4 = this.a;
                        String str = this.b;
                        InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
                        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
                        InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                        SA2 sa2A = aVar.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                        InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                            interfaceC22053ub1A.s(Integer.valueOf(iA));
                            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                        }
                        DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                        androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                        AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1843624663, true, new C0901a(c10265bM4, str), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                        interfaceC22053ub1.u();
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.bM4$c$a$a$b */
                static final class b implements InterfaceC14603iB2 {
                    final /* synthetic */ C10265bM4 a;

                    b(C10265bM4 c10265bM4) {
                        this.a = c10265bM4;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C10265bM4 c10265bM4) {
                        AbstractC13042fc3.i(c10265bM4, "this$0");
                        c10265bM4.a();
                        return C19938rB7.a;
                    }

                    public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        e.a aVar = androidx.compose.ui.e.a;
                        androidx.compose.ui.e eVarD = androidx.compose.foundation.layout.t.d(aVar, 0.0f, 1, null);
                        G10 g10 = G10.a;
                        int i2 = G10.b;
                        androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(eVarD, g10.c(interfaceC22053ub1, i2).b().c(), 0.0f, 0.0f, 0.0f, 14, null);
                        InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                        final C10265bM4 c10265bM4 = this.a;
                        InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
                        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
                        InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                        SA2 sa2A = aVar2.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
                        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                        InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                            interfaceC22053ub1A.s(Integer.valueOf(iA));
                            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                        }
                        DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                        androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                        androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j());
                        interfaceC22053ub1.W(-1657387395);
                        boolean zD = interfaceC22053ub1.D(c10265bM4);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.gM4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C10265bM4.c.a.C0899a.b.c(c10265bM4);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC24077y03.b(C02.e(new SV(false), interfaceC22053ub1, 0), UY6.c(AbstractC12217eE5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).G(), interfaceC22053ub1, 0, 0);
                        interfaceC22053ub1.u();
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C0899a(C10265bM4 c10265bM4, String str) {
                    this.a = c10265bM4;
                    this.b = str;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    A98 a98A = AbstractC21393ta8.a(0, 0, 0, 0);
                    androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.t.b(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(56), 1, null);
                    C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                    ED.a(AbstractC19242q11.e(-752527727, true, new C0900a(this.a, this.b), interfaceC22053ub1, 54), eVarB, AbstractC19242q11.e(2123578003, true, new b(this.a), interfaceC22053ub1, 54), null, 0.0f, a98A, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).q(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 438, 152);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C10265bM4 c10265bM4, String str) {
                this.a = c10265bM4;
                this.b = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(629949484, true, new C0899a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-882225300, true, new a(C10265bM4.this, (String) AbstractC10222bH6.b(C10265bM4.this.X9().X0(), null, interfaceC22053ub1, 0, 1).getValue()), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bM4$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C7726Sy2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.bM4$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.bM4$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.bM4$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.bM4$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.bM4$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C10265bM4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C15306jM4.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
    }

    private final void V9() {
        W9().d.setContent(AbstractC19242q11.c(-594670157, true, new b()));
    }

    private final C7726Sy2 W9() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C7726Sy2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15306jM4 X9() {
        return (C15306jM4) this.viewModel.getValue();
    }

    private final void Y9() {
        AbstractC19329q98.a(Q7().getWindow(), W9().d).a(O98.m.d());
    }

    private final void Z9(BaleToolbar baleToolbar) {
        W9().c.setVisibility(8);
        baleToolbar.y(AbstractC13435gD5.context_menu_selection_list);
        ComposeView composeView = W9().c;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1491564943, true, new c()));
        composeView.h();
        baleToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.aM4
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return C10265bM4.aa(this.a, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean aa(C10265bM4 c10265bM4, MenuItem menuItem) {
        AbstractC13042fc3.i(c10265bM4, "this$0");
        if (menuItem.getItemId() != AbstractC10176bC5.search_contacts) {
            return false;
        }
        c10265bM4.W9().c.setVisibility(0);
        c10265bM4.W9().c.g();
        c10265bM4.W9().e.setVisibility(8);
        return true;
    }

    private final void ba() {
        final BaleToolbar baleToolbar = W9().e;
        String strW0 = X9().W0();
        if (strW0 != null) {
            baleToolbar.setTitle(i6(AbstractC12217eE5.organization_title, strW0));
        } else {
            new SA2() { // from class: ir.nasim.ZL4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C10265bM4.ca(baleToolbar, this);
                }
            };
        }
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        AbstractC13042fc3.f(baleToolbar);
        Z9(baleToolbar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(BaleToolbar baleToolbar, C10265bM4 c10265bM4) {
        AbstractC13042fc3.i(baleToolbar, "$this_with");
        AbstractC13042fc3.i(c10265bM4, "this$0");
        baleToolbar.setTitle(c10265bM4.h6(AbstractC12217eE5.organization_title_desc));
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C7726Sy2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        if (W9().c.getVisibility() != 0) {
            return super.a();
        }
        W9().c.setVisibility(8);
        W9().e.setVisibility(0);
        W9().c.h();
        X9().b1("");
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Y9();
        ba();
        V9();
    }
}
