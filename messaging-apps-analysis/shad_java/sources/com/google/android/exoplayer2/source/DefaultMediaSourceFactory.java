package com.google.android.exoplayer2.source;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

/* loaded from: classes.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private final DataSource.Factory dataSourceFactory;
    private final MediaSourceDrmHelper mediaSourceDrmHelper;
    private final SparseArray<MediaSourceFactory> mediaSourceFactories;
    private final int[] supportedTypes;

    public DefaultMediaSourceFactory(Context context) {
        this(new DefaultDataSourceFactory(context));
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this(new DefaultDataSourceFactory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        this.mediaSourceDrmHelper = new MediaSourceDrmHelper();
        SparseArray<MediaSourceFactory> sparseArrayLoadDelegates = loadDelegates(factory, extractorsFactory);
        this.mediaSourceFactories = sparseArrayLoadDelegates;
        this.supportedTypes = new int[sparseArrayLoadDelegates.size()];
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.supportedTypes[i] = this.mediaSourceFactories.keyAt(i);
        }
    }

    private static SparseArray<MediaSourceFactory> loadDelegates(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        SparseArray<MediaSourceFactory> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (MediaSourceFactory) DashMediaSource.Factory.class.asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (MediaSourceFactory) SsMediaSource.Factory.class.asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (MediaSourceFactory) HlsMediaSource.Factory.class.asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new ProgressiveMediaSource.Factory(factory, extractorsFactory));
        return sparseArray;
    }
}
