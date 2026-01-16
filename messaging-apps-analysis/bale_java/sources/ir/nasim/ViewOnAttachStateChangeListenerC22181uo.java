package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.ViewOnAttachStateChangeListenerC22181uo;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.uo, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnAttachStateChangeListenerC22181uo implements InterfaceC18484ok1, DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    public static final a p = new a(null);
    public static final int q = 8;
    private final AndroidComposeView a;
    private SA2 b;
    private C19666qk1 c;
    private long k;
    private C7870Tn6 m;
    private boolean n;
    private final List d = new ArrayList();
    private long e = 100;
    private b f = b.a;
    private boolean g = true;
    private final InterfaceC17639nJ0 h = DJ0.b(1, null, null, 6, null);
    private final Handler i = new Handler(Looper.getMainLooper());
    private AbstractC20768sa3 j = AbstractC21388ta3.b();
    private C16734lm4 l = AbstractC21388ta3.c();
    private final Runnable o = new Runnable() { // from class: ir.nasim.to
        @Override // java.lang.Runnable
        public final void run() {
            ViewOnAttachStateChangeListenerC22181uo.j(this.a);
        }
    };

    /* renamed from: ir.nasim.uo$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.uo$b */
    private static final class b {
        public static final b a = new b("SHOW_ORIGINAL", 0);
        public static final b b = new b("SHOW_TRANSLATED", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.uo$c */
    static final class c {
        public static final c a = new c();

        private c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void b(ViewOnAttachStateChangeListenerC22181uo viewOnAttachStateChangeListenerC22181uo, LongSparseArray longSparseArray) {
            TranslationResponseValue value;
            CharSequence text;
            C8338Vn6 c8338Vn6;
            C7631Sn6 c7631Sn6B;
            C20450s2 c20450s2;
            UA2 ua2;
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                long jKeyAt = longSparseArray.keyAt(i);
                ViewTranslationResponse viewTranslationResponseA = AbstractC3600Bo.a(longSparseArray.get(jKeyAt));
                if (viewTranslationResponseA != null && (value = viewTranslationResponseA.getValue("android:text")) != null && (text = value.getText()) != null && (c8338Vn6 = (C8338Vn6) viewOnAttachStateChangeListenerC22181uo.n().b((int) jKeyAt)) != null && (c7631Sn6B = c8338Vn6.b()) != null && (c20450s2 = (C20450s2) AbstractC5719Kn6.a(c7631Sn6B.w(), C5485Jn6.a.A())) != null && (ua2 = (UA2) c20450s2.a()) != null) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ViewOnAttachStateChangeListenerC22181uo viewOnAttachStateChangeListenerC22181uo, LongSparseArray longSparseArray) {
            a.b(viewOnAttachStateChangeListenerC22181uo, longSparseArray);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(ir.nasim.ViewOnAttachStateChangeListenerC22181uo r15, long[] r16, int[] r17, java.util.function.Consumer r18) {
            /*
                r14 = this;
                r0 = r16
                int r1 = r0.length
                r2 = 0
            L4:
                if (r2 >= r1) goto L72
                r3 = r0[r2]
                ir.nasim.sa3 r5 = r15.n()
                int r3 = (int) r3
                java.lang.Object r3 = r5.b(r3)
                ir.nasim.Vn6 r3 = (ir.nasim.C8338Vn6) r3
                if (r3 == 0) goto L6d
                ir.nasim.Sn6 r3 = r3.b()
                if (r3 != 0) goto L1c
                goto L6d
            L1c:
                ir.nasim.AbstractC3361Ao.a()
                androidx.compose.ui.platform.AndroidComposeView r4 = r15.o()
                android.view.autofill.AutofillId r4 = ir.nasim.AbstractC22771vo.a(r4)
                int r5 = r3.o()
                long r5 = (long) r5
                android.view.translation.ViewTranslationRequest$Builder r4 = ir.nasim.AbstractC25141zo.a(r4, r5)
                androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.w()
                ir.nasim.Xn6 r5 = ir.nasim.C8838Xn6.a
                ir.nasim.co6 r5 = r5.H()
                java.lang.Object r3 = ir.nasim.AbstractC5719Kn6.a(r3, r5)
                r5 = r3
                java.util.List r5 = (java.util.List) r5
                if (r5 == 0) goto L6d
                r12 = 62
                r13 = 0
                java.lang.String r6 = "\n"
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                java.lang.String r3 = ir.nasim.AbstractC12806fC3.e(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                if (r3 == 0) goto L6d
                ir.nasim.fu r5 = new ir.nasim.fu
                r6 = 0
                r7 = 2
                r5.<init>(r3, r6, r7, r6)
                java.lang.String r3 = "android:text"
                android.view.translation.TranslationRequestValue r5 = ir.nasim.AbstractC23367wo.a(r5)
                ir.nasim.AbstractC23957xo.a(r4, r3, r5)
                android.view.translation.ViewTranslationRequest r3 = ir.nasim.AbstractC24547yo.a(r4)
                r4 = r18
                r4.accept(r3)
                goto L6f
            L6d:
                r4 = r18
            L6f:
                int r2 = r2 + 1
                goto L4
            L72:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ViewOnAttachStateChangeListenerC22181uo.c.c(ir.nasim.uo, long[], int[], java.util.function.Consumer):void");
        }

        public final void d(final ViewOnAttachStateChangeListenerC22181uo viewOnAttachStateChangeListenerC22181uo, final LongSparseArray longSparseArray) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (AbstractC13042fc3.d(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                b(viewOnAttachStateChangeListenerC22181uo, longSparseArray);
            } else {
                viewOnAttachStateChangeListenerC22181uo.o().post(new Runnable() { // from class: ir.nasim.Eo
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnAttachStateChangeListenerC22181uo.c.e(viewOnAttachStateChangeListenerC22181uo, longSparseArray);
                    }
                });
            }
        }
    }

    /* renamed from: ir.nasim.uo$d */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC17893nk1.values().length];
            try {
                iArr[EnumC17893nk1.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC17893nk1.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.uo$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return ViewOnAttachStateChangeListenerC22181uo.this.e(this);
        }
    }

    /* renamed from: ir.nasim.uo$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C7870Tn6 e;
        final /* synthetic */ ViewOnAttachStateChangeListenerC22181uo f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C7870Tn6 c7870Tn6, ViewOnAttachStateChangeListenerC22181uo viewOnAttachStateChangeListenerC22181uo) {
            super(2);
            this.e = c7870Tn6;
            this.f = viewOnAttachStateChangeListenerC22181uo;
        }

        public final void a(int i, C7631Sn6 c7631Sn6) {
            if (this.e.a().a(c7631Sn6.o())) {
                return;
            }
            this.f.H(i, c7631Sn6);
            this.f.t();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), (C7631Sn6) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uo$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        g() {
            super(2);
        }

        public final void a(int i, C7631Sn6 c7631Sn6) {
            ViewOnAttachStateChangeListenerC22181uo.this.H(i, c7631Sn6);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), (C7631Sn6) obj2);
            return C19938rB7.a;
        }
    }

    public ViewOnAttachStateChangeListenerC22181uo(AndroidComposeView androidComposeView, SA2 sa2) {
        this.a = androidComposeView;
        this.b = sa2;
        this.m = new C7870Tn6(androidComposeView.getSemanticsOwner().d(), AbstractC21388ta3.b());
    }

    private final void C(C7631Sn6 c7631Sn6, C7870Tn6 c7870Tn6) {
        l(c7631Sn6, new f(c7870Tn6, this));
        List listT = c7631Sn6.t();
        int size = listT.size();
        for (int i = 0; i < size; i++) {
            C7631Sn6 c7631Sn62 = (C7631Sn6) listT.get(i);
            if (n().a(c7631Sn62.o()) && this.l.a(c7631Sn62.o())) {
                Object objB = this.l.b(c7631Sn62.o());
                if (objB == null) {
                    M73.c("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                C(c7631Sn62, (C7870Tn6) objB);
            }
        }
    }

    private final void D() {
        C16734lm4 c16734lm4 = this.l;
        int[] iArr = c16734lm4.b;
        long[] jArr = c16734lm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = iArr[(i << 3) + i3];
                        if (!n().a(i4)) {
                            g(i4);
                            t();
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void E(int i, String str) {
        C19666qk1 c19666qk1;
        if (Build.VERSION.SDK_INT >= 29 && (c19666qk1 = this.c) != null) {
            AutofillId autofillIdB = c19666qk1.b(i);
            if (autofillIdB != null) {
                c19666qk1.f(autofillIdB, str);
            } else {
                M73.c("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void F() {
        C20450s2 c20450s2;
        UA2 ua2;
        AbstractC20768sa3 abstractC20768sa3N = n();
        Object[] objArr = abstractC20768sa3N.c;
        long[] jArr = abstractC20768sa3N.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration semanticsConfigurationW = ((C8338Vn6) objArr[(i << 3) + i3]).b().w();
                        if (AbstractC13042fc3.d(AbstractC5719Kn6.a(semanticsConfigurationW, C8838Xn6.a.u()), Boolean.FALSE) && (c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationW, C5485Jn6.a.B())) != null && (ua2 = (UA2) c20450s2.a()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final KX7 G(C7631Sn6 c7631Sn6, int i) {
        C21330tU c21330tUA;
        AutofillId autofillIdA;
        String strI;
        C19666qk1 c19666qk1 = this.c;
        if (c19666qk1 == null || Build.VERSION.SDK_INT < 29 || (c21330tUA = AbstractC14199hW7.a(this.a)) == null) {
            return null;
        }
        if (c7631Sn6.r() != null) {
            autofillIdA = c19666qk1.b(r3.o());
            if (autofillIdA == null) {
                return null;
            }
        } else {
            autofillIdA = c21330tUA.a();
        }
        KX7 kx7C = c19666qk1.c(autofillIdA, c7631Sn6.o());
        if (kx7C == null) {
            return null;
        }
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        if (semanticsConfigurationW.i(c8838Xn6.A())) {
            return null;
        }
        Bundle bundleA = kx7C.a();
        if (bundleA != null) {
            bundleA.putLong("android.view.contentcapture.EventTimestamp", this.k);
            bundleA.putInt("android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX", i);
        }
        String str = (String) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.G());
        if (str != null) {
            kx7C.e(c7631Sn6.o(), null, null, str);
        }
        if (((Boolean) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.v())) != null) {
            kx7C.b("android.widget.ViewGroup");
        }
        List list = (List) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.H());
        if (list != null) {
            kx7C.b("android.widget.TextView");
            kx7C.f(AbstractC12806fC3.e(list, Separators.RETURN, null, null, 0, null, null, 62, null));
        }
        C13245fu c13245fu = (C13245fu) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.g());
        if (c13245fu != null) {
            kx7C.b("android.widget.EditText");
            kx7C.f(c13245fu);
        }
        List list2 = (List) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.d());
        if (list2 != null) {
            kx7C.c(AbstractC12806fC3.e(list2, Separators.RETURN, null, null, 0, null, null, 62, null));
        }
        B26 b26 = (B26) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.C());
        if (b26 != null && (strI = AbstractC13192fo6.i(b26.p())) != null) {
            kx7C.b(strI);
        }
        C13774gn7 c13774gn7E = AbstractC13192fo6.e(semanticsConfigurationW);
        if (c13774gn7E != null) {
            C13183fn7 c13183fn7L = c13774gn7E.l();
            kx7C.g(C13193fo7.h(c13183fn7L.i().l()) * c13183fn7L.b().getDensity() * c13183fn7L.b().t1(), 0, 0, 0);
        }
        CK5 ck5H = c7631Sn6.h();
        kx7C.d((int) ck5H.i(), (int) ck5H.l(), 0, 0, (int) (ck5H.j() - ck5H.i()), (int) (ck5H.e() - ck5H.l()));
        return kx7C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int i, C7631Sn6 c7631Sn6) {
        if (q()) {
            K(c7631Sn6);
            f(c7631Sn6.o(), G(c7631Sn6, i));
            l(c7631Sn6, new g());
        }
    }

    private final void I(C7631Sn6 c7631Sn6) {
        if (q()) {
            g(c7631Sn6.o());
            List listT = c7631Sn6.t();
            int size = listT.size();
            for (int i = 0; i < size; i++) {
                I((C7631Sn6) listT.get(i));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void J() {
        /*
            r16 = this;
            r0 = r16
            ir.nasim.lm4 r1 = r0.l
            r1.g()
            ir.nasim.sa3 r1 = r16.n()
            int[] r2 = r1.b
            java.lang.Object[] r3 = r1.c
            long[] r1 = r1.a
            int r4 = r1.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L62
            r6 = 0
        L17:
            r7 = r1[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L5d
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L31:
            if (r11 >= r9) goto L5b
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L57
            int r12 = r6 << 3
            int r12 = r12 + r11
            r13 = r2[r12]
            r12 = r3[r12]
            ir.nasim.Vn6 r12 = (ir.nasim.C8338Vn6) r12
            ir.nasim.lm4 r14 = r0.l
            ir.nasim.Tn6 r15 = new ir.nasim.Tn6
            ir.nasim.Sn6 r12 = r12.b()
            ir.nasim.sa3 r5 = r16.n()
            r15.<init>(r12, r5)
            r14.r(r13, r15)
        L57:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L31
        L5b:
            if (r9 != r10) goto L62
        L5d:
            if (r6 == r4) goto L62
            int r6 = r6 + 1
            goto L17
        L62:
            ir.nasim.Tn6 r1 = new ir.nasim.Tn6
            androidx.compose.ui.platform.AndroidComposeView r2 = r0.a
            ir.nasim.Wn6 r2 = r2.getSemanticsOwner()
            ir.nasim.Sn6 r2 = r2.d()
            ir.nasim.sa3 r3 = r16.n()
            r1.<init>(r2, r3)
            r0.m = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ViewOnAttachStateChangeListenerC22181uo.J():void");
    }

    private final void K(C7631Sn6 c7631Sn6) {
        C20450s2 c20450s2;
        UA2 ua2;
        UA2 ua22;
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        Boolean bool = (Boolean) AbstractC5719Kn6.a(semanticsConfigurationW, C8838Xn6.a.u());
        if (this.f == b.a && AbstractC13042fc3.d(bool, Boolean.TRUE)) {
            C20450s2 c20450s22 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationW, C5485Jn6.a.B());
            if (c20450s22 == null || (ua22 = (UA2) c20450s22.a()) == null) {
                return;
            }
            return;
        }
        if (this.f != b.b || !AbstractC13042fc3.d(bool, Boolean.FALSE) || (c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationW, C5485Jn6.a.B())) == null || (ua2 = (UA2) c20450s2.a()) == null) {
            return;
        }
    }

    private final void f(int i, KX7 kx7) {
        if (kx7 == null) {
            return;
        }
        this.d.add(new C17302mk1(i, this.k, EnumC17893nk1.a, kx7));
    }

    private final void g(int i) {
        this.d.add(new C17302mk1(i, this.k, EnumC17893nk1.b, null));
    }

    private final void h(AbstractC20768sa3 abstractC20768sa3) {
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        int i;
        char c2;
        long j;
        int i2;
        long[] jArr3;
        Object[] objArr;
        C7870Tn6 c7870Tn6;
        long[] jArr4;
        Object[] objArr2;
        C7870Tn6 c7870Tn62;
        Object[] objArr3;
        Object[] objArr4;
        AbstractC20768sa3 abstractC20768sa32 = abstractC20768sa3;
        int[] iArr3 = abstractC20768sa32.b;
        long[] jArr5 = abstractC20768sa32.a;
        int length = jArr5.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j2 = jArr5[i3];
            char c3 = 7;
            long j3 = -9187201950435737472L;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j2 & 255) < 128) {
                        int i7 = iArr3[(i3 << 3) + i6];
                        C7870Tn6 c7870Tn63 = (C7870Tn6) this.l.b(i7);
                        C8338Vn6 c8338Vn6 = (C8338Vn6) abstractC20768sa32.b(i7);
                        C7631Sn6 c7631Sn6B = c8338Vn6 != null ? c8338Vn6.b() : null;
                        if (c7631Sn6B == null) {
                            M73.c("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        if (c7870Tn63 == null) {
                            C7386Rm4 c7386Rm4A = c7631Sn6B.w().A();
                            Object[] objArr5 = c7386Rm4A.b;
                            long[] jArr6 = c7386Rm4A.a;
                            int length2 = jArr6.length - 2;
                            iArr2 = iArr3;
                            if (length2 >= 0) {
                                int i8 = 0;
                                while (true) {
                                    long j4 = jArr6[i8];
                                    jArr2 = jArr5;
                                    i = length;
                                    if ((((~j4) << c3) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                        int i10 = 0;
                                        while (i10 < i9) {
                                            if ((j4 & 255) < 128) {
                                                C11322co6 c11322co6 = (C11322co6) objArr5[(i8 << 3) + i10];
                                                C8838Xn6 c8838Xn6 = C8838Xn6.a;
                                                objArr4 = objArr5;
                                                if (AbstractC13042fc3.d(c11322co6, c8838Xn6.H())) {
                                                    List list = (List) AbstractC5719Kn6.a(c7631Sn6B.w(), c8838Xn6.H());
                                                    E(c7631Sn6B.o(), String.valueOf(list != null ? (C13245fu) AbstractC15401jX0.s0(list) : null));
                                                }
                                            } else {
                                                objArr4 = objArr5;
                                            }
                                            j4 >>= 8;
                                            i10++;
                                            objArr5 = objArr4;
                                        }
                                        objArr3 = objArr5;
                                        if (i9 != 8) {
                                            break;
                                        }
                                    } else {
                                        objArr3 = objArr5;
                                    }
                                    if (i8 == length2) {
                                        break;
                                    }
                                    i8++;
                                    jArr5 = jArr2;
                                    length = i;
                                    objArr5 = objArr3;
                                    c3 = 7;
                                }
                            } else {
                                jArr2 = jArr5;
                                i = length;
                            }
                        } else {
                            iArr2 = iArr3;
                            jArr2 = jArr5;
                            i = length;
                            C7386Rm4 c7386Rm4A2 = c7631Sn6B.w().A();
                            Object[] objArr6 = c7386Rm4A2.b;
                            long[] jArr7 = c7386Rm4A2.a;
                            int length3 = jArr7.length - 2;
                            if (length3 >= 0) {
                                int i11 = 0;
                                while (true) {
                                    long j5 = jArr7[i11];
                                    c2 = 7;
                                    j = -9187201950435737472L;
                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i12 = 8 - ((~(i11 - length3)) >>> 31);
                                        int i13 = 0;
                                        while (i13 < i12) {
                                            if ((j5 & 255) < 128) {
                                                jArr4 = jArr7;
                                                C11322co6 c11322co62 = (C11322co6) objArr6[(i11 << 3) + i13];
                                                C8838Xn6 c8838Xn62 = C8838Xn6.a;
                                                objArr2 = objArr6;
                                                if (AbstractC13042fc3.d(c11322co62, c8838Xn62.H())) {
                                                    List list2 = (List) AbstractC5719Kn6.a(c7870Tn63.b(), c8838Xn62.H());
                                                    C13245fu c13245fu = list2 != null ? (C13245fu) AbstractC15401jX0.s0(list2) : null;
                                                    c7870Tn62 = c7870Tn63;
                                                    List list3 = (List) AbstractC5719Kn6.a(c7631Sn6B.w(), c8838Xn62.H());
                                                    C13245fu c13245fu2 = list3 != null ? (C13245fu) AbstractC15401jX0.s0(list3) : null;
                                                    if (!AbstractC13042fc3.d(c13245fu, c13245fu2)) {
                                                        E(c7631Sn6B.o(), String.valueOf(c13245fu2));
                                                    }
                                                }
                                                j5 >>= 8;
                                                i13++;
                                                jArr7 = jArr4;
                                                objArr6 = objArr2;
                                                c7870Tn63 = c7870Tn62;
                                            } else {
                                                jArr4 = jArr7;
                                                objArr2 = objArr6;
                                            }
                                            c7870Tn62 = c7870Tn63;
                                            j5 >>= 8;
                                            i13++;
                                            jArr7 = jArr4;
                                            objArr6 = objArr2;
                                            c7870Tn63 = c7870Tn62;
                                        }
                                        jArr3 = jArr7;
                                        objArr = objArr6;
                                        c7870Tn6 = c7870Tn63;
                                        if (i12 != 8) {
                                            break;
                                        }
                                    } else {
                                        jArr3 = jArr7;
                                        objArr = objArr6;
                                        c7870Tn6 = c7870Tn63;
                                    }
                                    if (i11 == length3) {
                                        break;
                                    }
                                    i11++;
                                    jArr7 = jArr3;
                                    objArr6 = objArr;
                                    c7870Tn63 = c7870Tn6;
                                }
                            }
                            i2 = 8;
                        }
                        j = -9187201950435737472L;
                        c2 = 7;
                        i2 = 8;
                    } else {
                        iArr2 = iArr3;
                        jArr2 = jArr5;
                        i = length;
                        c2 = c3;
                        j = j3;
                        i2 = i4;
                    }
                    j2 >>= i2;
                    i6++;
                    i4 = i2;
                    j3 = j;
                    iArr3 = iArr2;
                    jArr5 = jArr2;
                    length = i;
                    c3 = c2;
                    abstractC20768sa32 = abstractC20768sa3;
                }
                iArr = iArr3;
                jArr = jArr5;
                int i14 = length;
                if (i5 != i4) {
                    return;
                } else {
                    length = i14;
                }
            } else {
                iArr = iArr3;
                jArr = jArr5;
            }
            if (i3 == length) {
                return;
            }
            i3++;
            abstractC20768sa32 = abstractC20768sa3;
            iArr3 = iArr;
            jArr5 = jArr;
        }
    }

    private final void i() {
        C20450s2 c20450s2;
        SA2 sa2;
        AbstractC20768sa3 abstractC20768sa3N = n();
        Object[] objArr = abstractC20768sa3N.c;
        long[] jArr = abstractC20768sa3N.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration semanticsConfigurationW = ((C8338Vn6) objArr[(i << 3) + i3]).b().w();
                        if (AbstractC5719Kn6.a(semanticsConfigurationW, C8838Xn6.a.u()) != null && (c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationW, C5485Jn6.a.a())) != null && (sa2 = (SA2) c20450s2.a()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ViewOnAttachStateChangeListenerC22181uo viewOnAttachStateChangeListenerC22181uo) {
        if (viewOnAttachStateChangeListenerC22181uo.q()) {
            InterfaceC23714xO4.B(viewOnAttachStateChangeListenerC22181uo.a, false, 1, null);
            viewOnAttachStateChangeListenerC22181uo.D();
            viewOnAttachStateChangeListenerC22181uo.C(viewOnAttachStateChangeListenerC22181uo.a.getSemanticsOwner().d(), viewOnAttachStateChangeListenerC22181uo.m);
            viewOnAttachStateChangeListenerC22181uo.h(viewOnAttachStateChangeListenerC22181uo.n());
            viewOnAttachStateChangeListenerC22181uo.J();
            viewOnAttachStateChangeListenerC22181uo.n = false;
        }
    }

    private final void l(C7631Sn6 c7631Sn6, InterfaceC14603iB2 interfaceC14603iB2) {
        List listT = c7631Sn6.t();
        int size = listT.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = listT.get(i2);
            if (n().a(((C7631Sn6) obj).o())) {
                interfaceC14603iB2.invoke(Integer.valueOf(i), obj);
                i++;
            }
        }
    }

    private final void p() {
        C20450s2 c20450s2;
        UA2 ua2;
        AbstractC20768sa3 abstractC20768sa3N = n();
        Object[] objArr = abstractC20768sa3N.c;
        long[] jArr = abstractC20768sa3N.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration semanticsConfigurationW = ((C8338Vn6) objArr[(i << 3) + i3]).b().w();
                        if (AbstractC13042fc3.d(AbstractC5719Kn6.a(semanticsConfigurationW, C8838Xn6.a.u()), Boolean.TRUE) && (c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationW, C5485Jn6.a.B())) != null && (ua2 = (UA2) c20450s2.a()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void r() {
        AutofillId autofillIdB;
        C19666qk1 c19666qk1 = this.c;
        if (c19666qk1 != null && Build.VERSION.SDK_INT >= 29 && (!this.d.isEmpty())) {
            List list = this.d;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C17302mk1 c17302mk1 = (C17302mk1) list.get(i);
                int i2 = d.a[c17302mk1.c().ordinal()];
                if (i2 == 1) {
                    KX7 kx7B = c17302mk1.b();
                    if (kx7B != null) {
                        c19666qk1.d(kx7B.h());
                    }
                } else if (i2 == 2 && (autofillIdB = c19666qk1.b(c17302mk1.a())) != null) {
                    c19666qk1.e(autofillIdB);
                }
            }
            c19666qk1.a();
            this.d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.h.h(C19938rB7.a);
    }

    public final void A() {
        this.f = b.b;
        F();
    }

    public final void B(ViewOnAttachStateChangeListenerC22181uo viewOnAttachStateChangeListenerC22181uo, LongSparseArray longSparseArray) {
        c.a.d(viewOnAttachStateChangeListenerC22181uo, longSparseArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0092 -> B:13:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.ViewOnAttachStateChangeListenerC22181uo.e
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.uo$e r0 = (ir.nasim.ViewOnAttachStateChangeListenerC22181uo.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.uo$e r0 = new ir.nasim.uo$e
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r2 = r0.b
            ir.nasim.CJ0 r2 = (ir.nasim.CJ0) r2
            java.lang.Object r5 = r0.a
            ir.nasim.uo r5 = (ir.nasim.ViewOnAttachStateChangeListenerC22181uo) r5
            ir.nasim.AbstractC10685c16.b(r10)
        L33:
            r10 = r2
            r2 = r5
            goto L54
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3e:
            java.lang.Object r2 = r0.b
            ir.nasim.CJ0 r2 = (ir.nasim.CJ0) r2
            java.lang.Object r5 = r0.a
            ir.nasim.uo r5 = (ir.nasim.ViewOnAttachStateChangeListenerC22181uo) r5
            ir.nasim.AbstractC10685c16.b(r10)
            goto L65
        L4a:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.nJ0 r10 = r9.h
            ir.nasim.CJ0 r10 = r10.iterator()
            r2 = r9
        L54:
            r0.a = r2
            r0.b = r10
            r0.e = r4
            java.lang.Object r5 = r10.a(r0)
            if (r5 != r1) goto L61
            return r1
        L61:
            r8 = r2
            r2 = r10
            r10 = r5
            r5 = r8
        L65:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L95
            r2.next()
            boolean r10 = r5.q()
            if (r10 == 0) goto L79
            r5.r()
        L79:
            boolean r10 = r5.n
            if (r10 != 0) goto L86
            r5.n = r4
            android.os.Handler r10 = r5.i
            java.lang.Runnable r6 = r5.o
            r10.post(r6)
        L86:
            long r6 = r5.e
            r0.a = r5
            r0.b = r2
            r0.e = r3
            java.lang.Object r10 = ir.nasim.HG1.b(r6, r0)
            if (r10 != r1) goto L33
            return r1
        L95:
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ViewOnAttachStateChangeListenerC22181uo.e(ir.nasim.rm1):java.lang.Object");
    }

    public final AbstractC20768sa3 n() {
        if (this.g) {
            this.g = false;
            this.j = AbstractC13192fo6.b(this.a.getSemanticsOwner());
            this.k = System.currentTimeMillis();
        }
        return this.j;
    }

    public final AndroidComposeView o() {
        return this.a;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
        this.c = (C19666qk1) this.b.invoke();
        H(-1, this.a.getSemanticsOwner().d());
        r();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
        I(this.a.getSemanticsOwner().d());
        r();
        this.c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.i.removeCallbacks(this.o);
        this.c = null;
    }

    public final boolean q() {
        return InterfaceC18484ok1.f0.a() && this.c != null;
    }

    public final void u() {
        this.f = b.a;
        i();
    }

    public final void v(long[] jArr, int[] iArr, Consumer consumer) {
        c.a.c(this, jArr, iArr, consumer);
    }

    public final void w() {
        this.f = b.a;
        p();
    }

    public final void x() {
        this.g = true;
        if (q()) {
            t();
        }
    }

    public final void z() {
        this.g = true;
        if (!q() || this.n) {
            return;
        }
        this.n = true;
        this.i.post(this.o);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
