package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;

@Deprecated
/* loaded from: classes.dex */
public final class ExoPlayerFactory {
    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, int i) {
        return newSimpleInstance(context, new DefaultRenderersFactory(context).setExtensionRendererMode(i), trackSelector, loadControl);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector) {
        return newSimpleInstance(context, new DefaultRenderersFactory(context), trackSelector);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector) {
        return newSimpleInstance(context, renderersFactory, trackSelector, new DefaultLoadControl());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, Util.getCurrentOrMainLooper());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, new AnalyticsCollector(Clock.DEFAULT), looper);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, AnalyticsCollector analyticsCollector, Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, DefaultBandwidthMeter.getSingletonInstance(context), analyticsCollector, looper);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, Looper looper) {
        return new SimpleExoPlayer(context, renderersFactory, trackSelector, new DefaultMediaSourceFactory(context), loadControl, bandwidthMeter, analyticsCollector, true, Clock.DEFAULT, looper);
    }
}
