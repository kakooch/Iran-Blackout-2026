package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.jw7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15655jw7 extends AbstractC13273fw7 {
    private final C12722f55 d;

    public C15655jw7(C12722f55 c12722f55) {
        this.d = c12722f55;
    }

    @Override // java.util.Iterator
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        XZ0.a(f());
        n(e() + 2);
        return new C23942xm4(this.d, d()[e() - 2], d()[e() - 1]);
    }
}
