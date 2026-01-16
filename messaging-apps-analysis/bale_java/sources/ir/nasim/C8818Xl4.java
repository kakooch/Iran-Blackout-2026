package ir.nasim;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import ir.nasim.C16675lg5;

/* renamed from: ir.nasim.Xl4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8818Xl4 {
    private final C16675lg5 a;

    /* renamed from: ir.nasim.Xl4$a */
    private final class a implements C16675lg5.e {
        private final MediaControllerCompat a;
        final /* synthetic */ C8818Xl4 b;

        public a(C8818Xl4 c8818Xl4, MediaControllerCompat mediaControllerCompat) {
            AbstractC13042fc3.i(mediaControllerCompat, "mediaController");
            this.b = c8818Xl4;
            this.a = mediaControllerCompat;
        }

        @Override // ir.nasim.C16675lg5.e
        public PendingIntent a(com.google.android.exoplayer2.z0 z0Var) {
            AbstractC13042fc3.i(z0Var, "player");
            return this.a.e();
        }

        @Override // ir.nasim.C16675lg5.e
        public CharSequence b(com.google.android.exoplayer2.z0 z0Var) {
            AbstractC13042fc3.i(z0Var, "player");
            return String.valueOf(this.a.b().e().j());
        }

        @Override // ir.nasim.C16675lg5.e
        public CharSequence c(com.google.android.exoplayer2.z0 z0Var) {
            AbstractC13042fc3.i(z0Var, "player");
            return String.valueOf(this.a.b().e().i());
        }

        @Override // ir.nasim.C16675lg5.e
        public Bitmap e(com.google.android.exoplayer2.z0 z0Var, C16675lg5.b bVar) {
            AbstractC13042fc3.i(z0Var, "player");
            AbstractC13042fc3.i(bVar, "callback");
            return this.a.b().e().d();
        }
    }

    public C8818Xl4(Context context, MediaSessionCompat.Token token, C16675lg5.g gVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(token, "sessionToken");
        AbstractC13042fc3.i(gVar, "notificationListener");
        C16675lg5 c16675lg5A = new C16675lg5.c(context, 123, "EXO_SERVICE_NOTIFICATION", new a(this, new MediaControllerCompat(context, token))).c(AbstractC12217eE5.audio_notification_channel).b(AbstractC12217eE5.audio_notification_channel).d(gVar).a();
        c16675lg5A.v(KB5.ba_media_music);
        c16675lg5A.t(token);
        c16675lg5A.q(C5495Jo7.a.s());
        c16675lg5A.r(false);
        c16675lg5A.w(false);
        c16675lg5A.x(true);
        this.a = c16675lg5A;
    }

    public final void a() {
        this.a.u(null);
    }

    public final void b(com.google.android.exoplayer2.z0 z0Var) {
        this.a.u(z0Var);
        this.a.x(true);
    }
}
