package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import ir.nasim.features.audioplayer.service.MusicService;

/* renamed from: ir.nasim.Zl4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9327Zl4 {
    private final C20298rm4 a;
    private final androidx.lifecycle.r b;
    private final C20298rm4 c;
    private final androidx.lifecycle.r d;
    private final C20298rm4 e;
    private final androidx.lifecycle.r f;
    public MediaControllerCompat g;
    private final a h;
    private final MediaBrowserCompat i;

    /* renamed from: ir.nasim.Zl4$a */
    private final class a extends MediaBrowserCompat.b {
        private final Context c;
        final /* synthetic */ C9327Zl4 d;

        public a(C9327Zl4 c9327Zl4, Context context) {
            AbstractC13042fc3.i(context, "context");
            this.d = c9327Zl4;
            this.c = context;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void a() {
            C19406qI3.a("MusicServiceConnection", "CONNECTED", new Object[0]);
            C9327Zl4 c9327Zl4 = this.d;
            MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.c, c9327Zl4.f().c());
            mediaControllerCompat.g(this.d.new b());
            c9327Zl4.k(mediaControllerCompat);
            this.d.a.n(Boolean.TRUE);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void b() {
            C19406qI3.a("MusicServiceConnection", "FAILED", new Object[0]);
            this.d.a.n(Boolean.FALSE);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void c() {
            C19406qI3.a("MusicServiceConnection", "SUSPENDED", new Object[0]);
            this.d.a.n(Boolean.FALSE);
        }
    }

    /* renamed from: ir.nasim.Zl4$b */
    private final class b extends MediaControllerCompat.a {
        public b() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void d(MediaMetadataCompat mediaMetadataCompat) {
            C9327Zl4.this.e.n(mediaMetadataCompat);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void e(PlaybackStateCompat playbackStateCompat) {
            if (playbackStateCompat != null) {
                C9327Zl4 c9327Zl4 = C9327Zl4.this;
                Integer num = (Integer) c9327Zl4.c.f();
                int iH = playbackStateCompat.h();
                if (num != null && num.intValue() == iH) {
                    return;
                }
                c9327Zl4.c.n(Integer.valueOf(playbackStateCompat.h()));
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void h(int i) {
            super.h(i);
            C7183Qq.s().putInt("audio_player_repeat_mode", i);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void i() {
            C9327Zl4.this.h.c();
        }
    }

    public C9327Zl4(Context context) {
        AbstractC13042fc3.i(context, "context");
        C20298rm4 c20298rm4 = new C20298rm4();
        this.a = c20298rm4;
        this.b = c20298rm4;
        C20298rm4 c20298rm42 = new C20298rm4();
        this.c = c20298rm42;
        this.d = c20298rm42;
        C20298rm4 c20298rm43 = new C20298rm4();
        this.e = c20298rm43;
        this.f = c20298rm43;
        a aVar = new a(this, context);
        this.h = aVar;
        this.i = new MediaBrowserCompat(context, new ComponentName(context, (Class<?>) MusicService.class), aVar, null);
    }

    public final androidx.lifecycle.r e() {
        return this.f;
    }

    public final MediaBrowserCompat f() {
        return this.i;
    }

    public final MediaControllerCompat g() {
        MediaControllerCompat mediaControllerCompat = this.g;
        if (mediaControllerCompat != null) {
            return mediaControllerCompat;
        }
        AbstractC13042fc3.y("mediaController");
        return null;
    }

    public final androidx.lifecycle.r h() {
        return this.d;
    }

    public final MediaControllerCompat.e i() {
        MediaControllerCompat.e eVarF = g().f();
        AbstractC13042fc3.h(eVarF, "getTransportControls(...)");
        return eVarF;
    }

    public final androidx.lifecycle.r j() {
        return this.b;
    }

    public final void k(MediaControllerCompat mediaControllerCompat) {
        AbstractC13042fc3.i(mediaControllerCompat, "<set-?>");
        this.g = mediaControllerCompat;
    }
}
