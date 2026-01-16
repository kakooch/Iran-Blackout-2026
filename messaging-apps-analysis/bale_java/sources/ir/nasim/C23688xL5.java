package ir.nasim;

import java.lang.annotation.Annotation;

/* renamed from: ir.nasim.xL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23688xL5 extends AbstractC23098wL5 implements InterfaceC4477Fh3 {
    private final Annotation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23688xL5(C6432No4 c6432No4, Annotation annotation) {
        super(c6432No4);
        AbstractC13042fc3.i(annotation, "annotation");
        this.c = annotation;
    }

    @Override // ir.nasim.InterfaceC4477Fh3
    public InterfaceC4009Dh3 a() {
        return new C22502vL5(this.c);
    }
}
