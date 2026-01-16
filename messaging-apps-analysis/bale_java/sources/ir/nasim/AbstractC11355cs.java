package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.compose.ui.viewinterop.ViewFactoryHolder;
import ir.nasim.InterfaceC16030kb1;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.cs, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11355cs {
    private static final UA2 a = h.e;

    /* renamed from: ir.nasim.cs$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, androidx.compose.ui.e eVar, UA2 ua22, int i, int i2) {
            super(2);
            this.e = ua2;
            this.f = eVar;
            this.g = ua22;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC11355cs.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, UA2 ua2) {
            AbstractC11355cs.f(c3419Au3).setResetBlock(ua2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (UA2) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, UA2 ua2) {
            AbstractC11355cs.f(c3419Au3).setUpdateBlock(ua2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (UA2) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, UA2 ua2) {
            AbstractC11355cs.f(c3419Au3).setReleaseBlock(ua2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (UA2) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, UA2 ua2) {
            AbstractC11355cs.f(c3419Au3).setUpdateBlock(ua2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (UA2) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final f e = new f();

        f() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, UA2 ua2) {
            AbstractC11355cs.f(c3419Au3).setReleaseBlock(ua2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (UA2) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(UA2 ua2, androidx.compose.ui.e eVar, UA2 ua22, UA2 ua23, UA2 ua24, int i, int i2) {
            super(2);
            this.e = ua2;
            this.f = eVar;
            this.g = ua22;
            this.h = ua23;
            this.i = ua24;
            this.j = i;
            this.k = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC11355cs.b(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Context e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ AbstractC7050Qb1 g;
        final /* synthetic */ InterfaceC11814db6 h;
        final /* synthetic */ int i;
        final /* synthetic */ View j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Context context, UA2 ua2, AbstractC7050Qb1 abstractC7050Qb1, InterfaceC11814db6 interfaceC11814db6, int i, View view) {
            super(0);
            this.e = context;
            this.f = ua2;
            this.g = abstractC7050Qb1;
            this.h = interfaceC11814db6;
            this.i = i;
            this.j = view;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C3419Au3 invoke() {
            Context context = this.e;
            UA2 ua2 = this.f;
            AbstractC7050Qb1 abstractC7050Qb1 = this.g;
            InterfaceC11814db6 interfaceC11814db6 = this.h;
            int i = this.i;
            KeyEvent.Callback callback = this.j;
            AbstractC13042fc3.g(callback, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
            return new ViewFactoryHolder(context, ua2, abstractC7050Qb1, interfaceC11814db6, i, (InterfaceC23714xO4) callback).getLayoutNode();
        }
    }

    /* renamed from: ir.nasim.cs$j */
    static final class j extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final j e = new j();

        j() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, androidx.compose.ui.e eVar) {
            AbstractC11355cs.f(c3419Au3).setModifier(eVar);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (androidx.compose.ui.e) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$k */
    static final class k extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final k e = new k();

        k() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, WH1 wh1) {
            AbstractC11355cs.f(c3419Au3).setDensity(wh1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (WH1) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$l */
    static final class l extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final l e = new l();

        l() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC11355cs.f(c3419Au3).setLifecycleOwner(interfaceC18633oz3);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (InterfaceC18633oz3) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$m */
    static final class m extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final m e = new m();

        m() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, InterfaceC7760Tb6 interfaceC7760Tb6) {
            AbstractC11355cs.f(c3419Au3).setSavedStateRegistryOwner(interfaceC7760Tb6);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (InterfaceC7760Tb6) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cs$n */
    static final class n extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final n e = new n();

        /* renamed from: ir.nasim.cs$n$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC12613eu3.values().length];
                try {
                    iArr[EnumC12613eu3.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC12613eu3.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        n() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, EnumC12613eu3 enumC12613eu3) {
            ViewFactoryHolder viewFactoryHolderF = AbstractC11355cs.f(c3419Au3);
            int i = a.a[enumC12613eu3.ordinal()];
            int i2 = 1;
            if (i == 1) {
                i2 = 0;
            } else if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            viewFactoryHolderF.setLayoutDirection(i2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (EnumC12613eu3) obj2);
            return C19938rB7.a;
        }
    }

    public static final void a(UA2 ua2, androidx.compose.ui.e eVar, UA2 ua22, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1783766393);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.D(ua2) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        int i6 = i3 & 4;
        if (i6 != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(ua22) ? 256 : 128;
        }
        if (interfaceC22053ub1J.o((i4 & 147) != 146, i4 & 1)) {
            if (i5 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (i6 != 0) {
                ua22 = a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1783766393, i4, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:104)");
            }
            b(ua2, eVar, null, a, ua22, interfaceC22053ub1J, (i4 & 14) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER | (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i4 << 6) & 57344), 4);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        androidx.compose.ui.e eVar2 = eVar;
        UA2 ua23 = ua22;
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(ua2, eVar2, ua23, i2, i3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.UA2 r24, androidx.compose.ui.e r25, ir.nasim.UA2 r26, ir.nasim.UA2 r27, ir.nasim.UA2 r28, ir.nasim.InterfaceC22053ub1 r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11355cs.b(ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    private static final SA2 d(UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(2030558801, i2, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:252)");
        }
        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        AbstractC7050Qb1 abstractC7050Qb1D = AbstractC6797Pa1.d(interfaceC22053ub1, 0);
        InterfaceC11814db6 interfaceC11814db6 = (InterfaceC11814db6) interfaceC22053ub1.H(AbstractC13035fb6.e());
        View view = (View) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.k());
        boolean zD = interfaceC22053ub1.D(context) | ((((i2 & 14) ^ 6) > 4 && interfaceC22053ub1.V(ua2)) || (i2 & 6) == 4) | interfaceC22053ub1.D(abstractC7050Qb1D) | interfaceC22053ub1.D(interfaceC11814db6) | interfaceC22053ub1.e(iA) | interfaceC22053ub1.D(view);
        Object objB = interfaceC22053ub1.B();
        if (zD || objB == InterfaceC22053ub1.a.a()) {
            objB = new i(context, ua2, abstractC7050Qb1D, interfaceC11814db6, iA, view);
            interfaceC22053ub1.s(objB);
        }
        SA2 sa2 = (SA2) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return sa2;
    }

    public static final UA2 e() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewFactoryHolder f(C3419Au3 c3419Au3) {
        AndroidViewHolder androidViewHolderB0 = c3419Au3.b0();
        if (androidViewHolderB0 != null) {
            return (ViewFactoryHolder) androidViewHolderB0;
        }
        M73.c("Required value was null.");
        throw new KotlinNothingValueException();
    }

    private static final void g(InterfaceC22053ub1 interfaceC22053ub1, androidx.compose.ui.e eVar, int i2, WH1 wh1, InterfaceC18633oz3 interfaceC18633oz3, InterfaceC7760Tb6 interfaceC7760Tb6, EnumC12613eu3 enumC12613eu3, InterfaceC11819dc1 interfaceC11819dc1) {
        InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
        DG7.c(interfaceC22053ub1, interfaceC11819dc1, aVar.g());
        DG7.c(interfaceC22053ub1, eVar, j.e);
        DG7.c(interfaceC22053ub1, wh1, k.e);
        DG7.c(interfaceC22053ub1, interfaceC18633oz3, l.e);
        DG7.c(interfaceC22053ub1, interfaceC7760Tb6, m.e);
        DG7.c(interfaceC22053ub1, enumC12613eu3, n.e);
        InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
        if (interfaceC22053ub1.h() || !AbstractC13042fc3.d(interfaceC22053ub1.B(), Integer.valueOf(i2))) {
            interfaceC22053ub1.s(Integer.valueOf(i2));
            interfaceC22053ub1.v(Integer.valueOf(i2), interfaceC14603iB2B);
        }
    }

    /* renamed from: ir.nasim.cs$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        public static final h e = new h();

        h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((View) obj);
            return C19938rB7.a;
        }

        public final void a(View view) {
        }
    }
}
