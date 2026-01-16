package com.google.android.exoplayer2t.source.hls.playlist;

import com.google.android.exoplayer2t.upstream.ParsingLoadable;

/* loaded from: classes.dex */
public interface HlsPlaylistParserFactory {
    ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser();

    ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist);
}
