package com.google.android.exoplayer2t.trackselection;

import com.google.android.exoplayer2t.ExoPlaybackException;
import com.google.android.exoplayer2t.RendererCapabilities;
import com.google.android.exoplayer2t.Timeline;
import com.google.android.exoplayer2t.source.MediaSource;
import com.google.android.exoplayer2t.source.TrackGroupArray;
import com.google.android.exoplayer2t.upstream.BandwidthMeter;
import com.google.android.exoplayer2t.util.Assertions;

/* loaded from: classes.dex */
public abstract class TrackSelector {
    private BandwidthMeter bandwidthMeter;

    public interface InvalidationListener {
    }

    public abstract void onSelectionActivated(Object obj);

    public abstract TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;

    public final void init(InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        this.bandwidthMeter = bandwidthMeter;
    }

    protected final BandwidthMeter getBandwidthMeter() {
        return (BandwidthMeter) Assertions.checkNotNull(this.bandwidthMeter);
    }
}
