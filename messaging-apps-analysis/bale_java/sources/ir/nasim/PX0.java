package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.LongSparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.nasim.PX0;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintColorsListView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PipettePickerView;
import ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class PX0 extends BottomSheet {
    private d r1;
    private ImageView s1;
    private ImageView t1;
    private c u1;
    private Path v1;
    private int w1;
    private InterfaceC25043ze1 x1;
    private h y1;
    private boolean z1;

    class a extends PipettePickerView {
        a(Context context, Bitmap bitmap) {
            super(context, bitmap);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PipettePickerView
        protected void i() {
            PX0.this.y1.a();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PipettePickerView
        protected void j() {
            PX0.this.y1.c();
        }
    }

    class b extends ScrollView {
        final /* synthetic */ LinearLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, LinearLayout linearLayout) {
            super(context);
            this.a = linearLayout;
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float y = this.a.getY() + AbstractC21455b.F(1.0f);
            int iF = AbstractC21455b.F(36.0f);
            RectF rectF = AbstractC21455b.x;
            rectF.set((getMeasuredWidth() - iF) / 2.0f, y, (getMeasuredWidth() + iF) / 2.0f, AbstractC21455b.F(4.0f) + y);
            canvas.drawRoundRect(rectF, AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), new Paint());
        }

        @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            ((LinearLayout.LayoutParams) PX0.this.r1.getLayoutParams()).height = (int) (((View.MeasureSpec.getSize(i) - AbstractC21455b.F(24.0f)) * 0.8333333f) + AbstractC21455b.F(88.0f));
        }
    }

    private final class c extends View {
        private Paint a;
        private Paint b;
        private float c;

        public c(Context context) {
            super(context);
            this.a = new Paint(1);
            Paint paint = new Paint(1);
            this.b = paint;
            paint.setColor(-1);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.b.setStrokeWidth(AbstractC21455b.F(3.0f));
        }

        private void a() {
            this.a.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, new int[]{0, PX0.this.w1}, (float[]) null, Shader.TileMode.CLAMP));
        }

        private void c(float f) {
            float F = AbstractC21455b.F(6.0f);
            this.c = AbstractC22000uV3.a(((f - F) + (AbstractC21455b.F(13.0f) - (this.b.getStrokeWidth() / 2.0f))) / (getWidth() - (F * 2.0f)), 0.0f, 1.0f);
            PX0 px0 = PX0.this;
            px0.S0(QY0.k(px0.w1, (int) (this.c * 255.0f)), 1);
            invalidate();
        }

        public void b(int i) {
            this.c = Color.alpha(i) / 255.0f;
            a();
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float height = getHeight() / 2.0f;
            float F = AbstractC21455b.F(6.0f);
            RectF rectF = AbstractC21455b.x;
            float f = height - F;
            float f2 = height + F;
            rectF.set(F, f, getWidth() - F, f2);
            canvas.save();
            PX0.this.v1.rewind();
            PX0.this.v1.addRoundRect(rectF, AbstractC21455b.F(16.0f), AbstractC21455b.F(16.0f), Path.Direction.CW);
            canvas.clipPath(PX0.this.v1);
            PaintColorsListView.b2(canvas, rectF, AbstractC21455b.F(6.0f));
            canvas.restore();
            rectF.set(F, f, getWidth() - F, f2);
            canvas.drawRoundRect(rectF, AbstractC21455b.F(16.0f), AbstractC21455b.F(16.0f), this.a);
            float F2 = AbstractC21455b.F(13.0f);
            float strokeWidth = F2 - (this.b.getStrokeWidth() / 2.0f);
            float fMax = Math.max(F + strokeWidth, (F + ((getWidth() - (2.0f * F)) * this.c)) - strokeWidth);
            canvas.drawCircle(fMax, height, F2, this.b);
            PaintColorsListView.c2(canvas, fMax, height, strokeWidth, QY0.k(PX0.this.w1, (int) (this.c * 255.0f)));
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            a();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    c(motionEvent.getX());
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return true;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            c(motionEvent.getX());
            return true;
        }
    }

    private final class e extends View {
        private Paint a;
        private Paint b;
        private int c;
        private int d;

        public e(Context context) {
            super(context);
            this.a = new Paint(1);
            Paint paint = new Paint(1);
            this.b = paint;
            paint.setColor(-1);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.b.setStrokeWidth(AbstractC21455b.F(3.0f));
        }

        private void b() {
            int iArgb;
            int iArgb2;
            int i = this.c;
            if (i == 1) {
                iArgb = Color.argb(255, Color.red(PX0.this.w1), 0, Color.blue(PX0.this.w1));
                iArgb2 = Color.argb(255, Color.red(PX0.this.w1), 255, Color.blue(PX0.this.w1));
            } else if (i != 2) {
                iArgb = Color.argb(255, 0, Color.green(PX0.this.w1), Color.blue(PX0.this.w1));
                iArgb2 = Color.argb(255, 255, Color.green(PX0.this.w1), Color.blue(PX0.this.w1));
            } else {
                iArgb = Color.argb(255, Color.red(PX0.this.w1), Color.green(PX0.this.w1), 0);
                iArgb2 = Color.argb(255, Color.red(PX0.this.w1), Color.green(PX0.this.w1), 255);
            }
            this.a.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, new int[]{iArgb, iArgb2}, (float[]) null, Shader.TileMode.CLAMP));
        }

        private void d(float f) {
            float F = AbstractC21455b.F(6.0f);
            float fA = AbstractC22000uV3.a(((f - F) + (AbstractC21455b.F(13.0f) - (this.b.getStrokeWidth() / 2.0f))) / (getWidth() - (F * 2.0f)), 0.0f, 1.0f);
            int i = this.c;
            int iArgb = i != 1 ? i != 2 ? Color.argb(255, (int) (fA * 255.0f), Color.green(PX0.this.w1), Color.blue(PX0.this.w1)) : Color.argb(255, Color.red(PX0.this.w1), Color.green(PX0.this.w1), (int) (fA * 255.0f)) : Color.argb(255, Color.red(PX0.this.w1), (int) (fA * 255.0f), Color.blue(PX0.this.w1));
            PX0 px0 = PX0.this;
            px0.S0(QY0.k(iArgb, Color.alpha(px0.w1)), 4);
            invalidate();
        }

        public void a() {
            this.d = QY0.k(PX0.this.w1, 255);
            b();
            invalidate();
        }

        public void c(int i) {
            this.c = i;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float height = getHeight() / 2.0f;
            float F = AbstractC21455b.F(6.0f);
            RectF rectF = AbstractC21455b.x;
            rectF.set(F, height - F, getWidth() - F, height + F);
            canvas.drawRoundRect(rectF, AbstractC21455b.F(16.0f), AbstractC21455b.F(16.0f), this.a);
            int i = this.c;
            float fRed = (i != 1 ? i != 2 ? Color.red(PX0.this.w1) : Color.blue(PX0.this.w1) : Color.green(PX0.this.w1)) / 255.0f;
            float F2 = AbstractC21455b.F(13.0f);
            float strokeWidth = F2 - (this.b.getStrokeWidth() / 2.0f);
            float fMax = Math.max(F + strokeWidth, (F + ((getWidth() - (2.0f * F)) * fRed)) - strokeWidth);
            canvas.drawCircle(fMax, height, F2, this.b);
            PaintColorsListView.c2(canvas, fMax, height, strokeWidth, this.d);
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            b();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    d(motionEvent.getX());
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return true;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            d(motionEvent.getX());
            return true;
        }
    }

    private final class f extends View {
        private Paint a;
        private Paint b;
        private Paint c;
        private float d;
        private float e;
        private Drawable f;
        private float[] g;

        public f(Context context) {
            super(context);
            this.a = new Paint(1);
            this.b = new Paint(1);
            this.c = new Paint(1);
            this.g = new float[3];
            setPadding(AbstractC21455b.F(14.0f), AbstractC21455b.F(3.0f), AbstractC21455b.F(14.0f), AbstractC21455b.F(3.0f));
            this.c.setColor(-1);
            this.c.setStyle(Paint.Style.FILL_AND_STROKE);
            this.c.setStrokeWidth(AbstractC21455b.F(3.0f));
            this.f = AbstractC4043Dl1.f(context, AbstractC23598xB5.knob_shadow);
        }

        private void b(MotionEvent motionEvent) {
            this.d = (motionEvent.getX() - getPaddingLeft()) / ((getWidth() - getPaddingLeft()) - getPaddingRight());
            float y = (motionEvent.getY() - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
            this.e = y;
            float[] fArr = this.g;
            fArr[0] = y * 360.0f;
            float f = this.d;
            if (f <= 0.22f || f >= 0.78f) {
                fArr[1] = AbstractC21455b.T0(1.0f, 0.0f, f <= 0.22f ? 1.0f - (f / 0.22f) : (f - 0.78f) / 0.22000003f);
                float[] fArr2 = this.g;
                float f2 = this.d;
                fArr2[2] = f2 > 0.22f ? AbstractC21455b.T0(1.0f, 0.0f, (f2 - 0.78f) / 0.22000003f) : 1.0f;
            } else {
                fArr[1] = 1.0f;
                fArr[2] = 1.0f;
            }
            PX0.this.w1 = Color.HSVToColor(this.g);
            PX0 px0 = PX0.this;
            px0.S0(px0.w1, 0);
            invalidate();
        }

        public void a(int i, boolean z) {
            PX0.this.w1 = i;
            Color.colorToHSV(i, this.g);
            if (z) {
                float[] fArr = this.g;
                float f = (fArr[1] * 0.5f) + 1.0f;
                float f2 = fArr[2];
                this.d = f - (1.0f - (f2 <= 0.5f ? ((1.0f - f2) * 0.22000003f) + 0.78f : (1.0f - f2) * 0.22f));
                this.e = fArr[0] / 360.0f;
            }
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            RectF rectF = AbstractC21455b.x;
            rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            canvas.drawRoundRect(rectF, AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), this.a);
            canvas.drawRoundRect(rectF, AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), this.b);
            float F = AbstractC21455b.F(13.0f);
            float strokeWidth = F - (this.c.getStrokeWidth() / 2.0f);
            float F2 = AbstractC21455b.F(16.0f);
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            float f = width;
            float paddingLeft = getPaddingLeft() + AbstractC22000uV3.a(this.d * f, F2, f - F2);
            float f2 = height;
            float paddingTop = getPaddingTop() + AbstractC22000uV3.a(this.e * f2, F2, f2 - F2);
            Drawable drawable = this.f;
            Rect rect = AbstractC21455b.y;
            drawable.getPadding(rect);
            Drawable drawable2 = this.f;
            int i = (int) ((paddingLeft - F) - rect.left);
            int i2 = (int) ((paddingTop - F) - rect.top);
            int i3 = rect.bottom;
            drawable2.setBounds(i, i2, (int) (paddingLeft + F + i3), (int) (paddingTop + F + i3));
            this.f.draw(canvas);
            canvas.drawCircle(paddingLeft, paddingTop, F, this.c);
            PaintColorsListView.c2(canvas, paddingLeft, paddingTop, strokeWidth, QY0.k(PX0.this.w1, 255));
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.a.setShader(new LinearGradient(0.0f, getPaddingTop(), 0.0f, i2 - getPaddingBottom(), new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -65536}, (float[]) null, Shader.TileMode.CLAMP));
            this.b.setShader(new LinearGradient(getPaddingLeft(), 0.0f, i - getPaddingRight(), 0.0f, new int[]{-1, 0, 0, -16777216}, new float[]{0.06f, 0.22f, 0.78f, 0.94f}, Shader.TileMode.MIRROR));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
                b(motionEvent);
            } else if (actionMasked == 1) {
                getParent().requestDisallowInterceptTouchEvent(false);
                b(motionEvent);
            } else if (actionMasked == 2) {
                b(motionEvent);
            } else if (actionMasked == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            return true;
        }
    }

    private final class g extends View {
        private Paint a;
        private final int[] b;
        private Paint c;
        private LongSparseArray d;
        private long e;
        private Path f;
        private float[] g;
        private Map h;

        public g(Context context) {
            super(context);
            this.a = new Paint(1);
            this.b = new int[]{-16735784, -16752387, -11788361, -6804548, -4707235, -180718, -38656, -152832, -211200, -198077, -2495689, -8996289};
            this.c = new Paint(1);
            this.d = new LongSparseArray();
            this.e = Long.MIN_VALUE;
            this.f = new Path();
            this.g = new float[8];
            this.h = new HashMap();
            setPadding(AbstractC21455b.F(14.0f), AbstractC21455b.F(3.0f), AbstractC21455b.F(14.0f), AbstractC21455b.F(3.0f));
            this.c.setColor(-1);
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeCap(Paint.Cap.ROUND);
            this.c.setStrokeJoin(Paint.Join.ROUND);
            for (int i = 0; i < 12; i++) {
                int i2 = 0;
                while (i2 < 10) {
                    if (i2 == 0) {
                        this.h.put(Long.valueOf((i << 16) + i2), Integer.valueOf(QY0.c(-1, -16777216, i / 11.0f)));
                    } else {
                        this.h.put(Long.valueOf((i << 16) + i2), Integer.valueOf(i2 < 6 ? QY0.c(this.b[i], -16777216, ((5 - i2) / 4.0f) * 0.5f) : QY0.c(this.b[i], -1, 0.5f - (((9 - i2) / 5.0f) * 0.5f))));
                    }
                    i2++;
                }
            }
        }

        private void c(MotionEvent motionEvent) {
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / 12;
            int height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 10;
            int x = (int) ((motionEvent.getX() - getPaddingLeft()) / width);
            int y = (int) (motionEvent.getY() / height);
            Integer num = (Integer) this.h.get(Long.valueOf((x << 16) + y));
            if (num != null) {
                PX0.this.S0(num.intValue(), 3);
                b(x, y);
            }
        }

        public void a(int i) {
            for (Map.Entry entry : this.h.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == i) {
                    long jLongValue = ((Long) entry.getKey()).longValue();
                    b((int) (jLongValue >> 16), (int) (jLongValue - (r5 << 16)));
                    return;
                }
            }
            this.e = Long.MIN_VALUE;
            invalidate();
        }

        public void b(int i, int i2) {
            long j = (i << 16) + i2;
            this.e = j;
            if (this.d.get(j) == null) {
                this.d.put(this.e, Float.valueOf(0.0f));
            }
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            char c;
            float F;
            super.onDraw(canvas);
            RectF rectF = AbstractC21455b.x;
            rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            canvas.save();
            PX0.this.v1.rewind();
            PX0.this.v1.addRoundRect(rectF, AbstractC21455b.F(10.0f), AbstractC21455b.F(10.0f), Path.Direction.CW);
            canvas.clipPath(PX0.this.v1);
            float width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / 12.0f;
            float height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 10.0f;
            for (int i = 0; i < 12; i++) {
                for (int i2 = 0; i2 < 10; i2++) {
                    Integer num = (Integer) this.h.get(Long.valueOf((i << 16) + i2));
                    if (num != null) {
                        this.a.setColor(num.intValue());
                        RectF rectF2 = AbstractC21455b.x;
                        rectF2.set(getPaddingLeft() + (i * width), getPaddingTop() + (i2 * height), getPaddingLeft() + ((i + 1) * width), getPaddingTop() + ((i2 + 1) * height));
                        canvas.drawRect(rectF2, this.a);
                    }
                }
            }
            canvas.restore();
            int i3 = 0;
            while (i3 < this.d.size()) {
                long jKeyAt = this.d.keyAt(i3);
                float fFloatValue = ((Float) this.d.valueAt(i3)).floatValue();
                float fMin = this.e == jKeyAt ? Math.min(1.0f, fFloatValue + 0.045714285f) : Math.max(0.0f, fFloatValue - 0.10666667f);
                int i4 = (int) (jKeyAt >> 16);
                int i5 = (int) (jKeyAt - (i4 << 16));
                Integer num2 = (Integer) this.h.get(Long.valueOf(jKeyAt));
                if (num2 != null) {
                    this.c.setColor(AbstractC21455b.z(num2.intValue()) > 0.721f ? -15658735 : -1);
                }
                this.c.setStrokeWidth(InterpolatorC12631ew1.h.getInterpolation(fMin) * AbstractC21455b.F(3.0f));
                this.f.rewind();
                RectF rectF3 = AbstractC21455b.x;
                rectF3.set(getPaddingLeft() + (i4 * width), getPaddingTop() + (i5 * height), getPaddingLeft() + ((i4 + 1) * width), getPaddingTop() + ((i5 + 1) * height));
                float[] fArr = this.g;
                float F2 = (i4 == 0 && i5 == 0) ? AbstractC21455b.F(10.0f) : 0.0f;
                fArr[1] = F2;
                fArr[0] = F2;
                float[] fArr2 = this.g;
                float F3 = (i4 == 11 && i5 == 0) ? AbstractC21455b.F(10.0f) : 0.0f;
                fArr2[3] = F3;
                fArr2[2] = F3;
                float[] fArr3 = this.g;
                float F4 = (i4 == 11 && i5 == 9) ? AbstractC21455b.F(10.0f) : 0.0f;
                fArr3[5] = F4;
                fArr3[4] = F4;
                float[] fArr4 = this.g;
                if (i4 == 0 && i5 == 9) {
                    c = 0;
                    F = AbstractC21455b.F(10.0f);
                } else {
                    c = 0;
                    F = 0.0f;
                }
                fArr4[7] = F;
                fArr4[6] = F;
                this.f.addRoundRect(rectF3, this.g, Path.Direction.CW);
                canvas.drawPath(this.f, this.c);
                if (fMin > 0.0f || this.e == jKeyAt) {
                    if (fMin < 1.0f) {
                        invalidate();
                    }
                    this.d.setValueAt(i3, Float.valueOf(fMin));
                } else {
                    this.d.removeAt(i3);
                    i3--;
                    invalidate();
                }
                i3++;
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    c(motionEvent);
                } else if (actionMasked == 2) {
                    c(motionEvent);
                } else if (actionMasked == 3) {
                }
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                c(motionEvent);
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
    }

    public interface h {
        void a();

        boolean b();

        void c();

        void d(int i);

        void e(Bitmap bitmap, Canvas canvas);

        View f();

        ViewGroup g();

        boolean h();
    }

    public PX0(final Context context, m.h hVar) {
        super(context, true, hVar);
        this.v1 = new Path();
        S(-14342875);
        Drawable drawableMutate = context.getResources().getDrawable(AbstractC23598xB5.sheet_shadow_round).mutate();
        this.N0 = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-14342875, PorterDuff.Mode.MULTIPLY));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, AbstractC21455b.F(16.0f), 0, 0);
        ImageView imageView = new ImageView(context);
        this.s1 = imageView;
        imageView.setImageResource(AbstractC23598xB5.picker);
        ImageView imageView2 = this.s1;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView2.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.s1.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.s1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.MX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q0(context, view);
            }
        });
        ImageView imageView3 = new ImageView(context);
        this.t1 = imageView3;
        imageView3.setImageResource(AbstractC23598xB5.ic_ab_done);
        this.t1.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.t1.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.t1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.NX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R0(view);
            }
        });
        c cVar = new c(context);
        this.u1 = cVar;
        cVar.b(-65536);
        d dVar = new d(context);
        this.r1 = dVar;
        linearLayout.addView(dVar, AbstractC13840gu3.g(-1, 0));
        b bVar = new b(context, linearLayout);
        bVar.addView(linearLayout);
        v0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(Context context, View view) {
        if (this.y1.b()) {
            return;
        }
        Bitmap bitmapE1 = AbstractC21455b.E1(this.y1.f());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapE1.getWidth(), bitmapE1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-16777216);
        this.y1.e(bitmapCreateBitmap, canvas);
        canvas.drawBitmap(bitmapE1, 0.0f, 0.0f, (Paint) null);
        bitmapE1.recycle();
        a aVar = new a(context, bitmapCreateBitmap);
        this.y1.g().addView(aVar, AbstractC13840gu3.b(-1, -1.0f));
        final h hVar = this.y1;
        Objects.requireNonNull(hVar);
        aVar.setColorListener(new InterfaceC25043ze1() { // from class: ir.nasim.OX0
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                hVar.d(((Integer) obj).intValue());
            }
        });
        aVar.f();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(int i2, int i3) {
        View viewFindFocus;
        if (!this.z1) {
            if (i3 != 2) {
                return;
            } else {
                this.z1 = true;
            }
        }
        if (i3 != 5 && (viewFindFocus = this.r1.findFocus()) != null) {
            viewFindFocus.clearFocus();
            AbstractC21455b.t0(viewFindFocus);
        }
        if (i3 != 3) {
            this.r1.a.a(i2);
        }
        if (i3 != 0) {
            this.r1.b.a(i2, i3 != 1);
        }
        if (i3 != 1) {
            this.u1.b(i2);
        }
        this.r1.c.e();
    }

    public PX0 T0(int i2) {
        S0(i2, 2);
        return this;
    }

    public PX0 U0(InterfaceC25043ze1 interfaceC25043ze1) {
        this.x1 = interfaceC25043ze1;
        return this;
    }

    public PX0 V0(h hVar) {
        this.y1 = hVar;
        return this;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        InterfaceC25043ze1 interfaceC25043ze1 = this.x1;
        if (interfaceC25043ze1 != null) {
            interfaceC25043ze1.accept(Integer.valueOf(this.w1));
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        if (!this.y1.h()) {
            this.s1.setVisibility(8);
        }
        super.show();
    }

    private final class d extends LinearLayout {
        private g a;
        private f b;
        private j c;
        private ViewPagerFixed.TabsView d;

        class a extends ViewPagerFixed {
            final /* synthetic */ PX0 B;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, m.h hVar, PX0 px0) {
                super(context, hVar);
                this.B = px0;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed
            protected int E() {
                return 0;
            }
        }

        public d(Context context) {
            super(context);
            setOrientation(1);
            g gVar = PX0.this.new g(context);
            this.a = gVar;
            gVar.a(PX0.this.w1);
            this.b = PX0.this.new f(context);
            this.c = PX0.this.new j(context);
            a aVar = new a(context, ((BottomSheet) PX0.this).e1, PX0.this);
            aVar.setAdapter(new b(PX0.this));
            addView(aVar, AbstractC13840gu3.h(-1, 0, 1.0f));
            addView(PX0.this.u1, AbstractC13840gu3.i(-1, 48, 12.0f, 0.0f, 12.0f, 0.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.addView(PX0.this.s1, AbstractC13840gu3.g(28, 28));
            ViewPagerFixed.TabsView tabsViewP = aVar.p(false, 8);
            this.d = tabsViewP;
            linearLayout.addView(tabsViewP, AbstractC13840gu3.l(-1, 40, 1.0f, 16, 12, 0, 12, 0));
            linearLayout.addView(PX0.this.t1, AbstractC13840gu3.g(28, 28));
            addView(linearLayout, AbstractC13840gu3.i(-1, 48, 14.0f, 0.0f, 14.0f, 0.0f));
        }

        class b extends ViewPagerFixed.e {
            final /* synthetic */ PX0 a;

            b(PX0 px0) {
                this.a = px0;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.e
            public View b(int i) {
                return i != 1 ? i != 2 ? d.this.a : d.this.c : d.this.b;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.e
            public int c() {
                return 3;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.e
            public String e(int i) {
                return i != 1 ? i != 2 ? FH3.C(TD5.tgwidget_PaintPaletteGrid).toUpperCase() : FH3.C(TD5.tgwidget_PaintPaletteSliders).toUpperCase() : FH3.C(TD5.tgwidget_PaintPaletteSpectrum).toUpperCase();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.e
            public int f(int i) {
                return i;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.e
            public void a(View view, int i, int i2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class i extends FrameLayout {
        private TextView a;
        private e b;
        private EditText c;
        private int d;
        private boolean e;

        public i(Context context) {
            super(context);
            TextView textView = new TextView(context);
            this.a = textView;
            textView.setTextColor(-1711276033);
            this.a.setTextSize(1, 14.0f);
            this.a.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            addView(this.a, AbstractC13840gu3.c(-2, -2.0f, 3, 8.0f, 0.0f, 8.0f, 0.0f));
            e eVar = PX0.this.new e(context);
            this.b = eVar;
            addView(eVar, AbstractC13840gu3.c(-1, -1.0f, 3, 0.0f, 16.0f, 78.0f, 0.0f));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.c = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.c.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(10.0f), 436207615));
            this.c.setPadding(0, 0, 0, 0);
            this.c.setTextColor(-1);
            this.c.setGravity(17);
            this.c.setSingleLine();
            this.c.setImeOptions(6);
            this.c.setImeActionLabel(FH3.C(TD5.tgwidget_Done), 6);
            this.c.setInputType(2);
            this.c.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.c.addTextChangedListener(new a(PX0.this));
            this.c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.QX0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    this.a.g(view, z);
                }
            });
            this.c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.RX0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    return PX0.i.h(textView2, i, keyEvent);
                }
            });
            addView(this.c, AbstractC13840gu3.d(72, 36, 85));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(View view, boolean z) {
            if (z || !TextUtils.isEmpty(this.c.getText())) {
                return;
            }
            this.c.setText("0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean h(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            textView.clearFocus();
            AbstractC21455b.t0(textView);
            return false;
        }

        public void e(int i) {
            this.d = i;
            this.b.c(i);
            if (i == 0) {
                this.a.setText(FH3.C(TD5.tgwidget_PaintPaletteSlidersRed).toUpperCase());
            } else if (i == 1) {
                this.a.setText(FH3.C(TD5.tgwidget_PaintPaletteSlidersGreen).toUpperCase());
            } else if (i == 2) {
                this.a.setText(FH3.C(TD5.tgwidget_PaintPaletteSlidersBlue).toUpperCase());
            }
            f();
        }

        public void f() {
            this.e = true;
            this.b.a();
            int selectionStart = this.c.getSelectionStart();
            int selectionEnd = this.c.getSelectionEnd();
            int i = this.d;
            if (i == 0) {
                this.c.setText(String.valueOf(Color.red(PX0.this.w1)));
            } else if (i == 1) {
                this.c.setText(String.valueOf(Color.green(PX0.this.w1)));
            } else if (i == 2) {
                this.c.setText(String.valueOf(Color.blue(PX0.this.w1)));
            }
            this.c.setSelection(selectionStart, selectionEnd);
            this.e = false;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(52.0f), 1073741824));
        }

        class a implements TextWatcher {
            private CharSequence a;
            final /* synthetic */ PX0 b;

            a(PX0 px0) {
                this.b = px0;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (i.this.e || this.a == null || editable == null || TextUtils.isEmpty(editable) || Objects.equals(this.a.toString(), editable.toString())) {
                    return;
                }
                int iB = AbstractC22000uV3.b(Integer.parseInt(editable.toString()), 0, 255);
                int i = i.this.d;
                PX0.this.S0(i != 1 ? i != 2 ? Color.argb(Color.alpha(PX0.this.w1), iB, Color.green(PX0.this.w1), Color.blue(PX0.this.w1)) : Color.argb(Color.alpha(PX0.this.w1), Color.red(PX0.this.w1), Color.green(PX0.this.w1), iB) : Color.argb(Color.alpha(PX0.this.w1), Color.red(PX0.this.w1), iB, Color.blue(PX0.this.w1)), 5);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.a = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class j extends LinearLayout {
        private i a;
        private i b;
        private i c;
        private EditText d;
        private boolean e;

        public j(Context context) {
            super(context);
            setOrientation(1);
            setPadding(AbstractC21455b.F(14.0f), 0, AbstractC21455b.F(14.0f), 0);
            i iVar = PX0.this.new i(context);
            this.a = iVar;
            iVar.e(0);
            addView(this.a, AbstractC13840gu3.l(-1, -2, 0.0f, 0, 0, 0, 0, 16));
            i iVar2 = PX0.this.new i(context);
            this.b = iVar2;
            iVar2.e(1);
            addView(this.b, AbstractC13840gu3.l(-1, -2, 0.0f, 0, 0, 0, 0, 16));
            i iVar3 = PX0.this.new i(context);
            this.c = iVar3;
            iVar3.e(2);
            addView(this.c, AbstractC13840gu3.l(-1, -2, 0.0f, 0, 0, 0, 0, 16));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(21);
            addView(linearLayout, AbstractC13840gu3.b(-1, 64.0f));
            TextView textView = new TextView(context);
            textView.setTextColor(-1711276033);
            textView.setTextSize(1, 16.0f);
            textView.setText(FH3.C(TD5.tgwidget_PaintPaletteSlidersHexColor).toUpperCase());
            textView.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            linearLayout.addView(textView, AbstractC13840gu3.i(-2, -2, 0.0f, 0.0f, 8.0f, 0.0f));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.d = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.d.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(10.0f), 436207615));
            this.d.setPadding(0, 0, 0, 0);
            this.d.setTextColor(-1);
            this.d.setGravity(17);
            this.d.setSingleLine();
            this.d.setImeOptions(6);
            this.d.setImeActionLabel(FH3.C(TD5.tgwidget_Done), 6);
            this.d.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.d.addTextChangedListener(new a(PX0.this));
            this.d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.SX0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    this.a.f(view, z);
                }
            });
            this.d.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.TX0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    return PX0.j.g(textView2, i, keyEvent);
                }
            });
            linearLayout.addView(this.d, AbstractC13840gu3.g(72, 36));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(View view, boolean z) {
            if (z || !TextUtils.isEmpty(this.d.getText())) {
                return;
            }
            this.d.setText("0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean g(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            textView.clearFocus();
            AbstractC21455b.t0(textView);
            return false;
        }

        public void e() {
            this.e = true;
            this.a.f();
            this.b.f();
            this.c.f();
            if (!this.d.isFocused()) {
                int selectionStart = this.d.getSelectionStart();
                int selectionEnd = this.d.getSelectionEnd();
                StringBuilder sb = new StringBuilder(Integer.toHexString(PX0.this.w1));
                while (sb.length() < 8) {
                    sb.insert(0, "0");
                }
                this.d.setText(sb.toString().toUpperCase().substring(2));
                this.d.setSelection(selectionStart, selectionEnd);
            }
            this.e = false;
        }

        class a implements TextWatcher {
            private Pattern a = Pattern.compile("^[0-9a-fA-F]*$");
            private CharSequence b;
            final /* synthetic */ PX0 c;

            a(PX0 px0) {
                this.c = px0;
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x00c9 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00ca  */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void afterTextChanged(android.text.Editable r6) throws java.lang.NumberFormatException {
                /*
                    r5 = this;
                    ir.nasim.PX0$j r0 = ir.nasim.PX0.j.this
                    boolean r0 = ir.nasim.PX0.j.d(r0)
                    if (r0 == 0) goto L9
                    return
                L9:
                    java.lang.CharSequence r0 = r5.b
                    if (r0 == 0) goto Ld2
                    if (r6 == 0) goto Ld2
                    boolean r0 = android.text.TextUtils.isEmpty(r6)
                    if (r0 != 0) goto Ld2
                    java.lang.CharSequence r0 = r5.b
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = r6.toString()
                    boolean r0 = java.util.Objects.equals(r0, r1)
                    if (r0 != 0) goto Ld2
                    java.lang.String r0 = r6.toString()
                    int r1 = r0.length()
                    r2 = 2
                    r3 = 8
                    if (r1 <= r3) goto L4d
                    ir.nasim.PX0$j r6 = ir.nasim.PX0.j.this
                    android.widget.EditText r6 = ir.nasim.PX0.j.c(r6)
                    java.lang.String r0 = r0.substring(r2, r3)
                    java.lang.String r0 = r0.toUpperCase()
                    r6.setText(r0)
                    ir.nasim.PX0$j r6 = ir.nasim.PX0.j.this
                    android.widget.EditText r6 = ir.nasim.PX0.j.c(r6)
                    r6.setSelection(r3)
                    return
                L4d:
                    java.util.regex.Pattern r1 = r5.a
                    java.util.regex.Matcher r6 = r1.matcher(r6)
                    boolean r6 = r6.find()
                    if (r6 != 0) goto L5a
                    return
                L5a:
                    int r6 = r0.length()
                    r1 = 3
                    r4 = 16
                    if (r6 == r1) goto L80
                    r1 = 6
                    if (r6 == r1) goto L77
                    if (r6 == r3) goto L71
                    ir.nasim.PX0$j r6 = ir.nasim.PX0.j.this
                    ir.nasim.PX0 r6 = ir.nasim.PX0.this
                    int r6 = ir.nasim.PX0.I0(r6)
                    goto Lbf
                L71:
                    long r0 = java.lang.Long.parseLong(r0, r4)
                L75:
                    int r6 = (int) r0
                    goto Lbf
                L77:
                    long r0 = java.lang.Long.parseLong(r0, r4)
                    int r6 = (int) r0
                    r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                    int r6 = r6 + r0
                    goto Lbf
                L80:
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r1 = "FF"
                    r6.append(r1)
                    r1 = 0
                    char r3 = r0.charAt(r1)
                    r6.append(r3)
                    char r1 = r0.charAt(r1)
                    r6.append(r1)
                    r1 = 1
                    char r3 = r0.charAt(r1)
                    r6.append(r3)
                    char r1 = r0.charAt(r1)
                    r6.append(r1)
                    char r1 = r0.charAt(r2)
                    r6.append(r1)
                    char r0 = r0.charAt(r2)
                    r6.append(r0)
                    java.lang.String r6 = r6.toString()
                    long r0 = java.lang.Long.parseLong(r6, r4)
                    goto L75
                Lbf:
                    ir.nasim.PX0$j r0 = ir.nasim.PX0.j.this
                    ir.nasim.PX0 r0 = ir.nasim.PX0.this
                    int r0 = ir.nasim.PX0.I0(r0)
                    if (r6 != r0) goto Lca
                    return
                Lca:
                    ir.nasim.PX0$j r0 = ir.nasim.PX0.j.this
                    ir.nasim.PX0 r0 = ir.nasim.PX0.this
                    r1 = 5
                    ir.nasim.PX0.O0(r0, r6, r1)
                Ld2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PX0.j.a.afterTextChanged(android.text.Editable):void");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.b = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }
    }
}
