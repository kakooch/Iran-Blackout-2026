package ir.appp.rghapp.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import ir.appp.rghapp.RGHMediaHelper$SavedFilterState;
import java.io.IOException;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class SSHOutputSurface implements SurfaceTexture.OnFrameAvailableListener {
    private boolean mFrameAvailable;
    private final Object mFrameSyncObject = new Object();
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private SSHTextureRenderer mTextureRender;

    public SSHOutputSurface(Context context, RGHMediaHelper$SavedFilterState rGHMediaHelper$SavedFilterState, String str, String str2, MediaController.CropState cropState, int i, int i2, int i3, int i4) throws IOException {
        SSHTextureRenderer sSHTextureRenderer = new SSHTextureRenderer(context, rGHMediaHelper$SavedFilterState, str, str2, cropState, i, i2, i3, i4);
        this.mTextureRender = sSHTextureRenderer;
        sSHTextureRenderer.surfaceCreated();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureRender.getTextureId());
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.mSurface = new Surface(this.mSurfaceTexture);
    }

    public void release() {
        this.mSurface.release();
        this.mTextureRender = null;
        this.mSurface = null;
        this.mSurfaceTexture = null;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void awaitNewImage() {
        synchronized (this.mFrameSyncObject) {
            while (!this.mFrameAvailable) {
                try {
                    this.mFrameSyncObject.wait(2500L);
                    if (!this.mFrameAvailable) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.mFrameAvailable = false;
        }
        this.mSurfaceTexture.updateTexImage();
    }

    public void drawImage() {
        this.mTextureRender.drawFrame(this.mSurfaceTexture);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mFrameSyncObject) {
            if (this.mFrameAvailable) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.mFrameAvailable = true;
            this.mFrameSyncObject.notifyAll();
        }
    }
}
