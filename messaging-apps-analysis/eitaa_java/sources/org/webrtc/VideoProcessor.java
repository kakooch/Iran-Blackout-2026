package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoProcessor extends CapturerObserver {
    void onFrameCaptured(VideoFrame frame, FrameAdaptationParameters parameters);

    void setSink(VideoSink sink);

    public static class FrameAdaptationParameters {
        public final int cropHeight;
        public final int cropWidth;
        public final int cropX;
        public final int cropY;
        public final boolean drop;
        public final int scaleHeight;
        public final int scaleWidth;
        public final long timestampNs;

        public FrameAdaptationParameters(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight, long timestampNs, boolean drop) {
            this.cropX = cropX;
            this.cropY = cropY;
            this.cropWidth = cropWidth;
            this.cropHeight = cropHeight;
            this.scaleWidth = scaleWidth;
            this.scaleHeight = scaleHeight;
            this.timestampNs = timestampNs;
            this.drop = drop;
        }
    }

    /* renamed from: org.webrtc.VideoProcessor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFrameCaptured(VideoProcessor _this, VideoFrame videoFrame, FrameAdaptationParameters frameAdaptationParameters) {
            VideoFrame videoFrameApplyFrameAdaptationParameters = applyFrameAdaptationParameters(videoFrame, frameAdaptationParameters);
            if (videoFrameApplyFrameAdaptationParameters != null) {
                _this.onFrameCaptured(videoFrameApplyFrameAdaptationParameters);
                videoFrameApplyFrameAdaptationParameters.release();
            }
        }

        public static VideoFrame applyFrameAdaptationParameters(VideoFrame frame, FrameAdaptationParameters parameters) {
            if (parameters.drop) {
                return null;
            }
            return new VideoFrame(frame.getBuffer().cropAndScale(parameters.cropX, parameters.cropY, parameters.cropWidth, parameters.cropHeight, parameters.scaleWidth, parameters.scaleHeight), frame.getRotation(), parameters.timestampNs);
        }
    }
}
