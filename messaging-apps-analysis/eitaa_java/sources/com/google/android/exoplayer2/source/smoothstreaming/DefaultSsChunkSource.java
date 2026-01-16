package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultSsChunkSource implements SsChunkSource {
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private final ChunkExtractorWrapper[] extractorWrappers;
    private IOException fatalError;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int streamElementIndex;
    private TrackSelection trackSelection;

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
    }

    public static final class Factory implements SsChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory dataSourceFactory) {
            this.dataSourceFactory = dataSourceFactory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public SsChunkSource createChunkSource(LoaderErrorThrower manifestLoaderErrorThrower, SsManifest manifest, int elementIndex, TrackSelection trackSelection, TransferListener transferListener) {
            DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                dataSourceCreateDataSource.addTransferListener(transferListener);
            }
            return new DefaultSsChunkSource(manifestLoaderErrorThrower, manifest, elementIndex, trackSelection, dataSourceCreateDataSource);
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower manifestLoaderErrorThrower, SsManifest manifest, int streamElementIndex, TrackSelection trackSelection, DataSource dataSource) {
        this.manifestLoaderErrorThrower = manifestLoaderErrorThrower;
        this.manifest = manifest;
        this.streamElementIndex = streamElementIndex;
        this.trackSelection = trackSelection;
        this.dataSource = dataSource;
        SsManifest.StreamElement streamElement = manifest.streamElements[streamElementIndex];
        this.extractorWrappers = new ChunkExtractorWrapper[trackSelection.length()];
        int i = 0;
        while (i < this.extractorWrappers.length) {
            int indexInTrackGroup = trackSelection.getIndexInTrackGroup(i);
            Format format = streamElement.formats[indexInTrackGroup];
            TrackEncryptionBox[] trackEncryptionBoxArr = format.drmInitData != null ? manifest.protectionElement.trackEncryptionBoxes : null;
            int i2 = streamElement.type;
            int i3 = i;
            this.extractorWrappers[i3] = new ChunkExtractorWrapper(new FragmentedMp4Extractor(3, null, new Track(indexInTrackGroup, i2, streamElement.timescale, -9223372036854775807L, manifest.durationUs, format, 0, trackEncryptionBoxArr, i2 == 2 ? 4 : 0, null, null)), streamElement.type, format);
            i = i3 + 1;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long positionUs, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int chunkIndex = streamElement.getChunkIndex(positionUs);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return Util.resolveSeekPositionUs(positionUs, seekParameters, startTimeUs, (startTimeUs >= positionUs || chunkIndex >= streamElement.chunkCount + (-1)) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateManifest(SsManifest newManifest) {
        SsManifest.StreamElement[] streamElementArr = this.manifest.streamElements;
        int i = this.streamElementIndex;
        SsManifest.StreamElement streamElement = streamElementArr[i];
        int i2 = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = newManifest.streamElements[i];
        if (i2 == 0 || streamElement2.chunkCount == 0) {
            this.currentManifestChunkOffset += i2;
        } else {
            int i3 = i2 - 1;
            long startTimeUs = streamElement.getStartTimeUs(i3) + streamElement.getChunkDurationUs(i3);
            long startTimeUs2 = streamElement2.getStartTimeUs(0);
            if (startTimeUs <= startTimeUs2) {
                this.currentManifestChunkOffset += i2;
            } else {
                this.currentManifestChunkOffset += streamElement.getChunkIndex(startTimeUs2);
            }
        }
        this.manifest = newManifest;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateTrackSelection(TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long playbackPositionUs, List<? extends MediaChunk> queue) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return queue.size();
        }
        return this.trackSelection.evaluateQueueSize(playbackPositionUs, queue);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(long playbackPositionUs, long loadPositionUs, List<? extends MediaChunk> queue, ChunkHolder out) {
        int nextChunkIndex;
        long j = loadPositionUs;
        if (this.fatalError != null) {
            return;
        }
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        if (streamElement.chunkCount == 0) {
            out.endOfStream = !r4.isLive;
            return;
        }
        if (queue.isEmpty()) {
            nextChunkIndex = streamElement.getChunkIndex(j);
        } else {
            nextChunkIndex = (int) (queue.get(queue.size() - 1).getNextChunkIndex() - this.currentManifestChunkOffset);
            if (nextChunkIndex < 0) {
                this.fatalError = new BehindLiveWindowException();
                return;
            }
        }
        if (nextChunkIndex >= streamElement.chunkCount) {
            out.endOfStream = !this.manifest.isLive;
            return;
        }
        long j2 = j - playbackPositionUs;
        long jResolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(playbackPositionUs);
        int length = this.trackSelection.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        for (int i = 0; i < length; i++) {
            mediaChunkIteratorArr[i] = new StreamElementIterator(streamElement, this.trackSelection.getIndexInTrackGroup(i), nextChunkIndex);
        }
        this.trackSelection.updateSelectedTrack(playbackPositionUs, j2, jResolveTimeToLiveEdgeUs, queue, mediaChunkIteratorArr);
        long startTimeUs = streamElement.getStartTimeUs(nextChunkIndex);
        long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(nextChunkIndex);
        if (!queue.isEmpty()) {
            j = -9223372036854775807L;
        }
        long j3 = j;
        int i2 = nextChunkIndex + this.currentManifestChunkOffset;
        int selectedIndex = this.trackSelection.getSelectedIndex();
        out.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), nextChunkIndex), null, i2, startTimeUs, chunkDurationUs, j3, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.extractorWrappers[selectedIndex]);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean cancelable, Exception e, long blacklistDurationMs) {
        if (cancelable && blacklistDurationMs != -9223372036854775807L) {
            TrackSelection trackSelection = this.trackSelection;
            if (trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), blacklistDurationMs)) {
                return true;
            }
        }
        return false;
    }

    private static MediaChunk newMediaChunk(Format format, DataSource dataSource, Uri uri, String cacheKey, int chunkIndex, long chunkStartTimeUs, long chunkEndTimeUs, long chunkSeekTimeUs, int trackSelectionReason, Object trackSelectionData, ChunkExtractorWrapper extractorWrapper) {
        return new ContainerMediaChunk(dataSource, new DataSpec(uri, 0L, -1L, cacheKey), format, trackSelectionReason, trackSelectionData, chunkStartTimeUs, chunkEndTimeUs, chunkSeekTimeUs, -9223372036854775807L, chunkIndex, 1, chunkStartTimeUs, extractorWrapper);
    }

    private long resolveTimeToLiveEdgeUs(long playbackPositionUs) {
        SsManifest ssManifest = this.manifest;
        if (!ssManifest.isLive) {
            return -9223372036854775807L;
        }
        SsManifest.StreamElement streamElement = ssManifest.streamElements[this.streamElementIndex];
        int i = streamElement.chunkCount - 1;
        return (streamElement.getStartTimeUs(i) + streamElement.getChunkDurationUs(i)) - playbackPositionUs;
    }

    private static final class StreamElementIterator extends BaseMediaChunkIterator {
        private final SsManifest.StreamElement streamElement;
        private final int trackIndex;

        public StreamElementIterator(SsManifest.StreamElement streamElement, int trackIndex, int chunkIndex) {
            super(chunkIndex, streamElement.chunkCount - 1);
            this.streamElement = streamElement;
            this.trackIndex = trackIndex;
        }
    }
}
