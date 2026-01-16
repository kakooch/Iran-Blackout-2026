package ir.eitaa.ui.ActionBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Components.EmptyStubSpan;
import ir.eitaa.ui.Components.StaticLayoutEx;

/* loaded from: classes3.dex */
public class SimpleTextView extends View implements Drawable.Callback {
    private boolean buildFullLayout;
    private int currentScrollDelay;
    private int drawablePadding;
    private Paint fadePaint;
    private Paint fadePaintBack;
    private Layout firstLineLayout;
    private float fullAlpha;
    private Layout fullLayout;
    private int fullLayoutAdditionalWidth;
    private float fullLayoutLeftCharactersOffset;
    private int fullLayoutLeftOffset;
    private int fullTextMaxLines;
    private int gravity;
    private long lastUpdateTime;
    private int lastWidth;
    private Layout layout;
    private Drawable leftDrawable;
    private int leftDrawableTopPadding;
    private int maxLines;
    private int minWidth;
    private int minusWidth;
    private int offsetX;
    private int offsetY;
    private Layout partLayout;
    private Drawable replacedDrawable;
    private String replacedText;
    private int replacingDrawableTextIndex;
    private float replacingDrawableTextOffset;
    private Drawable rightDrawable;
    private float rightDrawableScale;
    private int rightDrawableTopPadding;
    private boolean scrollNonFitText;
    private float scrollingOffset;
    private CharSequence text;
    private boolean textDoesNotFit;
    private int textHeight;
    private TextPaint textPaint;
    private int textWidth;
    private int totalWidth;
    private boolean wasLayout;
    private Drawable wrapBackgroundDrawable;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public SimpleTextView(Context context) {
        super(context);
        this.gravity = 51;
        this.maxLines = 1;
        this.rightDrawableScale = 1.0f;
        this.drawablePadding = AndroidUtilities.dp(4.0f);
        this.fullTextMaxLines = 3;
        this.textPaint = new TextPaint(1);
        setImportantForAccessibility(1);
    }

    public void setTextColor(int color) {
        this.textPaint.setColor(color);
        invalidate();
    }

    public void setLinkTextColor(int color) {
        this.textPaint.linkColor = color;
        invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.wasLayout = false;
    }

    public void setTextSize(int size) {
        float fDp = AndroidUtilities.dp(size);
        if (fDp == this.textPaint.getTextSize()) {
            return;
        }
        this.textPaint.setTextSize(fDp);
        if (recreateLayoutMaybe()) {
            return;
        }
        invalidate();
    }

    public void setBuildFullLayout(boolean value) {
        this.buildFullLayout = value;
    }

    public void setFullAlpha(float value) {
        this.fullAlpha = value;
        invalidate();
    }

    public float getFullAlpha() {
        return this.fullAlpha;
    }

    public void setScrollNonFitText(boolean value) {
        if (this.scrollNonFitText == value) {
            return;
        }
        this.scrollNonFitText = value;
        if (value) {
            this.fadePaint = new Paint();
            this.fadePaint.setShader(new LinearGradient(0.0f, 0.0f, AndroidUtilities.dp(6.0f), 0.0f, new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            this.fadePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.fadePaintBack = new Paint();
            this.fadePaintBack.setShader(new LinearGradient(0.0f, 0.0f, AndroidUtilities.dp(6.0f), 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            this.fadePaintBack.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
        requestLayout();
    }

    public void setMaxLines(int value) {
        this.maxLines = value;
    }

    public void setGravity(int value) {
        this.gravity = value;
    }

    public void setTypeface(Typeface typeface) {
        this.textPaint.setTypeface(typeface);
    }

    public int getSideDrawablesSize() {
        Drawable drawable = this.leftDrawable;
        int intrinsicWidth = drawable != null ? 0 + drawable.getIntrinsicWidth() + this.drawablePadding : 0;
        return this.rightDrawable != null ? intrinsicWidth + ((int) (r0.getIntrinsicWidth() * this.rightDrawableScale)) + this.drawablePadding : intrinsicWidth;
    }

    public Paint getPaint() {
        return this.textPaint;
    }

    private void calcOffset(int width) {
        if (this.layout.getLineCount() > 0) {
            this.textWidth = (int) Math.ceil(this.layout.getLineWidth(0));
            Layout layout = this.fullLayout;
            if (layout != null) {
                this.textHeight = layout.getLineBottom(layout.getLineCount() - 1);
            } else if (this.maxLines > 1 && this.layout.getLineCount() > 0) {
                Layout layout2 = this.layout;
                this.textHeight = layout2.getLineBottom(layout2.getLineCount() - 1);
            } else {
                this.textHeight = this.layout.getLineBottom(0);
            }
            int i = this.gravity;
            if ((i & 7) == 1) {
                this.offsetX = ((width - this.textWidth) / 2) - ((int) this.layout.getLineLeft(0));
            } else if ((i & 7) == 3) {
                Layout layout3 = this.firstLineLayout;
                if (layout3 != null) {
                    this.offsetX = -((int) layout3.getLineLeft(0));
                } else {
                    this.offsetX = -((int) this.layout.getLineLeft(0));
                }
            } else if (this.layout.getLineLeft(0) == 0.0f) {
                Layout layout4 = this.firstLineLayout;
                if (layout4 != null) {
                    this.offsetX = (int) (width - layout4.getLineWidth(0));
                } else {
                    this.offsetX = width - this.textWidth;
                }
            } else {
                this.offsetX = -AndroidUtilities.dp(8.0f);
            }
            this.offsetX += getPaddingLeft();
            this.textDoesNotFit = this.textWidth > width;
            Layout layout5 = this.fullLayout;
            if (layout5 != null && this.fullLayoutAdditionalWidth > 0) {
                this.fullLayoutLeftCharactersOffset = layout5.getPrimaryHorizontal(0) - this.firstLineLayout.getPrimaryHorizontal(0);
            }
        }
        int i2 = this.replacingDrawableTextIndex;
        if (i2 >= 0) {
            this.replacingDrawableTextOffset = this.layout.getPrimaryHorizontal(i2);
        } else {
            this.replacingDrawableTextOffset = 0.0f;
        }
    }

    protected boolean createLayout(int i) {
        CharSequence charSequence;
        CharSequence charSequenceSubSequence;
        CharSequence charSequence2 = this.text;
        this.replacingDrawableTextIndex = -1;
        if (charSequence2 != null) {
            try {
                Drawable drawable = this.leftDrawable;
                int intrinsicWidth = drawable != null ? (i - drawable.getIntrinsicWidth()) - this.drawablePadding : i;
                if (this.rightDrawable != null) {
                    intrinsicWidth = (intrinsicWidth - ((int) (r6.getIntrinsicWidth() * this.rightDrawableScale))) - this.drawablePadding;
                }
                CharSequence charSequence3 = charSequence2;
                if (this.replacedText != null) {
                    charSequence3 = charSequence2;
                    if (this.replacedDrawable != null) {
                        int iIndexOf = charSequence2.toString().indexOf(this.replacedText);
                        this.replacingDrawableTextIndex = iIndexOf;
                        if (iIndexOf >= 0) {
                            SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(charSequence2);
                            DialogCell.FixedWidthSpan fixedWidthSpan = new DialogCell.FixedWidthSpan(this.replacedDrawable.getIntrinsicWidth());
                            int i2 = this.replacingDrawableTextIndex;
                            spannableStringBuilderValueOf.setSpan(fixedWidthSpan, i2, this.replacedText.length() + i2, 0);
                            charSequence3 = spannableStringBuilderValueOf;
                        } else {
                            intrinsicWidth = (intrinsicWidth - this.replacedDrawable.getIntrinsicWidth()) - this.drawablePadding;
                            charSequence3 = charSequence2;
                        }
                    }
                }
                if (this.buildFullLayout) {
                    CharSequence charSequenceEllipsize = TextUtils.ellipsize(charSequence3, this.textPaint, intrinsicWidth, TextUtils.TruncateAt.END);
                    if (!charSequenceEllipsize.equals(charSequence3)) {
                        StaticLayout staticLayoutCreateStaticLayout = StaticLayoutEx.createStaticLayout(charSequence3, 0, charSequence3.length(), this.textPaint, intrinsicWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, intrinsicWidth, this.fullTextMaxLines, false);
                        this.fullLayout = staticLayoutCreateStaticLayout;
                        if (staticLayoutCreateStaticLayout != null) {
                            int lineEnd = staticLayoutCreateStaticLayout.getLineEnd(0);
                            int lineStart = this.fullLayout.getLineStart(1);
                            CharSequence charSequenceSubSequence2 = charSequence3.subSequence(0, lineEnd);
                            SpannableStringBuilder spannableStringBuilderValueOf2 = SpannableStringBuilder.valueOf(charSequence3);
                            spannableStringBuilderValueOf2.setSpan(new EmptyStubSpan(), 0, lineStart, 0);
                            if (lineEnd < charSequenceEllipsize.length()) {
                                charSequence = charSequenceEllipsize;
                                charSequenceSubSequence = charSequence.subSequence(lineEnd, charSequenceEllipsize.length());
                            } else {
                                charSequence = charSequenceEllipsize;
                                charSequenceSubSequence = "…";
                            }
                            this.firstLineLayout = new StaticLayout(charSequence, 0, charSequence.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + intrinsicWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                            StaticLayout staticLayout = new StaticLayout(charSequenceSubSequence2, 0, charSequenceSubSequence2.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + intrinsicWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                            this.layout = staticLayout;
                            if (staticLayout.getLineLeft(0) != 0.0f) {
                                charSequenceSubSequence = "\u200f" + ((Object) charSequenceSubSequence);
                            }
                            CharSequence charSequence4 = charSequenceSubSequence;
                            this.partLayout = new StaticLayout(charSequence4, 0, charSequence4.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + intrinsicWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                            int length = spannableStringBuilderValueOf2.length();
                            TextPaint textPaint = this.textPaint;
                            int iDp = AndroidUtilities.dp(8.0f) + intrinsicWidth;
                            int i3 = this.fullLayoutAdditionalWidth;
                            this.fullLayout = StaticLayoutEx.createStaticLayout(spannableStringBuilderValueOf2, 0, length, textPaint, iDp + i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, intrinsicWidth + i3, this.fullTextMaxLines, false);
                        }
                    } else {
                        this.layout = new StaticLayout(charSequenceEllipsize, 0, charSequenceEllipsize.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + intrinsicWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                        this.fullLayout = null;
                        this.partLayout = null;
                        this.firstLineLayout = null;
                    }
                } else if (this.maxLines > 1) {
                    this.layout = StaticLayoutEx.createStaticLayout(charSequence3, 0, charSequence3.length(), this.textPaint, intrinsicWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, intrinsicWidth, this.maxLines, false);
                } else {
                    CharSequence charSequenceEllipsize2 = charSequence3;
                    if (!this.scrollNonFitText) {
                        charSequenceEllipsize2 = TextUtils.ellipsize(charSequence3, this.textPaint, intrinsicWidth, TextUtils.TruncateAt.END);
                    }
                    CharSequence charSequence5 = charSequenceEllipsize2;
                    this.layout = new StaticLayout(charSequence5, 0, charSequence5.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + intrinsicWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                }
                calcOffset(intrinsicWidth);
            } catch (Exception unused) {
            }
        } else {
            this.layout = null;
            this.textWidth = 0;
            this.textHeight = 0;
        }
        invalidate();
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int i = this.lastWidth;
        int i2 = AndroidUtilities.displaySize.x;
        if (i != i2) {
            this.lastWidth = i2;
            this.scrollingOffset = 0.0f;
            this.currentScrollDelay = 500;
        }
        createLayout(((size - getPaddingLeft()) - getPaddingRight()) - this.minusWidth);
        if (View.MeasureSpec.getMode(heightMeasureSpec) != 1073741824) {
            size2 = this.textHeight;
        }
        setMeasuredDimension(size, size2);
        if ((this.gravity & R.styleable.AppCompatTheme_windowActionBarOverlay) == 16) {
            this.offsetY = ((getMeasuredHeight() - this.textHeight) / 2) + getPaddingTop();
        } else {
            this.offsetY = getPaddingTop();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.wasLayout = true;
    }

    public int getTextWidth() {
        return this.textWidth;
    }

    public int getTextHeight() {
        return this.textHeight;
    }

    public void setLeftDrawableTopPadding(int value) {
        this.leftDrawableTopPadding = value;
    }

    public void setRightDrawableTopPadding(int value) {
        this.rightDrawableTopPadding = value;
    }

    public void setLeftDrawable(int resId) {
        setLeftDrawable(resId == 0 ? null : getContext().getResources().getDrawable(resId));
    }

    public Drawable getLeftDrawable() {
        return this.leftDrawable;
    }

    public void setRightDrawable(int resId) {
        setRightDrawable(resId == 0 ? null : getContext().getResources().getDrawable(resId));
    }

    public void setMinWidth(int width) {
        this.minWidth = width;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        if (this.maxLines > 1) {
            super.setBackgroundDrawable(background);
        } else {
            this.wrapBackgroundDrawable = background;
        }
    }

    @Override // android.view.View
    public Drawable getBackground() {
        Drawable drawable = this.wrapBackgroundDrawable;
        return drawable != null ? drawable : super.getBackground();
    }

    public void setLeftDrawable(Drawable drawable) {
        Drawable drawable2 = this.leftDrawable;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.leftDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (recreateLayoutMaybe()) {
            return;
        }
        invalidate();
    }

    public void replaceTextWithDrawable(Drawable drawable, String replacedText) {
        Drawable drawable2 = this.replacedDrawable;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.replacedDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (!recreateLayoutMaybe()) {
            invalidate();
        }
        this.replacedText = replacedText;
    }

    public void setMinusWidth(int value) {
        if (value == this.minusWidth) {
            return;
        }
        this.minusWidth = value;
        if (recreateLayoutMaybe()) {
            return;
        }
        invalidate();
    }

    public Drawable getRightDrawable() {
        return this.rightDrawable;
    }

    public void setRightDrawable(Drawable drawable) {
        Drawable drawable2 = this.rightDrawable;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.rightDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (recreateLayoutMaybe()) {
            return;
        }
        invalidate();
    }

    public void setRightDrawableScale(float scale) {
        this.rightDrawableScale = scale;
    }

    public void setSideDrawablesColor(int color) {
        Theme.setDrawableColor(this.rightDrawable, color);
        Theme.setDrawableColor(this.leftDrawable, color);
    }

    public boolean setText(CharSequence value) {
        return setText(value, false);
    }

    public boolean setText(CharSequence value, boolean force) {
        CharSequence charSequence = this.text;
        if (charSequence == null && value == null) {
            return false;
        }
        if (!force && charSequence != null && charSequence.equals(value)) {
            return false;
        }
        this.text = value;
        this.scrollingOffset = 0.0f;
        this.currentScrollDelay = 500;
        recreateLayoutMaybe();
        return true;
    }

    public void setDrawablePadding(int value) {
        if (this.drawablePadding == value) {
            return;
        }
        this.drawablePadding = value;
        if (recreateLayoutMaybe()) {
            return;
        }
        invalidate();
    }

    private boolean recreateLayoutMaybe() {
        if (this.wasLayout && getMeasuredHeight() != 0 && !this.buildFullLayout) {
            boolean zCreateLayout = createLayout(((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - this.minusWidth);
            if ((this.gravity & R.styleable.AppCompatTheme_windowActionBarOverlay) == 16) {
                this.offsetY = ((getMeasuredHeight() - this.textHeight) / 2) + getPaddingTop();
            } else {
                this.offsetY = getPaddingTop();
            }
            return zCreateLayout;
        }
        requestLayout();
        return true;
    }

    public CharSequence getText() {
        CharSequence charSequence = this.text;
        return charSequence == null ? "" : charSequence;
    }

    public int getLineCount() {
        Layout layout = this.layout;
        int lineCount = layout != null ? 0 + layout.getLineCount() : 0;
        Layout layout2 = this.fullLayout;
        return layout2 != null ? lineCount + layout2.getLineCount() : lineCount;
    }

    public int getTextStartX() {
        int intrinsicWidth = 0;
        if (this.layout == null) {
            return 0;
        }
        Drawable drawable = this.leftDrawable;
        if (drawable != null && (this.gravity & 7) == 3) {
            intrinsicWidth = 0 + this.drawablePadding + drawable.getIntrinsicWidth();
        }
        Drawable drawable2 = this.replacedDrawable;
        if (drawable2 != null && this.replacingDrawableTextIndex < 0 && (this.gravity & 7) == 3) {
            intrinsicWidth += this.drawablePadding + drawable2.getIntrinsicWidth();
        }
        return ((int) getX()) + this.offsetX + intrinsicWidth;
    }

    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public int getTextStartY() {
        if (this.layout == null) {
            return 0;
        }
        return (int) getY();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int intrinsicWidth;
        float fDp;
        int intrinsicHeight;
        int i;
        int intrinsicHeight2;
        super.onDraw(canvas);
        boolean z = this.scrollNonFitText && (this.textDoesNotFit || this.scrollingOffset != 0.0f);
        int iSaveLayerAlpha = z ? canvas.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), 255, 31) : Integer.MIN_VALUE;
        this.totalWidth = this.textWidth;
        Drawable drawable = this.leftDrawable;
        if (drawable != null) {
            int i2 = (int) (-this.scrollingOffset);
            int i3 = this.gravity;
            if ((i3 & 7) == 1) {
                i2 += this.offsetX;
            }
            if ((i3 & R.styleable.AppCompatTheme_windowActionBarOverlay) == 16) {
                intrinsicHeight2 = ((getMeasuredHeight() - this.leftDrawable.getIntrinsicHeight()) / 2) + this.leftDrawableTopPadding;
            } else {
                intrinsicHeight2 = this.leftDrawableTopPadding + ((this.textHeight - drawable.getIntrinsicHeight()) / 2);
            }
            Drawable drawable2 = this.leftDrawable;
            drawable2.setBounds(i2, intrinsicHeight2, drawable2.getIntrinsicWidth() + i2, this.leftDrawable.getIntrinsicHeight() + intrinsicHeight2);
            this.leftDrawable.draw(canvas);
            int i4 = this.gravity;
            intrinsicWidth = ((i4 & 7) == 3 || (i4 & 7) == 1) ? this.drawablePadding + this.leftDrawable.getIntrinsicWidth() + 0 : 0;
            this.totalWidth += this.drawablePadding + this.leftDrawable.getIntrinsicWidth();
        } else {
            intrinsicWidth = 0;
        }
        Drawable drawable3 = this.replacedDrawable;
        if (drawable3 != null && this.replacedText != null) {
            int i5 = (int) ((-this.scrollingOffset) + this.replacingDrawableTextOffset);
            int i6 = this.gravity;
            if ((i6 & 7) == 1) {
                i5 += this.offsetX;
            }
            if ((i6 & R.styleable.AppCompatTheme_windowActionBarOverlay) == 16) {
                intrinsicHeight = (getMeasuredHeight() - this.replacedDrawable.getIntrinsicHeight()) / 2;
                i = this.leftDrawableTopPadding;
            } else {
                intrinsicHeight = (this.textHeight - drawable3.getIntrinsicHeight()) / 2;
                i = this.leftDrawableTopPadding;
            }
            int i7 = intrinsicHeight + i;
            Drawable drawable4 = this.replacedDrawable;
            drawable4.setBounds(i5, i7, drawable4.getIntrinsicWidth() + i5, this.replacedDrawable.getIntrinsicHeight() + i7);
            this.replacedDrawable.draw(canvas);
            if (this.replacingDrawableTextIndex < 0) {
                int i8 = this.gravity;
                if ((i8 & 7) == 3 || (i8 & 7) == 1) {
                    intrinsicWidth += this.drawablePadding + this.replacedDrawable.getIntrinsicWidth();
                }
                this.totalWidth += this.drawablePadding + this.replacedDrawable.getIntrinsicWidth();
            }
        }
        if (this.rightDrawable != null) {
            int i9 = this.textWidth + intrinsicWidth + this.drawablePadding + ((int) (-this.scrollingOffset));
            int i10 = this.gravity;
            if ((i10 & 7) == 1 || (i10 & 7) == 5) {
                int i11 = this.offsetX;
                i9 += i11;
            }
            int intrinsicWidth2 = (int) (r6.getIntrinsicWidth() * this.rightDrawableScale);
            int intrinsicHeight3 = (int) (this.rightDrawable.getIntrinsicHeight() * this.rightDrawableScale);
            int i12 = ((this.textHeight - intrinsicHeight3) / 2) + this.rightDrawableTopPadding;
            this.rightDrawable.setBounds(i9, i12, i9 + intrinsicWidth2, intrinsicHeight3 + i12);
            this.rightDrawable.draw(canvas);
            this.totalWidth += this.drawablePadding + intrinsicWidth2;
        }
        int iDp = this.totalWidth + AndroidUtilities.dp(16.0f);
        float f = this.scrollingOffset;
        if (f != 0.0f) {
            Drawable drawable5 = this.leftDrawable;
            if (drawable5 != null) {
                int i13 = ((int) (-f)) + iDp;
                int intrinsicHeight4 = ((this.textHeight - drawable5.getIntrinsicHeight()) / 2) + this.leftDrawableTopPadding;
                Drawable drawable6 = this.leftDrawable;
                drawable6.setBounds(i13, intrinsicHeight4, drawable6.getIntrinsicWidth() + i13, this.leftDrawable.getIntrinsicHeight() + intrinsicHeight4);
                this.leftDrawable.draw(canvas);
            }
            Drawable drawable7 = this.rightDrawable;
            if (drawable7 != null) {
                int i14 = this.textWidth + intrinsicWidth + this.drawablePadding + ((int) (-this.scrollingOffset)) + iDp;
                int intrinsicHeight5 = ((this.textHeight - drawable7.getIntrinsicHeight()) / 2) + this.rightDrawableTopPadding;
                Drawable drawable8 = this.rightDrawable;
                drawable8.setBounds(i14, intrinsicHeight5, drawable8.getIntrinsicWidth() + i14, this.rightDrawable.getIntrinsicHeight() + intrinsicHeight5);
                this.rightDrawable.draw(canvas);
            }
        }
        if (this.layout != null) {
            if (this.wrapBackgroundDrawable != null) {
                int i15 = (int) ((this.offsetX + intrinsicWidth) - this.scrollingOffset);
                int i16 = this.textWidth;
                int i17 = i15 + (i16 / 2);
                int iMax = Math.max(i16 + getPaddingLeft() + getPaddingRight(), this.minWidth);
                int i18 = i17 - (iMax / 2);
                this.wrapBackgroundDrawable.setBounds(i18, 0, iMax + i18, getMeasuredHeight());
                this.wrapBackgroundDrawable.draw(canvas);
            }
            if (this.offsetX + intrinsicWidth != 0 || this.offsetY != 0 || this.scrollingOffset != 0.0f) {
                canvas.save();
                canvas.translate((this.offsetX + intrinsicWidth) - this.scrollingOffset, this.offsetY);
            }
            drawLayout(canvas);
            if (this.partLayout != null && this.fullAlpha < 1.0f) {
                int alpha = this.textPaint.getAlpha();
                this.textPaint.setAlpha((int) ((1.0f - this.fullAlpha) * 255.0f));
                canvas.save();
                if (this.partLayout.getText().length() == 1) {
                    fDp = AndroidUtilities.dp(this.fullTextMaxLines == 1 ? 0.5f : 4.0f);
                } else {
                    fDp = 0.0f;
                }
                if (this.layout.getLineLeft(0) != 0.0f) {
                    canvas.translate((-this.layout.getLineWidth(0)) + fDp, 0.0f);
                } else {
                    canvas.translate(this.layout.getLineWidth(0) - fDp, 0.0f);
                }
                float f2 = -this.fullLayoutLeftOffset;
                float f3 = this.fullAlpha;
                canvas.translate((f2 * f3) + (this.fullLayoutLeftCharactersOffset * f3), 0.0f);
                this.partLayout.draw(canvas);
                canvas.restore();
                this.textPaint.setAlpha(alpha);
            }
            if (this.fullLayout != null && this.fullAlpha > 0.0f) {
                int alpha2 = this.textPaint.getAlpha();
                this.textPaint.setAlpha((int) (this.fullAlpha * 255.0f));
                float f4 = -this.fullLayoutLeftOffset;
                float f5 = this.fullAlpha;
                float f6 = this.fullLayoutLeftCharactersOffset;
                canvas.translate(((f4 * f5) + (f5 * f6)) - f6, 0.0f);
                this.fullLayout.draw(canvas);
                this.textPaint.setAlpha(alpha2);
            }
            if (this.scrollingOffset != 0.0f) {
                canvas.translate(iDp, 0.0f);
                drawLayout(canvas);
            }
            if (this.offsetX + intrinsicWidth != 0 || this.offsetY != 0 || this.scrollingOffset != 0.0f) {
                canvas.restore();
            }
            if (z) {
                if (this.scrollingOffset < AndroidUtilities.dp(10.0f)) {
                    this.fadePaint.setAlpha((int) ((this.scrollingOffset / AndroidUtilities.dp(10.0f)) * 255.0f));
                } else if (this.scrollingOffset > (this.totalWidth + AndroidUtilities.dp(16.0f)) - AndroidUtilities.dp(10.0f)) {
                    this.fadePaint.setAlpha((int) ((1.0f - ((this.scrollingOffset - ((this.totalWidth + AndroidUtilities.dp(16.0f)) - AndroidUtilities.dp(10.0f))) / AndroidUtilities.dp(10.0f))) * 255.0f));
                } else {
                    this.fadePaint.setAlpha(255);
                }
                canvas.drawRect(0.0f, 0.0f, AndroidUtilities.dp(6.0f), getMeasuredHeight(), this.fadePaint);
                canvas.save();
                canvas.translate(getMeasuredWidth() - AndroidUtilities.dp(6.0f), 0.0f);
                canvas.drawRect(0.0f, 0.0f, AndroidUtilities.dp(6.0f), getMeasuredHeight(), this.fadePaintBack);
                canvas.restore();
            }
            updateScrollAnimation();
        }
        if (z) {
            canvas.restoreToCount(iSaveLayerAlpha);
        }
    }

    private void drawLayout(Canvas canvas) {
        if (this.fullAlpha > 0.0f && this.fullLayoutLeftOffset != 0) {
            canvas.save();
            float f = -this.fullLayoutLeftOffset;
            float f2 = this.fullAlpha;
            canvas.translate((f * f2) + (this.fullLayoutLeftCharactersOffset * f2), 0.0f);
            this.layout.draw(canvas);
            canvas.restore();
            return;
        }
        this.layout.draw(canvas);
    }

    private void updateScrollAnimation() {
        if (this.scrollNonFitText) {
            if (this.textDoesNotFit || this.scrollingOffset != 0.0f) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.lastUpdateTime;
                if (j > 17) {
                    j = 17;
                }
                int i = this.currentScrollDelay;
                if (i > 0) {
                    this.currentScrollDelay = (int) (i - j);
                } else {
                    int iDp = this.totalWidth + AndroidUtilities.dp(16.0f);
                    float fDp = 50.0f;
                    if (this.scrollingOffset < AndroidUtilities.dp(100.0f)) {
                        fDp = ((this.scrollingOffset / AndroidUtilities.dp(100.0f)) * 20.0f) + 30.0f;
                    } else if (this.scrollingOffset >= iDp - AndroidUtilities.dp(100.0f)) {
                        fDp = 50.0f - (((this.scrollingOffset - (iDp - AndroidUtilities.dp(100.0f))) / AndroidUtilities.dp(100.0f)) * 20.0f);
                    }
                    float fDp2 = this.scrollingOffset + ((j / 1000.0f) * AndroidUtilities.dp(fDp));
                    this.scrollingOffset = fDp2;
                    this.lastUpdateTime = jElapsedRealtime;
                    if (fDp2 > iDp) {
                        this.scrollingOffset = 0.0f;
                        this.currentScrollDelay = 500;
                    }
                }
                invalidate();
            }
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        Drawable drawable = this.leftDrawable;
        if (who == drawable) {
            invalidate(drawable.getBounds());
            return;
        }
        Drawable drawable2 = this.rightDrawable;
        if (who == drawable2) {
            invalidate(drawable2.getBounds());
            return;
        }
        Drawable drawable3 = this.replacedDrawable;
        if (who == drawable3) {
            invalidate(drawable3.getBounds());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setVisibleToUser(true);
        info.setClassName("android.widget.TextView");
        info.setText(this.text);
    }

    public void setFullLayoutAdditionalWidth(int fullLayoutAdditionalWidth, int fullLayoutLeftOffset) {
        if (this.fullLayoutAdditionalWidth == fullLayoutAdditionalWidth && this.fullLayoutLeftOffset == fullLayoutLeftOffset) {
            return;
        }
        this.fullLayoutAdditionalWidth = fullLayoutAdditionalWidth;
        this.fullLayoutLeftOffset = fullLayoutLeftOffset;
        createLayout(getMeasuredWidth() - this.minusWidth);
    }

    public void setFullTextMaxLines(int fullTextMaxLines) {
        this.fullTextMaxLines = fullTextMaxLines;
    }

    public int getTextColor() {
        return this.textPaint.getColor();
    }
}
