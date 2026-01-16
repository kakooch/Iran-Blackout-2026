package androidx.camera.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class k extends e {
    private final AtomicBoolean d;

    k(f fVar) {
        super(fVar);
        this.d = new AtomicBoolean(false);
    }

    @Override // androidx.camera.core.e, androidx.camera.core.f, java.lang.AutoCloseable
    public void close() {
        if (this.d.getAndSet(true)) {
            return;
        }
        super.close();
    }
}
