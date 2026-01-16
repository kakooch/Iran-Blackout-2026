package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import androidx.annotation.Keep;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class ClippingImageView extends View {
    private static float[] y = new float[8];
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private RectF i;
    private Paint j;
    private ImageReceiver.b k;
    private Matrix l;
    private boolean m;
    private int[] n;
    private BitmapShader o;
    private Paint p;
    private RectF q;
    private RectF r;
    private Matrix s;
    private Path t;
    private float u;
    private float[][] v;
    private float w;
    private float x;

    public ClippingImageView(Context context) {
        super(context);
        this.n = new int[4];
        this.t = new Path();
        Paint paint = new Paint(2);
        this.j = paint;
        paint.setFilterBitmap(true);
        this.l = new Matrix();
        this.i = new RectF();
        this.r = new RectF();
        this.p = new Paint(3);
        this.q = new RectF();
        this.s = new Matrix();
    }

    public void a(RectF rectF) {
        rectF.left = getTranslationX();
        rectF.top = getTranslationY();
        rectF.right = rectF.left + (getMeasuredWidth() * getScaleX());
        float measuredHeight = rectF.top + (getMeasuredHeight() * getScaleY());
        rectF.left += this.b;
        rectF.top += this.d;
        rectF.right -= this.c;
        rectF.bottom = measuredHeight - this.a;
    }

    @Keep
    public float getAnimationProgress() {
        return this.u;
    }

    public Bitmap getBitmap() {
        ImageReceiver.b bVar = this.k;
        if (bVar != null) {
            return bVar.c;
        }
        return null;
    }

    public float getCenterX() {
        float scaleY = getScaleY();
        return getTranslationX() + ((((this.b / scaleY) + (getWidth() - (this.c / scaleY))) / 2.0f) * getScaleX());
    }

    public float getCenterY() {
        float scaleY = getScaleY();
        return getTranslationY() + ((((this.d / scaleY) + (getHeight() - (this.a / scaleY))) / 2.0f) * getScaleY());
    }

    public int getClipBottom() {
        return this.a;
    }

    public int getClipHorizontal() {
        return this.c;
    }

    public int getClipLeft() {
        return this.b;
    }

    public int getClipRight() {
        return this.c;
    }

    public int getClipTop() {
        return this.d;
    }

    public int getOrientation() {
        return this.e;
    }

    public int[] getRadius() {
        return this.n;
    }

    @Override // android.view.View
    public float getTranslationY() {
        return super.getTranslationY() - this.w;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        ImageReceiver.b bVar;
        if (getVisibility() != 0 || (bVar = this.k) == null || bVar.c()) {
            return;
        }
        float scaleY = getScaleY();
        canvas.save();
        if (this.m) {
            this.s.reset();
            this.q.set(this.h / scaleY, this.g / scaleY, getWidth() - (this.h / scaleY), getHeight() - (this.g / scaleY));
            this.r.set(0.0f, 0.0f, this.k.b(), this.k.a());
            AbstractC21455b.v1(this.s, this.r, this.q, this.e, this.f, false);
            this.o.setLocalMatrix(this.s);
            canvas.clipRect(this.b / scaleY, this.d / scaleY, getWidth() - (this.c / scaleY), getHeight() - (this.a / scaleY));
            int i = 0;
            while (true) {
                int[] iArr = this.n;
                if (i >= iArr.length) {
                    break;
                }
                float[] fArr = y;
                int i2 = i * 2;
                int i3 = iArr[i];
                fArr[i2] = i3;
                fArr[i2 + 1] = i3;
                i++;
            }
            this.t.reset();
            this.t.addRoundRect(this.q, y, Path.Direction.CW);
            this.t.close();
            canvas.drawPath(this.t, this.p);
        } else {
            int i4 = this.e;
            if (i4 == 90 || i4 == 270) {
                this.i.set((-getHeight()) / 2, (-getWidth()) / 2, getHeight() / 2, getWidth() / 2);
                this.l.setRectToRect(this.r, this.i, Matrix.ScaleToFit.FILL);
                int i5 = this.f;
                if (i5 == 1) {
                    this.l.postScale(-1.0f, 1.0f);
                } else if (i5 == 2) {
                    this.l.postScale(1.0f, -1.0f);
                }
                this.l.postRotate(this.e, 0.0f, 0.0f);
                this.l.postTranslate(getWidth() / 2, getHeight() / 2);
            } else if (i4 == 180) {
                this.i.set((-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
                this.l.setRectToRect(this.r, this.i, Matrix.ScaleToFit.FILL);
                int i6 = this.f;
                if (i6 == 1) {
                    this.l.postScale(-1.0f, 1.0f);
                } else if (i6 == 2) {
                    this.l.postScale(1.0f, -1.0f);
                }
                this.l.postRotate(this.e, 0.0f, 0.0f);
                this.l.postTranslate(getWidth() / 2, getHeight() / 2);
            } else {
                this.i.set(0.0f, 0.0f, getWidth(), getHeight());
                int i7 = this.f;
                if (i7 == 1) {
                    this.l.postScale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
                } else if (i7 == 2) {
                    this.l.postScale(1.0f, -1.0f, getWidth() / 2, getHeight() / 2);
                }
                this.l.setRectToRect(this.r, this.i, Matrix.ScaleToFit.FILL);
            }
            canvas.clipRect(this.b / scaleY, this.d / scaleY, getWidth() - (this.c / scaleY), getHeight() - (this.a / scaleY));
            try {
                canvas.drawBitmap(this.k.c, this.l, this.j);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
        canvas.restore();
    }

    public void setAdditionalTranslationX(float f) {
        this.x = f;
    }

    public void setAdditionalTranslationY(float f) {
        this.w = f;
    }

    @Keep
    public void setAnimationProgress(float f) {
        this.u = f;
        float[][] fArr = this.v;
        float f2 = fArr[0][0];
        setScaleX(f2 + ((fArr[1][0] - f2) * f));
        float[][] fArr2 = this.v;
        float f3 = fArr2[0][1];
        setScaleY(f3 + ((fArr2[1][1] - f3) * this.u));
        float[][] fArr3 = this.v;
        float f4 = fArr3[0][2];
        float f5 = this.x;
        setTranslationX(f4 + f5 + ((((fArr3[1][2] + f5) - f4) - f5) * this.u));
        float[][] fArr4 = this.v;
        float f6 = fArr4[0][3];
        setTranslationY(f6 + ((fArr4[1][3] - f6) * this.u));
        float[][] fArr5 = this.v;
        float f7 = fArr5[0][4];
        setClipHorizontal((int) (f7 + ((fArr5[1][4] - f7) * this.u)));
        float[][] fArr6 = this.v;
        float f8 = fArr6[0][5];
        setClipTop((int) (f8 + ((fArr6[1][5] - f8) * this.u)));
        float[][] fArr7 = this.v;
        float f9 = fArr7[0][6];
        setClipBottom((int) (f9 + ((fArr7[1][6] - f9) * this.u)));
        int i = 0;
        while (true) {
            int[] iArr = this.n;
            if (i >= iArr.length) {
                break;
            }
            float[][] fArr8 = this.v;
            int i2 = i + 7;
            float f10 = fArr8[0][i2];
            iArr[i] = (int) (f10 + ((fArr8[1][i2] - f10) * this.u));
            setRadius(iArr);
            i++;
        }
        float[][] fArr9 = this.v;
        float[] fArr10 = fArr9[0];
        if (fArr10.length > 11) {
            float f11 = fArr10[11];
            setImageY((int) (f11 + ((fArr9[1][11] - f11) * this.u)));
            float[][] fArr11 = this.v;
            float f12 = fArr11[0][12];
            setImageX((int) (f12 + ((fArr11[1][12] - f12) * this.u)));
        }
        invalidate();
    }

    public void setAnimationValues(float[][] fArr) {
        this.v = fArr;
    }

    public void setClipBottom(int i) {
        this.a = i;
        invalidate();
    }

    public void setClipHorizontal(int i) {
        this.c = i;
        this.b = i;
        invalidate();
    }

    public void setClipLeft(int i) {
        this.b = i;
        invalidate();
    }

    public void setClipRight(int i) {
        this.c = i;
        invalidate();
    }

    public void setClipTop(int i) {
        this.d = i;
        invalidate();
    }

    public void setClipVertical(int i) {
        this.a = i;
        this.d = i;
        invalidate();
    }

    public void setImageBitmap(ImageReceiver.b bVar) {
        ImageReceiver.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.d();
            this.o = null;
        }
        this.k = bVar;
        if (bVar != null && bVar.c != null) {
            this.r.set(0.0f, 0.0f, bVar.b(), bVar.a());
            Bitmap bitmap = this.k.c;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.o = bitmapShader;
            this.p.setShader(bitmapShader);
        }
        invalidate();
    }

    public void setImageX(int i) {
        this.h = i;
    }

    public void setImageY(int i) {
        this.g = i;
    }

    public void setOrientation(int i) {
        this.e = i;
        this.f = 0;
    }

    public void setRadius(int[] iArr) {
        if (iArr == null) {
            this.m = false;
            Arrays.fill(this.n, 0);
            return;
        }
        System.arraycopy(iArr, 0, this.n, 0, iArr.length);
        this.m = false;
        for (int i : iArr) {
            if (i != 0) {
                this.m = true;
                return;
            }
        }
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f + this.w);
    }

    public void setOrientation(int i, int i2) {
        this.e = i;
        this.f = i2;
    }
}
