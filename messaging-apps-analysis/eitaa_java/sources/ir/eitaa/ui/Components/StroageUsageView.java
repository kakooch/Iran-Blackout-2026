package ir.eitaa.ui.Components;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.voip.CellFlickerDrawable;

/* loaded from: classes3.dex */
public class StroageUsageView extends FrameLayout {
    private Paint bgPaint;
    private boolean calculating;
    float calculatingProgress;
    boolean calculatingProgressIncrement;
    TextView calculatingTextView;
    CellFlickerDrawable cellFlickerDrawable;
    View divider;
    TextView eitaaCacheTextView;
    TextView eitaaDatabaseTextView;
    EllipsizeSpanAnimator ellipsizeSpanAnimator;
    TextView freeSizeTextView;
    int lastProgressColor;
    public ViewGroup legendLayout;
    private Paint paintCalculcating;
    private Paint paintFill;
    private Paint paintProgress;
    private Paint paintProgress2;
    float progress;
    float progress2;
    ProgressView progressView;
    TextSettingsCell textSettingsCell;
    private long totalDeviceFreeSize;
    private long totalDeviceSize;
    private long totalSize;
    TextView totlaSizeTextView;
    ValueAnimator valueAnimator;
    ValueAnimator valueAnimator2;

    public StroageUsageView(Context context) {
        super(context);
        this.paintFill = new Paint(1);
        this.paintCalculcating = new Paint(1);
        this.paintProgress = new Paint(1);
        this.paintProgress2 = new Paint(1);
        this.bgPaint = new Paint();
        this.cellFlickerDrawable = new CellFlickerDrawable(220, 255);
        setWillNotDraw(false);
        this.cellFlickerDrawable.drawFrame = false;
        this.paintFill.setStrokeWidth(AndroidUtilities.dp(6.0f));
        this.paintCalculcating.setStrokeWidth(AndroidUtilities.dp(6.0f));
        this.paintProgress.setStrokeWidth(AndroidUtilities.dp(6.0f));
        this.paintProgress2.setStrokeWidth(AndroidUtilities.dp(6.0f));
        this.paintFill.setStrokeCap(Paint.Cap.ROUND);
        this.paintCalculcating.setStrokeCap(Paint.Cap.ROUND);
        this.paintProgress.setStrokeCap(Paint.Cap.ROUND);
        this.paintProgress2.setStrokeCap(Paint.Cap.ROUND);
        ProgressView progressView = new ProgressView(context);
        this.progressView = progressView;
        addView(progressView, LayoutHelper.createFrame(-1, -2.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.StroageUsageView.1
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), heightMeasureSpec);
                int childCount = getChildCount();
                int measuredHeight = 0;
                int measuredWidth = 0;
                int measuredHeight2 = 0;
                for (int i = 0; i < childCount; i++) {
                    if (getChildAt(i).getVisibility() != 8) {
                        if (getChildAt(i).getMeasuredWidth() + measuredWidth > View.MeasureSpec.getSize(widthMeasureSpec)) {
                            measuredHeight2 += getChildAt(i).getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                            measuredWidth = 0;
                        }
                        measuredWidth += getChildAt(i).getMeasuredWidth() + AndroidUtilities.dp(16.0f);
                        measuredHeight = getChildAt(i).getMeasuredHeight() + measuredHeight2;
                    }
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                int childCount = getChildCount();
                int measuredWidth = 0;
                int measuredHeight = 0;
                for (int i = 0; i < childCount; i++) {
                    if (getChildAt(i).getVisibility() != 8) {
                        if (getChildAt(i).getMeasuredWidth() + measuredWidth > getMeasuredWidth()) {
                            measuredHeight += getChildAt(i).getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                            measuredWidth = 0;
                        }
                        getChildAt(i).layout(measuredWidth, measuredHeight, getChildAt(i).getMeasuredWidth() + measuredWidth, getChildAt(i).getMeasuredHeight() + measuredHeight);
                        measuredWidth += getChildAt(i).getMeasuredWidth() + AndroidUtilities.dp(16.0f);
                    }
                }
            }
        };
        this.legendLayout = frameLayout;
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 21.0f, 40.0f, 21.0f, 16.0f));
        TextView textView = new TextView(context);
        this.calculatingTextView = textView;
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.calculatingTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        String string = LocaleController.getString("CalculatingSize", R.string.CalculatingSize);
        int iIndexOf = string.indexOf("...");
        if (iIndexOf >= 0) {
            SpannableString spannableString = new SpannableString(string);
            EllipsizeSpanAnimator ellipsizeSpanAnimator = new EllipsizeSpanAnimator(this.calculatingTextView);
            this.ellipsizeSpanAnimator = ellipsizeSpanAnimator;
            ellipsizeSpanAnimator.wrap(spannableString, iIndexOf);
            this.calculatingTextView.setText(spannableString);
        } else {
            this.calculatingTextView.setText(string);
        }
        TextView textView2 = new TextView(context);
        this.eitaaCacheTextView = textView2;
        textView2.setTypeface(AndroidUtilities.getFontFamily(false));
        this.eitaaCacheTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.eitaaCacheTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        TextView textView3 = new TextView(context);
        this.eitaaDatabaseTextView = textView3;
        textView3.setTypeface(AndroidUtilities.getFontFamily(false));
        this.eitaaDatabaseTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.eitaaDatabaseTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        TextView textView4 = new TextView(context);
        this.freeSizeTextView = textView4;
        textView4.setTypeface(AndroidUtilities.getFontFamily(false));
        this.freeSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.freeSizeTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        TextView textView5 = new TextView(context);
        this.totlaSizeTextView = textView5;
        textView5.setTypeface(AndroidUtilities.getFontFamily(false));
        this.totlaSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.totlaSizeTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        this.lastProgressColor = Theme.getColor("player_progress");
        this.eitaaCacheTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eitaaCacheTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.freeSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 64)), (Drawable) null, (Drawable) null, (Drawable) null);
        this.freeSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.totlaSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 127)), (Drawable) null, (Drawable) null, (Drawable) null);
        this.totlaSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.eitaaDatabaseTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eitaaDatabaseTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        this.legendLayout.addView(this.calculatingTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.eitaaDatabaseTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.eitaaCacheTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.totlaSizeTextView, LayoutHelper.createFrame(-2, -2.0f));
        this.legendLayout.addView(this.freeSizeTextView, LayoutHelper.createFrame(-2, -2.0f));
        View view = new View(getContext());
        this.divider = view;
        linearLayout.addView(view, LayoutHelper.createLinear(-1, -2, 0, 21, 0, 0, 0));
        this.divider.getLayoutParams().height = 1;
        this.divider.setBackgroundColor(Theme.getColor("divider"));
        TextSettingsCell textSettingsCell = new TextSettingsCell(getContext());
        this.textSettingsCell = textSettingsCell;
        linearLayout.addView(textSettingsCell, LayoutHelper.createLinear(-1, -2));
    }

    public void setStorageUsage(boolean calculating, long database, long totalSize, long totalDeviceFreeSize, long totalDeviceSize) {
        this.calculating = calculating;
        this.totalSize = totalSize;
        this.totalDeviceFreeSize = totalDeviceFreeSize;
        this.totalDeviceSize = totalDeviceSize;
        this.freeSizeTextView.setText(LocaleController.formatString("TotalDeviceFreeSize", R.string.TotalDeviceFreeSize, AndroidUtilities.formatFileSize(totalDeviceFreeSize)));
        long j = totalDeviceSize - totalDeviceFreeSize;
        this.totlaSizeTextView.setText(LocaleController.formatString("TotalDeviceSize", R.string.TotalDeviceSize, AndroidUtilities.formatFileSize(j)));
        if (calculating) {
            this.calculatingTextView.setVisibility(0);
            this.eitaaCacheTextView.setVisibility(8);
            this.freeSizeTextView.setVisibility(8);
            this.totlaSizeTextView.setVisibility(8);
            this.eitaaDatabaseTextView.setVisibility(8);
            this.divider.setVisibility(8);
            this.textSettingsCell.setVisibility(8);
            this.progress = 0.0f;
            this.progress2 = 0.0f;
            EllipsizeSpanAnimator ellipsizeSpanAnimator = this.ellipsizeSpanAnimator;
            if (ellipsizeSpanAnimator != null) {
                ellipsizeSpanAnimator.addView(this.calculatingTextView);
            }
        } else {
            EllipsizeSpanAnimator ellipsizeSpanAnimator2 = this.ellipsizeSpanAnimator;
            if (ellipsizeSpanAnimator2 != null) {
                ellipsizeSpanAnimator2.removeView(this.calculatingTextView);
            }
            this.calculatingTextView.setVisibility(8);
            if (totalSize > 0) {
                this.divider.setVisibility(0);
                this.textSettingsCell.setVisibility(0);
                this.eitaaCacheTextView.setVisibility(0);
                this.eitaaDatabaseTextView.setVisibility(8);
                this.textSettingsCell.setText(LocaleController.getString("ClearEitaaCache", R.string.ClearEitaaCache), false);
                this.eitaaCacheTextView.setText(LocaleController.formatString("EitaaCacheSize", R.string.EitaaCacheSize, AndroidUtilities.formatFileSize(totalSize + database)));
            } else {
                this.eitaaCacheTextView.setVisibility(8);
                this.eitaaDatabaseTextView.setVisibility(0);
                this.eitaaDatabaseTextView.setText(LocaleController.formatString("LocalDatabaseSize", R.string.LocalDatabaseSize, AndroidUtilities.formatFileSize(database)));
                this.divider.setVisibility(8);
                this.textSettingsCell.setVisibility(8);
            }
            this.freeSizeTextView.setVisibility(0);
            this.totlaSizeTextView.setVisibility(0);
            float f = totalDeviceSize;
            float f2 = (totalSize + database) / f;
            float f3 = j / f;
            if (this.progress != f2) {
                ValueAnimator valueAnimator = this.valueAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.progress, f2);
                this.valueAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StroageUsageView$P49q2p6hs7eFeulTTHADfRRL1g4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$setStorageUsage$0$StroageUsageView(valueAnimator2);
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
                valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StroageUsageView$ROm7J9UuQW6Hpdf_zM8HhnuEvR0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        this.f$0.lambda$setStorageUsage$1$StroageUsageView(valueAnimator3);
                    }
                });
                this.valueAnimator2.start();
            }
        }
        this.textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setStorageUsage$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setStorageUsage$0$StroageUsageView(ValueAnimator valueAnimator) {
        this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setStorageUsage$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setStorageUsage$1$StroageUsageView(ValueAnimator valueAnimator) {
        this.progress2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.progressView.invalidate();
        if (this.lastProgressColor != Theme.getColor("player_progress")) {
            this.lastProgressColor = Theme.getColor("player_progress");
            this.eitaaCacheTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
            this.eitaaCacheTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
            this.eitaaDatabaseTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), this.lastProgressColor), (Drawable) null, (Drawable) null, (Drawable) null);
            this.eitaaDatabaseTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
            this.freeSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 64)), (Drawable) null, (Drawable) null, (Drawable) null);
            this.freeSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
            this.totlaSizeTextView.setCompoundDrawablesWithIntrinsicBounds(Theme.createCircleDrawable(AndroidUtilities.dp(10.0f), ColorUtils.setAlphaComponent(this.lastProgressColor, 127)), (Drawable) null, (Drawable) null, (Drawable) null);
            this.totlaSizeTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
        }
        this.textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.divider.setBackgroundColor(Theme.getColor("divider"));
    }

    private class ProgressView extends View {
        public ProgressView(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40.0f), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int color = Theme.getColor("player_progress");
            StroageUsageView.this.paintFill.setColor(color);
            StroageUsageView.this.paintProgress.setColor(color);
            StroageUsageView.this.paintProgress2.setColor(color);
            StroageUsageView.this.paintProgress.setAlpha(255);
            StroageUsageView.this.paintProgress2.setAlpha(82);
            StroageUsageView.this.paintFill.setAlpha(46);
            StroageUsageView.this.bgPaint.setColor(Theme.getColor("windowBackgroundWhite"));
            canvas.drawLine(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(20.0f), getMeasuredWidth() - AndroidUtilities.dp(24.0f), AndroidUtilities.dp(20.0f), StroageUsageView.this.paintFill);
            if (StroageUsageView.this.calculating || StroageUsageView.this.calculatingProgress != 0.0f) {
                if (StroageUsageView.this.calculating) {
                    StroageUsageView stroageUsageView = StroageUsageView.this;
                    if (stroageUsageView.calculatingProgressIncrement) {
                        float f = stroageUsageView.calculatingProgress + 0.024615385f;
                        stroageUsageView.calculatingProgress = f;
                        if (f > 1.0f) {
                            stroageUsageView.calculatingProgress = 1.0f;
                            stroageUsageView.calculatingProgressIncrement = false;
                        }
                    } else {
                        float f2 = stroageUsageView.calculatingProgress - 0.024615385f;
                        stroageUsageView.calculatingProgress = f2;
                        if (f2 < 0.0f) {
                            stroageUsageView.calculatingProgress = 0.0f;
                            stroageUsageView.calculatingProgressIncrement = true;
                        }
                    }
                } else {
                    StroageUsageView stroageUsageView2 = StroageUsageView.this;
                    float f3 = stroageUsageView2.calculatingProgress - 0.10666667f;
                    stroageUsageView2.calculatingProgress = f3;
                    if (f3 < 0.0f) {
                        stroageUsageView2.calculatingProgress = 0.0f;
                    }
                }
                invalidate();
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(17.0f), getMeasuredWidth() - AndroidUtilities.dp(24.0f), AndroidUtilities.dp(23.0f));
                StroageUsageView.this.cellFlickerDrawable.setParentWidth(getMeasuredWidth());
                StroageUsageView.this.cellFlickerDrawable.draw(canvas, rectF, AndroidUtilities.dp(3.0f));
            }
            int iDp = AndroidUtilities.dp(24.0f);
            if (!StroageUsageView.this.calculating) {
                int iDp2 = AndroidUtilities.dp(24.0f) + ((int) ((getMeasuredWidth() - (AndroidUtilities.dp(24.0f) * 2)) * StroageUsageView.this.progress2));
                canvas.drawLine(iDp, AndroidUtilities.dp(20.0f), AndroidUtilities.dp(24.0f) + r5, AndroidUtilities.dp(20.0f), StroageUsageView.this.paintProgress2);
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EllipsizeSpanAnimator ellipsizeSpanAnimator = this.ellipsizeSpanAnimator;
        if (ellipsizeSpanAnimator != null) {
            ellipsizeSpanAnimator.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EllipsizeSpanAnimator ellipsizeSpanAnimator = this.ellipsizeSpanAnimator;
        if (ellipsizeSpanAnimator != null) {
            ellipsizeSpanAnimator.onDetachedFromWindow();
        }
    }
}
