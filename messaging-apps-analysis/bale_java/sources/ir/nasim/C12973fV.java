package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

/* renamed from: ir.nasim.fV, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12973fV extends DynamicDrawableSpan {
    private static final a d = new a(null);
    public static final int e = 8;
    private static final int f = AbstractC8943Xx1.c(20);
    private final C20610sI7 a;
    private final int b;
    private Drawable c;

    /* renamed from: ir.nasim.fV$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C12973fV(C20610sI7 c20610sI7, int i, int i2, ED1 ed1) {
        this(c20610sI7, (i2 & 2) != 0 ? f : i);
    }

    public final void a(Drawable drawable) {
        AbstractC13042fc3.i(drawable, "avatarDrawable");
        int i = this.b;
        drawable.setBounds(0, 0, i, i);
        this.c = drawable;
    }

    public final int b() {
        return this.b;
    }

    public final C20610sI7 c() {
        return this.a;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        int iSave = canvas.save();
        canvas.translate(f2, i3 + (((i5 - i3) - this.b) / 2.0f));
        try {
            this.c.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return this.c;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        AbstractC13042fc3.i(paint, "paint");
        return this.b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12973fV(C20610sI7 c20610sI7, int i) {
        super(2);
        AbstractC13042fc3.i(c20610sI7, "userAvatar");
        this.a = c20610sI7;
        this.b = i;
        WU wuC = c20610sI7.c();
        wuC.setBounds(0, 0, i, i);
        this.c = wuC;
    }
}
