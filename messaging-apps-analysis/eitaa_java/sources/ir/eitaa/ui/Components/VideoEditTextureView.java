package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import ir.eitaa.ui.Components.FilterGLThread;

/* loaded from: classes3.dex */
public class VideoEditTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private VideoPlayer currentVideoPlayer;
    private VideoEditTextureViewDelegate delegate;
    private FilterGLThread eglThread;
    private int videoHeight;
    private int videoWidth;
    private Rect viewRect;

    public interface VideoEditTextureViewDelegate {
        void onEGLThreadAvailable(FilterGLThread eglThread);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    public VideoEditTextureView(Context context, VideoPlayer videoPlayer) {
        super(context);
        this.viewRect = new Rect();
        this.currentVideoPlayer = videoPlayer;
        setSurfaceTextureListener(this);
    }

    public void setDelegate(VideoEditTextureViewDelegate videoEditTextureViewDelegate) {
        this.delegate = videoEditTextureViewDelegate;
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            if (videoEditTextureViewDelegate == null) {
                filterGLThread.setFilterGLThreadDelegate(null);
            } else {
                videoEditTextureViewDelegate.onEGLThreadAvailable(filterGLThread);
            }
        }
    }

    public void setVideoSize(int width, int height) {
        this.videoWidth = width;
        this.videoHeight = height;
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread == null) {
            return;
        }
        filterGLThread.setVideoSize(width, height);
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        int i;
        if (this.eglThread != null || surface == null || this.currentVideoPlayer == null) {
            return;
        }
        FilterGLThread filterGLThread = new FilterGLThread(surface, new FilterGLThread.FilterGLThreadVideoDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoEditTextureView$4Mp2_xQmTO2wE2E2nbPv44zTuVM
            @Override // ir.eitaa.ui.Components.FilterGLThread.FilterGLThreadVideoDelegate
            public final void onVideoSurfaceCreated(SurfaceTexture surfaceTexture) {
                this.f$0.lambda$onSurfaceTextureAvailable$0$VideoEditTextureView(surfaceTexture);
            }
        });
        this.eglThread = filterGLThread;
        int i2 = this.videoWidth;
        if (i2 != 0 && (i = this.videoHeight) != 0) {
            filterGLThread.setVideoSize(i2, i);
        }
        this.eglThread.setSurfaceTextureSize(width, height);
        this.eglThread.requestRender(true, true, false);
        VideoEditTextureViewDelegate videoEditTextureViewDelegate = this.delegate;
        if (videoEditTextureViewDelegate != null) {
            videoEditTextureViewDelegate.onEGLThreadAvailable(this.eglThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onSurfaceTextureAvailable$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onSurfaceTextureAvailable$0$VideoEditTextureView(SurfaceTexture surfaceTexture) {
        if (this.currentVideoPlayer == null) {
            return;
        }
        this.currentVideoPlayer.setSurface(new Surface(surfaceTexture));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, final int width, final int height) {
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.setSurfaceTextureSize(width, height);
            this.eglThread.requestRender(false, true, false);
            this.eglThread.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoEditTextureView$s4JihEnlNhlAbJsDQB6Ik38mfM4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSurfaceTextureSizeChanged$1$VideoEditTextureView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onSurfaceTextureSizeChanged$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onSurfaceTextureSizeChanged$1$VideoEditTextureView() {
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(false, true, false);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread == null) {
            return true;
        }
        filterGLThread.shutdown();
        this.eglThread = null;
        return true;
    }

    public void release() {
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.shutdown();
        }
        this.currentVideoPlayer = null;
    }

    public void setViewRect(float x, float y, float w, float h) {
        Rect rect = this.viewRect;
        rect.x = x;
        rect.y = y;
        rect.width = w;
        rect.height = h;
    }

    public boolean containsPoint(float x, float y) {
        Rect rect = this.viewRect;
        float f = rect.x;
        if (x >= f && x <= f + rect.width) {
            float f2 = rect.y;
            if (y >= f2 && y <= f2 + rect.height) {
                return true;
            }
        }
        return false;
    }
}
