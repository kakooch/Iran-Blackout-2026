package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.GlideException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.QI2;

/* loaded from: classes5.dex */
public final class QI2 {
    public static final QI2 a = new QI2();

    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return QI2.b(null, this);
        }
    }

    public static final class b extends AbstractC4151Dx1 {
        final /* synthetic */ HE0 d;

        b(HE0 he0) {
            this.d = he0;
        }

        @Override // ir.nasim.InterfaceC21549tj7
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable, InterfaceC22855vv7 interfaceC22855vv7) {
            AbstractC13042fc3.i(drawable, "resource");
            AbstractC24549yo1.c(this.d, drawable);
        }

        @Override // ir.nasim.InterfaceC21549tj7
        public void g(Drawable drawable) {
            AbstractC24549yo1.c(this.d, null);
        }

        @Override // ir.nasim.AbstractC4151Dx1, ir.nasim.InterfaceC21549tj7
        public void k(Drawable drawable) {
            AbstractC24549yo1.c(this.d, null);
        }
    }

    public static final class c implements IT5 {
        final /* synthetic */ ImageView a;
        final /* synthetic */ SA2 b;

        c(ImageView imageView, SA2 sa2) {
            this.a = imageView;
            this.b = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SA2 sa2) {
            sa2.invoke();
        }

        @Override // ir.nasim.IT5
        public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
            AbstractC13042fc3.i(interfaceC21549tj7, "target");
            ImageView imageView = this.a;
            final SA2 sa2 = this.b;
            imageView.post(new Runnable() { // from class: ir.nasim.RI2
                @Override // java.lang.Runnable
                public final void run() {
                    QI2.c.c(sa2);
                }
            });
            return true;
        }

        @Override // ir.nasim.IT5
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(Drawable drawable, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
            AbstractC13042fc3.i(drawable, "resource");
            AbstractC13042fc3.i(obj, CommonUrlParts.MODEL);
            AbstractC13042fc3.i(enumC21012sz1, "dataSource");
            return false;
        }
    }

    private QI2() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.lang.String r4, ir.nasim.InterfaceC20295rm1 r5) {
        /*
            boolean r0 = r5 instanceof ir.nasim.QI2.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.QI2$a r0 = (ir.nasim.QI2.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.QI2$a r0 = new ir.nasim.QI2$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.a
            java.lang.String r4 = (java.lang.String) r4
            ir.nasim.AbstractC10685c16.b(r5)     // Catch: java.lang.Exception -> L94
            goto L91
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            r0.a = r4     // Catch: java.lang.Exception -> L94
            r0.c = r3     // Catch: java.lang.Exception -> L94
            ir.nasim.IE0 r5 = new ir.nasim.IE0     // Catch: java.lang.Exception -> L94
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)     // Catch: java.lang.Exception -> L94
            r5.<init>(r2, r3)     // Catch: java.lang.Exception -> L94
            r5.w()     // Catch: java.lang.Exception -> L94
            ir.nasim.Ko r2 = ir.nasim.C5721Ko.a     // Catch: java.lang.Exception -> L94
            android.content.Context r2 = r2.d()     // Catch: java.lang.Exception -> L94
            com.bumptech.glide.h r2 = com.bumptech.glide.b.t(r2)     // Catch: java.lang.Exception -> L94
            com.bumptech.glide.g r2 = r2.j()     // Catch: java.lang.Exception -> L94
            com.bumptech.glide.g r4 = r2.Z0(r4)     // Catch: java.lang.Exception -> L94
            ir.nasim.Na0 r4 = r4.e()     // Catch: java.lang.Exception -> L94
            com.bumptech.glide.g r4 = (com.bumptech.glide.g) r4     // Catch: java.lang.Exception -> L94
            r2 = 16500(0x4074, float:2.3121E-41)
            ir.nasim.Na0 r4 = r4.r0(r2)     // Catch: java.lang.Exception -> L94
            com.bumptech.glide.g r4 = (com.bumptech.glide.g) r4     // Catch: java.lang.Exception -> L94
            r2 = 1060320051(0x3f333333, float:0.7)
            ir.nasim.Na0 r4 = r4.o0(r2)     // Catch: java.lang.Exception -> L94
            com.bumptech.glide.g r4 = (com.bumptech.glide.g) r4     // Catch: java.lang.Exception -> L94
            ir.nasim.H02 r2 = ir.nasim.H02.k()     // Catch: java.lang.Exception -> L94
            com.bumptech.glide.g r4 = r4.i1(r2)     // Catch: java.lang.Exception -> L94
            ir.nasim.QI2$b r2 = new ir.nasim.QI2$b     // Catch: java.lang.Exception -> L94
            r2.<init>(r5)     // Catch: java.lang.Exception -> L94
            r4.M0(r2)     // Catch: java.lang.Exception -> L94
            java.lang.Object r5 = r5.t()     // Catch: java.lang.Exception -> L94
            java.lang.Object r4 = ir.nasim.AbstractC13660gc3.e()     // Catch: java.lang.Exception -> L94
            if (r5 != r4) goto L8e
            ir.nasim.WA1.c(r0)     // Catch: java.lang.Exception -> L94
        L8e:
            if (r5 != r1) goto L91
            return r1
        L91:
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch: java.lang.Exception -> L94
            goto L95
        L94:
            r5 = 0
        L95:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QI2.b(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public static final com.bumptech.glide.g c(String str, Context context, int i, int i2) {
        AbstractC13042fc3.i(str, "string");
        AbstractC13042fc3.i(context, "context");
        UI2 ui2U1 = OI2.b(C5721Ko.a.d()).y(str).e().c0(i2, i).o0(0.7f).i1(H02.k());
        AbstractC13042fc3.h(ui2U1, "transition(...)");
        return ui2U1;
    }

    public static final void e(int i, ImageView imageView) {
        AbstractC13042fc3.i(imageView, "imageView");
        OI2.b(C5721Ko.a.d()).L().W0(Integer.valueOf(i)).Q0(imageView);
    }

    public static final void f(String str, ImageView imageView) {
        AbstractC13042fc3.i(str, "string");
        AbstractC13042fc3.i(imageView, "imageView");
        OI2.b(C5721Ko.a.d()).L().Z0(str).Q0(imageView);
    }

    public static final com.bumptech.glide.g g(Drawable drawable, Context context, int i, int i2) {
        AbstractC13042fc3.i(drawable, "drawable");
        AbstractC13042fc3.i(context, "context");
        UI2 ui2M1 = OI2.b(C5721Ko.a.d()).N(drawable).c0(i2, i).l1().i1(H02.k()).o0(0.7f);
        AbstractC13042fc3.h(ui2M1, "sizeMultiplier(...)");
        return ui2M1;
    }

    public static final com.bumptech.glide.g h(Uri uri, Context context, int i, int i2) {
        AbstractC13042fc3.i(uri, "uri");
        AbstractC13042fc3.i(context, "context");
        UI2 ui2M1 = OI2.b(C5721Ko.a.d()).O(uri).c0(i2, i).i1(H02.k()).o0(0.7f);
        AbstractC13042fc3.h(ui2M1, "sizeMultiplier(...)");
        return ui2M1;
    }

    public static final com.bumptech.glide.g i(String str, Context context, int i, int i2) {
        AbstractC13042fc3.i(str, "string");
        AbstractC13042fc3.i(context, "context");
        UI2 ui2M1 = OI2.b(C5721Ko.a.d()).y(str).c0(i2, i).i1(H02.k()).o0(0.7f);
        AbstractC13042fc3.h(ui2M1, "sizeMultiplier(...)");
        return ui2M1;
    }

    public static final void j(int i, ImageView imageView) {
        AbstractC13042fc3.i(imageView, "imageView");
        OI2.b(C5721Ko.a.d()).w(Integer.valueOf(i)).Q0(imageView);
    }

    public static final void k(Bitmap bitmap, ImageView imageView) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        AbstractC13042fc3.i(imageView, "imageView");
        OI2.b(C5721Ko.a.d()).M(bitmap).Q0(imageView);
    }

    public static final void l(Uri uri, ImageView imageView) {
        AbstractC13042fc3.i(uri, "uri");
        AbstractC13042fc3.i(imageView, "imageView");
        OI2.b(C5721Ko.a.d()).O(uri).Q0(imageView);
    }

    public static final void n(String str, ImageView imageView) {
        AbstractC13042fc3.i(str, "string");
        AbstractC13042fc3.i(imageView, "imageView");
        p(str, imageView, null, 4, null);
    }

    public static final void o(String str, ImageView imageView, Integer num) {
        AbstractC13042fc3.i(str, "string");
        AbstractC13042fc3.i(imageView, "imageView");
        UI2 ui2R = OI2.b(C5721Ko.a.d()).y(str);
        if (num != null) {
            ui2R.e0(num.intValue());
        }
        ui2R.Q0(imageView);
    }

    public static /* synthetic */ void p(String str, ImageView imageView, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        o(str, imageView, num);
    }

    public static final void u(ImageView imageView, String str, SA2 sa2) {
        AbstractC13042fc3.i(imageView, "<this>");
        AbstractC13042fc3.i(str, "string");
        UI2 ui2R = OI2.b(C5721Ko.a.d()).y(str);
        if (sa2 != null) {
            ui2R.S0(new c(imageView, sa2));
        }
        ui2R.c0(imageView.getWidth(), imageView.getHeight()).Q0(imageView);
    }

    public static /* synthetic */ void v(ImageView imageView, String str, SA2 sa2, int i, Object obj) {
        if ((i & 2) != 0) {
            sa2 = null;
        }
        u(imageView, str, sa2);
    }

    public final void a(ImageView imageView) {
        AbstractC13042fc3.i(imageView, "<this>");
        OI2.b(C5721Ko.a.d()).n(imageView);
    }

    public final UI2 d(Bitmap bitmap, int i, int i2) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        UI2 ui2U1 = OI2.b(C5721Ko.a.d()).M(bitmap).e().c0(i2, i).o0(0.7f).i1(H02.k());
        AbstractC13042fc3.h(ui2U1, "transition(...)");
        return ui2U1;
    }

    public final void m(ImageView imageView, String str) {
        AbstractC13042fc3.i(imageView, "<this>");
        AbstractC13042fc3.i(str, "string");
        OI2.b(C5721Ko.a.d()).y(str).Q0(imageView);
    }

    public final void q(ImageView imageView, Bitmap bitmap, int i, int i2) {
        AbstractC13042fc3.i(imageView, "<this>");
        AbstractC13042fc3.i(bitmap, "bitmap");
        OI2.b(C5721Ko.a.d()).M(bitmap).b(C20107rU5.B0(new C5191Ih0(i, i2))).Q0(imageView);
    }

    public final void r(ImageView imageView, byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(imageView, "<this>");
        AbstractC13042fc3.i(bArr, "bytes");
        OI2.b(C5721Ko.a.d()).z(bArr).b(C20107rU5.B0(new C5191Ih0(i, i2))).Q0(imageView);
    }

    public final void s(ImageView imageView, int i, float f, boolean z) {
        AbstractC13042fc3.i(imageView, "<this>");
        ((com.bumptech.glide.g) com.bumptech.glide.b.t(C5721Ko.a.d()).w(Integer.valueOf(i)).u0(new C5677Kj0(f, z))).Q0(imageView);
    }

    public final void t(ImageView imageView, String str, float f, boolean z) {
        AbstractC13042fc3.i(imageView, "<this>");
        AbstractC13042fc3.i(str, "string");
        ((com.bumptech.glide.g) com.bumptech.glide.b.t(C5721Ko.a.d()).y(str).u0(new C5677Kj0(f, z))).Q0(imageView);
    }
}
