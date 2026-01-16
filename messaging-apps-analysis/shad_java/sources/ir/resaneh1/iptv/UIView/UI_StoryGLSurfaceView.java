package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.exoplayer2t.ExoPlayerFactory;
import com.google.android.exoplayer2t.SimpleExoPlayer;
import com.google.android.exoplayer2t.source.ExtractorMediaSource;
import com.google.android.exoplayer2t.source.LoopingMediaSource;
import com.google.android.exoplayer2t.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2t.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2t.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2t.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2t.util.Util;
import ir.appp.rghapp.GLMediaRenderer;
import ir.appp.rghapp.RGHFilter;
import ir.appp.rghapp.Utils;
import ir.appp.rghapp.rubinoPostSlider.FilterGLThread;
import ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView;
import ir.appp.rghapp.rubinoPostSlider.VideoPlayer;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.StoryObject;
import java.io.File;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class UI_StoryGLSurfaceView implements VideoPlayer.VideoPlayerDelegate {
    public Context context;
    private RGHFilter currentFilter;
    private StoryObject currentStoryObject;
    private FilterGLThread eglThread;
    private FrameLayout frameLayout;
    private GLMediaRenderer glRenderer;
    private GLSurfaceView glSurfaceView;
    public ImageView imageViewFiltered;
    public ImageView imageViewOverLay;
    private int lastRnd = -1;
    private VideoEditTextureView mediaTextureView;
    private VideoPlayer videoPlayer;
    public View view;

    @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
    public void onError(VideoPlayer videoPlayer, Exception exc) {
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
    public void onRenderedFirstFrame() {
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
    public void onStateChanged(boolean z, int i, boolean z2) {
    }

    public View createView(Context context) {
        this.context = context;
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        if (Utils.useNewStoryCreationSystem()) {
            ImageView imageView = new ImageView(context);
            this.imageViewFiltered = imageView;
            this.frameLayout.addView(imageView, LayoutHelper.createFrame(-1, -1, 17));
            this.imageViewFiltered.setVisibility(8);
        }
        ImageView imageView2 = new ImageView(context);
        this.imageViewOverLay = imageView2;
        this.frameLayout.addView(imageView2, LayoutHelper.createFrame(-1, -1, 17));
        return this.view;
    }

    private void preparePlayer(String str) {
        if (Utils.useNewStoryCreationSystem()) {
            this.videoPlayer.preparePlayer(Uri.fromFile(new File(str)), "other");
            this.videoPlayer.setLooping(true);
            this.videoPlayer.setPlayWhenReady(true);
            this.videoPlayer.seekTo(this.currentStoryObject.glSceneState.getVideoPlaybackStartTime());
            return;
        }
        Context context = this.context;
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getString(R.string.app_name)));
        SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(this.context, new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
        simpleExoPlayerNewSimpleInstance.prepare(new LoopingMediaSource(new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(str))));
        simpleExoPlayerNewSimpleInstance.setPlayWhenReady(true);
        this.glRenderer.setExoMediaPlayer(simpleExoPlayerNewSimpleInstance);
    }

    public void onBindGl(StoryObject storyObject) {
        if (storyObject == null || storyObject.glSceneState == null) {
            return;
        }
        this.currentStoryObject = storyObject;
        Bitmap bitmap = storyObject.overlay;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.imageViewOverLay.setVisibility(0);
            this.imageViewOverLay.setImageBitmap(storyObject.overlay);
            Bitmap bitmap2 = storyObject.lastOverlay;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
        } else {
            this.imageViewOverLay.setVisibility(8);
        }
        if (Utils.useNewStoryCreationSystem()) {
            initGl(storyObject.localFilePathBeforeSave, storyObject.story_type == StoryObject.StoryTypeEnum.Video);
            int i = storyObject.rnd;
            if (i != this.lastRnd) {
                this.lastRnd = i;
                return;
            }
            return;
        }
        if (this.glRenderer == null) {
            initGl(storyObject.localFilePathBeforeSave, storyObject.story_type == StoryObject.StoryTypeEnum.Video, storyObject.rghFilter, storyObject.overlay, storyObject.backgroundImagePath);
            this.lastRnd = storyObject.rnd;
        }
        int i2 = storyObject.rnd;
        if (i2 != this.lastRnd) {
            this.lastRnd = i2;
            this.glRenderer.destroyGLComponents(false);
            if (!storyObject.glSceneState.isImageMedia()) {
                preparePlayer(storyObject.glSceneState.getMediaPath());
            }
            this.glRenderer.loadSceneFromState(storyObject.glSceneState);
        }
    }

    public void initGl(String str, boolean z, RGHFilter rGHFilter, Bitmap bitmap, String str2) {
        this.currentFilter = rGHFilter;
        GLSurfaceView gLSurfaceView = new GLSurfaceView(this.context);
        this.glSurfaceView = gLSurfaceView;
        this.frameLayout.addView(gLSurfaceView, 0, LayoutHelper.createFrame(-1, -1, 17));
        this.glSurfaceView.setEGLContextClientVersion(2);
        this.glSurfaceView.setPreserveEGLContextOnPause(true);
        GLMediaRenderer gLMediaRenderer = new GLMediaRenderer(this.context, str, !z);
        this.glRenderer = gLMediaRenderer;
        gLMediaRenderer.setMaxScreenWidth((int) DimensionHelper.getStoryViewWidthPx((Activity) this.context));
        this.glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.glSurfaceView.setRenderer(this.glRenderer);
        this.glRenderer.setGlSurfaceView(this.glSurfaceView);
        this.glSurfaceView.setRenderMode(1);
        this.glRenderer.setMediaCoordinationInfo(this.currentFilter.getOutputScaleWidth(), this.currentFilter.getOutputScaleHeight(), this.currentFilter.getxPosInContainer(), this.currentFilter.getyPosInContainer(), this.currentFilter.getRotationAngle());
        this.glRenderer.setFilterType(this.currentFilter.getFilterType());
        this.glRenderer.setSaturation(this.currentFilter.getSaturation());
        this.glRenderer.setContrast(this.currentFilter.getContrast());
        this.glRenderer.setBrightness(this.currentFilter.getBrightness());
        this.glRenderer.setNextFilterValues(this.currentFilter.getSaturationNext(), this.currentFilter.getContrastNext(), this.currentFilter.getBrightnessNext());
        if (this.currentFilter.isTrimEnabled()) {
            this.glRenderer.setVideoTimeLimit(this.currentFilter.getTrimStart(), this.currentFilter.getTrimEnd());
        }
        Context context = this.context;
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getString(R.string.app_name)));
        new DefaultBandwidthMeter();
        SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(this.context, new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
        simpleExoPlayerNewSimpleInstance.setPlayWhenReady(true);
        simpleExoPlayerNewSimpleInstance.prepare(new LoopingMediaSource(new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(str))));
        simpleExoPlayerNewSimpleInstance.setPlayWhenReady(true);
        this.glRenderer.setExoMediaPlayer(simpleExoPlayerNewSimpleInstance);
    }

    public void initGl(String str, boolean z) {
        if (z) {
            if (this.imageViewFiltered.getVisibility() == 0) {
                this.imageViewFiltered.setImageBitmap(null);
                this.imageViewFiltered.setVisibility(8);
            }
            if (this.videoPlayer == null) {
                VideoPlayer videoPlayer = new VideoPlayer();
                this.videoPlayer = videoPlayer;
                videoPlayer.setDelegate(this);
                VideoEditTextureView videoEditTextureView = new VideoEditTextureView(this.context, this.videoPlayer);
                this.mediaTextureView = videoEditTextureView;
                videoEditTextureView.setDelegate(new VideoEditTextureView.VideoEditTextureViewDelegate() { // from class: ir.resaneh1.iptv.UIView.UI_StoryGLSurfaceView$$ExternalSyntheticLambda0
                    @Override // ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView.VideoEditTextureViewDelegate
                    public final void onEGLThreadAvailable(FilterGLThread filterGLThread) {
                        this.f$0.lambda$initGl$0(filterGLThread);
                    }
                });
                this.mediaTextureView.setPivotX(0.0f);
                this.mediaTextureView.setPivotY(0.0f);
                this.mediaTextureView.setOpaque(false);
                this.frameLayout.addView(this.mediaTextureView, 0, LayoutHelper.createFrame(-1, -1, 17));
            } else {
                this.mediaTextureView.setVisibility(0);
            }
            preparePlayer(str);
            return;
        }
        VideoPlayer videoPlayer2 = this.videoPlayer;
        if (videoPlayer2 != null) {
            videoPlayer2.pause();
            this.mediaTextureView.setVisibility(8);
        }
        Bitmap bitmap = this.currentStoryObject.filteredBitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            this.imageViewFiltered.setImageBitmap(this.currentStoryObject.filteredBitmap);
        }
        this.imageViewFiltered.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGl$0(FilterGLThread filterGLThread) {
        this.eglThread = filterGLThread;
    }

    private void glSceneOnStartPreparation() {
        try {
            if (isRendererAvailable()) {
                this.eglThread.getFilterShader().loadSceneFromState(this.currentStoryObject.glSceneState);
                this.eglThread.getFilterShader().setFilterType(this.currentStoryObject.rghFilter.getFilterType());
                this.eglThread.getFilterShader().setVideoTimeLimit(this.currentStoryObject.glSceneState.getVideoPlaybackStartTime(), this.currentStoryObject.glSceneState.getVideoPlaybackEndTime());
            }
        } catch (Exception unused) {
        }
    }

    private boolean isRendererAvailable() {
        FilterGLThread filterGLThread;
        return Utils.useNewStoryCreationSystem() ? (this.mediaTextureView == null || (filterGLThread = this.eglThread) == null || filterGLThread.getFilterShader() == null) ? false : true : this.glRenderer != null;
    }

    public void onPause() {
        if (isRendererAvailable()) {
            if (Utils.useNewStoryCreationSystem()) {
                this.eglThread.getFilterShader().pauseMediaPlayback();
                return;
            }
            this.glRenderer.pauseMediaPlayback();
            GLSurfaceView gLSurfaceView = this.glSurfaceView;
            if (gLSurfaceView != null) {
                gLSurfaceView.onPause();
            }
        }
    }

    public void onResume() {
        if (isRendererAvailable()) {
            if (Utils.useNewStoryCreationSystem()) {
                this.eglThread.getFilterShader().resumeMediaPlayback();
            } else {
                this.glSurfaceView.onResume();
                this.glRenderer.resumeMediaPlayback();
            }
        }
    }

    public void onDestroy() {
        if (isRendererAvailable()) {
            if (Utils.useNewStoryCreationSystem()) {
                VideoEditTextureView videoEditTextureView = this.mediaTextureView;
                if (videoEditTextureView != null) {
                    this.frameLayout.removeView(videoEditTextureView);
                    this.mediaTextureView.release();
                    this.mediaTextureView = null;
                    this.eglThread.shutdown();
                    this.eglThread = null;
                    this.videoPlayer.releasePlayer();
                    this.videoPlayer = null;
                    return;
                }
                return;
            }
            this.glRenderer.destroyGLComponents(true);
        }
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        VideoEditTextureView videoEditTextureView = this.mediaTextureView;
        if (videoEditTextureView != null) {
            videoEditTextureView.setVideoSize((int) (i * f), i2);
        }
        glSceneOnStartPreparation();
    }
}
