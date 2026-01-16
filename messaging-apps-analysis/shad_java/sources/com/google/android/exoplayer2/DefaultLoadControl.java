package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes.dex */
public class DefaultLoadControl implements LoadControl {
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferBytes;
    private final int targetBufferBytesOverwrite;

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, MessagesController.UPDATE_MASK_CHECK));
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(defaultAllocator, i, i2, i3, i4, i5, z, 0, false);
    }

    protected DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        assertGreaterOrEqual(i3, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i, i3, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i2, i, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(i6, 0, "backBufferDurationMs", "0");
        this.allocator = defaultAllocator;
        this.minBufferUs = C.msToUs(i);
        this.maxBufferUs = C.msToUs(i2);
        this.bufferForPlaybackUs = C.msToUs(i3);
        this.bufferForPlaybackAfterRebufferUs = C.msToUs(i4);
        this.targetBufferBytesOverwrite = i5;
        this.targetBufferBytes = i5 == -1 ? 13107200 : i5;
        this.prioritizeTimeOverSizeThresholds = z;
        this.backBufferDurationUs = C.msToUs(i6);
        this.retainBackBufferFromKeyframe = z2;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        int iCalculateTargetBufferBytes = this.targetBufferBytesOverwrite;
        if (iCalculateTargetBufferBytes == -1) {
            iCalculateTargetBufferBytes = calculateTargetBufferBytes(rendererArr, trackSelectionArray);
        }
        this.targetBufferBytes = iCalculateTargetBufferBytes;
        this.allocator.setTargetBufferSize(iCalculateTargetBufferBytes);
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
    public boolean shouldContinueLoading(long j, long j2, float f) {
        boolean z = true;
        boolean z2 = this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes;
        long jMin = this.minBufferUs;
        if (f > 1.0f) {
            jMin = Math.min(Util.getMediaDurationForPlayoutDuration(jMin, f), this.maxBufferUs);
        }
        if (j2 < Math.max(jMin, 500000L)) {
            if (!this.prioritizeTimeOverSizeThresholds && z2) {
                z = false;
            }
            this.isBuffering = z;
            if (!z && j2 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.maxBufferUs || z2) {
            this.isBuffering = false;
        }
        return this.isBuffering;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j, float f, boolean z) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j, f);
        long j2 = z ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return j2 <= 0 || playoutDurationForMediaDuration >= j2 || (!this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes);
    }

    protected int calculateTargetBufferBytes(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int defaultBufferSize = 0;
        for (int i = 0; i < rendererArr.length; i++) {
            if (trackSelectionArray.get(i) != null) {
                defaultBufferSize += getDefaultBufferSize(rendererArr[i].getTrackType());
            }
        }
        return Math.max(13107200, defaultBufferSize);
    }

    private void reset(boolean z) {
        int i = this.targetBufferBytesOverwrite;
        if (i == -1) {
            i = 13107200;
        }
        this.targetBufferBytes = i;
        this.isBuffering = false;
        if (z) {
            this.allocator.reset();
        }
    }

    private static int getDefaultBufferSize(int i) {
        switch (i) {
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
                return MessagesController.UPDATE_MASK_REORDER;
            case 6:
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void assertGreaterOrEqual(int i, int i2, String str, String str2) {
        Assertions.checkArgument(i >= i2, str + " cannot be less than " + str2);
    }
}
