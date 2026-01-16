package com.google.android.exoplayer2t.source.hls.playlist;

import com.google.android.exoplayer2t.upstream.ParsingLoadable;

/* loaded from: classes.dex */
public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    @Override // com.google.android.exoplayer2t.source.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser() {
        return new HlsPlaylistParser();
    }

    @Override // com.google.android.exoplayer2t.source.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist) {
        return new HlsPlaylistParser(hlsMasterPlaylist);
    }
}
