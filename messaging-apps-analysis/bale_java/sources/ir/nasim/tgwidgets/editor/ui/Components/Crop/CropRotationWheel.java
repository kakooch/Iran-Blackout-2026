package ir.nasim.tgwidgets.editor.ui.Components.Crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;

/* loaded from: classes7.dex */
public class CropRotationWheel extends FrameLayout {
    private Paint a;
    private Paint b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private String f;
    private TextPaint g;
    protected float h;
    private RectF i;
    private float j;
    private a k;

    public interface a {
        void a(float f);

        boolean d();

        void e(float f);

        void f();

        boolean g();

        void h();
    }

    public CropRotationWheel(Context context) {
        super(context);
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.a = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.a.setColor(-1);
        this.a.setAlpha(255);
        this.a.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(style);
        this.b.setColor(-11420173);
        this.b.setAlpha(255);
        this.b.setAntiAlias(true);
        ImageView imageView = new ImageView(context);
        this.e = imageView;
        imageView.setImageResource(AbstractC23598xB5.msg_photo_flip);
        this.e.setBackgroundDrawable(m.Y(1090519039));
        ImageView imageView2 = this.e;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView2.setScaleType(scaleType);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.wu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f(view);
            }
        });
        this.e.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.xu1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.a.g(view);
            }
        });
        this.e.setContentDescription(FH3.E("AccDescrMirror", TD5.tgwidget_AccDescrMirror));
        addView(this.e, AbstractC13840gu3.d(70, 64, 19));
        ImageView imageView3 = new ImageView(context);
        this.c = imageView3;
        imageView3.setImageResource(AbstractC23598xB5.msg_photo_cropfix);
        this.c.setBackgroundDrawable(m.Y(1090519039));
        this.c.setScaleType(scaleType);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h(view);
            }
        });
        this.c.setVisibility(8);
        this.c.setContentDescription(FH3.E("AccDescrAspectRatio", TD5.tgwidget_AccDescrAspectRatio));
        addView(this.c, AbstractC13840gu3.d(70, 64, 19));
        ImageView imageView4 = new ImageView(context);
        this.d = imageView4;
        imageView4.setImageResource(AbstractC23598xB5.msg_photo_rotate);
        this.d.setBackgroundDrawable(m.Y(1090519039));
        this.d.setScaleType(scaleType);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.i(view);
            }
        });
        this.d.setContentDescription(FH3.E("AccDescrRotate", TD5.tgwidget_AccDescrRotate));
        addView(this.d, AbstractC13840gu3.d(70, 64, 21));
        TextPaint textPaint = new TextPaint(1);
        this.g = textPaint;
        textPaint.setColor(-1);
        this.g.setTextSize(AbstractC21455b.F(14.0f));
        setWillNotDraw(false);
        setRotation(0.0f, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        a aVar = this.k;
        if (aVar != null) {
            setMirrored(aVar.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean g(View view) {
        this.c.callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        a aVar = this.k;
        if (aVar != null) {
            setRotated(aVar.g());
        }
    }

    protected void e(Canvas canvas, int i, float f, int i2, int i3, boolean z, Paint paint) {
        int iF = (int) ((i2 / 2.0f) - AbstractC21455b.F(70.0f));
        int iCos = (i2 / 2) + ((int) (iF * Math.cos(Math.toRadians(90.0f - ((i * 5) + f)))));
        float fAbs = Math.abs(r8) / iF;
        int iMin = Math.min(255, Math.max(0, (int) ((1.0f - (fAbs * fAbs)) * 255.0f)));
        if (z) {
            paint = this.b;
        }
        Paint paint2 = paint;
        paint2.setAlpha(iMin);
        int i4 = z ? 4 : 2;
        int iF2 = AbstractC21455b.F(z ? 16.0f : 12.0f);
        int i5 = i4 / 2;
        canvas.drawRect(iCos - i5, (i3 - iF2) / 2, iCos + i5, (i3 + iF2) / 2, paint2);
    }

    @Override // android.view.View
    public float getRotation() {
        return this.h;
    }

    public void j(boolean z) {
        setRotation(0.0f, false);
        if (z) {
            setMirrored(false);
        }
        setRotated(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        float f = ((-this.h) * 2.0f) % 5.0f;
        int iFloor = (int) Math.floor(r0 / 5.0f);
        int i = 0;
        while (i < 16) {
            Paint paint = this.a;
            if (i < iFloor || (i == 0 && f < 0.0f)) {
                paint = this.b;
            }
            int i2 = i;
            e(canvas, i, f, width, height, i == iFloor || (i == 0 && iFloor == -1), paint);
            if (i2 != 0) {
                int i3 = -i2;
                e(canvas, i3, f, width, height, i3 == iFloor + 1, i3 > iFloor ? this.b : this.a);
            }
            i = i2 + 1;
        }
        this.b.setAlpha(255);
        this.i.left = (width - AbstractC21455b.F(2.5f)) / 2;
        this.i.top = (height - AbstractC21455b.F(22.0f)) / 2;
        this.i.right = (AbstractC21455b.F(2.5f) + width) / 2;
        this.i.bottom = (height + AbstractC21455b.F(22.0f)) / 2;
        canvas.drawRoundRect(this.i, AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), this.b);
        canvas.drawText(this.f, (width - this.g.measureText(this.f)) / 2.0f, AbstractC21455b.F(14.0f), this.g);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), AbstractC21455b.F(400.0f)), 1073741824), i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        if (actionMasked == 0) {
            this.j = x;
            a aVar = this.k;
            if (aVar != null) {
                aVar.f();
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.e(this.h);
            }
            AbstractC21455b.Z0(String.format("%.1f°", Float.valueOf(this.h)));
        } else if (actionMasked == 2) {
            float fMax = Math.max(-45.0f, Math.min(45.0f, this.h + ((float) ((((this.j - x) / AbstractC21455b.g) / 3.141592653589793d) / 1.649999976158142d))));
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    if ((Math.abs(fMax - 45.0f) < 0.001f && Math.abs(this.h - 45.0f) >= 0.001f) || (Math.abs(fMax - (-45.0f)) < 0.001f && Math.abs(this.h - (-45.0f)) >= 0.001f)) {
                        performHapticFeedback(3, 1);
                    } else if (Math.floor(this.h / 2.5f) != Math.floor(fMax / 2.5f)) {
                        performHapticFeedback(9, 1);
                    }
                } catch (Exception unused) {
                }
            }
            if (Math.abs(fMax - this.h) > 0.001d) {
                if (Math.abs(fMax) < 0.05d) {
                    fMax = 0.0f;
                }
                setRotation(fMax, false);
                a aVar3 = this.k;
                if (aVar3 != null) {
                    aVar3.a(this.h);
                }
                this.j = x;
            }
        }
        return true;
    }

    public void setAspectLock(boolean z) {
        this.c.setColorFilter(z ? new PorterDuffColorFilter(-11420173, PorterDuff.Mode.MULTIPLY) : null);
    }

    public void setFreeform(boolean z) {
    }

    public void setListener(a aVar) {
        this.k = aVar;
    }

    public void setMirrored(boolean z) {
        this.e.setColorFilter(z ? new PorterDuffColorFilter(m.i0(m.F4), PorterDuff.Mode.MULTIPLY) : null);
    }

    public void setRotated(boolean z) {
        this.d.setColorFilter(z ? new PorterDuffColorFilter(m.i0(m.F4), PorterDuff.Mode.MULTIPLY) : null);
    }

    public void setRotation(float f, boolean z) {
        this.h = f;
        if (Math.abs(f) < 0.099d) {
            f = Math.abs(f);
        }
        this.f = String.format("%.1fº", Float.valueOf(f));
        invalidate();
    }
}
