package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.NK3;
import java.io.IOException;
import java.io.InputStream;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public abstract class WM5 {

    static final class a implements WK3 {
        final /* synthetic */ HE0 a;

        a(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.WK3
        public final void a(Object obj) {
            if (this.a.p()) {
                return;
            }
            this.a.resumeWith(C9475a16.b(obj));
        }
    }

    static final class b implements WK3 {
        final /* synthetic */ HE0 a;

        b(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.WK3
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(Throwable th) {
            if (this.a.p()) {
                return;
            }
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(th);
            he0.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C23677xK3 c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C23677xK3 c23677xK3, Context context, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c23677xK3;
            this.d = context;
            this.e = str;
            this.f = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            for (C8388Vt2 c8388Vt2 : this.c.g().values()) {
                Context context = this.d;
                AbstractC13042fc3.f(c8388Vt2);
                WM5.q(context, c8388Vt2, this.e, this.f);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C23677xK3 c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C23677xK3 c23677xK3, Context context, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c23677xK3;
            this.d = context;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            for (VK3 vk3 : this.c.j().values()) {
                AbstractC13042fc3.f(vk3);
                WM5.o(vk3);
                WM5.p(this.d, vk3, this.e);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return WM5.m(null, null, null, null, null, null, this);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(false);
        }

        public final Object n(int i, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n(((Number) obj).intValue(), (Throwable) obj2, (InterfaceC20295rm1) obj3);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        int d;
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ Context f;
        final /* synthetic */ NK3 g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;
        final /* synthetic */ String j;
        final /* synthetic */ String k;
        final /* synthetic */ InterfaceC9102Ym4 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC15796kB2 interfaceC15796kB2, Context context, NK3 nk3, String str, String str2, String str3, String str4, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC15796kB2;
            this.f = context;
            this.g = nk3;
            this.h = str;
            this.i = str2;
            this.j = str3;
            this.k = str4;
            this.l = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        
            if (((java.lang.Boolean) r13).booleanValue() == false) goto L29;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:26:0x0086). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2e
                if (r1 == r3) goto L24
                if (r1 != r2) goto L1c
                int r1 = r12.c
                java.lang.Object r4 = r12.b
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                ir.nasim.AbstractC10685c16.b(r13)     // Catch: java.lang.Throwable -> L18
                goto L86
            L18:
                r13 = move-exception
                r4 = r13
                goto L92
            L1c:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L24:
                int r1 = r12.c
                java.lang.Object r4 = r12.b
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                ir.nasim.AbstractC10685c16.b(r13)
                goto L58
            L2e:
                ir.nasim.AbstractC10685c16.b(r13)
                r13 = 0
                r1 = 0
                r4 = r13
            L34:
                ir.nasim.Ym4 r13 = r12.l
                ir.nasim.MK3 r13 = ir.nasim.WM5.g(r13)
                boolean r13 = r13.B()
                if (r13 != 0) goto L94
                if (r1 == 0) goto L60
                ir.nasim.kB2 r13 = r12.e
                java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r1)
                ir.nasim.AbstractC13042fc3.f(r4)
                r12.b = r4
                r12.c = r1
                r12.d = r3
                java.lang.Object r13 = r13.q(r5, r4, r12)
                if (r13 != r0) goto L58
                return r0
            L58:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto L94
            L60:
                android.content.Context r5 = r12.f     // Catch: java.lang.Throwable -> L18
                ir.nasim.NK3 r6 = r12.g     // Catch: java.lang.Throwable -> L18
                java.lang.String r13 = r12.h     // Catch: java.lang.Throwable -> L18
                java.lang.String r7 = ir.nasim.WM5.b(r13)     // Catch: java.lang.Throwable -> L18
                java.lang.String r13 = r12.i     // Catch: java.lang.Throwable -> L18
                java.lang.String r8 = ir.nasim.WM5.b(r13)     // Catch: java.lang.Throwable -> L18
                java.lang.String r13 = r12.j     // Catch: java.lang.Throwable -> L18
                java.lang.String r9 = ir.nasim.WM5.a(r13)     // Catch: java.lang.Throwable -> L18
                java.lang.String r10 = r12.k     // Catch: java.lang.Throwable -> L18
                r12.b = r4     // Catch: java.lang.Throwable -> L18
                r12.c = r1     // Catch: java.lang.Throwable -> L18
                r12.d = r2     // Catch: java.lang.Throwable -> L18
                r11 = r12
                java.lang.Object r13 = ir.nasim.WM5.c(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L18
                if (r13 != r0) goto L86
                return r0
            L86:
                ir.nasim.xK3 r13 = (ir.nasim.C23677xK3) r13     // Catch: java.lang.Throwable -> L18
                ir.nasim.Ym4 r5 = r12.l     // Catch: java.lang.Throwable -> L18
                ir.nasim.MK3 r5 = ir.nasim.WM5.g(r5)     // Catch: java.lang.Throwable -> L18
                r5.f(r13)     // Catch: java.lang.Throwable -> L18
                goto L34
            L92:
                int r1 = r1 + r3
                goto L34
            L94:
                ir.nasim.Ym4 r13 = r12.l
                ir.nasim.MK3 r13 = ir.nasim.WM5.g(r13)
                boolean r13 = r13.A()
                if (r13 != 0) goto Lab
                if (r4 == 0) goto Lab
                ir.nasim.Ym4 r13 = r12.l
                ir.nasim.MK3 r13 = ir.nasim.WM5.g(r13)
                r13.i(r4)
            Lab:
                ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WM5.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private static final Object h(com.airbnb.lottie.s sVar, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        sVar.d(new a(ie0)).c(new b(ie0));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(String str) {
        if (AbstractC20762sZ6.n0(str) || AbstractC20153rZ6.S(str, Separators.DOT, false, 2, null)) {
            return str;
        }
        return Separators.DOT + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(String str) {
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return null;
        }
        if (AbstractC20762sZ6.b0(str, '/', false, 2, null)) {
            return str;
        }
        return str + Separators.SLASH;
    }

    private static final Object k(Context context, C23677xK3 c23677xK3, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (c23677xK3.g().isEmpty()) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(C12366eV1.b(), new c(c23677xK3, context, str, str2, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private static final Object l(Context context, C23677xK3 c23677xK3, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!c23677xK3.r()) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(C12366eV1.b(), new d(c23677xK3, context, str, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m(android.content.Context r6, ir.nasim.NK3 r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WM5.m(android.content.Context, ir.nasim.NK3, java.lang.String, java.lang.String, java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    private static final com.airbnb.lottie.s n(Context context, NK3 nk3, String str, boolean z) {
        if (nk3 instanceof NK3.b) {
            return AbstractC13042fc3.d(str, "__LottieInternalDefaultCacheKey__") ? JK3.B(context, ((NK3.b) nk3).f()) : JK3.C(context, ((NK3.b) nk3).f(), str);
        }
        if (!(nk3 instanceof NK3.a)) {
            throw new NoWhenBranchMatchedException();
        }
        if (AbstractC13042fc3.d(str, "__LottieInternalDefaultCacheKey__")) {
            str = String.valueOf(((NK3.a) nk3).f().hashCode());
        }
        return JK3.z(((NK3.a) nk3).f(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(VK3 vk3) {
        if (vk3.b() != null) {
            return;
        }
        String strC = vk3.c();
        AbstractC13042fc3.f(strC);
        if (!AbstractC20153rZ6.S(strC, "data:", false, 2, null) || AbstractC20762sZ6.l0(strC, "base64,", 0, false, 6, null) <= 0) {
            return;
        }
        try {
            String strSubstring = strC.substring(AbstractC20762sZ6.k0(strC, ',', 0, false, 6, null) + 1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            byte[] bArrDecode = Base64.decode(strSubstring, 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            vk3.g(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
        } catch (IllegalArgumentException e2) {
            JI3.d("data URL did not have correct base64 format.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Context context, VK3 vk3, String str) throws IOException {
        if (vk3.b() != null || str == null) {
            return;
        }
        String strC = vk3.c();
        try {
            InputStream inputStreamOpen = context.getAssets().open(str + strC);
            AbstractC13042fc3.f(inputStreamOpen);
            Bitmap bitmapDecodeStream = null;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
            } catch (IllegalArgumentException e2) {
                JI3.d("Unable to decode image.", e2);
            }
            if (bitmapDecodeStream != null) {
                vk3.g(AbstractC16500lN7.m(bitmapDecodeStream, vk3.f(), vk3.d()));
            }
        } catch (IOException e3) {
            JI3.d("Unable to open asset.", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Context context, C8388Vt2 c8388Vt2, String str, String str2) {
        String str3 = str + c8388Vt2.a() + str2;
        try {
            Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str3);
            try {
                AbstractC13042fc3.f(typefaceCreateFromAsset);
                String strC = c8388Vt2.c();
                AbstractC13042fc3.h(strC, "getStyle(...)");
                c8388Vt2.e(t(typefaceCreateFromAsset, strC));
            } catch (Exception e2) {
                JI3.b("Failed to create " + c8388Vt2.a() + " typeface with style=" + c8388Vt2.c() + "!", e2);
            }
        } catch (Exception e3) {
            JI3.b("Failed to find typeface in assets with path " + str3 + Separators.DOT, e3);
        }
    }

    public static final LK3 r(NK3 nk3, String str, String str2, String str3, String str4, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(nk3, "spec");
        interfaceC22053ub1.A(-1248473602);
        String str5 = (i2 & 2) != 0 ? null : str;
        String str6 = (i2 & 4) != 0 ? "fonts/" : str2;
        String str7 = (i2 & 8) != 0 ? ".ttf" : str3;
        String str8 = (i2 & 16) != 0 ? "__LottieInternalDefaultCacheKey__" : str4;
        InterfaceC15796kB2 fVar = (i2 & 32) != 0 ? new f(null) : interfaceC15796kB2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1248473602, i, -1, "com.airbnb.lottie.compose.rememberLottieComposition (rememberLottieComposition.kt:83)");
        }
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        interfaceC22053ub1.A(1388713953);
        int i3 = i & 14;
        int i4 = i3 ^ 6;
        boolean z = (i4 > 4 && interfaceC22053ub1.V(nk3)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC13472gH6.d(new MK3(), null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        interfaceC22053ub1.U();
        interfaceC22053ub1.A(1388714244);
        boolean z2 = ((i4 > 4 && interfaceC22053ub1.V(nk3)) || (i & 6) == 4) | ((((57344 & i) ^ 24576) > 16384 && interfaceC22053ub1.V(str8)) || (i & 24576) == 16384);
        Object objB2 = interfaceC22053ub1.B();
        if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = n(context, nk3, str8, true);
            interfaceC22053ub1.s(objB2);
        }
        interfaceC22053ub1.U();
        AbstractC10721c52.f(nk3, str8, new g(fVar, context, nk3, str5, str6, str7, str8, interfaceC9102Ym4, null), interfaceC22053ub1, i3 | 512 | ((i >> 9) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
        MK3 mk3S = s(interfaceC9102Ym4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return mk3S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MK3 s(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (MK3) interfaceC9102Ym4.getValue();
    }

    private static final Typeface t(Typeface typeface, String str) {
        int i = 0;
        boolean zX = AbstractC20762sZ6.X(str, "Italic", false, 2, null);
        boolean zX2 = AbstractC20762sZ6.X(str, "Bold", false, 2, null);
        if (zX && zX2) {
            i = 3;
        } else if (zX) {
            i = 2;
        } else if (zX2) {
            i = 1;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
