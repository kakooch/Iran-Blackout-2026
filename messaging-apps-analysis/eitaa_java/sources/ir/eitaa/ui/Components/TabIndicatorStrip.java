package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TabIndicatorStrip {
    private int currentIndex;
    private int firstTabIndex;
    private int height;
    private int nextIndex;
    private float progress;
    private int width;
    private int x;
    private int y;
    private final float d = AndroidUtilities.dp(14.0f);
    private final float r = AndroidUtilities.dp(4.0f);
    private final Paint paint = new Paint(1);
    private final List<Object> objects = new ArrayList();

    public void setObjects(List<Object> newObjects) {
        this.objects.clear();
        this.objects.addAll(newObjects);
        reset();
    }

    public void setCoords(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    private void reset() {
        this.currentIndex = 0;
        this.nextIndex = 0;
        this.firstTabIndex = 0;
        this.progress = 0.0f;
    }

    public Object getNextObject(boolean forward) {
        if (forward) {
            if (this.currentIndex + 1 < this.objects.size()) {
                return this.objects.get(this.currentIndex + 1);
            }
            return null;
        }
        int i = this.currentIndex;
        if (i - 1 >= 0) {
            return this.objects.get(i - 1);
        }
        return null;
    }

    public void selectTabWithObject(Object object, float progress) {
        int iIndexOf = this.objects.indexOf(object);
        if (progress < 0.0f) {
            progress = 0.0f;
        } else if (progress > 1.0f) {
            progress = 1.0f;
        }
        this.progress = progress;
        if (iIndexOf >= 0) {
            this.nextIndex = iIndexOf;
        }
        if (progress >= 1.0f) {
            int i = this.nextIndex;
            this.currentIndex = i;
            int i2 = this.firstTabIndex;
            if (i - i2 >= 5) {
                this.firstTabIndex = i - 4;
            } else if (i < i2) {
                this.firstTabIndex = i;
            }
        }
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void draw(Canvas canvas) {
        float f;
        if (this.objects.size() < 2) {
            return;
        }
        this.paint.setColor(-13421773);
        canvas.save();
        canvas.translate(this.x, this.y);
        canvas.save();
        canvas.translate(this.width / 2.0f, this.height / 2.0f);
        canvas.save();
        int i = this.nextIndex;
        int i2 = this.currentIndex;
        if ((i >= i2 || i >= this.firstTabIndex) && (i <= i2 || i2 - this.firstTabIndex < 4)) {
            f = 0.0f;
        } else {
            f = i > i2 ? -1.0f : 1.0f;
            canvas.translate(this.progress * this.d * f, 0.0f);
        }
        int iMin = Math.min(this.objects.size(), 5);
        for (int i3 = 0; i3 < iMin; i3++) {
            float f2 = (((-(iMin - 1.0f)) / 2.0f) + i3) * this.d;
            float f3 = this.r;
            int i4 = this.currentIndex;
            int i5 = this.firstTabIndex;
            if (i3 == i4 - i5) {
                f3 *= i4 == this.nextIndex ? 1.25f : ((1.0f - this.progress) * 0.25f) + 1.0f;
                this.paint.setColor(Theme.getColor("switchThumbChecked"));
            } else {
                if (i3 == this.nextIndex - i5) {
                    f3 *= (this.progress * 0.25f) + 1.0f;
                }
                this.paint.setColor(Theme.getColor("switchTrack"));
            }
            if (i3 == 0 && f < 0.0f) {
                f3 -= (this.r / 2.0f) * this.progress;
            }
            if (i3 == iMin - 1 && f > 0.0f) {
                f3 -= (this.r / 2.0f) * this.progress;
            }
            canvas.drawCircle(f2, 0.0f, f3, this.paint);
        }
        this.paint.setColor(Theme.getColor("switchTrack"));
        if (this.firstTabIndex >= 2) {
            float f4 = this.r;
            float f5 = f4 / 4.0f;
            if (f > 0.0f) {
                f5 += (this.progress * f4) / 4.0f;
            } else if (f < 0.0f) {
                f5 -= (this.progress * f4) / 4.0f;
            }
            canvas.drawCircle(this.d * (-4.0f), 0.0f, f5, this.paint);
        }
        if (this.firstTabIndex >= 1) {
            float f6 = this.r;
            float f7 = f6 / 2.0f;
            if (f > 0.0f) {
                f7 += (this.progress * f6) / 2.0f;
            } else if (f < 0.0f) {
                f7 -= (this.progress * f6) / 4.0f;
            }
            canvas.drawCircle(this.d * (-3.0f), 0.0f, f7, this.paint);
        }
        if (this.firstTabIndex < this.objects.size() - 5) {
            float f8 = this.r;
            float f9 = f8 / 2.0f;
            if (f > 0.0f) {
                f9 -= (this.progress * f8) / 4.0f;
            } else if (f < 0.0f) {
                f9 += (this.progress * f8) / 2.0f;
            }
            canvas.drawCircle(this.d * 3.0f, 0.0f, f9, this.paint);
        }
        if (this.firstTabIndex < this.objects.size() - 6) {
            float f10 = this.r;
            float f11 = f10 / 4.0f;
            if (f > 0.0f) {
                f11 -= (this.progress * f10) / 4.0f;
            } else if (f < 0.0f) {
                f11 += (this.progress * f10) / 4.0f;
            }
            canvas.drawCircle(this.d * 4.0f, 0.0f, f11, this.paint);
        }
        canvas.restore();
        canvas.restore();
        canvas.restore();
    }
}
