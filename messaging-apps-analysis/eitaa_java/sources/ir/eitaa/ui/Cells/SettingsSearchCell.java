package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SettingsSearchCell extends FrameLayout {
    private ImageView imageView;
    private int left;
    private boolean needDivider;
    private TextView textView;
    private TextView valueTextView;

    public class VerticalImageSpan extends ImageSpan {
        public VerticalImageSpan(Drawable drawable) {
            super(drawable);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i = fontMetricsInt2.descent;
                int i2 = fontMetricsInt2.ascent;
                int i3 = i2 + ((i - i2) / 2);
                int i4 = (bounds.bottom - bounds.top) / 2;
                int i5 = i3 - i4;
                fontMetricsInt.ascent = i5;
                fontMetricsInt.top = i5;
                int i6 = i3 + i4;
                fontMetricsInt.bottom = i6;
                fontMetricsInt.descent = i6;
            }
            return bounds.right;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            int i = paint.getFontMetricsInt().descent;
            canvas.translate(x, ((y + i) - ((i - r3.ascent) / 2)) - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2));
            if (LocaleController.isRTL) {
                canvas.scale(-1.0f, 1.0f, drawable.getIntrinsicWidth() / 2, drawable.getIntrinsicHeight() / 2);
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public SettingsSearchCell(Context context) {
        super(context);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = this.textView;
        boolean z = LocaleController.isRTL;
        addView(textView2, LayoutHelper.createFrame(-2, -2.0f, z ? 5 : 3, z ? 16.0f : 71.0f, 10.0f, z ? 71.0f : 16.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.valueTextView = textView3;
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        this.valueTextView.setTextSize(1, 13.0f);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView4 = this.valueTextView;
        boolean z2 = LocaleController.isRTL;
        addView(textView4, LayoutHelper.createFrame(-2, -2.0f, z2 ? 5 : 3, z2 ? 16.0f : 71.0f, 33.0f, z2 ? 71.0f : 16.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
        addView(this.imageView, LayoutHelper.createFrame(48, 48.0f, LocaleController.isRTL ? 5 : 3, 10.0f, 8.0f, 10.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public void setTextAndValueAndIcon(CharSequence text, String[] value, int icon, boolean divider) {
        this.textView.setText(text);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 16.0f : 71.0f);
        layoutParams.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? 71.0f : 16.0f);
        if (value != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < value.length; i++) {
                if (i != 0) {
                    spannableStringBuilder.append((CharSequence) " > ");
                    Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.settings_arrow).mutate();
                    drawableMutate.setBounds(0, 0, drawableMutate.getIntrinsicWidth(), drawableMutate.getIntrinsicHeight());
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayText2"), PorterDuff.Mode.MULTIPLY));
                    spannableStringBuilder.setSpan(new VerticalImageSpan(drawableMutate), spannableStringBuilder.length() - 2, spannableStringBuilder.length() - 1, 33);
                }
                spannableStringBuilder.append((CharSequence) value[i]);
            }
            this.valueTextView.setText(spannableStringBuilder);
            this.valueTextView.setVisibility(0);
            layoutParams.topMargin = AndroidUtilities.dp(10.0f);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.valueTextView.getLayoutParams();
            layoutParams2.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 16.0f : 71.0f);
            layoutParams2.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? 71.0f : 16.0f);
        } else {
            layoutParams.topMargin = AndroidUtilities.dp(21.0f);
            this.valueTextView.setVisibility(8);
        }
        if (icon != 0) {
            this.imageView.setImageResource(icon);
            this.imageView.setVisibility(0);
        } else {
            this.imageView.setVisibility(8);
        }
        this.left = 69;
        this.needDivider = divider;
        setWillNotDraw(!divider);
    }

    public void setTextAndValue(CharSequence text, String[] value, boolean faq, boolean divider) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        if (faq) {
            this.valueTextView.setText(text);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < value.length; i++) {
                if (i != 0) {
                    spannableStringBuilder.append((CharSequence) " > ");
                    Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.settings_arrow).mutate();
                    drawableMutate.setBounds(0, 0, drawableMutate.getIntrinsicWidth(), drawableMutate.getIntrinsicHeight());
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
                    spannableStringBuilder.setSpan(new VerticalImageSpan(drawableMutate), spannableStringBuilder.length() - 2, spannableStringBuilder.length() - 1, 33);
                }
                spannableStringBuilder.append((CharSequence) value[i]);
            }
            this.textView.setText(spannableStringBuilder);
            this.valueTextView.setVisibility(0);
            layoutParams.topMargin = AndroidUtilities.dp(10.0f);
        } else {
            this.textView.setText(text);
            if (value != null) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                for (int i2 = 0; i2 < value.length; i2++) {
                    if (i2 != 0) {
                        spannableStringBuilder2.append((CharSequence) " > ");
                        Drawable drawableMutate2 = getContext().getResources().getDrawable(R.drawable.settings_arrow).mutate();
                        drawableMutate2.setBounds(0, 0, drawableMutate2.getIntrinsicWidth(), drawableMutate2.getIntrinsicHeight());
                        drawableMutate2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayText2"), PorterDuff.Mode.MULTIPLY));
                        spannableStringBuilder2.setSpan(new VerticalImageSpan(drawableMutate2), spannableStringBuilder2.length() - 2, spannableStringBuilder2.length() - 1, 33);
                    }
                    spannableStringBuilder2.append((CharSequence) value[i2]);
                }
                this.valueTextView.setText(spannableStringBuilder2);
                this.valueTextView.setVisibility(0);
                layoutParams.topMargin = AndroidUtilities.dp(10.0f);
            } else {
                layoutParams.topMargin = AndroidUtilities.dp(21.0f);
                this.valueTextView.setVisibility(8);
            }
        }
        int iDp = AndroidUtilities.dp(16.0f);
        layoutParams.rightMargin = iDp;
        layoutParams.leftMargin = iDp;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.valueTextView.getLayoutParams();
        int iDp2 = AndroidUtilities.dp(16.0f);
        layoutParams2.rightMargin = iDp2;
        layoutParams2.leftMargin = iDp2;
        this.imageView.setVisibility(8);
        this.needDivider = divider;
        setWillNotDraw(!divider);
        this.left = 16;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(this.left), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(this.left) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }
}
