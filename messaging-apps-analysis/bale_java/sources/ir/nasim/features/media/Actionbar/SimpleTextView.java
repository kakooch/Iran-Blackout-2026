package ir.nasim.features.media.Actionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C22078ud6;

/* loaded from: classes6.dex */
public class SimpleTextView extends View {
    private Layout a;
    private TextPaint b;
    private int c;
    private CharSequence d;
    private Drawable e;
    private Drawable f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;

    public SimpleTextView(Context context) {
        super(context);
        this.c = 51;
        this.g = C22078ud6.a(4.0f);
        this.b = new TextPaint(1);
    }

    private void a(int i) {
        if (this.a.getLineCount() > 0) {
            this.j = (int) Math.ceil(this.a.getLineWidth(0));
            this.k = this.a.getLineBottom(0);
            if ((this.c & 7) == 3) {
                this.i = -((int) this.a.getLineLeft(0));
            } else if (this.a.getLineLeft(0) == 0.0f) {
                this.i = i - this.j;
            } else {
                this.i = -C22078ud6.a(8.0f);
            }
            this.i += getPaddingLeft();
        }
    }

    private boolean b(int i) {
        if (this.d != null) {
            try {
                Drawable drawable = this.e;
                if (drawable != null) {
                    i = (i - drawable.getIntrinsicWidth()) - this.g;
                }
                Drawable drawable2 = this.f;
                if (drawable2 != null) {
                    i = (i - drawable2.getIntrinsicWidth()) - this.g;
                }
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.d, this.b, i, TextUtils.TruncateAt.END);
                this.a = new StaticLayout(charSequenceEllipsize, 0, charSequenceEllipsize.length(), this.b, i + C22078ud6.a(8.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                a(i);
            } catch (Exception unused) {
            }
        } else {
            this.a = null;
            this.j = 0;
            this.k = 0;
        }
        invalidate();
        return true;
    }

    private boolean c() {
        if (this.l) {
            return b(getMeasuredWidth());
        }
        requestLayout();
        return true;
    }

    public int getSideDrawablesSize() {
        Drawable drawable = this.e;
        int intrinsicWidth = drawable != null ? drawable.getIntrinsicWidth() + this.g : 0;
        Drawable drawable2 = this.f;
        return drawable2 != null ? intrinsicWidth + drawable2.getIntrinsicWidth() + this.g : intrinsicWidth;
    }

    public CharSequence getText() {
        CharSequence charSequence = this.d;
        return charSequence == null ? "" : charSequence;
    }

    public int getTextHeight() {
        return this.k;
    }

    public int getTextWidth() {
        return this.j;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable == drawable2) {
            invalidate(drawable2.getBounds());
            return;
        }
        Drawable drawable3 = this.f;
        if (drawable == drawable3) {
            invalidate(drawable3.getBounds());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = this.e;
        int intrinsicWidth = 0;
        if (drawable != null) {
            int intrinsicHeight = ((this.k - drawable.getIntrinsicHeight()) / 2) + this.h;
            Drawable drawable2 = this.e;
            drawable2.setBounds(0, intrinsicHeight, drawable2.getIntrinsicWidth(), this.e.getIntrinsicHeight() + intrinsicHeight);
            this.e.draw(canvas);
            if ((this.c & 7) == 3) {
                intrinsicWidth = this.e.getIntrinsicWidth() + this.g;
            }
        }
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            int i = this.j + intrinsicWidth + this.g;
            int intrinsicHeight2 = (this.k - drawable3.getIntrinsicHeight()) / 2;
            Drawable drawable4 = this.f;
            drawable4.setBounds(i, intrinsicHeight2, drawable4.getIntrinsicWidth() + i, this.f.getIntrinsicHeight() + intrinsicHeight2);
            canvas.save();
            canvas.translate(this.j - AbstractC7426Rr.z(24.0f), 0.0f);
            this.f.draw(canvas);
            canvas.restore();
        }
        if (this.a != null) {
            if (this.i + intrinsicWidth != 0) {
                canvas.save();
                canvas.translate(this.i + intrinsicWidth, 0.0f);
            }
            this.a.draw(canvas);
            if (this.i + intrinsicWidth != 0) {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.l = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        b((size - getPaddingLeft()) - getPaddingRight());
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            size2 = this.k;
        }
        setMeasuredDimension(size, size2);
    }

    public void setGravity(int i) {
        this.c = i;
    }

    public void setLeftDrawable(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (c()) {
            return;
        }
        invalidate();
    }

    public void setLeftDrawableTopPadding(int i) {
        this.h = i;
    }

    public void setRightDrawable(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (c()) {
            return;
        }
        invalidate();
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, false);
    }

    public void setTextColor(int i) {
        this.b.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        float fA = C22078ud6.a(i);
        if (fA == this.b.getTextSize()) {
            return;
        }
        this.b.setTextSize(fA);
        if (c()) {
            return;
        }
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.b.setTypeface(typeface);
    }

    public void setText(CharSequence charSequence, boolean z) {
        CharSequence charSequence2 = this.d;
        if (charSequence2 == null && charSequence == null) {
            return;
        }
        if (z || charSequence2 == null || charSequence == null || !charSequence2.equals(charSequence)) {
            this.d = charSequence;
            c();
        }
    }
}
