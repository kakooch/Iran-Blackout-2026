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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.material.imageview.ShapeableImageView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C20107rU5;
import ir.nasim.C5721Ko;
import ir.nasim.C8610Ws;
import ir.nasim.ED1;
import ir.nasim.EnumC21012sz1;
import ir.nasim.IT5;
import ir.nasim.InterfaceC21549tj7;
import ir.nasim.OI2;
import ir.nasim.QI2;
import ir.nasim.UI2;
import ir.nasim.VI2;
import ir.nasim.designsystem.ImageViewCrossFade;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002HKB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJI\u0010\u0017\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\nJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0017¢\u0006\u0004\b\"\u0010\nJ\u000f\u0010#\u001a\u00020\bH\u0017¢\u0006\u0004\b#\u0010\nJ\u0017\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020\b2\b\b\u0001\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b.\u0010/J\u001d\u00102\u001a\u00020\u001e2\u0006\u0010$\u001a\u0002002\u0006\u00101\u001a\u00020\u001e¢\u0006\u0004\b2\u00103J\u0015\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J+\u0010=\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\b2\u0006\u00105\u001a\u000204¢\u0006\u0004\b?\u00107J-\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u0002042\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u0002042\u0006\u0010C\u001a\u000204¢\u0006\u0004\b?\u0010DJ\u0019\u0010E\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010IR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010R¨\u0006T"}, d2 = {"Lir/nasim/designsystem/ImageViewCrossFade;", "Landroid/widget/ViewSwitcher;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "h", "()V", "g", "Landroid/widget/ImageView;", "imageView", "Lir/nasim/IT5;", "Landroid/graphics/drawable/Drawable;", "listener", "", "imageUrl", "", "imageBytes", "Lir/nasim/rU5;", "options", "l", "(Landroid/widget/ImageView;Lir/nasim/IT5;Ljava/lang/String;[BLir/nasim/rU5;)V", "p", "i", "q", "e", "f", "", "isPostToStoryCapture", "setIsPostToStoryCapture", "(Z)V", "destroyDrawingCache", "buildDrawingCache", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "color", "setBackgroundColor", "(I)V", "byteArray", "o", "([BLir/nasim/rU5;)V", "m", "(Ljava/lang/String;Lir/nasim/rU5;)V", "Lir/nasim/Ws;", "autoStart", "j", "(Lir/nasim/Ws;Z)Z", "", "radius", "setCornerRadius", "(F)V", "Landroid/view/View;", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "setCorners", "topRight", "topLeft", "bottomRight", "bottomLeft", "(FFFF)V", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "Lcom/google/android/material/imageview/ShapeableImageView;", "a", "Lcom/google/android/material/imageview/ShapeableImageView;", "mainImageView", "b", "thumbnailImageView", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "switchAction", "d", "Z", "isThumbnailLoaded", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ImageViewCrossFade extends ViewSwitcher {
    public static final int g = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private ShapeableImageView mainImageView;

    /* renamed from: b, reason: from kotlin metadata */
    private ShapeableImageView thumbnailImageView;

    /* renamed from: c, reason: from kotlin metadata */
    private Runnable switchAction;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isThumbnailLoaded;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isPostToStoryCapture;

    /* JADX INFO: Access modifiers changed from: private */
    final class b implements IT5 {
        private final ImageView a;
        final /* synthetic */ ImageViewCrossFade b;

        public b(ImageViewCrossFade imageViewCrossFade, ImageView imageView) {
            AbstractC13042fc3.i(imageView, "imageView");
            this.b = imageViewCrossFade;
            this.a = imageView;
            Runnable runnable = imageViewCrossFade.switchAction;
            if (runnable != null) {
                imageView.removeCallbacks(runnable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ImageViewCrossFade imageViewCrossFade) throws Resources.NotFoundException {
            AbstractC13042fc3.i(imageViewCrossFade, "this$0");
            imageViewCrossFade.q();
        }

        @Override // ir.nasim.IT5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean b(Drawable drawable, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
            AbstractC13042fc3.i(drawable, "resource");
            AbstractC13042fc3.i(obj, CommonUrlParts.MODEL);
            AbstractC13042fc3.i(enumC21012sz1, "dataSource");
            final ImageViewCrossFade imageViewCrossFade = this.b;
            imageViewCrossFade.switchAction = new Runnable() { // from class: ir.nasim.designsystem.a
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    ImageViewCrossFade.b.e(imageViewCrossFade);
                }
            };
            this.a.post(this.b.switchAction);
            return false;
        }

        @Override // ir.nasim.IT5
        public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
            AbstractC13042fc3.i(interfaceC21549tj7, "target");
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageViewCrossFade(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(context, "context");
    }

    private final void e() {
        ShapeableImageView shapeableImageView = new ShapeableImageView(getContext());
        addView(shapeableImageView);
        this.thumbnailImageView = shapeableImageView;
        ShapeableImageView shapeableImageView2 = new ShapeableImageView(getContext());
        addView(shapeableImageView2);
        this.mainImageView = shapeableImageView2;
    }

    private final void g() {
        QI2 qi2 = QI2.a;
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        qi2.a(shapeableImageView);
    }

    private final void h() {
        QI2 qi2 = QI2.a;
        ShapeableImageView shapeableImageView = this.thumbnailImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView = null;
        }
        qi2.a(shapeableImageView);
        this.isThumbnailLoaded = false;
    }

    private final void i() {
        setInAnimation(null);
        setOutAnimation(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ImageViewCrossFade imageViewCrossFade) throws Resources.NotFoundException {
        AbstractC13042fc3.i(imageViewCrossFade, "this$0");
        imageViewCrossFade.q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l(ImageView imageView, IT5 listener, String imageUrl, byte[] imageBytes, C20107rU5 options) {
        VI2 vi2B = OI2.b(C5721Ko.a.d());
        if (imageUrl == null) {
            imageUrl = imageBytes;
        }
        vi2B.Q(imageUrl).b(options).S0(listener).Q0(imageView);
    }

    static /* synthetic */ void n(ImageViewCrossFade imageViewCrossFade, ImageView imageView, IT5 it5, String str, byte[] bArr, C20107rU5 c20107rU5, int i, Object obj) {
        imageViewCrossFade.l(imageView, (i & 2) != 0 ? null : it5, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bArr, c20107rU5);
    }

    private final void p() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        animationLoadAnimation.setDuration(250L);
        setInAnimation(animationLoadAnimation);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
        animationLoadAnimation2.setDuration(250L);
        setOutAnimation(animationLoadAnimation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() throws Resources.NotFoundException {
        if (!this.isThumbnailLoaded || this.isPostToStoryCapture) {
            i();
        } else {
            p();
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
        ShapeableImageView shapeableImageView = this.thumbnailImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView = null;
        }
        shapeableImageView.buildDrawingCache();
        ShapeableImageView shapeableImageView3 = this.mainImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("mainImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        shapeableImageView2.buildDrawingCache();
    }

    @Override // android.view.View
    public void destroyDrawingCache() {
        super.destroyDrawingCache();
        if (isInEditMode()) {
            return;
        }
        ShapeableImageView shapeableImageView = this.thumbnailImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView = null;
        }
        shapeableImageView.destroyDrawingCache();
        ShapeableImageView shapeableImageView3 = this.mainImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("mainImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        shapeableImageView2.destroyDrawingCache();
    }

    public final void f() {
        h();
        g();
        this.switchAction = null;
    }

    public final boolean j(C8610Ws drawable, boolean autoStart) throws InterruptedException {
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
        shapeableImageView.setBackground(drawable);
        Runnable runnable = new Runnable() { // from class: ir.nasim.j33
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                ImageViewCrossFade.k(this.a);
            }
        };
        this.switchAction = runnable;
        return shapeableImageView.post(runnable);
    }

    public final void m(String imageUrl, C20107rU5 options) {
        ShapeableImageView shapeableImageView;
        AbstractC13042fc3.i(imageUrl, "imageUrl");
        AbstractC13042fc3.i(options, "options");
        ShapeableImageView shapeableImageView2 = this.mainImageView;
        ShapeableImageView shapeableImageView3 = null;
        if (shapeableImageView2 == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        } else {
            shapeableImageView = shapeableImageView2;
        }
        ShapeableImageView shapeableImageView4 = this.mainImageView;
        if (shapeableImageView4 == null) {
            AbstractC13042fc3.y("mainImageView");
        } else {
            shapeableImageView3 = shapeableImageView4;
        }
        n(this, shapeableImageView, new b(this, shapeableImageView3), imageUrl, null, options, 8, null);
    }

    public final void o(byte[] byteArray, C20107rU5 options) {
        AbstractC13042fc3.i(byteArray, "byteArray");
        AbstractC13042fc3.i(options, "options");
        ShapeableImageView shapeableImageView = this.thumbnailImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView = null;
        }
        UI2 ui2K1 = OI2.c(shapeableImageView).z(byteArray).b(options);
        ShapeableImageView shapeableImageView3 = this.thumbnailImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("thumbnailImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        ui2K1.Q0(shapeableImageView2);
        setDisplayedChild(0);
        this.isThumbnailLoaded = true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        ShapeableImageView shapeableImageView = this.thumbnailImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setBackgroundColor(color);
        ShapeableImageView shapeableImageView3 = this.mainImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("mainImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        shapeableImageView2.setBackgroundColor(color);
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
            shapeableImageView3 = null;
        }
        shapeableImageView.setShapeAppearanceModel(shapeableImageView3.getShapeAppearanceModel().v().o(radius).m());
        ShapeableImageView shapeableImageView4 = this.thumbnailImageView;
        if (shapeableImageView4 == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView4 = null;
        }
        ShapeableImageView shapeableImageView5 = this.thumbnailImageView;
        if (shapeableImageView5 == null) {
            AbstractC13042fc3.y("thumbnailImageView");
        } else {
            shapeableImageView2 = shapeableImageView5;
        }
        shapeableImageView4.setShapeAppearanceModel(shapeableImageView2.getShapeAppearanceModel().v().o(radius).m());
    }

    public final void setCorners(float radius) {
        ShapeableImageView shapeableImageView = this.mainImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel().v().q(0, radius).m());
        ShapeableImageView shapeableImageView3 = this.thumbnailImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("thumbnailImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        shapeableImageView2.setShapeAppearanceModel(shapeableImageView2.getShapeAppearanceModel().v().q(0, radius).m());
    }

    public final void setImageDrawable(Drawable drawable) {
        ShapeableImageView shapeableImageView = this.thumbnailImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setImageDrawable(drawable);
        ShapeableImageView shapeableImageView3 = this.mainImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("mainImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        shapeableImageView2.setImageDrawable(drawable);
    }

    public final void setIsPostToStoryCapture(boolean isPostToStoryCapture) {
        this.isPostToStoryCapture = isPostToStoryCapture;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        ShapeableImageView shapeableImageView = this.mainImageView;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setLayoutParams(params != null ? new FrameLayout.LayoutParams(params) : null);
        ShapeableImageView shapeableImageView2 = this.thumbnailImageView;
        if (shapeableImageView2 == null) {
            AbstractC13042fc3.y("thumbnailImageView");
            shapeableImageView2 = null;
        }
        shapeableImageView2.setLayoutParams(params != null ? new FrameLayout.LayoutParams(params) : null);
    }

    public /* synthetic */ ImageViewCrossFade(Context context, AttributeSet attributeSet, int i, ED1 ed1) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewCrossFade(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        if (isInEditMode()) {
            return;
        }
        p();
        e();
    }

    public final void setCorners(float topRight, float topLeft, float bottomRight, float bottomLeft) {
        ShapeableImageView shapeableImageView = this.mainImageView;
        ShapeableImageView shapeableImageView2 = null;
        if (shapeableImageView == null) {
            AbstractC13042fc3.y("mainImageView");
            shapeableImageView = null;
        }
        shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel().v().J(0, topRight).E(0, topLeft).y(0, bottomRight).t(0, bottomLeft).m());
        ShapeableImageView shapeableImageView3 = this.thumbnailImageView;
        if (shapeableImageView3 == null) {
            AbstractC13042fc3.y("thumbnailImageView");
        } else {
            shapeableImageView2 = shapeableImageView3;
        }
        shapeableImageView2.setShapeAppearanceModel(shapeableImageView2.getShapeAppearanceModel().v().J(0, topRight).E(0, topLeft).y(0, bottomRight).t(0, bottomLeft).m());
    }
}
