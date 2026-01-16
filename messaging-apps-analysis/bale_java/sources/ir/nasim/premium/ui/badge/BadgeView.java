package ir.nasim.premium.ui.badge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.facebook.shimmer.a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC22039uZ6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.ED1;
import ir.nasim.KB5;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J%\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0010J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u0010J\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0010J\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u0010R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#¨\u0006%"}, d2 = {"Lir/nasim/premium/ui/badge/BadgeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/facebook/shimmer/a;", "sh", "Lir/nasim/rB7;", "setShimmerEffect", "(Lcom/facebook/shimmer/a;)V", "c", "()V", "e", "", "json", "w", "h", "a", "(Ljava/lang/String;II)V", "b", "d", "setAutoRepeat", "f", "Lir/nasim/tgwidgets/editor/ui/Components/RLottieImageView;", "Lir/nasim/tgwidgets/editor/ui/Components/RLottieImageView;", "ivBadge", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "ivShimmer", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "shimmerLayout", "premium_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class BadgeView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final RLottieImageView ivBadge;

    /* renamed from: b, reason: from kotlin metadata */
    private final AppCompatImageView ivShimmer;

    /* renamed from: c, reason: from kotlin metadata */
    private final ShimmerFrameLayout shimmerLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BadgeView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final void a(String json, int w, int h) {
        AbstractC13042fc3.i(json, "json");
        this.ivBadge.setAnimationWithName(json, AbstractC22039uZ6.A1(json, 10), w, h);
    }

    public final void b() {
        this.ivBadge.f();
    }

    public final void c() {
        this.ivBadge.setVisibility(8);
        this.shimmerLayout.setVisibility(0);
        this.shimmerLayout.e();
    }

    public final void d() {
        this.ivBadge.g();
    }

    public final void e() {
        this.shimmerLayout.f();
        this.ivBadge.setVisibility(0);
        this.shimmerLayout.setVisibility(8);
    }

    public final void f() throws InterruptedException {
        this.ivBadge.d();
    }

    public final void setAutoRepeat() {
        this.ivBadge.setAutoRepeat(true);
    }

    public final void setShimmerEffect(a sh) {
        AbstractC13042fc3.i(sh, "sh");
        this.shimmerLayout.c(sh);
        this.shimmerLayout.e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ BadgeView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        RLottieImageView rLottieImageView = new RLottieImageView(context, attributeSet, i);
        rLottieImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        rLottieImageView.setScaleType(scaleType);
        rLottieImageView.setId(View.generateViewId());
        rLottieImageView.setVisibility(8);
        this.ivBadge = rLottieImageView;
        AppCompatImageView appCompatImageView = new AppCompatImageView(context, attributeSet, i);
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        appCompatImageView.setScaleType(scaleType);
        appCompatImageView.setImageDrawable(AbstractC4043Dl1.f(context, KB5.sticker_placeholder));
        appCompatImageView.setId(View.generateViewId());
        this.ivShimmer = appCompatImageView;
        ShimmerFrameLayout shimmerFrameLayout = new ShimmerFrameLayout(context);
        shimmerFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        shimmerFrameLayout.addView(appCompatImageView);
        this.shimmerLayout = shimmerFrameLayout;
        addView(rLottieImageView);
        addView(shimmerFrameLayout);
    }
}
