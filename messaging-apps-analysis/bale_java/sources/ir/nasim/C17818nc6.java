package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.nc6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17818nc6 extends AbstractC25155zp3 {
    private final C19591qc6 i;

    public C17818nc6(List list) {
        super(list);
        this.i = new C19591qc6();
    }

    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C19591qc6 i(C24561yp3 c24561yp3, float f) {
        Object obj;
        C19591qc6 c19591qc6;
        Object obj2 = c24561yp3.b;
        if (obj2 == null || (obj = c24561yp3.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C19591qc6 c19591qc62 = (C19591qc6) obj2;
        C19591qc6 c19591qc63 = (C19591qc6) obj;
        C13505gL3 c13505gL3 = this.e;
        if (c13505gL3 != null && (c19591qc6 = (C19591qc6) c13505gL3.b(c24561yp3.g, c24561yp3.h.floatValue(), c19591qc62, c19591qc63, f, e(), f())) != null) {
            return c19591qc6;
        }
        this.i.d(AbstractC7323Rf4.i(c19591qc62.b(), c19591qc63.b(), f), AbstractC7323Rf4.i(c19591qc62.c(), c19591qc63.c(), f));
        return this.i;
    }
}
