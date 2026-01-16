package org.rbmain.ui.ActionBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.stetho.server.http.HttpStatus;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;
import org.rbmain.ui.Components.AnimatedEmojiSpan;
import org.rbmain.ui.Components.EmptyStubSpan;
import org.rbmain.ui.Components.StaticLayoutEx;
import org.rbmain.ui.Components.spoilers.SpoilerEffect;

/* loaded from: classes4.dex */
public class SimpleTextView extends View {
    private boolean attachedToWindow;
    private boolean buildFullLayout;
    private boolean canHideRightDrawable;
    private int currentScrollDelay;
    private int drawablePadding;
    private boolean ellipsizeByGradient;
    private boolean ellipsizeByGradientLeft;
    private int ellipsizeByGradientWidthDp;
    private AnimatedEmojiSpan.EmojiGroupedSpans emojiStack;
    private Paint fadeEllpsizePaint;
    private int fadeEllpsizePaintWidth;
    private Paint fadePaint;
    private Paint fadePaintBack;
    private Layout firstLineLayout;
    private Boolean forceEllipsizeByGradientLeft;
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
    private Layout.Alignment mAlignment;
    private int maxLines;
    private boolean maybeClick;
    private int minWidth;
    private int minusWidth;
    private int offsetX;
    private int offsetY;
    private int paddingRight;
    private Layout partLayout;
    private Path path;
    private Drawable replacedDrawable;
    private String replacedText;
    private int replacingDrawableTextIndex;
    private float replacingDrawableTextOffset;
    private Drawable rightDrawable;
    private boolean rightDrawableHidden;
    private View.OnClickListener rightDrawableOnClickListener;
    private boolean rightDrawableOutside;
    private float rightDrawableScale;
    private int rightDrawableTopPadding;
    public int rightDrawableX;
    public int rightDrawableY;
    private boolean scrollNonFitText;
    private float scrollingOffset;
    private List<SpoilerEffect> spoilers;
    private Stack<SpoilerEffect> spoilersPool;
    private CharSequence text;
    private boolean textDoesNotFit;
    private int textHeight;
    private TextPaint textPaint;
    private int textWidth;
    private int totalWidth;
    private float touchDownX;
    private float touchDownY;
    private boolean usaAlphaForEmoji;
    private boolean wasLayout;
    private boolean widthWrapContent;
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
        this.ellipsizeByGradientWidthDp = 16;
        this.fullTextMaxLines = 3;
        this.spoilers = new ArrayList();
        this.spoilersPool = new Stack<>();
        this.path = new Path();
        this.mAlignment = Layout.Alignment.ALIGN_NORMAL;
        this.textPaint = new TextPaint(1);
        setImportantForAccessibility(1);
    }

    public void setTextColor(int i) {
        this.textPaint.setColor(i);
        invalidate();
    }

    public void setLinkTextColor(int i) {
        this.textPaint.linkColor = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        this.emojiStack = AnimatedEmojiSpan.update(0, this, this.emojiStack, this.layout);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        AnimatedEmojiSpan.release(this, this.emojiStack);
        this.wasLayout = false;
    }

    public void setTextSize(int i) {
        float fDp = AndroidUtilities.dp(i);
        if (fDp == this.textPaint.getTextSize()) {
            return;
        }
        this.textPaint.setTextSize(fDp);
        if (recreateLayoutMaybe()) {
            return;
        }
        invalidate();
    }

    public void setBuildFullLayout(boolean z) {
        this.buildFullLayout = z;
    }

    public void setFullAlpha(float f) {
        this.fullAlpha = f;
        invalidate();
    }

    public float getFullAlpha() {
        return this.fullAlpha;
    }

    public void setScrollNonFitText(boolean z) {
        if (this.scrollNonFitText == z) {
            return;
        }
        this.scrollNonFitText = z;
        updateFadePaints();
        requestLayout();
    }

    public void setEllipsizeByGradient(boolean z) {
        setEllipsizeByGradient(z, (Boolean) null);
    }

    public void setEllipsizeByGradient(int i) {
        setEllipsizeByGradient(i, (Boolean) null);
    }

    public void setEllipsizeByGradient(boolean z, Boolean bool) {
        if (this.scrollNonFitText == z) {
            return;
        }
        this.ellipsizeByGradient = z;
        this.forceEllipsizeByGradientLeft = bool;
        updateFadePaints();
    }

    public void setEllipsizeByGradient(int i, Boolean bool) {
        setEllipsizeByGradient(true, bool);
        this.ellipsizeByGradientWidthDp = i;
        updateFadePaints();
    }

    public void setWidthWrapContent(boolean z) {
        this.widthWrapContent = z;
    }

    private void updateFadePaints() {
        if ((this.fadePaint == null || this.fadePaintBack == null) && this.scrollNonFitText) {
            Paint paint = new Paint();
            this.fadePaint = paint;
            paint.setShader(new LinearGradient(0.0f, 0.0f, AndroidUtilities.dp(6.0f), 0.0f, new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            this.fadePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Paint paint2 = new Paint();
            this.fadePaintBack = paint2;
            paint2.setShader(new LinearGradient(0.0f, 0.0f, AndroidUtilities.dp(6.0f), 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            this.fadePaintBack.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
        Boolean bool = this.forceEllipsizeByGradientLeft;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        if (!(this.fadeEllpsizePaint != null && this.fadeEllpsizePaintWidth == AndroidUtilities.dp(this.ellipsizeByGradientWidthDp) && this.ellipsizeByGradientLeft == zBooleanValue) && this.ellipsizeByGradient) {
            if (this.fadeEllpsizePaint == null) {
                this.fadeEllpsizePaint = new Paint();
            }
            this.ellipsizeByGradientLeft = zBooleanValue;
            if (zBooleanValue) {
                Paint paint3 = this.fadeEllpsizePaint;
                int iDp = AndroidUtilities.dp(this.ellipsizeByGradientWidthDp);
                this.fadeEllpsizePaintWidth = iDp;
                paint3.setShader(new LinearGradient(0.0f, 0.0f, iDp, 0.0f, new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            } else {
                Paint paint4 = this.fadeEllpsizePaint;
                int iDp2 = AndroidUtilities.dp(this.ellipsizeByGradientWidthDp);
                this.fadeEllpsizePaintWidth = iDp2;
                paint4.setShader(new LinearGradient(0.0f, 0.0f, iDp2, 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            }
            this.fadeEllpsizePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
    }

    public void setMaxLines(int i) {
        this.maxLines = i;
    }

    public void setGravity(int i) {
        this.gravity = i;
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

    private void calcOffset(int i) {
        Layout layout = this.layout;
        if (layout == null) {
            return;
        }
        if (layout.getLineCount() > 0) {
            this.textWidth = (int) Math.ceil(this.layout.getLineWidth(0));
            Layout layout2 = this.fullLayout;
            if (layout2 != null) {
                this.textHeight = layout2.getLineBottom(layout2.getLineCount() - 1);
            } else if (this.maxLines > 1 && this.layout.getLineCount() > 0) {
                Layout layout3 = this.layout;
                this.textHeight = layout3.getLineBottom(layout3.getLineCount() - 1);
            } else {
                this.textHeight = this.layout.getLineBottom(0);
            }
            int i2 = this.gravity;
            if ((i2 & 7) == 1) {
                this.offsetX = ((i - this.textWidth) / 2) - ((int) this.layout.getLineLeft(0));
            } else if ((i2 & 7) == 3) {
                Layout layout4 = this.firstLineLayout;
                if (layout4 != null) {
                    this.offsetX = -((int) layout4.getLineLeft(0));
                } else {
                    this.offsetX = -((int) this.layout.getLineLeft(0));
                }
            } else if (this.layout.getLineLeft(0) == 0.0f) {
                Layout layout5 = this.firstLineLayout;
                if (layout5 != null) {
                    this.offsetX = (int) (i - layout5.getLineWidth(0));
                } else {
                    this.offsetX = i - this.textWidth;
                }
            } else {
                this.offsetX = -AndroidUtilities.dp(8.0f);
            }
            this.offsetX += getPaddingLeft();
            this.textDoesNotFit = this.textWidth > i - this.paddingRight;
            Layout layout6 = this.fullLayout;
            if (layout6 != null && this.fullLayoutAdditionalWidth > 0) {
                this.fullLayoutLeftCharactersOffset = layout6.getPrimaryHorizontal(0) - this.firstLineLayout.getPrimaryHorizontal(0);
            }
        }
        int i3 = this.replacingDrawableTextIndex;
        if (i3 >= 0) {
            this.replacingDrawableTextOffset = this.layout.getPrimaryHorizontal(i3);
        } else {
            this.replacingDrawableTextOffset = 0.0f;
        }
    }

    protected boolean createLayout(int i) {
        int intrinsicWidth;
        int i2;
        CharSequence charSequence = this.text;
        this.replacingDrawableTextIndex = -1;
        this.rightDrawableHidden = false;
        if (charSequence != null) {
            try {
                Drawable drawable = this.leftDrawable;
                int intrinsicWidth2 = drawable != null ? (i - drawable.getIntrinsicWidth()) - this.drawablePadding : i;
                if (this.rightDrawable == null || this.rightDrawableOutside) {
                    intrinsicWidth = 0;
                } else {
                    intrinsicWidth = (int) (r3.getIntrinsicWidth() * this.rightDrawableScale);
                    intrinsicWidth2 = (intrinsicWidth2 - intrinsicWidth) - this.drawablePadding;
                }
                CharSequence charSequence2 = charSequence;
                if (this.replacedText != null) {
                    charSequence2 = charSequence;
                    if (this.replacedDrawable != null) {
                        int iIndexOf = charSequence.toString().indexOf(this.replacedText);
                        this.replacingDrawableTextIndex = iIndexOf;
                        if (iIndexOf >= 0) {
                            SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(charSequence);
                            DialogCell.FixedWidthSpan fixedWidthSpan = new DialogCell.FixedWidthSpan(this.replacedDrawable.getIntrinsicWidth());
                            int i3 = this.replacingDrawableTextIndex;
                            spannableStringBuilderValueOf.setSpan(fixedWidthSpan, i3, this.replacedText.length() + i3, 0);
                            charSequence2 = spannableStringBuilderValueOf;
                        } else {
                            intrinsicWidth2 = (intrinsicWidth2 - this.replacedDrawable.getIntrinsicWidth()) - this.drawablePadding;
                            charSequence2 = charSequence;
                        }
                    }
                }
                if (this.canHideRightDrawable && intrinsicWidth != 0 && !this.rightDrawableOutside && !charSequence2.equals(TextUtils.ellipsize(charSequence2, this.textPaint, intrinsicWidth2, TextUtils.TruncateAt.END))) {
                    this.rightDrawableHidden = true;
                    intrinsicWidth2 = intrinsicWidth2 + intrinsicWidth + this.drawablePadding;
                }
                int i4 = intrinsicWidth2;
                if (this.buildFullLayout) {
                    CharSequence charSequenceEllipsize = !this.ellipsizeByGradient ? TextUtils.ellipsize(charSequence2, this.textPaint, i4, TextUtils.TruncateAt.END) : charSequence2;
                    if (!this.ellipsizeByGradient && !charSequenceEllipsize.equals(charSequence2)) {
                        StaticLayout staticLayoutCreateStaticLayout = StaticLayoutEx.createStaticLayout(charSequence2, 0, charSequence2.length(), this.textPaint, i4, getAlignment(), 1.0f, 0.0f, false, TextUtils.TruncateAt.END, i4, this.fullTextMaxLines, false);
                        this.fullLayout = staticLayoutCreateStaticLayout;
                        if (staticLayoutCreateStaticLayout != null) {
                            int lineEnd = staticLayoutCreateStaticLayout.getLineEnd(0);
                            int lineStart = this.fullLayout.getLineStart(1);
                            CharSequence charSequenceSubSequence = charSequence2.subSequence(0, lineEnd);
                            SpannableStringBuilder spannableStringBuilderValueOf2 = SpannableStringBuilder.valueOf(charSequence2);
                            spannableStringBuilderValueOf2.setSpan(new EmptyStubSpan(), 0, lineStart, 0);
                            String strSubSequence = lineEnd < charSequenceEllipsize.length() ? charSequenceEllipsize.subSequence(lineEnd, charSequenceEllipsize.length()) : "…";
                            this.firstLineLayout = new StaticLayout(charSequenceEllipsize, 0, charSequenceEllipsize.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + i4, getAlignment(), 1.0f, 0.0f, false);
                            StaticLayout staticLayout = new StaticLayout(charSequenceSubSequence, 0, charSequenceSubSequence.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + i4, getAlignment(), 1.0f, 0.0f, false);
                            this.layout = staticLayout;
                            if (staticLayout.getLineLeft(0) != 0.0f) {
                                strSubSequence = "\u200f" + ((Object) strSubSequence);
                            }
                            CharSequence charSequence3 = strSubSequence;
                            this.partLayout = new StaticLayout(charSequence3, 0, charSequence3.length(), this.textPaint, this.scrollNonFitText ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + i4, getAlignment(), 1.0f, 0.0f, false);
                            this.fullLayout = StaticLayoutEx.createStaticLayout(spannableStringBuilderValueOf2, 0, spannableStringBuilderValueOf2.length(), this.textPaint, AndroidUtilities.dp(8.0f) + i4 + this.fullLayoutAdditionalWidth, getAlignment(), 1.0f, 0.0f, false, TextUtils.TruncateAt.END, i4 + this.fullLayoutAdditionalWidth, this.fullTextMaxLines, false);
                        }
                    } else {
                        this.layout = new StaticLayout(charSequenceEllipsize, 0, charSequenceEllipsize.length(), this.textPaint, (this.scrollNonFitText || this.ellipsizeByGradient) ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + i4, getAlignment(), 1.0f, 0.0f, false);
                        this.fullLayout = null;
                        this.partLayout = null;
                        this.firstLineLayout = null;
                    }
                } else if (this.maxLines > 1) {
                    this.layout = StaticLayoutEx.createStaticLayout(charSequence2, 0, charSequence2.length(), this.textPaint, i4, getAlignment(), 1.0f, 0.0f, false, TextUtils.TruncateAt.END, i4, this.maxLines, false);
                } else {
                    CharSequence charSequenceEllipsize2 = charSequence2;
                    if (!this.scrollNonFitText) {
                        charSequenceEllipsize2 = this.ellipsizeByGradient ? charSequence2 : TextUtils.ellipsize(charSequence2, this.textPaint, i4, TextUtils.TruncateAt.END);
                    }
                    CharSequence charSequence4 = charSequenceEllipsize2;
                    this.layout = new StaticLayout(charSequence4, 0, charSequence4.length(), this.textPaint, (this.scrollNonFitText || this.ellipsizeByGradient) ? AndroidUtilities.dp(2000.0f) : AndroidUtilities.dp(8.0f) + i4, getAlignment(), 1.0f, 0.0f, false);
                }
                this.spoilersPool.addAll(this.spoilers);
                this.spoilers.clear();
                Layout layout = this.layout;
                if (layout == null || !(layout.getText() instanceof Spannable)) {
                    i2 = i4;
                } else {
                    i2 = i4;
                    SpoilerEffect.addSpoilers(this, this.layout, -2, -2, this.spoilersPool, this.spoilers);
                }
                calcOffset(i2);
            } catch (Exception unused) {
            }
        } else {
            this.layout = null;
            this.textWidth = 0;
            this.textHeight = 0;
        }
        AnimatedEmojiSpan.release(this, this.emojiStack);
        if (this.attachedToWindow) {
            this.emojiStack = AnimatedEmojiSpan.update(0, this, this.emojiStack, this.layout);
        }
        invalidate();
        return true;
    }

    public void setAlignment(Layout.Alignment alignment) {
        this.mAlignment = alignment;
        requestLayout();
    }

    private Layout.Alignment getAlignment() {
        return this.mAlignment;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.lastWidth;
        int i4 = AndroidUtilities.displaySize.x;
        if (i3 != i4) {
            this.lastWidth = i4;
            this.scrollingOffset = 0.0f;
            this.currentScrollDelay = HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
        }
        int intrinsicWidth = 0;
        createLayout((((size - getPaddingLeft()) - getPaddingRight()) - this.minusWidth) - ((!this.rightDrawableOutside || (drawable2 = this.rightDrawable) == null) ? 0 : drawable2.getIntrinsicWidth() + this.drawablePadding));
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            size2 = getPaddingBottom() + getPaddingTop() + this.textHeight;
        }
        if (this.widthWrapContent) {
            int paddingLeft = getPaddingLeft() + this.textWidth + getPaddingRight() + this.minusWidth;
            if (this.rightDrawableOutside && (drawable = this.rightDrawable) != null) {
                intrinsicWidth = drawable.getIntrinsicWidth() + this.drawablePadding;
            }
            size = Math.min(size, paddingLeft + intrinsicWidth);
        }
        setMeasuredDimension(size, size2);
        if ((this.gravity & 112) == 16) {
            this.offsetY = getPaddingTop() + ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.textHeight) / 2);
        } else {
            this.offsetY = getPaddingTop();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.wasLayout = true;
    }

    public int getTextWidth() {
        return this.textWidth;
    }

    public int getTextHeight() {
        return this.textHeight;
    }

    public void setLeftDrawableTopPadding(int i) {
        this.leftDrawableTopPadding = i;
    }

    public void setRightDrawableTopPadding(int i) {
        this.rightDrawableTopPadding = i;
    }

    public void setLeftDrawable(int i) {
        setLeftDrawable(i == 0 ? null : getContext().getResources().getDrawable(i));
    }

    public Drawable getLeftDrawable() {
        return this.leftDrawable;
    }

    public void setRightDrawable(int i) {
        setRightDrawable(i == 0 ? null : getContext().getResources().getDrawable(i));
    }

    public void setMinWidth(int i) {
        this.minWidth = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.maxLines > 1) {
            super.setBackgroundDrawable(drawable);
        } else {
            this.wrapBackgroundDrawable = drawable;
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

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.rightDrawable || drawable == this.leftDrawable || super.verifyDrawable(drawable);
    }

    public void replaceTextWithDrawable(Drawable drawable, String str) {
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
        this.replacedText = str;
    }

    public void setMinusWidth(int i) {
        if (i == this.minusWidth) {
            return;
        }
        this.minusWidth = i;
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

    public void setRightDrawableScale(float f) {
        this.rightDrawableScale = f;
    }

    public void setSideDrawablesColor(int i) {
        Theme.setDrawableColor(this.rightDrawable, i);
        Theme.setDrawableColor(this.leftDrawable, i);
    }

    public boolean setText(CharSequence charSequence) {
        return setText(charSequence, false);
    }

    public boolean setText(CharSequence charSequence, boolean z) {
        CharSequence charSequence2 = this.text;
        if (charSequence2 == null && charSequence == null) {
            return false;
        }
        if (!z && charSequence2 != null && charSequence2.equals(charSequence)) {
            return false;
        }
        this.text = charSequence;
        this.currentScrollDelay = HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
        recreateLayoutMaybe();
        return true;
    }

    public void setDrawablePadding(int i) {
        if (this.drawablePadding == i) {
            return;
        }
        this.drawablePadding = i;
        if (recreateLayoutMaybe()) {
            return;
        }
        invalidate();
    }

    private boolean recreateLayoutMaybe() {
        if (this.wasLayout && getMeasuredHeight() != 0 && !this.buildFullLayout) {
            boolean zCreateLayout = createLayout(((getMaxTextWidth() - getPaddingLeft()) - getPaddingRight()) - this.minusWidth);
            if ((this.gravity & 112) == 16) {
                this.offsetY = (getMeasuredHeight() - this.textHeight) / 2;
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
        return charSequence == null ? BuildConfig.FLAVOR : charSequence;
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

    public void setRightPadding(int i) {
        if (this.paddingRight != i) {
            this.paddingRight = i;
            int maxTextWidth = ((getMaxTextWidth() - getPaddingLeft()) - getPaddingRight()) - this.minusWidth;
            Drawable drawable = this.leftDrawable;
            if (drawable != null) {
                maxTextWidth = (maxTextWidth - drawable.getIntrinsicWidth()) - this.drawablePadding;
            }
            int intrinsicWidth = 0;
            if (this.rightDrawable != null && !this.rightDrawableOutside) {
                intrinsicWidth = (int) (r1.getIntrinsicWidth() * this.rightDrawableScale);
                maxTextWidth = (maxTextWidth - intrinsicWidth) - this.drawablePadding;
            }
            if (this.replacedText != null && this.replacedDrawable != null) {
                int iIndexOf = this.text.toString().indexOf(this.replacedText);
                this.replacingDrawableTextIndex = iIndexOf;
                if (iIndexOf < 0) {
                    maxTextWidth = (maxTextWidth - this.replacedDrawable.getIntrinsicWidth()) - this.drawablePadding;
                }
            }
            if (this.canHideRightDrawable && intrinsicWidth != 0 && !this.rightDrawableOutside) {
                if (!this.text.equals(TextUtils.ellipsize(this.text, this.textPaint, maxTextWidth, TextUtils.TruncateAt.END))) {
                    this.rightDrawableHidden = true;
                    maxTextWidth = maxTextWidth + intrinsicWidth + this.drawablePadding;
                }
            }
            calcOffset(maxTextWidth);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int intrinsicWidth;
        int paddingTop;
        int i;
        float fDp;
        int paddingTop2;
        int i2;
        int paddingTop3;
        int i3;
        int paddingTop4;
        int i4;
        int intrinsicHeight;
        int paddingTop5;
        int i5;
        super.onDraw(canvas);
        boolean z = this.scrollNonFitText && (this.textDoesNotFit || this.scrollingOffset != 0.0f);
        int iSaveLayerAlpha = (z || this.ellipsizeByGradient) ? canvas.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), 255, 31) : Integer.MIN_VALUE;
        this.totalWidth = this.textWidth;
        if (this.leftDrawable != null) {
            int i6 = (int) (-this.scrollingOffset);
            int i7 = this.gravity;
            if ((i7 & 7) == 1) {
                i6 += this.offsetX;
            }
            if ((i7 & 112) == 16) {
                paddingTop5 = (getMeasuredHeight() - this.leftDrawable.getIntrinsicHeight()) / 2;
                i5 = this.leftDrawableTopPadding;
            } else {
                paddingTop5 = getPaddingTop() + ((this.textHeight - this.leftDrawable.getIntrinsicHeight()) / 2);
                i5 = this.leftDrawableTopPadding;
            }
            int i8 = paddingTop5 + i5;
            Drawable drawable = this.leftDrawable;
            drawable.setBounds(i6, i8, drawable.getIntrinsicWidth() + i6, this.leftDrawable.getIntrinsicHeight() + i8);
            this.leftDrawable.draw(canvas);
            int i9 = this.gravity;
            intrinsicWidth = ((i9 & 7) == 3 || (i9 & 7) == 1) ? this.drawablePadding + this.leftDrawable.getIntrinsicWidth() + 0 : 0;
            this.totalWidth += this.drawablePadding + this.leftDrawable.getIntrinsicWidth();
        } else {
            intrinsicWidth = 0;
        }
        Drawable drawable2 = this.replacedDrawable;
        if (drawable2 != null && this.replacedText != null) {
            int i10 = (int) ((-this.scrollingOffset) + this.replacingDrawableTextOffset);
            int i11 = this.gravity;
            if ((i11 & 7) == 1) {
                i10 += this.offsetX;
            }
            if ((i11 & 112) == 16) {
                intrinsicHeight = ((getMeasuredHeight() - this.replacedDrawable.getIntrinsicHeight()) / 2) + this.leftDrawableTopPadding;
            } else {
                intrinsicHeight = this.leftDrawableTopPadding + ((this.textHeight - drawable2.getIntrinsicHeight()) / 2);
            }
            Drawable drawable3 = this.replacedDrawable;
            drawable3.setBounds(i10, intrinsicHeight, drawable3.getIntrinsicWidth() + i10, this.replacedDrawable.getIntrinsicHeight() + intrinsicHeight);
            this.replacedDrawable.draw(canvas);
            if (this.replacingDrawableTextIndex < 0) {
                int i12 = this.gravity;
                if ((i12 & 7) == 3 || (i12 & 7) == 1) {
                    intrinsicWidth += this.drawablePadding + this.replacedDrawable.getIntrinsicWidth();
                }
                this.totalWidth += this.drawablePadding + this.replacedDrawable.getIntrinsicWidth();
            }
        }
        int i13 = intrinsicWidth;
        if (this.rightDrawable != null && !this.rightDrawableHidden && this.rightDrawableScale > 0.0f && !this.rightDrawableOutside) {
            int i14 = this.textWidth + i13 + this.drawablePadding + ((int) (-this.scrollingOffset));
            int i15 = this.gravity;
            if ((i15 & 7) == 1 || (i15 & 7) == 5) {
                i14 += this.offsetX;
            }
            int intrinsicWidth2 = (int) (r1.getIntrinsicWidth() * this.rightDrawableScale);
            int intrinsicHeight2 = (int) (this.rightDrawable.getIntrinsicHeight() * this.rightDrawableScale);
            if ((this.gravity & 112) == 16) {
                paddingTop4 = (getMeasuredHeight() - intrinsicHeight2) / 2;
                i4 = this.rightDrawableTopPadding;
            } else {
                paddingTop4 = getPaddingTop() + ((this.textHeight - intrinsicHeight2) / 2);
                i4 = this.rightDrawableTopPadding;
            }
            int i16 = paddingTop4 + i4;
            this.rightDrawable.setBounds(i14, i16, i14 + intrinsicWidth2, i16 + intrinsicHeight2);
            this.rightDrawableX = i14 + (intrinsicWidth2 >> 1);
            this.rightDrawableY = i16 + (intrinsicHeight2 >> 1);
            this.rightDrawable.draw(canvas);
            this.totalWidth += this.drawablePadding + intrinsicWidth2;
        }
        int iDp = this.totalWidth + AndroidUtilities.dp(16.0f);
        float f = this.scrollingOffset;
        if (f != 0.0f) {
            if (this.leftDrawable != null) {
                int i17 = ((int) (-f)) + iDp;
                if ((this.gravity & 112) == 16) {
                    paddingTop3 = (getMeasuredHeight() - this.leftDrawable.getIntrinsicHeight()) / 2;
                    i3 = this.leftDrawableTopPadding;
                } else {
                    paddingTop3 = getPaddingTop() + ((this.textHeight - this.leftDrawable.getIntrinsicHeight()) / 2);
                    i3 = this.leftDrawableTopPadding;
                }
                int i18 = paddingTop3 + i3;
                Drawable drawable4 = this.leftDrawable;
                drawable4.setBounds(i17, i18, drawable4.getIntrinsicWidth() + i17, this.leftDrawable.getIntrinsicHeight() + i18);
                this.leftDrawable.draw(canvas);
            }
            if (this.rightDrawable != null && !this.rightDrawableOutside) {
                int intrinsicWidth3 = (int) (r1.getIntrinsicWidth() * this.rightDrawableScale);
                int intrinsicHeight3 = (int) (this.rightDrawable.getIntrinsicHeight() * this.rightDrawableScale);
                int i19 = this.textWidth + i13 + this.drawablePadding + ((int) (-this.scrollingOffset)) + iDp;
                if ((this.gravity & 112) == 16) {
                    paddingTop2 = (getMeasuredHeight() - intrinsicHeight3) / 2;
                    i2 = this.rightDrawableTopPadding;
                } else {
                    paddingTop2 = getPaddingTop() + ((this.textHeight - intrinsicHeight3) / 2);
                    i2 = this.rightDrawableTopPadding;
                }
                int i20 = paddingTop2 + i2;
                this.rightDrawable.setBounds(i19, i20, intrinsicWidth3 + i19, intrinsicHeight3 + i20);
                this.rightDrawable.draw(canvas);
            }
        }
        if (this.layout != null) {
            if (this.rightDrawableOutside || this.ellipsizeByGradient || this.paddingRight > 0) {
                canvas.save();
                int maxTextWidth = getMaxTextWidth() - this.paddingRight;
                Drawable drawable5 = this.rightDrawable;
                canvas.clipRect(0, 0, maxTextWidth - AndroidUtilities.dp((drawable5 == null || (drawable5 instanceof AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable) || !this.rightDrawableOutside) ? 0.0f : 2.0f), getMeasuredHeight());
            }
            Emoji.emojiDrawingUseAlpha = this.usaAlphaForEmoji;
            if (this.wrapBackgroundDrawable != null) {
                int i21 = (int) ((this.offsetX + i13) - this.scrollingOffset);
                int i22 = this.textWidth;
                int i23 = i21 + (i22 / 2);
                int iMax = Math.max(i22 + getPaddingLeft() + getPaddingRight(), this.minWidth);
                int i24 = i23 - (iMax / 2);
                this.wrapBackgroundDrawable.setBounds(i24, 0, iMax + i24, getMeasuredHeight());
                this.wrapBackgroundDrawable.draw(canvas);
            }
            if (this.offsetX + i13 != 0 || this.offsetY != 0 || this.scrollingOffset != 0.0f) {
                canvas.save();
                canvas.translate((this.offsetX + i13) - this.scrollingOffset, this.offsetY);
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
            if (this.offsetX + i13 != 0 || this.offsetY != 0 || this.scrollingOffset != 0.0f) {
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
                canvas.translate((getMaxTextWidth() - this.paddingRight) - AndroidUtilities.dp(6.0f), 0.0f);
                canvas.drawRect(0.0f, 0.0f, AndroidUtilities.dp(6.0f), getMeasuredHeight(), this.fadePaintBack);
                canvas.restore();
            } else if (this.ellipsizeByGradient && this.textDoesNotFit && this.fadeEllpsizePaint != null) {
                canvas.save();
                updateFadePaints();
                if (!this.ellipsizeByGradientLeft) {
                    int maxTextWidth2 = (getMaxTextWidth() - this.paddingRight) - this.fadeEllpsizePaintWidth;
                    Drawable drawable6 = this.rightDrawable;
                    canvas.translate(maxTextWidth2 - AndroidUtilities.dp((drawable6 == null || (drawable6 instanceof AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable) || !this.rightDrawableOutside) ? 0.0f : 2.0f), 0.0f);
                }
                canvas.drawRect(0.0f, 0.0f, this.fadeEllpsizePaintWidth, getMeasuredHeight(), this.fadeEllpsizePaint);
                canvas.restore();
            }
            updateScrollAnimation();
            Emoji.emojiDrawingUseAlpha = true;
            if (this.rightDrawableOutside || this.ellipsizeByGradient || this.paddingRight > 0) {
                canvas.restore();
            }
        }
        if (z || this.ellipsizeByGradient) {
            canvas.restoreToCount(iSaveLayerAlpha);
        }
        if (this.rightDrawable == null || !this.rightDrawableOutside) {
            return;
        }
        int i25 = i13 + this.textWidth + this.drawablePadding;
        float f7 = this.scrollingOffset;
        int iMin = Math.min(i25 + (f7 == 0.0f ? -iDp : (int) (-f7)) + iDp, (getMaxTextWidth() - this.paddingRight) + this.drawablePadding);
        int intrinsicWidth4 = (int) (this.rightDrawable.getIntrinsicWidth() * this.rightDrawableScale);
        int intrinsicHeight4 = (int) (this.rightDrawable.getIntrinsicHeight() * this.rightDrawableScale);
        if ((this.gravity & 112) == 16) {
            paddingTop = (getMeasuredHeight() - intrinsicHeight4) / 2;
            i = this.rightDrawableTopPadding;
        } else {
            paddingTop = getPaddingTop() + ((this.textHeight - intrinsicHeight4) / 2);
            i = this.rightDrawableTopPadding;
        }
        int i26 = paddingTop + i;
        this.rightDrawable.setBounds(iMin, i26, iMin + intrinsicWidth4, i26 + intrinsicHeight4);
        this.rightDrawableX = iMin + (intrinsicWidth4 >> 1);
        this.rightDrawableY = i26 + (intrinsicHeight4 >> 1);
        this.rightDrawable.draw(canvas);
    }

    public int getRightDrawableX() {
        return this.rightDrawableX;
    }

    public int getRightDrawableY() {
        return this.rightDrawableY;
    }

    private int getMaxTextWidth() {
        Drawable drawable;
        return getMeasuredWidth() - ((!this.rightDrawableOutside || (drawable = this.rightDrawable) == null) ? 0 : drawable.getIntrinsicWidth() + this.drawablePadding);
    }

    private void drawLayout(Canvas canvas) {
        if (this.fullAlpha > 0.0f && this.fullLayoutLeftOffset != 0) {
            canvas.save();
            float f = -this.fullLayoutLeftOffset;
            float f2 = this.fullAlpha;
            canvas.translate((f * f2) + (this.fullLayoutLeftCharactersOffset * f2), 0.0f);
            canvas.save();
            clipOutSpoilers(canvas);
            AnimatedEmojiSpan.EmojiGroupedSpans emojiGroupedSpans = this.emojiStack;
            if (emojiGroupedSpans != null) {
                emojiGroupedSpans.clearPositions();
            }
            this.layout.draw(canvas);
            canvas.restore();
            AnimatedEmojiSpan.drawAnimatedEmojis(canvas, this.layout, this.emojiStack, 0.0f, null, 0.0f, 0.0f, 0.0f, 1.0f);
            drawSpoilers(canvas);
            canvas.restore();
            return;
        }
        canvas.save();
        clipOutSpoilers(canvas);
        AnimatedEmojiSpan.EmojiGroupedSpans emojiGroupedSpans2 = this.emojiStack;
        if (emojiGroupedSpans2 != null) {
            emojiGroupedSpans2.clearPositions();
        }
        canvas.clipRect(canvas.getClipBounds().left, 0, canvas.getClipBounds().right, getMeasuredHeight());
        this.layout.draw(canvas);
        canvas.restore();
        AnimatedEmojiSpan.drawAnimatedEmojis(canvas, this.layout, this.emojiStack, 0.0f, null, 0.0f, 0.0f, 0.0f, 1.0f);
        drawSpoilers(canvas);
    }

    private void clipOutSpoilers(Canvas canvas) {
        this.path.rewind();
        Iterator<SpoilerEffect> it = this.spoilers.iterator();
        while (it.hasNext()) {
            Rect bounds = it.next().getBounds();
            this.path.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Path.Direction.CW);
        }
        canvas.clipPath(this.path, Region.Op.DIFFERENCE);
    }

    private void drawSpoilers(Canvas canvas) {
        Iterator<SpoilerEffect> it = this.spoilers.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas);
        }
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
                        this.currentScrollDelay = HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
                    }
                }
                invalidate();
            }
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = this.leftDrawable;
        if (drawable == drawable2) {
            invalidate(drawable2.getBounds());
            return;
        }
        Drawable drawable3 = this.rightDrawable;
        if (drawable == drawable3) {
            invalidate(drawable3.getBounds());
            return;
        }
        Drawable drawable4 = this.replacedDrawable;
        if (drawable == drawable4) {
            invalidate(drawable4.getBounds());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(true);
        accessibilityNodeInfo.setClassName("android.widget.TextView");
        accessibilityNodeInfo.setText(this.text);
    }

    public void setFullLayoutAdditionalWidth(int i, int i2) {
        if (this.fullLayoutAdditionalWidth == i && this.fullLayoutLeftOffset == i2) {
            return;
        }
        this.fullLayoutAdditionalWidth = i;
        this.fullLayoutLeftOffset = i2;
        createLayout(((getMaxTextWidth() - getPaddingLeft()) - getPaddingRight()) - this.minusWidth);
    }

    public void setFullTextMaxLines(int i) {
        this.fullTextMaxLines = i;
    }

    public int getTextColor() {
        return this.textPaint.getColor();
    }

    public void setCanHideRightDrawable(boolean z) {
        this.canHideRightDrawable = z;
    }

    public void setRightDrawableOutside(boolean z) {
        this.rightDrawableOutside = z;
    }

    public boolean getRightDrawableOutside() {
        return this.rightDrawableOutside;
    }

    public void setRightDrawableOnClick(View.OnClickListener onClickListener) {
        this.rightDrawableOnClickListener = onClickListener;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.rightDrawableOnClickListener != null && this.rightDrawable != null) {
            RectF rectF = AndroidUtilities.rectTmp;
            rectF.set(this.rightDrawableX - AndroidUtilities.dp(16.0f), this.rightDrawableY - AndroidUtilities.dp(16.0f), this.rightDrawableX + AndroidUtilities.dp(16.0f), this.rightDrawableY + AndroidUtilities.dp(16.0f));
            if (motionEvent.getAction() == 0 && rectF.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.maybeClick = true;
                this.touchDownX = motionEvent.getX();
                this.touchDownY = motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (motionEvent.getAction() == 2 && this.maybeClick) {
                if (Math.abs(motionEvent.getX() - this.touchDownX) >= AndroidUtilities.touchSlop || Math.abs(motionEvent.getY() - this.touchDownY) >= AndroidUtilities.touchSlop) {
                    this.maybeClick = false;
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (this.maybeClick && motionEvent.getAction() == 1) {
                    this.rightDrawableOnClickListener.onClick(this);
                }
                this.maybeClick = false;
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onTouchEvent(motionEvent) || this.maybeClick;
    }
}
