package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.rc6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20198rc6 implements BQ7 {
    public static final C20198rc6 a = new C20198rc6();

    private C20198rc6() {
    }

    @Override // ir.nasim.BQ7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C19591qc6 a(AbstractC11911dl3 abstractC11911dl3, float f) {
        boolean z = abstractC11911dl3.j() == AbstractC11911dl3.b.BEGIN_ARRAY;
        if (z) {
            abstractC11911dl3.b();
        }
        float fF1 = (float) abstractC11911dl3.f1();
        float fF12 = (float) abstractC11911dl3.f1();
        while (abstractC11911dl3.d()) {
            abstractC11911dl3.R();
        }
        if (z) {
            abstractC11911dl3.c();
        }
        return new C19591qc6((fF1 / 100.0f) * f, (fF12 / 100.0f) * f);
    }
}
