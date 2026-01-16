package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.AudioAttributesCompat;
import ir.nasim.AbstractC22752vm0;
import ir.nasim.AbstractC23786xW4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class MediaControllerCompat {
    private final b a;
    private final MediaSessionCompat.Token b;
    private final ConcurrentHashMap c = new ConcurrentHashMap();

    static class MediaControllerImplApi21 implements b {
        protected final MediaController a;
        final Object b = new Object();
        private final List c = new ArrayList();
        private HashMap d = new HashMap();
        final MediaSessionCompat.Token e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.a = new WeakReference(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.b) {
                    mediaControllerImplApi21.e.f(b.a.B2(AbstractC22752vm0.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.e.g(AbstractC23786xW4.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                    mediaControllerImplApi21.e();
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void D0(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void V1(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void Z(List list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void f1(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void v1(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void z0() {
                throw new AssertionError();
            }
        }

        MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.e = token;
            this.a = new MediaController(context, (MediaSession.Token) token.e());
            if (token.c() == null) {
                f();
            }
        }

        private void f() {
            g("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PendingIntent a() {
            return this.a.getSessionActivity();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public e b() {
            MediaController.TransportControls transportControls = this.a.getTransportControls();
            return Build.VERSION.SDK_INT >= 29 ? new i(transportControls) : new h(transportControls);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean c(KeyEvent keyEvent) {
            return this.a.dispatchMediaButtonEvent(keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public final void d(a aVar, Handler handler) {
            this.a.registerCallback(aVar.a, handler);
            synchronized (this.b) {
                if (this.e.c() != null) {
                    a aVar2 = new a(aVar);
                    this.d.put(aVar, aVar2);
                    aVar.c = aVar2;
                    try {
                        this.e.c().g1(aVar2);
                        aVar.m(13, null, null);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                } else {
                    aVar.c = null;
                    this.c.add(aVar);
                }
            }
        }

        void e() {
            if (this.e.c() == null) {
                return;
            }
            for (a aVar : this.c) {
                a aVar2 = new a(aVar);
                this.d.put(aVar, aVar2);
                aVar.c = aVar2;
                try {
                    this.e.c().g1(aVar2);
                    aVar.m(13, null, null);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                }
            }
            this.c.clear();
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.a.sendCommand(str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public MediaMetadataCompat o() {
            MediaMetadata metadata = this.a.getMetadata();
            if (metadata != null) {
                return MediaMetadataCompat.b(metadata);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PlaybackStateCompat p() {
            if (this.e.c() != null) {
                try {
                    return this.e.c().p();
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
                }
            }
            PlaybackState playbackState = this.a.getPlaybackState();
            if (playbackState != null) {
                return PlaybackStateCompat.a(playbackState);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public List z() {
            List<MediaSession.QueueItem> queue = this.a.getQueue();
            if (queue != null) {
                return MediaSessionCompat.QueueItem.b(queue);
            }
            return null;
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {
        final MediaController.Callback a = new C0003a(this);
        b b;
        android.support.v4.media.session.a c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        private static class C0003a extends MediaController.Callback {
            private final WeakReference a;

            C0003a(a aVar) {
                this.a = new WeakReference(aVar);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(new d(playbackInfo.getPlaybackType(), AudioAttributesCompat.f(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.a(bundle);
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.c(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.d(MediaMetadataCompat.b(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                a aVar = (a) this.a.get();
                if (aVar == null || aVar.c != null) {
                    return;
                }
                aVar.e(PlaybackStateCompat.a(playbackState));
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List list) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.f(MediaSessionCompat.QueueItem.b(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.g(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.i();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.j(str, bundle);
                }
            }
        }

        private class b extends Handler {
            boolean a;

            b(Looper looper) {
                super(looper);
                this.a = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            a.this.j((String) message.obj, data);
                            break;
                        case 2:
                            a.this.e((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            a.this.d((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            a.this.a((d) message.obj);
                            break;
                        case 5:
                            a.this.f((List) message.obj);
                            break;
                        case 6:
                            a.this.g((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            a.this.c(bundle);
                            break;
                        case 8:
                            a.this.i();
                            break;
                        case 9:
                            a.this.h(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            a.this.b(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            a.this.l(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            a.this.k();
                            break;
                    }
                }
            }
        }

        private static class c extends a.AbstractBinderC0005a {
            private final WeakReference a;

            c(a aVar) {
                this.a = new WeakReference(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void J(int i) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.m(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void L1(boolean z) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.m(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void N0(int i) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.m(12, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void U1(boolean z) {
            }

            @Override // android.support.v4.media.session.a
            public void V() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.m(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void y2(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.m(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void z2(String str, Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.m(1, str, bundle);
                }
            }
        }

        public void a(d dVar) {
        }

        public void b(boolean z) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            m(8, null, null);
        }

        public void c(Bundle bundle) {
        }

        public abstract void d(MediaMetadataCompat mediaMetadataCompat);

        public abstract void e(PlaybackStateCompat playbackStateCompat);

        public void f(List list) {
        }

        public void g(CharSequence charSequence) {
        }

        public void h(int i) {
        }

        public abstract void i();

        public void j(String str, Bundle bundle) {
        }

        public void k() {
        }

        public void l(int i) {
        }

        void m(int i, Object obj, Bundle bundle) {
            b bVar = this.b;
            if (bVar != null) {
                Message messageObtainMessage = bVar.obtainMessage(i, obj);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        }

        void n(Handler handler) {
            if (handler != null) {
                b bVar = new b(handler.getLooper());
                this.b = bVar;
                bVar.a = true;
            } else {
                b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar2.a = false;
                    bVar2.removeCallbacksAndMessages(null);
                    this.b = null;
                }
            }
        }
    }

    interface b {
        PendingIntent a();

        e b();

        boolean c(KeyEvent keyEvent);

        void d(a aVar, Handler handler);

        MediaMetadataCompat o();

        PlaybackStateCompat p();

        List z();
    }

    static class c extends MediaControllerImplApi21 {
        c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    public static final class d {
        private final int a;
        private final AudioAttributesCompat b;
        private final int c;
        private final int d;
        private final int e;

        d(int i, AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
            this.a = i;
            this.b = audioAttributesCompat;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public static abstract class e {
        e() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c(String str, Bundle bundle);

        public abstract void d(long j);

        public abstract void e(float f);

        public abstract void f(int i);

        public abstract void g();
    }

    static class f extends e {
        protected final MediaController.TransportControls a;

        f(MediaController.TransportControls transportControls) {
            this.a = transportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void a() {
            this.a.pause();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void b() {
            this.a.play();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void c(String str, Bundle bundle) {
            this.a.playFromMediaId(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void d(long j) {
            this.a.seekTo(j);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void e(float f) {
            if (f == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", f);
            h("android.support.v4.media.session.action.SET_PLAYBACK_SPEED", bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void f(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i);
            h("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void g() {
            this.a.stop();
        }

        public void h(String str, Bundle bundle) {
            MediaControllerCompat.i(str, bundle);
            this.a.sendCustomAction(str, bundle);
        }
    }

    static class g extends f {
        g(MediaController.TransportControls transportControls) {
            super(transportControls);
        }
    }

    static class h extends g {
        h(MediaController.TransportControls transportControls) {
            super(transportControls);
        }
    }

    static class i extends h {
        i(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.f, android.support.v4.media.session.MediaControllerCompat.e
        public void e(float f) {
            if (f == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            this.a.setPlaybackSpeed(f);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        MediaSessionCompat.Token tokenC = mediaSessionCompat.c();
        this.b = tokenC;
        if (Build.VERSION.SDK_INT >= 29) {
            this.a = new c(context, tokenC);
        } else {
            this.a = new MediaControllerImplApi21(context, tokenC);
        }
    }

    static void i(String str, Bundle bundle) {
        if (str == null) {
            return;
        }
        if (str.equals("android.support.v4.media.session.action.FOLLOW") || str.equals("android.support.v4.media.session.action.UNFOLLOW")) {
            if (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + Separators.DOT);
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.a.c(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public MediaMetadataCompat b() {
        return this.a.o();
    }

    public PlaybackStateCompat c() {
        return this.a.p();
    }

    public List d() {
        return this.a.z();
    }

    public PendingIntent e() {
        return this.a.a();
    }

    public e f() {
        return this.a.b();
    }

    public void g(a aVar) {
        h(aVar, null);
    }

    public void h(a aVar, Handler handler) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.c.putIfAbsent(aVar, Boolean.TRUE) != null) {
            Log.w("MediaControllerCompat", "the callback has already been registered");
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        aVar.n(handler);
        this.a.d(aVar, handler);
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token != null) {
            this.b = token;
            this.a = new MediaControllerImplApi21(context, token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
}
