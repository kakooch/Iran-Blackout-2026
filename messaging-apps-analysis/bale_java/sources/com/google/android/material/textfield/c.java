package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;

/* loaded from: classes3.dex */
class c extends C10345bV3 {
    private final RectF A;
    private final Paint z;

    c(C11411cx6 c11411cx6) {
        super(c11411cx6 == null ? new C11411cx6() : c11411cx6);
        this.z = new Paint(1);
        u0();
        this.A = new RectF();
    }

    private void u0() {
        this.z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.z.setColor(-1);
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    boolean q0() {
        return !this.A.isEmpty();
    }

    @Override // ir.nasim.C10345bV3
    protected void r(Canvas canvas) {
        if (this.A.isEmpty()) {
            super.r(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.A);
        } else {
            canvas.clipRect(this.A, Region.Op.DIFFERENCE);
        }
        super.r(canvas);
        canvas.restore();
    }

    void r0() {
        s0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void s0(float f, float f2, float f3, float f4) {
        RectF rectF = this.A;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }

    void t0(RectF rectF) {
        s0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
