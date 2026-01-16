package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Pa3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6799Pa3 extends AbstractC25155zp3 {
    public C6799Pa3(List list) {
        super(list);
    }

    int r(C24561yp3 c24561yp3, float f) {
        Integer num;
        if (c24561yp3.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iH = c24561yp3.c == null ? c24561yp3.h() : c24561yp3.e();
        C13505gL3 c13505gL3 = this.e;
        return (c13505gL3 == null || (num = (Integer) c13505gL3.b(c24561yp3.g, c24561yp3.h.floatValue(), (Integer) c24561yp3.b, Integer.valueOf(iH), f, e(), f())) == null) ? AbstractC7323Rf4.j(c24561yp3.h(), iH, f) : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer i(C24561yp3 c24561yp3, float f) {
        return Integer.valueOf(r(c24561yp3, f));
    }
}
