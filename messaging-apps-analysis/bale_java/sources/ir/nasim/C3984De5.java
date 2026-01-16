package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.De5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3984De5 extends ReplacementSpan {
    public static final a k = new a(null);
    public static final int l = 8;
    private final float a;
    private final int b;
    private final float c;
    private final int d;
    private final float e;
    private final int f;
    private Paint.FontMetricsInt g;
    private int h;
    private int i;
    private boolean j;

    /* renamed from: ir.nasim.De5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C3984De5(float f, int i, float f2, int i2, float f3, int i3) {
        this.a = f;
        this.b = i;
        this.c = f2;
        this.d = i2;
        this.e = f3;
        this.f = i3;
    }

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.g;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        AbstractC13042fc3.y("fontMetrics");
        return null;
    }

    public final int b() {
        if (!this.j) {
            N73.c("PlaceholderSpan is not laid out yet.");
        }
        return this.i;
    }

    public final int c() {
        return this.f;
    }

    public final int d() {
        if (!this.j) {
            N73.c("PlaceholderSpan is not laid out yet.");
        }
        return this.h;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float f;
        int iA;
        this.j = true;
        float textSize = paint.getTextSize();
        this.g = paint.getFontMetricsInt();
        if (!(a().descent > a().ascent)) {
            N73.a("Invalid fontMetrics: line height can not be negative.");
        }
        int i3 = this.b;
        if (i3 == 0) {
            f = this.a * this.e;
        } else {
            if (i3 != 1) {
                N73.b("Unsupported unit.");
                throw new KotlinNothingValueException();
            }
            f = this.a * textSize;
        }
        this.h = AbstractC4218Ee5.a(f);
        int i4 = this.d;
        if (i4 == 0) {
            iA = AbstractC4218Ee5.a(this.c * this.e);
        } else {
            if (i4 != 1) {
                N73.b("Unsupported unit.");
                throw new KotlinNothingValueException();
            }
            iA = AbstractC4218Ee5.a(this.c * textSize);
        }
        this.i = iA;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = a().ascent;
            fontMetricsInt.descent = a().descent;
            fontMetricsInt.leading = a().leading;
            switch (this.f) {
                case 0:
                    if (fontMetricsInt.ascent > (-b())) {
                        fontMetricsInt.ascent = -b();
                        break;
                    }
                    break;
                case 1:
                case 4:
                    if (fontMetricsInt.ascent + b() > fontMetricsInt.descent) {
                        fontMetricsInt.descent = fontMetricsInt.ascent + b();
                        break;
                    }
                    break;
                case 2:
                case 5:
                    if (fontMetricsInt.ascent > fontMetricsInt.descent - b()) {
                        fontMetricsInt.ascent = fontMetricsInt.descent - b();
                        break;
                    }
                    break;
                case 3:
                case 6:
                    if (fontMetricsInt.descent - fontMetricsInt.ascent < b()) {
                        int iB = fontMetricsInt.ascent - ((b() - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2);
                        fontMetricsInt.ascent = iB;
                        fontMetricsInt.descent = iB + b();
                        break;
                    }
                    break;
                default:
                    N73.a("Unknown verticalAlign.");
                    break;
            }
            fontMetricsInt.top = Math.min(a().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(a().bottom, fontMetricsInt.descent);
        }
        return d();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
    }
}
