package ir.nasim;

import android.graphics.SurfaceTexture;
import ir.nasim.tgwidgets.editor.messenger.camera.CameraView;

/* renamed from: ir.nasim.eE0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final /* synthetic */ class C12212eE0 implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ CameraView.e a;

    public /* synthetic */ C12212eE0(CameraView.e eVar) {
        this.a = eVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.a.M(surfaceTexture);
    }
}
