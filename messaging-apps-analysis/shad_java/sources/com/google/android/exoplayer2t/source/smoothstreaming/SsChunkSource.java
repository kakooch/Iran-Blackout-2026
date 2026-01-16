package com.google.android.exoplayer2t.source.smoothstreaming;

import com.google.android.exoplayer2t.source.chunk.ChunkSource;
import com.google.android.exoplayer2t.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2t.trackselection.TrackSelection;
import com.google.android.exoplayer2t.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2t.upstream.TransferListener;

/* loaded from: classes.dex */
public interface SsChunkSource extends ChunkSource {

    public interface Factory {
        SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, TransferListener transferListener);
    }

    void updateManifest(SsManifest ssManifest);

    void updateTrackSelection(TrackSelection trackSelection);
}
