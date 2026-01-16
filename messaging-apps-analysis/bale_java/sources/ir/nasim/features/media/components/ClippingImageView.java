package ir.nasim.features.media.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/* loaded from: classes6.dex */
public class ClippingImageView extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private RectF f;
    private Paint g;
    private Bitmap h;
    private Matrix i;
    private boolean j;
    private int k;
    private BitmapShader l;
    private Paint m;
    private RectF n;
    private RectF o;
    private Matrix p;
    private float q;
    private float[][] r;

    public ClippingImageView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.g = paint;
        paint.setFilterBitmap(true);
        this.i = new Matrix();
        this.f = new RectF();
        this.o = new RectF();
        this.m = new Paint(1);
        this.n = new RectF();
        this.p = new Matrix();
    }

    public int getRadius() {
        return this.k;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        int width;
        if (getVisibility() == 0 && this.h != null) {
            float scaleY = getScaleY();
            canvas.save();
            if (this.j) {
                this.p.reset();
                this.n.set(0.0f, 0.0f, getWidth(), getHeight());
                int i = this.e;
                if (i % 360 == 90 || i % 360 == 270) {
                    height = this.h.getHeight();
                    width = this.h.getWidth();
                } else {
                    height = this.h.getWidth();
                    width = this.h.getHeight();
                }
                float width2 = getWidth() != 0 ? height / getWidth() : 1.0f;
                float height2 = getHeight() != 0 ? width / getHeight() : 1.0f;
                float fMin = Math.min(width2, height2);
                if (Math.abs(width2 - height2) > 1.0E-5f) {
                    this.o.set((height - r3) / 2, (width - r4) / 2, (int) Math.floor(getWidth() * fMin), (int) Math.floor(getHeight() * fMin));
                    this.p.setRectToRect(this.o, this.n, Matrix.ScaleToFit.START);
                } else {
                    this.o.set(0.0f, 0.0f, this.h.getWidth(), this.h.getHeight());
                    this.p.setRectToRect(this.o, this.n, Matrix.ScaleToFit.FILL);
                }
                this.l.setLocalMatrix(this.p);
                canvas.clipRect(this.b / scaleY, this.d / scaleY, getWidth() - (this.c / scaleY), getHeight() - (this.a / scaleY));
                RectF rectF = this.n;
                int i2 = this.k;
                canvas.drawRoundRect(rectF, i2, i2, this.m);
            } else {
                int i3 = this.e;
                if (i3 == 90 || i3 == 270) {
                    this.f.set((-getHeight()) / 2, (-getWidth()) / 2, getHeight() / 2, getWidth() / 2);
                    this.i.setRectToRect(this.o, this.f, Matrix.ScaleToFit.FILL);
                    this.i.postRotate(this.e, 0.0f, 0.0f);
                    this.i.postTranslate(getWidth() / 2, getHeight() / 2);
                } else if (i3 == 180) {
                    this.f.set((-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
                    this.i.setRectToRect(this.o, this.f, Matrix.ScaleToFit.FILL);
                    this.i.postRotate(this.e, 0.0f, 0.0f);
                    this.i.postTranslate(getWidth() / 2, getHeight() / 2);
                } else {
                    this.f.set(0.0f, 0.0f, getWidth(), getHeight());
                    this.i.setRectToRect(this.o, this.f, Matrix.ScaleToFit.FILL);
                }
                canvas.clipRect(this.b / scaleY, this.d / scaleY, getWidth() - (this.c / scaleY), getHeight() - (this.a / scaleY));
                try {
                    canvas.drawBitmap(this.h, this.i, this.g);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            canvas.restore();
        }
    }

    public void setAnimationProgress(float f) {
        this.q = f;
        float[][] fArr = this.r;
        float f2 = fArr[0][0];
        setScaleX(f2 + ((fArr[1][0] - f2) * f));
        float[][] fArr2 = this.r;
        float f3 = fArr2[0][1];
        setScaleY(f3 + ((fArr2[1][1] - f3) * this.q));
        float[][] fArr3 = this.r;
        float f4 = fArr3[0][2];
        setTranslationX(f4 + ((fArr3[1][2] - f4) * this.q));
        float[][] fArr4 = this.r;
        float f5 = fArr4[0][3];
        setTranslationY(f5 + ((fArr4[1][3] - f5) * this.q));
        float[][] fArr5 = this.r;
        float f6 = fArr5[0][4];
        setClipHorizontal((int) (f6 + ((fArr5[1][4] - f6) * this.q)));
        float[][] fArr6 = this.r;
        float f7 = fArr6[0][5];
        setClipTop((int) (f7 + ((fArr6[1][5] - f7) * this.q)));
        float[][] fArr7 = this.r;
        float f8 = fArr7[0][6];
        setClipBottom((int) (f8 + ((fArr7[1][6] - f8) * this.q)));
        float[][] fArr8 = this.r;
        float f9 = fArr8[0][7];
        setRadius((int) (f9 + ((fArr8[1][7] - f9) * this.q)));
        invalidate();
    }

    public void setAnimationValues(float[][] fArr) {
        this.r = fArr;
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

    public void setClipTop(int i) {
        this.d = i;
        invalidate();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.h = bitmap;
        if (bitmap != null) {
            this.o.set(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            if (this.j) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                this.l = bitmapShader;
                this.m.setShader(bitmapShader);
            }
        }
        invalidate();
    }

    public void setNeedRadius(boolean z) {
        this.j = z;
    }

    public void setOrientation(int i) {
        this.e = i;
    }

    public void setRadius(int i) {
        this.k = i;
    }
}
