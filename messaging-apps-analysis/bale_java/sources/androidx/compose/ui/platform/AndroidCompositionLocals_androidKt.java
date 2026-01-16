package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.compose.ui.platform.AndroidComposeView;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC13035fb6;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6535Nx5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C13336g33;
import ir.nasim.C15376jU2;
import ir.nasim.C19938rB7;
import ir.nasim.C22211ur;
import ir.nasim.C7252Qx5;
import ir.nasim.DA4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15967kU2;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.KV1;
import ir.nasim.LV1;
import ir.nasim.NW5;
import ir.nasim.PV1;
import ir.nasim.QJ5;
import ir.nasim.RV1;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UG3;
import ir.nasim.ZD1;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\"\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00168\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\" \u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019\" \u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u00168\u0006¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019\"\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b)\u0010\u0019\" \u0010/\u001a\b\u0012\u0004\u0012\u00020+0\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010.\u001a\u0004\b,\u0010\u0019¨\u00060²\u0006\u000e\u0010\r\u001a\u00020\f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "owner", "Lkotlin/Function0;", "Lir/nasim/rB7;", "content", "a", "(Landroidx/compose/ui/platform/AndroidComposeView;Lir/nasim/iB2;Lir/nasim/ub1;I)V", "Landroid/content/Context;", "context", "Lir/nasim/NW5;", "n", "(Landroid/content/Context;Lir/nasim/ub1;I)Lir/nasim/NW5;", "Landroid/content/res/Configuration;", "configuration", "Lir/nasim/g33;", "m", "(Landroid/content/Context;Landroid/content/res/Configuration;Lir/nasim/ub1;I)Lir/nasim/g33;", "", "name", "", "l", "(Ljava/lang/String;)Ljava/lang/Void;", "Lir/nasim/Nx5;", "Lir/nasim/Nx5;", "f", "()Lir/nasim/Nx5;", "LocalConfiguration", "b", "g", "LocalContext", "c", "h", "LocalImageVectorCache", "d", "i", "LocalResourceIdCache", "Lir/nasim/Tb6;", "e", "j", "LocalSavedStateRegistryOwner", "Landroid/view/View;", "k", "LocalView", "Lir/nasim/oz3;", "getLocalLifecycleOwner", "getLocalLifecycleOwner$annotations", "()V", "LocalLifecycleOwner", "ui_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class AndroidCompositionLocals_androidKt {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.d(null, a.e, 1, null);
    private static final AbstractC6535Nx5 b = AbstractC11024cc1.f(b.e);
    private static final AbstractC6535Nx5 c = AbstractC11024cc1.f(c.e);
    private static final AbstractC6535Nx5 d = AbstractC11024cc1.f(d.e);
    private static final AbstractC6535Nx5 e = AbstractC11024cc1.f(e.e);
    private static final AbstractC6535Nx5 f = AbstractC11024cc1.f(f.e);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Configuration invoke() {
            AndroidCompositionLocals_androidKt.l("LocalConfiguration");
            throw new KotlinNothingValueException();
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Context invoke() {
            AndroidCompositionLocals_androidKt.l("LocalContext");
            throw new KotlinNothingValueException();
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13336g33 invoke() {
            AndroidCompositionLocals_androidKt.l("LocalImageVectorCache");
            throw new KotlinNothingValueException();
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        public static final d e = new d();

        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NW5 invoke() {
            AndroidCompositionLocals_androidKt.l("LocalResourceIdCache");
            throw new KotlinNothingValueException();
        }
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        public static final e e = new e();

        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC7760Tb6 invoke() {
            AndroidCompositionLocals_androidKt.l("LocalSavedStateRegistryOwner");
            throw new KotlinNothingValueException();
        }
    }

    static final class f extends AbstractC8614Ws3 implements SA2 {
        public static final f e = new f();

        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke() {
            AndroidCompositionLocals_androidKt.l("LocalView");
            throw new KotlinNothingValueException();
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC9102Ym4 interfaceC9102Ym4) {
            super(1);
            this.e = interfaceC9102Ym4;
        }

        public final void a(Configuration configuration) {
            AndroidCompositionLocals_androidKt.c(this.e, new Configuration(configuration));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Configuration) obj);
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ PV1 e;

        public static final class a implements KV1 {
            final /* synthetic */ PV1 a;

            public a(PV1 pv1) {
                this.a = pv1;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(PV1 pv1) {
            super(1);
            this.e = pv1;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            return new a(this.e);
        }
    }

    static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ AndroidComposeView e;
        final /* synthetic */ C22211ur f;
        final /* synthetic */ InterfaceC14603iB2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AndroidComposeView androidComposeView, C22211ur c22211ur, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = androidComposeView;
            this.f = c22211ur;
            this.g = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1471621628, i, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:121)");
            }
            AbstractC13040fc1.a(this.e, this.f, this.g, interfaceC22053ub1, 0);
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

    static final class j extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ AndroidComposeView e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(AndroidComposeView androidComposeView, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = androidComposeView;
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AndroidCompositionLocals_androidKt.a(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Context e;
        final /* synthetic */ l f;

        public static final class a implements KV1 {
            final /* synthetic */ Context a;
            final /* synthetic */ l b;

            public a(Context context, l lVar) {
                this.a = context;
                this.b = lVar;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.getApplicationContext().unregisterComponentCallbacks(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Context context, l lVar) {
            super(1);
            this.e = context;
            this.f = lVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.getApplicationContext().registerComponentCallbacks(this.f);
            return new a(this.e, this.f);
        }
    }

    public static final class l implements ComponentCallbacks2 {
        final /* synthetic */ Configuration a;
        final /* synthetic */ C13336g33 b;

        l(Configuration configuration, C13336g33 c13336g33) {
            this.a = configuration;
            this.b = c13336g33;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            this.b.c(this.a.updateFrom(configuration));
            this.a.setTo(configuration);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.b.a();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            this.b.a();
        }
    }

    static final class m extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Context e;
        final /* synthetic */ n f;

        public static final class a implements KV1 {
            final /* synthetic */ Context a;
            final /* synthetic */ n b;

            public a(Context context, n nVar) {
                this.a = context;
                this.b = nVar;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.getApplicationContext().unregisterComponentCallbacks(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Context context, n nVar) {
            super(1);
            this.e = context;
            this.f = nVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.getApplicationContext().registerComponentCallbacks(this.f);
            return new a(this.e, this.f);
        }
    }

    public static final class n implements ComponentCallbacks2 {
        final /* synthetic */ NW5 a;

        n(NW5 nw5) {
            this.a = nw5;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            this.a.a();
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.a.a();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            this.a.a();
        }
    }

    public static final void a(AndroidComposeView androidComposeView, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1396852028);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(androidComposeView) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i3 & 19) != 18, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1396852028, i3, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:76)");
            }
            Context context = androidComposeView.getContext();
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(new Configuration(context.getResources().getConfiguration()), null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new g(interfaceC9102Ym4);
                interfaceC22053ub1J.s(objB2);
            }
            androidComposeView.setConfigurationChangeObserver((UA2) objB2);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new C22211ur(context);
                interfaceC22053ub1J.s(objB3);
            }
            C22211ur c22211ur = (C22211ur) objB3;
            AndroidComposeView.C1928b viewTreeOwners = androidComposeView.getViewTreeOwners();
            if (viewTreeOwners == null) {
                throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
            }
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = RV1.b(androidComposeView, viewTreeOwners.b());
                interfaceC22053ub1J.s(objB4);
            }
            PV1 pv1 = (PV1) objB4;
            C19938rB7 c19938rB7 = C19938rB7.a;
            boolean zD = interfaceC22053ub1J.D(pv1);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD || objB5 == aVar.a()) {
                objB5 = new h(pv1);
                interfaceC22053ub1J.s(objB5);
            }
            AbstractC10721c52.a(c19938rB7, (UA2) objB5, interfaceC22053ub1J, 6);
            Object objB6 = interfaceC22053ub1J.B();
            if (objB6 == aVar.a()) {
                objB6 = C15376jU2.a.a(context) ? new ZD1(androidComposeView.getView()) : new DA4();
                interfaceC22053ub1J.s(objB6);
            }
            AbstractC11024cc1.b(new C7252Qx5[]{a.d(b(interfaceC9102Ym4)), b.d(context), UG3.a().d(viewTreeOwners.a()), e.d(viewTreeOwners.b()), AbstractC13035fb6.e().d(pv1), f.d(androidComposeView.getView()), c.d(m(context, b(interfaceC9102Ym4), interfaceC22053ub1J, 0)), d.d(n(context, interfaceC22053ub1J, 0)), AbstractC13040fc1.p().d(Boolean.valueOf(((Boolean) interfaceC22053ub1J.H(AbstractC13040fc1.q())).booleanValue() | androidComposeView.getScrollCaptureInProgress$ui_release())), AbstractC13040fc1.l().d((InterfaceC15967kU2) objB6)}, AbstractC19242q11.e(1471621628, true, new i(androidComposeView, c22211ur, interfaceC14603iB2), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new j(androidComposeView, interfaceC14603iB2, i2));
        }
    }

    private static final Configuration b(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (Configuration) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(InterfaceC9102Ym4 interfaceC9102Ym4, Configuration configuration) {
        interfaceC9102Ym4.setValue(configuration);
    }

    public static final AbstractC6535Nx5 f() {
        return a;
    }

    public static final AbstractC6535Nx5 g() {
        return b;
    }

    public static final AbstractC6535Nx5 getLocalLifecycleOwner() {
        return UG3.a();
    }

    public static final AbstractC6535Nx5 h() {
        return c;
    }

    public static final AbstractC6535Nx5 i() {
        return d;
    }

    public static final AbstractC6535Nx5 j() {
        return e;
    }

    public static final AbstractC6535Nx5 k() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void l(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    private static final C13336g33 m(Context context, Configuration configuration, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-485908294, i2, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:157)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = new C13336g33();
            interfaceC22053ub1.s(objB);
        }
        C13336g33 c13336g33 = (C13336g33) objB;
        Object objB2 = interfaceC22053ub1.B();
        Object obj = objB2;
        if (objB2 == aVar.a()) {
            Configuration configuration2 = new Configuration();
            if (configuration != null) {
                configuration2.setTo(configuration);
            }
            interfaceC22053ub1.s(configuration2);
            obj = configuration2;
        }
        Configuration configuration3 = (Configuration) obj;
        Object objB3 = interfaceC22053ub1.B();
        if (objB3 == aVar.a()) {
            objB3 = new l(configuration3, c13336g33);
            interfaceC22053ub1.s(objB3);
        }
        l lVar = (l) objB3;
        boolean zD = interfaceC22053ub1.D(context);
        Object objB4 = interfaceC22053ub1.B();
        if (zD || objB4 == aVar.a()) {
            objB4 = new k(context, lVar);
            interfaceC22053ub1.s(objB4);
        }
        AbstractC10721c52.a(c13336g33, (UA2) objB4, interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c13336g33;
    }

    private static final NW5 n(Context context, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1348507246, i2, -1, "androidx.compose.ui.platform.obtainResourceIdCache (AndroidCompositionLocals.android.kt:127)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = new NW5();
            interfaceC22053ub1.s(objB);
        }
        NW5 nw5 = (NW5) objB;
        Object objB2 = interfaceC22053ub1.B();
        if (objB2 == aVar.a()) {
            objB2 = new n(nw5);
            interfaceC22053ub1.s(objB2);
        }
        n nVar = (n) objB2;
        boolean zD = interfaceC22053ub1.D(context);
        Object objB3 = interfaceC22053ub1.B();
        if (zD || objB3 == aVar.a()) {
            objB3 = new m(context, nVar);
            interfaceC22053ub1.s(objB3);
        }
        AbstractC10721c52.a(nw5, (UA2) objB3, interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return nw5;
    }
}
