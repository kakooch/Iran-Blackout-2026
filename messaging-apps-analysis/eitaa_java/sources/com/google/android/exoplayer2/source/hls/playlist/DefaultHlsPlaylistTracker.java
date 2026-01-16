package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static final HlsPlaylistTracker.Factory FACTORY = new HlsPlaylistTracker.Factory() { // from class: com.google.android.exoplayer2.source.hls.playlist.-$$Lambda$v4Cu38iwTNBS0lObDF_BajWNhwg
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory
        public final HlsPlaylistTracker createTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            return new DefaultHlsPlaylistTracker(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory);
        }
    };
    private final HlsDataSourceFactory dataSourceFactory;
    private MediaSourceEventListener.EventDispatcher eventDispatcher;
    private Loader initialPlaylistLoader;
    private long initialStartTimeUs;
    private boolean isLive;
    private final List<HlsPlaylistTracker.PlaylistEventListener> listeners;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private HlsMasterPlaylist masterPlaylist;
    private ParsingLoadable.Parser<HlsPlaylist> mediaPlaylistParser;
    private final HashMap<Uri, MediaPlaylistBundle> playlistBundles;
    private final HlsPlaylistParserFactory playlistParserFactory;
    private Handler playlistRefreshHandler;
    private final double playlistStuckTargetDurationCoefficient;
    private HlsMediaPlaylist primaryMediaPlaylistSnapshot;
    private Uri primaryMediaPlaylistUrl;
    private HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener;

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory dataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory playlistParserFactory) {
        this(dataSourceFactory, loadErrorHandlingPolicy, playlistParserFactory, 3.5d);
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory dataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory playlistParserFactory, double playlistStuckTargetDurationCoefficient) {
        this.dataSourceFactory = dataSourceFactory;
        this.playlistParserFactory = playlistParserFactory;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.playlistStuckTargetDurationCoefficient = playlistStuckTargetDurationCoefficient;
        this.listeners = new ArrayList();
        this.playlistBundles = new HashMap<>();
        this.initialStartTimeUs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void start(Uri initialPlaylistUri, MediaSourceEventListener.EventDispatcher eventDispatcher, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        this.playlistRefreshHandler = new Handler();
        this.eventDispatcher = eventDispatcher;
        this.primaryPlaylistListener = primaryPlaylistListener;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.dataSourceFactory.createDataSource(4), initialPlaylistUri, 4, this.playlistParserFactory.createPlaylistParser());
        Assertions.checkState(this.initialPlaylistLoader == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.initialPlaylistLoader = loader;
        eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, loader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type)));
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.primaryMediaPlaylistUrl = null;
        this.primaryMediaPlaylistSnapshot = null;
        this.masterPlaylist = null;
        this.initialStartTimeUs = -9223372036854775807L;
        this.initialPlaylistLoader.release();
        this.initialPlaylistLoader = null;
        Iterator<MediaPlaylistBundle> it = this.playlistBundles.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.playlistRefreshHandler.removeCallbacksAndMessages(null);
        this.playlistRefreshHandler = null;
        this.playlistBundles.clear();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void addListener(HlsPlaylistTracker.PlaylistEventListener listener) {
        this.listeners.add(listener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void removeListener(HlsPlaylistTracker.PlaylistEventListener listener) {
        this.listeners.remove(listener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public HlsMasterPlaylist getMasterPlaylist() {
        return this.masterPlaylist;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public HlsMediaPlaylist getPlaylistSnapshot(Uri url, boolean isForPlayback) {
        HlsMediaPlaylist playlistSnapshot = this.playlistBundles.get(url).getPlaylistSnapshot();
        if (playlistSnapshot != null && isForPlayback) {
            maybeSetPrimaryUrl(url);
        }
        return playlistSnapshot;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long getInitialStartTimeUs() {
        return this.initialStartTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isSnapshotValid(Uri url) {
        return this.playlistBundles.get(url).isSnapshotValid();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        Loader loader = this.initialPlaylistLoader;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.primaryMediaPlaylistUrl;
        if (uri != null) {
            maybeThrowPlaylistRefreshError(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPlaylistRefreshError(Uri url) throws IOException {
        this.playlistBundles.get(url).maybeThrowPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void refreshPlaylist(Uri url) {
        this.playlistBundles.get(url).loadPlaylist();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.isLive;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> loadable, long elapsedRealtimeMs, long loadDurationMs) {
        HlsMasterPlaylist hlsMasterPlaylistCreateSingleVariantMasterPlaylist;
        HlsPlaylist result = loadable.getResult();
        boolean z = result instanceof HlsMediaPlaylist;
        if (z) {
            hlsMasterPlaylistCreateSingleVariantMasterPlaylist = HlsMasterPlaylist.createSingleVariantMasterPlaylist(result.baseUri);
        } else {
            hlsMasterPlaylistCreateSingleVariantMasterPlaylist = (HlsMasterPlaylist) result;
        }
        this.masterPlaylist = hlsMasterPlaylistCreateSingleVariantMasterPlaylist;
        this.mediaPlaylistParser = this.playlistParserFactory.createPlaylistParser(hlsMasterPlaylistCreateSingleVariantMasterPlaylist);
        this.primaryMediaPlaylistUrl = hlsMasterPlaylistCreateSingleVariantMasterPlaylist.variants.get(0).url;
        createBundles(hlsMasterPlaylistCreateSingleVariantMasterPlaylist.mediaPlaylistUrls);
        MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(this.primaryMediaPlaylistUrl);
        if (!z) {
            mediaPlaylistBundle.loadPlaylist();
        } else {
            mediaPlaylistBundle.processLoadedPlaylist((HlsMediaPlaylist) result, loadDurationMs);
        }
        this.eventDispatcher.loadCompleted(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), 4, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
        this.eventDispatcher.loadCanceled(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), 4, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadable.type, loadDurationMs, error, errorCount);
        boolean z = retryDelayMsFor == -9223372036854775807L;
        this.eventDispatcher.loadError(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), 4, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded(), error, z);
        if (z) {
            return Loader.DONT_RETRY_FATAL;
        }
        return Loader.createRetryAction(false, retryDelayMsFor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeSelectNewPrimaryUrl() {
        List<HlsMasterPlaylist.Variant> list = this.masterPlaylist.variants;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(list.get(i).url);
            if (jElapsedRealtime > mediaPlaylistBundle.blacklistUntilMs) {
                this.primaryMediaPlaylistUrl = mediaPlaylistBundle.playlistUrl;
                mediaPlaylistBundle.loadPlaylist();
                return true;
            }
        }
        return false;
    }

    private void maybeSetPrimaryUrl(Uri url) {
        if (url.equals(this.primaryMediaPlaylistUrl) || !isVariantUrl(url)) {
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylist = this.primaryMediaPlaylistSnapshot;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.hasEndTag) {
            this.primaryMediaPlaylistUrl = url;
            this.playlistBundles.get(url).loadPlaylist();
        }
    }

    private boolean isVariantUrl(Uri playlistUrl) {
        List<HlsMasterPlaylist.Variant> list = this.masterPlaylist.variants;
        for (int i = 0; i < list.size(); i++) {
            if (playlistUrl.equals(list.get(i).url)) {
                return true;
            }
        }
        return false;
    }

    private void createBundles(List<Uri> urls) {
        int size = urls.size();
        for (int i = 0; i < size; i++) {
            Uri uri = urls.get(i);
            this.playlistBundles.put(uri, new MediaPlaylistBundle(uri));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlaylistUpdated(Uri url, HlsMediaPlaylist newSnapshot) {
        if (url.equals(this.primaryMediaPlaylistUrl)) {
            if (this.primaryMediaPlaylistSnapshot == null) {
                this.isLive = !newSnapshot.hasEndTag;
                this.initialStartTimeUs = newSnapshot.startTimeUs;
            }
            this.primaryMediaPlaylistSnapshot = newSnapshot;
            this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(newSnapshot);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).onPlaylistChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPlaylistError(Uri playlistUrl, long blacklistDurationMs) {
        int size = this.listeners.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            z |= !this.listeners.get(i).onPlaylistError(playlistUrl, blacklistDurationMs);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HlsMediaPlaylist getLatestPlaylistSnapshot(HlsMediaPlaylist oldPlaylist, HlsMediaPlaylist loadedPlaylist) {
        if (loadedPlaylist.isNewerThan(oldPlaylist)) {
            return loadedPlaylist.copyWith(getLoadedPlaylistStartTimeUs(oldPlaylist, loadedPlaylist), getLoadedPlaylistDiscontinuitySequence(oldPlaylist, loadedPlaylist));
        }
        return loadedPlaylist.hasEndTag ? oldPlaylist.copyWithEndTag() : oldPlaylist;
    }

    private long getLoadedPlaylistStartTimeUs(HlsMediaPlaylist oldPlaylist, HlsMediaPlaylist loadedPlaylist) {
        if (loadedPlaylist.hasProgramDateTime) {
            return loadedPlaylist.startTimeUs;
        }
        HlsMediaPlaylist hlsMediaPlaylist = this.primaryMediaPlaylistSnapshot;
        long j = hlsMediaPlaylist != null ? hlsMediaPlaylist.startTimeUs : 0L;
        if (oldPlaylist == null) {
            return j;
        }
        int size = oldPlaylist.segments.size();
        HlsMediaPlaylist.Segment firstOldOverlappingSegment = getFirstOldOverlappingSegment(oldPlaylist, loadedPlaylist);
        if (firstOldOverlappingSegment != null) {
            return oldPlaylist.startTimeUs + firstOldOverlappingSegment.relativeStartTimeUs;
        }
        return ((long) size) == loadedPlaylist.mediaSequence - oldPlaylist.mediaSequence ? oldPlaylist.getEndTimeUs() : j;
    }

    private int getLoadedPlaylistDiscontinuitySequence(HlsMediaPlaylist oldPlaylist, HlsMediaPlaylist loadedPlaylist) {
        HlsMediaPlaylist.Segment firstOldOverlappingSegment;
        if (loadedPlaylist.hasDiscontinuitySequence) {
            return loadedPlaylist.discontinuitySequence;
        }
        HlsMediaPlaylist hlsMediaPlaylist = this.primaryMediaPlaylistSnapshot;
        int i = hlsMediaPlaylist != null ? hlsMediaPlaylist.discontinuitySequence : 0;
        return (oldPlaylist == null || (firstOldOverlappingSegment = getFirstOldOverlappingSegment(oldPlaylist, loadedPlaylist)) == null) ? i : (oldPlaylist.discontinuitySequence + firstOldOverlappingSegment.relativeDiscontinuitySequence) - loadedPlaylist.segments.get(0).relativeDiscontinuitySequence;
    }

    private static HlsMediaPlaylist.Segment getFirstOldOverlappingSegment(HlsMediaPlaylist oldPlaylist, HlsMediaPlaylist loadedPlaylist) {
        int i = (int) (loadedPlaylist.mediaSequence - oldPlaylist.mediaSequence);
        List<HlsMediaPlaylist.Segment> list = oldPlaylist.segments;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    private final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>>, Runnable {
        private long blacklistUntilMs;
        private long earliestNextLoadTimeMs;
        private long lastSnapshotChangeMs;
        private long lastSnapshotLoadMs;
        private boolean loadPending;
        private final ParsingLoadable<HlsPlaylist> mediaPlaylistLoadable;
        private final Loader mediaPlaylistLoader = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        private IOException playlistError;
        private HlsMediaPlaylist playlistSnapshot;
        private final Uri playlistUrl;

        public MediaPlaylistBundle(Uri playlistUrl) {
            this.playlistUrl = playlistUrl;
            this.mediaPlaylistLoadable = new ParsingLoadable<>(DefaultHlsPlaylistTracker.this.dataSourceFactory.createDataSource(4), playlistUrl, 4, DefaultHlsPlaylistTracker.this.mediaPlaylistParser);
        }

        public HlsMediaPlaylist getPlaylistSnapshot() {
            return this.playlistSnapshot;
        }

        public boolean isSnapshotValid() {
            int i;
            if (this.playlistSnapshot == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, C.usToMs(this.playlistSnapshot.durationUs));
            HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
            return hlsMediaPlaylist.hasEndTag || (i = hlsMediaPlaylist.playlistType) == 2 || i == 1 || this.lastSnapshotLoadMs + jMax > jElapsedRealtime;
        }

        public void release() {
            this.mediaPlaylistLoader.release();
        }

        public void loadPlaylist() {
            this.blacklistUntilMs = 0L;
            if (this.loadPending || this.mediaPlaylistLoader.isLoading() || this.mediaPlaylistLoader.hasFatalError()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime < this.earliestNextLoadTimeMs) {
                this.loadPending = true;
                DefaultHlsPlaylistTracker.this.playlistRefreshHandler.postDelayed(this, this.earliestNextLoadTimeMs - jElapsedRealtime);
            } else {
                loadPlaylistImmediately();
            }
        }

        public void maybeThrowPlaylistRefreshError() throws IOException {
            this.mediaPlaylistLoader.maybeThrowError();
            IOException iOException = this.playlistError;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<HlsPlaylist> loadable, long elapsedRealtimeMs, long loadDurationMs) {
            HlsPlaylist result = loadable.getResult();
            if (result instanceof HlsMediaPlaylist) {
                processLoadedPlaylist((HlsMediaPlaylist) result, loadDurationMs);
                DefaultHlsPlaylistTracker.this.eventDispatcher.loadCompleted(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), 4, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
            } else {
                this.playlistError = new ParserException("Loaded playlist has unexpected type.");
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<HlsPlaylist> loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadCanceled(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), 4, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
            Loader.LoadErrorAction loadErrorActionCreateRetryAction;
            long blacklistDurationMsFor = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(loadable.type, loadDurationMs, error, errorCount);
            boolean z = blacklistDurationMsFor != -9223372036854775807L;
            boolean zBlacklistPlaylist = DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, blacklistDurationMsFor) || !z;
            if (z) {
                zBlacklistPlaylist |= blacklistPlaylist(blacklistDurationMsFor);
            }
            if (zBlacklistPlaylist) {
                long retryDelayMsFor = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadable.type, loadDurationMs, error, errorCount);
                if (retryDelayMsFor != -9223372036854775807L) {
                    loadErrorActionCreateRetryAction = Loader.createRetryAction(false, retryDelayMsFor);
                } else {
                    loadErrorActionCreateRetryAction = Loader.DONT_RETRY_FATAL;
                }
            } else {
                loadErrorActionCreateRetryAction = Loader.DONT_RETRY;
            }
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadError(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), 4, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded(), error, !loadErrorActionCreateRetryAction.isRetry());
            return loadErrorActionCreateRetryAction;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.loadPending = false;
            loadPlaylistImmediately();
        }

        private void loadPlaylistImmediately() {
            long jStartLoading = this.mediaPlaylistLoader.startLoading(this.mediaPlaylistLoadable, this, DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.mediaPlaylistLoadable.type));
            MediaSourceEventListener.EventDispatcher eventDispatcher = DefaultHlsPlaylistTracker.this.eventDispatcher;
            ParsingLoadable<HlsPlaylist> parsingLoadable = this.mediaPlaylistLoadable;
            eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, jStartLoading);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processLoadedPlaylist(HlsMediaPlaylist loadedPlaylist, long loadDurationMs) {
            long j;
            HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.lastSnapshotLoadMs = jElapsedRealtime;
            HlsMediaPlaylist latestPlaylistSnapshot = DefaultHlsPlaylistTracker.this.getLatestPlaylistSnapshot(hlsMediaPlaylist, loadedPlaylist);
            this.playlistSnapshot = latestPlaylistSnapshot;
            if (latestPlaylistSnapshot != hlsMediaPlaylist) {
                this.playlistError = null;
                this.lastSnapshotChangeMs = jElapsedRealtime;
                DefaultHlsPlaylistTracker.this.onPlaylistUpdated(this.playlistUrl, latestPlaylistSnapshot);
            } else if (!latestPlaylistSnapshot.hasEndTag) {
                long size = loadedPlaylist.mediaSequence + loadedPlaylist.segments.size();
                HlsMediaPlaylist hlsMediaPlaylist2 = this.playlistSnapshot;
                if (size < hlsMediaPlaylist2.mediaSequence) {
                    this.playlistError = new HlsPlaylistTracker.PlaylistResetException(this.playlistUrl);
                    DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, -9223372036854775807L);
                } else {
                    double d = jElapsedRealtime - this.lastSnapshotChangeMs;
                    double dUsToMs = C.usToMs(hlsMediaPlaylist2.targetDurationUs);
                    double d2 = DefaultHlsPlaylistTracker.this.playlistStuckTargetDurationCoefficient;
                    Double.isNaN(dUsToMs);
                    if (d > dUsToMs * d2) {
                        this.playlistError = new HlsPlaylistTracker.PlaylistStuckException(this.playlistUrl);
                        long blacklistDurationMsFor = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(4, loadDurationMs, this.playlistError, 1);
                        DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, blacklistDurationMsFor);
                        if (blacklistDurationMsFor != -9223372036854775807L) {
                            blacklistPlaylist(blacklistDurationMsFor);
                        }
                    }
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
            if (hlsMediaPlaylist3 != hlsMediaPlaylist) {
                j = hlsMediaPlaylist3.targetDurationUs;
            } else {
                j = hlsMediaPlaylist3.targetDurationUs / 2;
            }
            this.earliestNextLoadTimeMs = jElapsedRealtime + C.usToMs(j);
            if (!this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl) || this.playlistSnapshot.hasEndTag) {
                return;
            }
            loadPlaylist();
        }

        private boolean blacklistPlaylist(long blacklistDurationMs) {
            this.blacklistUntilMs = SystemClock.elapsedRealtime() + blacklistDurationMs;
            return this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl) && !DefaultHlsPlaylistTracker.this.maybeSelectNewPrimaryUrl();
        }
    }
}
