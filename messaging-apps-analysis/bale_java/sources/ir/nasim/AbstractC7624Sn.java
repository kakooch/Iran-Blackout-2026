package ir.nasim;

import android.graphics.Canvas;

/* renamed from: ir.nasim.Sn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7624Sn {
    private static final Canvas a = new Canvas();

    public static final UE0 a(Y03 y03) {
        C7390Rn c7390Rn = new C7390Rn();
        c7390Rn.y(new Canvas(AbstractC19123pp.b(y03)));
        return c7390Rn;
    }

    public static final UE0 b(Canvas canvas) {
        C7390Rn c7390Rn = new C7390Rn();
        c7390Rn.y(canvas);
        return c7390Rn;
    }

    public static final Canvas d(UE0 ue0) {
        AbstractC13042fc3.g(ue0, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidCanvas");
        return ((C7390Rn) ue0).a();
    }
}
