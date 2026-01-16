package org.webrtc;

import org.webrtc.VideoProcessor;
import org.webrtc.VideoSink;

/* loaded from: classes3.dex */
public class VideoSource extends MediaSource {
    private final CapturerObserver capturerObserver;
    private boolean isCapturerRunning;
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;
    private VideoProcessor videoProcessor;
    private final Object videoProcessorLock;

    public static class AspectRatio {
        public static final AspectRatio UNDEFINED = new AspectRatio(0, 0);
        public final int height;
        public final int width;

        public AspectRatio(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public VideoSource(long nativeSource) {
        super(nativeSource);
        this.videoProcessorLock = new Object();
        this.capturerObserver = new CapturerObserver() { // from class: org.webrtc.VideoSource.1
            @Override // org.webrtc.CapturerObserver
            public void onCapturerStarted(boolean success) {
                VideoSource.this.nativeAndroidVideoTrackSource.setState(success);
                synchronized (VideoSource.this.videoProcessorLock) {
                    VideoSource.this.isCapturerRunning = success;
                    if (VideoSource.this.videoProcessor != null) {
                        VideoSource.this.videoProcessor.onCapturerStarted(success);
                    }
                }
            }

            @Override // org.webrtc.CapturerObserver
            public void onCapturerStopped() {
                VideoSource.this.nativeAndroidVideoTrackSource.setState(false);
                synchronized (VideoSource.this.videoProcessorLock) {
                    VideoSource.this.isCapturerRunning = false;
                    if (VideoSource.this.videoProcessor != null) {
                        VideoSource.this.videoProcessor.onCapturerStopped();
                    }
                }
            }

            @Override // org.webrtc.CapturerObserver
            public void onFrameCaptured(VideoFrame frame) {
                VideoProcessor.FrameAdaptationParameters frameAdaptationParametersAdaptFrame = VideoSource.this.nativeAndroidVideoTrackSource.adaptFrame(frame);
                synchronized (VideoSource.this.videoProcessorLock) {
                    if (VideoSource.this.videoProcessor != null) {
                        VideoSource.this.videoProcessor.onFrameCaptured(frame, frameAdaptationParametersAdaptFrame);
                        return;
                    }
                    VideoFrame videoFrameApplyFrameAdaptationParameters = VideoProcessor.CC.applyFrameAdaptationParameters(frame, frameAdaptationParametersAdaptFrame);
                    if (videoFrameApplyFrameAdaptationParameters != null) {
                        VideoSource.this.nativeAndroidVideoTrackSource.onFrameCaptured(videoFrameApplyFrameAdaptationParameters);
                        videoFrameApplyFrameAdaptationParameters.release();
                    }
                }
            }
        };
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(nativeSource);
    }

    public void adaptOutputFormat(int width, int height, int fps) {
        int iMax = Math.max(width, height);
        int iMin = Math.min(width, height);
        adaptOutputFormat(iMax, iMin, iMin, iMax, fps);
    }

    public void adaptOutputFormat(int landscapeWidth, int landscapeHeight, int portraitWidth, int portraitHeight, int fps) {
        adaptOutputFormat(new AspectRatio(landscapeWidth, landscapeHeight), Integer.valueOf(landscapeWidth * landscapeHeight), new AspectRatio(portraitWidth, portraitHeight), Integer.valueOf(portraitWidth * portraitHeight), Integer.valueOf(fps));
    }

    public void adaptOutputFormat(AspectRatio targetLandscapeAspectRatio, Integer maxLandscapePixelCount, AspectRatio targetPortraitAspectRatio, Integer maxPortraitPixelCount, Integer maxFps) {
        this.nativeAndroidVideoTrackSource.adaptOutputFormat(targetLandscapeAspectRatio, maxLandscapePixelCount, targetPortraitAspectRatio, maxPortraitPixelCount, maxFps);
    }

    public void setIsScreencast(boolean isScreencast) {
        this.nativeAndroidVideoTrackSource.setIsScreencast(isScreencast);
    }

    public void setVideoProcessor(VideoProcessor newVideoProcessor) {
        synchronized (this.videoProcessorLock) {
            VideoProcessor videoProcessor = this.videoProcessor;
            if (videoProcessor != null) {
                videoProcessor.setSink(null);
                if (this.isCapturerRunning) {
                    this.videoProcessor.onCapturerStopped();
                }
            }
            this.videoProcessor = newVideoProcessor;
            if (newVideoProcessor != null) {
                newVideoProcessor.setSink(new VideoSink() { // from class: org.webrtc.-$$Lambda$VideoSource$YyLxKFoSqQqCiEUmK7972bOrjFc
                    @Override // org.webrtc.VideoSink
                    public final void onFrame(VideoFrame videoFrame) {
                        this.f$0.lambda$setVideoProcessor$1$VideoSource(videoFrame);
                    }

                    @Override // org.webrtc.VideoSink
                    public /* synthetic */ void setParentSink(VideoSink videoSink) {
                        VideoSink.CC.$default$setParentSink(this, videoSink);
                    }
                });
                if (this.isCapturerRunning) {
                    newVideoProcessor.onCapturerStarted(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setVideoProcessor$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setVideoProcessor$0$VideoSource(VideoFrame videoFrame) {
        this.nativeAndroidVideoTrackSource.onFrameCaptured(videoFrame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setVideoProcessor$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setVideoProcessor$1$VideoSource(final VideoFrame videoFrame) {
        runWithReference(new Runnable() { // from class: org.webrtc.-$$Lambda$VideoSource$SVhlCGU_3fBAjlvWXyIaT4PIyC0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setVideoProcessor$0$VideoSource(videoFrame);
            }
        });
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }

    @Override // org.webrtc.MediaSource
    public void dispose() {
        setVideoProcessor(null);
        super.dispose();
    }
}
