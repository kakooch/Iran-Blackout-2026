package ir.nasim;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* renamed from: ir.nasim.Ew6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4381Ew6 extends CharacterStyle implements UpdateAppearance {
    private final AbstractC4147Dw6 a;
    private final float b;
    private final InterfaceC9102Ym4 c = AbstractC13472gH6.d(OD6.c(OD6.b.a()), null, 2, null);
    private final InterfaceC9664aL6 d = AbstractC10222bH6.d(new a());

    /* renamed from: ir.nasim.Ew6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Shader invoke() {
            if (C4381Ew6.this.b() == 9205357640488583168L || OD6.k(C4381Ew6.this.b())) {
                return null;
            }
            return C4381Ew6.this.a().b(C4381Ew6.this.b());
        }
    }

    public C4381Ew6(AbstractC4147Dw6 abstractC4147Dw6, float f) {
        this.a = abstractC4147Dw6;
        this.b = f;
    }

    public final AbstractC4147Dw6 a() {
        return this.a;
    }

    public final long b() {
        return ((OD6) this.c.getValue()).m();
    }

    public final void c(long j) {
        this.c.setValue(OD6.c(j));
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC14399hr.a(textPaint, this.b);
        textPaint.setShader((Shader) this.d.getValue());
    }
}
