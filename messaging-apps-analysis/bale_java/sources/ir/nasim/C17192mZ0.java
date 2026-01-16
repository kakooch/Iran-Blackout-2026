package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.ReplacementSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.mZ0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C17192mZ0 extends ReplacementSpan {
    private static final a k = new a(null);
    public static final int l = 8;
    private static final int m = AbstractC8943Xx1.c(25);
    private final int a;
    private final int b;
    private final float c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final List h;
    private final InterfaceC9173Yu3 i;
    private List j;

    /* renamed from: ir.nasim.mZ0$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C17192mZ0(int i, int i2, float f, int i3, int i4, int i5, int i6, List list, int i7, ED1 ed1) {
        this(i, i2, (i7 & 4) != 0 ? VH5.q.a() : f, (i7 & 8) != 0 ? VH5.q.g() : i3, (i7 & 16) != 0 ? VH5.q.g() : i4, (i7 & 32) != 0 ? AbstractC8943Xx1.c(8) : i5, (i7 & 64) != 0 ? m : i6, (i7 & 128) != 0 ? AbstractC10360bX0.m() : list);
    }

    private final void b(Canvas canvas, float f, float f2) {
        List listP = AbstractC10360bX0.p(Integer.valueOf(AbstractC8943Xx1.c(0)), Integer.valueOf(AbstractC8943Xx1.c(12)), Integer.valueOf(AbstractC8943Xx1.c(24)));
        int i = 0;
        for (Object obj : AbstractC15401jX0.f1(this.j, 3)) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            Drawable drawable = (Drawable) obj;
            float fFloatValue = ((Number) listP.get(i)).floatValue() + f;
            int iSave = canvas.save();
            canvas.translate(fFloatValue, f2);
            try {
                int i3 = this.g;
                drawable.setBounds(0, 0, i3, i3);
                f().draw(canvas);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
                i = i2;
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    private final GradientDrawable f() {
        return (GradientDrawable) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GradientDrawable g(C17192mZ0 c17192mZ0) {
        AbstractC13042fc3.i(c17192mZ0, "this$0");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(c17192mZ0.b);
        gradientDrawable.setBounds(AbstractC8943Xx1.c(-2), AbstractC8943Xx1.c(-2), c17192mZ0.g + AbstractC8943Xx1.a(1.5d), c17192mZ0.g + AbstractC8943Xx1.a(1.5d));
        gradientDrawable.setCornerRadius(AbstractC8943Xx1.c(16));
        return gradientDrawable;
    }

    public final int c() {
        return this.g;
    }

    public final List d() {
        return this.h;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        b(canvas, f + AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(1));
    }

    public final List e() {
        return this.j;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        AbstractC13042fc3.i(paint, "paint");
        int size = ((this.h.size() + 1) * (this.g / 2)) + AbstractC8943Xx1.c(this.h.size() * 2);
        return this.h.size() == 1 ? size + AbstractC8943Xx1.c(2) : size;
    }

    public C17192mZ0(int i, int i2, float f, int i3, int i4, int i5, int i6, List list) {
        AbstractC13042fc3.i(list, "avatars");
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = list;
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17192mZ0.g(this.a);
            }
        });
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C20610sI7) it.next()).c());
        }
        this.j = AbstractC15401jX0.p1(arrayList);
    }
}
