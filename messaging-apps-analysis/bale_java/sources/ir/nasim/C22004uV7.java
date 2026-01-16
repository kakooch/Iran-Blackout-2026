package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* renamed from: ir.nasim.uV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22004uV7 extends ReplacementSpan {
    private static final int q;
    private static final int s;
    private static final int t;
    private static final int u;
    private final String a;
    private final String b;
    private final Float c;
    private final boolean d;
    private final boolean e;
    private final Drawable f;
    private final int g;
    private final int h;
    private final float i;
    private final float j;
    private int k;
    private int l;
    private int m;
    private int n;
    public static final a o = new a(null);
    public static final int p = 8;
    private static final int r = (int) ((24 * AbstractC3742Cd6.c()) + 0.5d);
    private static final int v = (int) ((AbstractC3742Cd6.c() * 1.5d) + 0.5d);
    private static final int w = (int) ((2 * AbstractC3742Cd6.c()) + 0.5d);
    private static final int x = (int) ((8 * AbstractC3742Cd6.c()) + 0.5d);
    private static final int y = (int) ((5 * AbstractC3742Cd6.c()) + 0.5d);
    private static final int z = (int) ((4 * AbstractC3742Cd6.c()) + 0.5d);

    /* renamed from: ir.nasim.uV7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        double d = 6;
        q = (int) ((AbstractC3742Cd6.c() * d) + 0.5d);
        s = (int) ((d * AbstractC3742Cd6.c()) + 0.5d);
        double d2 = 1;
        t = (int) ((AbstractC3742Cd6.c() * d2) + 0.5d);
        u = (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d);
    }

    public /* synthetic */ C22004uV7(String str, String str2, Float f, boolean z2, boolean z3, Drawable drawable, int i, int i2, float f2, float f3, int i3, ED1 ed1) {
        this(str, str2, f, z2, z3, drawable, i, i2, (i3 & 256) != 0 ? -90.0f : f2, (i3 & 512) != 0 ? q : f3);
    }

    private final void a(Canvas canvas, Paint paint, float f, float f2, float f3, float f4) {
        int color = paint.getColor();
        paint.setColor(this.h);
        float f5 = this.j;
        canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
        paint.setColor(color);
    }

    private final void b(Canvas canvas, float f, float f2) {
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            Drawable drawable = this.f;
            if (drawable != null) {
                int i = r;
                drawable.setBounds(0, 0, i, i);
                drawable.draw(canvas);
            }
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    private final void c(Canvas canvas, float f, Paint paint, float f2, float f3, float f4, float f5) {
        int color = paint.getColor();
        Paint.Style style = paint.getStyle();
        Paint.Cap strokeCap = paint.getStrokeCap();
        float strokeWidth = paint.getStrokeWidth();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(w);
        float f6 = (f2 + f4) / 2.0f;
        float f7 = (f3 + f5) / 2.0f;
        paint.setColor(QY0.k(this.g, SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER));
        canvas.drawCircle(f6, f7, (f5 - f3) / 2.0f, paint);
        paint.setColor(this.g);
        canvas.drawArc(f2, f3, f4, f5, this.i, f * 360, false, paint);
        if (this.e) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(u);
            int i = s;
            float f8 = f6 - (i / 2.0f);
            float f9 = f7 - (i / 2.0f);
            float f10 = i + f8;
            float f11 = f9 + i;
            int i2 = t;
            canvas.drawRoundRect(f8, f9, f10, f11, i2, i2, paint);
        }
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeCap(strokeCap);
        paint.setStrokeWidth(strokeWidth);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        a(canvas, paint, f, i3, f + this.k, i5);
        float f2 = i5 - i3;
        float f3 = x;
        int iSave = canvas.save();
        canvas.translate(f3, 0.0f);
        try {
            if (this.d) {
                float f4 = i4 / 2.0f;
                canvas.drawText(this.a, 0.0f, f4, paint);
                canvas.drawText(this.b, 0.0f, (f2 / 2) + f4, paint);
                float fMax = Integer.max(this.l, this.m) + this.n;
                Float f5 = this.c;
                if (f5 != null) {
                    float fFloatValue = f5.floatValue();
                    float f6 = r;
                    int i6 = v;
                    float f7 = f6 - (i6 * 2.0f);
                    float f8 = i6 + fMax;
                    float f9 = (f2 - f7) / 2.0f;
                    c(canvas, fFloatValue, paint, f8, f9, f8 + f7, f9 + f7);
                } else {
                    b(canvas, fMax, (f2 - r) / 2.0f);
                }
            } else {
                Float f10 = this.c;
                if (f10 != null) {
                    float fFloatValue2 = f10.floatValue();
                    float f11 = r;
                    int i7 = v;
                    float f12 = f11 - (i7 * 2.0f);
                    float f13 = i7 + 0.0f;
                    float f14 = (f2 - f12) / 2.0f;
                    c(canvas, fFloatValue2, paint, f13, f14, f13 + f12, f14 + f12);
                } else {
                    b(canvas, 0.0f, (f2 - r) / 2.0f);
                }
                float f15 = r + this.n;
                float f16 = i4 / 2.0f;
                canvas.drawText(this.a, f15, f16, paint);
                canvas.drawText(this.b, f15, (f2 / 2) + f16, paint);
            }
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int i3;
        int i4;
        AbstractC13042fc3.i(paint, "paint");
        this.l = AbstractC20723sV3.d(paint.measureText(this.b));
        this.m = AbstractC20723sV3.d(paint.measureText(this.a));
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        int i5 = (fontMetricsInt2.bottom - fontMetricsInt2.top) * 2;
        int i6 = r;
        int iMax = Integer.max(i5, y + i6);
        if (fontMetricsInt != null && iMax != (i4 = (i3 = fontMetricsInt.bottom) - fontMetricsInt.top)) {
            int iD = AbstractC20723sV3.d(i3 * (i4 > 0 ? iMax / i4 : 1.0f));
            fontMetricsInt.bottom = iD;
            fontMetricsInt.top = iD - iMax;
        }
        this.n = Integer.max(this.l, this.m) > 0 ? z : 0;
        int iMax2 = Integer.max(this.l, this.m) + this.n + i6 + (x * 2);
        this.k = iMax2;
        return iMax2;
    }

    public C22004uV7(String str, String str2, Float f, boolean z2, boolean z3, Drawable drawable, int i, int i2, float f2, float f3) {
        AbstractC13042fc3.i(str, "duration");
        AbstractC13042fc3.i(str2, "fileSize");
        this.a = str;
        this.b = str2;
        this.c = f;
        this.d = z2;
        this.e = z3;
        this.f = drawable;
        this.g = i;
        this.h = i2;
        this.i = f2;
        this.j = f3;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
    }
}
