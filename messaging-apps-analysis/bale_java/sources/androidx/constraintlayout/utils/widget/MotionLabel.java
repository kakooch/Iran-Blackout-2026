package androidx.constraintlayout.utils.widget;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.InterfaceC12572eq2;
import ir.nasim.OA1;
import ir.nasim.SE5;

/* loaded from: classes2.dex */
public class MotionLabel extends View implements InterfaceC12572eq2 {
    static String O0 = "MotionLabel";
    private float A;
    private Matrix A0;
    private float B;
    private float B0;
    private float C0;
    private float D;
    private float D0;
    private float E0;
    Paint F0;
    private Drawable G;
    private int G0;
    Matrix H;
    Rect H0;
    Paint I0;
    private Bitmap J;
    float J0;
    float K0;
    float L0;
    float M0;
    float N0;
    TextPaint a;
    Path b;
    private int c;
    private int d;
    private boolean e;
    private float f;
    private float g;
    ViewOutlineProvider h;
    RectF i;
    private float j;
    private float k;
    private int l;
    private int m;
    private float n;
    private String o;
    boolean p;
    private Rect q;
    private int r;
    private int s;
    private int t;
    private int u;
    private String v;
    private Layout w;
    private int x;
    private int y;
    private boolean z;
    private BitmapShader z0;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), (Math.min(r3, r4) * MotionLabel.this.f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.g);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.j = 48.0f;
        this.k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.x = 8388659;
        this.y = 0;
        this.z = false;
        this.B0 = Float.NaN;
        this.C0 = Float.NaN;
        this.D0 = 0.0f;
        this.E0 = 0.0f;
        this.F0 = new Paint();
        this.G0 = 0;
        this.K0 = Float.NaN;
        this.L0 = Float.NaN;
        this.M0 = Float.NaN;
        this.N0 = Float.NaN;
        g(context, null);
    }

    private void d(float f, float f2, float f3, float f4) {
        if (this.A0 == null) {
            return;
        }
        this.B = f3 - f;
        this.D = f4 - f2;
        l();
    }

    private void g(Context context, AttributeSet attributeSet) {
        i(context, attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.MotionLabel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.MotionLabel_android_text) {
                    setText(typedArrayObtainStyledAttributes.getText(index));
                } else if (index == SE5.MotionLabel_android_fontFamily) {
                    this.v = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == SE5.MotionLabel_scaleFromTextSize) {
                    this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.k);
                } else if (index == SE5.MotionLabel_android_textSize) {
                    this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.j);
                } else if (index == SE5.MotionLabel_android_textStyle) {
                    this.l = typedArrayObtainStyledAttributes.getInt(index, this.l);
                } else if (index == SE5.MotionLabel_android_typeface) {
                    this.m = typedArrayObtainStyledAttributes.getInt(index, this.m);
                } else if (index == SE5.MotionLabel_android_textColor) {
                    this.c = typedArrayObtainStyledAttributes.getColor(index, this.c);
                } else if (index == SE5.MotionLabel_borderRound) {
                    float dimension = typedArrayObtainStyledAttributes.getDimension(index, this.g);
                    this.g = dimension;
                    setRound(dimension);
                } else if (index == SE5.MotionLabel_borderRoundPercent) {
                    float f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    this.f = f;
                    setRoundPercent(f);
                } else if (index == SE5.MotionLabel_android_gravity) {
                    setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
                } else if (index == SE5.MotionLabel_android_autoSizeTextType) {
                    this.y = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == SE5.MotionLabel_textOutlineColor) {
                    this.d = typedArrayObtainStyledAttributes.getInt(index, this.d);
                    this.e = true;
                } else if (index == SE5.MotionLabel_textOutlineThickness) {
                    this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                    this.e = true;
                } else if (index == SE5.MotionLabel_textBackground) {
                    this.G = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.e = true;
                } else if (index == SE5.MotionLabel_textBackgroundPanX) {
                    this.K0 = typedArrayObtainStyledAttributes.getFloat(index, this.K0);
                } else if (index == SE5.MotionLabel_textBackgroundPanY) {
                    this.L0 = typedArrayObtainStyledAttributes.getFloat(index, this.L0);
                } else if (index == SE5.MotionLabel_textPanX) {
                    this.D0 = typedArrayObtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == SE5.MotionLabel_textPanY) {
                    this.E0 = typedArrayObtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == SE5.MotionLabel_textBackgroundRotate) {
                    this.N0 = typedArrayObtainStyledAttributes.getFloat(index, this.N0);
                } else if (index == SE5.MotionLabel_textBackgroundZoom) {
                    this.M0 = typedArrayObtainStyledAttributes.getFloat(index, this.M0);
                } else if (index == SE5.MotionLabel_textureHeight) {
                    this.B0 = typedArrayObtainStyledAttributes.getDimension(index, this.B0);
                } else if (index == SE5.MotionLabel_textureWidth) {
                    this.C0 = typedArrayObtainStyledAttributes.getDimension(index, this.C0);
                } else if (index == SE5.MotionLabel_textureEffect) {
                    this.G0 = typedArrayObtainStyledAttributes.getInt(index, this.G0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    private float getHorizontalOffset() {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        TextPaint textPaint = this.a;
        String str = this.o;
        return (((((Float.isNaN(this.B) ? getMeasuredWidth() : this.B) - getPaddingLeft()) - getPaddingRight()) - (f * textPaint.measureText(str, 0, str.length()))) * (this.D0 + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.D) ? getMeasuredHeight() : this.D) - getPaddingTop()) - getPaddingBottom();
        float f2 = fontMetrics.descent;
        float f3 = fontMetrics.ascent;
        return (((measuredHeight - ((f2 - f3) * f)) * (1.0f - this.E0)) / 2.0f) - (f * f3);
    }

    private void h(String str, int i, int i2) {
        Typeface typefaceCreate;
        if (str != null) {
            typefaceCreate = Typeface.create(str, i2);
            if (typefaceCreate != null) {
                setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (i == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (i == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        if (i2 <= 0) {
            this.a.setFakeBoldText(false);
            this.a.setTextSkewX(0.0f);
            setTypeface(typefaceCreate);
        } else {
            Typeface typefaceDefaultFromStyle = typefaceCreate == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typefaceCreate, i2);
            setTypeface(typefaceDefaultFromStyle);
            int i3 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i2;
            this.a.setFakeBoldText((i3 & 1) != 0);
            this.a.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    private void i(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC15790kA5.colorPrimary, typedValue, true);
        TextPaint textPaint = this.a;
        int i = typedValue.data;
        this.c = i;
        textPaint.setColor(i);
    }

    private void k() {
        if (this.G != null) {
            this.A0 = new Matrix();
            int intrinsicWidth = this.G.getIntrinsicWidth();
            int intrinsicHeight = this.G.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.C0) ? 128 : (int) this.C0;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.B0) ? 128 : (int) this.B0;
            }
            if (this.G0 != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.J = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.J);
            this.G.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.G.setFilterBitmap(true);
            this.G.draw(canvas);
            if (this.G0 != 0) {
                this.J = e(this.J, 4);
            }
            Bitmap bitmap = this.J;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.z0 = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void l() {
        float f = Float.isNaN(this.K0) ? 0.0f : this.K0;
        float f2 = Float.isNaN(this.L0) ? 0.0f : this.L0;
        float f3 = Float.isNaN(this.M0) ? 1.0f : this.M0;
        float f4 = Float.isNaN(this.N0) ? 0.0f : this.N0;
        this.A0.reset();
        float width = this.J.getWidth();
        float height = this.J.getHeight();
        float f5 = Float.isNaN(this.C0) ? this.B : this.C0;
        float f6 = Float.isNaN(this.B0) ? this.D : this.B0;
        float f7 = f3 * (width * f6 < height * f5 ? f5 / width : f6 / height);
        this.A0.postScale(f7, f7);
        float f8 = width * f7;
        float f9 = f5 - f8;
        float f10 = f7 * height;
        float f11 = f6 - f10;
        if (!Float.isNaN(this.B0)) {
            f11 = this.B0 / 2.0f;
        }
        if (!Float.isNaN(this.C0)) {
            f9 = this.C0 / 2.0f;
        }
        this.A0.postTranslate((((f * f9) + f5) - f8) * 0.5f, (((f2 * f11) + f6) - f10) * 0.5f);
        this.A0.postRotate(f4, f5 / 2.0f, f6 / 2.0f);
        this.z0.setLocalMatrix(this.A0);
    }

    @Override // ir.nasim.InterfaceC12572eq2
    public void a(float f, float f2, float f3, float f4) {
        int i = (int) (f + 0.5f);
        this.A = f - i;
        int i2 = (int) (f3 + 0.5f);
        int i3 = i2 - i;
        int i4 = (int) (f4 + 0.5f);
        int i5 = (int) (0.5f + f2);
        int i6 = i4 - i5;
        float f5 = f3 - f;
        this.B = f5;
        float f6 = f4 - f2;
        this.D = f6;
        d(f, f2, f3, f4);
        if (getMeasuredHeight() == i6 && getMeasuredWidth() == i3) {
            super.layout(i, i5, i2, i4);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            super.layout(i, i5, i2, i4);
        }
        if (this.z) {
            if (this.H0 == null) {
                this.I0 = new Paint();
                this.H0 = new Rect();
                this.I0.set(this.a);
                this.J0 = this.I0.getTextSize();
            }
            this.B = f5;
            this.D = f6;
            Paint paint = this.I0;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.H0);
            float fHeight = this.H0.height() * 1.3f;
            float f7 = (f5 - this.s) - this.r;
            float f8 = (f6 - this.u) - this.t;
            float fWidth = this.H0.width();
            if (fWidth * f8 > fHeight * f7) {
                this.a.setTextSize((this.J0 * f7) / fWidth);
            } else {
                this.a.setTextSize((this.J0 * f8) / fHeight);
            }
            if (this.e || !Float.isNaN(this.k)) {
                f(Float.isNaN(this.k) ? 1.0f : this.j / this.k);
            }
        }
    }

    Bitmap e(Bitmap bitmap, int i) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i2 = 0; i2 < i && width >= 32 && height >= 32; i2++) {
            width /= 2;
            height /= 2;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, width, height, true);
        }
        return bitmapCreateScaledBitmap;
    }

    void f(float f) {
        if (this.e || f != 1.0f) {
            this.b.reset();
            String str = this.o;
            int length = str.length();
            this.a.getTextBounds(str, 0, length, this.q);
            this.a.getTextPath(str, 0, length, 0.0f, 0.0f, this.b);
            if (f != 1.0f) {
                String str2 = O0;
                String strA = OA1.a();
                StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 22);
                sb.append(strA);
                sb.append(" scale ");
                sb.append(f);
                Log.v(str2, sb.toString());
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                this.b.transform(matrix);
            }
            Rect rect = this.q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.p = false;
        }
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getScaleFromTextSize() {
        return this.k;
    }

    public float getTextBackgroundPanX() {
        return this.K0;
    }

    public float getTextBackgroundPanY() {
        return this.L0;
    }

    public float getTextBackgroundRotate() {
        return this.N0;
    }

    public float getTextBackgroundZoom() {
        return this.M0;
    }

    public int getTextOutlineColor() {
        return this.d;
    }

    public float getTextPanX() {
        return this.D0;
    }

    public float getTextPanY() {
        return this.E0;
    }

    public float getTextureHeight() {
        return this.B0;
    }

    public float getTextureWidth() {
        return this.C0;
    }

    public Typeface getTypeface() {
        return this.a.getTypeface();
    }

    void j() {
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        h(this.v, this.m, this.l);
        this.a.setColor(this.c);
        this.a.setStrokeWidth(this.n);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setFlags(128);
        setTextSize(this.j);
        this.a.setAntiAlias(true);
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        boolean zIsNaN = Float.isNaN(this.k);
        float f = zIsNaN ? 1.0f : this.j / this.k;
        this.B = i3 - i;
        this.D = i4 - i2;
        if (this.z) {
            if (this.H0 == null) {
                this.I0 = new Paint();
                this.H0 = new Rect();
                this.I0.set(this.a);
                this.J0 = this.I0.getTextSize();
            }
            Paint paint = this.I0;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.H0);
            int iWidth = this.H0.width();
            int iHeight = (int) (this.H0.height() * 1.3f);
            float f2 = (this.B - this.s) - this.r;
            float f3 = (this.D - this.u) - this.t;
            if (zIsNaN) {
                float f4 = iWidth;
                float f5 = iHeight;
                if (f4 * f3 > f5 * f2) {
                    this.a.setTextSize((this.J0 * f2) / f4);
                } else {
                    this.a.setTextSize((this.J0 * f3) / f5);
                }
            } else {
                float f6 = iWidth;
                float f7 = iHeight;
                f = f6 * f3 > f7 * f2 ? f2 / f6 : f3 / f7;
            }
        }
        if (this.e || !zIsNaN) {
            d(i, i2, i3, i4);
            f(f);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        super.onDraw(canvas);
        if (!this.e && f == 1.0f) {
            canvas.drawText(this.o, this.A + this.r + getHorizontalOffset(), this.t + getVerticalOffset(), this.a);
            return;
        }
        if (this.p) {
            f(f);
        }
        if (this.H == null) {
            this.H = new Matrix();
        }
        if (!this.e) {
            float horizontalOffset = this.r + getHorizontalOffset();
            float verticalOffset = this.t + getVerticalOffset();
            this.H.reset();
            this.H.preTranslate(horizontalOffset, verticalOffset);
            this.b.transform(this.H);
            this.a.setColor(this.c);
            this.a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.a.setStrokeWidth(this.n);
            canvas.drawPath(this.b, this.a);
            this.H.reset();
            this.H.preTranslate(-horizontalOffset, -verticalOffset);
            this.b.transform(this.H);
            return;
        }
        this.F0.set(this.a);
        this.H.reset();
        float horizontalOffset2 = this.r + getHorizontalOffset();
        float verticalOffset2 = this.t + getVerticalOffset();
        this.H.postTranslate(horizontalOffset2, verticalOffset2);
        this.H.preScale(f, f);
        this.b.transform(this.H);
        if (this.z0 != null) {
            this.a.setFilterBitmap(true);
            this.a.setShader(this.z0);
        } else {
            this.a.setColor(this.c);
        }
        this.a.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(this.n);
        canvas.drawPath(this.b, this.a);
        if (this.z0 != null) {
            this.a.setShader(null);
        }
        this.a.setColor(this.d);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.n);
        canvas.drawPath(this.b, this.a);
        this.H.reset();
        this.H.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.b.transform(this.H);
        this.a.set(this.F0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.z = false;
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.a;
            String str = this.o;
            textPaint.getTextBounds(str, 0, str.length(), this.q);
            if (mode != 1073741824) {
                size = (int) (this.q.width() + 0.99999f);
            }
            size += this.r + this.s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.t + this.u + fontMetricsInt;
            }
        } else if (this.y != 0) {
            this.z = true;
        }
        setMeasuredDimension(size, size2);
    }

    public void setGravity(int i) {
        if ((i & 8388615) == 0) {
            i |= 8388611;
        }
        if ((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
            i |= 48;
        }
        if (i != this.x) {
            invalidate();
        }
        this.x = i;
        int i2 = i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        if (i2 == 48) {
            this.E0 = -1.0f;
        } else if (i2 != 80) {
            this.E0 = 0.0f;
        } else {
            this.E0 = 1.0f;
        }
        int i3 = i & 8388615;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 8388611) {
                    if (i3 != 8388613) {
                        this.D0 = 0.0f;
                        return;
                    }
                }
            }
            this.D0 = 1.0f;
            return;
        }
        this.D0 = -1.0f;
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.g = f;
            float f2 = this.f;
            this.f = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.g != f;
        this.g = f;
        if (f != 0.0f) {
            if (this.b == null) {
                this.b = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                b bVar = new b();
                this.h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.b.reset();
            Path path = this.b;
            RectF rectF = this.i;
            float f3 = this.g;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.f != f;
        this.f = f;
        if (f != 0.0f) {
            if (this.b == null) {
                this.b = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                a aVar = new a();
                this.h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f) / 2.0f;
            this.i.set(0.0f, 0.0f, width, height);
            this.b.reset();
            this.b.addRoundRect(this.i, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f) {
        this.k = f;
    }

    public void setText(CharSequence charSequence) {
        this.o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f) {
        this.K0 = f;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float f) {
        this.L0 = f;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float f) {
        this.N0 = f;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float f) {
        this.M0 = f;
        l();
        invalidate();
    }

    public void setTextFillColor(int i) {
        this.c = i;
        invalidate();
    }

    public void setTextOutlineColor(int i) {
        this.d = i;
        this.e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f) {
        this.n = f;
        this.e = true;
        if (Float.isNaN(f)) {
            this.n = 1.0f;
            this.e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f) {
        this.D0 = f;
        invalidate();
    }

    public void setTextPanY(float f) {
        this.E0 = f;
        invalidate();
    }

    public void setTextSize(float f) {
        this.j = f;
        String str = O0;
        String strA = OA1.a();
        float f2 = this.k;
        StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 35);
        sb.append(strA);
        sb.append("  ");
        sb.append(f);
        sb.append(" / ");
        sb.append(f2);
        Log.v(str, sb.toString());
        TextPaint textPaint = this.a;
        if (!Float.isNaN(this.k)) {
            f = this.k;
        }
        textPaint.setTextSize(f);
        f(Float.isNaN(this.k) ? 1.0f : this.j / this.k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f) {
        this.B0 = f;
        l();
        invalidate();
    }

    public void setTextureWidth(float f) {
        this.C0 = f;
        l();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.a.getTypeface() != typeface) {
            this.a.setTypeface(typeface);
            if (this.w != null) {
                this.w = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.j = 48.0f;
        this.k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.x = 8388659;
        this.y = 0;
        this.z = false;
        this.B0 = Float.NaN;
        this.C0 = Float.NaN;
        this.D0 = 0.0f;
        this.E0 = 0.0f;
        this.F0 = new Paint();
        this.G0 = 0;
        this.K0 = Float.NaN;
        this.L0 = Float.NaN;
        this.M0 = Float.NaN;
        this.N0 = Float.NaN;
        g(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.j = 48.0f;
        this.k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.x = 8388659;
        this.y = 0;
        this.z = false;
        this.B0 = Float.NaN;
        this.C0 = Float.NaN;
        this.D0 = 0.0f;
        this.E0 = 0.0f;
        this.F0 = new Paint();
        this.G0 = 0;
        this.K0 = Float.NaN;
        this.L0 = Float.NaN;
        this.M0 = Float.NaN;
        this.N0 = Float.NaN;
        g(context, attributeSet);
    }
}
