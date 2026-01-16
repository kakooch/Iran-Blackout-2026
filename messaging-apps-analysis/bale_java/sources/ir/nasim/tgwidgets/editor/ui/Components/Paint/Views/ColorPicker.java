package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
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
import androidx.annotation.Keep;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.G37;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class ColorPicker extends FrameLayout {
    private static final int[] q = {-1431751, -2409774, -13610525, -11942419, -8337308, -205211, -223667, -16777216, -1};
    private static final float[] r = {0.0f, 0.14f, 0.24f, 0.39f, 0.49f, 0.62f, 0.73f, 0.85f, 1.0f};
    private boolean a;
    private boolean b;
    private boolean c;
    private OvershootInterpolator d;
    public ImageView e;
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

    public interface a {
    }

    public ColorPicker(Context context) {
        super(context);
        this.d = new OvershootInterpolator(1.02f);
        this.h = new Paint(1);
        this.i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new RectF();
        this.n = 0.016773745f;
        setWillNotDraw(false);
        this.g = getResources().getDrawable(AbstractC23598xB5.knob_shadow);
        this.i.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(AbstractC21455b.F(1.0f));
        ImageView imageView = new ImageView(context);
        this.e = imageView;
        imageView.setContentDescription(FH3.E("AccDescrBrushType", TD5.tgwidget_AccDescrBrushType));
        ImageView imageView2 = this.e;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView2.setScaleType(scaleType);
        this.e.setImageResource(AbstractC23598xB5.photo_paint_brush);
        addView(this.e, AbstractC13840gu3.b(46, 52.0f));
        this.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.e(view);
            }
        });
        ImageView imageView3 = new ImageView(context);
        this.f = imageView3;
        imageView3.setContentDescription(FH3.E("Undo", TD5.tgwidget_Undo));
        this.f.setScaleType(scaleType);
        this.f.setImageResource(AbstractC23598xB5.photo_undo);
        addView(this.f, AbstractC13840gu3.b(46, 52.0f));
        this.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f(view);
            }
        });
        SharedPreferences sharedPreferences = context.getSharedPreferences("paint", 0);
        this.m = sharedPreferences.getFloat("last_color_location", 1.0f);
        setWeight(sharedPreferences.getFloat("last_color_weight", 0.016773745f));
        setLocation(this.m);
    }

    private int d(int i, int i2, float f) {
        float fMin = Math.min(Math.max(f, 0.0f), 1.0f);
        int iRed = Color.red(i);
        int iRed2 = Color.red(i2);
        int iGreen = Color.green(i);
        int iGreen2 = Color.green(i2);
        return Color.argb(255, Math.min(255, (int) (iRed + ((iRed2 - iRed) * fMin))), Math.min(255, (int) (iGreen + ((iGreen2 - iGreen) * fMin))), Math.min(255, (int) (Color.blue(i) + ((Color.blue(i2) - r6) * fMin))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
    }

    private void g(boolean z, boolean z2) {
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
        objectAnimatorOfFloat.setInterpolator(this.d);
        objectAnimatorOfFloat.setDuration(this.c ? (int) (300 + (this.n * 75.0f)) : 300);
        objectAnimatorOfFloat.start();
    }

    @Keep
    private void setDraggingFactor(float f) {
        this.o = f;
        invalidate();
    }

    public int c(float f) {
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
            if (fArr[i2] >= f) {
                i = i2 - 1;
                break;
            }
            i2++;
        }
        float f2 = fArr[i];
        int[] iArr2 = q;
        return d(iArr2[i], iArr2[i2], (f - f2) / (fArr[i2] - f2));
    }

    @Keep
    public float getDraggingFactor() {
        return this.o;
    }

    public View getSettingsButton() {
        return this.e;
    }

    public G37 getSwatch() {
        return new G37(c(this.m), this.m, this.n);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.l, AbstractC21455b.F(6.0f), AbstractC21455b.F(6.0f), this.h);
        RectF rectF = this.l;
        int iWidth = (int) (rectF.left + (rectF.width() * this.m));
        int iCenterY = (int) ((this.l.centerY() + (this.o * (-AbstractC21455b.F(70.0f)))) - (this.b ? this.n * AbstractC21455b.F(190.0f) : 0.0f));
        int iF = (int) (AbstractC21455b.F(24.0f) * (this.o + 1.0f) * 0.5f);
        this.g.setBounds(iWidth - iF, iCenterY - iF, iWidth + iF, iF + iCenterY);
        this.g.draw(canvas);
        float fFloor = (((int) Math.floor(AbstractC21455b.F(4.0f) + ((AbstractC21455b.F(19.0f) - AbstractC21455b.F(4.0f)) * this.n))) * (this.o + 1.0f)) / 2.0f;
        float f = iWidth;
        float f2 = iCenterY;
        canvas.drawCircle(f, f2, (AbstractC21455b.F(22.0f) / 2) * (this.o + 1.0f), this.i);
        canvas.drawCircle(f, f2, fFloor, this.j);
        canvas.drawCircle(f, f2, fFloor - AbstractC21455b.F(0.5f), this.k);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.h.setShader(new LinearGradient(AbstractC21455b.F(56.0f), 0.0f, i5 - AbstractC21455b.F(56.0f), 0.0f, q, r, Shader.TileMode.REPEAT));
        this.l.set(AbstractC21455b.F(56.0f), i6 - AbstractC21455b.F(32.0f), i5 - AbstractC21455b.F(56.0f), r9 + AbstractC21455b.F(12.0f));
        ImageView imageView = this.e;
        imageView.layout(i5 - imageView.getMeasuredWidth(), i6 - AbstractC21455b.F(52.0f), i5, i6);
        this.f.layout(0, i6 - AbstractC21455b.F(52.0f), this.e.getMeasuredWidth(), i6);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        float x = motionEvent.getX() - this.l.left;
        float y = motionEvent.getY() - this.l.top;
        if (!this.a && y < (-AbstractC21455b.F(10.0f))) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 1 || actionMasked == 6) {
            this.a = false;
            this.c = this.b;
            this.b = false;
            g(false, true);
        } else if (actionMasked == 0 || actionMasked == 2) {
            if (!this.a) {
                this.a = true;
            }
            setLocation(Math.max(0.0f, Math.min(1.0f, x / this.l.width())));
            g(true, true);
            if (y < (-AbstractC21455b.F(10.0f))) {
                this.b = true;
                setWeight(Math.max(0.0f, Math.min(1.0f, ((-y) - AbstractC21455b.F(10.0f)) / AbstractC21455b.F(190.0f))));
            }
            return true;
        }
        return false;
    }

    public void setDelegate(a aVar) {
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
            int r6 = r5.c(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.ColorPicker.setLocation(float):void");
    }

    public void setSettingsButtonImage(int i) {
        this.e.setImageResource(i);
    }

    public void setSwatch(G37 g37) {
        setLocation(g37.b);
        setWeight(g37.c);
    }

    public void setUndoEnabled(boolean z) {
        this.f.setAlpha(z ? 1.0f : 0.3f);
        this.f.setEnabled(z);
    }

    public void setWeight(float f) {
        this.n = f;
        invalidate();
    }
}
