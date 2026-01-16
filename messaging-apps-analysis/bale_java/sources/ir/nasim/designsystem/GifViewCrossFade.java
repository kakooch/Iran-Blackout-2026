package ir.nasim.designsystem;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C20107rU5;
import ir.nasim.C5191Ih0;
import ir.nasim.C8610Ws;
import ir.nasim.QI2;
import ir.nasim.designsystem.GifViewCrossFade;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\b2\b\b\u0001\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\"\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J+\u0010-\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\b2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b/\u0010'J-\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020$¢\u0006\u0004\b/\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R$\u0010<\u001a\u0002052\u0006\u00109\u001a\u0002058\u0006@BX\u0086.¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010>R\u0016\u0010A\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010F¨\u0006H"}, d2 = {"Lir/nasim/designsystem/GifViewCrossFade;", "Landroid/widget/ViewSwitcher;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "e", "()V", "d", "i", "f", "j", "b", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "c", "destroyDrawingCache", "buildDrawingCache", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "color", "setBackgroundColor", "(I)V", "Lir/nasim/Ws;", "", "autoStart", "g", "(Lir/nasim/Ws;Z)V", "", "radius", "setCornerRadius", "(F)V", "Landroid/view/View;", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "setCorners", "topRight", "topLeft", "bottomRight", "bottomLeft", "(FFFF)V", "Lcom/google/android/material/imageview/ShapeableImageView;", "a", "Lcom/google/android/material/imageview/ShapeableImageView;", "mainImageView", "value", "getThumbnailImageView", "()Lcom/google/android/material/imageview/ShapeableImageView;", "thumbnailImageView", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "switchAction", "Z", "isThumbnailLoaded", "", "J", "animDuration", "Lir/nasim/rU5;", "Lir/nasim/rU5;", "blurRequest", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class GifViewCrossFade extends ViewSwitcher {

    /* renamed from: a, reason: from kotlin metadata */
    private ShapeableImageView mainImageView;

    /* renamed from: b, reason: from kotlin metadata */
    private ShapeableImageView thumbnailImageView;

    /* renamed from: c, reason: from kotlin metadata */
    private Runnable switchAction;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isThumbnailLoaded;

    /* renamed from: e, reason: from kotlin metadata */
    private long animDuration;

    /* renamed from: f, reason: from kotlin metadata */
    private final C20107rU5 blurRequest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifViewCrossFade(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.animDuration = 100L;
        if (!isInEditMode()) {
            i();
            b();
        }
        C20107rU5 c20107rU5B0 = C20107rU5.B0(new C5191Ih0(20, 4));
        AbstractC13042fc3.h(c20107rU5B0, "bitmapTransform(...)");
        this.blurRequest = c20107rU5B0;
    }

    private final void b() {
        ShapeableImageView shapeableImageView = new ShapeableImageView(getContext());
        addView(shapeableImageView);
        this.thumbnailImageView = shapeableImageView;
        ShapeableImageView shapeableImageView2 = new ShapeableImageView(getContext());
        addView(shapeableImageView2);
        this.mainImageView = shapeableImageView2;
    }

    private final void d() {
        QI2 qi2 = QI2.a;
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        qi2.a(shapeableImageView);
    }

    private final void e() {
        QI2.a.a(getThumbnailImageView());
        this.isThumbnailLoaded = false;
    }

    private final void f() {
        setInAnimation(null);
        setOutAnimation(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GifViewCrossFade gifViewCrossFade) throws Resources.NotFoundException {
        AbstractC13042fc3.i(gifViewCrossFade, "this$0");
        gifViewCrossFade.j();
    }

    private final void i() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        animationLoadAnimation.setDuration(this.animDuration);
        setInAnimation(animationLoadAnimation);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
        animationLoadAnimation2.setDuration(this.animDuration);
        setOutAnimation(animationLoadAnimation2);
    }

    private final void j() throws Resources.NotFoundException {
        if (this.isThumbnailLoaded) {
            i();
        } else {
            f();
        }
        setDisplayedChild(1);
    }

    @Override // android.widget.ViewSwitcher, android.widget.ViewAnimator, android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (child != null) {
            child.setVisibility(getChildCount() == 1 ? 0 : 4);
        }
    }

    @Override // android.view.View
    public void buildDrawingCache() {
        super.buildDrawingCache();
        getThumbnailImageView().buildDrawingCache();
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.buildDrawingCache();
    }

    public final void c() {
        e();
        d();
        this.switchAction = null;
    }

    @Override // android.view.View
    public void destroyDrawingCache() {
        super.destroyDrawingCache();
        if (isInEditMode()) {
            return;
        }
        getThumbnailImageView().destroyDrawingCache();
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.destroyDrawingCache();
    }

    public final void g(C8610Ws drawable, boolean autoStart) throws InterruptedException {
        AbstractC13042fc3.i(drawable, "drawable");
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        drawable.S(shapeableImageView);
        if (autoStart) {
            drawable.start();
        }
        drawable.setBounds(0, 0, 40, 40);
        shapeableImageView.setImageDrawable(drawable);
        Runnable runnable = new Runnable() { // from class: ir.nasim.YH2
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                GifViewCrossFade.h(this.a);
            }
        };
        this.switchAction = runnable;
        shapeableImageView.post(runnable);
    }

    public final ShapeableImageView getThumbnailImageView() {
        ShapeableImageView shapeableImageView = this.thumbnailImageView;
        if (shapeableImageView != null) {
            return shapeableImageView;
        }
        AbstractC13042fc3.y("thumbnailImageView");
        return null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        getThumbnailImageView().setBackgroundColor(color);
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setBackgroundColor(color);
    }

    public final void setCornerRadius(float radius) {
        ShapeableImageView shapeableImageView = this.mainImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        ShapeableImageView shapeableImageView3 = this.mainImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("mainImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        shapeableImageView.setShapeAppearanceModel(shapeableImageView2.getShapeAppearanceModel().v().o(radius).m());
        getThumbnailImageView().setShapeAppearanceModel(getThumbnailImageView().getShapeAppearanceModel().v().o(radius).m());
    }

    public final void setCorners(float radius) {
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel().v().q(0, radius).m());
        ShapeableImageView thumbnailImageView = getThumbnailImageView();
        thumbnailImageView.setShapeAppearanceModel(thumbnailImageView.getShapeAppearanceModel().v().q(0, radius).m());
    }

    public final void setImageDrawable(Drawable drawable) {
        getThumbnailImageView().setImageDrawable(drawable);
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setImageDrawable(drawable);
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        AbstractC13042fc3.i(scaleType, "scaleType");
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setScaleType(scaleType);
        getThumbnailImageView().setScaleType(scaleType);
    }

    public final void setCorners(float topRight, float topLeft, float bottomRight, float bottomLeft) {
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel().v().J(0, topRight).E(0, topLeft).y(0, bottomRight).t(0, bottomLeft).m());
        ShapeableImageView thumbnailImageView = getThumbnailImageView();
        thumbnailImageView.setShapeAppearanceModel(thumbnailImageView.getShapeAppearanceModel().v().J(0, topRight).E(0, topLeft).y(0, bottomRight).t(0, bottomLeft).m());
    }
}
