package ir.nasim;

import java.lang.annotation.Annotation;

/* renamed from: ir.nasim.sL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20635sL5 implements JH6 {
    private final Annotation b;

    public C20635sL5(Annotation annotation) {
        AbstractC13042fc3.i(annotation, "annotation");
        this.b = annotation;
    }

    @Override // ir.nasim.JH6
    public KH6 b() {
        KH6 kh6 = KH6.a;
        AbstractC13042fc3.h(kh6, "NO_SOURCE_FILE");
        return kh6;
    }

    public final Annotation d() {
        return this.b;
    }
}
