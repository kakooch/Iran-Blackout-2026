package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public class CombinedDrawable extends Drawable implements Drawable.Callback {
    private int backHeight;
    private int backWidth;
    private Drawable background;
    private boolean fullSize;
    private Drawable icon;
    private int iconHeight;
    private int iconWidth;
    private int left;
    private int offsetX;
    private int offsetY;
    private int top;

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] state) {
        return true;
    }

    public CombinedDrawable(Drawable backgroundDrawable, Drawable iconDrawable, int leftOffset, int topOffset) {
        this.background = backgroundDrawable;
        this.icon = iconDrawable;
        this.left = leftOffset;
        this.top = topOffset;
        if (iconDrawable != null) {
            iconDrawable.setCallback(this);
        }
    }

    public void setIconSize(int width, int height) {
        this.iconWidth = width;
        this.iconHeight = height;
    }

    public CombinedDrawable(Drawable backgroundDrawable, Drawable iconDrawable) {
        this.background = backgroundDrawable;
        this.icon = iconDrawable;
        if (iconDrawable != null) {
            iconDrawable.setCallback(this);
        }
    }

    public void setCustomSize(int width, int height) {
        this.backWidth = width;
        this.backHeight = height;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public void setFullsize(boolean value) {
        this.fullSize = value;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.icon.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.icon.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        this.icon.setState(stateSet);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.icon.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.icon.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.icon.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.background.setBounds(getBounds());
        this.background.draw(canvas);
        if (this.icon != null) {
            if (this.fullSize) {
                android.graphics.Rect bounds = getBounds();
                int i = this.left;
                if (i != 0) {
                    Drawable drawable = this.icon;
                    int i2 = bounds.left + i;
                    int i3 = bounds.top;
                    int i4 = this.top;
                    drawable.setBounds(i2, i3 + i4, bounds.right - i, bounds.bottom - i4);
                } else {
                    this.icon.setBounds(bounds);
                }
            } else if (this.iconWidth != 0) {
                int iCenterX = (getBounds().centerX() - (this.iconWidth / 2)) + this.left + this.offsetX;
                int iCenterY = getBounds().centerY();
                int i5 = this.iconHeight;
                int i6 = (iCenterY - (i5 / 2)) + this.top + this.offsetY;
                this.icon.setBounds(iCenterX, i6, this.iconWidth + iCenterX, i5 + i6);
            } else {
                int iCenterX2 = (getBounds().centerX() - (this.icon.getIntrinsicWidth() / 2)) + this.left;
                int iCenterY2 = (getBounds().centerY() - (this.icon.getIntrinsicHeight() / 2)) + this.top;
                Drawable drawable2 = this.icon;
                drawable2.setBounds(iCenterX2, iCenterY2, drawable2.getIntrinsicWidth() + iCenterX2, this.icon.getIntrinsicHeight() + iCenterY2);
            }
            this.icon.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.icon.setAlpha(alpha);
        this.background.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.backWidth;
        return i != 0 ? i : this.background.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.backHeight;
        return i != 0 ? i : this.background.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        int i = this.backWidth;
        return i != 0 ? i : this.background.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        int i = this.backHeight;
        return i != 0 ? i : this.background.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.icon.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }
}
