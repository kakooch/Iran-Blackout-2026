package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.SeekBarView;

/* loaded from: classes3.dex */
public class BrightnessControlCell extends FrameLayout {
    private ImageView leftImageView;
    private ImageView rightImageView;
    private SeekBarView seekBarView;

    protected void didChangedValue(float value) {
    }

    public BrightnessControlCell(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        this.leftImageView = imageView;
        imageView.setImageResource(R.drawable.brightness_low);
        addView(this.leftImageView, LayoutHelper.createFrame(24, 24.0f, 51, 17.0f, 12.0f, 0.0f, 0.0f));
        SeekBarView seekBarView = new SeekBarView(context, true, null) { // from class: ir.eitaa.ui.Cells.BrightnessControlCell.1
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
        this.seekBarView.setDelegate(new SeekBarView.SeekBarViewDelegate() { // from class: ir.eitaa.ui.Cells.BrightnessControlCell.2
            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public CharSequence getContentDescription() {
                return " ";
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public /* synthetic */ int getStepsCount() {
                return SeekBarView.SeekBarViewDelegate.CC.$default$getStepsCount(this);
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public void onSeekBarPressed(boolean pressed) {
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public void onSeekBarDrag(boolean stop, float progress) {
                BrightnessControlCell.this.didChangedValue(progress);
            }
        });
        this.seekBarView.setImportantForAccessibility(2);
        addView(this.seekBarView, LayoutHelper.createFrame(-1, 38.0f, 51, 54.0f, 5.0f, 54.0f, 0.0f));
        ImageView imageView2 = new ImageView(context);
        this.rightImageView = imageView2;
        imageView2.setImageResource(R.drawable.brightness_high);
        addView(this.rightImageView, LayoutHelper.createFrame(24, 24.0f, 53, 0.0f, 12.0f, 17.0f, 0.0f));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.leftImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
        this.rightImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
    }

    public void setProgress(float value) {
        this.seekBarView.setProgress(value);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        this.seekBarView.getSeekBarAccessibilityDelegate().onInitializeAccessibilityNodeInfoInternal(this, info);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        return super.performAccessibilityAction(action, arguments) || this.seekBarView.getSeekBarAccessibilityDelegate().performAccessibilityActionInternal(this, action, arguments);
    }
}
