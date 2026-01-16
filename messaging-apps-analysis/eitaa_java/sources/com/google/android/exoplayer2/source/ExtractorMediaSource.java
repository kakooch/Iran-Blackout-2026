package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import ir.eitaa.messenger.exoplayer2.upstream.DataSource$Factory;
import java.io.IOException;

@Deprecated
/* loaded from: classes.dex */
public final class ExtractorMediaSource extends CompositeMediaSource<Void> {
    private final ProgressiveMediaSource progressiveMediaSource;

    @Deprecated
    public interface EventListener {
        void onLoadError(IOException error);
    }

    @Deprecated
    public static final class Factory {
        private int continueLoadingCheckIntervalBytes;
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;
        private ExtractorsFactory extractorsFactory;
        private boolean isCreateCalled;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private Object tag;

        public Factory(DataSource$Factory dataSourceFactory) {
            this.dataSourceFactory = (DataSource.Factory) dataSourceFactory;
            setMinLoadableRetryCount(-1);
            this.continueLoadingCheckIntervalBytes = 1048576;
        }

        @Deprecated
        public Factory setMinLoadableRetryCount(int minLoadableRetryCount) {
            return setLoadErrorHandlingPolicy(new DefaultLoadErrorHandlingPolicy(minLoadableRetryCount));
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        public ExtractorMediaSource createMediaSource(Uri uri) {
            this.isCreateCalled = true;
            if (this.extractorsFactory == null) {
                this.extractorsFactory = new DefaultExtractorsFactory();
            }
            return new ExtractorMediaSource(uri, this.dataSourceFactory, this.extractorsFactory, this.loadErrorHandlingPolicy, this.customCacheKey, this.continueLoadingCheckIntervalBytes, this.tag);
        }
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory dataSourceFactory, ExtractorsFactory extractorsFactory, Handler eventHandler, EventListener eventListener) {
        this(uri, dataSourceFactory, extractorsFactory, eventHandler, eventListener, null);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory dataSourceFactory, ExtractorsFactory extractorsFactory, Handler eventHandler, EventListener eventListener, String customCacheKey) {
        this(uri, dataSourceFactory, extractorsFactory, eventHandler, eventListener, customCacheKey, 1048576);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory dataSourceFactory, ExtractorsFactory extractorsFactory, Handler eventHandler, EventListener eventListener, String customCacheKey, int continueLoadingCheckIntervalBytes) {
        this(uri, dataSourceFactory, extractorsFactory, new DefaultLoadErrorHandlingPolicy(), customCacheKey, continueLoadingCheckIntervalBytes, (Object) null);
        if (eventListener == null || eventHandler == null) {
            return;
        }
        addEventListener(eventHandler, new EventListenerWrapper(eventListener));
    }

    private ExtractorMediaSource(Uri uri, DataSource.Factory dataSourceFactory, ExtractorsFactory extractorsFactory, LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy, String customCacheKey, int continueLoadingCheckIntervalBytes, Object tag) {
        this.progressiveMediaSource = new ProgressiveMediaSource(uri, dataSourceFactory, extractorsFactory, DrmSessionManager.CC.getDummyDrmSessionManager(), loadableLoadErrorHandlingPolicy, customCacheKey, continueLoadingCheckIntervalBytes, tag);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener mediaTransferListener) {
        super.prepareSourceInternal(mediaTransferListener);
        prepareChildSource(null, this.progressiveMediaSource);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0$CompositeMediaSource(Void id, MediaSource mediaSource, Timeline timeline) {
        refreshSourceInfo(timeline);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId id, Allocator allocator, long startPositionUs) {
        return this.progressiveMediaSource.createPeriod(id, allocator, startPositionUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.progressiveMediaSource.releasePeriod(mediaPeriod);
    }

    @Deprecated
    private static final class EventListenerWrapper implements MediaSourceEventListener {
        private final EventListener eventListener;

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onDownstreamFormatChanged(this, i, mediaPeriodId, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onLoadCanceled(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onLoadCompleted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onLoadStarted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSourceEventListener.CC.$default$onMediaPeriodCreated(this, i, mediaPeriodId);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSourceEventListener.CC.$default$onMediaPeriodReleased(this, i, mediaPeriodId);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSourceEventListener.CC.$default$onReadingStarted(this, i, mediaPeriodId);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onUpstreamDiscarded(this, i, mediaPeriodId, mediaLoadData);
        }

        public EventListenerWrapper(EventListener eventListener) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
            this.eventListener.onLoadError(error);
        }
    }
}
