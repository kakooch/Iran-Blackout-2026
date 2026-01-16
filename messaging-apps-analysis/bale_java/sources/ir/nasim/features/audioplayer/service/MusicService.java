package ir.nasim.features.audioplayer.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.Toast;
import androidx.media.MediaBrowserServiceCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16632lc2;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC24575yq7;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C12366eV1;
import ir.nasim.C13519gN;
import ir.nasim.C16675lg5;
import ir.nasim.C18274oO;
import ir.nasim.C19406qI3;
import ir.nasim.C19795qx1;
import ir.nasim.C19938rB7;
import ir.nasim.C21352tW3;
import ir.nasim.C23709xO;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C8818Xl4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16501lO;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.P17;
import ir.nasim.XY3;
import ir.nasim.features.audioplayer.service.MusicService;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0004JKLMB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J)\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J+\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cH\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u00060&R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006N"}, d2 = {"Lir/nasim/features/audioplayer/service/MusicService;", "Landroidx/media/MediaBrowserServiceCompat;", "<init>", "()V", "Lir/nasim/rB7;", "x", "y", "onCreate", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "rootIntent", "onTaskRemoved", "(Landroid/content/Intent;)V", "onDestroy", "", "clientPackageName", "clientUid", "Landroid/os/Bundle;", "rootHints", "Landroidx/media/MediaBrowserServiceCompat$e;", "e", "(Ljava/lang/String;ILandroid/os/Bundle;)Landroidx/media/MediaBrowserServiceCompat$e;", "parentId", "Landroidx/media/MediaBrowserServiceCompat$l;", "", "Landroid/support/v4/media/MediaBrowserCompat$MediaItem;", "result", "f", "(Ljava/lang/String;Landroidx/media/MediaBrowserServiceCompat$l;)V", "Lcom/google/android/exoplayer2/audio/a;", "i", "Lcom/google/android/exoplayer2/audio/a;", "exoAudioAttributes", "Lir/nasim/features/audioplayer/service/MusicService$c;", "j", "Lir/nasim/features/audioplayer/service/MusicService$c;", "musicPlayerEventListener", "Lcom/google/android/exoplayer2/k;", "k", "Lcom/google/android/exoplayer2/k;", "exoPlayer", "Lir/nasim/Xl4;", "l", "Lir/nasim/Xl4;", "musicNotificationManager", "Landroid/support/v4/media/session/MediaSessionCompat;", "m", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSession", "Lir/nasim/XY3;", "n", "Lir/nasim/XY3;", "mediaSessionConnector", "Lir/nasim/qx1;", "o", "Lir/nasim/qx1;", "customMediaSourceFactory", "", "p", "Z", "z", "()Z", "B", "(Z)V", "isForegroundService", "Lir/nasim/ro1;", "q", "Lir/nasim/ro1;", "serviceScope", "b", "a", "d", "c", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class MusicService extends MediaBrowserServiceCompat {

    /* renamed from: i, reason: from kotlin metadata */
    private final com.google.android.exoplayer2.audio.a exoAudioAttributes;

    /* renamed from: j, reason: from kotlin metadata */
    private final c musicPlayerEventListener;

    /* renamed from: k, reason: from kotlin metadata */
    private InterfaceC2037k exoPlayer;

    /* renamed from: l, reason: from kotlin metadata */
    private C8818Xl4 musicNotificationManager;

    /* renamed from: m, reason: from kotlin metadata */
    private MediaSessionCompat mediaSession;

    /* renamed from: n, reason: from kotlin metadata */
    private XY3 mediaSessionConnector;

    /* renamed from: o, reason: from kotlin metadata */
    private C19795qx1 customMediaSourceFactory;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean isForegroundService;

    /* renamed from: q, reason: from kotlin metadata */
    private final InterfaceC20315ro1 serviceScope;

    private final class a implements XY3.i {
        public a() {
        }

        @Override // ir.nasim.XY3.i
        public void a(String str, boolean z, Bundle bundle) {
            AbstractC13042fc3.i(str, "query");
        }

        @Override // ir.nasim.XY3.i
        public void e(boolean z) {
        }

        @Override // ir.nasim.XY3.i
        public long f() {
            return 2393124L;
        }

        @Override // ir.nasim.XY3.i
        public void g(Uri uri, boolean z, Bundle bundle) {
            AbstractC13042fc3.i(uri, "uri");
        }

        @Override // ir.nasim.XY3.c
        public boolean h(z0 z0Var, String str, Bundle bundle, ResultReceiver resultReceiver) {
            AbstractC13042fc3.i(z0Var, "player");
            AbstractC13042fc3.i(str, "command");
            return false;
        }

        @Override // ir.nasim.XY3.i
        public void m(String str, boolean z, Bundle bundle) {
            AbstractC13042fc3.i(str, "mediaId");
            InterfaceC2037k interfaceC2037k = MusicService.this.exoPlayer;
            if (interfaceC2037k != null) {
                interfaceC2037k.C0(C13519gN.a.r());
            }
            InterfaceC2037k interfaceC2037k2 = MusicService.this.exoPlayer;
            if (interfaceC2037k2 != null) {
                interfaceC2037k2.U(C13519gN.a.O(str), 0L);
            }
            InterfaceC2037k interfaceC2037k3 = MusicService.this.exoPlayer;
            if (interfaceC2037k3 != null) {
                interfaceC2037k3.r();
            }
            InterfaceC2037k interfaceC2037k4 = MusicService.this.exoPlayer;
            if (interfaceC2037k4 != null) {
                interfaceC2037k4.D(z);
            }
        }
    }

    private final class b extends AbstractC24575yq7 {
        /* JADX WARN: Illegal instructions before constructor call */
        public b() {
            MediaSessionCompat mediaSessionCompat = MusicService.this.mediaSession;
            if (mediaSessionCompat == null) {
                AbstractC13042fc3.y("mediaSession");
                mediaSessionCompat = null;
            }
            super(mediaSessionCompat);
        }

        @Override // ir.nasim.AbstractC24575yq7
        public MediaDescriptionCompat n(z0 z0Var, int i) {
            MediaDescriptionCompat mediaDescriptionCompatE;
            AbstractC13042fc3.i(z0Var, "player");
            MediaMetadataCompat mediaMetadataCompatP = C13519gN.a.P(i);
            if (mediaMetadataCompatP != null && (mediaDescriptionCompatE = mediaMetadataCompatP.e()) != null) {
                return mediaDescriptionCompatE;
            }
            MediaDescriptionCompat mediaDescriptionCompatA = new MediaDescriptionCompat.d().a();
            AbstractC13042fc3.h(mediaDescriptionCompatA, "build(...)");
            return mediaDescriptionCompatA;
        }
    }

    private final class c implements z0.d {
        public c() {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void S4(boolean z, int i) {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void Z2(PlaybackException playbackException) {
            AbstractC13042fc3.i(playbackException, "error");
            try {
                if ((playbackException instanceof ExoPlaybackException) && AbstractC20762sZ6.X(AbstractC16632lc2.b(playbackException), C18274oO.a.a(), false, 2, null)) {
                    return;
                }
                Context contextD = C5721Ko.a.d();
                String string = contextD.getString(AbstractC12217eE5.audio_player_error);
                AbstractC13042fc3.h(string, "getString(...)");
                Toast.makeText(contextD, string, 1).show();
                InterfaceC16501lO.w(C23709xO.a, false, 1, null);
                C19406qI3.d("MusicService", playbackException);
            } catch (Exception unused) {
            }
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void c4(boolean z, int i) {
            if (i == 1) {
                C23709xO c23709xO = C23709xO.a;
                c23709xO.A0();
                c23709xO.q0();
                c23709xO.Y();
                return;
            }
            C8818Xl4 c8818Xl4 = null;
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                InterfaceC16501lO.w(C23709xO.a, false, 1, null);
                return;
            }
            C23709xO c23709xO2 = C23709xO.a;
            c23709xO2.j0();
            C8818Xl4 c8818Xl42 = MusicService.this.musicNotificationManager;
            if (c8818Xl42 == null) {
                AbstractC13042fc3.y("musicNotificationManager");
            } else {
                c8818Xl4 = c8818Xl42;
            }
            c8818Xl4.b(MusicService.this.exoPlayer);
            c23709xO2.i0();
        }
    }

    private final class d implements C16675lg5.g {
        public d() {
        }

        @Override // ir.nasim.C16675lg5.g
        public void a(int i, Notification notification, boolean z) {
            AbstractC13042fc3.i(notification, "notification");
            if (!z || MusicService.this.getIsForegroundService()) {
                return;
            }
            AbstractC4043Dl1.p(MusicService.this.getApplicationContext(), new Intent(MusicService.this.getApplicationContext(), MusicService.this.getClass()));
            MusicService.this.startForeground(i, notification);
            MusicService.this.B(true);
        }

        @Override // ir.nasim.C16675lg5.g
        public void b(int i, boolean z) {
            if (z) {
                InterfaceC16501lO.w(C23709xO.a, false, 1, null);
            }
            MusicService.this.stopForeground(true);
            MusicService.this.B(false);
            MusicService.this.stopSelf();
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MusicService.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19795qx1 c19795qx1 = MusicService.this.customMediaSourceFactory;
            if (c19795qx1 != null) {
                c19795qx1.f();
            }
            MusicService.this.customMediaSourceFactory = null;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public MusicService() {
        com.google.android.exoplayer2.audio.a aVarA = new a.e().c(2).f(1).a();
        AbstractC13042fc3.h(aVarA, "build(...)");
        this.exoAudioAttributes = aVarA;
        this.musicPlayerEventListener = new c();
        this.serviceScope = AbstractC20906so1.a(C12366eV1.b().X(P17.b(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A(z0 z0Var, Intent intent) {
        AbstractC13042fc3.i(z0Var, "<unused var>");
        AbstractC13042fc3.i(intent, "mediaButtonEvent");
        return C21352tW3.h(intent);
    }

    private final void x() {
        Intent launchIntentForPackage;
        PackageManager packageManager = getPackageManager();
        PendingIntent activity = (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(getPackageName())) == null) ? null : PendingIntent.getActivity(this, 0, launchIntentForPackage, 67108864);
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this, "MusicService", null, PendingIntent.getBroadcast(getBaseContext(), 0, new Intent("android.intent.action.MEDIA_BUTTON"), 67108864));
        mediaSessionCompat.n(activity);
        mediaSessionCompat.f(true);
        this.mediaSession = mediaSessionCompat;
        q(mediaSessionCompat.c());
    }

    private final void y() {
        MediaSessionCompat mediaSessionCompat = this.mediaSession;
        if (mediaSessionCompat == null) {
            AbstractC13042fc3.y("mediaSession");
            mediaSessionCompat = null;
        }
        MediaSessionCompat.Token tokenC = mediaSessionCompat.c();
        AbstractC13042fc3.h(tokenC, "getSessionToken(...)");
        this.musicNotificationManager = new C8818Xl4(this, tokenC, new d());
    }

    public final void B(boolean z) {
        this.isForegroundService = z;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.e e(String clientPackageName, int clientUid, Bundle rootHints) {
        AbstractC13042fc3.i(clientPackageName, "clientPackageName");
        if (clientUid == Process.myUid()) {
            return new MediaBrowserServiceCompat.e("root_id", null);
        }
        return null;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void f(String parentId, MediaBrowserServiceCompat.l result) {
        AbstractC13042fc3.i(parentId, "parentId");
        AbstractC13042fc3.i(result, "result");
        result.f(new ArrayList());
    }

    @Override // androidx.media.MediaBrowserServiceCompat, android.app.Service
    public void onCreate() {
        C5735Kp4.w().L();
        super.onCreate();
        this.customMediaSourceFactory = new C19795qx1(this);
        InterfaceC2037k.b bVar = new InterfaceC2037k.b(this);
        C19795qx1 c19795qx1 = this.customMediaSourceFactory;
        if (c19795qx1 == null) {
            return;
        }
        InterfaceC2037k interfaceC2037kI = bVar.t(c19795qx1).i();
        interfaceC2037kI.S(this.exoAudioAttributes, true);
        interfaceC2037kI.J(true);
        interfaceC2037kI.m0(this.musicPlayerEventListener);
        this.exoPlayer = interfaceC2037kI;
        AbstractC13042fc3.h(interfaceC2037kI, "also(...)");
        x();
        y();
        MediaSessionCompat mediaSessionCompat = this.mediaSession;
        if (mediaSessionCompat == null) {
            AbstractC13042fc3.y("mediaSession");
            mediaSessionCompat = null;
        }
        XY3 xy3 = new XY3(mediaSessionCompat);
        xy3.L(new a());
        xy3.N(new b());
        xy3.M(interfaceC2037kI);
        xy3.J(6554447L);
        xy3.K(new XY3.g() { // from class: ir.nasim.Yl4
            @Override // ir.nasim.XY3.g
            public final boolean a(com.google.android.exoplayer2.z0 z0Var, Intent intent) {
                return MusicService.A(z0Var, intent);
            }
        });
        this.mediaSessionConnector = xy3;
        C23709xO.a.p0(interfaceC2037kI);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        AbstractC10533bm0.d(this.serviceScope, null, null, new e(null), 3, null);
        InterfaceC2037k interfaceC2037k = this.exoPlayer;
        if (interfaceC2037k != null) {
            interfaceC2037k.stop();
        }
        MediaSessionCompat mediaSessionCompat = this.mediaSession;
        if (mediaSessionCompat == null) {
            AbstractC13042fc3.y("mediaSession");
            mediaSessionCompat = null;
        }
        mediaSessionCompat.e();
        XY3 xy3 = this.mediaSessionConnector;
        if (xy3 == null) {
            AbstractC13042fc3.y("mediaSessionConnector");
            xy3 = null;
        }
        xy3.M(null);
        InterfaceC2037k interfaceC2037k2 = this.exoPlayer;
        if (interfaceC2037k2 != null) {
            interfaceC2037k2.o(this.musicPlayerEventListener);
        }
        InterfaceC2037k interfaceC2037k3 = this.exoPlayer;
        if (interfaceC2037k3 != null) {
            interfaceC2037k3.release();
        }
        this.exoPlayer = null;
        C23709xO.a.e0(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            stopSelf();
            return 1;
        }
        MediaSessionCompat mediaSessionCompat = null;
        C8818Xl4 c8818Xl4 = null;
        if (intent.getBooleanExtra("DISMISS_NOTIFICATION_COMMAND", false)) {
            C8818Xl4 c8818Xl42 = this.musicNotificationManager;
            if (c8818Xl42 == null) {
                AbstractC13042fc3.y("musicNotificationManager");
            } else {
                c8818Xl4 = c8818Xl42;
            }
            c8818Xl4.a();
            return 1;
        }
        if (!intent.getBooleanExtra("GO_TO_BUFFERING_STATE_COMMAND", false)) {
            return 1;
        }
        PlaybackStateCompat playbackStateCompatA = new PlaybackStateCompat.d().g(6, 0L, 1.0f).b(0L).a();
        MediaSessionCompat mediaSessionCompat2 = this.mediaSession;
        if (mediaSessionCompat2 == null) {
            AbstractC13042fc3.y("mediaSession");
        } else {
            mediaSessionCompat = mediaSessionCompat2;
        }
        mediaSessionCompat.k(playbackStateCompatA);
        InterfaceC2037k interfaceC2037k = this.exoPlayer;
        if (interfaceC2037k == null) {
            return 1;
        }
        interfaceC2037k.stop();
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        AbstractC13042fc3.i(rootIntent, "rootIntent");
        super.onTaskRemoved(rootIntent);
        InterfaceC2037k interfaceC2037k = this.exoPlayer;
        if (interfaceC2037k == null || interfaceC2037k.i()) {
            return;
        }
        C8818Xl4 c8818Xl4 = this.musicNotificationManager;
        if (c8818Xl4 == null) {
            AbstractC13042fc3.y("musicNotificationManager");
            c8818Xl4 = null;
        }
        c8818Xl4.a();
    }

    /* renamed from: z, reason: from getter */
    public final boolean getIsForegroundService() {
        return this.isForegroundService;
    }
}
