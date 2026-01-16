package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.bg4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10477bg4 {

    /* renamed from: ir.nasim.bg4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ DialogC9039Yf4 e;

        /* renamed from: ir.nasim.bg4$a$a, reason: collision with other inner class name */
        public static final class C0919a implements KV1 {
            final /* synthetic */ DialogC9039Yf4 a;

            public C0919a(DialogC9039Yf4 dialogC9039Yf4) {
                this.a = dialogC9039Yf4;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.dismiss();
                this.a.g();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(DialogC9039Yf4 dialogC9039Yf4) {
            super(1);
            this.e = dialogC9039Yf4;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.show();
            return new C0919a(this.e);
        }
    }

    /* renamed from: ir.nasim.bg4$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ DialogC9039Yf4 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ C9857ag4 g;
        final /* synthetic */ EnumC12613eu3 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(DialogC9039Yf4 dialogC9039Yf4, SA2 sa2, C9857ag4 c9857ag4, EnumC12613eu3 enumC12613eu3) {
            super(0);
            this.e = dialogC9039Yf4;
            this.f = sa2;
            this.g = c9857ag4;
            this.h = enumC12613eu3;
        }

        public final void a() {
            this.e.k(this.f, this.g, this.h);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bg4$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ C9857ag4 f;
        final /* synthetic */ C15607js g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SA2 sa2, C9857ag4 c9857ag4, C15607js c15607js, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = sa2;
            this.f = c9857ag4;
            this.g = c15607js;
            this.h = interfaceC14603iB2;
            this.i = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC10477bg4.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bg4$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        /* renamed from: ir.nasim.bg4$d$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC9939ao6.j(interfaceC11943do6);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC9664aL6 interfaceC9664aL6) {
            super(2);
            this.e = interfaceC9664aL6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1560960657, i, -1, "androidx.compose.material3.ModalBottomSheetDialog.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:296)");
            }
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(androidx.compose.ui.e.a, false, a.e, 1, null);
            InterfaceC9664aL6 interfaceC9664aL6 = this.e;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
            AbstractC10477bg4.b(interfaceC9664aL6).invoke(interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bg4$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        public static final e e = new e();

        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    /* renamed from: ir.nasim.bg4$f */
    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC20851si6.values().length];
            try {
                iArr[EnumC20851si6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC20851si6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC20851si6.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final void a(SA2 sa2, C9857ag4 c9857ag4, C15607js c15607js, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        boolean z;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1254951810);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c9857ag4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? interfaceC22053ub1J.V(c15607js) : interfaceC22053ub1J.D(c15607js) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1254951810, i3, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:272)");
            }
            View view = (View) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.k());
            WH1 wh1 = (WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g());
            EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1J.H(AbstractC13040fc1.n());
            AbstractC7050Qb1 abstractC7050Qb1D = AbstractC6797Pa1.d(interfaceC22053ub1J, 0);
            InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(interfaceC14603iB2, interfaceC22053ub1J, (i3 >> 9) & 14);
            UUID uuid = (UUID) AbstractC9681aN5.e(new Object[0], null, null, e.e, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                C14860ic1 c14860ic1 = new C14860ic1(AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J));
                interfaceC22053ub1J.s(c14860ic1);
                objB = c14860ic1;
            }
            InterfaceC20315ro1 interfaceC20315ro1A = ((C14860ic1) objB).a();
            boolean zA = AbstractC5345Iy1.a(interfaceC22053ub1J, 0);
            boolean zV = interfaceC22053ub1J.V(view) | interfaceC22053ub1J.V(wh1);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == aVar.a()) {
                z = true;
                DialogC9039Yf4 dialogC9039Yf4 = new DialogC9039Yf4(sa2, c9857ag4, view, enumC12613eu3, wh1, uuid, c15607js, interfaceC20315ro1A, zA);
                dialogC9039Yf4.h(abstractC7050Qb1D, AbstractC19242q11.c(-1560960657, true, new d(interfaceC9664aL6Q)));
                interfaceC22053ub1J.s(dialogC9039Yf4);
                objB2 = dialogC9039Yf4;
            } else {
                z = true;
            }
            DialogC9039Yf4 dialogC9039Yf42 = (DialogC9039Yf4) objB2;
            boolean zD = interfaceC22053ub1J.D(dialogC9039Yf42);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD || objB3 == aVar.a()) {
                objB3 = new a(dialogC9039Yf42);
                interfaceC22053ub1J.s(objB3);
            }
            AbstractC10721c52.a(dialogC9039Yf42, (UA2) objB3, interfaceC22053ub1J, 0);
            boolean zD2 = interfaceC22053ub1J.D(dialogC9039Yf42) | ((i3 & 14) == 4 ? z : false) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32 ? z : false) | interfaceC22053ub1J.V(enumC12613eu3);
            Object objB4 = interfaceC22053ub1J.B();
            if (zD2 || objB4 == aVar.a()) {
                objB4 = new b(dialogC9039Yf42, sa2, c9857ag4, enumC12613eu3);
                interfaceC22053ub1J.s(objB4);
            }
            AbstractC10721c52.i((SA2) objB4, interfaceC22053ub1J, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(sa2, c9857ag4, c15607js, interfaceC14603iB2, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC14603iB2 b(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC14603iB2) interfaceC9664aL6.getValue();
    }

    public static final boolean e(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(EnumC20851si6 enumC20851si6, boolean z) {
        int i = f.a[enumC20851si6.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }
}
