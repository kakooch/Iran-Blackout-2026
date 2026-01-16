package com.google.android.exoplayer2.video;

/* loaded from: classes.dex */
public interface VideoListener {

    /* renamed from: com.google.android.exoplayer2.video.VideoListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onSurfaceSizeChanged(VideoListener videoListener, int i, int i2) {
        }
    }

    void onRenderedFirstFrame();

    void onSurfaceSizeChanged(int i, int i2);

    void onVideoSizeChanged(int i, int i2, int i3, float f);
}
