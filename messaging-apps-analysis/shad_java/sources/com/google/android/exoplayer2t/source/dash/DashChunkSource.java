package com.google.android.exoplayer2t.source.dash;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.source.chunk.ChunkSource;
import com.google.android.exoplayer2t.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2t.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2t.trackselection.TrackSelection;
import com.google.android.exoplayer2t.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2t.upstream.TransferListener;
import java.util.List;

/* loaded from: classes.dex */
public interface DashChunkSource extends ChunkSource {

    public interface Factory {
        DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, long j, boolean z, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener);
    }

    void updateManifest(DashManifest dashManifest, int i);

    void updateTrackSelection(TrackSelection trackSelection);
}
