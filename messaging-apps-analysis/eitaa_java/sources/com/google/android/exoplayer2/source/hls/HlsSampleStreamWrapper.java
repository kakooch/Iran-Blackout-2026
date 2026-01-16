package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    private static final Set<Integer> MAPPABLE_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 4)));
    private final Allocator allocator;
    private final Callback callback;
    private final HlsChunkSource chunkSource;
    private int chunkUid;
    private Format downstreamTrackFormat;
    private DrmInitData drmInitData;
    private final DrmSessionManager<?> drmSessionManager;
    private TrackOutput emsgUnwrappingTrackOutput;
    private int enabledTrackGroupCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final Handler handler;
    private boolean haveAudioVideoSampleQueues;
    private final ArrayList<HlsSampleStream> hlsSampleStreams;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final ArrayList<HlsMediaChunk> mediaChunks;
    private final int metadataType;
    private final Format muxedAudioFormat;
    private final Runnable onTracksEndedRunnable;
    private Set<TrackGroup> optionalTrackGroups;
    private final Map<String, DrmInitData> overridingDrmInitData;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primarySampleQueueIndex;
    private int primarySampleQueueType;
    private int primaryTrackGroupIndex;
    private final List<HlsMediaChunk> readOnlyMediaChunks;
    private boolean released;
    private long sampleOffsetUs;
    private SparseIntArray sampleQueueIndicesByType;
    private boolean[] sampleQueueIsAudioVideoFlags;
    private Set<Integer> sampleQueueMappingDoneByType;
    private FormatAdjustingSampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private boolean[] sampleQueuesEnabledStates;
    private boolean seenFirstTrackSelection;
    private int[] trackGroupToSampleQueueIndex;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private Format upstreamTrackFormat;
    private final Loader loader = new Loader("Loader:HlsSampleStreamWrapper");
    private final HlsChunkSource.HlsChunkHolder nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    private int[] sampleQueueTrackIds = new int[0];

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(Uri playlistUrl);

        void onPrepared();
    }

    private static int getTrackTypeScore(int trackType) {
        if (trackType == 1) {
            return 2;
        }
        if (trackType != 2) {
            return trackType != 3 ? 0 : 1;
        }
        return 3;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long positionUs) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
    }

    public HlsSampleStreamWrapper(int trackType, Callback callback, HlsChunkSource chunkSource, Map<String, DrmInitData> overridingDrmInitData, Allocator allocator, long positionUs, Format muxedAudioFormat, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, int metadataType) {
        this.trackType = trackType;
        this.callback = callback;
        this.chunkSource = chunkSource;
        this.overridingDrmInitData = overridingDrmInitData;
        this.allocator = allocator;
        this.muxedAudioFormat = muxedAudioFormat;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.metadataType = metadataType;
        Set<Integer> set = MAPPABLE_TYPES;
        this.sampleQueueMappingDoneByType = new HashSet(set.size());
        this.sampleQueueIndicesByType = new SparseIntArray(set.size());
        this.sampleQueues = new FormatAdjustingSampleQueue[0];
        this.sampleQueueIsAudioVideoFlags = new boolean[0];
        this.sampleQueuesEnabledStates = new boolean[0];
        ArrayList<HlsMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList);
        this.hlsSampleStreams = new ArrayList<>();
        this.maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.-$$Lambda$HlsSampleStreamWrapper$FTpP0pC43I2Fmbrry86yPSv4RFI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.maybeFinishPrepare();
            }
        };
        this.onTracksEndedRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.-$$Lambda$HlsSampleStreamWrapper$6vTR3mtGTvT72nPYfSpGJ3S1EYI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onTracksEnded();
            }
        };
        this.handler = new Handler();
        this.lastSeekPositionUs = positionUs;
        this.pendingResetPositionUs = positionUs;
    }

    public void continuePreparing() {
        if (this.prepared) {
            return;
        }
        continueLoading(this.lastSeekPositionUs);
    }

    public void prepareWithMasterPlaylistInfo(TrackGroup[] trackGroups, int primaryTrackGroupIndex, int... optionalTrackGroupsIndices) {
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroups);
        this.optionalTrackGroups = new HashSet();
        for (int i : optionalTrackGroupsIndices) {
            this.optionalTrackGroups.add(this.trackGroups.get(i));
        }
        this.primaryTrackGroupIndex = primaryTrackGroupIndex;
        Handler handler = this.handler;
        final Callback callback = this.callback;
        callback.getClass();
        handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.-$$Lambda$rRHodWwjcYk_5s1z_Ry1lDfFieg
            @Override // java.lang.Runnable
            public final void run() {
                callback.onPrepared();
            }
        });
        setIsPrepared();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public TrackGroupArray getTrackGroups() {
        assertIsPrepared();
        return this.trackGroups;
    }

    public int bindSampleQueueToSampleStream(int trackGroupIndex) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i = this.trackGroupToSampleQueueIndex[trackGroupIndex];
        if (i == -1) {
            return this.optionalTrackGroups.contains(this.trackGroups.get(trackGroupIndex)) ? -3 : -2;
        }
        boolean[] zArr = this.sampleQueuesEnabledStates;
        if (zArr[i]) {
            return -2;
        }
        zArr[i] = true;
        return i;
    }

    public void unbindSampleQueue(int trackGroupIndex) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i = this.trackGroupToSampleQueueIndex[trackGroupIndex];
        Assertions.checkState(this.sampleQueuesEnabledStates[i]);
        this.sampleQueuesEnabledStates[i] = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] r20, boolean[] r21, com.google.android.exoplayer2.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void discardBuffer(long positionUs, boolean toKeyframe) {
        if (!this.sampleQueuesBuilt || isPendingReset()) {
            return;
        }
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            this.sampleQueues[i].discardTo(positionUs, toKeyframe, this.sampleQueuesEnabledStates[i]);
        }
    }

    public boolean seekToUs(long positionUs, boolean forceReset) {
        this.lastSeekPositionUs = positionUs;
        if (isPendingReset()) {
            this.pendingResetPositionUs = positionUs;
            return true;
        }
        if (this.sampleQueuesBuilt && !forceReset && seekInsideBufferUs(positionUs)) {
            return false;
        }
        this.pendingResetPositionUs = positionUs;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
        } else {
            this.loader.clearFatalError();
            resetSampleQueues();
        }
        return true;
    }

    public void release() {
        if (this.prepared) {
            for (FormatAdjustingSampleQueue formatAdjustingSampleQueue : this.sampleQueues) {
                formatAdjustingSampleQueue.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
        this.hlsSampleStreams.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (FormatAdjustingSampleQueue formatAdjustingSampleQueue : this.sampleQueues) {
            formatAdjustingSampleQueue.release();
        }
    }

    public void setIsTimestampMaster(boolean isTimestampMaster) {
        this.chunkSource.setIsTimestampMaster(isTimestampMaster);
    }

    public boolean onPlaylistError(Uri playlistUrl, long blacklistDurationMs) {
        return this.chunkSource.onPlaylistError(playlistUrl, blacklistDurationMs);
    }

    public boolean isReady(int sampleQueueIndex) {
        return !isPendingReset() && this.sampleQueues[sampleQueueIndex].isReady(this.loadingFinished);
    }

    public void maybeThrowError(int sampleQueueIndex) throws IOException {
        maybeThrowError();
        this.sampleQueues[sampleQueueIndex].maybeThrowError();
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public int readData(int sampleQueueIndex, FormatHolder formatHolder, DecoderInputBuffer buffer, boolean requireFormat) {
        Format format;
        if (isPendingReset()) {
            return -3;
        }
        int i = 0;
        if (!this.mediaChunks.isEmpty()) {
            int i2 = 0;
            while (i2 < this.mediaChunks.size() - 1 && finishedReadingChunk(this.mediaChunks.get(i2))) {
                i2++;
            }
            Util.removeRange(this.mediaChunks, 0, i2);
            HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(0);
            Format format2 = hlsMediaChunk.trackFormat;
            if (!format2.equals(this.downstreamTrackFormat)) {
                this.eventDispatcher.downstreamFormatChanged(this.trackType, format2, hlsMediaChunk.trackSelectionReason, hlsMediaChunk.trackSelectionData, hlsMediaChunk.startTimeUs);
            }
            this.downstreamTrackFormat = format2;
        }
        int i3 = this.sampleQueues[sampleQueueIndex].read(formatHolder, buffer, requireFormat, this.loadingFinished, this.lastSeekPositionUs);
        if (i3 == -5) {
            Format formatCopyWithManifestFormatInfo = (Format) Assertions.checkNotNull(formatHolder.format);
            if (sampleQueueIndex == this.primarySampleQueueIndex) {
                int iPeekSourceId = this.sampleQueues[sampleQueueIndex].peekSourceId();
                while (i < this.mediaChunks.size() && this.mediaChunks.get(i).uid != iPeekSourceId) {
                    i++;
                }
                if (i < this.mediaChunks.size()) {
                    format = this.mediaChunks.get(i).trackFormat;
                } else {
                    format = (Format) Assertions.checkNotNull(this.upstreamTrackFormat);
                }
                formatCopyWithManifestFormatInfo = formatCopyWithManifestFormatInfo.copyWithManifestFormatInfo(format);
            }
            formatHolder.format = formatCopyWithManifestFormatInfo;
        }
        return i3;
    }

    public int skipData(int sampleQueueIndex, long positionUs) {
        if (isPendingReset()) {
            return 0;
        }
        FormatAdjustingSampleQueue formatAdjustingSampleQueue = this.sampleQueues[sampleQueueIndex];
        if (this.loadingFinished && positionUs > formatAdjustingSampleQueue.getLargestQueuedTimestampUs()) {
            return formatAdjustingSampleQueue.advanceToEnd();
        }
        return formatAdjustingSampleQueue.advanceTo(positionUs);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        /*
            r7 = this;
            boolean r0 = r7.loadingFinished
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.isPendingReset()
            if (r0 == 0) goto L10
            long r0 = r7.pendingResetPositionUs
            return r0
        L10:
            long r0 = r7.lastSeekPositionUs
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = r7.getLastMediaChunk()
            boolean r3 = r2.isLoadCompleted()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r2 = r7.mediaChunks
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r2 = r7.mediaChunks
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = (com.google.android.exoplayer2.source.hls.HlsMediaChunk) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.endTimeUs
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.sampleQueuesBuilt
            if (r2 == 0) goto L55
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$FormatAdjustingSampleQueue[] r2 = r7.sampleQueues
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.getLargestQueuedTimestampUs()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.getBufferedPositionUs():long");
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long positionUs) {
        List<HlsMediaChunk> listEmptyList;
        long jMax;
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        if (isPendingReset()) {
            listEmptyList = Collections.emptyList();
            jMax = this.pendingResetPositionUs;
        } else {
            listEmptyList = this.readOnlyMediaChunks;
            HlsMediaChunk lastMediaChunk = getLastMediaChunk();
            if (lastMediaChunk.isLoadCompleted()) {
                jMax = lastMediaChunk.endTimeUs;
            } else {
                jMax = Math.max(this.lastSeekPositionUs, lastMediaChunk.startTimeUs);
            }
        }
        List<HlsMediaChunk> list = listEmptyList;
        this.chunkSource.getNextChunk(positionUs, jMax, list, this.prepared || !list.isEmpty(), this.nextChunkHolder);
        HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.nextChunkHolder;
        boolean z = hlsChunkHolder.endOfStream;
        Chunk chunk = hlsChunkHolder.chunk;
        Uri uri = hlsChunkHolder.playlistUrl;
        hlsChunkHolder.clear();
        if (z) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        }
        if (chunk == null) {
            if (uri != null) {
                this.callback.onPlaylistRefreshRequired(uri);
            }
            return false;
        }
        if (isMediaChunk(chunk)) {
            this.pendingResetPositionUs = -9223372036854775807L;
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) chunk;
            hlsMediaChunk.init(this);
            this.mediaChunks.add(hlsMediaChunk);
            this.upstreamTrackFormat = hlsMediaChunk.trackFormat;
        }
        this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type)));
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.loader.isLoading();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk loadable, long elapsedRealtimeMs, long loadDurationMs) {
        this.chunkSource.onChunkLoadCompleted(loadable);
        this.eventDispatcher.loadCompleted(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, this.trackType, loadable.trackFormat, loadable.trackSelectionReason, loadable.trackSelectionData, loadable.startTimeUs, loadable.endTimeUs, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
        this.eventDispatcher.loadCanceled(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, this.trackType, loadable.trackFormat, loadable.trackSelectionReason, loadable.trackSelectionData, loadable.startTimeUs, loadable.endTimeUs, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        if (released) {
            return;
        }
        resetSampleQueues();
        if (this.enabledTrackGroupCount > 0) {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(Chunk loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
        Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        long jBytesLoaded = loadable.bytesLoaded();
        boolean zIsMediaChunk = isMediaChunk(loadable);
        long blacklistDurationMsFor = this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(loadable.type, loadDurationMs, error, errorCount);
        boolean zMaybeBlacklistTrack = blacklistDurationMsFor != -9223372036854775807L ? this.chunkSource.maybeBlacklistTrack(loadable, blacklistDurationMsFor) : false;
        if (zMaybeBlacklistTrack) {
            if (zIsMediaChunk && jBytesLoaded == 0) {
                ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
                Assertions.checkState(arrayList.remove(arrayList.size() - 1) == loadable);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
            loadErrorActionCreateRetryAction = Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadable.type, loadDurationMs, error, errorCount);
            if (retryDelayMsFor != -9223372036854775807L) {
                loadErrorActionCreateRetryAction = Loader.createRetryAction(false, retryDelayMsFor);
            } else {
                loadErrorActionCreateRetryAction = Loader.DONT_RETRY_FATAL;
            }
        }
        Loader.LoadErrorAction loadErrorAction = loadErrorActionCreateRetryAction;
        this.eventDispatcher.loadError(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, this.trackType, loadable.trackFormat, loadable.trackSelectionReason, loadable.trackSelectionData, loadable.startTimeUs, loadable.endTimeUs, elapsedRealtimeMs, loadDurationMs, jBytesLoaded, error, !loadErrorAction.isRetry());
        if (zMaybeBlacklistTrack) {
            if (!this.prepared) {
                continueLoading(this.lastSeekPositionUs);
            } else {
                this.callback.onContinueLoadingRequested(this);
            }
        }
        return loadErrorAction;
    }

    public void init(int chunkUid, boolean shouldSpliceIn) {
        this.chunkUid = chunkUid;
        for (FormatAdjustingSampleQueue formatAdjustingSampleQueue : this.sampleQueues) {
            formatAdjustingSampleQueue.sourceId(chunkUid);
        }
        if (shouldSpliceIn) {
            for (FormatAdjustingSampleQueue formatAdjustingSampleQueue2 : this.sampleQueues) {
                formatAdjustingSampleQueue2.splice();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int id, int type) {
        TrackOutput trackOutputCreateSampleQueue;
        if (!MAPPABLE_TYPES.contains(Integer.valueOf(type))) {
            int i = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.sampleQueues;
                if (i >= trackOutputArr.length) {
                    trackOutputCreateSampleQueue = null;
                    break;
                }
                if (this.sampleQueueTrackIds[i] == id) {
                    trackOutputCreateSampleQueue = trackOutputArr[i];
                    break;
                }
                i++;
            }
        } else {
            trackOutputCreateSampleQueue = getMappedTrackOutput(id, type);
        }
        if (trackOutputCreateSampleQueue == null) {
            if (this.tracksEnded) {
                return createDummyTrackOutput(id, type);
            }
            trackOutputCreateSampleQueue = createSampleQueue(id, type);
        }
        if (type != 4) {
            return trackOutputCreateSampleQueue;
        }
        if (this.emsgUnwrappingTrackOutput == null) {
            this.emsgUnwrappingTrackOutput = new EmsgUnwrappingTrackOutput(trackOutputCreateSampleQueue, this.metadataType);
        }
        return this.emsgUnwrappingTrackOutput;
    }

    private TrackOutput getMappedTrackOutput(int id, int type) {
        Assertions.checkArgument(MAPPABLE_TYPES.contains(Integer.valueOf(type)));
        int i = this.sampleQueueIndicesByType.get(type, -1);
        if (i == -1) {
            return null;
        }
        if (this.sampleQueueMappingDoneByType.add(Integer.valueOf(type))) {
            this.sampleQueueTrackIds[i] = id;
        }
        if (this.sampleQueueTrackIds[i] == id) {
            return this.sampleQueues[i];
        }
        return createDummyTrackOutput(id, type);
    }

    private SampleQueue createSampleQueue(int id, int type) {
        int length = this.sampleQueues.length;
        boolean z = true;
        if (type != 1 && type != 2) {
            z = false;
        }
        FormatAdjustingSampleQueue formatAdjustingSampleQueue = new FormatAdjustingSampleQueue(this.allocator, this.handler.getLooper(), this.drmSessionManager, this.overridingDrmInitData);
        if (z) {
            formatAdjustingSampleQueue.setDrmInitData(this.drmInitData);
        }
        formatAdjustingSampleQueue.setSampleOffsetUs(this.sampleOffsetUs);
        formatAdjustingSampleQueue.sourceId(this.chunkUid);
        formatAdjustingSampleQueue.setUpstreamFormatChangeListener(this);
        int i = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.sampleQueueTrackIds, i);
        this.sampleQueueTrackIds = iArrCopyOf;
        iArrCopyOf[length] = id;
        this.sampleQueues = (FormatAdjustingSampleQueue[]) Util.nullSafeArrayAppend(this.sampleQueues, formatAdjustingSampleQueue);
        boolean[] zArrCopyOf = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, i);
        this.sampleQueueIsAudioVideoFlags = zArrCopyOf;
        zArrCopyOf[length] = z;
        this.haveAudioVideoSampleQueues = zArrCopyOf[length] | this.haveAudioVideoSampleQueues;
        this.sampleQueueMappingDoneByType.add(Integer.valueOf(type));
        this.sampleQueueIndicesByType.append(type, length);
        if (getTrackTypeScore(type) > getTrackTypeScore(this.primarySampleQueueType)) {
            this.primarySampleQueueIndex = length;
            this.primarySampleQueueType = type;
        }
        this.sampleQueuesEnabledStates = Arrays.copyOf(this.sampleQueuesEnabledStates, i);
        return formatAdjustingSampleQueue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.tracksEnded = true;
        this.handler.post(this.onTracksEndedRunnable);
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void onNewExtractor() {
        this.sampleQueueMappingDoneByType.clear();
    }

    public void setSampleOffsetUs(long sampleOffsetUs) {
        if (this.sampleOffsetUs != sampleOffsetUs) {
            this.sampleOffsetUs = sampleOffsetUs;
            for (FormatAdjustingSampleQueue formatAdjustingSampleQueue : this.sampleQueues) {
                formatAdjustingSampleQueue.setSampleOffsetUs(sampleOffsetUs);
            }
        }
    }

    public void setDrmInitData(DrmInitData drmInitData) {
        if (Util.areEqual(this.drmInitData, drmInitData)) {
            return;
        }
        this.drmInitData = drmInitData;
        int i = 0;
        while (true) {
            FormatAdjustingSampleQueue[] formatAdjustingSampleQueueArr = this.sampleQueues;
            if (i >= formatAdjustingSampleQueueArr.length) {
                return;
            }
            if (this.sampleQueueIsAudioVideoFlags[i]) {
                formatAdjustingSampleQueueArr[i].setDrmInitData(drmInitData);
            }
            i++;
        }
    }

    private void updateSampleStreams(SampleStream[] streams) {
        this.hlsSampleStreams.clear();
        for (SampleStream sampleStream : streams) {
            if (sampleStream != null) {
                this.hlsSampleStreams.add((HlsSampleStream) sampleStream);
            }
        }
    }

    private boolean finishedReadingChunk(HlsMediaChunk chunk) {
        int i = chunk.uid;
        int length = this.sampleQueues.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.sampleQueuesEnabledStates[i2] && this.sampleQueues[i2].peekSourceId() == i) {
                return false;
            }
        }
        return true;
    }

    private void resetSampleQueues() {
        for (FormatAdjustingSampleQueue formatAdjustingSampleQueue : this.sampleQueues) {
            formatAdjustingSampleQueue.reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && this.trackGroupToSampleQueueIndex == null && this.sampleQueuesBuilt) {
            for (FormatAdjustingSampleQueue formatAdjustingSampleQueue : this.sampleQueues) {
                if (formatAdjustingSampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            if (this.trackGroups != null) {
                mapSampleQueuesToMatchTrackGroups();
                return;
            }
            buildTracksFromSampleStreams();
            setIsPrepared();
            this.callback.onPrepared();
        }
    }

    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    @RequiresNonNull({"trackGroups"})
    private void mapSampleQueuesToMatchTrackGroups() {
        int i = this.trackGroups.length;
        int[] iArr = new int[i];
        this.trackGroupToSampleQueueIndex = iArr;
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                FormatAdjustingSampleQueue[] formatAdjustingSampleQueueArr = this.sampleQueues;
                if (i3 >= formatAdjustingSampleQueueArr.length) {
                    break;
                }
                if (formatsMatch(formatAdjustingSampleQueueArr[i3].getUpstreamFormat(), this.trackGroups.get(i2).getFormat(0))) {
                    this.trackGroupToSampleQueueIndex[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        Iterator<HlsSampleStream> it = this.hlsSampleStreams.iterator();
        while (it.hasNext()) {
            it.next().bindSampleQueue();
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void buildTracksFromSampleStreams() {
        int length = this.sampleQueues.length;
        int i = 0;
        int i2 = 6;
        int i3 = -1;
        while (true) {
            int i4 = 2;
            if (i >= length) {
                break;
            }
            String str = this.sampleQueues[i].getUpstreamFormat().sampleMimeType;
            if (!MimeTypes.isVideo(str)) {
                if (MimeTypes.isAudio(str)) {
                    i4 = 1;
                } else {
                    i4 = MimeTypes.isText(str) ? 3 : 6;
                }
            }
            if (getTrackTypeScore(i4) > getTrackTypeScore(i2)) {
                i3 = i;
                i2 = i4;
            } else if (i4 == i2 && i3 != -1) {
                i3 = -1;
            }
            i++;
        }
        TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        int i5 = trackGroup.length;
        this.primaryTrackGroupIndex = -1;
        this.trackGroupToSampleQueueIndex = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.trackGroupToSampleQueueIndex[i6] = i6;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i7 = 0; i7 < length; i7++) {
            Format upstreamFormat = this.sampleQueues[i7].getUpstreamFormat();
            if (i7 == i3) {
                Format[] formatArr = new Format[i5];
                if (i5 == 1) {
                    formatArr[0] = upstreamFormat.copyWithManifestFormatInfo(trackGroup.getFormat(0));
                } else {
                    for (int i8 = 0; i8 < i5; i8++) {
                        formatArr[i8] = deriveFormat(trackGroup.getFormat(i8), upstreamFormat, true);
                    }
                }
                trackGroupArr[i7] = new TrackGroup(formatArr);
                this.primaryTrackGroupIndex = i7;
            } else {
                trackGroupArr[i7] = new TrackGroup(deriveFormat((i2 == 2 && MimeTypes.isAudio(upstreamFormat.sampleMimeType)) ? this.muxedAudioFormat : null, upstreamFormat, false));
            }
        }
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroupArr);
        Assertions.checkState(this.optionalTrackGroups == null);
        this.optionalTrackGroups = Collections.emptySet();
    }

    private TrackGroupArray createTrackGroupArrayWithDrmInfo(TrackGroup[] trackGroups) {
        for (int i = 0; i < trackGroups.length; i++) {
            TrackGroup trackGroup = trackGroups[i];
            Format[] formatArr = new Format[trackGroup.length];
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                Format format = trackGroup.getFormat(i2);
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    format = format.copyWithExoMediaCryptoType(this.drmSessionManager.getExoMediaCryptoType(drmInitData));
                }
                formatArr[i2] = format;
            }
            trackGroups[i] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroups);
    }

    private HlsMediaChunk getLastMediaChunk() {
        return this.mediaChunks.get(r0.size() - 1);
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private boolean seekInsideBufferUs(long positionUs) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (!this.sampleQueues[i].seekTo(positionUs, false) && (this.sampleQueueIsAudioVideoFlags[i] || !this.haveAudioVideoSampleQueues)) {
                return false;
            }
        }
        return true;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void setIsPrepared() {
        this.prepared = true;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void assertIsPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackGroups);
        Assertions.checkNotNull(this.optionalTrackGroups);
    }

    private static Format deriveFormat(Format playlistFormat, Format sampleFormat, boolean propagateBitrate) {
        if (playlistFormat == null) {
            return sampleFormat;
        }
        int i = propagateBitrate ? playlistFormat.bitrate : -1;
        int i2 = playlistFormat.channelCount;
        if (i2 == -1) {
            i2 = sampleFormat.channelCount;
        }
        int i3 = i2;
        String codecsOfType = Util.getCodecsOfType(playlistFormat.codecs, MimeTypes.getTrackType(sampleFormat.sampleMimeType));
        String mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType);
        if (mediaMimeType == null) {
            mediaMimeType = sampleFormat.sampleMimeType;
        }
        return sampleFormat.copyWithContainerInfo(playlistFormat.id, playlistFormat.label, mediaMimeType, codecsOfType, playlistFormat.metadata, i, playlistFormat.width, playlistFormat.height, i3, playlistFormat.selectionFlags, playlistFormat.language);
    }

    private static boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private static boolean formatsMatch(Format manifestFormat, Format sampleFormat) {
        String str = manifestFormat.sampleMimeType;
        String str2 = sampleFormat.sampleMimeType;
        int trackType = MimeTypes.getTrackType(str);
        if (trackType != 3) {
            return trackType == MimeTypes.getTrackType(str2);
        }
        if (Util.areEqual(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || manifestFormat.accessibilityChannel == sampleFormat.accessibilityChannel;
        }
        return false;
    }

    private static DummyTrackOutput createDummyTrackOutput(int id, int type) {
        Log.w("HlsSampleStreamWrapper", "Unmapped track with id " + id + " of type " + type);
        return new DummyTrackOutput();
    }

    private static final class FormatAdjustingSampleQueue extends SampleQueue {
        private DrmInitData drmInitData;
        private final Map<String, DrmInitData> overridingDrmInitData;

        public FormatAdjustingSampleQueue(Allocator allocator, Looper playbackLooper, DrmSessionManager<?> drmSessionManager, Map<String, DrmInitData> overridingDrmInitData) {
            super(allocator, playbackLooper, drmSessionManager);
            this.overridingDrmInitData = overridingDrmInitData;
        }

        public void setDrmInitData(DrmInitData drmInitData) {
            this.drmInitData = drmInitData;
            invalidateUpstreamFormatAdjustment();
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue
        public Format getAdjustedUpstreamFormat(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.drmInitData;
            if (drmInitData2 == null) {
                drmInitData2 = format.drmInitData;
            }
            if (drmInitData2 != null && (drmInitData = this.overridingDrmInitData.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            return super.getAdjustedUpstreamFormat(format.copyWithAdjustments(drmInitData2, getAdjustedMetadata(format.metadata)));
        }

        private Metadata getAdjustedMetadata(Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i2);
                if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[length - 1];
            while (i < length) {
                if (i != i2) {
                    entryArr[i < i2 ? i : i - 1] = metadata.get(i);
                }
                i++;
            }
            return new Metadata(entryArr);
        }
    }

    private static class EmsgUnwrappingTrackOutput implements TrackOutput {
        private byte[] buffer;
        private int bufferPosition;
        private final TrackOutput delegate;
        private final Format delegateFormat;
        private final EventMessageDecoder emsgDecoder = new EventMessageDecoder();
        private Format format;
        private static final Format ID3_FORMAT = Format.createSampleFormat(null, "application/id3", Long.MAX_VALUE);
        private static final Format EMSG_FORMAT = Format.createSampleFormat(null, "application/x-emsg", Long.MAX_VALUE);

        public EmsgUnwrappingTrackOutput(TrackOutput delegate, int metadataType) {
            this.delegate = delegate;
            if (metadataType == 1) {
                this.delegateFormat = ID3_FORMAT;
            } else if (metadataType == 3) {
                this.delegateFormat = EMSG_FORMAT;
            } else {
                throw new IllegalArgumentException("Unknown metadataType: " + metadataType);
            }
            this.buffer = new byte[0];
            this.bufferPosition = 0;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            this.format = format;
            this.delegate.format(this.delegateFormat);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(ExtractorInput input, int length, boolean allowEndOfInput) throws InterruptedException, IOException {
            ensureBufferCapacity(this.bufferPosition + length);
            int i = input.read(this.buffer, this.bufferPosition, length);
            if (i != -1) {
                this.bufferPosition += i;
                return i;
            }
            if (allowEndOfInput) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray buffer, int length) {
            ensureBufferCapacity(this.bufferPosition + length);
            buffer.readBytes(this.buffer, this.bufferPosition, length);
            this.bufferPosition += length;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long timeUs, int flags, int size, int offset, TrackOutput.CryptoData cryptoData) {
            Assertions.checkNotNull(this.format);
            ParsableByteArray sampleAndTrimBuffer = getSampleAndTrimBuffer(size, offset);
            if (!Util.areEqual(this.format.sampleMimeType, this.delegateFormat.sampleMimeType)) {
                if ("application/x-emsg".equals(this.format.sampleMimeType)) {
                    EventMessage eventMessageDecode = this.emsgDecoder.decode(sampleAndTrimBuffer);
                    if (!emsgContainsExpectedWrappedFormat(eventMessageDecode)) {
                        Log.w("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.delegateFormat.sampleMimeType, eventMessageDecode.getWrappedMetadataFormat()));
                        return;
                    }
                    sampleAndTrimBuffer = new ParsableByteArray((byte[]) Assertions.checkNotNull(eventMessageDecode.getWrappedMetadataBytes()));
                } else {
                    Log.w("EmsgUnwrappingTrackOutput", "Ignoring sample for unsupported format: " + this.format.sampleMimeType);
                    return;
                }
            }
            int iBytesLeft = sampleAndTrimBuffer.bytesLeft();
            this.delegate.sampleData(sampleAndTrimBuffer, iBytesLeft);
            this.delegate.sampleMetadata(timeUs, flags, iBytesLeft, offset, cryptoData);
        }

        private boolean emsgContainsExpectedWrappedFormat(EventMessage emsg) {
            Format wrappedMetadataFormat = emsg.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && Util.areEqual(this.delegateFormat.sampleMimeType, wrappedMetadataFormat.sampleMimeType);
        }

        private void ensureBufferCapacity(int requiredLength) {
            byte[] bArr = this.buffer;
            if (bArr.length < requiredLength) {
                this.buffer = Arrays.copyOf(bArr, requiredLength + (requiredLength / 2));
            }
        }

        private ParsableByteArray getSampleAndTrimBuffer(int size, int offset) {
            int i = this.bufferPosition - offset;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.buffer, i - size, i));
            byte[] bArr = this.buffer;
            System.arraycopy(bArr, i, bArr, 0, offset);
            this.bufferPosition = offset;
            return parsableByteArray;
        }
    }
}
