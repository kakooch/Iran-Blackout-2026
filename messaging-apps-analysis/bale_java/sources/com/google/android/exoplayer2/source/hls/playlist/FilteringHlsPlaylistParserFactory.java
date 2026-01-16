package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.k;
import ir.nasim.C20316ro2;
import java.util.List;

/* loaded from: classes2.dex */
public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    private final HlsPlaylistParserFactory a;
    private final List b;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory, List list) {
        this.a = hlsPlaylistParserFactory;
        this.b = list;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public k.a a() {
        return new C20316ro2(this.a.a(), this.b);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public k.a b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        return new C20316ro2(this.a.b(hlsMultivariantPlaylist, hlsMediaPlaylist), this.b);
    }
}
