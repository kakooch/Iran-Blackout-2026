package ir.nasim;

import java.io.Closeable;
import livekit.org.webrtc.SurfaceTextureHelper;

/* renamed from: ir.nasim.l37, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16313l37 implements Closeable {
    private final SurfaceTextureHelper a;
    private boolean b;

    public C16313l37(SurfaceTextureHelper surfaceTextureHelper) {
        this.a = surfaceTextureHelper;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        SurfaceTextureHelper surfaceTextureHelper = this.a;
        if (surfaceTextureHelper != null) {
            surfaceTextureHelper.stopListening();
        }
        SurfaceTextureHelper surfaceTextureHelper2 = this.a;
        if (surfaceTextureHelper2 != null) {
            surfaceTextureHelper2.dispose();
        }
    }
}
