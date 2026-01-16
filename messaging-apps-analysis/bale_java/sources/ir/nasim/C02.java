package ir.nasim;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.graphics.painter.ColorPainter;
import com.google.accompanist.drawablepainter.DrawablePainter;
import com.google.accompanist.drawablepainter.EmptyPainter;

/* loaded from: classes2.dex */
public abstract class C02 {
    private static final InterfaceC9173Yu3 a = AbstractC13269fw3.b(EnumC4870Gx3.c, a.e);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c(Drawable drawable) {
        return (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) ? OD6.b.a() : UD6.a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler d() {
        return (Handler) a.getValue();
    }

    public static final EV4 e(Drawable drawable, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        Object drawablePainter;
        interfaceC22053ub1.A(1756822313);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1756822313, i, -1, "com.google.accompanist.drawablepainter.rememberDrawablePainter (DrawablePainter.kt:151)");
        }
        interfaceC22053ub1.A(1157296644);
        boolean zV = interfaceC22053ub1.V(drawable);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            if (drawable == null) {
                objB = EmptyPainter.g;
            } else {
                if (drawable instanceof ColorDrawable) {
                    drawablePainter = new ColorPainter(DX0.b(((ColorDrawable) drawable).getColor()), null);
                } else {
                    Drawable drawableMutate = drawable.mutate();
                    AbstractC13042fc3.h(drawableMutate, "mutate(...)");
                    drawablePainter = new DrawablePainter(drawableMutate);
                }
                objB = drawablePainter;
            }
            interfaceC22053ub1.s(objB);
        }
        interfaceC22053ub1.U();
        EV4 ev4 = (EV4) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return ev4;
    }
}
