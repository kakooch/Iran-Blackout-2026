package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import ir.nasim.C22697vg5;
import ir.nasim.DK5;
import ir.nasim.SD6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class PhotoFilterBlurControl extends FrameLayout {
    private static final float D = AbstractC21455b.F(20.0f);
    private static final float G = AbstractC21455b.F(30.0f);
    private static final float H = AbstractC21455b.F(30.0f);
    private boolean A;
    private c B;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private b f;
    private C22697vg5 g;
    private float h;
    private float i;
    private SD6 j;
    private C22697vg5 k;
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

    public interface c {
        void a(C22697vg5 c22697vg5, float f, float f2, float f3);
    }

    public PhotoFilterBlurControl(Context context) {
        super(context);
        this.a = 1;
        this.b = 2;
        this.c = 3;
        this.d = 4;
        this.e = 5;
        this.g = new C22697vg5();
        this.j = new SD6();
        this.k = new C22697vg5(0.5f, 0.5f);
        this.l = 0.15f;
        this.m = 0.35f;
        this.o = new RectF();
        this.s = 1.0f;
        this.v = true;
        this.y = new Paint(1);
        this.z = new Paint(1);
        setWillNotDraw(false);
        this.y.setColor(-1);
        this.z.setColor(-1);
        this.z.setStrokeWidth(AbstractC21455b.F(2.0f));
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
        C22697vg5 actualCenterPoint = getActualCenterPoint();
        float f = x - actualCenterPoint.a;
        float f2 = y - actualCenterPoint.b;
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        SD6 sd6 = this.j;
        float fMin = Math.min(sd6.a, sd6.b);
        float f3 = this.l * fMin;
        float f4 = this.m * fMin;
        float fAbs = (float) Math.abs((f * Math.cos(a(this.n) + 1.5707963267948966d)) + (f2 * Math.sin(a(this.n) + 1.5707963267948966d)));
        if (i == 1) {
            this.p = motionEvent.getX();
            this.q = motionEvent.getY();
            i = Math.abs(f4 - f3) < D ? 1 : 0;
            float f5 = i != 0 ? 0.0f : H;
            float f6 = i == 0 ? H : 0.0f;
            int i2 = this.x;
            if (i2 == 0) {
                if (fSqrt < G) {
                    this.f = b.BlurViewActiveControlCenter;
                    this.g = actualCenterPoint;
                } else {
                    float f7 = H;
                    if (fAbs > f3 - f7 && fAbs < f5 + f3) {
                        this.f = b.BlurViewActiveControlInnerRadius;
                        this.h = fAbs;
                        this.i = f3;
                    } else if (fAbs > f4 - f6 && fAbs < f4 + f7) {
                        this.f = b.BlurViewActiveControlOuterRadius;
                        this.h = fAbs;
                        this.i = f4;
                    } else if (fAbs <= f3 - f7 || fAbs >= f4 + f7) {
                        this.f = b.BlurViewActiveControlRotation;
                    }
                }
            } else if (i2 == 1) {
                if (fSqrt < G) {
                    this.f = b.BlurViewActiveControlCenter;
                    this.g = actualCenterPoint;
                } else {
                    float f8 = H;
                    if (fSqrt > f3 - f8 && fSqrt < f5 + f3) {
                        this.f = b.BlurViewActiveControlInnerRadius;
                        this.h = fSqrt;
                        this.i = f3;
                    } else if (fSqrt > f4 - f6 && fSqrt < f8 + f4) {
                        this.f = b.BlurViewActiveControlOuterRadius;
                        this.h = fSqrt;
                        this.i = f4;
                    }
                }
            }
            e(true, true);
            return;
        }
        if (i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                this.f = b.BlurViewActiveControlNone;
                e(false, true);
                return;
            }
            return;
        }
        int i3 = this.x;
        if (i3 == 0) {
            int i4 = a.a[this.f.ordinal()];
            if (i4 == 1) {
                float f9 = x - this.p;
                float f10 = y - this.q;
                float width = (getWidth() - this.j.a) / 2.0f;
                float f11 = this.A ? 0 : AbstractC21455b.d;
                float height = getHeight();
                SD6 sd62 = this.j;
                float f12 = sd62.b;
                DK5 dk5 = new DK5(width, f11 + ((height - f12) / 2.0f), sd62.a, f12);
                float f13 = dk5.a;
                float fMax = Math.max(f13, Math.min(dk5.c + f13, this.g.a + f9));
                float f14 = dk5.b;
                C22697vg5 c22697vg5 = new C22697vg5(fMax, Math.max(f14, Math.min(dk5.d + f14, this.g.b + f10)));
                float f15 = c22697vg5.a - dk5.a;
                SD6 sd63 = this.j;
                float f16 = sd63.a;
                this.k = new C22697vg5(f15 / f16, ((c22697vg5.b - dk5.b) + ((f16 - sd63.b) / 2.0f)) / f16);
            } else if (i4 == 2) {
                this.l = Math.min(Math.max(0.1f, (this.i + (fAbs - this.h)) / fMin), this.m - 0.02f);
            } else if (i4 == 3) {
                this.m = Math.max(this.l + 0.02f, (this.i + (fAbs - this.h)) / fMin);
            } else if (i4 == 4) {
                float f17 = x - this.p;
                float f18 = y - this.q;
                boolean z = x > actualCenterPoint.a;
                boolean z2 = y > actualCenterPoint.b;
                boolean z3 = Math.abs(f18) > Math.abs(f17);
                if (z || z2 ? !(!z || z2 ? !z || !z2 ? !z3 ? f17 >= 0.0f : f18 >= 0.0f : !z3 ? f17 >= 0.0f : f18 <= 0.0f : !z3 ? f17 <= 0.0f : f18 <= 0.0f) : !(!z3 ? f17 <= 0.0f : f18 >= 0.0f)) {
                    i = 1;
                }
                this.n += ((((float) Math.sqrt((f17 * f17) + (f18 * f18))) * ((i * 2) - 1)) / 3.1415927f) / 1.15f;
                this.p = x;
                this.q = y;
            }
        } else if (i3 == 1) {
            int i5 = a.a[this.f.ordinal()];
            if (i5 == 1) {
                float f19 = x - this.p;
                float f20 = y - this.q;
                float width2 = (getWidth() - this.j.a) / 2.0f;
                float f21 = this.A ? 0 : AbstractC21455b.d;
                float height2 = getHeight();
                SD6 sd64 = this.j;
                float f22 = sd64.b;
                DK5 dk52 = new DK5(width2, f21 + ((height2 - f22) / 2.0f), sd64.a, f22);
                float f23 = dk52.a;
                float fMax2 = Math.max(f23, Math.min(dk52.c + f23, this.g.a + f19));
                float f24 = dk52.b;
                C22697vg5 c22697vg52 = new C22697vg5(fMax2, Math.max(f24, Math.min(dk52.d + f24, this.g.b + f20)));
                float f25 = c22697vg52.a - dk52.a;
                SD6 sd65 = this.j;
                float f26 = sd65.a;
                this.k = new C22697vg5(f25 / f26, ((c22697vg52.b - dk52.b) + ((f26 - sd65.b) / 2.0f)) / f26);
            } else if (i5 == 2) {
                this.l = Math.min(Math.max(0.1f, (this.i + (fSqrt - this.h)) / fMin), this.m - 0.02f);
            } else if (i5 == 3) {
                this.m = Math.max(this.l + 0.02f, (this.i + (fSqrt - this.h)) / fMin);
            }
        }
        invalidate();
        c cVar = this.B;
        if (cVar != null) {
            cVar.a(this.k, this.l, this.m, a(this.n) + 1.5707964f);
        }
    }

    private void d(int i, MotionEvent motionEvent) {
        if (i == 1) {
            this.r = b(motionEvent);
            this.s = 1.0f;
            this.f = b.BlurViewActiveControlWholeArea;
            e(true, true);
        } else if (i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                this.f = b.BlurViewActiveControlNone;
                e(false, true);
                return;
            }
            return;
        }
        float fB = b(motionEvent);
        float f = this.s + (((fB - this.r) / AbstractC21455b.g) * 0.01f);
        this.s = f;
        float fMax = Math.max(0.1f, this.l * f);
        this.l = fMax;
        this.m = Math.max(fMax + 0.02f, this.m * this.s);
        this.s = 1.0f;
        this.r = fB;
        invalidate();
        c cVar = this.B;
        if (cVar != null) {
            cVar.a(this.k, this.l, this.m, a(this.n) + 1.5707964f);
        }
    }

    private void e(boolean z, boolean z2) {
    }

    private C22697vg5 getActualCenterPoint() {
        float width = getWidth();
        float f = this.j.a;
        float f2 = ((width - f) / 2.0f) + (this.k.a * f);
        int i = !this.A ? AbstractC21455b.d : 0;
        float height = getHeight();
        SD6 sd6 = this.j;
        float f3 = sd6.b;
        float f4 = i + ((height - f3) / 2.0f);
        float f5 = sd6.a;
        return new C22697vg5(f2, (f4 - ((f5 - f3) / 2.0f)) + (this.k.b * f5));
    }

    private float getActualInnerRadius() {
        SD6 sd6 = this.j;
        return Math.min(sd6.a, sd6.b) * this.l;
    }

    private float getActualOuterRadius() {
        SD6 sd6 = this.j;
        return Math.min(sd6.a, sd6.b) * this.m;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        C22697vg5 actualCenterPoint = getActualCenterPoint();
        float actualInnerRadius = getActualInnerRadius();
        float actualOuterRadius = getActualOuterRadius();
        canvas.translate(actualCenterPoint.a, actualCenterPoint.b);
        int i = this.x;
        if (i == 0) {
            canvas.rotate(this.n);
            float F = AbstractC21455b.F(6.0f);
            float F2 = AbstractC21455b.F(12.0f);
            float F3 = AbstractC21455b.F(1.5f);
            for (int i2 = 0; i2 < 30; i2++) {
                float f = F2 + F;
                float f2 = i2 * f;
                float f3 = -actualInnerRadius;
                float f4 = f2 + F2;
                float f5 = F3 - actualInnerRadius;
                canvas.drawRect(f2, f3, f4, f5, this.y);
                float f6 = ((-r11) * f) - F;
                float f7 = f6 - F2;
                canvas.drawRect(f7, f3, f6, f5, this.y);
                float f8 = F3 + actualInnerRadius;
                canvas.drawRect(f2, actualInnerRadius, f4, f8, this.y);
                canvas.drawRect(f7, actualInnerRadius, f6, f8, this.y);
            }
            float F4 = AbstractC21455b.F(6.0f);
            for (int i3 = 0; i3 < 64; i3++) {
                float f9 = F4 + F;
                float f10 = i3 * f9;
                float f11 = -actualOuterRadius;
                float f12 = F4 + f10;
                float f13 = F3 - actualOuterRadius;
                canvas.drawRect(f10, f11, f12, f13, this.y);
                float f14 = ((-i3) * f9) - F;
                float f15 = f14 - F4;
                canvas.drawRect(f15, f11, f14, f13, this.y);
                float f16 = F3 + actualOuterRadius;
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
        canvas.drawCircle(0.0f, 0.0f, AbstractC21455b.F(8.0f), this.y);
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterBlurControl.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setActualAreaSize(float f, float f2) {
        SD6 sd6 = this.j;
        sd6.a = f;
        sd6.b = f2;
    }

    public void setDelegate(c cVar) {
        this.B = cVar;
    }

    public void setType(int i) {
        this.x = i;
        invalidate();
    }
}
