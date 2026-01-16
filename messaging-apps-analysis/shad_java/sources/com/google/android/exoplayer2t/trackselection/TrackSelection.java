package com.google.android.exoplayer2t.trackselection;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.source.TrackGroup;
import com.google.android.exoplayer2t.source.chunk.MediaChunk;
import com.google.android.exoplayer2t.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2t.upstream.BandwidthMeter;
import java.util.List;

/* loaded from: classes.dex */
public interface TrackSelection {

    /* renamed from: com.google.android.exoplayer2t.trackselection.TrackSelection$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDiscontinuity(TrackSelection trackSelection) {
        }
    }

    public interface Factory {
        TrackSelection[] createTrackSelections(Definition[] definitionArr, BandwidthMeter bandwidthMeter);
    }

    boolean blacklist(int i, long j);

    void disable();

    void enable();

    int evaluateQueueSize(long j, List<? extends MediaChunk> list);

    Format getFormat(int i);

    int getIndexInTrackGroup(int i);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int i);

    int indexOf(Format format);

    int length();

    void onDiscontinuity();

    void onPlaybackSpeed(float f);

    void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr);

    public static final class Definition {
        public final Object data;
        public final TrackGroup group;
        public final int reason;
        public final int[] tracks;

        public Definition(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0, null);
        }

        public Definition(TrackGroup trackGroup, int[] iArr, int i, Object obj) {
            this.group = trackGroup;
            this.tracks = iArr;
            this.reason = i;
            this.data = obj;
        }
    }
}
