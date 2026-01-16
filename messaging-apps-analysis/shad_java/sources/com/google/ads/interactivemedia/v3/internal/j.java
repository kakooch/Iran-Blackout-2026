package com.google.ads.interactivemedia.v3.internal;

import org.webrtc.MediaStreamTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public enum j {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MediaStreamTrack.VIDEO_TRACK_KIND),
    AUDIO(MediaStreamTrack.AUDIO_TRACK_KIND);

    private final String f;

    j(String str) {
        this.f = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f;
    }
}
