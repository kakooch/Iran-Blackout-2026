package ir.eitaa.messenger.exoplayer2.ext.rtmp;

import ir.eitaa.messenger.exoplayer2.upstream.DataSource$Factory;
import ir.eitaa.messenger.exoplayer2.upstream.TransferListener;

/* loaded from: classes.dex */
public final class RtmpDataSourceFactory implements DataSource$Factory {
    private final TransferListener<?> listener;

    public RtmpDataSourceFactory() {
        this(null);
    }

    public RtmpDataSourceFactory(TransferListener<?> listener) {
        this.listener = listener;
    }
}
