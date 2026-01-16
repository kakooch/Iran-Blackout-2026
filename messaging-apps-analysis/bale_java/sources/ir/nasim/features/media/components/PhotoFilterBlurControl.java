package ir.nasim.features.media.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;

/* loaded from: classes6.dex */
public class PhotoFilterBlurControl extends FrameLayout {
    private static final float B = C22078ud6.a(20.0f);
    private static final float D = C22078ud6.a(30.0f);
    private static final float G = C22078ud6.a(30.0f);
    private PhotoFilterLinearBlurControlDelegate A;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private b f;
    private Point g;
    private float h;
    private float i;
    private Size j;
    private Point k;
    private float l;
    private float m;
    private float n;
    private RectF o;
    private float p;
    private float q;
    private float r;
    private float s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private Paint y;
    private Paint z;

    public interface PhotoFilterLinearBlurControlDelegate {
        void valueChanged(Point point, float f, float f2, float f3);
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.BlurViewActiveControlCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.BlurViewActiveControlInnerRadius.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.BlurViewActiveControlOuterRadius.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.BlurViewActiveControlRotation.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private enum b {
        BlurViewActiveControlNone,
        BlurViewActiveControlCenter,
        BlurViewActiveControlInnerRadius,
        BlurViewActiveControlOuterRadius,
        BlurViewActiveControlWholeArea,
        BlurViewActiveControlRotation
    }

    public PhotoFilterBlurControl(Context context) {
        super(context);
        this.a = 1;
        this.b = 2;
        this.c = 3;
        this.d = 4;
        this.e = 5;
        this.g = new Point();
        this.j = new Size();
        this.k = new Point(0.5f, 0.5f);
        this.l = 0.15f;
        this.m = 0.35f;
        this.o = new RectF();
        this.s = 1.0f;
        this.v = true;
        this.y = new Paint(1);
        this.z = new Paint(1);
        setWillNotDraw(false);
        Paint paint = this.y;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        paint.setColor(c5495Jo7.f0());
        this.z.setColor(c5495Jo7.f0());
        this.z.setStrokeWidth(C22078ud6.a(2.0f));
        this.z.setStyle(Paint.Style.STROKE);
    }

    private float a(float f) {
        return (f * 3.1415927f) / 180.0f;
    }

    private float b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        float x2 = x - motionEvent.getX(1);
        float y2 = y - motionEvent.getY(1);
        return (float) Math.sqrt((x2 * x2) + (y2 * y2));
    }

    private void c(int i, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Point actualCenterPoint = getActualCenterPoint();
        Point point = new Point(x - actualCenterPoint.x, y - actualCenterPoint.y);
        float f = point.x;
        float f2 = point.y;
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        Size size = this.j;
        float f3 = size.width;
        float f4 = size.height;
        if (f3 > f4) {
            f3 = f4;
        }
        float f5 = this.l * f3;
        float f6 = this.m * f3;
        float fAbs = (float) Math.abs((point.x * Math.cos(a(this.n) + 1.5707963267948966d)) + (point.y * Math.sin(a(this.n) + 1.5707963267948966d)));
        if (i == 1) {
            this.p = motionEvent.getX();
            this.q = motionEvent.getY();
            boolean z = Math.abs(f6 - f5) < B;
            float f7 = z ? 0.0f : G;
            float f8 = z ? 0.0f : G;
            int i2 = this.x;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (fSqrt < D) {
                        this.f = b.BlurViewActiveControlCenter;
                        this.g = actualCenterPoint;
                        return;
                    }
                    float f9 = G;
                    if (fSqrt > f5 - f9 && fSqrt < f7 + f5) {
                        this.f = b.BlurViewActiveControlInnerRadius;
                        this.h = fSqrt;
                        this.i = f5;
                        return;
                    } else {
                        if (fSqrt <= f6 - f8 || fSqrt >= f9 + f6) {
                            return;
                        }
                        this.f = b.BlurViewActiveControlOuterRadius;
                        this.h = fSqrt;
                        this.i = f6;
                        return;
                    }
                }
                return;
            }
            if (fSqrt < D) {
                this.f = b.BlurViewActiveControlCenter;
                this.g = actualCenterPoint;
                return;
            }
            float f10 = G;
            if (fAbs > f5 - f10 && fAbs < f7 + f5) {
                this.f = b.BlurViewActiveControlInnerRadius;
                this.h = fAbs;
                this.i = f5;
                return;
            } else if (fAbs > f6 - f8 && fAbs < f6 + f10) {
                this.f = b.BlurViewActiveControlOuterRadius;
                this.h = fAbs;
                this.i = f6;
                return;
            } else {
                if (fAbs <= f5 - f10 || fAbs >= f6 + f10) {
                    this.f = b.BlurViewActiveControlRotation;
                    return;
                }
                return;
            }
        }
        if (i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                this.f = b.BlurViewActiveControlNone;
                return;
            }
            return;
        }
        int i3 = this.x;
        if (i3 == 0) {
            int i4 = a.a[this.f.ordinal()];
            if (i4 == 1) {
                float f11 = x - this.p;
                float f12 = y - this.q;
                float width = (getWidth() - this.j.width) / 2.0f;
                float height = getHeight();
                Size size2 = this.j;
                float f13 = size2.height;
                Rect rect = new Rect(width, (height - f13) / 2.0f, size2.width, f13);
                float f14 = rect.x;
                float fMax = Math.max(f14, Math.min(rect.width + f14, this.g.x + f11));
                float f15 = rect.y;
                Point point2 = new Point(fMax, Math.max(f15, Math.min(rect.height + f15, this.g.y + f12)));
                float f16 = point2.x - rect.x;
                Size size3 = this.j;
                float f17 = size3.width;
                this.k = new Point(f16 / f17, ((point2.y - rect.y) + ((f17 - size3.height) / 2.0f)) / f17);
            } else if (i4 == 2) {
                this.l = Math.min(Math.max(0.1f, (this.i + (fAbs - this.h)) / f3), this.m - 0.02f);
            } else if (i4 == 3) {
                this.m = Math.max(this.l + 0.02f, (this.i + (fAbs - this.h)) / f3);
            } else if (i4 == 4) {
                float f18 = x - this.p;
                float f19 = y - this.q;
                boolean z2 = x > actualCenterPoint.x;
                boolean z3 = y > actualCenterPoint.y;
                this.n += ((((float) Math.sqrt((f18 * f18) + (f19 * f19))) * ((((z2 || z3 ? !z2 || z3 ? !(z2 && z3) ? !(Math.abs(f19) <= Math.abs(f18) ? f18 >= 0.0f : f19 >= 0.0f) : !(Math.abs(f19) <= Math.abs(f18) ? f18 >= 0.0f : f19 <= 0.0f) : Math.abs(f19) <= Math.abs(f18) ? f18 <= 0.0f : f19 <= 0.0f : Math.abs(f19) <= Math.abs(f18) ? f18 <= 0.0f : f19 >= 0.0f) ? 0 : 1) * 2) - 1)) / 3.1415927f) / 1.15f;
                this.p = x;
                this.q = y;
            }
        } else if (i3 == 1) {
            int i5 = a.a[this.f.ordinal()];
            if (i5 == 1) {
                float f20 = x - this.p;
                float f21 = y - this.q;
                float width2 = (getWidth() - this.j.width) / 2.0f;
                float height2 = getHeight();
                Size size4 = this.j;
                float f22 = size4.height;
                Rect rect2 = new Rect(width2, (height2 - f22) / 2.0f, size4.width, f22);
                float f23 = rect2.x;
                float fMax2 = Math.max(f23, Math.min(rect2.width + f23, this.g.x + f20));
                float f24 = rect2.y;
                Point point3 = new Point(fMax2, Math.max(f24, Math.min(rect2.height + f24, this.g.y + f21)));
                float f25 = point3.x - rect2.x;
                Size size5 = this.j;
                float f26 = size5.width;
                this.k = new Point(f25 / f26, ((point3.y - rect2.y) + ((f26 - size5.height) / 2.0f)) / f26);
            } else if (i5 == 2) {
                this.l = Math.min(Math.max(0.1f, (this.i + (fSqrt - this.h)) / f3), this.m - 0.02f);
            } else if (i5 == 3) {
                this.m = Math.max(this.l + 0.02f, (this.i + (fSqrt - this.h)) / f3);
            }
        }
        invalidate();
        PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate = this.A;
        if (photoFilterLinearBlurControlDelegate != null) {
            photoFilterLinearBlurControlDelegate.valueChanged(this.k, this.l, this.m, a(this.n) + 1.5707964f);
        }
    }

    private void d(int i, MotionEvent motionEvent) {
        if (i == 1) {
            this.r = b(motionEvent);
            this.s = 1.0f;
            this.f = b.BlurViewActiveControlWholeArea;
        } else if (i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                this.f = b.BlurViewActiveControlNone;
                return;
            }
            return;
        }
        float fB = b(motionEvent);
        float fB2 = this.s + (((fB - this.r) / AbstractC7426Rr.B()) * 0.01f);
        this.s = fB2;
        float fMax = Math.max(0.1f, this.l * fB2);
        this.l = fMax;
        this.m = Math.max(fMax + 0.02f, this.m * this.s);
        this.s = 1.0f;
        this.r = fB;
        invalidate();
        PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate = this.A;
        if (photoFilterLinearBlurControlDelegate != null) {
            photoFilterLinearBlurControlDelegate.valueChanged(this.k, this.l, this.m, a(this.n) + 1.5707964f);
        }
    }

    private Point getActualCenterPoint() {
        float width = getWidth();
        float f = this.j.width;
        float f2 = ((width - f) / 2.0f) + (this.k.x * f);
        float height = getHeight();
        Size size = this.j;
        float f3 = size.height;
        float f4 = size.width;
        return new Point(f2, (((height - f3) / 2.0f) - ((f4 - f3) / 2.0f)) + (this.k.y * f4));
    }

    private float getActualInnerRadius() {
        Size size = this.j;
        float f = size.width;
        float f2 = size.height;
        if (f > f2) {
            f = f2;
        }
        return f * this.l;
    }

    private float getActualOuterRadius() {
        Size size = this.j;
        float f = size.width;
        float f2 = size.height;
        if (f > f2) {
            f = f2;
        }
        return f * this.m;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Point actualCenterPoint = getActualCenterPoint();
        float actualInnerRadius = getActualInnerRadius();
        float actualOuterRadius = getActualOuterRadius();
        canvas.translate(actualCenterPoint.x, actualCenterPoint.y);
        int i = this.x;
        if (i == 0) {
            canvas.rotate(this.n);
            float fA = C22078ud6.a(6.0f);
            float fA2 = C22078ud6.a(12.0f);
            float fA3 = C22078ud6.a(1.5f);
            for (int i2 = 0; i2 < 30; i2++) {
                float f = fA2 + fA;
                float f2 = i2 * f;
                float f3 = -actualInnerRadius;
                float f4 = f2 + fA2;
                float f5 = fA3 - actualInnerRadius;
                canvas.drawRect(f2, f3, f4, f5, this.y);
                float f6 = ((-r11) * f) - fA;
                float f7 = f6 - fA2;
                canvas.drawRect(f7, f3, f6, f5, this.y);
                float f8 = fA3 + actualInnerRadius;
                canvas.drawRect(f2, actualInnerRadius, f4, f8, this.y);
                canvas.drawRect(f7, actualInnerRadius, f6, f8, this.y);
            }
            float fA4 = C22078ud6.a(6.0f);
            for (int i3 = 0; i3 < 64; i3++) {
                float f9 = fA4 + fA;
                float f10 = i3 * f9;
                float f11 = -actualOuterRadius;
                float f12 = fA4 + f10;
                float f13 = fA3 - actualOuterRadius;
                canvas.drawRect(f10, f11, f12, f13, this.y);
                float f14 = ((-i3) * f9) - fA;
                float f15 = f14 - fA4;
                canvas.drawRect(f15, f11, f14, f13, this.y);
                float f16 = fA3 + actualOuterRadius;
                canvas.drawRect(f10, actualOuterRadius, f12, f16, this.y);
                canvas.drawRect(f15, actualOuterRadius, f14, f16, this.y);
            }
        } else if (i == 1) {
            float f17 = -actualInnerRadius;
            this.o.set(f17, f17, actualInnerRadius, actualInnerRadius);
            for (int i4 = 0; i4 < 22; i4++) {
                canvas.drawArc(this.o, 16.35f * i4, 10.2f, false, this.z);
            }
            float f18 = -actualOuterRadius;
            this.o.set(f18, f18, actualOuterRadius, actualOuterRadius);
            for (int i5 = 0; i5 < 64; i5++) {
                canvas.drawArc(this.o, 5.62f * i5, 3.6f, false, this.z);
            }
        }
        canvas.drawCircle(0.0f, 0.0f, C22078ud6.a(8.0f), this.y);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.components.PhotoFilterBlurControl.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setActualAreaSize(float f, float f2) {
        Size size = this.j;
        size.width = f;
        size.height = f2;
    }

    public void setDelegate(PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate) {
        this.A = photoFilterLinearBlurControlDelegate;
    }

    public void setType(int i) {
        this.x = i;
    }
}
