package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AnimatedTextView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.Switch;

/* loaded from: classes4.dex */
public class TextCell extends FrameLayout {
    private int changeProgressStartDelay;
    private Switch checkBox;
    private boolean drawLoading;
    private float drawLoadingProgress;
    public int heightDp;
    public int imageLeft;
    public final RLottieImageView imageView;
    private boolean inDialogs;
    private boolean incrementLoadingProgress;
    private int lastWidth;
    private int leftPadding;
    private float loadingProgress;
    private int loadingSize;
    private boolean needDivider;
    public int offsetFromImage;
    Paint paint;
    private boolean prioritizeTitleOverValue;
    private Theme.ResourcesProvider resourcesProvider;
    private final SimpleTextView subtitleView;
    public final SimpleTextView textView;
    private ImageView valueImageView;
    public final SimpleTextView valueSpoilersTextView;
    private CharSequence valueText;
    public final AnimatedTextView valueTextView;

    protected int getOffsetFromImage(boolean z) {
        return z ? 65 : 71;
    }

    public TextCell(Context context) {
        this(context, 23, false, false, null);
    }

    public TextCell(Context context, int i, boolean z) {
        this(context, i, z, false, null);
    }

    public TextCell(Context context, int i, boolean z, boolean z2, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.offsetFromImage = 71;
        this.heightDp = 50;
        this.imageLeft = 21;
        this.resourcesProvider = resourcesProvider;
        this.leftPadding = i;
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.textView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor(z ? Theme.key_dialogTextBlack : Theme.key_windowBackgroundWhiteBlackText, resourcesProvider));
        simpleTextView.setTextSize(16);
        simpleTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        simpleTextView.setImportantForAccessibility(2);
        addView(simpleTextView, LayoutHelper.createFrame(-2, -1.0f));
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.subtitleView = simpleTextView2;
        simpleTextView2.setTextColor(Theme.getColor(z ? Theme.key_dialogTextGray : Theme.key_windowBackgroundWhiteGrayText, resourcesProvider));
        simpleTextView2.setTextSize(13);
        simpleTextView2.setGravity(LocaleController.isRTL ? 5 : 3);
        simpleTextView2.setImportantForAccessibility(2);
        addView(simpleTextView2, LayoutHelper.createFrame(-2, -1.0f));
        AnimatedTextView animatedTextView = new AnimatedTextView(context, false, false, true);
        this.valueTextView = animatedTextView;
        animatedTextView.setTextColor(Theme.getColor(z ? Theme.key_dialogTextBlue2 : Theme.key_windowBackgroundWhiteValueText, resourcesProvider));
        animatedTextView.setPadding(0, AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f));
        animatedTextView.setTextSize(AndroidUtilities.dp(16.0f));
        animatedTextView.setGravity(LocaleController.isRTL ? 3 : 5);
        animatedTextView.setImportantForAccessibility(2);
        animatedTextView.setTranslationY(AndroidUtilities.dp(-2.0f));
        addView(animatedTextView);
        SimpleTextView simpleTextView3 = new SimpleTextView(context);
        this.valueSpoilersTextView = simpleTextView3;
        simpleTextView3.setEllipsizeByGradient(18, Boolean.FALSE);
        simpleTextView3.setTextColor(Theme.getColor(z ? Theme.key_dialogTextBlue2 : Theme.key_windowBackgroundWhiteValueText, resourcesProvider));
        simpleTextView3.setGravity(LocaleController.isRTL ? 3 : 5);
        simpleTextView3.setTextSize(16);
        simpleTextView3.setImportantForAccessibility(2);
        simpleTextView3.setVisibility(8);
        addView(simpleTextView3);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        rLottieImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(z ? Theme.key_dialogIcon : Theme.key_windowBackgroundWhiteGrayIcon, resourcesProvider), PorterDuff.Mode.MULTIPLY));
        addView(rLottieImageView);
        ImageView imageView = new ImageView(context);
        this.valueImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.valueImageView);
        if (z2) {
            Switch r3 = new Switch(context, resourcesProvider);
            this.checkBox = r3;
            int i2 = Theme.key_switchTrack;
            int i3 = Theme.key_switchTrackChecked;
            int i4 = Theme.key_windowBackgroundWhite;
            r3.setColors(i2, i3, i4, i4);
            addView(this.checkBox, LayoutHelper.createFrame(37, 20.0f, (LocaleController.isRTL ? 3 : 5) | 16, 22.0f, 0.0f, 22.0f, 0.0f));
        }
        setFocusable(true);
    }

    public Switch getCheckBox() {
        return this.checkBox;
    }

    public void setIsInDialogs() {
        this.inDialogs = true;
    }

    public SimpleTextView getTextView() {
        return this.textView;
    }

    public RLottieImageView getImageView() {
        return this.imageView;
    }

    public AnimatedTextView getValueTextView() {
        return this.valueTextView;
    }

    public ImageView getValueImageView() {
        return this.valueImageView;
    }

    public void setPrioritizeTitleOverValue(boolean z) {
        if (this.prioritizeTitleOverValue != z) {
            this.prioritizeTitleOverValue = z;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        CharSequence charSequence;
        int size = View.MeasureSpec.getSize(i);
        int iDp = AndroidUtilities.dp(this.heightDp);
        int i3 = this.lastWidth;
        if (i3 != 0 && i3 != size && (charSequence = this.valueText) != null) {
            AnimatedTextView animatedTextView = this.valueTextView;
            animatedTextView.setText(TextUtils.ellipsize(charSequence, animatedTextView.getPaint(), AndroidUtilities.displaySize.x / 2.5f, TextUtils.TruncateAt.END), false);
        }
        this.lastWidth = size;
        if (this.prioritizeTitleOverValue) {
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(this.leftPadding + 71), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.subtitleView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(this.leftPadding + 71), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.valueTextView.measure(View.MeasureSpec.makeMeasureSpec((size - AndroidUtilities.dp(this.leftPadding + 103)) - this.textView.getTextWidth(), LocaleController.isRTL ? Integer.MIN_VALUE : 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.valueSpoilersTextView.measure(View.MeasureSpec.makeMeasureSpec((size - AndroidUtilities.dp(this.leftPadding + 103)) - this.textView.getTextWidth(), LocaleController.isRTL ? Integer.MIN_VALUE : 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
        } else {
            this.valueTextView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(this.leftPadding), LocaleController.isRTL ? Integer.MIN_VALUE : 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.valueSpoilersTextView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(this.leftPadding), LocaleController.isRTL ? Integer.MIN_VALUE : 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            int iMax = Math.max(this.valueTextView.width(), this.valueSpoilersTextView.getTextWidth());
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (size - AndroidUtilities.dp(this.leftPadding + 71)) - iMax), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.subtitleView.measure(View.MeasureSpec.makeMeasureSpec((size - AndroidUtilities.dp(this.leftPadding + 71)) - iMax, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
        }
        if (this.imageView.getVisibility() == 0) {
            this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
        }
        if (this.valueImageView.getVisibility() == 0) {
            this.valueImageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
        }
        Switch r0 = this.checkBox;
        if (r0 != null) {
            r0.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(37.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
        }
        setMeasuredDimension(size, iDp + (this.needDivider ? 1 : 0));
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        Switch r0 = this.checkBox;
        if (r0 != null) {
            r0.setEnabled(z);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iDp;
        int i5 = i4 - i2;
        int i6 = i3 - i;
        int iMax = (i5 - Math.max(this.valueSpoilersTextView.getTextHeight(), this.valueTextView.getTextHeight())) / 2;
        int iDp2 = LocaleController.isRTL ? AndroidUtilities.dp(this.leftPadding) : (i6 - this.valueTextView.getMeasuredWidth()) - AndroidUtilities.dp(this.leftPadding);
        if (this.prioritizeTitleOverValue && !LocaleController.isRTL) {
            iDp2 = (i6 - this.valueTextView.getMeasuredWidth()) - AndroidUtilities.dp(this.leftPadding);
        }
        AnimatedTextView animatedTextView = this.valueTextView;
        animatedTextView.layout(iDp2, iMax, animatedTextView.getMeasuredWidth() + iDp2, this.valueTextView.getMeasuredHeight() + iMax);
        int iDp3 = LocaleController.isRTL ? AndroidUtilities.dp(this.leftPadding) : (i6 - this.valueSpoilersTextView.getMeasuredWidth()) - AndroidUtilities.dp(this.leftPadding);
        SimpleTextView simpleTextView = this.valueSpoilersTextView;
        simpleTextView.layout(iDp3, iMax, simpleTextView.getMeasuredWidth() + iDp3, this.valueSpoilersTextView.getMeasuredHeight() + iMax);
        if (LocaleController.isRTL) {
            iDp = (getMeasuredWidth() - this.textView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? this.offsetFromImage : this.leftPadding);
        } else {
            iDp = AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? this.offsetFromImage : this.leftPadding);
        }
        if (this.subtitleView.getVisibility() == 0) {
            float f = this.heightDp > 50 ? 4 : 2;
            int textHeight = (((i5 - this.textView.getTextHeight()) - this.subtitleView.getTextHeight()) - AndroidUtilities.dp(f)) / 2;
            SimpleTextView simpleTextView2 = this.textView;
            simpleTextView2.layout(iDp, textHeight, simpleTextView2.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight);
            int textHeight2 = textHeight + this.textView.getTextHeight() + AndroidUtilities.dp(f);
            SimpleTextView simpleTextView3 = this.subtitleView;
            simpleTextView3.layout(iDp, textHeight2, simpleTextView3.getMeasuredWidth() + iDp, this.subtitleView.getMeasuredHeight() + textHeight2);
        } else {
            int textHeight3 = (i5 - this.textView.getTextHeight()) / 2;
            SimpleTextView simpleTextView4 = this.textView;
            simpleTextView4.layout(iDp, textHeight3, simpleTextView4.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight3);
        }
        if (this.imageView.getVisibility() == 0) {
            int iDp4 = (AndroidUtilities.dp(this.heightDp > 50 ? 0.0f : 2.0f) + ((i5 - this.imageView.getMeasuredHeight()) / 2)) - this.imageView.getPaddingTop();
            int iDp5 = !LocaleController.isRTL ? AndroidUtilities.dp(this.imageLeft) : (i6 - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageLeft);
            RLottieImageView rLottieImageView = this.imageView;
            rLottieImageView.layout(iDp5, iDp4, rLottieImageView.getMeasuredWidth() + iDp5, this.imageView.getMeasuredHeight() + iDp4);
        }
        if (this.valueImageView.getVisibility() == 0) {
            int measuredHeight = (i5 - this.valueImageView.getMeasuredHeight()) / 2;
            int iDp6 = LocaleController.isRTL ? AndroidUtilities.dp(23.0f) : (i6 - this.valueImageView.getMeasuredWidth()) - AndroidUtilities.dp(23.0f);
            ImageView imageView = this.valueImageView;
            imageView.layout(iDp6, measuredHeight, imageView.getMeasuredWidth() + iDp6, this.valueImageView.getMeasuredHeight() + measuredHeight);
        }
        Switch r6 = this.checkBox;
        if (r6 == null || r6.getVisibility() != 0) {
            return;
        }
        int measuredHeight2 = (i5 - this.checkBox.getMeasuredHeight()) / 2;
        int iDp7 = LocaleController.isRTL ? AndroidUtilities.dp(22.0f) : (i6 - this.checkBox.getMeasuredWidth()) - AndroidUtilities.dp(22.0f);
        Switch r7 = this.checkBox;
        r7.layout(iDp7, measuredHeight2, r7.getMeasuredWidth() + iDp7, this.checkBox.getMeasuredHeight() + measuredHeight2);
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public void setColors(int i, int i2) {
        this.textView.setTextColor(Theme.getColor(i2, this.resourcesProvider));
        this.textView.setTag(Integer.valueOf(i2));
        if (i >= 0) {
            this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i, this.resourcesProvider), PorterDuff.Mode.MULTIPLY));
            this.imageView.setTag(Integer.valueOf(i));
        }
    }

    public void setText(String str, boolean z) {
        this.imageLeft = 21;
        this.textView.setText(str);
        AnimatedTextView animatedTextView = this.valueTextView;
        this.valueText = null;
        animatedTextView.setText(null, false);
        this.imageView.setVisibility(8);
        this.valueTextView.setVisibility(8);
        this.valueSpoilersTextView.setVisibility(8);
        this.valueImageView.setVisibility(8);
        this.needDivider = z;
        setWillNotDraw(!z);
    }

    public void setTextAndIcon(String str, int i, boolean z) {
        this.imageLeft = 21;
        this.offsetFromImage = getOffsetFromImage(false);
        this.textView.setText(str);
        AnimatedTextView animatedTextView = this.valueTextView;
        this.valueText = null;
        animatedTextView.setText(null, false);
        this.imageView.setImageResource(i);
        this.imageView.setVisibility(0);
        this.valueTextView.setVisibility(8);
        this.valueSpoilersTextView.setVisibility(8);
        this.valueImageView.setVisibility(8);
        this.imageView.setPadding(0, AndroidUtilities.dp(7.0f), 0, 0);
        this.needDivider = z;
        setWillNotDraw(!z);
    }

    public void setTextAndIcon(String str, Drawable drawable, boolean z) {
        this.offsetFromImage = 68;
        this.imageLeft = 18;
        this.textView.setText(str);
        AnimatedTextView animatedTextView = this.valueTextView;
        this.valueText = null;
        animatedTextView.setText(null, false);
        this.imageView.setColorFilter((ColorFilter) null);
        if (drawable instanceof RLottieDrawable) {
            this.imageView.setAnimation((RLottieDrawable) drawable);
        } else {
            this.imageView.setImageDrawable(drawable);
        }
        this.imageView.setVisibility(0);
        this.valueTextView.setVisibility(8);
        this.valueImageView.setVisibility(8);
        this.imageView.setPadding(0, AndroidUtilities.dp(6.0f), 0, 0);
        this.needDivider = z;
        setWillNotDraw(!z);
    }

    public void setOffsetFromImage(int i) {
        this.offsetFromImage = i;
    }

    public void setImageLeft(int i) {
        this.imageLeft = i;
    }

    public void setTextAndValue(String str, String str2, boolean z) {
        setTextAndValue(str, str2, false, z);
    }

    public void setTextAndValue(String str, String str2, boolean z, boolean z2) {
        this.imageLeft = 21;
        this.offsetFromImage = getOffsetFromImage(false);
        this.textView.setText(str);
        AnimatedTextView animatedTextView = this.valueTextView;
        this.valueText = str2;
        animatedTextView.setText(TextUtils.ellipsize(str2, animatedTextView.getPaint(), AndroidUtilities.displaySize.x / 2.5f, TextUtils.TruncateAt.END), z);
        this.valueTextView.setVisibility(0);
        this.valueSpoilersTextView.setVisibility(8);
        this.imageView.setVisibility(8);
        this.valueImageView.setVisibility(8);
        this.needDivider = z2;
        setWillNotDraw(!z2);
        Switch r5 = this.checkBox;
        if (r5 != null) {
            r5.setVisibility(8);
        }
    }

    public void setTextAndValueAndIcon(String str, String str2, int i, boolean z) {
        setTextAndValueAndIcon(str, str2, false, i, z);
    }

    public void setTextAndValueAndIcon(String str, String str2, boolean z, int i, boolean z2) {
        this.imageLeft = 21;
        this.offsetFromImage = getOffsetFromImage(false);
        this.textView.setText(str);
        AnimatedTextView animatedTextView = this.valueTextView;
        this.valueText = str2;
        animatedTextView.setText(TextUtils.ellipsize(str2, animatedTextView.getPaint(), AndroidUtilities.displaySize.x / 2.5f, TextUtils.TruncateAt.END), z);
        this.valueTextView.setVisibility(0);
        this.valueSpoilersTextView.setVisibility(8);
        this.valueImageView.setVisibility(8);
        this.imageView.setVisibility(0);
        this.imageView.setTranslationX(0.0f);
        this.imageView.setTranslationY(0.0f);
        this.imageView.setPadding(0, AndroidUtilities.dp(7.0f), 0, 0);
        this.imageView.setImageResource(i);
        this.needDivider = z2;
        setWillNotDraw(!z2);
        Switch r5 = this.checkBox;
        if (r5 != null) {
            r5.setVisibility(8);
        }
    }

    public void setTextAndCheck(CharSequence charSequence, boolean z, boolean z2) {
        this.imageLeft = 21;
        this.offsetFromImage = getOffsetFromImage(false);
        this.textView.setText(charSequence);
        this.imageView.setVisibility(8);
        this.valueImageView.setVisibility(8);
        this.needDivider = z2;
        Switch r3 = this.checkBox;
        if (r3 != null) {
            r3.setVisibility(0);
            this.checkBox.setChecked(z, false);
        }
        this.needDivider = z2;
        setWillNotDraw(!z2);
    }

    public void setTextAndValueDrawable(String str, Drawable drawable, boolean z) {
        this.imageLeft = 21;
        this.offsetFromImage = getOffsetFromImage(false);
        this.textView.setText(str);
        AnimatedTextView animatedTextView = this.valueTextView;
        this.valueText = null;
        animatedTextView.setText(null, false);
        this.valueImageView.setVisibility(0);
        this.valueImageView.setImageDrawable(drawable);
        this.valueTextView.setVisibility(8);
        this.valueSpoilersTextView.setVisibility(8);
        this.imageView.setVisibility(8);
        this.imageView.setPadding(0, AndroidUtilities.dp(7.0f), 0, 0);
        this.needDivider = z;
        setWillNotDraw(!z);
        Switch r3 = this.checkBox;
        if (r3 != null) {
            r3.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float fDp;
        int iDp;
        if (this.needDivider) {
            float f2 = 20.0f;
            if (LocaleController.isRTL) {
                fDp = 0.0f;
            } else {
                if (this.imageView.getVisibility() == 0) {
                    f = this.inDialogs ? 72 : 68;
                } else {
                    f = 20.0f;
                }
                fDp = AndroidUtilities.dp(f);
            }
            float measuredHeight = getMeasuredHeight() - 1;
            int measuredWidth = getMeasuredWidth();
            if (LocaleController.isRTL) {
                if (this.imageView.getVisibility() == 0) {
                    f2 = this.inDialogs ? 72 : 68;
                }
                iDp = AndroidUtilities.dp(f2);
            } else {
                iDp = 0;
            }
            canvas.drawLine(fDp, measuredHeight, measuredWidth - iDp, getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence text = this.textView.getText();
        if (!TextUtils.isEmpty(text)) {
            CharSequence text2 = this.valueTextView.getText();
            if (!TextUtils.isEmpty(text2)) {
                text = TextUtils.concat(text, ": ", text2);
            }
        }
        if (this.checkBox != null) {
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.checkBox.isChecked());
            StringBuilder sb = new StringBuilder();
            sb.append(this.textView.getText());
            if (!TextUtils.isEmpty(this.valueTextView.getText())) {
                sb.append('\n');
                sb.append(this.valueTextView.getText());
            }
            accessibilityNodeInfo.setContentDescription(sb);
        } else if (!TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(text);
        }
        accessibilityNodeInfo.addAction(16);
    }

    public void setNeedDivider(boolean z) {
        if (this.needDivider != z) {
            this.needDivider = z;
            setWillNotDraw(!z);
            invalidate();
        }
    }

    public void setChecked(boolean z) {
        this.checkBox.setChecked(z, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void dispatchDraw(android.graphics.Canvas r9) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.TextCell.dispatchDraw(android.graphics.Canvas):void");
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.subtitleView.setVisibility(0);
            this.subtitleView.setText(charSequence);
        } else {
            this.subtitleView.setVisibility(8);
        }
    }
}
