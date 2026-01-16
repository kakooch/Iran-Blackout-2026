package livekit.org.webrtc;

import livekit.org.webrtc.VideoFrame;
import livekit.org.webrtc.VideoProcessor;

/* loaded from: classes8.dex */
class NativeCapturerObserver implements CapturerObserver {
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;

    @CalledByNative
    public NativeCapturerObserver(long j) {
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j);
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z) {
        this.nativeAndroidVideoTrackSource.setState(z);
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        this.nativeAndroidVideoTrackSource.setState(false);
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        VideoProcessor.FrameAdaptationParameters frameAdaptationParametersAdaptFrame = this.nativeAndroidVideoTrackSource.adaptFrame(videoFrame);
        if (frameAdaptationParametersAdaptFrame == null) {
            return;
        }
        VideoFrame.Buffer bufferCropAndScale = videoFrame.getBuffer().cropAndScale(frameAdaptationParametersAdaptFrame.cropX, frameAdaptationParametersAdaptFrame.cropY, frameAdaptationParametersAdaptFrame.cropWidth, frameAdaptationParametersAdaptFrame.cropHeight, frameAdaptationParametersAdaptFrame.scaleWidth, frameAdaptationParametersAdaptFrame.scaleHeight);
        this.nativeAndroidVideoTrackSource.onFrameCaptured(new VideoFrame(bufferCropAndScale, videoFrame.getRotation(), frameAdaptationParametersAdaptFrame.timestampNs));
        bufferCropAndScale.release();
    }
}
