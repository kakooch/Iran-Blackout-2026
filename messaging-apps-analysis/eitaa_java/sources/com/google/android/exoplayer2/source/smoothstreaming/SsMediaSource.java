package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    private final SsChunkSource.Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionManager<?> drmSessionManager;
    private final long livePresentationDelayMs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private SsManifest manifest;
    private DataSource manifestDataSource;
    private final DataSource.Factory manifestDataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    private long manifestLoadStartTimestamp;
    private Loader manifestLoader;
    private LoaderErrorThrower manifestLoaderErrorThrower;
    private final ParsingLoadable.Parser<? extends SsManifest> manifestParser;
    private Handler manifestRefreshHandler;
    private final Uri manifestUri;
    private final ArrayList<SsMediaPeriod> mediaPeriods;
    private TransferListener mediaTransferListener;
    private final boolean sideloadedManifest;
    private final Object tag;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    public static final class Factory {
        private final SsChunkSource.Factory chunkSourceFactory;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManager<?> drmSessionManager;
        private long livePresentationDelayMs;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final DataSource.Factory manifestDataSourceFactory;

        public Factory(DataSource.Factory dataSourceFactory) {
            this(new DefaultSsChunkSource.Factory(dataSourceFactory), dataSourceFactory);
        }

        public Factory(SsChunkSource.Factory chunkSourceFactory, DataSource.Factory manifestDataSourceFactory) {
            this.chunkSourceFactory = (SsChunkSource.Factory) Assertions.checkNotNull(chunkSourceFactory);
            this.manifestDataSourceFactory = manifestDataSourceFactory;
            this.drmSessionManager = DrmSessionManager.CC.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.livePresentationDelayMs = 30000L;
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
        }
    }

    @Deprecated
    public SsMediaSource(Uri manifestUri, DataSource.Factory manifestDataSourceFactory, SsChunkSource.Factory chunkSourceFactory, Handler eventHandler, MediaSourceEventListener eventListener) {
        this(manifestUri, manifestDataSourceFactory, chunkSourceFactory, 3, 30000L, eventHandler, eventListener);
    }

    @Deprecated
    public SsMediaSource(Uri manifestUri, DataSource.Factory manifestDataSourceFactory, SsChunkSource.Factory chunkSourceFactory, int minLoadableRetryCount, long livePresentationDelayMs, Handler eventHandler, MediaSourceEventListener eventListener) {
        this(manifestUri, manifestDataSourceFactory, new SsManifestParser(), chunkSourceFactory, minLoadableRetryCount, livePresentationDelayMs, eventHandler, eventListener);
    }

    @Deprecated
    public SsMediaSource(Uri manifestUri, DataSource.Factory manifestDataSourceFactory, ParsingLoadable.Parser<? extends SsManifest> manifestParser, SsChunkSource.Factory chunkSourceFactory, int minLoadableRetryCount, long livePresentationDelayMs, Handler eventHandler, MediaSourceEventListener eventListener) {
        this(null, manifestUri, manifestDataSourceFactory, manifestParser, chunkSourceFactory, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.CC.getDummyDrmSessionManager(), new DefaultLoadErrorHandlingPolicy(minLoadableRetryCount), livePresentationDelayMs, null);
        if (eventHandler == null || eventListener == null) {
            return;
        }
        addEventListener(eventHandler, eventListener);
    }

    private SsMediaSource(SsManifest manifest, Uri manifestUri, DataSource.Factory manifestDataSourceFactory, ParsingLoadable.Parser<? extends SsManifest> manifestParser, SsChunkSource.Factory chunkSourceFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long livePresentationDelayMs, Object tag) {
        Assertions.checkState(manifest == null || !manifest.isLive);
        this.manifest = manifest;
        this.manifestUri = manifestUri == null ? null : SsUtil.fixManifestUri(manifestUri);
        this.manifestDataSourceFactory = manifestDataSourceFactory;
        this.manifestParser = manifestParser;
        this.chunkSourceFactory = chunkSourceFactory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.livePresentationDelayMs = livePresentationDelayMs;
        this.manifestEventDispatcher = createEventDispatcher(null);
        this.tag = tag;
        this.sideloadedManifest = manifest != null;
        this.mediaPeriods = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener mediaTransferListener) {
        this.mediaTransferListener = mediaTransferListener;
        this.drmSessionManager.prepare();
        if (this.sideloadedManifest) {
            this.manifestLoaderErrorThrower = new LoaderErrorThrower.Dummy();
            processManifest();
            return;
        }
        this.manifestDataSource = this.manifestDataSourceFactory.createDataSource();
        Loader loader = new Loader("Loader:Manifest");
        this.manifestLoader = loader;
        this.manifestLoaderErrorThrower = loader;
        this.manifestRefreshHandler = new Handler();
        startLoadingManifest();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId id, Allocator allocator, long startPositionUs) {
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.manifest, this.chunkSourceFactory, this.mediaTransferListener, this.compositeSequenceableLoaderFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, createEventDispatcher(id), this.manifestLoaderErrorThrower, allocator);
        this.mediaPeriods.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod period) {
        ((SsMediaPeriod) period).release();
        this.mediaPeriods.remove(period);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void releaseSourceInternal() {
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestDataSource = null;
        this.manifestLoadStartTimestamp = 0L;
        Loader loader = this.manifestLoader;
        if (loader != null) {
            loader.release();
            this.manifestLoader = null;
        }
        Handler handler = this.manifestRefreshHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.manifestRefreshHandler = null;
        }
        this.drmSessionManager.release();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<SsManifest> loadable, long elapsedRealtimeMs, long loadDurationMs) {
        this.manifestEventDispatcher.loadCompleted(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        this.manifest = loadable.getResult();
        this.manifestLoadStartTimestamp = elapsedRealtimeMs - loadDurationMs;
        processManifest();
        scheduleManifestRefresh();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<SsManifest> loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
        this.manifestEventDispatcher.loadCanceled(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(ParsingLoadable<SsManifest> loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
        Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(4, loadDurationMs, error, errorCount);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorActionCreateRetryAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorActionCreateRetryAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        this.manifestEventDispatcher.loadError(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded(), error, !loadErrorActionCreateRetryAction.isRetry());
        return loadErrorActionCreateRetryAction;
    }

    private void processManifest() {
        SinglePeriodTimeline singlePeriodTimeline;
        for (int i = 0; i < this.mediaPeriods.size(); i++) {
            this.mediaPeriods.get(i).updateManifest(this.manifest);
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.manifest.streamElements) {
            if (streamElement.chunkCount > 0) {
                jMax2 = Math.min(jMax2, streamElement.getStartTimeUs(0));
                jMax = Math.max(jMax, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
            }
        }
        if (jMax2 == Long.MAX_VALUE) {
            long j = this.manifest.isLive ? -9223372036854775807L : 0L;
            SsManifest ssManifest = this.manifest;
            boolean z = ssManifest.isLive;
            singlePeriodTimeline = new SinglePeriodTimeline(j, 0L, 0L, 0L, true, z, z, ssManifest, this.tag);
        } else {
            SsManifest ssManifest2 = this.manifest;
            if (ssManifest2.isLive) {
                long j2 = ssManifest2.dvrWindowLengthUs;
                if (j2 != -9223372036854775807L && j2 > 0) {
                    jMax2 = Math.max(jMax2, jMax - j2);
                }
                long j3 = jMax2;
                long j4 = jMax - j3;
                long jMsToUs = j4 - C.msToUs(this.livePresentationDelayMs);
                if (jMsToUs < 5000000) {
                    jMsToUs = Math.min(5000000L, j4 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline(-9223372036854775807L, j4, j3, jMsToUs, true, true, true, this.manifest, this.tag);
            } else {
                long j5 = ssManifest2.durationUs;
                long j6 = j5 != -9223372036854775807L ? j5 : jMax - jMax2;
                singlePeriodTimeline = new SinglePeriodTimeline(jMax2 + j6, j6, jMax2, 0L, true, false, false, this.manifest, this.tag);
            }
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    private void scheduleManifestRefresh() {
        if (this.manifest.isLive) {
            this.manifestRefreshHandler.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.-$$Lambda$SsMediaSource$jl1D4lFyOlMeu1xBKIXvLsVW-do
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.startLoadingManifest();
                }
            }, Math.max(0L, (this.manifestLoadStartTimestamp + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        if (this.manifestLoader.hasFatalError()) {
            return;
        }
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.manifestDataSource, this.manifestUri, 4, this.manifestParser);
        this.manifestEventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.manifestLoader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type)));
    }
}
