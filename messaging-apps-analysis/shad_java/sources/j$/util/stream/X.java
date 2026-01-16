package j$.util.stream;

import j$.util.C0114k;
import j$.util.function.C0108a;

/* loaded from: classes2.dex */
public final /* synthetic */ class X implements j$.util.function.y {
    public static final /* synthetic */ X a = new X();

    private /* synthetic */ X() {
    }

    @Override // j$.util.function.y
    public j$.util.function.y a(j$.util.function.y yVar) {
        yVar.getClass();
        return new j$.util.function.x(this, yVar, 1);
    }

    @Override // j$.util.function.y
    public j$.util.function.y b(j$.util.function.y yVar) {
        yVar.getClass();
        return new j$.util.function.x(this, yVar, 0);
    }

    @Override // j$.util.function.y
    public j$.util.function.y negate() {
        return new C0108a(this);
    }

    @Override // j$.util.function.y
    public final boolean test(Object obj) {
        return ((C0114k) obj).c();
    }
}
