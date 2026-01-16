package org.webrtc;

import org.webrtc.VideoDecoder;

/* loaded from: classes3.dex */
class VideoDecoderWrapper {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnDecodedFrame(long nativeVideoDecoderWrapper, VideoFrame frame, Integer decodeTimeMs, Integer qp);

    VideoDecoderWrapper() {
    }

    @CalledByNative
    static VideoDecoder.Callback createDecoderCallback(final long nativeDecoder) {
        return new VideoDecoder.Callback() { // from class: org.webrtc.-$$Lambda$VideoDecoderWrapper$3uw3mxtBT9cCv2VFxBjPGUCviXM
            @Override // org.webrtc.VideoDecoder.Callback
            public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
                VideoDecoderWrapper.nativeOnDecodedFrame(nativeDecoder, videoFrame, num, num2);
            }
        };
    }
}
