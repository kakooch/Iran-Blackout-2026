package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import ir.appp.rghapp.rubinoPostSlider.FilterGLThread;
import ir.resaneh1.iptv.logger.MyLog;
import org.rbmain.ui.Components.Rect;

/* loaded from: classes3.dex */
public class VideoEditTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private VideoPlayer currentVideoPlayer;
    private VideoEditTextureViewDelegate delegate;
    private FilterGLThread eglThread;
    private SurfaceTexture surfaceTexture;
    private int videoHeight;
    private Surface videoSurface;
    private int videoWidth;

    public interface VideoEditTextureViewDelegate {
        void onEGLThreadAvailable(FilterGLThread filterGLThread);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public VideoEditTextureView(Context context, VideoPlayer videoPlayer) {
        super(context);
        new Rect();
        MyLog.e("VideoEditTextureView", "instance created");
        this.currentVideoPlayer = videoPlayer;
        setSurfaceTextureListener(this);
    }

    public void setDelegate(VideoEditTextureViewDelegate videoEditTextureViewDelegate) {
        this.delegate = videoEditTextureViewDelegate;
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread == null || videoEditTextureViewDelegate == null) {
            return;
        }
        videoEditTextureViewDelegate.onEGLThreadAvailable(filterGLThread);
    }

    public void setVideoSize(int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread == null) {
            return;
        }
        filterGLThread.setVideoSize(i, i2);
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        int i3;
        MyLog.e("VideoEditTextureView", "onSurfaceTextureAvailable - w = " + i + " - h = " + i2);
        if (this.eglThread != null || surfaceTexture == null || this.currentVideoPlayer == null) {
            return;
        }
        FilterGLThread filterGLThread = new FilterGLThread(this.currentVideoPlayer, surfaceTexture, new FilterGLThread.FilterGLThreadVideoDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView$$ExternalSyntheticLambda0
            @Override // ir.appp.rghapp.rubinoPostSlider.FilterGLThread.FilterGLThreadVideoDelegate
            public final void onVideoSurfaceCreated(SurfaceTexture surfaceTexture2) {
                this.f$0.lambda$onSurfaceTextureAvailable$0(surfaceTexture2);
            }
        });
        this.eglThread = filterGLThread;
        int i4 = this.videoWidth;
        if (i4 != 0 && (i3 = this.videoHeight) != 0) {
            filterGLThread.setVideoSize(i4, i3);
        }
        this.eglThread.setSurfaceTextureSize(i, i2);
        this.eglThread.requestRender(true, false);
        VideoEditTextureViewDelegate videoEditTextureViewDelegate = this.delegate;
        if (videoEditTextureViewDelegate != null) {
            videoEditTextureViewDelegate.onEGLThreadAvailable(this.eglThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSurfaceTextureAvailable$0(SurfaceTexture surfaceTexture) {
        if (this.currentVideoPlayer == null) {
            return;
        }
        this.surfaceTexture = surfaceTexture;
        Surface surface = new Surface(this.surfaceTexture);
        this.videoSurface = surface;
        this.currentVideoPlayer.setSurface(surface);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        MyLog.e("VideoEditTextureView", "onSurfaceTextureSizeChanged");
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.setSurfaceTextureSize(i, i2);
            this.eglThread.requestRender(true, false);
            this.eglThread.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSurfaceTextureSizeChanged$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSurfaceTextureSizeChanged$1() {
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(true, false);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
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
        try {
            VideoPlayer videoPlayer = this.currentVideoPlayer;
            if (videoPlayer != null) {
                videoPlayer.setSurface(null);
                this.currentVideoPlayer.releasePlayer();
                this.currentVideoPlayer = null;
            }
            this.videoSurface.release();
            try {
                SurfaceTexture surfaceTexture = this.surfaceTexture;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.surfaceTexture.setOnFrameAvailableListener(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public FilterGLThread getEglThread() {
        return this.eglThread;
    }
}
