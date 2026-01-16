package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.dq2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C11959dq2 extends AbstractC25155zp3 {
    public C11959dq2(List list) {
        super(list);
    }

    public float r() {
        return s(b(), d());
    }

    float s(C24561yp3 c24561yp3, float f) {
        Float f2;
        if (c24561yp3.b == null || c24561yp3.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C13505gL3 c13505gL3 = this.e;
        return (c13505gL3 == null || (f2 = (Float) c13505gL3.b(c24561yp3.g, c24561yp3.h.floatValue(), (Float) c24561yp3.b, (Float) c24561yp3.c, f, e(), f())) == null) ? AbstractC7323Rf4.i(c24561yp3.g(), c24561yp3.d(), f) : f2.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Float i(C24561yp3 c24561yp3, float f) {
        return Float.valueOf(s(c24561yp3, f));
    }
}
