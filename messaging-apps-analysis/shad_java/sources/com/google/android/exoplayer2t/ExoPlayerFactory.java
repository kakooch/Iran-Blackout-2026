package com.google.android.exoplayer2t;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2t.analytics.AnalyticsCollector;
import com.google.android.exoplayer2t.drm.DrmSessionManager;
import com.google.android.exoplayer2t.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2t.trackselection.TrackSelector;
import com.google.android.exoplayer2t.upstream.BandwidthMeter;
import com.google.android.exoplayer2t.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2t.util.Clock;
import com.google.android.exoplayer2t.util.Util;

@Deprecated
/* loaded from: classes.dex */
public final class ExoPlayerFactory {
    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i) {
        return newSimpleInstance(context, new DefaultRenderersFactory(context).setExtensionRendererMode(i), trackSelector, loadControl, drmSessionManager);
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
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl) {
        return newSimpleInstance(context, new DefaultRenderersFactory(context), trackSelector, loadControl);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, null, Util.getLooper());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, Util.getLooper());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, new AnalyticsCollector(Clock.DEFAULT), looper);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, AnalyticsCollector analyticsCollector, Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, DefaultBandwidthMeter.getSingletonInstance(context), analyticsCollector, looper);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, Looper looper) {
        return new SimpleExoPlayer(context, renderersFactory, trackSelector, loadControl, drmSessionManager, bandwidthMeter, analyticsCollector, Clock.DEFAULT, looper);
    }
}
