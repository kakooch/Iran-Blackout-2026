package org.webrtc;

import ir.eitaa.messenger.MediaController;

/* loaded from: classes3.dex */
enum VideoCodecMimeType {
    VP8("video/x-vnd.on2.vp8"),
    VP9("video/x-vnd.on2.vp9"),
    H264(MediaController.VIDEO_MIME_TYPE),
    H265("video/hevc"),
    AV1("video/av01");

    private final String mimeType;

    VideoCodecMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    String mimeType() {
        return this.mimeType;
    }
}
