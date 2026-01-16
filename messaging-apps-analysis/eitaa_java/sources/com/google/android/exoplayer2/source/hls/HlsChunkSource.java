package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
class HlsChunkSource {
    private final DataSource encryptionDataSource;
    private Uri expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private final DataSource mediaDataSource;
    private final List<Format> muxedCaptionFormats;
    private final Format[] playlistFormats;
    private final HlsPlaylistTracker playlistTracker;
    private final Uri[] playlistUrls;
    private boolean seenExpectedPlaylistError;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private TrackSelection trackSelection;
    private final FullSegmentEncryptionKeyCache keyCache = new FullSegmentEncryptionKeyCache(4);
    private byte[] scratchSpace = Util.EMPTY_BYTE_ARRAY;
    private long liveEdgeInPeriodTimeUs = -9223372036854775807L;

    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public Uri playlistUrl;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    public HlsChunkSource(HlsExtractorFactory extractorFactory, HlsPlaylistTracker playlistTracker, Uri[] playlistUrls, Format[] playlistFormats, HlsDataSourceFactory dataSourceFactory, TransferListener mediaTransferListener, TimestampAdjusterProvider timestampAdjusterProvider, List<Format> muxedCaptionFormats) {
        this.extractorFactory = extractorFactory;
        this.playlistTracker = playlistTracker;
        this.playlistUrls = playlistUrls;
        this.playlistFormats = playlistFormats;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.muxedCaptionFormats = muxedCaptionFormats;
        DataSource dataSourceCreateDataSource = dataSourceFactory.createDataSource(1);
        this.mediaDataSource = dataSourceCreateDataSource;
        if (mediaTransferListener != null) {
            dataSourceCreateDataSource.addTransferListener(mediaTransferListener);
        }
        this.encryptionDataSource = dataSourceFactory.createDataSource(3);
        this.trackGroup = new TrackGroup(playlistFormats);
        int[] iArr = new int[playlistUrls.length];
        for (int i = 0; i < playlistUrls.length; i++) {
            iArr[i] = i;
        }
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, iArr);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.expectedPlaylistUrl;
        if (uri == null || !this.seenExpectedPlaylistError) {
            return;
        }
        this.playlistTracker.maybeThrowPlaylistRefreshError(uri);
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public void setTrackSelection(TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    public TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void setIsTimestampMaster(boolean isTimestampMaster) {
        this.isTimestampMaster = isTimestampMaster;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[PHI: r2
      0x0056: PHI (r2v2 long) = (r2v1 long), (r2v1 long), (r2v14 long) binds: [B:10:0x0033, B:12:0x0037, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getNextChunk(long r29, long r31, java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r33, boolean r34, com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder r35) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsChunkSource.getNextChunk(long, long, java.util.List, boolean, com.google.android.exoplayer2.source.hls.HlsChunkSource$HlsChunkHolder):void");
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            this.keyCache.put(encryptionKeyChunk.dataSpec.uri, (byte[]) Assertions.checkNotNull(encryptionKeyChunk.getResult()));
        }
    }

    public boolean maybeBlacklistTrack(Chunk chunk, long blacklistDurationMs) {
        TrackSelection trackSelection = this.trackSelection;
        return trackSelection.blacklist(trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), blacklistDurationMs);
    }

    public boolean onPlaylistError(Uri playlistUrl, long blacklistDurationMs) {
        int iIndexOf;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.playlistUrls;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(playlistUrl)) {
                break;
            }
            i++;
        }
        if (i == -1 || (iIndexOf = this.trackSelection.indexOf(i)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError = playlistUrl.equals(this.expectedPlaylistUrl) | this.seenExpectedPlaylistError;
        return blacklistDurationMs == -9223372036854775807L || this.trackSelection.blacklist(iIndexOf, blacklistDurationMs);
    }

    public MediaChunkIterator[] createMediaChunkIterators(HlsMediaChunk previous, long loadPositionUs) {
        int iIndexOf = previous == null ? -1 : this.trackGroup.indexOf(previous.trackFormat);
        int length = this.trackSelection.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        for (int i = 0; i < length; i++) {
            int indexInTrackGroup = this.trackSelection.getIndexInTrackGroup(i);
            Uri uri = this.playlistUrls[indexInTrackGroup];
            if (!this.playlistTracker.isSnapshotValid(uri)) {
                mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
            } else {
                HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri, false);
                Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                long chunkMediaSequence = getChunkMediaSequence(previous, indexInTrackGroup != iIndexOf, playlistSnapshot, initialStartTimeUs, loadPositionUs);
                long j = playlistSnapshot.mediaSequence;
                if (chunkMediaSequence < j) {
                    mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
                } else {
                    mediaChunkIteratorArr[i] = new HlsMediaPlaylistSegmentIterator(playlistSnapshot, initialStartTimeUs, (int) (chunkMediaSequence - j));
                }
            }
        }
        return mediaChunkIteratorArr;
    }

    private long getChunkMediaSequence(HlsMediaChunk previous, boolean switchingTrack, HlsMediaPlaylist mediaPlaylist, long startOfPlaylistInPeriodUs, long loadPositionUs) {
        long jBinarySearchFloor;
        long size;
        if (previous == null || switchingTrack) {
            long j = mediaPlaylist.durationUs + startOfPlaylistInPeriodUs;
            if (previous != null && !this.independentSegments) {
                loadPositionUs = previous.startTimeUs;
            }
            if (!mediaPlaylist.hasEndTag && loadPositionUs >= j) {
                jBinarySearchFloor = mediaPlaylist.mediaSequence;
                size = mediaPlaylist.segments.size();
            } else {
                jBinarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) mediaPlaylist.segments, Long.valueOf(loadPositionUs - startOfPlaylistInPeriodUs), true, !this.playlistTracker.isLive() || previous == null);
                size = mediaPlaylist.mediaSequence;
            }
            return jBinarySearchFloor + size;
        }
        return previous.getNextChunkIndex();
    }

    private long resolveTimeToLiveEdgeUs(long playbackPositionUs) {
        long j = this.liveEdgeInPeriodTimeUs;
        if (j != -9223372036854775807L) {
            return j - playbackPositionUs;
        }
        return -9223372036854775807L;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist mediaPlaylist) {
        this.liveEdgeInPeriodTimeUs = mediaPlaylist.hasEndTag ? -9223372036854775807L : mediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
    }

    private Chunk maybeCreateEncryptionChunkFor(Uri keyUri, int selectedTrackIndex) {
        if (keyUri == null) {
            return null;
        }
        byte[] bArrRemove = this.keyCache.remove(keyUri);
        if (bArrRemove != null) {
            this.keyCache.put(keyUri, bArrRemove);
            return null;
        }
        return new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec(keyUri, 0L, -1L, null, 1), this.playlistFormats[selectedTrackIndex], this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.scratchSpace);
    }

    private static Uri getFullEncryptionKeyUri(HlsMediaPlaylist playlist, HlsMediaPlaylist.Segment segment) {
        String str;
        if (segment == null || (str = segment.fullSegmentEncryptionKeyUri) == null) {
            return null;
        }
        return UriUtil.resolveToUri(playlist.baseUri, str);
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        public InitializationTrackSelection(TrackGroup group, int[] tracks) {
            super(group, tracks);
            this.selectedIndex = indexOf(group.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long playbackPositionUs, long bufferedDurationUs, long availableDurationUs, List<? extends MediaChunk> queue, MediaChunkIterator[] mediaChunkIterators) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.selectedIndex, jElapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, jElapsedRealtime)) {
                        this.selectedIndex = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }
    }

    private static final class EncryptionKeyChunk extends DataChunk {
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format trackFormat, int trackSelectionReason, Object trackSelectionData, byte[] scratchSpace) {
            super(dataSource, dataSpec, 3, trackFormat, trackSelectionReason, trackSelectionData, scratchSpace);
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        protected void consume(byte[] data, int limit) {
            this.result = Arrays.copyOf(data, limit);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    private static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final HlsMediaPlaylist playlist;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(HlsMediaPlaylist playlist, long startOfPlaylistInPeriodUs, int chunkIndex) {
            super(chunkIndex, playlist.segments.size() - 1);
            this.playlist = playlist;
            this.startOfPlaylistInPeriodUs = startOfPlaylistInPeriodUs;
        }
    }
}
