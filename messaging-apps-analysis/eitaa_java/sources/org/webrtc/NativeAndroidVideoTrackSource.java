package org.webrtc;

import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoSource;

/* loaded from: classes3.dex */
public class NativeAndroidVideoTrackSource {
    private final long nativeAndroidVideoTrackSource;

    private static native VideoProcessor.FrameAdaptationParameters nativeAdaptFrame(long nativeAndroidVideoTrackSource, int width, int height, int rotation, long timestampNs);

    private static native void nativeAdaptOutputFormat(long nativeAndroidVideoTrackSource, int landscapeWidth, int landscapeHeight, Integer maxLandscapePixelCount, int portraitWidth, int portraitHeight, Integer maxPortraitPixelCount, Integer maxFps);

    private static native void nativeOnFrameCaptured(long nativeAndroidVideoTrackSource, int rotation, long timestampNs, VideoFrame.Buffer buffer);

    private static native void nativeSetIsScreencast(long nativeAndroidVideoTrackSource, boolean isScreencast);

    private static native void nativeSetState(long nativeAndroidVideoTrackSource, boolean isLive);

    public NativeAndroidVideoTrackSource(long nativeAndroidVideoTrackSource) {
        this.nativeAndroidVideoTrackSource = nativeAndroidVideoTrackSource;
    }

    public void setState(boolean isLive) {
        nativeSetState(this.nativeAndroidVideoTrackSource, isLive);
    }

    public VideoProcessor.FrameAdaptationParameters adaptFrame(VideoFrame frame) {
        return nativeAdaptFrame(this.nativeAndroidVideoTrackSource, frame.getBuffer().getWidth(), frame.getBuffer().getHeight(), frame.getRotation(), frame.getTimestampNs());
    }

    public void onFrameCaptured(VideoFrame frame) {
        nativeOnFrameCaptured(this.nativeAndroidVideoTrackSource, frame.getRotation(), frame.getTimestampNs(), frame.getBuffer());
    }

    public void adaptOutputFormat(VideoSource.AspectRatio targetLandscapeAspectRatio, Integer maxLandscapePixelCount, VideoSource.AspectRatio targetPortraitAspectRatio, Integer maxPortraitPixelCount, Integer maxFps) {
        nativeAdaptOutputFormat(this.nativeAndroidVideoTrackSource, targetLandscapeAspectRatio.width, targetLandscapeAspectRatio.height, maxLandscapePixelCount, targetPortraitAspectRatio.width, targetPortraitAspectRatio.height, maxPortraitPixelCount, maxFps);
    }

    public void setIsScreencast(boolean isScreencast) {
        nativeSetIsScreencast(this.nativeAndroidVideoTrackSource, isScreencast);
    }

    @CalledByNative
    static VideoProcessor.FrameAdaptationParameters createFrameAdaptationParameters(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight, long timestampNs, boolean drop) {
        return new VideoProcessor.FrameAdaptationParameters(cropX, cropY, cropWidth, cropHeight, scaleWidth, scaleHeight, timestampNs, drop);
    }
}
