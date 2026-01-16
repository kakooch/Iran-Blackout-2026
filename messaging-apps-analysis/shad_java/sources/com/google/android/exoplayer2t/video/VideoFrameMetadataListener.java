package com.google.android.exoplayer2t.video;

import android.media.MediaFormat;
import com.google.android.exoplayer2t.Format;

/* loaded from: classes.dex */
public interface VideoFrameMetadataListener {
    void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat);
}
