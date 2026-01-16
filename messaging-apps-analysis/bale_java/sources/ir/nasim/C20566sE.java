package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C9475a16;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006 ²\u0006\f\u0010\u001f\u001a\u00020\u001e8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/sE;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/ZR3;", "marketPlaceState", "Lir/nasim/rB7;", "V9", "(Lir/nasim/ZR3;)V", "W9", "Y9", "X9", "Z9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/HE;", "h1", "Lir/nasim/Yu3;", "U9", "()Lir/nasim/HE;", "viewModel", "i1", "a", "Lir/nasim/GE;", "state", "apprating_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.sE, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20566sE extends LV2 {

    /* renamed from: i1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.sE$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C20566sE a(int i) {
            C20566sE c20566sE = new C20566sE();
            c20566sE.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("peer_id", Integer.valueOf(i))));
            return c20566sE;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.sE$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ZR3.values().length];
            try {
                iArr[ZR3.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZR3.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ZR3.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ZR3.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.sE$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.sE$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ C20566sE d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6, C20566sE c20566sE, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9664aL6;
                this.d = c20566sE;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ZR3 zr3D = c.c(this.c).d();
                if (zr3D != null) {
                    this.d.V9(zr3D);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sE$c$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20566sE c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C20566sE c20566sE, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20566sE;
                this.d = interfaceC9664aL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (c.c(this.d).c()) {
                    this.c.Q7().onBackPressed();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sE$c$c, reason: collision with other inner class name */
        static final class C1538c implements InterfaceC14603iB2 {
            final /* synthetic */ C20566sE a;
            final /* synthetic */ InterfaceC9664aL6 b;

            /* renamed from: ir.nasim.sE$c$c$a */
            /* synthetic */ class a extends EB2 implements UA2 {
                a(Object obj) {
                    super(1, obj, HE.class, "neverShowRatingAppClickChanged", "neverShowRatingAppClickChanged(Z)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y(((Boolean) obj).booleanValue());
                    return C19938rB7.a;
                }

                public final void y(boolean z) {
                    ((HE) this.receiver).U0(z);
                }
            }

            /* renamed from: ir.nasim.sE$c$c$b */
            /* synthetic */ class b extends EB2 implements SA2 {
                b(Object obj) {
                    super(0, obj, HE.class, "openMarketPlace", "openMarketPlace()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((HE) this.receiver).W0();
                }
            }

            /* renamed from: ir.nasim.sE$c$c$c, reason: collision with other inner class name */
            /* synthetic */ class C1539c extends EB2 implements SA2 {
                C1539c(Object obj) {
                    super(0, obj, HE.class, "cancelRating", "cancelRating()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((HE) this.receiver).P0();
                }
            }

            C1538c(C20566sE c20566sE, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c20566sE;
                this.b = interfaceC9664aL6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (c.c(this.b).e()) {
                    HE heU9 = this.a.U9();
                    interfaceC22053ub1.W(-1165631615);
                    boolean zD = interfaceC22053ub1.D(heU9);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new a(heU9);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB);
                    HE heU92 = this.a.U9();
                    interfaceC22053ub1.W(-1165628910);
                    boolean zD2 = interfaceC22053ub1.D(heU92);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(heU92);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB2);
                    HE heU93 = this.a.U9();
                    interfaceC22053ub1.W(-1165626929);
                    boolean zD3 = interfaceC22053ub1.D(heU93);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new C1539c(heU93);
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    FE.j(ua2, sa2, (SA2) ((InterfaceC16733lm3) objB3), interfaceC22053ub1, 0);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final GE c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (GE) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(C20566sE.this.U9().T0(), null, null, null, interfaceC22053ub1, 0, 7);
            ZR3 zr3D = c(interfaceC9664aL6C).d();
            interfaceC22053ub1.W(1803136163);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C20566sE.this);
            C20566sE c20566sE = C20566sE.this;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(interfaceC9664aL6C, c20566sE, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(zr3D, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            Boolean boolValueOf = Boolean.valueOf(c(interfaceC9664aL6C).c());
            interfaceC22053ub1.W(1803143031);
            boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C20566sE.this);
            C20566sE c20566sE2 = C20566sE.this;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(c20566sE2, interfaceC9664aL6C, null);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
            M10.f(false, AbstractC19242q11.e(1773180646, true, new C1538c(C20566sE.this, interfaceC9664aL6C), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sE$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.sE$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.sE$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.sE$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.sE$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C20566sE() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(HE.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HE U9() {
        return (HE) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(ZR3 marketPlaceState) {
        int i = b.a[marketPlaceState.ordinal()];
        if (i == 1) {
            W9(marketPlaceState);
            return;
        }
        if (i == 2) {
            Y9(marketPlaceState);
        } else if (i == 3) {
            X9(marketPlaceState);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            Z9(marketPlaceState);
        }
    }

    private final void W9(ZR3 marketPlaceState) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            Intent intent = new Intent("android.intent.action.EDIT");
            FragmentActivity fragmentActivityA5 = A5();
            intent.setData(Uri.parse("bazaar://details?id=" + (fragmentActivityA5 != null ? fragmentActivityA5.getPackageName() : null)));
            intent.setPackage("com.farsitel.bazaar");
            n8(intent);
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.j(objB)) {
            U9().X0(marketPlaceState);
        }
        if (C9475a16.e(objB) != null) {
            U9().V0(marketPlaceState);
        }
    }

    private final void X9(ZR3 marketPlaceState) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            FragmentActivity fragmentActivityQ7 = Q7();
            FragmentActivity fragmentActivityA5 = A5();
            fragmentActivityQ7.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://cafebazaar.ir/app/?id=" + (fragmentActivityA5 != null ? fragmentActivityA5.getPackageName() : null))).addFlags(268435456));
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.j(objB)) {
            U9().X0(marketPlaceState);
        }
        if (C9475a16.e(objB) != null) {
            U9().S0();
        }
    }

    private final void Y9(ZR3 marketPlaceState) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            FragmentActivity fragmentActivityA5 = A5();
            String str = "myket://comment?id=" + (fragmentActivityA5 != null ? fragmentActivityA5.getPackageName() : null);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            n8(intent);
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.j(objB)) {
            U9().X0(marketPlaceState);
        }
        if (C9475a16.e(objB) != null) {
            U9().V0(marketPlaceState);
        }
    }

    private final void Z9(ZR3 marketPlaceState) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            FragmentActivity fragmentActivityQ7 = Q7();
            FragmentActivity fragmentActivityA5 = A5();
            fragmentActivityQ7.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://myket.ir/app/" + (fragmentActivityA5 != null ? fragmentActivityA5.getPackageName() : null))).addFlags(268435456));
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.j(objB)) {
            U9().X0(marketPlaceState);
        }
        if (C9475a16.e(objB) != null) {
            U9().S0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1917105493, true, new c()));
        return composeView;
    }
}
