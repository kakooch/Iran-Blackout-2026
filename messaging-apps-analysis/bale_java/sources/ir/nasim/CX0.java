package ir.nasim;

import java.util.List;

/* loaded from: classes2.dex */
public class CX0 extends AbstractC25155zp3 {
    public CX0(List list) {
        super(list);
    }

    public int r() {
        return s(b(), d());
    }

    public int s(C24561yp3 c24561yp3, float f) {
        Float f2;
        Integer num;
        if (c24561yp3.b == null || c24561yp3.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C13505gL3 c13505gL3 = this.e;
        return (c13505gL3 == null || (f2 = c24561yp3.h) == null || (num = (Integer) c13505gL3.b(c24561yp3.g, f2.floatValue(), (Integer) c24561yp3.b, (Integer) c24561yp3.c, f, e(), f())) == null) ? AD2.c(AbstractC7323Rf4.b(f, 0.0f, 1.0f), ((Integer) c24561yp3.b).intValue(), ((Integer) c24561yp3.c).intValue()) : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Integer i(C24561yp3 c24561yp3, float f) {
        return Integer.valueOf(s(c24561yp3, f));
    }
}
