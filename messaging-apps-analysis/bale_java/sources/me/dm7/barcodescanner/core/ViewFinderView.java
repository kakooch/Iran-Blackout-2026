package me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.EC5;
import ir.nasim.EV1;
import ir.nasim.InterfaceC17461n03;
import ir.nasim.KA5;

/* loaded from: classes8.dex */
public class ViewFinderView extends View implements InterfaceC17461n03 {
    private static final int[] p = {0, 64, 128, 192, 255, 192, 128, 64};
    private Rect a;
    private int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    protected Paint h;
    protected Paint i;
    protected Paint j;
    protected int k;
    protected boolean l;
    private boolean m;
    private float n;
    private int o;

    public ViewFinderView(Context context) {
        super(context);
        this.c = getResources().getColor(KA5.viewfinder_laser);
        this.d = getResources().getColor(KA5.viewfinder_mask);
        this.e = getResources().getColor(KA5.viewfinder_border);
        this.f = getResources().getInteger(EC5.viewfinder_border_width);
        this.g = getResources().getInteger(EC5.viewfinder_border_length);
        this.o = 0;
        d();
    }

    private void d() {
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(this.c);
        this.h.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setColor(this.d);
        Paint paint3 = new Paint();
        this.j = paint3;
        paint3.setColor(this.e);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.f);
        this.j.setAntiAlias(true);
        this.k = this.g;
    }

    public void a(Canvas canvas) {
        Rect framingRect = getFramingRect();
        Paint paint = this.h;
        int[] iArr = p;
        paint.setAlpha(iArr[this.b]);
        this.b = (this.b + 1) % iArr.length;
        int iHeight = (framingRect.height() / 2) + framingRect.top;
        canvas.drawRect(framingRect.left + 2, iHeight - 1, framingRect.right - 1, iHeight + 2, this.h);
        postInvalidateDelayed(80L, framingRect.left - 10, framingRect.top - 10, framingRect.right + 10, framingRect.bottom + 10);
    }

    public void b(Canvas canvas) {
        Rect framingRect = getFramingRect();
        Path path = new Path();
        path.moveTo(framingRect.left, framingRect.top + this.k);
        path.lineTo(framingRect.left, framingRect.top);
        path.lineTo(framingRect.left + this.k, framingRect.top);
        canvas.drawPath(path, this.j);
        path.moveTo(framingRect.right, framingRect.top + this.k);
        path.lineTo(framingRect.right, framingRect.top);
        path.lineTo(framingRect.right - this.k, framingRect.top);
        canvas.drawPath(path, this.j);
        path.moveTo(framingRect.right, framingRect.bottom - this.k);
        path.lineTo(framingRect.right, framingRect.bottom);
        path.lineTo(framingRect.right - this.k, framingRect.bottom);
        canvas.drawPath(path, this.j);
        path.moveTo(framingRect.left, framingRect.bottom - this.k);
        path.lineTo(framingRect.left, framingRect.bottom);
        path.lineTo(framingRect.left + this.k, framingRect.bottom);
        canvas.drawPath(path, this.j);
    }

    public void c(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect framingRect = getFramingRect();
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, framingRect.top, this.i);
        canvas.drawRect(0.0f, framingRect.top, framingRect.left, framingRect.bottom + 1, this.i);
        canvas.drawRect(framingRect.right + 1, framingRect.top, f, framingRect.bottom + 1, this.i);
        canvas.drawRect(0.0f, framingRect.bottom + 1, f, height, this.i);
    }

    public synchronized void e() {
        int width;
        int height;
        try {
            Point point = new Point(getWidth(), getHeight());
            int iA = EV1.a(getContext());
            if (this.l) {
                width = (int) ((iA != 1 ? getHeight() : getWidth()) * 0.625f);
                height = width;
            } else if (iA != 1) {
                int height2 = (int) (getHeight() * 0.625f);
                height = height2;
                width = (int) (height2 * 1.4f);
            } else {
                width = (int) (getWidth() * 0.75f);
                height = (int) (width * 0.75f);
            }
            if (width > getWidth()) {
                width = getWidth() - 50;
            }
            if (height > getHeight()) {
                height = getHeight() - 50;
            }
            int i = (point.x - width) / 2;
            int i2 = (point.y - height) / 2;
            int i3 = this.o;
            this.a = new Rect(i + i3, i2 + i3, (i + width) - i3, (i2 + height) - i3);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC17461n03
    public Rect getFramingRect() {
        return this.a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getFramingRect() == null) {
            return;
        }
        c(canvas);
        b(canvas);
        if (this.m) {
            a(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        e();
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setBorderAlpha(float f) {
        this.n = f;
        this.j.setAlpha((int) (255.0f * f));
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setBorderColor(int i) {
        this.j.setColor(i);
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setBorderCornerRadius(int i) {
        this.j.setPathEffect(new CornerPathEffect(i));
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setBorderCornerRounded(boolean z) {
        if (z) {
            this.j.setStrokeJoin(Paint.Join.ROUND);
        } else {
            this.j.setStrokeJoin(Paint.Join.BEVEL);
        }
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setBorderLineLength(int i) {
        this.k = i;
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setBorderStrokeWidth(int i) {
        this.j.setStrokeWidth(i);
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setLaserColor(int i) {
        this.h.setColor(i);
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setLaserEnabled(boolean z) {
        this.m = z;
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setMaskColor(int i) {
        this.i.setColor(i);
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setSquareViewFinder(boolean z) {
        this.l = z;
    }

    public void setViewFinderOffset(int i) {
        this.o = i;
    }

    @Override // ir.nasim.InterfaceC17461n03
    public void setupViewFinder() {
        e();
        invalidate();
    }

    public ViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = getResources().getColor(KA5.viewfinder_laser);
        this.d = getResources().getColor(KA5.viewfinder_mask);
        this.e = getResources().getColor(KA5.viewfinder_border);
        this.f = getResources().getInteger(EC5.viewfinder_border_width);
        this.g = getResources().getInteger(EC5.viewfinder_border_length);
        this.o = 0;
        d();
    }
}
