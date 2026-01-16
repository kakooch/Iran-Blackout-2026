package ir.nasim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.C19528qW;
import ir.nasim.HW;
import ir.nasim.RW;
import ir.nasim.premium.ui.badge.BadgeView;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iW, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14802iW extends androidx.recyclerview.widget.q {
    private final InterfaceC18633oz3 f;
    private final UA2 g;

    /* renamed from: ir.nasim.iW$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OW.values().length];
            try {
                iArr[OW.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OW.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OW.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OW.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14802iW(InterfaceC18633oz3 interfaceC18633oz3, UA2 ua2) {
        super(new C22595vW());
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(ua2, "onBadgeSelect");
        this.f = interfaceC18633oz3;
        this.g = ua2;
    }

    private final void H(BadgeView badgeView, ViewGroup viewGroup) {
        C19528qW.b bVar = C19528qW.p;
        badgeView.setLayoutParams(new FrameLayout.LayoutParams(bVar.b() + (bVar.a() * 2), bVar.b() + (bVar.a() * 2), 16));
        badgeView.setPadding(bVar.a(), bVar.a(), bVar.a(), bVar.a());
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        badgeView.setShimmerEffect(bVar.e(context));
    }

    private final void I(TextView textView) {
        textView.setTextDirection(JF5.g() ? 4 : 3);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        Context context = textView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        textView.setTextColor(OY0.b(context, AbstractC21139tA5.n300));
        textView.setTextSize(1, 12.0f);
        textView.setTypeface(C6011Lu2.k());
        double d = 9;
        textView.setPadding((int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d), 0);
    }

    private final void J(ShimmerFrameLayout shimmerFrameLayout, ViewGroup viewGroup) {
        shimmerFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        C19528qW.b bVar = C19528qW.p;
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        shimmerFrameLayout.c(bVar.e(context));
        AppCompatImageView appCompatImageView = new AppCompatImageView(viewGroup.getContext());
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams((int) ((65 * AbstractC3742Cd6.c()) + 0.5d), (int) ((27 * AbstractC3742Cd6.c()) + 0.5d)));
        appCompatImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        appCompatImageView.setImageDrawable(AbstractC4043Dl1.f(appCompatImageView.getContext(), KB5.sticker_placeholder));
        appCompatImageView.setId(View.generateViewId());
        double d = 9;
        appCompatImageView.setPadding((int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d), 0);
        shimmerFrameLayout.addView(appCompatImageView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(RW rw, int i) {
        AbstractC13042fc3.i(rw, "holder");
        HW hw = (HW) A(i);
        AbstractC13042fc3.f(hw);
        rw.C0(hw);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public RW onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        int i2 = a.a[OW.b.a(i).ordinal()];
        if (i2 == 1) {
            TextView textView = new TextView(context);
            I(textView);
            return new RW.b(textView);
        }
        if (i2 == 2) {
            InterfaceC18633oz3 interfaceC18633oz3 = this.f;
            AbstractC13042fc3.f(context);
            BadgeView badgeView = new BadgeView(context, null, 0, 6, null);
            badgeView.setAutoRepeat();
            H(badgeView, viewGroup);
            return new RW.a(interfaceC18633oz3, badgeView, this.g);
        }
        if (i2 == 3) {
            AbstractC13042fc3.f(context);
            BadgeView badgeView2 = new BadgeView(context, null, 0, 6, null);
            H(badgeView2, viewGroup);
            return new RW.d(badgeView2);
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        ShimmerFrameLayout shimmerFrameLayout = new ShimmerFrameLayout(context);
        J(shimmerFrameLayout, viewGroup);
        return new RW.c(shimmerFrameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(RW rw) {
        AbstractC13042fc3.i(rw, "holder");
        super.onViewRecycled(rw);
        rw.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        OW ow;
        HW hw = (HW) A(i);
        if (hw instanceof HW.b) {
            ow = OW.c;
        } else if (hw instanceof HW.a) {
            ow = OW.d;
        } else if (hw instanceof HW.c.a) {
            ow = OW.e;
        } else {
            if (!(hw instanceof HW.c.b)) {
                throw new NoWhenBranchMatchedException();
            }
            ow = OW.f;
        }
        return ow.getNumber();
    }
}
