package ir.eitaa.ui.Components;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TrendingStickersAlert extends BottomSheet {
    private final AlertContainerView alertContainerView;
    private final TrendingStickersLayout layout;
    private int scrollOffsetY;
    private final GradientDrawable shapeDrawable;
    private final int topOffset;

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public TrendingStickersAlert(Context context, BaseFragment parentFragment, TrendingStickersLayout trendingStickersLayout, Theme.ResourcesProvider resourcesProvider) {
        super(context, true, resourcesProvider);
        this.topOffset = AndroidUtilities.dp(12.0f);
        this.shapeDrawable = new GradientDrawable();
        AlertContainerView alertContainerView = new AlertContainerView(context);
        this.alertContainerView = alertContainerView;
        alertContainerView.addView(trendingStickersLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.containerView = alertContainerView;
        this.layout = trendingStickersLayout;
        trendingStickersLayout.setParentFragment(parentFragment);
        trendingStickersLayout.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.TrendingStickersAlert.1
            private int scrolledY;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 0) {
                    this.scrolledY = 0;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                this.scrolledY += dy;
                if (recyclerView.getScrollState() == 1 && Math.abs(this.scrolledY) > AndroidUtilities.dp(96.0f)) {
                    View viewFindFocus = TrendingStickersAlert.this.layout.findFocus();
                    if (viewFindFocus == null) {
                        viewFindFocus = TrendingStickersAlert.this.layout;
                    }
                    AndroidUtilities.hideKeyboard(viewFindFocus);
                }
                if (dy != 0) {
                    TrendingStickersAlert.this.updateLayout();
                }
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        setHeavyOperationsEnabled(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.layout.recycle();
        setHeavyOperationsEnabled(true);
    }

    public void setHeavyOperationsEnabled(boolean enabled) {
        NotificationCenter.getGlobalInstance().postNotificationName(enabled ? NotificationCenter.startAllHeavyOperations : NotificationCenter.stopAllHeavyOperations, 2);
    }

    public TrendingStickersLayout getLayout() {
        return this.layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.layout.update()) {
            this.scrollOffsetY = this.layout.getContentTopOffset();
            this.containerView.invalidate();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        final TrendingStickersLayout trendingStickersLayout = this.layout;
        trendingStickersLayout.getClass();
        trendingStickersLayout.getThemeDescriptions(arrayList, new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ziFHVEBPSrurNmPGcNUHxMUSloU
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                trendingStickersLayout.updateColors();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        });
        arrayList.add(new ThemeDescription(this.alertContainerView, 0, null, null, new Drawable[]{this.shadowDrawable}, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.alertContainerView, 0, null, null, null, null, "key_sheet_scrollUp"));
        return arrayList;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void setAllowNestedScroll(boolean allowNestedScroll) {
        this.allowNestedScroll = allowNestedScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AlertContainerView extends SizeNotifierFrameLayout {
        private boolean gluedToTop;
        private boolean ignoreLayout;
        private final Paint paint;
        private float[] radii;
        private float statusBarAlpha;
        private ValueAnimator statusBarAnimator;
        private boolean statusBarVisible;

        public AlertContainerView(Context context) {
            super(context);
            this.paint = new Paint(1);
            this.gluedToTop = false;
            this.ignoreLayout = false;
            this.statusBarVisible = false;
            this.statusBarAlpha = 0.0f;
            this.radii = new float[8];
            setWillNotDraw(false);
            setPadding(((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, 0, ((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, 0);
            setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.eitaa.ui.Components.TrendingStickersAlert.AlertContainerView.1
                private boolean lastIsWidthGreater;
                private int lastKeyboardHeight;

                @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                public void onSizeChanged(int keyboardHeight, boolean isWidthGreater) {
                    if (this.lastKeyboardHeight == keyboardHeight && this.lastIsWidthGreater == isWidthGreater) {
                        return;
                    }
                    this.lastKeyboardHeight = keyboardHeight;
                    this.lastIsWidthGreater = isWidthGreater;
                    if (keyboardHeight <= AndroidUtilities.dp(20.0f) || AlertContainerView.this.gluedToTop) {
                        return;
                    }
                    TrendingStickersAlert.this.setAllowNestedScroll(false);
                    AlertContainerView.this.gluedToTop = true;
                }
            });
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$u4eAagwFu6QFylX2-QizANbPxQc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.requestLayout();
                }
            }, 200L);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            if (ev.getAction() == 0 && TrendingStickersAlert.this.scrollOffsetY != 0 && ev.getY() < TrendingStickersAlert.this.scrollOffsetY) {
                TrendingStickersAlert.this.dismiss();
                return true;
            }
            return super.onInterceptTouchEvent(ev);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent e) {
            return !TrendingStickersAlert.this.isDismissed() && super.onTouchEvent(e);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 1073741824));
        }

        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int i = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
            int size = View.MeasureSpec.getSize(getMeasuredHeight()) - i;
            int iMeasureKeyboardHeight = measureKeyboardHeight();
            int i2 = (int) ((size + iMeasureKeyboardHeight) * 0.2f);
            this.ignoreLayout = true;
            if (iMeasureKeyboardHeight > AndroidUtilities.dp(20.0f)) {
                TrendingStickersAlert.this.layout.glueToTop(true);
                TrendingStickersAlert.this.setAllowNestedScroll(false);
                this.gluedToTop = true;
            } else {
                TrendingStickersAlert.this.layout.glueToTop(false);
                TrendingStickersAlert.this.setAllowNestedScroll(true);
                this.gluedToTop = false;
            }
            TrendingStickersAlert.this.layout.setContentViewPaddingTop(i2);
            if (getPaddingTop() != i) {
                setPadding(((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, i, ((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, 0);
            }
            this.ignoreLayout = false;
            super.onLayout(changed, l, t, r, b);
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.view.View
        protected void onDraw(Canvas canvas) {
            TrendingStickersAlert.this.updateLayout();
            super.onDraw(canvas);
            float fraction = getFraction();
            int i = (int) (TrendingStickersAlert.this.topOffset * (1.0f - fraction));
            int i2 = (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0) - TrendingStickersAlert.this.topOffset;
            canvas.save();
            canvas.translate(0.0f, TrendingStickersAlert.this.layout.getTranslationY() + i2);
            ((BottomSheet) TrendingStickersAlert.this).shadowDrawable.setBounds(0, (TrendingStickersAlert.this.scrollOffsetY - ((BottomSheet) TrendingStickersAlert.this).backgroundPaddingTop) + i, getMeasuredWidth(), getMeasuredHeight() + (i2 < 0 ? -i2 : 0));
            ((BottomSheet) TrendingStickersAlert.this).shadowDrawable.draw(canvas);
            if (fraction > 0.0f && fraction < 1.0f) {
                float fDp = AndroidUtilities.dp(12.0f) * fraction;
                TrendingStickersAlert.this.shapeDrawable.setColor(TrendingStickersAlert.this.getThemedColor("dialogBackground"));
                float[] fArr = this.radii;
                fArr[3] = fDp;
                fArr[2] = fDp;
                fArr[1] = fDp;
                fArr[0] = fDp;
                TrendingStickersAlert.this.shapeDrawable.setCornerRadii(this.radii);
                TrendingStickersAlert.this.shapeDrawable.setBounds(((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, TrendingStickersAlert.this.scrollOffsetY + i, getWidth() - ((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, TrendingStickersAlert.this.scrollOffsetY + i + AndroidUtilities.dp(24.0f));
                TrendingStickersAlert.this.shapeDrawable.draw(canvas);
            }
            canvas.restore();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            float fraction = getFraction();
            canvas.save();
            float translationY = TrendingStickersAlert.this.layout.getTranslationY();
            int i = Build.VERSION.SDK_INT;
            boolean z = false;
            canvas.translate(0.0f, (translationY + (i >= 21 ? AndroidUtilities.statusBarHeight : 0)) - TrendingStickersAlert.this.topOffset);
            int iDp = AndroidUtilities.dp(36.0f);
            int iDp2 = AndroidUtilities.dp(4.0f);
            int i2 = (int) (iDp2 * 2.0f * (1.0f - fraction));
            TrendingStickersAlert.this.shapeDrawable.setCornerRadius(AndroidUtilities.dp(2.0f));
            TrendingStickersAlert.this.shapeDrawable.setColor(ColorUtils.setAlphaComponent(TrendingStickersAlert.this.getThemedColor("key_sheet_scrollUp"), (int) (Color.alpha(r8) * fraction)));
            TrendingStickersAlert.this.shapeDrawable.setBounds((getWidth() - iDp) / 2, TrendingStickersAlert.this.scrollOffsetY + AndroidUtilities.dp(10.0f) + i2, (getWidth() + iDp) / 2, TrendingStickersAlert.this.scrollOffsetY + AndroidUtilities.dp(10.0f) + i2 + iDp2);
            TrendingStickersAlert.this.shapeDrawable.draw(canvas);
            canvas.restore();
            if (fraction == 0.0f && i >= 21 && !TrendingStickersAlert.this.isDismissed()) {
                z = true;
            }
            setStatusBarVisible(z, true);
            if (this.statusBarAlpha > 0.0f) {
                int themedColor = TrendingStickersAlert.this.getThemedColor("dialogBackground");
                this.paint.setColor(Color.argb((int) (this.statusBarAlpha * 255.0f), (int) (Color.red(themedColor) * 0.8f), (int) (Color.green(themedColor) * 0.8f), (int) (Color.blue(themedColor) * 0.8f)));
                canvas.drawRect(((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, this.paint);
            }
        }

        @Override // android.view.View
        public void setTranslationY(float translationY) {
            TrendingStickersAlert.this.layout.setTranslationY(translationY);
            invalidate();
        }

        @Override // android.view.View
        public float getTranslationY() {
            return TrendingStickersAlert.this.layout.getTranslationY();
        }

        private float getFraction() {
            return Math.min(1.0f, Math.max(0.0f, TrendingStickersAlert.this.scrollOffsetY / (TrendingStickersAlert.this.topOffset * 2.0f)));
        }

        private void setStatusBarVisible(boolean visible, boolean animated) {
            if (this.statusBarVisible != visible) {
                ValueAnimator valueAnimator = this.statusBarAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.statusBarVisible = visible;
                if (animated) {
                    ValueAnimator valueAnimator2 = this.statusBarAnimator;
                    if (valueAnimator2 == null) {
                        float[] fArr = new float[2];
                        fArr[0] = this.statusBarAlpha;
                        fArr[1] = visible ? 1.0f : 0.0f;
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
                        this.statusBarAnimator = valueAnimatorOfFloat;
                        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TrendingStickersAlert$AlertContainerView$pbYtksSQ25SmOnejnVOKhjtifPI
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                                this.f$0.lambda$setStatusBarVisible$0$TrendingStickersAlert$AlertContainerView(valueAnimator3);
                            }
                        });
                        this.statusBarAnimator.setDuration(200L);
                    } else {
                        float[] fArr2 = new float[2];
                        fArr2[0] = this.statusBarAlpha;
                        fArr2[1] = visible ? 1.0f : 0.0f;
                        valueAnimator2.setFloatValues(fArr2);
                    }
                    this.statusBarAnimator.start();
                    return;
                }
                this.statusBarAlpha = visible ? 1.0f : 0.0f;
                invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setStatusBarVisible$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setStatusBarVisible$0$TrendingStickersAlert$AlertContainerView(ValueAnimator valueAnimator) {
            this.statusBarAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            invalidate();
        }
    }
}
