package ir.nasim;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.fZ0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13010fZ0 extends Drawable implements Drawable.Callback {
    private Drawable a;
    private Drawable b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;

    public C13010fZ0(Drawable drawable, Drawable drawable2, int i, int i2) {
        this.a = drawable;
        this.b = drawable2;
        this.c = i;
        this.d = i2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
    }

    public Drawable a() {
        return this.a;
    }

    public Drawable b() {
        return this.b;
    }

    public void c(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    public void d(boolean z) {
        this.k = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.a.setBounds(getBounds());
        this.a.draw(canvas);
        if (this.b != null) {
            if (this.k) {
                Rect bounds = getBounds();
                int i = this.c;
                if (i != 0) {
                    Drawable drawable = this.b;
                    int i2 = bounds.left + i;
                    int i3 = bounds.top;
                    int i4 = this.d;
                    drawable.setBounds(i2, i3 + i4, bounds.right - i, bounds.bottom - i4);
                } else {
                    this.b.setBounds(bounds);
                }
            } else if (this.e != 0) {
                int iCenterX = (getBounds().centerX() - (this.e / 2)) + this.c + this.i;
                int iCenterY = getBounds().centerY();
                int i5 = this.f;
                int i6 = (iCenterY - (i5 / 2)) + this.d + this.j;
                this.b.setBounds(iCenterX, i6, this.e + iCenterX, i5 + i6);
            } else {
                int iCenterX2 = (getBounds().centerX() - (this.b.getIntrinsicWidth() / 2)) + this.c;
                int iCenterY2 = (getBounds().centerY() - (this.b.getIntrinsicHeight() / 2)) + this.d;
                Drawable drawable2 = this.b;
                drawable2.setBounds(iCenterX2, iCenterY2, drawable2.getIntrinsicWidth() + iCenterX2, this.b.getIntrinsicHeight() + iCenterY2);
            }
            this.b.draw(canvas);
        }
    }

    public void e(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.b.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.h;
        return i != 0 ? i : this.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.g;
        return i != 0 ? i : this.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        int i = this.h;
        return i != 0 ? i : this.a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        int i = this.g;
        return i != 0 ? i : this.a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.b.getState();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.b.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        if (this.l) {
            this.a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        this.b.setState(iArr);
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public C13010fZ0(Drawable drawable, Drawable drawable2) {
        this.a = drawable;
        this.b = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
    }
}
