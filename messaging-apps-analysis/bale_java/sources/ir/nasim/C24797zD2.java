package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.O15;
import ir.nasim.gallery.widget.GalleryCheckBox;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.zD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24797zD2 extends RecyclerView.C {
    private final boolean u;
    private final C10182bD2 v;
    private final VI2 w;
    private final InterfaceC14603iB2 x;
    private final UA2 y;
    public static final a z = new a(null);
    public static final int A = 8;

    /* renamed from: ir.nasim.zD2$a */
    public static final class a {
        private a() {
        }

        public final C24797zD2 a(ViewGroup viewGroup, boolean z, VI2 vi2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(vi2, "glideRequests");
            AbstractC13042fc3.i(interfaceC14603iB2, "onItemClicked");
            AbstractC13042fc3.i(ua2, "photoViewerOpener");
            C10182bD2 c10182bD2C = C10182bD2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c10182bD2C, "inflate(...)");
            return new C24797zD2(z, c10182bD2C, vi2, interfaceC14603iB2, ua2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zD2$b */
    public static final class b extends A02 {
        final /* synthetic */ ImageView i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImageView imageView) {
            super(imageView);
            this.i = imageView;
        }

        @Override // ir.nasim.AbstractC16900m33, ir.nasim.InterfaceC21549tj7
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable, InterfaceC22855vv7 interfaceC22855vv7) {
            AbstractC13042fc3.i(drawable, "resource");
            this.i.setPadding(0, 0, 0, 0);
            q(drawable);
        }
    }

    public /* synthetic */ C24797zD2(boolean z2, C10182bD2 c10182bD2, VI2 vi2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, ED1 ed1) {
        this(z2, c10182bD2, vi2, interfaceC14603iB2, ua2);
    }

    private final void H0(Spannable spannable) {
        this.v.b.r(spannable);
    }

    private final AbstractC16900m33 J0(String str, Long l, boolean z2) {
        ImageView imageView = this.v.c;
        AbstractC13042fc3.f(imageView);
        int iC = AbstractC8943Xx1.c(35);
        imageView.setPadding(iC, iC, iC, iC);
        Context context = imageView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        Drawable drawableD = AbstractC6713Oq7.d(context, AbstractC16981mB5.gallery_bottom_sheet_place_holder_icon, AbstractC4043Dl1.c(imageView.getContext(), AbstractC24769zA5.color6_3));
        UI2 ui2Y0 = this.w.y(str).i(AbstractC23175wU1.d).y0(new LH0(), new P46(AbstractC8943Xx1.c(4)));
        if (z2) {
            ui2Y0 = ui2Y0.f0(drawableD);
        }
        UI2 ui2C0 = ui2Y0.c0(imageView.getWidth(), imageView.getHeight());
        if (l != null) {
            ui2C0 = ui2C0.s1(l.longValue());
        }
        AbstractC16900m33 abstractC16900m33 = (AbstractC16900m33) ui2C0.M0(T0(imageView));
        AbstractC13042fc3.h(abstractC16900m33, "with(...)");
        return abstractC16900m33;
    }

    private final void L0(final C21837uD2 c21837uD2) {
        final C10182bD2 c10182bD2 = this.v;
        ConstraintLayout root = c10182bD2.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.wD2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24797zD2.M0(this.a, c21837uD2, view);
            }
        });
        root.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.xD2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C24797zD2.N0(this.a, c21837uD2, view);
            }
        });
        c10182bD2.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yD2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24797zD2.O0(this.a, c21837uD2, c10182bD2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(C24797zD2 c24797zD2, C21837uD2 c21837uD2, View view) {
        AbstractC13042fc3.i(c24797zD2, "this$0");
        AbstractC13042fc3.i(c21837uD2, "$item");
        c24797zD2.y.invoke(c21837uD2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N0(C24797zD2 c24797zD2, C21837uD2 c21837uD2, View view) {
        AbstractC13042fc3.i(c24797zD2, "this$0");
        AbstractC13042fc3.i(c21837uD2, "$item");
        c24797zD2.y.invoke(c21837uD2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(C24797zD2 c24797zD2, C21837uD2 c21837uD2, C10182bD2 c10182bD2, View view) {
        AbstractC13042fc3.i(c24797zD2, "this$0");
        AbstractC13042fc3.i(c21837uD2, "$item");
        AbstractC13042fc3.i(c10182bD2, "$this_with");
        c24797zD2.x.invoke(c21837uD2, Boolean.valueOf(!c10182bD2.d.a()));
    }

    private final void Q0(Integer num, boolean z2) {
        this.v.d.setNumber(num != null ? Integer.valueOf(num.intValue() + 1) : null, z2);
    }

    private final void S0() {
        C10182bD2 c10182bD2 = this.v;
        ShimmerFrameLayout shimmerFrameLayout = c10182bD2.e;
        AbstractC13042fc3.f(shimmerFrameLayout);
        shimmerFrameLayout.setVisibility(0);
        shimmerFrameLayout.d(true);
        GalleryCheckBox galleryCheckBox = c10182bD2.d;
        AbstractC13042fc3.h(galleryCheckBox, "selectionCheckBox");
        galleryCheckBox.setVisibility(8);
    }

    private final AbstractC16900m33 T0(ImageView imageView) {
        return new b(imageView);
    }

    private final void U0() {
        C10182bD2 c10182bD2 = this.v;
        ShimmerFrameLayout shimmerFrameLayout = c10182bD2.e;
        AbstractC13042fc3.h(shimmerFrameLayout, "shimmerFrameLayout");
        if (shimmerFrameLayout.getVisibility() == 0) {
            ShimmerFrameLayout shimmerFrameLayout2 = c10182bD2.e;
            shimmerFrameLayout2.a();
            shimmerFrameLayout2.f();
            AbstractC13042fc3.f(shimmerFrameLayout2);
            shimmerFrameLayout2.setVisibility(8);
            GalleryCheckBox galleryCheckBox = c10182bD2.d;
            AbstractC13042fc3.h(galleryCheckBox, "selectionCheckBox");
            galleryCheckBox.setVisibility(this.u ? 0 : 8);
        }
    }

    public final void F0(C21837uD2 c21837uD2) {
        if (c21837uD2 == null) {
            S0();
            return;
        }
        U0();
        J0(c21837uD2.f(), c21837uD2.h(), true);
        H0(c21837uD2.b());
        Q0(c21837uD2.g(), false);
        L0(c21837uD2);
    }

    public final void P0(O15 o15) {
        AbstractC13042fc3.i(o15, "payload");
        if (o15 instanceof O15.a) {
            O15.a aVar = (O15.a) o15;
            J0(aVar.a(), aVar.b(), false);
        } else {
            if (!(o15 instanceof O15.b)) {
                throw new NoWhenBranchMatchedException();
            }
            Q0(((O15.b) o15).a(), true);
        }
    }

    public final void a() {
        C10182bD2 c10182bD2 = this.v;
        this.w.n(c10182bD2.c);
        c10182bD2.getRoot().setOnClickListener(null);
        c10182bD2.getRoot().setOnLongClickListener(null);
        c10182bD2.d.setOnClickListener(null);
        U0();
    }

    private C24797zD2(boolean z2, C10182bD2 c10182bD2, VI2 vi2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        super(c10182bD2.getRoot());
        this.u = z2;
        this.v = c10182bD2;
        this.w = vi2;
        this.x = interfaceC14603iB2;
        this.y = ua2;
        c10182bD2.b.setTypeface(C6011Lu2.k());
        GalleryCheckBox galleryCheckBox = c10182bD2.d;
        AbstractC13042fc3.h(galleryCheckBox, "selectionCheckBox");
        galleryCheckBox.setVisibility(z2 ? 0 : 8);
    }
}
