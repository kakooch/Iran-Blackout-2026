package com.google.android.exoplayer2t.source;

import com.google.android.exoplayer2t.SeekParameters;
import com.google.android.exoplayer2t.source.SequenceableLoader;
import com.google.android.exoplayer2t.trackselection.TrackSelection;
import java.io.IOException;

/* loaded from: classes.dex */
public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    @Override // com.google.android.exoplayer2t.source.SequenceableLoader
    boolean continueLoading(long j);

    void discardBuffer(long j, boolean z);

    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    @Override // com.google.android.exoplayer2t.source.SequenceableLoader
    long getBufferedPositionUs();

    @Override // com.google.android.exoplayer2t.source.SequenceableLoader
    long getNextLoadPositionUs();

    TrackGroupArray getTrackGroups();

    @Override // com.google.android.exoplayer2t.source.SequenceableLoader
    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long j);

    long readDiscontinuity();

    @Override // com.google.android.exoplayer2t.source.SequenceableLoader
    void reevaluateBuffer(long j);

    long seekToUs(long j);

    long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);
}
