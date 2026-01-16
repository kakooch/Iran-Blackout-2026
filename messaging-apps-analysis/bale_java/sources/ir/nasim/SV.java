package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes4.dex */
public class SV extends Drawable {
    private long c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private Paint a = new Paint(1);
    private boolean b = false;
    private DecelerateInterpolator h = new DecelerateInterpolator();

    public SV(boolean z) {
        this.a.setColor(-1);
        this.a.setStrokeWidth(C22078ud6.a(2.0f));
        this.g = z;
    }

    public void a(float f, boolean z) {
        this.c = 0L;
        float f2 = this.e;
        if (f2 == 1.0f) {
            this.b = true;
        } else if (f2 == 0.0f) {
            this.b = false;
        }
        this.c = 0L;
        if (z) {
            if (f2 < f) {
                this.f = (int) (f2 * 300.0f);
            } else {
                this.f = (int) ((1.0f - f2) * 300.0f);
            }
            this.c = System.currentTimeMillis();
            this.d = f;
        } else {
            this.e = f;
            this.d = f;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        if (this.e != this.d) {
            if (this.c != 0) {
                int iCurrentTimeMillis = (int) (this.f + (System.currentTimeMillis() - this.c));
                this.f = iCurrentTimeMillis;
                if (iCurrentTimeMillis >= 300) {
                    this.e = this.d;
                } else if (this.e < this.d) {
                    this.e = this.h.getInterpolation(iCurrentTimeMillis / 300.0f) * this.d;
                } else {
                    this.e = 1.0f - this.h.getInterpolation(iCurrentTimeMillis / 300.0f);
                }
            }
            this.c = System.currentTimeMillis();
            invalidateSelf();
        }
        this.a.setColor(Color.rgb(255, 255, 255));
        canvas.save();
        canvas.translate(getIntrinsicWidth() / 2, getIntrinsicHeight() / 2);
        float f2 = this.e;
        if (this.g) {
            canvas.rotate((f2 * (this.b ? -180 : SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER)) + 135.0f);
            f = 1.0f;
        } else {
            canvas.rotate((this.b ? -225 : 135) * f2);
            f = f2;
        }
        canvas.drawLine((-C22078ud6.a(7.0f)) - (C22078ud6.a(1.0f) * f), 0.0f, C22078ud6.a(8.0f), 0.0f, this.a);
        float f3 = -C22078ud6.a(0.5f);
        float fA = C22078ud6.a(7.0f) + (C22078ud6.a(1.0f) * f);
        float fA2 = (-C22078ud6.a(7.0f)) + (C22078ud6.a(7.0f) * f);
        float fA3 = C22078ud6.a(0.5f) - (C22078ud6.a(0.5f) * f);
        canvas.drawLine(fA2, -f3, fA3, -fA, this.a);
        canvas.drawLine(fA2, f3, fA3, fA, this.a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return C22078ud6.a(24.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return C22078ud6.a(24.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
