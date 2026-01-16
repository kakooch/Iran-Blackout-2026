package org.rbmain.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
class StroageUsageView extends FrameLayout {
    private Paint bgPaint;
    private boolean calculating;
    TextView calculatingTextView;
    View divider;
    TextView freeSizeTextView;
    int lastProgressColor;
    ViewGroup legendLayout;
    private Paint paintFill;
    private Paint paintProgress;
    private Paint paintProgress2;
    float progress;
    float progress2;
    ProgressView progressView;
    TextView rubikaCacheTextView;
    TextView rubikaDatabaseTextView;
    TextSettingsCell textSettingsCell;
    TextView totlaSizeTextView;
    ValueAnimator valueAnimator;
    ValueAnimator valueAnimator2;

    public StroageUsageView(Context context) {
        super(context);
        this.paintFill = new Paint(1);
        this.paintProgress = new Paint(1);
        this.paintProgress2 = new Paint(1);
        this.bgPaint = new Paint();
        setWillNotDraw(false);
        this.paintFill.setStrokeWidth(AndroidUtilities.dp(6.0f));
        this.paintProgress.setStrokeWidth(AndroidUtilities.dp(6.0f));
        this.paintProgress2.setStrokeWidth(AndroidUtilities.dp(6.0f));
        this.paintFill.setStrokeCap(Paint.Cap.ROUND);
        this.paintProgress.setStrokeCap(Paint.Cap.ROUND);
        this.paintProgress2.setStrokeCap(Paint.Cap.ROUND);
        ProgressView progressView = new ProgressView(context);
        this.progressView = progressView;
        addView(progressView, LayoutHelper.createFrame(-1, -2.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f));
        FrameLayout frameLayout = new FrameLayout(this, context) { // from class: org.rbmain.ui.StroageUsageView.1
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), i2);
                int childCount = getChildCount();
                int measuredHeight = 0;
                int measuredWidth = 0;
                int measuredHeight2 = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (getChildAt(i3).getVisibility() != 8) {
                        if (getChildAt(i3).getMeasuredWidth() + measuredWidth > View.MeasureSpec.getSize(i)) {
                            measuredHeight2 += getChildAt(i3).getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                            measuredWidth = 0;
                        }
                        measuredWidth += getChildAt(i3).getMeasuredWidth() + AndroidUtilities.dp(16.0f);
                        measuredHeight = getChildAt(i3).getMeasuredHeight() + measuredHeight2;
                    }
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                int childCount = getChildCount();
                int measuredWidth = 0;
                int measuredHeight = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    if (getChildAt(i5).getVisibility() != 8) {
                        if (getChildAt(i5).getMeasuredWidth() + measuredWidth > getMeasuredWidth()) {
                            measuredHeight += getChildAt(i5).getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                            measuredWidth = 0;
                        }
                        getChildAt(i5).layout(measuredWidth, measuredHeight, getChildAt(i5).getMeasuredWidth() + measuredWidth, getChildAt(i5).getMeasuredHeight() + measuredHeight);
                        measuredWidth += getChildAt(i5).getMeasuredWidth() + AndroidUtilities.dp(16.0f);
                    }
                }
            }
        };
        this.legendLayout = frameLayout;
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 21.0f, 40.0f, 21.0f, 16.0f));
        TextView textView = new TextView(context);
        this.calculatingTextView = textView;
        int i = Theme.key_windowBackgroundWhiteGrayText;
        textView.setTextColor(Theme.getColor(i));
        this.calculatingTextView.setText(LocaleController.getString("CalculatingSize", R.string.CalculatingSize));
        TextView textView2 = new TextView(context);
        this.rubikaCacheTextView = textView2;
        textView2.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.rubikaCacheTextView.setTextColor(Theme.getColor(i));
        TextView textView3 = new TextView(context);
        this.rubikaDatabaseTextView = textView3;
        textView3.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.rubikaDatabaseTextView.setTextColor(Theme.getColor(i));
        TextView textView4 = new TextView(context);
        this.freeSizeTextView = textView4;
        textView4.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.freeSizeTextView.setTextColor(Theme.getColor(i));
        TextView textView5 = new TextView(context);
        this.totlaSizeTextView = textView5;
        textView5.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.totlaSizeTextView.setTextColor(Theme.getColor(i));
        this.lastProgressColor = Theme.getColor(Theme.key_player_progress);
        this.rubikaCacheTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
        this.rubikaCacheTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.freeSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 64)), (Drawable) null, (Drawable) null, (Drawable) null);
        this.freeSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.totlaSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 127)), (Drawable) null, (Drawable) null, (Drawable) null);
        this.totlaSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.rubikaDatabaseTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
        this.rubikaDatabaseTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.legendLayout.addView(this.calculatingTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.rubikaDatabaseTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.rubikaCacheTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.totlaSizeTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.freeSizeTextView, LayoutHelper.createFrame(-2, -2.0f));
        View view = new View(getContext());
        this.divider = view;
        linearLayout.addView(view, LayoutHelper.createLinear(-1, -2, 0, 21, 0, 0, 0));
        this.divider.getLayoutParams().height = 1;
        this.divider.setBackgroundColor(Theme.getColor(Theme.key_divider));
        TextSettingsCell textSettingsCell = new TextSettingsCell(getContext());
        this.textSettingsCell = textSettingsCell;
        linearLayout.addView(textSettingsCell, LayoutHelper.createLinear(-1, -2));
    }

    public void setStorageUsage(boolean z, long j, long j2, long j3, long j4) {
        this.calculating = z;
        this.freeSizeTextView.setText(LocaleController.formatString("TotalDeviceFreeSize", R.string.TotalDeviceFreeSize, AndroidUtilities.formatFileSize(j3)));
        long j5 = j4 - j3;
        this.totlaSizeTextView.setText(LocaleController.formatString("TotalDeviceSize", R.string.TotalDeviceSize, AndroidUtilities.formatFileSize(j5)));
        if (z) {
            this.calculatingTextView.setVisibility(0);
            this.rubikaCacheTextView.setVisibility(8);
            this.freeSizeTextView.setVisibility(8);
            this.totlaSizeTextView.setVisibility(8);
            this.rubikaDatabaseTextView.setVisibility(8);
            this.divider.setVisibility(8);
            this.textSettingsCell.setVisibility(8);
            this.progress = 0.0f;
            this.progress2 = 0.0f;
        } else {
            this.calculatingTextView.setVisibility(8);
            if (j2 > 0) {
                this.divider.setVisibility(0);
                this.textSettingsCell.setVisibility(0);
                this.rubikaCacheTextView.setVisibility(0);
                this.rubikaDatabaseTextView.setVisibility(8);
                this.textSettingsCell.setText(LocaleController.getString("ClearRubikaCache", R.string.ClearRubikaCache), false);
                this.rubikaCacheTextView.setText(LocaleController.formatString("RubikaCacheSize", R.string.RubikaCacheSize, AndroidUtilities.formatFileSize(j2 + j)));
            } else {
                this.rubikaCacheTextView.setVisibility(8);
                this.rubikaDatabaseTextView.setVisibility(0);
                this.rubikaDatabaseTextView.setText(LocaleController.formatString("LocalDatabaseSize", R.string.LocalDatabaseSize, AndroidUtilities.formatFileSize(j)));
                this.divider.setVisibility(8);
                this.textSettingsCell.setVisibility(8);
            }
            this.freeSizeTextView.setVisibility(0);
            this.totlaSizeTextView.setVisibility(0);
            float f = j4;
            float f2 = (j2 + j) / f;
            float f3 = j5 / f;
            if (this.progress != f2) {
                ValueAnimator valueAnimator = this.valueAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.progress, f2);
                this.valueAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.StroageUsageView$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$setStorageUsage$0(valueAnimator2);
                    }
                });
                this.valueAnimator.start();
            }
            if (this.progress2 != f3) {
                ValueAnimator valueAnimator2 = this.valueAnimator2;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.progress2, f3);
                this.valueAnimator2 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.StroageUsageView$$ExternalSyntheticLambda1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        this.f$0.lambda$setStorageUsage$1(valueAnimator3);
                    }
                });
                this.valueAnimator2.start();
            }
        }
        this.textSettingsCell.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setStorageUsage$0(ValueAnimator valueAnimator) {
        this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setStorageUsage$1(ValueAnimator valueAnimator) {
        this.progress2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.progressView.invalidate();
        int i = this.lastProgressColor;
        int i2 = Theme.key_player_progress;
        if (i != Theme.getColor(i2)) {
            this.lastProgressColor = Theme.getColor(i2);
            this.rubikaCacheTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
            this.rubikaCacheTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
            this.rubikaDatabaseTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
            this.rubikaDatabaseTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
            this.freeSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 64)), (Drawable) null, (Drawable) null, (Drawable) null);
            this.freeSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
            this.totlaSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 127)), (Drawable) null, (Drawable) null, (Drawable) null);
            this.totlaSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        }
        this.textSettingsCell.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.divider.setBackgroundColor(Theme.getColor(Theme.key_divider));
    }

    private class ProgressView extends View {
        public ProgressView(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40.0f), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int color = Theme.getColor(Theme.key_player_progress);
            StroageUsageView.this.paintFill.setColor(color);
            StroageUsageView.this.paintProgress.setColor(color);
            StroageUsageView.this.paintProgress2.setColor(color);
            StroageUsageView.this.paintProgress.setAlpha(255);
            StroageUsageView.this.paintProgress2.setAlpha(82);
            StroageUsageView.this.paintFill.setAlpha(46);
            StroageUsageView.this.bgPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            canvas.drawLine(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(20.0f), getMeasuredWidth() - AndroidUtilities.dp(24.0f), AndroidUtilities.dp(20.0f), StroageUsageView.this.paintFill);
            int iDp = AndroidUtilities.dp(24.0f);
            if (!StroageUsageView.this.calculating) {
                int iDp2 = AndroidUtilities.dp(24.0f) + ((int) ((getMeasuredWidth() - (AndroidUtilities.dp(24.0f) * 2)) * StroageUsageView.this.progress2));
                canvas.drawLine(iDp, AndroidUtilities.dp(20.0f), AndroidUtilities.dp(24.0f) + r4, AndroidUtilities.dp(20.0f), StroageUsageView.this.paintProgress2);
                canvas.drawRect(iDp2, AndroidUtilities.dp(20.0f) - AndroidUtilities.dp(3.0f), iDp2 + AndroidUtilities.dp(3.0f), AndroidUtilities.dp(20.0f) + AndroidUtilities.dp(3.0f), StroageUsageView.this.bgPaint);
            }
            if (StroageUsageView.this.calculating) {
                return;
            }
            int measuredWidth = (int) ((getMeasuredWidth() - (AndroidUtilities.dp(24.0f) * 2)) * StroageUsageView.this.progress);
            if (measuredWidth < AndroidUtilities.dp(1.0f)) {
                measuredWidth = AndroidUtilities.dp(1.0f);
            }
            int iDp3 = AndroidUtilities.dp(24.0f) + measuredWidth;
            canvas.drawLine(iDp, AndroidUtilities.dp(20.0f), AndroidUtilities.dp(24.0f) + measuredWidth, AndroidUtilities.dp(20.0f), StroageUsageView.this.paintProgress);
            canvas.drawRect(iDp3, AndroidUtilities.dp(20.0f) - AndroidUtilities.dp(3.0f), iDp3 + AndroidUtilities.dp(3.0f), AndroidUtilities.dp(20.0f) + AndroidUtilities.dp(3.0f), StroageUsageView.this.bgPaint);
        }
    }
}
