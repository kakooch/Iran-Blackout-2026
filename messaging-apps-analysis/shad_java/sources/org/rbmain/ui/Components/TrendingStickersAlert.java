package org.rbmain.ui.Components;

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
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;

/* loaded from: classes5.dex */
public class TrendingStickersAlert extends BottomSheet {
    private final AlertContainerView alertContainerView;
    private final TrendingStickersLayout layout;
    private int scrollOffsetY;
    private final GradientDrawable shapeDrawable;
    private final int topOffset;

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public TrendingStickersAlert(Context context, BaseFragment baseFragment, TrendingStickersLayout trendingStickersLayout) {
        super(context, true);
        this.topOffset = AndroidUtilities.dp(12.0f);
        this.shapeDrawable = new GradientDrawable();
        MediaDataController.getInstance(this.currentAccount).checkFeaturedStickers();
        AlertContainerView alertContainerView = new AlertContainerView(context);
        this.alertContainerView = alertContainerView;
        alertContainerView.addView(trendingStickersLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.containerView = alertContainerView;
        this.layout = trendingStickersLayout;
        trendingStickersLayout.setParentFragment(baseFragment);
        trendingStickersLayout.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.TrendingStickersAlert.1
            private int scrolledY;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    this.scrolledY = 0;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                this.scrolledY += i2;
                if (recyclerView.getScrollState() == 1 && Math.abs(this.scrolledY) > AndroidUtilities.dp(96.0f)) {
                    View viewFindFocus = TrendingStickersAlert.this.layout.findFocus();
                    if (viewFindFocus == null) {
                        viewFindFocus = TrendingStickersAlert.this.layout;
                    }
                    AndroidUtilities.hideKeyboard(viewFindFocus);
                }
                if (i2 != 0) {
                    TrendingStickersAlert.this.updateLayout();
                }
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        setHeavyOperationsEnabled(false);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.layout.recycle();
        setHeavyOperationsEnabled(true);
    }

    public void setHeavyOperationsEnabled(boolean z) {
        NotificationCenter.getGlobalInstance().postNotificationName(z ? NotificationCenter.startAllHeavyOperations : NotificationCenter.stopAllHeavyOperations, 2);
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

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        final TrendingStickersLayout trendingStickersLayout = this.layout;
        trendingStickersLayout.getClass();
        trendingStickersLayout.getThemeDescriptions(arrayList, new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.Components.TrendingStickersAlert$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                trendingStickersLayout.updateColors();
            }
        });
        arrayList.add(new ThemeDescription(this.alertContainerView, 0, null, null, new Drawable[]{this.shadowDrawable}, null, Theme.key_dialogBackground));
        arrayList.add(new ThemeDescription(this.alertContainerView, 0, null, null, null, null, Theme.key_sheet_scrollUp));
        return arrayList;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void setAllowNestedScroll(boolean z) {
        this.allowNestedScroll = z;
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
            setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate(TrendingStickersAlert.this) { // from class: org.rbmain.ui.Components.TrendingStickersAlert.AlertContainerView.1
                private boolean lastIsWidthGreater;
                private int lastKeyboardHeight;

                @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                public void onSizeChanged(int i, boolean z) {
                    if (this.lastKeyboardHeight == i && this.lastIsWidthGreater == z) {
                        return;
                    }
                    this.lastKeyboardHeight = i;
                    this.lastIsWidthGreater = z;
                    if (i <= AndroidUtilities.dp(20.0f) || AlertContainerView.this.gluedToTop) {
                        return;
                    }
                    TrendingStickersAlert.this.setAllowNestedScroll(false);
                    AlertContainerView.this.gluedToTop = true;
                }
            });
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.TrendingStickersAlert$AlertContainerView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.requestLayout();
                }
            }, 200L);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && TrendingStickersAlert.this.scrollOffsetY != 0 && motionEvent.getY() < TrendingStickersAlert.this.scrollOffsetY) {
                TrendingStickersAlert.this.dismiss();
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return !TrendingStickersAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
        }

        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
            int size = View.MeasureSpec.getSize(getMeasuredHeight()) - i5;
            int iMeasureKeyboardHeight = measureKeyboardHeight();
            int i6 = (int) ((size + iMeasureKeyboardHeight) * 0.2f);
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
            TrendingStickersAlert.this.layout.setContentViewPaddingTop(i6);
            if (getPaddingTop() != i5) {
                setPadding(((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, i5, ((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, 0);
            }
            this.ignoreLayout = false;
            super.onLayout(z, i, i2, i3, i4);
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        @Override // android.view.View
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
                TrendingStickersAlert.this.shapeDrawable.setColor(Theme.getColor(Theme.key_dialogBackground));
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

        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
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
            TrendingStickersAlert.this.shapeDrawable.setColor(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_sheet_scrollUp), (int) (Color.alpha(r8) * fraction)));
            TrendingStickersAlert.this.shapeDrawable.setBounds((getWidth() - iDp) / 2, TrendingStickersAlert.this.scrollOffsetY + AndroidUtilities.dp(10.0f) + i2, (getWidth() + iDp) / 2, TrendingStickersAlert.this.scrollOffsetY + AndroidUtilities.dp(10.0f) + i2 + iDp2);
            TrendingStickersAlert.this.shapeDrawable.draw(canvas);
            canvas.restore();
            if (fraction == 0.0f && i >= 21 && !TrendingStickersAlert.this.isDismissed()) {
                z = true;
            }
            setStatusBarVisible(z, true);
            if (this.statusBarAlpha > 0.0f) {
                int color = Theme.getColor(Theme.key_dialogBackground);
                this.paint.setColor(Color.argb((int) (this.statusBarAlpha * 255.0f), (int) (Color.red(color) * 0.8f), (int) (Color.green(color) * 0.8f), (int) (Color.blue(color) * 0.8f)));
                canvas.drawRect(((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) TrendingStickersAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, this.paint);
            }
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            TrendingStickersAlert.this.layout.setTranslationY(f);
            invalidate();
        }

        @Override // android.view.View
        public float getTranslationY() {
            return TrendingStickersAlert.this.layout.getTranslationY();
        }

        private float getFraction() {
            return Math.min(1.0f, Math.max(0.0f, TrendingStickersAlert.this.scrollOffsetY / (TrendingStickersAlert.this.topOffset * 2.0f)));
        }

        private void setStatusBarVisible(boolean z, boolean z2) {
            if (this.statusBarVisible != z) {
                ValueAnimator valueAnimator = this.statusBarAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.statusBarVisible = z;
                if (z2) {
                    ValueAnimator valueAnimator2 = this.statusBarAnimator;
                    if (valueAnimator2 == null) {
                        float[] fArr = new float[2];
                        fArr[0] = this.statusBarAlpha;
                        fArr[1] = z ? 1.0f : 0.0f;
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
                        this.statusBarAnimator = valueAnimatorOfFloat;
                        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.TrendingStickersAlert$AlertContainerView$$ExternalSyntheticLambda0
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                                this.f$0.lambda$setStatusBarVisible$0(valueAnimator3);
                            }
                        });
                        this.statusBarAnimator.setDuration(200L);
                    } else {
                        float[] fArr2 = new float[2];
                        fArr2[0] = this.statusBarAlpha;
                        fArr2[1] = z ? 1.0f : 0.0f;
                        valueAnimator2.setFloatValues(fArr2);
                    }
                    this.statusBarAnimator.start();
                    return;
                }
                this.statusBarAlpha = z ? 1.0f : 0.0f;
                invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setStatusBarVisible$0(ValueAnimator valueAnimator) {
            this.statusBarAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            invalidate();
        }
    }
}
