package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class WU extends Drawable {
    public static final a h = new a(null);
    public static final int i = 8;
    private static TextPaint j;
    private static float k;
    private static Paint l;
    private static int[] m;
    private final float a;
    private final Context b;
    private String c;
    private int d;
    private int e;
    private int f;
    private boolean g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ WU(String str, int i2, float f, Context context, boolean z, boolean z2, int i3, ED1 ed1) {
        this(str, i2, f, context, z, (i3 & 32) != 0 ? false : z2);
    }

    public final int a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        TextPaint textPaint;
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.h(getBounds(), "getBounds(...)");
        Paint paint = l;
        if (paint != null) {
            paint.setColor(this.d);
            if (this.g) {
                canvas.drawCircle(r0.centerX(), r0.centerY(), (Math.min(r0.width(), r0.height()) / 2) - 1, paint);
            } else {
                RectF rectF = new RectF(r0.left, r0.top, r0.right, r0.bottom);
                float fWidth = r0.width() / 3.5f;
                canvas.drawRoundRect(rectF, fWidth, fWidth, paint);
            }
        }
        float f = k;
        float f2 = this.a;
        if (f != f2) {
            TextPaint textPaint2 = j;
            if (textPaint2 != null) {
                textPaint2.setTextSize(TypedValue.applyDimension(2, f2, this.b.getResources().getDisplayMetrics()));
            }
            k = this.a;
        }
        String str = this.c;
        if (str == null || (textPaint = j) == null) {
            return;
        }
        canvas.drawText(str, this.e, this.f, textPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        Rect rect = new Rect();
        String str = this.c;
        if (str != null) {
            float f = k;
            float f2 = this.a;
            if (f != f2) {
                TextPaint textPaint = j;
                if (textPaint != null) {
                    textPaint.setTextSize(TypedValue.applyDimension(2, f2, this.b.getResources().getDisplayMetrics()));
                }
                k = this.a;
            }
            TextPaint textPaint2 = j;
            if (textPaint2 != null) {
                this.e = (int) (((i4 - i2) - textPaint2.measureText(str, 0, str.length())) / 2);
                textPaint2.getTextBounds(str, 0, str.length(), rect);
            }
            this.f = (((i5 - i3) - rect.top) - rect.bottom) / 2;
        }
    }

    public WU(String str, int i2, float f, Context context, boolean z, boolean z2) {
        String upperCase;
        AbstractC13042fc3.i(context, "context");
        this.b = context;
        this.a = f;
        this.g = z2;
        if (z) {
            upperCase = "";
        } else if (str == null || str.length() == 0) {
            upperCase = Separators.QUESTION;
        } else {
            int length = str.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (i3 <= length) {
                boolean z4 = AbstractC13042fc3.k(str.charAt(!z3 ? i3 : length), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z4) {
                    i3++;
                } else {
                    z3 = true;
                }
            }
            String[] strArr = (String[]) new C20644sM5(Separators.SP).m(str.subSequence(i3, length + 1).toString(), 2).toArray(new String[0]);
            if (strArr[0].length() == 0) {
                strArr[0] = Separators.QUESTION;
            }
            String strSubstring = strArr[0].substring(0, 1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            upperCase = strSubstring.toUpperCase(locale);
            AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        }
        if (m == null) {
            m = new int[]{AbstractC4043Dl1.c(context, TA5.placeholder_0), AbstractC4043Dl1.c(context, TA5.placeholder_1), AbstractC4043Dl1.c(context, TA5.placeholder_2), AbstractC4043Dl1.c(context, TA5.placeholder_3), AbstractC4043Dl1.c(context, TA5.placeholder_4), AbstractC4043Dl1.c(context, TA5.placeholder_5), AbstractC4043Dl1.c(context, TA5.placeholder_6)};
        }
        if (l == null) {
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.FILL);
            l = paint;
        }
        if (j == null) {
            TextPaint textPaint = new TextPaint(1);
            textPaint.setTypeface(C6011Lu2.i());
            textPaint.setColor(-1);
            textPaint.setTextSize(TypedValue.applyDimension(1, k, context.getResources().getDisplayMetrics()));
            j = textPaint;
        }
        int[] iArr = m;
        if (iArr != null) {
            this.d = i2 == 0 ? iArr[upperCase.charAt(0) % iArr.length] : iArr[Math.abs(i2) % iArr.length];
        }
        this.c = upperCase;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
