package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.Switch;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TextCheckCell extends FrameLayout {
    public static final Property<TextCheckCell, Float> ANIMATION_PROGRESS = new AnimationProperties.FloatProperty<TextCheckCell>("animationProgress") { // from class: ir.eitaa.ui.Cells.TextCheckCell.1
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(TextCheckCell object, float value) {
            object.setAnimationProgress(value);
            object.invalidate();
        }

        @Override // android.util.Property
        public Float get(TextCheckCell object) {
            return Float.valueOf(object.animationProgress);
        }
    };
    private int animatedColorBackground;
    private Paint animationPaint;
    private float animationProgress;
    private ObjectAnimator animator;
    private Switch checkBox;
    private boolean drawCheckRipple;
    private int height;
    private boolean isMultiline;
    private float lastTouchX;
    private boolean needDivider;
    private TextView textView;
    private TextView valueTextView;

    public TextCheckCell(Context context) {
        this(context, 21);
    }

    public TextCheckCell(Context context, int padding) {
        this(context, padding, false);
    }

    public TextCheckCell(Context context, int padding, boolean dialog) {
        super(context);
        this.height = 50;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(dialog ? "dialogTextBlack" : "windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = this.textView;
        boolean z = LocaleController.isRTL;
        addView(textView2, LayoutHelper.createFrame(-1, -1.0f, (z ? 5 : 3) | 48, z ? 70.0f : padding, 0.0f, z ? padding : 70.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.valueTextView = textView3;
        textView3.setTextColor(Theme.getColor(dialog ? "dialogIcon" : "windowBackgroundWhiteGrayText2"));
        this.valueTextView.setTextSize(1, 13.0f);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setPadding(0, 0, 0, 0);
        this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView4 = this.valueTextView;
        boolean z2 = LocaleController.isRTL;
        addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 64.0f : padding, 36.0f, z2 ? padding : 64.0f, 0.0f));
        Switch r2 = new Switch(context);
        this.checkBox = r2;
        r2.setColors("switchTrack", "switchTrackChecked", "windowBackgroundWhite", "windowBackgroundWhite");
        addView(this.checkBox, LayoutHelper.createFrame(37, 20.0f, (LocaleController.isRTL ? 3 : 5) | 16, 22.0f, 0.0f, 22.0f, 0.0f));
        setClipChildren(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.isMultiline) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.valueTextView.getVisibility() == 0 ? 64.0f : this.height) + (this.needDivider ? 1 : 0), 1073741824));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.lastTouchX = event.getX();
        return super.onTouchEvent(event);
    }

    public void setTextAndCheck(String text, boolean checked, boolean divider) {
        this.textView.setText(text);
        this.isMultiline = false;
        this.checkBox.setChecked(checked, false);
        this.needDivider = divider;
        this.valueTextView.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.topMargin = 0;
        this.textView.setLayoutParams(layoutParams);
        setWillNotDraw(!divider);
    }

    public void setColors(String key, String switchKey, String switchKeyChecked, String switchThumb, String switchThumbChecked) {
        this.textView.setTextColor(Theme.getColor(key));
        this.checkBox.setColors(switchKey, switchKeyChecked, switchThumb, switchThumbChecked);
        this.textView.setTag(key);
    }

    public void setTypeface(Typeface typeface) {
        this.textView.setTypeface(typeface);
    }

    public void setHeight(int value) {
        this.height = value;
    }

    public void setDrawCheckRipple(boolean value) {
        this.drawCheckRipple = value;
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        if (this.drawCheckRipple) {
            this.checkBox.setDrawRipple(pressed);
        }
        super.setPressed(pressed);
    }

    public void setTextAndValueAndCheck(String text, String value, boolean checked, boolean multiline, boolean divider) {
        this.textView.setText(text);
        this.valueTextView.setText(value);
        this.checkBox.setChecked(checked, false);
        this.needDivider = divider;
        this.valueTextView.setVisibility(0);
        this.isMultiline = multiline;
        if (multiline) {
            this.valueTextView.setLines(0);
            this.valueTextView.setMaxLines(0);
            this.valueTextView.setSingleLine(false);
            this.valueTextView.setEllipsize(null);
            this.valueTextView.setPadding(0, 0, 0, AndroidUtilities.dp(11.0f));
        } else {
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.valueTextView.setPadding(0, 0, 0, 0);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.height = -2;
        layoutParams.topMargin = AndroidUtilities.dp(10.0f);
        this.textView.setLayoutParams(layoutParams);
        setWillNotDraw(true ^ divider);
    }

    public void setEnabled(boolean value, ArrayList<Animator> animators) {
        super.setEnabled(value);
        if (animators != null) {
            TextView textView = this.textView;
            float[] fArr = new float[1];
            fArr[0] = value ? 1.0f : 0.5f;
            animators.add(ObjectAnimator.ofFloat(textView, "alpha", fArr));
            Switch r2 = this.checkBox;
            float[] fArr2 = new float[1];
            fArr2[0] = value ? 1.0f : 0.5f;
            animators.add(ObjectAnimator.ofFloat(r2, "alpha", fArr2));
            if (this.valueTextView.getVisibility() == 0) {
                TextView textView2 = this.valueTextView;
                float[] fArr3 = new float[1];
                fArr3[0] = value ? 1.0f : 0.5f;
                animators.add(ObjectAnimator.ofFloat(textView2, "alpha", fArr3));
                return;
            }
            return;
        }
        this.textView.setAlpha(value ? 1.0f : 0.5f);
        this.checkBox.setAlpha(value ? 1.0f : 0.5f);
        if (this.valueTextView.getVisibility() == 0) {
            this.valueTextView.setAlpha(value ? 1.0f : 0.5f);
        }
    }

    public void setChecked(boolean checked) {
        this.checkBox.setChecked(checked, true);
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        clearAnimation();
        this.animatedColorBackground = 0;
        super.setBackgroundColor(color);
    }

    public void setBackgroundColorAnimated(boolean checked, int color) {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.animator = null;
        }
        int i = this.animatedColorBackground;
        if (i != 0) {
            setBackgroundColor(i);
        }
        if (this.animationPaint == null) {
            this.animationPaint = new Paint(1);
        }
        this.checkBox.setOverrideColor(checked ? 1 : 2);
        this.animatedColorBackground = color;
        this.animationPaint.setColor(color);
        this.animationProgress = 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, ANIMATION_PROGRESS, 0.0f, 1.0f);
        this.animator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.TextCheckCell.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                TextCheckCell textCheckCell = TextCheckCell.this;
                textCheckCell.setBackgroundColor(textCheckCell.animatedColorBackground);
                TextCheckCell.this.animatedColorBackground = 0;
                TextCheckCell.this.invalidate();
            }
        });
        this.animator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.animator.setDuration(240L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationProgress(float value) {
        this.animationProgress = value;
        float fMax = Math.max(this.lastTouchX, getMeasuredWidth() - this.lastTouchX) + AndroidUtilities.dp(40.0f);
        this.checkBox.setOverrideColorProgress(this.lastTouchX, getMeasuredHeight() / 2, fMax * this.animationProgress);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.animatedColorBackground != 0) {
            canvas.drawCircle(this.lastTouchX, getMeasuredHeight() / 2, (Math.max(this.lastTouchX, getMeasuredWidth() - this.lastTouchX) + AndroidUtilities.dp(40.0f)) * this.animationProgress, this.animationPaint);
        }
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        int i;
        String str;
        super.onInitializeAccessibilityNodeInfo(info);
        StringBuilder sb = new StringBuilder();
        sb.append(this.textView.getText().toString());
        sb.append(" ");
        if (this.checkBox.isChecked()) {
            i = R.string.NotificationsOn;
            str = "NotificationsOn";
        } else {
            i = R.string.NotificationsOff;
            str = "NotificationsOff";
        }
        sb.append(LocaleController.getString(str, i));
        info.setContentDescription(sb.toString());
    }
}
