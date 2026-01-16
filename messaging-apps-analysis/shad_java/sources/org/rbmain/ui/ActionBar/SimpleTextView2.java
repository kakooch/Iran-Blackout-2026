package org.rbmain.ui.ActionBar;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class SimpleTextView2 extends SimpleTextView {
    private int drawablePadding;
    private int gravity;
    private Layout layout;
    private Drawable leftDrawable;
    private int leftDrawableTopPadding;
    private int offsetX;
    private Drawable rightDrawable;
    private int rightDrawableTopPadding;
    private CharSequence text;
    private int textHeight;
    private TextPaint textPaint;
    private int textWidth;
    private boolean wasLayout;

    @Override // org.rbmain.ui.ActionBar.SimpleTextView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public SimpleTextView2(Context context) {
        super(context);
        this.gravity = 51;
        this.drawablePadding = AndroidUtilities.dp(4.0f);
        this.textPaint = new TextPaint(1);
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setTextColor(int i) {
        this.textPaint.setColor(i);
        invalidate();
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setLinkTextColor(int i) {
        this.textPaint.linkColor = i;
        invalidate();
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.wasLayout = false;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
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

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setGravity(int i) {
        this.gravity = i;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setTypeface(Typeface typeface) {
        this.textPaint.setTypeface(typeface);
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public int getSideDrawablesSize() {
        Drawable drawable = this.leftDrawable;
        int intrinsicWidth = drawable != null ? 0 + drawable.getIntrinsicWidth() + this.drawablePadding : 0;
        Drawable drawable2 = this.rightDrawable;
        return drawable2 != null ? intrinsicWidth + drawable2.getIntrinsicWidth() + this.drawablePadding : intrinsicWidth;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public Paint getPaint() {
        return this.textPaint;
    }

    private void calcOffset(int i) {
        if (this.layout.getLineCount() > 0) {
            this.textWidth = (int) Math.ceil(this.layout.getLineWidth(0));
            this.textHeight = this.layout.getLineBottom(0);
            if ((this.gravity & 7) == 3) {
                this.offsetX = -((int) this.layout.getLineLeft(0));
            } else if (this.layout.getLineLeft(0) == 0.0f) {
                this.offsetX = i - this.textWidth;
            } else {
                this.offsetX = -AndroidUtilities.dp(8.0f);
            }
            this.offsetX += getPaddingLeft();
        }
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    protected boolean createLayout(int i) {
        if (this.text != null) {
            try {
                Drawable drawable = this.leftDrawable;
                if (drawable != null) {
                    i = (i - drawable.getIntrinsicWidth()) - this.drawablePadding;
                }
                Drawable drawable2 = this.rightDrawable;
                if (drawable2 != null) {
                    i = (i - drawable2.getIntrinsicWidth()) - this.drawablePadding;
                }
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.text, this.textPaint, i, TextUtils.TruncateAt.END);
                this.layout = new StaticLayout(charSequenceEllipsize, 0, charSequenceEllipsize.length(), this.textPaint, i + AndroidUtilities.dp(8.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                calcOffset(i);
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

    @Override // org.rbmain.ui.ActionBar.SimpleTextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        createLayout((size - getPaddingLeft()) - getPaddingRight());
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            size2 = this.textHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.wasLayout = true;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public int getTextWidth() {
        return this.textWidth;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public int getTextHeight() {
        return this.textHeight;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setLeftDrawableTopPadding(int i) {
        this.leftDrawableTopPadding = i;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setRightDrawableTopPadding(int i) {
        this.rightDrawableTopPadding = i;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setLeftDrawable(int i) {
        setLeftDrawable(i == 0 ? null : getContext().getResources().getDrawable(i));
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public void setRightDrawable(int i) {
        setRightDrawable(i == 0 ? null : getContext().getResources().getDrawable(i));
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
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

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
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

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public boolean setText(CharSequence charSequence) {
        return setText(charSequence, false);
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public boolean setText(CharSequence charSequence, boolean z) {
        CharSequence charSequence2 = this.text;
        if (charSequence2 == null && charSequence == null) {
            return false;
        }
        if (!z && charSequence2 != null && charSequence != null && charSequence2.equals(charSequence)) {
            return false;
        }
        this.text = charSequence;
        recreateLayoutMaybe();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
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
        if (this.wasLayout) {
            return createLayout(getMeasuredWidth());
        }
        requestLayout();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public CharSequence getText() {
        CharSequence charSequence = this.text;
        return charSequence == null ? BuildConfig.FLAVOR : charSequence;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public int getTextStartX() {
        int intrinsicWidth = 0;
        if (this.layout == null) {
            return 0;
        }
        Drawable drawable = this.leftDrawable;
        if (drawable != null && (this.gravity & 7) == 3) {
            intrinsicWidth = 0 + this.drawablePadding + drawable.getIntrinsicWidth();
        }
        return ((int) getX()) + this.offsetX + intrinsicWidth;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView
    public int getTextStartY() {
        if (this.layout == null) {
            return 0;
        }
        return (int) getY();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
    @Override // org.rbmain.ui.ActionBar.SimpleTextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            android.graphics.drawable.Drawable r0 = r6.leftDrawable
            r1 = 0
            if (r0 == 0) goto L38
            int r2 = r6.textHeight
            int r0 = r0.getIntrinsicHeight()
            int r2 = r2 - r0
            int r2 = r2 / 2
            int r0 = r6.leftDrawableTopPadding
            int r2 = r2 + r0
            android.graphics.drawable.Drawable r0 = r6.leftDrawable
            int r3 = r0.getIntrinsicWidth()
            android.graphics.drawable.Drawable r4 = r6.leftDrawable
            int r4 = r4.getIntrinsicHeight()
            int r4 = r4 + r2
            r0.setBounds(r1, r2, r3, r4)
            android.graphics.drawable.Drawable r0 = r6.leftDrawable
            r0.draw(r7)
            int r0 = r6.gravity
            r0 = r0 & 7
            r2 = 3
            if (r0 != r2) goto L38
            int r0 = r6.drawablePadding
            android.graphics.drawable.Drawable r2 = r6.leftDrawable
            int r2 = r2.getIntrinsicWidth()
            int r0 = r0 + r2
            int r0 = r0 + r1
            goto L39
        L38:
            r0 = 0
        L39:
            android.graphics.drawable.Drawable r2 = r6.rightDrawable
            if (r2 == 0) goto L81
            int r2 = r6.getWidth()
            android.graphics.drawable.Drawable r3 = r6.rightDrawable
            int r3 = r3.getIntrinsicWidth()
            int r2 = r2 - r3
            int r3 = r6.textHeight
            android.graphics.drawable.Drawable r4 = r6.rightDrawable
            int r4 = r4.getIntrinsicHeight()
            int r3 = r3 - r4
            int r3 = r3 / 2
            android.graphics.drawable.Drawable r3 = r6.rightDrawable
            int r4 = r3.getIntrinsicWidth()
            int r4 = r4 + r2
            android.graphics.drawable.Drawable r5 = r6.rightDrawable
            int r5 = r5.getIntrinsicHeight()
            r3.setBounds(r2, r1, r4, r5)
            r7.save()
            int r1 = r6.getHeight()
            android.graphics.drawable.Drawable r3 = r6.rightDrawable
            int r3 = r3.getIntrinsicHeight()
            int r1 = r1 - r3
            float r1 = (float) r1
            r3 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r3
            float r2 = (float) r2
            r7.translate(r2, r1)
            android.graphics.drawable.Drawable r1 = r6.rightDrawable
            r1.draw(r7)
            r7.restore()
        L81:
            android.text.Layout r1 = r6.layout
            if (r1 == 0) goto La2
            int r1 = r6.offsetX
            int r1 = r1 + r0
            if (r1 == 0) goto L95
            r7.save()
            int r1 = r6.offsetX
            int r1 = r1 + r0
            float r1 = (float) r1
            r2 = 0
            r7.translate(r1, r2)
        L95:
            android.text.Layout r1 = r6.layout
            r1.draw(r7)
            int r1 = r6.offsetX
            int r1 = r1 + r0
            if (r1 == 0) goto La2
            r7.restore()
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ActionBar.SimpleTextView2.onDraw(android.graphics.Canvas):void");
    }

    @Override // org.rbmain.ui.ActionBar.SimpleTextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = this.leftDrawable;
        if (drawable == drawable2) {
            invalidate(drawable2.getBounds());
            return;
        }
        Drawable drawable3 = this.rightDrawable;
        if (drawable == drawable3) {
            invalidate(drawable3.getBounds());
        }
    }
}
