package org.webrtc;

import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;

/* loaded from: classes3.dex */
public class NativeCapturerObserver implements CapturerObserver {
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;

    @CalledByNative
    public NativeCapturerObserver(long nativeSource) {
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(nativeSource);
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean success) {
        this.nativeAndroidVideoTrackSource.setState(success);
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        this.nativeAndroidVideoTrackSource.setState(false);
    }

    public NativeAndroidVideoTrackSource getNativeAndroidVideoTrackSource() {
        return this.nativeAndroidVideoTrackSource;
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame frame) {
        VideoProcessor.FrameAdaptationParameters frameAdaptationParametersAdaptFrame = this.nativeAndroidVideoTrackSource.adaptFrame(frame);
        if (frameAdaptationParametersAdaptFrame == null || frameAdaptationParametersAdaptFrame.cropWidth == 0 || frameAdaptationParametersAdaptFrame.cropHeight == 0) {
            return;
        }
        VideoFrame.Buffer bufferCropAndScale = frame.getBuffer().cropAndScale(frameAdaptationParametersAdaptFrame.cropX, frameAdaptationParametersAdaptFrame.cropY, frameAdaptationParametersAdaptFrame.cropWidth, frameAdaptationParametersAdaptFrame.cropHeight, frameAdaptationParametersAdaptFrame.scaleWidth, frameAdaptationParametersAdaptFrame.scaleHeight);
        this.nativeAndroidVideoTrackSource.onFrameCaptured(new VideoFrame(bufferCropAndScale, frame.getRotation(), frameAdaptationParametersAdaptFrame.timestampNs));
        bufferCropAndScale.release();
    }
}
