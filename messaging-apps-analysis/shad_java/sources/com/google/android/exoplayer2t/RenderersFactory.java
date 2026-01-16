package com.google.android.exoplayer2t;

import android.os.Handler;
import com.google.android.exoplayer2t.audio.AudioRendererEventListener;
import com.google.android.exoplayer2t.drm.DrmSessionManager;
import com.google.android.exoplayer2t.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2t.metadata.MetadataOutput;
import com.google.android.exoplayer2t.text.TextOutput;
import com.google.android.exoplayer2t.video.VideoRendererEventListener;

/* loaded from: classes.dex */
public interface RenderersFactory {
    Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager);
}
