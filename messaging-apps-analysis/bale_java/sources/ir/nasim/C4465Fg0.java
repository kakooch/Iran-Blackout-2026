package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC5416Jg0;
import ir.nasim.C24254yJ;
import ir.nasim.C4465Fg0;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001-B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\u0004*\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010*¨\u00062²\u0006\u000e\u0010/\u001a\u00020.8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u00101\u001a\u0002008\n@\nX\u008a\u008e\u0002"}, d2 = {"Lir/nasim/Fg0;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "xa", "sa", "ra", "Lir/nasim/Pg0;", "it", "ba", "(Lir/nasim/Pg0;Lir/nasim/ub1;I)V", "Lir/nasim/ix3;", "ta", "(Lir/nasim/ix3;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/Mg0;", "h1", "Lir/nasim/Yu3;", "wa", "()Lir/nasim/Mg0;", "viewModel", "Lir/nasim/zx2;", "i1", "Lir/nasim/bW7;", "va", "()Lir/nasim/zx2;", "binding", "Lir/nasim/n10;", "j1", "ua", "()Lir/nasim/n10;", "baleSnackBar", "k1", "a", "", "strokeWidth", "", "menuExpanded", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Fg0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4465Fg0 extends SV2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 baleSnackBar;
    static final /* synthetic */ InterfaceC5239Im3[] l1 = {AbstractC10882cM5.i(new C25226zw5(C4465Fg0.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentBlackListBinding;", 0))};

    /* renamed from: k1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m1 = 8;

    /* renamed from: ir.nasim.Fg0$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C4465Fg0 a(int i, ZN2 zn2) {
            AbstractC13042fc3.i(zn2, "type");
            C4465Fg0 c4465Fg0 = new C4465Fg0();
            c4465Fg0.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("groupTypeKey", zn2), AbstractC4616Fw7.a("GROUP_ID_ARGS", Integer.valueOf(i))));
            return c4465Fg0;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Fg0$b */
    static final class b implements InterfaceC15796kB2 {
        b() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarB = InterfaceC6988Pv3.b(interfaceC6988Pv3, aVar, 0.0f, 1, null);
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            C24254yJ.f fVarB = C24254yJ.a.b();
            C4465Fg0 c4465Fg0 = C4465Fg0.this;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(43));
            EV4 ev4C = FV4.c(AbstractC22412vB5.block, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC24077y03.b(ev4C, null, eVarT, g10.a(interfaceC22053ub1, i3).x(), interfaceC22053ub1, 432, 0);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1, i3).b().u()), interfaceC22053ub1, 0);
            String strC = UY6.c(c4465Fg0.wa().Y0() == ZN2.GROUP ? RD5.black_list_empty : RD5.black_list_empty_channel, interfaceC22053ub1, 0);
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1, i3).a();
            AbstractC9105Ym7.b(strC, null, g10.a(interfaceC22053ub1, i3).x(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : C6399Nk7.b.a(), (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1, 0, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER)), interfaceC22053ub1, 6);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Fg0$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Fg0$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C4465Fg0 a;

            /* renamed from: ir.nasim.Fg0$c$a$a, reason: collision with other inner class name */
            static final class C0373a implements InterfaceC15796kB2 {
                final /* synthetic */ C4465Fg0 a;

                C0373a(C4465Fg0 c4465Fg0) {
                    this.a = c4465Fg0;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    String strC = UY6.c(this.a.wa().Y0() == ZN2.GROUP ? RD5.black_list_desc : RD5.black_list_desc_channel, interfaceC22053ub1, 0);
                    e.a aVar = androidx.compose.ui.e.a;
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1, i2).y(), null, 2, null), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().u());
                    long jB = g10.a(interfaceC22053ub1, i2).B();
                    C9348Zn7 c9348Zn7C = g10.d(interfaceC22053ub1, i2).c();
                    AbstractC9105Ym7.b(strC, eVarJ, jB, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null), interfaceC22053ub1, 0, 0, 65528);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Fg0$c$a$b */
            public static final class b extends AbstractC8614Ws3 implements UA2 {
                public static final b e = new b();

                public b() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.Fg0$c$a$c, reason: collision with other inner class name */
            public static final class C0374c extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0374c(UA2 ua2, List list) {
                    super(1);
                    this.e = ua2;
                    this.f = list;
                }

                public final Object a(int i) {
                    return this.e.invoke(this.f.get(i));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.Fg0$c$a$d */
            public static final class d extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public d(UA2 ua2, List list) {
                    super(1);
                    this.e = ua2;
                    this.f = list;
                }

                public final Object a(int i) {
                    return this.e.invoke(this.f.get(i));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.Fg0$c$a$e */
            public static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;
                final /* synthetic */ C4465Fg0 f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public e(List list, C4465Fg0 c4465Fg0) {
                    super(4);
                    this.e = list;
                    this.f = c4465Fg0;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
                    if ((i2 & 6) == 0) {
                        i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    C6850Pg0 c6850Pg0 = (C6850Pg0) this.e.get(i);
                    interfaceC22053ub1.W(267905940);
                    this.f.ba(c6850Pg0, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.P();
                    }
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            a(C4465Fg0 c4465Fg0) {
                this.a = c4465Fg0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(AbstractC5416Jg0 abstractC5416Jg0, C4465Fg0 c4465Fg0, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(abstractC5416Jg0, "$user");
                AbstractC13042fc3.i(c4465Fg0, "this$0");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-423111047, true, new C0373a(c4465Fg0)), 3, null);
                AbstractC5416Jg0.d dVar = (AbstractC5416Jg0.d) abstractC5416Jg0;
                if (dVar.b().isEmpty()) {
                    c4465Fg0.ta(interfaceC15069ix3);
                } else {
                    List listB = dVar.b();
                    interfaceC15069ix3.a(listB.size(), new C0374c(new UA2() { // from class: ir.nasim.Hg0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C4465Fg0.c.a.f((C6850Pg0) obj);
                        }
                    }, listB), new d(b.e, listB), AbstractC19242q11.c(-632812321, true, new e(listB, c4465Fg0)));
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Object f(C6850Pg0 c6850Pg0) {
                AbstractC13042fc3.i(c6850Pg0, "it");
                return c6850Pg0.d() + " + " + c6850Pg0.b();
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final AbstractC5416Jg0 abstractC5416Jg0 = (AbstractC5416Jg0) AbstractC10222bH6.b(this.a.wa().W0(), null, interfaceC22053ub1, 0, 1).getValue();
                if (abstractC5416Jg0 instanceof AbstractC5416Jg0.a) {
                    interfaceC22053ub1.W(-1499350098);
                    e.a aVar = androidx.compose.ui.e.a;
                    androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
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
                    String strC = UY6.c(AbstractC12217eE5.auth_error_unknown, interfaceC22053ub1, 0);
                    androidx.compose.ui.e eVarH = hVar.h(aVar, aVar2.e());
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    AbstractC9105Ym7.b(strC, androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1, i2).b().c()), g10.a(interfaceC22053ub1, i2).t(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).a(), interfaceC22053ub1, 0, 0, 65528);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    return;
                }
                if (!AbstractC13042fc3.d(abstractC5416Jg0, AbstractC5416Jg0.c.a)) {
                    if (!(abstractC5416Jg0 instanceof AbstractC5416Jg0.d)) {
                        if (AbstractC13042fc3.d(abstractC5416Jg0, AbstractC5416Jg0.b.a)) {
                            interfaceC22053ub1.W(-1496679045);
                            interfaceC22053ub1.Q();
                            return;
                        } else {
                            interfaceC22053ub1.W(228727758);
                            interfaceC22053ub1.Q();
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    interfaceC22053ub1.W(-1498259394);
                    androidx.compose.ui.e eVarF2 = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
                    interfaceC22053ub1.W(228767631);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(abstractC5416Jg0);
                    final C4465Fg0 c4465Fg0 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.Gg0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C4465Fg0.c.a.d(abstractC5416Jg0, c4465Fg0, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC12623ev3.b(eVarF2, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 6, 510);
                    interfaceC22053ub1.Q();
                    return;
                }
                interfaceC22053ub1.W(-1498693952);
                e.a aVar4 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarF3 = androidx.compose.foundation.layout.t.f(aVar4, 0.0f, 1, null);
                InterfaceC12529em.a aVar5 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar5.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF3);
                InterfaceC16030kb1.a aVar6 = InterfaceC16030kb1.d0;
                SA2 sa2A2 = aVar6.a();
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar6.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar6.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar6.f());
                AbstractC10628bv5.a(androidx.compose.foundation.layout.h.a.h(aVar4, aVar5.e()), G10.a.a(interfaceC22053ub1, G10.b).I(), 0.0f, 0L, 0, interfaceC22053ub1, 0, 28);
                interfaceC22053ub1.u();
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1046647068, true, new a(C4465Fg0.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Fg0$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C25232zx2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Fg0$e */
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

    /* renamed from: ir.nasim.Fg0$f */
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

    /* renamed from: ir.nasim.Fg0$g */
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

    /* renamed from: ir.nasim.Fg0$h */
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

    /* renamed from: ir.nasim.Fg0$i */
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

    public C4465Fg0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6117Mg0.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());
        this.baleSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wg0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4465Fg0.qa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(C6850Pg0 c6850Pg0, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        final InterfaceC9102Ym4 interfaceC9102Ym4;
        final C6850Pg0 c6850Pg02 = c6850Pg0;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(806277850);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(c6850Pg02) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            G10 g10 = G10.a;
            int i4 = G10.b;
            final long jA = g10.a(interfaceC22053ub1J, i4).A();
            interfaceC22053ub1J.W(1157836038);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC4326Eq5.a(0.0f);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC14354hm4 interfaceC14354hm4 = (InterfaceC14354hm4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1157838736);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar2, g10.a(interfaceC22053ub1J, i4).r(), null, 2, null);
            interfaceC22053ub1J.W(1157845525);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB3);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB3;
            interfaceC22053ub1J.Q();
            InterfaceC17521n63 interfaceC17521n63F = androidx.compose.material.a.f(false, 0.0f, g10.a(interfaceC22053ub1J, i4).F(), 3, null);
            interfaceC22053ub1J.W(1157851488);
            int i5 = i3 & 14;
            boolean z = i5 == 4;
            Object objB4 = interfaceC22053ub1J.B();
            if (z || objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.xg0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C4465Fg0.ca(c6850Pg02);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.e.d(eVarD, interfaceC18507om4, interfaceC17521n63F, false, null, null, (SA2) objB4, 28, null);
            interfaceC22053ub1J.W(1157854702);
            boolean zF = interfaceC22053ub1J.f(jA);
            Object objB5 = interfaceC22053ub1J.B();
            if (zF || objB5 == aVar.a()) {
                objB5 = new UA2() { // from class: ir.nasim.yg0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C4465Fg0.da(jA, interfaceC14354hm4, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.ui.draw.b.b(eVarD2, (UA2) objB5), g10.c(interfaceC22053ub1J, i4).b().c());
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar3.i();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            M66 m66 = M66.a;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(c6850Pg0.a(), C02.e(new WU(c6850Pg0.e(), c6850Pg0.d(), 18.0f, (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g()), false, true), interfaceC22053ub1J, WU.i), false, 0, interfaceC22053ub1J, 0, 12);
            InterfaceC13157fl1 interfaceC13157fl1A = InterfaceC13157fl1.a.a();
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(50.0f)), N46.g());
            interfaceC22053ub1J.W(-1409165429);
            Object objB6 = interfaceC22053ub1J.B();
            if (objB6 == aVar.a()) {
                objB6 = new UA2() { // from class: ir.nasim.zg0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C4465Fg0.ea(interfaceC14354hm4, (InterfaceC11379cu3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.Q();
            AbstractC11456d23.b(ev4H, null, androidx.compose.ui.layout.c.a(eVarA, (UA2) objB6), null, interfaceC13157fl1A, 0.0f, null, interfaceC22053ub1J, 24624, 104);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1J, i4).b().c()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarB = L66.b(m66, aVar2, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.b(), aVar3.k(), interfaceC22053ub1J, 6);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
            SA2 sa2A2 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strE = c6850Pg0.e();
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1J, i4).l();
            C6399Nk7.a aVar5 = C6399Nk7.b;
            AbstractC9105Ym7.b(strE, null, g10.a(interfaceC22053ub1J, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L.b((16744447 & 1) != 0 ? c9348Zn7L.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7L.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L.b.h() : aVar5.f(), (16744447 & 65536) != 0 ? c9348Zn7L.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, g10.c(interfaceC22053ub1J, i4).b().n()), interfaceC22053ub1J, 0);
            int i6 = RD5.deleted_by_in_black_list;
            interfaceC22053ub1J.W(2100398401);
            String strC = c6850Pg0.b() == AbstractC5969Lp4.f() ? UY6.c(RD5.deleted_by_in_black_list_by_you, interfaceC22053ub1J, 0) : c6850Pg0.c();
            interfaceC22053ub1J.Q();
            String strD = UY6.d(i6, new Object[]{strC}, interfaceC22053ub1J, 0);
            C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1J, i4).o();
            AbstractC9105Ym7.b(strD, null, g10.a(interfaceC22053ub1J, i4).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7O.b((16744447 & 1) != 0 ? c9348Zn7O.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O.b.h() : aVar5.f(), (16744447 & 65536) != 0 ? c9348Zn7O.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7O.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1J, i4).b().e()), interfaceC22053ub1J, 0);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar2);
            SA2 sa2A3 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A3);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar4.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1J.W(2100417491);
            Object objB7 = interfaceC22053ub1J.B();
            if (objB7 == aVar.a()) {
                objB7 = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB7);
            }
            InterfaceC18507om4 interfaceC18507om42 = (InterfaceC18507om4) objB7;
            interfaceC22053ub1J.Q();
            InterfaceC17521n63 interfaceC17521n63F2 = androidx.compose.material.a.f(false, 0.0f, g10.a(interfaceC22053ub1J, i4).F(), 3, null);
            interfaceC22053ub1J.W(2100423989);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB8 = interfaceC22053ub1J.B();
            if (zD || objB8 == aVar.a()) {
                interfaceC9102Ym4 = interfaceC9102Ym42;
                objB8 = new SA2() { // from class: ir.nasim.Ag0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C4465Fg0.fa(this.a, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB8);
            } else {
                interfaceC9102Ym4 = interfaceC9102Ym42;
            }
            interfaceC22053ub1J.Q();
            AbstractC24077y03.b(FV4.c(AbstractC22412vB5.more_menu, interfaceC22053ub1J, 0), null, androidx.compose.foundation.e.d(aVar2, interfaceC18507om42, interfaceC17521n63F2, false, null, null, (SA2) objB8, 28, null), g10.a(interfaceC22053ub1J, i4).B(), interfaceC22053ub1J, 48, 0);
            float fQ = C17784nZ1.q(-12);
            long jB = C19557qZ1.b((Float.floatToRawIntBits(C17784nZ1.q(0)) & 4294967295L) | (Float.floatToRawIntBits(fQ) << 32));
            String strC2 = UY6.c(RD5.delete_from_list, interfaceC22053ub1J, 0);
            int i7 = AbstractC22412vB5.block;
            interfaceC22053ub1J.W(2100443634);
            boolean zD2 = interfaceC22053ub1J.D(this) | (i5 == 4);
            Object objB9 = interfaceC22053ub1J.B();
            if (zD2 || objB9 == aVar.a()) {
                c6850Pg02 = c6850Pg0;
                objB9 = new SA2() { // from class: ir.nasim.Bg0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C4465Fg0.ga(this.a, c6850Pg02);
                    }
                };
                interfaceC22053ub1J.s(objB9);
            } else {
                c6850Pg02 = c6850Pg0;
            }
            interfaceC22053ub1J.Q();
            List listE = AbstractC9766aX0.e(new C7847Tl1(strC2, i7, 0, (SA2) objB9, 4, null));
            boolean zMa = ma(interfaceC9102Ym4);
            interfaceC22053ub1J.W(2100459767);
            boolean zD3 = interfaceC22053ub1J.D(this);
            Object objB10 = interfaceC22053ub1J.B();
            if (zD3 || objB10 == aVar.a()) {
                objB10 = new SA2() { // from class: ir.nasim.Cg0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C4465Fg0.ia(this.a, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB10);
            }
            interfaceC22053ub1J.Q();
            AbstractC9090Yl1.b(jB, listE, zMa, (SA2) objB10, 0L, 0L, 0L, interfaceC22053ub1J, (C7847Tl1.e << 3) | 6, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Dg0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C4465Fg0.ja(this.a, c6850Pg02, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(C6850Pg0 c6850Pg0) {
        AbstractC13042fc3.i(c6850Pg0, "$it");
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25E = C11458d25.E(c6850Pg0.d());
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        C18987pb3.x1(c18987pb3, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 da(long j, InterfaceC14354hm4 interfaceC14354hm4, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC14354hm4, "$strokeWidth$delegate");
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        long jE = ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L));
        float fKa = ka(interfaceC14354hm4);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        InterfaceC17460n02.V0(interfaceC17460n02, j, jE, ZG4.e((Float.floatToRawIntBits(fKa) << 32) | (4294967295L & Float.floatToRawIntBits(fIntBitsToFloat2))), interfaceC17460n02.w1(C17784nZ1.q(1)), 0, null, 0.0f, null, 0, 496, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ea(InterfaceC14354hm4 interfaceC14354hm4, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC14354hm4, "$strokeWidth$delegate");
        AbstractC13042fc3.i(interfaceC11379cu3, "it");
        la(interfaceC14354hm4, Float.intBitsToFloat((int) (AbstractC12000du3.a(interfaceC11379cu3).f() >> 32)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 fa(C4465Fg0 c4465Fg0, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(c4465Fg0, "this$0");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$menuExpanded$delegate");
        c4465Fg0.sa();
        na(interfaceC9102Ym4, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ga(final C4465Fg0 c4465Fg0, final C6850Pg0 c6850Pg0) {
        AbstractC13042fc3.i(c4465Fg0, "this$0");
        AbstractC13042fc3.i(c6850Pg0, "$it");
        c4465Fg0.wa().c1(c6850Pg0.d(), new SA2() { // from class: ir.nasim.Eg0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4465Fg0.ha(this.a, c6850Pg0);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ha(C4465Fg0 c4465Fg0, C6850Pg0 c6850Pg0) {
        AbstractC13042fc3.i(c4465Fg0, "this$0");
        AbstractC13042fc3.i(c6850Pg0, "$it");
        C17468n10 c17468n10Ua = c4465Fg0.ua();
        String string = c4465Fg0.S7().getString(RD5.snack_bar_block_list, c6850Pg0.e());
        AbstractC13042fc3.h(string, "getString(...)");
        c17468n10Ua.o(string);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ia(C4465Fg0 c4465Fg0, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(c4465Fg0, "this$0");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$menuExpanded$delegate");
        c4465Fg0.ra();
        na(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(C4465Fg0 c4465Fg0, C6850Pg0 c6850Pg0, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c4465Fg0, "$tmp5_rcvr");
        AbstractC13042fc3.i(c6850Pg0, "$it");
        c4465Fg0.ba(c6850Pg0, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private static final float ka(InterfaceC14354hm4 interfaceC14354hm4) {
        return interfaceC14354hm4.a();
    }

    private static final void la(InterfaceC14354hm4 interfaceC14354hm4, float f2) {
        interfaceC14354hm4.s(f2);
    }

    private static final boolean ma(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void na(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 qa(C4465Fg0 c4465Fg0) {
        AbstractC13042fc3.i(c4465Fg0, "this$0");
        ConstraintLayout constraintLayoutB = c4465Fg0.va().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(constraintLayoutB, null, 0, 6, null);
        c17468n10.k(c4465Fg0.va().e);
        return c17468n10;
    }

    private final void ra() {
        Window window = Q7().getWindow();
        AbstractC13042fc3.h(window, "getWindow(...)");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AbstractC3742Cd6.e(window, contextS7);
        View view = va().d;
        AbstractC13042fc3.h(view, "dimView");
        view.setVisibility(8);
    }

    private final void sa() {
        Window window = Q7().getWindow();
        AbstractC13042fc3.h(window, "getWindow(...)");
        AbstractC3742Cd6.b(window, 0, 1, null);
        View view = va().d;
        AbstractC13042fc3.h(view, "dimView");
        view.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(InterfaceC15069ix3 interfaceC15069ix3) {
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1430153785, true, new b()), 3, null);
    }

    private final C17468n10 ua() {
        return (C17468n10) this.baleSnackBar.getValue();
    }

    private final C25232zx2 va() {
        Object objA = this.binding.a(this, l1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C25232zx2) objA;
    }

    private final void xa() {
        BaleToolbar baleToolbar = va().f;
        baleToolbar.setTitle(S7().getString(AbstractC12217eE5.black_list_title));
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout constraintLayoutB = C25232zx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        wa().b1();
        xa();
        ra();
        va().c.setContent(AbstractC19242q11.c(709850409, true, new c()));
    }

    public final C6117Mg0 wa() {
        return (C6117Mg0) this.viewModel.getValue();
    }
}
