package com.google.android.exoplayer2t;

import com.google.android.exoplayer2t.source.TrackGroupArray;
import com.google.android.exoplayer2t.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2t.upstream.Allocator;

/* loaded from: classes.dex */
public interface LoadControl {
    Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j, float f);

    boolean shouldStartPlayback(long j, float f, boolean z);
}
