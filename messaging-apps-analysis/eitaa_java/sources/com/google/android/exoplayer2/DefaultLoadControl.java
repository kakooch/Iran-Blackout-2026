package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public class DefaultLoadControl implements LoadControl {
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean hasVideo;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferAudioUs;
    private final long minBufferVideoUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private final int targetBufferBytesOverwrite;
    private int targetBufferSize;

    @Deprecated
    public DefaultLoadControl(DefaultAllocator allocator, int minBufferMs, int maxBufferMs, int bufferForPlaybackMs, int bufferForPlaybackAfterRebufferMs, int targetBufferBytes, boolean prioritizeTimeOverSizeThresholds) {
        this(allocator, minBufferMs, minBufferMs, maxBufferMs, bufferForPlaybackMs, bufferForPlaybackAfterRebufferMs, targetBufferBytes, prioritizeTimeOverSizeThresholds, 0, false);
    }

    protected DefaultLoadControl(DefaultAllocator allocator, int minBufferAudioMs, int minBufferVideoMs, int maxBufferMs, int bufferForPlaybackMs, int bufferForPlaybackAfterRebufferMs, int targetBufferBytes, boolean prioritizeTimeOverSizeThresholds, int backBufferDurationMs, boolean retainBackBufferFromKeyframe) {
        assertGreaterOrEqual(bufferForPlaybackMs, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(bufferForPlaybackAfterRebufferMs, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(minBufferAudioMs, bufferForPlaybackMs, "minBufferAudioMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(minBufferVideoMs, bufferForPlaybackMs, "minBufferVideoMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(minBufferAudioMs, bufferForPlaybackAfterRebufferMs, "minBufferAudioMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(minBufferVideoMs, bufferForPlaybackAfterRebufferMs, "minBufferVideoMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(maxBufferMs, minBufferAudioMs, "maxBufferMs", "minBufferAudioMs");
        assertGreaterOrEqual(maxBufferMs, minBufferVideoMs, "maxBufferMs", "minBufferVideoMs");
        assertGreaterOrEqual(backBufferDurationMs, 0, "backBufferDurationMs", "0");
        this.allocator = allocator;
        this.minBufferAudioUs = C.msToUs(minBufferAudioMs);
        this.minBufferVideoUs = C.msToUs(minBufferVideoMs);
        this.maxBufferUs = C.msToUs(maxBufferMs);
        this.bufferForPlaybackUs = C.msToUs(bufferForPlaybackMs);
        this.bufferForPlaybackAfterRebufferUs = C.msToUs(bufferForPlaybackAfterRebufferMs);
        this.targetBufferBytesOverwrite = targetBufferBytes;
        this.prioritizeTimeOverSizeThresholds = prioritizeTimeOverSizeThresholds;
        this.backBufferDurationUs = C.msToUs(backBufferDurationMs);
        this.retainBackBufferFromKeyframe = retainBackBufferFromKeyframe;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] renderers, TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        this.hasVideo = hasVideo(renderers, trackSelections);
        int iCalculateTargetBufferSize = this.targetBufferBytesOverwrite;
        if (iCalculateTargetBufferSize == -1) {
            iCalculateTargetBufferSize = calculateTargetBufferSize(renderers, trackSelections);
        }
        this.targetBufferSize = iCalculateTargetBufferSize;
        this.allocator.setTargetBufferSize(iCalculateTargetBufferSize);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long bufferedDurationUs, float playbackSpeed) {
        boolean z = true;
        boolean z2 = this.allocator.getTotalBytesAllocated() >= this.targetBufferSize;
        long jMin = this.hasVideo ? this.minBufferVideoUs : this.minBufferAudioUs;
        if (playbackSpeed > 1.0f) {
            jMin = Math.min(Util.getMediaDurationForPlayoutDuration(jMin, playbackSpeed), this.maxBufferUs);
        }
        if (bufferedDurationUs < jMin) {
            if (!this.prioritizeTimeOverSizeThresholds && z2) {
                z = false;
            }
            this.isBuffering = z;
        } else if (bufferedDurationUs >= this.maxBufferUs || z2) {
            this.isBuffering = false;
        }
        return this.isBuffering;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long bufferedDurationUs, float playbackSpeed, boolean rebuffering) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(bufferedDurationUs, playbackSpeed);
        long j = rebuffering ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return j <= 0 || playoutDurationForMediaDuration >= j || (!this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferSize);
    }

    protected int calculateTargetBufferSize(Renderer[] renderers, TrackSelectionArray trackSelectionArray) {
        int defaultBufferSize = 0;
        for (int i = 0; i < renderers.length; i++) {
            if (trackSelectionArray.get(i) != null) {
                defaultBufferSize += getDefaultBufferSize(renderers[i].getTrackType());
            }
        }
        return defaultBufferSize;
    }

    private void reset(boolean resetAllocator) {
        this.targetBufferSize = 0;
        this.isBuffering = false;
        if (resetAllocator) {
            this.allocator.reset();
        }
    }

    private static int getDefaultBufferSize(int trackType) {
        switch (trackType) {
            case 0:
                return 36438016;
            case 1:
                return 3538944;
            case 2:
                return 32768000;
            case 3:
            case 4:
            case 5:
                return 131072;
            case 6:
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static boolean hasVideo(Renderer[] renderers, TrackSelectionArray trackSelectionArray) {
        for (int i = 0; i < renderers.length; i++) {
            if (renderers[i].getTrackType() == 2 && trackSelectionArray.get(i) != null) {
                return true;
            }
        }
        return false;
    }

    private static void assertGreaterOrEqual(int value1, int value2, String name1, String name2) {
        Assertions.checkArgument(value1 >= value2, name1 + " cannot be less than " + name2);
    }
}
