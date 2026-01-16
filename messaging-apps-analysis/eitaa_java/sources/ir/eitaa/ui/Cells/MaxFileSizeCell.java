package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.SeekBarView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MaxFileSizeCell extends FrameLayout {
    private long currentSize;
    private SeekBarView seekBarView;
    private TextView sizeTextView;
    private TextView textView;

    protected void didChangedSizeValue(int value) {
    }

    public MaxFileSizeCell(Context context) {
        super(context);
        setWillNotDraw(false);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setImportantForAccessibility(2);
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, (LocaleController.isRTL ? 5 : 3) | 48, 21.0f, 13.0f, 21.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.sizeTextView = textView2;
        textView2.setTextColor(Theme.getColor("dialogTextBlue2"));
        this.sizeTextView.setTextSize(1, 16.0f);
        this.sizeTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.sizeTextView.setLines(1);
        this.sizeTextView.setMaxLines(1);
        this.sizeTextView.setSingleLine(true);
        this.sizeTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 48);
        this.sizeTextView.setImportantForAccessibility(2);
        addView(this.sizeTextView, LayoutHelper.createFrame(-2, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, 21.0f, 13.0f, 21.0f, 0.0f));
        SeekBarView seekBarView = new SeekBarView(context) { // from class: ir.eitaa.ui.Cells.MaxFileSizeCell.1
            @Override // ir.eitaa.ui.Components.SeekBarView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (event.getAction() == 0) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onTouchEvent(event);
            }
        };
        this.seekBarView = seekBarView;
        seekBarView.setReportChanges(true);
        this.seekBarView.setDelegate(new SeekBarView.SeekBarViewDelegate() { // from class: ir.eitaa.ui.Cells.MaxFileSizeCell.2
            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public /* synthetic */ int getStepsCount() {
                return SeekBarView.SeekBarViewDelegate.CC.$default$getStepsCount(this);
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public void onSeekBarPressed(boolean pressed) {
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public void onSeekBarDrag(boolean stop, float progress) {
                int i;
                float f;
                float f2;
                if (progress <= 0.25f) {
                    f = 512000;
                    f2 = 536576.0f;
                } else {
                    progress -= 0.25f;
                    if (progress < 0.25f) {
                        f = 1048576;
                        f2 = 9437184.0f;
                    } else {
                        progress -= 0.25f;
                        if (progress > 0.25f) {
                            i = (int) (104857600 + ((FileLoader.MAX_FILE_SIZE - 104857600) * ((progress - 0.25f) / 0.25f)));
                            long j = i;
                            MaxFileSizeCell.this.sizeTextView.setText(LocaleController.formatString("AutodownloadSizeLimitUpTo", R.string.AutodownloadSizeLimitUpTo, AndroidUtilities.formatFileSize(j)));
                            MaxFileSizeCell.this.currentSize = j;
                            MaxFileSizeCell.this.didChangedSizeValue(i);
                        }
                        f = 10485760;
                        f2 = 9.437184E7f;
                    }
                }
                i = (int) (f + ((progress / 0.25f) * f2));
                long j2 = i;
                MaxFileSizeCell.this.sizeTextView.setText(LocaleController.formatString("AutodownloadSizeLimitUpTo", R.string.AutodownloadSizeLimitUpTo, AndroidUtilities.formatFileSize(j2)));
                MaxFileSizeCell.this.currentSize = j2;
                MaxFileSizeCell.this.didChangedSizeValue(i);
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public CharSequence getContentDescription() {
                return ((Object) MaxFileSizeCell.this.textView.getText()) + " " + ((Object) MaxFileSizeCell.this.sizeTextView.getText());
            }
        });
        this.seekBarView.setImportantForAccessibility(2);
        addView(this.seekBarView, LayoutHelper.createFrame(-1, 38.0f, 51, 6.0f, 36.0f, 6.0f, 0.0f));
        setImportantForAccessibility(1);
        setAccessibilityDelegate(this.seekBarView.getSeekBarAccessibilityDelegate());
    }

    public void setText(String text) {
        this.textView.setText(text);
    }

    public long getSize() {
        return this.currentSize;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(80.0f));
        int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(42.0f);
        this.sizeTextView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(30.0f), 1073741824));
        this.textView.measure(View.MeasureSpec.makeMeasureSpec(Math.max(AndroidUtilities.dp(10.0f), (measuredWidth - this.sizeTextView.getMeasuredWidth()) - AndroidUtilities.dp(8.0f)), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(30.0f), 1073741824));
        this.seekBarView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - AndroidUtilities.dp(20.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(30.0f), 1073741824));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isEnabled()) {
            return super.onInterceptTouchEvent(ev);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isEnabled()) {
            return super.dispatchTouchEvent(ev);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled()) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    public void setSize(long size) {
        float fMax;
        float fMax2;
        this.currentSize = size;
        this.sizeTextView.setText(LocaleController.formatString("AutodownloadSizeLimitUpTo", R.string.AutodownloadSizeLimitUpTo, AndroidUtilities.formatFileSize(size)));
        long j = size - 512000;
        if (j < 536576) {
            fMax2 = Math.max(0.0f, j / 536576.0f) * 0.25f;
        } else {
            long j2 = j - 536576;
            if (j2 < 9437184) {
                fMax2 = (Math.max(0.0f, j2 / 9437184.0f) * 0.25f) + 0.25f;
            } else {
                float f = 0.5f;
                long j3 = j2 - 9437184;
                if (j3 < 94371840) {
                    fMax = Math.max(0.0f, j3 / 9.437184E7f);
                } else {
                    f = 0.75f;
                    fMax = Math.max(0.0f, (j3 - 94371840) / 1.9922944E9f);
                }
                fMax2 = (fMax * 0.25f) + f;
            }
        }
        this.seekBarView.setProgress(Math.min(1.0f, fMax2));
    }

    public void setEnabled(boolean value, ArrayList<Animator> animators) {
        super.setEnabled(value);
        if (animators != null) {
            TextView textView = this.textView;
            float[] fArr = new float[1];
            fArr[0] = value ? 1.0f : 0.5f;
            animators.add(ObjectAnimator.ofFloat(textView, "alpha", fArr));
            SeekBarView seekBarView = this.seekBarView;
            float[] fArr2 = new float[1];
            fArr2[0] = value ? 1.0f : 0.5f;
            animators.add(ObjectAnimator.ofFloat(seekBarView, "alpha", fArr2));
            TextView textView2 = this.sizeTextView;
            float[] fArr3 = new float[1];
            fArr3[0] = value ? 1.0f : 0.5f;
            animators.add(ObjectAnimator.ofFloat(textView2, "alpha", fArr3));
            return;
        }
        this.textView.setAlpha(value ? 1.0f : 0.5f);
        this.seekBarView.setAlpha(value ? 1.0f : 0.5f);
        this.sizeTextView.setAlpha(value ? 1.0f : 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
    }
}
