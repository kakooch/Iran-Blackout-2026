package ir.nasim;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* renamed from: ir.nasim.p02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18642p02 extends CharacterStyle implements UpdateAppearance {
    private final AbstractC18051o02 a;

    public C18642p02(AbstractC18051o02 abstractC18051o02) {
        this.a = abstractC18051o02;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            AbstractC18051o02 abstractC18051o02 = this.a;
            if (AbstractC13042fc3.d(abstractC18051o02, C8568Wn2.a)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (abstractC18051o02 instanceof C23815xZ6) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((C23815xZ6) this.a).f());
                textPaint.setStrokeMiter(((C23815xZ6) this.a).d());
                textPaint.setStrokeJoin(AbstractC19233q02.b(((C23815xZ6) this.a).c()));
                textPaint.setStrokeCap(AbstractC19233q02.a(((C23815xZ6) this.a).b()));
                ((C23815xZ6) this.a).e();
                textPaint.setPathEffect(null);
            }
        }
    }
}
