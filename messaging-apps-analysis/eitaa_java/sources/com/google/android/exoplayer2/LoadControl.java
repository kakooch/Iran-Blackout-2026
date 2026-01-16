package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;

/* loaded from: classes.dex */
public interface LoadControl {
    Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Renderer[] renderers, TrackGroupArray trackGroups, TrackSelectionArray trackSelections);

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long bufferedDurationUs, float playbackSpeed);

    boolean shouldStartPlayback(long bufferedDurationUs, float playbackSpeed, boolean rebuffering);
}
