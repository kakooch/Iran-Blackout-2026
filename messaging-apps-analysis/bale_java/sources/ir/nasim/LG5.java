package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import ir.nasim.VH5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class LG5 extends VH5 {
    private static final a J = new a(null);
    public static final int Y = 8;
    private static final int Z = AbstractC8943Xx1.c(20);
    private final List A;
    private final boolean B;
    private final InterfaceC9173Yu3 D;
    private List G;
    private final InterfaceC9173Yu3 H;
    private final int z;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LG5(Drawable drawable, int i, int i2, Integer num, int i3, int i4, Float f, float f2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List list, boolean z, int i13, ED1 ed1) {
        int iE;
        int iB = (i13 & 32) != 0 ? VH5.q.b() : i4;
        Float f3 = (i13 & 64) != 0 ? null : f;
        float fA = (i13 & 128) != 0 ? VH5.q.a() : f2;
        int iG = (i13 & 256) != 0 ? VH5.q.g() : i5;
        int iG2 = (i13 & 512) != 0 ? VH5.q.g() : i6;
        int iD = (i13 & 1024) != 0 ? VH5.q.d() : i7;
        int iD2 = (i13 & 2048) != 0 ? VH5.q.d() : i8;
        if ((i13 & 4096) != 0) {
            VH5.a aVar = VH5.q;
            iE = aVar.e() - aVar.c();
        } else {
            iE = i9;
        }
        this(drawable, i, i2, num, i3, iB, f3, fA, iG, iG2, iD, iD2, iE, (i13 & 8192) != 0 ? VH5.q.e() : i10, (i13 & 16384) != 0 ? VH5.q.c() : i11, (32768 & i13) != 0 ? Z : i12, list, (i13 & 131072) != 0 ? false : z);
    }

    private final void A(Drawable drawable, Canvas canvas) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float fI = AbstractC23053wG5.i(intrinsicWidth, intrinsicHeight) / 2;
        float f = intrinsicWidth / 2;
        float f2 = intrinsicHeight / 2;
        D().addCircle(f, f2, AbstractC8943Xx1.c(1) + fI, Path.Direction.CW);
        D().addCircle(f + AbstractC8943Xx1.c(14), f2, fI + AbstractC8943Xx1.c(1), Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(D());
        drawable.draw(canvas);
        canvas.restore();
    }

    private final Path D() {
        return (Path) this.H.getValue();
    }

    private final GradientDrawable F() {
        return (GradientDrawable) this.D.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GradientDrawable G(int i, LG5 lg5) {
        AbstractC13042fc3.i(lg5, "this$0");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(AbstractC8943Xx1.c(12));
        gradientDrawable.setBounds(AbstractC8943Xx1.c(-2), AbstractC8943Xx1.c(-2), lg5.z + AbstractC8943Xx1.c(2), lg5.z + AbstractC8943Xx1.c(2));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path x() {
        return new Path();
    }

    private final void y(Canvas canvas, float f, float f2) {
        List listP = AbstractC10360bX0.p(0, Integer.valueOf(AbstractC8943Xx1.c(15)), Integer.valueOf(AbstractC8943Xx1.c(30)));
        int i = 0;
        for (Object obj : AbstractC15401jX0.f1(this.G, 3)) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            Drawable drawable = (Drawable) obj;
            float fFloatValue = ((Number) listP.get(i)).floatValue() + f;
            int iSave = canvas.save();
            canvas.translate(fFloatValue, f2);
            try {
                int i3 = this.z;
                drawable.setBounds(0, 0, i3, i3);
                F().draw(canvas);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
                i = i2;
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    private final void z(Canvas canvas, float f, float f2) {
        List listP = AbstractC10360bX0.p(0, Integer.valueOf(AbstractC8943Xx1.c(15)), Integer.valueOf(AbstractC8943Xx1.c(30)));
        int i = 0;
        for (Object obj : AbstractC15401jX0.f1(this.G, 3)) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            Drawable drawable = (Drawable) obj;
            float fFloatValue = ((Number) listP.get(i)).floatValue() + f;
            int iSave = canvas.save();
            canvas.translate(fFloatValue, f2);
            try {
                int i3 = this.z;
                drawable.setBounds(0, 0, i3, i3);
                if (i == this.G.size() - 1) {
                    drawable.draw(canvas);
                } else {
                    A(drawable, canvas);
                }
                canvas.restoreToCount(iSave);
                i = i2;
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    public final int B() {
        return this.z;
    }

    public final List C() {
        return this.A;
    }

    public final List E() {
        return this.G;
    }

    @Override // ir.nasim.VH5, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        int size = getSize(paint, charSequence, i, i2, paint.getFontMetricsInt());
        float fS = f + s();
        float fP = i3 + p() + t();
        float fO = this.z + fS + o();
        float f2 = f + size;
        float fT = fP - t();
        float fM = m() + fP + q();
        i(canvas, paint, f, f2, fT, fM);
        l(canvas, f + 2.0f, fT + 2.0f, f2 - 2.0f, fM - 2.0f, paint);
        if (this.B) {
            z(canvas, fS, fP - AbstractC8943Xx1.c(1));
        } else {
            y(canvas, fS, fP - AbstractC8943Xx1.c(1));
        }
        k(canvas, fO + (AbstractC8943Xx1.c(14) * (this.G.size() - 1)), fP);
    }

    @Override // ir.nasim.VH5, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        AbstractC13042fc3.i(paint, "paint");
        u(fontMetricsInt);
        return this.z + o() + m() + s() + r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LG5(Drawable drawable, int i, final int i2, Integer num, int i3, int i4, Float f, float f2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List list, boolean z) {
        super("", drawable, i, num, i3, i4, f, f2, i5, i6, i7, i8, i9, i10, i11);
        AbstractC13042fc3.i(drawable, "reactionDrawable");
        AbstractC13042fc3.i(list, "avatars");
        this.z = i12;
        this.A = list;
        this.B = z;
        this.D = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.JG5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return LG5.G(i2, this);
            }
        });
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C20610sI7) it.next()).c());
        }
        this.G = AbstractC15401jX0.p1(arrayList);
        this.H = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.KG5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return LG5.x();
            }
        });
    }
}
