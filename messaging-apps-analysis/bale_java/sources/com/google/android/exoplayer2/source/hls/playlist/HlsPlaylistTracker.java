package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.j;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface HlsPlaylistTracker {

    public interface Factory {
        HlsPlaylistTracker a(HlsDataSourceFactory hlsDataSourceFactory, j jVar, HlsPlaylistParserFactory hlsPlaylistParserFactory);
    }

    public interface PlaylistEventListener {
        void b();

        boolean g(Uri uri, j.c cVar, boolean z);
    }

    public static final class PlaylistResetException extends IOException {
        public final Uri a;

        public PlaylistResetException(Uri uri) {
            this.a = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {
        public final Uri a;

        public PlaylistStuckException(Uri uri) {
            this.a = uri;
        }
    }

    public interface PrimaryPlaylistListener {
        void k(HlsMediaPlaylist hlsMediaPlaylist);
    }

    void a(PlaylistEventListener playlistEventListener);

    void b(Uri uri);

    long c();

    HlsMultivariantPlaylist d();

    void e(Uri uri);

    void f(PlaylistEventListener playlistEventListener);

    boolean h(Uri uri);

    boolean i();

    boolean k(Uri uri, long j);

    void l(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, PrimaryPlaylistListener primaryPlaylistListener);

    void m();

    HlsMediaPlaylist o(Uri uri, boolean z);

    void stop();
}
