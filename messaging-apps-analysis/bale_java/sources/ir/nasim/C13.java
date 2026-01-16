package ir.nasim;

import androidx.camera.core.impl.i;
import ir.nasim.BB0;

/* loaded from: classes.dex */
final class C13 extends C19931rB0 {
    static final C13 c = new C13(new E13());
    private final E13 b;

    private C13(E13 e13) {
        this.b = e13;
    }

    @Override // ir.nasim.C19931rB0, androidx.camera.core.impl.i.b
    public void a(androidx.camera.core.impl.C c2, i.a aVar) {
        super.a(c2, aVar);
        if (!(c2 instanceof androidx.camera.core.impl.m)) {
            throw new IllegalArgumentException("config is not ImageCaptureConfig");
        }
        androidx.camera.core.impl.m mVar = (androidx.camera.core.impl.m) c2;
        BB0.a aVar2 = new BB0.a();
        if (mVar.b0()) {
            this.b.a(mVar.V(), aVar2);
        }
        aVar.e(aVar2.c());
    }
}
