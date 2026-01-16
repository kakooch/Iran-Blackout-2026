package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C24254yJ;
import ir.nasim.F7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.K7;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001b\u0010\t\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00068²\u0006\f\u00107\u001a\u0002068\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/F7;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "la", "Lir/nasim/ix3;", "Lir/nasim/K7$d;", "state", "ga", "(Lir/nasim/ix3;Lir/nasim/K7$d;)V", "ka", "", "title", "W9", "(Ljava/lang/String;Lir/nasim/ub1;I)V", "Lir/nasim/BM2;", "group", "Y9", "(Lir/nasim/BM2;Lir/nasim/ub1;I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/dQ0;", "h1", "Lir/nasim/dQ0;", "ia", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/N7;", "i1", "Lir/nasim/Yu3;", "ja", "()Lir/nasim/N7;", "viewModel", "Lir/nasim/ix2;", "j1", "Lir/nasim/bW7;", "ha", "()Lir/nasim/ix2;", "binding", "k1", "a", "Lir/nasim/K7;", "myGroupsState", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class F7 extends HV2 {

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;
    static final /* synthetic */ InterfaceC5239Im3[] l1 = {AbstractC10882cM5.i(new C25226zw5(F7.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentAddBotToGroupBinding;", 0))};

    /* renamed from: k1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m1 = 8;

    /* renamed from: ir.nasim.F7$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final F7 a(int i, String str) {
            AbstractC13042fc3.i(str, "botName");
            F7 f7 = new F7();
            Bundle bundle = new Bundle();
            bundle.putInt("botIdArg", i);
            bundle.putString("botNameArg", str);
            f7.a8(bundle);
            return f7;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ZN2.values().length];
            try {
                iArr[ZN2.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZN2.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

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

    public static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ F7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(List list, F7 f7) {
            super(4);
            this.e = list;
            this.f = f7;
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
            BM2 bm2 = (BM2) this.e.get(i);
            interfaceC22053ub1.W(672887125);
            this.f.Y9(bm2, interfaceC22053ub1, 0);
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

    static final class f implements InterfaceC15796kB2 {
        f() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                F7.this.W9(UY6.c(AbstractC12217eE5.my_channel_title, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    public static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(UA2 ua2, List list) {
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

    public static final class i extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ F7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(List list, F7 f7) {
            super(4);
            this.e = list;
            this.f = f7;
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
            BM2 bm2 = (BM2) this.e.get(i);
            interfaceC22053ub1.W(2017371852);
            this.f.Y9(bm2, interfaceC22053ub1, 0);
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

    static final class j implements InterfaceC15796kB2 {
        j() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                F7.this.W9(UY6.c(AbstractC12217eE5.my_groups_title, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class k implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ F7 a;

            /* renamed from: ir.nasim.F7$k$a$a, reason: collision with other inner class name */
            static final class C0356a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ K7 c;
                final /* synthetic */ C19391qG6 d;
                final /* synthetic */ F7 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0356a(K7 k7, C19391qG6 c19391qG6, F7 f7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = k7;
                    this.d = c19391qG6;
                    this.e = f7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0356a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        if (((K7.d) this.c).e() == null) {
                            return C19938rB7.a;
                        }
                        C19391qG6 c19391qG6 = this.d;
                        this.b = 1;
                        if (C19391qG6.f(c19391qG6, "", null, false, null, this, 14, null) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    this.e.ja().e1();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0356a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ K7 a;

                b(K7 k7) {
                    this.a = k7;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(InterfaceC15254jG6 interfaceC15254jG6, boolean z) {
                    AbstractC13042fc3.i(interfaceC15254jG6, "$snackBar");
                    interfaceC15254jG6.dismiss();
                    return C19938rB7.a;
                }

                public final void b(final InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
                    if ((i & 6) == 0) {
                        i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
                    }
                    if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    Integer numE = ((K7.d) this.a).e();
                    if (numE == null) {
                        return;
                    }
                    String strC = UY6.c(numE.intValue(), interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(949153593);
                    boolean z = (i & 14) == 4;
                    Object objB = interfaceC22053ub1.B();
                    if (z || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.H7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return F7.k.a.b.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10984cY.c(strC, null, null, 0, (UA2) objB, interfaceC22053ub1, 0, 14);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(F7 f7) {
                this.a = f7;
            }

            private static final K7 c(InterfaceC9664aL6 interfaceC9664aL6) {
                return (K7) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(F7 f7, K7 k7, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(f7, "this$0");
                AbstractC13042fc3.i(k7, "$state");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                K7.d dVar = (K7.d) k7;
                f7.ka(interfaceC15069ix3, dVar);
                f7.ga(interfaceC15069ix3, dVar);
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1, i2).r(), null, 2, null);
                final F7 f7 = this.a;
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
                final K7 k7C = c(AbstractC10222bH6.b(f7.ja().b1(), null, interfaceC22053ub1, 0, 1));
                if (k7C instanceof K7.d) {
                    interfaceC22053ub1.W(181148848);
                    interfaceC22053ub1.W(-1241082395);
                    Object objB = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
                    if (objB == aVar4.a()) {
                        objB = new C19391qG6();
                        interfaceC22053ub1.s(objB);
                    }
                    C19391qG6 c19391qG6 = (C19391qG6) objB;
                    interfaceC22053ub1.Q();
                    K7.d dVar = (K7.d) k7C;
                    Integer numE = dVar.e();
                    interfaceC22053ub1.W(-1241079007);
                    boolean zV = interfaceC22053ub1.V(k7C) | interfaceC22053ub1.D(f7);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV || objB2 == aVar4.a()) {
                        objB2 = new C0356a(k7C, c19391qG6, f7, null);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(numE, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
                    AbstractC18209oG6.b(c19391qG6, Ac8.a(hVar.h(aVar, aVar2.b()), 2.0f), AbstractC19242q11.e(1835598863, true, new b(k7C), interfaceC22053ub1, 54), interfaceC22053ub1, 390, 0);
                    interfaceC22053ub1.W(-1241045969);
                    if (dVar.d()) {
                        CG3.g(null, null, null, interfaceC22053ub1, 0, 7);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarF2 = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
                    InterfaceC12529em.b bVarK = aVar2.k();
                    C24254yJ.m mVarH = C24254yJ.a.h();
                    interfaceC22053ub1.W(-1241035539);
                    boolean zD = interfaceC22053ub1.D(f7) | interfaceC22053ub1.V(k7C);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD || objB3 == aVar4.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.G7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return F7.k.a.d(f7, k7C, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC12623ev3.b(eVarF2, null, null, false, mVarH, bVarK, null, false, null, (UA2) objB3, interfaceC22053ub1, 221190, 462);
                    interfaceC22053ub1.Q();
                } else if (k7C instanceof K7.a) {
                    interfaceC22053ub1.W(182835310);
                    AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.auth_error_unknown, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(hVar.h(aVar, aVar2.e()), g10.c(interfaceC22053ub1, i2).b().c()), g10.a(interfaceC22053ub1, i2).t(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).a(), interfaceC22053ub1, 0, 0, 65528);
                    interfaceC22053ub1.Q();
                } else if (AbstractC13042fc3.d(k7C, K7.c.a)) {
                    interfaceC22053ub1.W(-1241009753);
                    AbstractC10628bv5.a(hVar.h(aVar, aVar2.e()), g10.a(interfaceC22053ub1, i2).I(), 0.0f, 0L, 0, interfaceC22053ub1, 0, 28);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(183623547);
                    interfaceC22053ub1.Q();
                }
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        k() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1437187716, true, new a(F7.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class l extends AbstractC8614Ws3 implements UA2 {
        public l() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C15068ix2.a(fragment.V7());
        }
    }

    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public F7() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new n(new m(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(N7.class), new o(interfaceC9173Yu3B), new p(null, interfaceC9173Yu3B), new q(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new l(), AbstractC20046rN7.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1229189955);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str, androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1J, i4).y(), null, 2, null), g10.c(interfaceC22053ub1J, i4).b().c(), g10.c(interfaceC22053ub1J, i4).b().u()), g10.a(interfaceC22053ub1J, i4).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i4).o(), interfaceC22053ub12, i3 & 14, 0, 65016);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.B7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return F7.X9(this.a, str, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X9(F7 f7, String str, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(f7, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$title");
        f7.W9(str, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(final BM2 bm2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1631177067);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(bm2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1J.W(496329316);
            boolean zD = ((i3 & 14) == 4) | interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.C7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return F7.Z9(this.a, bm2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null);
            G10 g10 = G10.a;
            int i5 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1J, i5).r(), null, 2, null), g10.c(interfaceC22053ub1J, i5).b().c());
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.e eVarG = c24254yJ.g();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar2.i(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(bm2.a(), null, false, 0, interfaceC22053ub1J, 0, 14), null, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(50.0f)), N46.g()), bm2.c(), bm2.e(), 0.0f, false, null, 20, null), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1J, 24624, 104);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i5).b().c()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.b(), aVar2.k(), interfaceC22053ub1J, 6);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
            SA2 sa2A2 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1J, 48);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            SA2 sa2A3 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            long jF = g10.a(interfaceC22053ub1J, i5).F();
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i5).b().h());
            int i6 = b.a[bm2.b().ordinal()];
            if (i6 == 1) {
                i4 = KB5.three_user;
            } else {
                if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i4 = KB5.tv;
            }
            AbstractC24077y03.b(FV4.c(i4, interfaceC22053ub1J, 0), UY6.c(AbstractC12217eE5.create_group_type, interfaceC22053ub1J, 0), eVarT, jF, interfaceC22053ub1J, 0, 0);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, g10.c(interfaceC22053ub1J, i5).b().n()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(bm2.e(), null, g10.a(interfaceC22053ub1J, i5).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).l(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1J, i5).b().n()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(UY6.b(AbstractC17590nD5.group_chat_members_count, bm2.d(), new Object[]{String.valueOf(bm2.d())}, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, g10.c(interfaceC22053ub1J, i5).b().c(), 0.0f, 11, null), g10.a(interfaceC22053ub1J, i5).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).c(), interfaceC22053ub1J, 0, 0, 65528);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.D7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return F7.ba(this.a, bm2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z9(final F7 f7, final BM2 bm2) {
        AbstractC13042fc3.i(f7, "this$0");
        AbstractC13042fc3.i(bm2, "$group");
        f7.ja().W0(bm2.c(), new SA2() { // from class: ir.nasim.E7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return F7.aa(this.a, bm2);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 aa(F7 f7, BM2 bm2) {
        AbstractC13042fc3.i(f7, "this$0");
        AbstractC13042fc3.i(bm2, "$group");
        f7.l9(f7, true);
        InterfaceC11677dQ0 interfaceC11677dQ0Ia = f7.ia();
        C11458d25 c11458d25Y = C11458d25.y(bm2.c());
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        C22042ua0.A9(f7, InterfaceC11677dQ0.b(interfaceC11677dQ0Ia, c11458d25Y, bm2.b() == ZN2.GROUP ? ExPeerType.GROUP : ExPeerType.CHANNEL, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, f7.ja().a1(), null, null, null, null, false, null, 133169148, null), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ba(F7 f7, BM2 bm2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(f7, "$tmp1_rcvr");
        AbstractC13042fc3.i(bm2, "$group");
        f7.Y9(bm2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga(InterfaceC15069ix3 interfaceC15069ix3, K7.d dVar) {
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1213452023, true, new f()), 3, null);
        List listC = dVar.c();
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (((BM2) it.next()).b() == ZN2.CHANNEL) {
                List listC2 = dVar.c();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listC2) {
                    if (((BM2) obj).b() == ZN2.CHANNEL) {
                        arrayList.add(obj);
                    }
                }
                interfaceC15069ix3.a(arrayList.size(), null, new d(c.e, arrayList), AbstractC19242q11.c(-632812321, true, new e(arrayList, this)));
                return;
            }
        }
    }

    private final C15068ix2 ha() {
        Object objA = this.binding.a(this, l1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C15068ix2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ka(InterfaceC15069ix3 interfaceC15069ix3, K7.d dVar) {
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(492079622, true, new j()), 3, null);
        List listC = dVar.c();
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (((BM2) it.next()).b() == ZN2.GROUP) {
                List listC2 = dVar.c();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listC2) {
                    if (((BM2) obj).b() == ZN2.GROUP) {
                        arrayList.add(obj);
                    }
                }
                interfaceC15069ix3.a(arrayList.size(), null, new h(g.e, arrayList), AbstractC19242q11.c(-632812321, true, new i(arrayList, this)));
                return;
            }
        }
    }

    private final void la() {
        BaleToolbar baleToolbar = ha().d;
        String string = S7().getString(AbstractC12217eE5.forward_select_chat);
        AbstractC13042fc3.h(string, "getString(...)");
        baleToolbar.setTitle(AbstractC20153rZ6.M(string, "…", "", false, 4, null));
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C15068ix2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final InterfaceC11677dQ0 ia() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    public final N7 ja() {
        return (N7) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ja().c1();
        la();
        ha().c.setContent(AbstractC19242q11.c(2103947209, true, new k()));
    }
}
