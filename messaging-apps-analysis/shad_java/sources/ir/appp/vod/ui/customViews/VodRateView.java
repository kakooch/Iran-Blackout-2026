package ir.appp.vod.ui.customViews;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Point;

/* compiled from: VodRateView.kt */
/* loaded from: classes3.dex */
public final class VodRateView extends ConstraintLayout {
    private final int animDuration;
    private ImageView backgroundImageView;
    private final Point centerPoint;
    private ImageView closeIconImageView;
    private final int closeIconSizePx;
    private ImageView disLikeIconBackground;
    private ImageView disLikeIconImageView;
    private final Interpolator hideCloseIconInterpolator;
    private AnimatorSet hideDislikedRateViewAnimatorSet;
    private AnimatorSet hideLikedRateViewAnimatorSet;
    private final Interpolator hideRateIconsInterpolator;
    private final int iconViewSizePx;
    private ImageView likeIconBackground;
    private ImageView likeIconImageView;
    private Function0<Unit> onCloseClicked;
    private Function0<Unit> onDisLikeClicked;
    private Function0<Unit> onLikeClicked;
    private Function0<Unit> onViewAnimationEnd;
    private final int rateBackgroundSizeDp;
    private final Interpolator showCloseIconInterpolator;
    private final Interpolator showRateIconsInterpolator;
    private AnimatorSet showRateViewAnimatorSet;
    private final int translateXDistance;
    private final int translateYDistance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodRateView(int i, Point centerPoint, Context context) throws Resources.NotFoundException {
        super(context);
        Intrinsics.checkNotNullParameter(centerPoint, "centerPoint");
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.iconViewSizePx = i;
        this.centerPoint = centerPoint;
        this.showRateIconsInterpolator = new Interpolator() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda5
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                return VodRateView.m366showRateIconsInterpolator$lambda0(f);
            }
        };
        this.hideRateIconsInterpolator = new Interpolator() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda4
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                return VodRateView.m358hideRateIconsInterpolator$lambda1(f);
            }
        };
        this.showCloseIconInterpolator = new Interpolator() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda7
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                return VodRateView.m365showCloseIconInterpolator$lambda2(f);
            }
        };
        this.hideCloseIconInterpolator = new Interpolator() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda6
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                return VodRateView.m357hideCloseIconInterpolator$lambda3(f);
            }
        };
        this.showRateViewAnimatorSet = new AnimatorSet();
        this.hideLikedRateViewAnimatorSet = new AnimatorSet();
        this.hideDislikedRateViewAnimatorSet = new AnimatorSet();
        int iDp = AndroidUtilities.dp(42.0f);
        this.closeIconSizePx = iDp;
        int iDp2 = AndroidUtilities.dp(36.0f) + i;
        this.rateBackgroundSizeDp = iDp2;
        this.translateXDistance = AndroidUtilities.dp(50.0f);
        this.translateYDistance = AndroidUtilities.dp(70.0f);
        this.animDuration = 300;
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.color.vod_rate_background_overlay);
        imageView.setAlpha(0.0f);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return VodRateView.m363lambda5$lambda4(this.f$0, view, motionEvent);
            }
        });
        this.backgroundImageView = imageView;
        addView(imageView, -1, -1);
        ImageView imageView2 = new ImageView(context);
        imageView2.setBackground(imageView2.getResources().getDrawable(R.drawable.vod_close_icon_background));
        imageView2.setImageResource(R.drawable.vod_close);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setX(centerPoint.x - (iDp / 2.0f));
        imageView2.setY(centerPoint.y - (iDp / 2.0f));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodRateView.m364lambda7$lambda6(this.f$0, view);
            }
        });
        this.closeIconImageView = imageView2;
        addView(imageView2, LayoutHelper.createFrame(AndroidUtilities.px(iDp), AndroidUtilities.px(iDp)));
        ImageView imageView3 = new ImageView(context);
        Drawable drawable = imageView3.getResources().getDrawable(R.drawable.vod_rate_icon_background);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            imageView3.setBackgroundDrawable(new RippleDrawable(ColorStateList.valueOf(imageView3.getResources().getColor(R.color.white)), drawable, null));
        } else {
            imageView3.setImageDrawable(drawable);
        }
        imageView3.setX(centerPoint.x - (iDp2 / 2.0f));
        imageView3.setY(centerPoint.y - (iDp2 / 2.0f));
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodRateView.m359lambda10$lambda9(this.f$0, view);
            }
        });
        this.likeIconBackground = imageView3;
        addView(imageView3, LayoutHelper.createFrame(AndroidUtilities.px(iDp2), AndroidUtilities.px(iDp2)));
        ImageView imageView4 = new ImageView(context);
        Drawable drawable2 = imageView4.getResources().getDrawable(R.drawable.vod_rate_icon_background);
        if (i2 >= 21) {
            imageView4.setBackgroundDrawable(new RippleDrawable(ColorStateList.valueOf(imageView4.getResources().getColor(R.color.white)), drawable2, null));
        } else {
            imageView4.setImageDrawable(drawable2);
        }
        imageView4.setX(centerPoint.x - (iDp2 / 2.0f));
        imageView4.setY(centerPoint.y - (iDp2 / 2.0f));
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodRateView.m361lambda13$lambda12(this.f$0, view);
            }
        });
        this.disLikeIconBackground = imageView4;
        addView(imageView4, LayoutHelper.createFrame(AndroidUtilities.px(iDp2), AndroidUtilities.px(iDp2)));
        ImageView imageView5 = new ImageView(context);
        imageView5.setBackground(null);
        imageView5.setClickable(false);
        imageView5.setFocusable(false);
        imageView5.setImageDrawable(imageView5.getResources().getDrawable(R.drawable.vod_rate));
        imageView5.setX(centerPoint.x - (i / 2.0f));
        imageView5.setY(centerPoint.y - (i / 2.0f));
        this.likeIconImageView = imageView5;
        addView(imageView5, LayoutHelper.createFrame(AndroidUtilities.px(i), AndroidUtilities.px(i)));
        ImageView imageView6 = new ImageView(context);
        imageView6.setBackground(null);
        imageView6.setClickable(false);
        imageView6.setFocusable(false);
        imageView6.setImageResource(R.drawable.vod_dislike_not_fill);
        imageView6.setX(centerPoint.x - (i / 2.0f));
        imageView6.setY(centerPoint.y - (i / 2.0f));
        this.disLikeIconImageView = imageView6;
        addView(imageView6, LayoutHelper.createFrame(AndroidUtilities.px(i), AndroidUtilities.px(i)));
        setupAnimations();
    }

    public final Function0<Unit> getOnLikeClicked() {
        return this.onLikeClicked;
    }

    public final void setOnLikeClicked(Function0<Unit> function0) {
        this.onLikeClicked = function0;
    }

    public final Function0<Unit> getOnDisLikeClicked() {
        return this.onDisLikeClicked;
    }

    public final void setOnDisLikeClicked(Function0<Unit> function0) {
        this.onDisLikeClicked = function0;
    }

    public final Function0<Unit> getOnCloseClicked() {
        return this.onCloseClicked;
    }

    public final void setOnCloseClicked(Function0<Unit> function0) {
        this.onCloseClicked = function0;
    }

    public final Function0<Unit> getOnViewAnimationEnd() {
        return this.onViewAnimationEnd;
    }

    public final void setOnViewAnimationEnd(Function0<Unit> function0) {
        this.onViewAnimationEnd = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showRateIconsInterpolator$lambda-0, reason: not valid java name */
    public static final float m366showRateIconsInterpolator$lambda0(float f) {
        if (0.0f <= f && f < 0.6f) {
            return 0.0f;
        }
        float f2 = 1;
        return (f2 / new AccelerateDecelerateInterpolator().getInterpolation(f2 - 0.6f)) * new AccelerateDecelerateInterpolator().getInterpolation(f - 0.6f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hideRateIconsInterpolator$lambda-1, reason: not valid java name */
    public static final float m358hideRateIconsInterpolator$lambda1(float f) {
        if (0.0f > f || f >= 0.4f) {
            return 1.0f;
        }
        return (1 / new AccelerateDecelerateInterpolator().getInterpolation(0.4f)) * new AccelerateDecelerateInterpolator().getInterpolation(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCloseIconInterpolator$lambda-2, reason: not valid java name */
    public static final float m365showCloseIconInterpolator$lambda2(float f) {
        if (0.0f <= f && f < 0.8f) {
            return 0.0f;
        }
        float f2 = 1;
        return (f2 / new AccelerateDecelerateInterpolator().getInterpolation(f2 - 0.8f)) * new AccelerateDecelerateInterpolator().getInterpolation(f - 0.8f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hideCloseIconInterpolator$lambda-3, reason: not valid java name */
    public static final float m357hideCloseIconInterpolator$lambda3(float f) {
        if (0.0f > f || f >= 0.2f) {
            return 1.0f;
        }
        return (1 / new AccelerateDecelerateInterpolator().getInterpolation(0.2f)) * new AccelerateDecelerateInterpolator().getInterpolation(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-5$lambda-4, reason: not valid java name */
    public static final boolean m363lambda5$lambda4(VodRateView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.hideLikedRateViewAnimatorSet.isRunning()) {
            return true;
        }
        this$0.hideLikedRateViewAnimatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-7$lambda-6, reason: not valid java name */
    public static final void m364lambda7$lambda6(VodRateView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideLikedRateViewAnimatorSet.start();
        Function0<Unit> function0 = this$0.onCloseClicked;
        if (function0 == null) {
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-10$lambda-9, reason: not valid java name */
    public static final void m359lambda10$lambda9(final VodRateView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new Handler().postDelayed(new Runnable() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                VodRateView.m360lambda10$lambda9$lambda8(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-10$lambda-9$lambda-8, reason: not valid java name */
    public static final void m360lambda10$lambda9$lambda8(VodRateView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.likeIconImageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.vod_like_fill);
        }
        this$0.hideLikedRateViewAnimatorSet.start();
        Function0<Unit> function0 = this$0.onLikeClicked;
        if (function0 == null) {
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-13$lambda-12, reason: not valid java name */
    public static final void m361lambda13$lambda12(final VodRateView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new Handler().postDelayed(new Runnable() { // from class: ir.appp.vod.ui.customViews.VodRateView$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                VodRateView.m362lambda13$lambda12$lambda11(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-13$lambda-12$lambda-11, reason: not valid java name */
    public static final void m362lambda13$lambda12$lambda11(VodRateView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.disLikeIconImageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.vod_dislike_fill);
        }
        this$0.hideDislikedRateViewAnimatorSet.start();
        Function0<Unit> function0 = this$0.onDisLikeClicked;
        if (function0 == null) {
            return;
        }
        function0.invoke();
    }

    private final void setupAnimations() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.closeIconImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.showCloseIconInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.closeIconImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 1.0f, 0.0f);
        objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: ir.appp.vod.ui.customViews.VodRateView.setupAnimations.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> onViewAnimationEnd = VodRateView.this.getOnViewAnimationEnd();
                if (onViewAnimationEnd == null) {
                    return;
                }
                onViewAnimationEnd.invoke();
            }
        });
        objectAnimatorOfFloat2.setInterpolator(this.hideCloseIconInterpolator);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(this.showRateIconsInterpolator);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.ALPHA, 1.0f, 0.0f);
        objectAnimatorOfFloat4.setInterpolator(this.hideRateIconsInterpolator);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat5.setInterpolator(this.showRateIconsInterpolator);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.ALPHA, 1.0f, 0.0f);
        objectAnimatorOfFloat6.setInterpolator(this.hideRateIconsInterpolator);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat7.setInterpolator(this.showRateIconsInterpolator);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 1.0f, 0.0f);
        objectAnimatorOfFloat8.setInterpolator(this.hideRateIconsInterpolator);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 1.0f, 0.0f);
        objectAnimatorOfFloat9.setInterpolator(this.hideRateIconsInterpolator);
        AnimatorSet duration = this.showRateViewAnimatorSet.setDuration(this.animDuration);
        Animator[] animatorArr = new Animator[21];
        animatorArr[0] = ObjectAnimator.ofFloat(this.backgroundImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 0.0f, 1.0f);
        ImageView imageView = this.likeIconImageView;
        Property property = ViewGroup.TRANSLATION_X;
        float[] fArr = new float[1];
        Float fValueOf = imageView == null ? null : Float.valueOf(imageView.getX());
        Intrinsics.checkNotNull(fValueOf);
        fArr[0] = fValueOf.floatValue() - this.translateXDistance;
        animatorArr[1] = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, fArr);
        ImageView imageView2 = this.likeIconImageView;
        Property property2 = ViewGroup.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        Float fValueOf2 = imageView2 == null ? null : Float.valueOf(imageView2.getY());
        Intrinsics.checkNotNull(fValueOf2);
        fArr2[0] = fValueOf2.floatValue() - this.translateYDistance;
        animatorArr[2] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property2, fArr2);
        animatorArr[3] = ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f, 1.15f);
        animatorArr[4] = ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f, 1.15f);
        animatorArr[5] = objectAnimatorOfFloat7;
        animatorArr[6] = ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f, 1.15f);
        animatorArr[7] = ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f, 1.15f);
        ImageView imageView3 = this.disLikeIconImageView;
        Property property3 = ViewGroup.TRANSLATION_X;
        float[] fArr3 = new float[1];
        Float fValueOf3 = imageView3 == null ? null : Float.valueOf(imageView3.getX());
        Intrinsics.checkNotNull(fValueOf3);
        fArr3[0] = fValueOf3.floatValue() + this.translateXDistance;
        animatorArr[8] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property3, fArr3);
        ImageView imageView4 = this.disLikeIconImageView;
        Property property4 = ViewGroup.TRANSLATION_Y;
        float[] fArr4 = new float[1];
        Float fValueOf4 = imageView4 == null ? null : Float.valueOf(imageView4.getY());
        Intrinsics.checkNotNull(fValueOf4);
        fArr4[0] = fValueOf4.floatValue() - this.translateYDistance;
        animatorArr[9] = ObjectAnimator.ofFloat(imageView4, (Property<ImageView, Float>) property4, fArr4);
        animatorArr[10] = objectAnimatorOfFloat3;
        ImageView imageView5 = this.likeIconBackground;
        Property property5 = ViewGroup.TRANSLATION_X;
        float[] fArr5 = new float[1];
        Float fValueOf5 = imageView5 == null ? null : Float.valueOf(imageView5.getX());
        Intrinsics.checkNotNull(fValueOf5);
        fArr5[0] = fValueOf5.floatValue() - this.translateXDistance;
        animatorArr[11] = ObjectAnimator.ofFloat(imageView5, (Property<ImageView, Float>) property5, fArr5);
        ImageView imageView6 = this.likeIconBackground;
        Property property6 = ViewGroup.TRANSLATION_Y;
        float[] fArr6 = new float[1];
        Float fValueOf6 = imageView6 == null ? null : Float.valueOf(imageView6.getY());
        Intrinsics.checkNotNull(fValueOf6);
        fArr6[0] = fValueOf6.floatValue() - this.translateYDistance;
        animatorArr[12] = ObjectAnimator.ofFloat(imageView6, (Property<ImageView, Float>) property6, fArr6);
        animatorArr[13] = ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f, 1.15f);
        animatorArr[14] = ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f, 1.15f);
        animatorArr[15] = objectAnimatorOfFloat5;
        ImageView imageView7 = this.disLikeIconBackground;
        Property property7 = ViewGroup.TRANSLATION_X;
        float[] fArr7 = new float[1];
        Float fValueOf7 = imageView7 == null ? null : Float.valueOf(imageView7.getX());
        Intrinsics.checkNotNull(fValueOf7);
        fArr7[0] = fValueOf7.floatValue() + this.translateXDistance;
        animatorArr[16] = ObjectAnimator.ofFloat(imageView7, (Property<ImageView, Float>) property7, fArr7);
        ImageView imageView8 = this.disLikeIconBackground;
        Property property8 = ViewGroup.TRANSLATION_Y;
        float[] fArr8 = new float[1];
        Float fValueOf8 = imageView8 != null ? Float.valueOf(imageView8.getY()) : null;
        Intrinsics.checkNotNull(fValueOf8);
        fArr8[0] = fValueOf8.floatValue() - this.translateYDistance;
        animatorArr[17] = ObjectAnimator.ofFloat(imageView8, (Property<ImageView, Float>) property8, fArr8);
        animatorArr[18] = ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f, 1.15f);
        animatorArr[19] = ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f, 1.15f);
        animatorArr[20] = objectAnimatorOfFloat;
        duration.playTogether(animatorArr);
        this.hideLikedRateViewAnimatorSet.setDuration(this.animDuration).playTogether(ObjectAnimator.ofFloat(this.backgroundImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.iconViewSizePx / 2.0f)), ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.iconViewSizePx / 2.0f)), objectAnimatorOfFloat4, ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), objectAnimatorOfFloat8, ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.iconViewSizePx / 2.0f)), ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.iconViewSizePx / 2.0f)), objectAnimatorOfFloat6, ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), objectAnimatorOfFloat2);
        this.hideDislikedRateViewAnimatorSet.setDuration(this.animDuration).playTogether(ObjectAnimator.ofFloat(this.backgroundImageView, (Property<ImageView, Float>) ViewGroup.ALPHA, 0.0f), objectAnimatorOfFloat9, ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.iconViewSizePx / 2.0f)), ObjectAnimator.ofFloat(this.likeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.iconViewSizePx / 2.0f)), objectAnimatorOfFloat4, ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.likeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.iconViewSizePx / 2.0f)), ObjectAnimator.ofFloat(this.disLikeIconImageView, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.iconViewSizePx / 2.0f)), objectAnimatorOfFloat6, ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_X, this.centerPoint.x - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.TRANSLATION_Y, this.centerPoint.y - (this.rateBackgroundSizeDp / 2.0f)), ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.disLikeIconBackground, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 1.0f), objectAnimatorOfFloat2);
    }

    public final void startViewAnimation(boolean z) {
        ImageView imageView = this.likeIconImageView;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
        ImageView imageView2 = this.likeIconBackground;
        if (imageView2 != null) {
            imageView2.setVisibility(z ? 0 : 8);
        }
        ImageView imageView3 = this.disLikeIconImageView;
        if (imageView3 != null) {
            imageView3.setVisibility(z ? 0 : 8);
        }
        ImageView imageView4 = this.disLikeIconBackground;
        if (imageView4 != null) {
            imageView4.setVisibility(z ? 0 : 8);
        }
        ImageView imageView5 = this.closeIconImageView;
        if (imageView5 != null) {
            imageView5.setVisibility(z ? 0 : 8);
        }
        ImageView imageView6 = this.likeIconImageView;
        if (imageView6 != null) {
            imageView6.setAlpha(z ? 1.0f : 0.0f);
        }
        ImageView imageView7 = this.likeIconBackground;
        if (imageView7 != null) {
            imageView7.setAlpha(z ? 1.0f : 0.0f);
        }
        ImageView imageView8 = this.disLikeIconImageView;
        if (imageView8 != null) {
            imageView8.setAlpha(z ? 1.0f : 0.0f);
        }
        ImageView imageView9 = this.disLikeIconBackground;
        if (imageView9 != null) {
            imageView9.setAlpha(z ? 1.0f : 0.0f);
        }
        ImageView imageView10 = this.closeIconImageView;
        if (imageView10 != null) {
            imageView10.setAlpha(z ? 1.0f : 0.0f);
        }
        if (z) {
            this.showRateViewAnimatorSet.start();
        }
    }
}
