package ir.nasim;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.GlideException;
import com.facebook.shimmer.ShimmerFrameLayout;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.InterfaceC13730gj3;

/* loaded from: classes5.dex */
public final class SH3 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final ImageView a;
    private final ShimmerFrameLayout b;
    private InterfaceC13730gj3 c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements IT5 {
        b() {
        }

        @Override // ir.nasim.IT5
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(Drawable drawable, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
            AbstractC13042fc3.i(drawable, "resource");
            AbstractC13042fc3.i(obj, CommonUrlParts.MODEL);
            AbstractC13042fc3.i(enumC21012sz1, "dataSource");
            ShimmerFrameLayout shimmerFrameLayout = SH3.this.b;
            shimmerFrameLayout.a();
            shimmerFrameLayout.f();
            return false;
        }

        @Override // ir.nasim.IT5
        public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
            AbstractC13042fc3.i(interfaceC21549tj7, "target");
            C19406qI3.a("LocationBinder", glideException != null ? glideException.getMessage() : null, new Object[0]);
            return false;
        }
    }

    public SH3(ImageView imageView, ShimmerFrameLayout shimmerFrameLayout) {
        AbstractC13042fc3.i(imageView, "imageView");
        AbstractC13042fc3.i(shimmerFrameLayout, "shimmerLayout");
        this.a = imageView;
        this.b = shimmerFrameLayout;
    }

    private final void c(String str) {
        OI2.b(C5721Ko.a.d()).y(str).i1(H02.k()).i(AbstractC23175wU1.d).S0(new b()).Q0(this.a);
    }

    public final void b(RH3 rh3) {
        AbstractC13042fc3.i(rh3, "location");
        this.b.e();
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        this.a.setBackground(new ColorDrawable(OY0.b(context, AbstractC21139tA5.bubble_third)));
        c(rh3.b());
    }

    public final void d() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.c = null;
        ShimmerFrameLayout shimmerFrameLayout = this.b;
        shimmerFrameLayout.d(false);
        shimmerFrameLayout.f();
        OI2.b(C5721Ko.a.d()).n(this.a);
    }
}
