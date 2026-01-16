package ir.nasim.features.libphotovideo.Paint.Views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.H37;
import ir.nasim.KB5;

/* loaded from: classes3.dex */
public class ColorPicker extends FrameLayout {
    private static final int[] q = {-1431751, -2409774, -13610525, -11942419, -8337308, -205211, -223667, -16777216, -1};
    private static final float[] r = {0.0f, 0.14f, 0.24f, 0.39f, 0.49f, 0.62f, 0.73f, 0.85f, 1.0f};
    private b a;
    private boolean b;
    private boolean c;
    private boolean d;
    private OvershootInterpolator e;
    private ImageView f;
    private Drawable g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Paint k;
    private RectF l;
    private float m;
    private float n;
    private float o;
    private boolean p;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ColorPicker.this.a != null) {
                ColorPicker.this.a.d();
            }
        }
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    public ColorPicker(Context context) {
        super(context);
        this.e = new OvershootInterpolator(1.02f);
        this.h = new Paint(1);
        this.i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new RectF();
        this.m = 1.0f;
        this.n = 0.27f;
        setWillNotDraw(false);
        this.g = getResources().getDrawable(KB5.knob_shadow);
        this.i.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(AbstractC7426Rr.z(1.0f));
        ImageView imageView = new ImageView(context);
        this.f = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.f.setImageResource(KB5.photo_paint_brush);
        addView(this.f, C14433hu3.a(60, 52.0f));
        this.f.setOnClickListener(new a());
        float f = context.getSharedPreferences("paint", 0).getFloat("last_color_location", 1.0f);
        this.m = f;
        setLocation(f);
    }

    private int c(int i, int i2, float f) {
        float fMin = Math.min(Math.max(f, 0.0f), 1.0f);
        int iRed = Color.red(i);
        int iRed2 = Color.red(i2);
        int iGreen = Color.green(i);
        int iGreen2 = Color.green(i2);
        return Color.argb(255, Math.min(255, (int) (iRed + ((iRed2 - iRed) * fMin))), Math.min(255, (int) (iGreen + ((iGreen2 - iGreen) * fMin))), Math.min(255, (int) (Color.blue(i) + ((Color.blue(i2) - r6) * fMin))));
    }

    private void d(boolean z, boolean z2) {
        if (this.p == z) {
            return;
        }
        this.p = z;
        float f = z ? 1.0f : 0.0f;
        if (!z2) {
            setDraggingFactor(f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "draggingFactor", this.o, f);
        objectAnimatorOfFloat.setInterpolator(this.e);
        objectAnimatorOfFloat.setDuration(this.d ? (int) (300 + (this.n * 75.0f)) : 300);
        objectAnimatorOfFloat.start();
    }

    private void setDraggingFactor(float f) {
        this.o = f;
        invalidate();
    }

    public int b(float f) {
        float[] fArr;
        int i;
        if (f <= 0.0f) {
            return q[0];
        }
        int i2 = 1;
        if (f >= 1.0f) {
            int[] iArr = q;
            return iArr[iArr.length - 1];
        }
        while (true) {
            fArr = r;
            if (i2 >= fArr.length) {
                i2 = -1;
                i = -1;
                break;
            }
            if (fArr[i2] > f) {
                i = i2 - 1;
                break;
            }
            i2++;
        }
        float f2 = fArr[i];
        int[] iArr2 = q;
        return c(iArr2[i], iArr2[i2], (f - f2) / (fArr[i2] - f2));
    }

    public H37 getSwatch() {
        return new H37(b(this.m), this.m, this.n);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.l, AbstractC7426Rr.z(6.0f), AbstractC7426Rr.z(6.0f), this.h);
        int iCenterX = (int) ((this.l.centerX() + (this.o * (-AbstractC7426Rr.z(70.0f)))) - (this.c ? this.n * AbstractC7426Rr.z(190.0f) : 0.0f));
        int iZ = ((int) ((this.l.top - AbstractC7426Rr.z(22.0f)) + (this.l.height() * this.m))) + AbstractC7426Rr.z(22.0f);
        int iZ2 = (int) (AbstractC7426Rr.z(24.0f) * (this.o + 1.0f) * 0.5f);
        this.g.setBounds(iCenterX - iZ2, iZ - iZ2, iCenterX + iZ2, iZ2 + iZ);
        this.g.draw(canvas);
        float fFloor = (((int) Math.floor(AbstractC7426Rr.z(4.0f) + ((AbstractC7426Rr.z(19.0f) - AbstractC7426Rr.z(4.0f)) * this.n))) * (this.o + 1.0f)) / 2.0f;
        float f = iCenterX;
        float f2 = iZ;
        canvas.drawCircle(f, f2, (AbstractC7426Rr.z(22.0f) / 2) * (this.o + 1.0f), this.i);
        canvas.drawCircle(f, f2, fFloor, this.j);
        canvas.drawCircle(f, f2, fFloor - AbstractC7426Rr.z(0.5f), this.k);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredHeight = (getMeasuredHeight() - AbstractC7426Rr.z(26.0f)) - AbstractC7426Rr.z(64.0f);
        this.h.setShader(new LinearGradient(0.0f, AbstractC7426Rr.z(26.0f), 0.0f, AbstractC7426Rr.z(26.0f) + measuredHeight, q, r, Shader.TileMode.REPEAT));
        this.l.set((i5 - AbstractC7426Rr.z(26.0f)) - AbstractC7426Rr.z(8.0f), AbstractC7426Rr.z(26.0f), r12 + AbstractC7426Rr.z(8.0f), r11 + measuredHeight);
        ImageView imageView = this.f;
        imageView.layout(i5 - imageView.getMeasuredWidth(), i6 - AbstractC7426Rr.z(52.0f), i5, i6);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        float x = motionEvent.getX() - this.l.left;
        float y = motionEvent.getY() - this.l.top;
        if (!this.b && x < (-AbstractC7426Rr.z(10.0f))) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 1 || actionMasked == 6) {
            if (this.b && (bVar = this.a) != null) {
                bVar.c();
                getContext().getSharedPreferences("paint", 0).edit().putFloat("last_color_location", this.m).apply();
            }
            this.b = false;
            this.d = this.c;
            this.c = false;
            d(false, true);
        } else if (actionMasked == 0 || actionMasked == 2) {
            if (!this.b) {
                this.b = true;
                b bVar2 = this.a;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
            setLocation(Math.max(0.0f, Math.min(1.0f, y / this.l.height())));
            d(true, true);
            if (x < (-AbstractC7426Rr.z(10.0f))) {
                this.c = true;
                setWeight(Math.max(0.0f, Math.min(1.0f, ((-x) - AbstractC7426Rr.z(10.0f)) / AbstractC7426Rr.z(190.0f))));
            }
            b bVar3 = this.a;
            if (bVar3 != null) {
                bVar3.b();
            }
            return true;
        }
        return false;
    }

    public void setDelegate(b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setLocation(float r6) {
        /*
            r5 = this;
            r5.m = r6
            int r6 = r5.b(r6)
            android.graphics.Paint r0 = r5.j
            r0.setColor(r6)
            r0 = 3
            float[] r0 = new float[r0]
            android.graphics.Color.colorToHSV(r6, r0)
            r1 = 0
            r1 = r0[r1]
            double r1 = (double) r1
            r3 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L4a
            r1 = 1
            r1 = r0[r1]
            double r1 = (double) r1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L4a
            r1 = 2
            r0 = r0[r1]
            r1 = 1064011039(0x3f6b851f, float:0.92)
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L4a
            float r0 = r0 - r1
            r6 = 1034147594(0x3da3d70a, float:0.08)
            float r0 = r0 / r6
            r6 = 1046562734(0x3e6147ae, float:0.22)
            float r0 = r0 * r6
            r6 = 1065353216(0x3f800000, float:1.0)
            float r6 = r6 - r0
            r0 = 1132396544(0x437f0000, float:255.0)
            float r6 = r6 * r0
            int r6 = (int) r6
            android.graphics.Paint r0 = r5.k
            int r6 = android.graphics.Color.rgb(r6, r6, r6)
            r0.setColor(r6)
            goto L4f
        L4a:
            android.graphics.Paint r0 = r5.k
            r0.setColor(r6)
        L4f:
            r5.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.libphotovideo.Paint.Views.ColorPicker.setLocation(float):void");
    }

    public void setSettingsButtonImage(int i) {
        this.f.setImageResource(i);
    }

    public void setSwatch(H37 h37) {
        setLocation(h37.b);
        setWeight(h37.c);
    }

    public void setWeight(float f) {
        this.n = f;
        invalidate();
    }
}
