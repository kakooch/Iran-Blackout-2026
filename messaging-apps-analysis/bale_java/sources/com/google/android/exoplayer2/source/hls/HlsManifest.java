package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;

/* loaded from: classes2.dex */
public final class HlsManifest {
    public final HlsMasterPlaylist a;
    public final HlsMultivariantPlaylist b;
    public final HlsMediaPlaylist c;

    HlsManifest(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.b = hlsMultivariantPlaylist;
        this.c = hlsMediaPlaylist;
        this.a = new HlsMasterPlaylist(hlsMultivariantPlaylist.a, hlsMultivariantPlaylist.b, hlsMultivariantPlaylist.e, hlsMultivariantPlaylist.f, hlsMultivariantPlaylist.g, hlsMultivariantPlaylist.h, hlsMultivariantPlaylist.i, hlsMultivariantPlaylist.j, hlsMultivariantPlaylist.k, hlsMultivariantPlaylist.c, hlsMultivariantPlaylist.l, hlsMultivariantPlaylist.m);
    }
}
