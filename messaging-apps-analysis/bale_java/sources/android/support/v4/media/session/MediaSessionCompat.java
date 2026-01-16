package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.media.session.MediaButtonReceiver;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC22752vm0;
import ir.nasim.AbstractC23786xW4;
import ir.nasim.InterfaceC12954fS7;
import ir.nasim.WY3;
import ir.nasim.YY3;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaSessionCompat {
    static int d;
    private final c a;
    private final MediaControllerCompat b;
    private final ArrayList c;

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();
        private final MediaDescriptionCompat a;
        private final long b;
        private MediaSession.QueueItem c;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        }

        private static class b {
            static MediaSession.QueueItem a(MediaDescription mediaDescription, long j) {
                return new MediaSession.QueueItem(mediaDescription, j);
            }

            static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }

        public static QueueItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.a(b.b(queueItem)), b.c(queueItem));
        }

        public static List b(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        public MediaDescriptionCompat c() {
            return this.a;
        }

        public long d() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Object e() {
            MediaSession.QueueItem queueItem = this.c;
            if (queueItem != null) {
                return queueItem;
            }
            MediaSession.QueueItem queueItemA = b.a((MediaDescription) this.a.f(), this.b);
            this.c = queueItemA;
            return queueItemA;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.a + ", Id=" + this.b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.a.writeToParcel(parcel, i);
            parcel.writeLong(this.b);
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.a = mediaDescriptionCompat;
            this.b = j;
            this.c = queueItem;
        }

        QueueItem(Parcel parcel) {
            this.a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.b = parcel.readLong();
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();
        ResultReceiver a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.a.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();
        private final Object a;
        private final Object b;
        private android.support.v4.media.session.b c;
        private InterfaceC12954fS7 d;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        public static Token a(Object obj) {
            return b(obj, null);
        }

        public static Token b(Object obj, android.support.v4.media.session.b bVar) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, bVar);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        public android.support.v4.media.session.b c() {
            android.support.v4.media.session.b bVar;
            synchronized (this.a) {
                bVar = this.c;
            }
            return bVar;
        }

        public InterfaceC12954fS7 d() {
            InterfaceC12954fS7 interfaceC12954fS7;
            synchronized (this.a) {
                interfaceC12954fS7 = this.d;
            }
            return interfaceC12954fS7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Object e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.b;
            if (obj2 == null) {
                return token.b == null;
            }
            Object obj3 = token.b;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public void f(android.support.v4.media.session.b bVar) {
            synchronized (this.a) {
                this.c = bVar;
            }
        }

        public void g(InterfaceC12954fS7 interfaceC12954fS7) {
            synchronized (this.a) {
                this.d = interfaceC12954fS7;
            }
        }

        public int hashCode() {
            Object obj = this.b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable((Parcelable) this.b, i);
        }

        Token(Object obj, android.support.v4.media.session.b bVar) {
            this(obj, bVar, null);
        }

        Token(Object obj, android.support.v4.media.session.b bVar, InterfaceC12954fS7 interfaceC12954fS7) {
            this.a = new Object();
            this.b = obj;
            this.c = bVar;
            this.d = interfaceC12954fS7;
        }
    }

    class a extends b {
        a() {
        }
    }

    public static abstract class b {
        private boolean c;
        a e;
        final Object a = new Object();
        final MediaSession.Callback b = new C0004b();
        WeakReference d = new WeakReference(null);

        private class a extends Handler {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                b bVar;
                a aVar;
                if (message.what == 1) {
                    synchronized (b.this.a) {
                        cVar = (c) b.this.d.get();
                        bVar = b.this;
                        aVar = bVar.e;
                    }
                    if (cVar == null || bVar != cVar.j() || aVar == null) {
                        return;
                    }
                    cVar.l((YY3) message.obj);
                    b.this.a(cVar, aVar);
                    cVar.l(null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$b$b, reason: collision with other inner class name */
        private class C0004b extends MediaSession.Callback {
            C0004b() {
            }

            private void a(c cVar) {
                cVar.l(null);
            }

            private d b() {
                d dVar;
                synchronized (b.this.a) {
                    dVar = (d) b.this.d.get();
                }
                if (dVar == null || b.this != dVar.j()) {
                    return null;
                }
                return dVar;
            }

            private void c(c cVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String strH = cVar.h();
                if (TextUtils.isEmpty(strH)) {
                    strH = "android.media.session.MediaController";
                }
                cVar.l(new YY3(strH, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                try {
                    QueueItem queueItem = null;
                    IBinder iBinderAsBinder = null;
                    queueItem = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        Bundle bundle2 = new Bundle();
                        Token tokenB = dVarB.b();
                        android.support.v4.media.session.b bVarC = tokenB.c();
                        if (bVarC != null) {
                            iBinderAsBinder = bVarC.asBinder();
                        }
                        AbstractC22752vm0.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", iBinderAsBinder);
                        AbstractC23786xW4.c(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", tokenB.d());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        b.this.e((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        b.this.h((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        b.this.Q((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        b.this.k(str, bundle, resultReceiver);
                    } else if (dVarB.h != null) {
                        int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                        if (i >= 0 && i < dVarB.h.size()) {
                            queueItem = (QueueItem) dVarB.h.get(i);
                        }
                        if (queueItem != null) {
                            b.this.Q(queueItem.c());
                        }
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                try {
                    if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        Uri uri = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle2);
                        b.this.C(uri, bundle2);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        b.this.F();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                        Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle3);
                        b.this.H(string, bundle3);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                        Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle4);
                        b.this.K(string2, bundle4);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        Uri uri2 = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle5);
                        b.this.P(uri2, bundle5);
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        b.this.V(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        b.this.a0(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        b.this.b0(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        RatingCompat ratingCompat = (RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                        Bundle bundle6 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle6);
                        b.this.Z(ratingCompat, bundle6);
                    } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        b.this.W(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    } else {
                        b.this.p(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.q();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                d dVarB = b();
                if (dVarB == null) {
                    return false;
                }
                c(dVarB);
                boolean zR = b.this.r(intent);
                a(dVarB);
                return zR || super.onMediaButtonEvent(intent);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.t();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.v();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                b.this.x(str, bundle);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                b.this.z(str, bundle);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                b.this.C(uri, bundle);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepare() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.F();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                b.this.H(str, bundle);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                b.this.K(str, bundle);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(dVarB);
                b.this.P(uri, bundle);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.T();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.U(j);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetPlaybackSpeed(float f) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.W(f);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.Y(RatingCompat.a(rating));
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.c0();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.d0();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.e0(j);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.f0();
                a(dVarB);
            }
        }

        public void C(Uri uri, Bundle bundle) {
        }

        public void F() {
        }

        public void H(String str, Bundle bundle) {
        }

        public void K(String str, Bundle bundle) {
        }

        public void P(Uri uri, Bundle bundle) {
        }

        public void Q(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void T() {
        }

        public void U(long j) {
        }

        public void V(boolean z) {
        }

        public void W(float f) {
        }

        public void Y(RatingCompat ratingCompat) {
        }

        public void Z(RatingCompat ratingCompat, Bundle bundle) {
        }

        void a(c cVar, Handler handler) {
            if (this.c) {
                this.c = false;
                handler.removeMessages(1);
                PlaybackStateCompat playbackStateCompatP = cVar.p();
                long jB = playbackStateCompatP == null ? 0L : playbackStateCompatP.b();
                boolean z = playbackStateCompatP != null && playbackStateCompatP.h() == 3;
                boolean z2 = (516 & jB) != 0;
                boolean z3 = (jB & 514) != 0;
                if (z && z3) {
                    t();
                } else {
                    if (z || !z2) {
                        return;
                    }
                    v();
                }
            }
        }

        public void a0(int i) {
        }

        public void b0(int i) {
        }

        public void c0() {
        }

        public void d0() {
        }

        public void e(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void e0(long j) {
        }

        public void f0() {
        }

        void g0(c cVar, Handler handler) {
            synchronized (this.a) {
                try {
                    this.d = new WeakReference(cVar);
                    a aVar = this.e;
                    a aVar2 = null;
                    if (aVar != null) {
                        aVar.removeCallbacksAndMessages(null);
                    }
                    if (cVar != null && handler != null) {
                        aVar2 = new a(handler.getLooper());
                    }
                    this.e = aVar2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void h(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void k(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void p(String str, Bundle bundle) {
        }

        public void q() {
        }

        public boolean r(Intent intent) {
            c cVar;
            a aVar;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.a) {
                cVar = (c) this.d.get();
                aVar = this.e;
            }
            if (cVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            YY3 yy3N = cVar.n();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                a(cVar, aVar);
                return false;
            }
            if (keyEvent.getRepeatCount() != 0) {
                a(cVar, aVar);
            } else if (this.c) {
                aVar.removeMessages(1);
                this.c = false;
                PlaybackStateCompat playbackStateCompatP = cVar.p();
                if (((playbackStateCompatP == null ? 0L : playbackStateCompatP.b()) & 32) != 0) {
                    c0();
                }
            } else {
                this.c = true;
                aVar.sendMessageDelayed(aVar.obtainMessage(1, yy3N), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void t() {
        }

        public void v() {
        }

        public void x(String str, Bundle bundle) {
        }

        public void z(String str, Bundle bundle) {
        }
    }

    interface c {
        Token b();

        void c(int i);

        void d(b bVar, Handler handler);

        void e(MediaMetadataCompat mediaMetadataCompat);

        void f(List list);

        void g(PlaybackStateCompat playbackStateCompat);

        String h();

        void i(PendingIntent pendingIntent);

        b j();

        void k(PendingIntent pendingIntent);

        void l(YY3 yy3);

        void m(boolean z);

        YY3 n();

        PlaybackStateCompat p();

        void release();

        void s(int i);

        void v(int i);
    }

    static class d implements c {
        final MediaSession a;
        final Token b;
        Bundle d;
        PlaybackStateCompat g;
        List h;
        MediaMetadataCompat i;
        int j;
        boolean k;
        int l;
        int m;
        b n;
        YY3 o;
        final Object c = new Object();
        boolean e = false;
        final RemoteCallbackList f = new RemoteCallbackList();

        class a extends b.a {
            a() {
            }

            @Override // android.support.v4.media.session.b
            public long A() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public CharSequence A1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int B() {
                return d.this.l;
            }

            @Override // android.support.v4.media.session.b
            public void B0(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void C(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean D() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public void E1(android.support.v4.media.session.a aVar) {
                d.this.f.unregister(aVar);
                Binder.getCallingPid();
                Binder.getCallingUid();
                synchronized (d.this.c) {
                    d.this.getClass();
                }
            }

            @Override // android.support.v4.media.session.b
            public void F(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int F0() {
                return d.this.m;
            }

            @Override // android.support.v4.media.session.b
            public void H0(int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void I1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean K0() {
                return d.this.k;
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent M() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void O0(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int P() {
                return d.this.j;
            }

            @Override // android.support.v4.media.session.b
            public void R0(long j) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void R1(float f) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void S0(boolean z) {
            }

            @Override // android.support.v4.media.session.b
            public void X1(int i, int i2, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String Z0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void b0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle d0() {
                if (d.this.d == null) {
                    return null;
                }
                return new Bundle(d.this.d);
            }

            @Override // android.support.v4.media.session.b
            public void g0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void g1(android.support.v4.media.session.a aVar) {
                if (d.this.e) {
                    return;
                }
                d.this.f.register(aVar, new YY3("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                synchronized (d.this.c) {
                    d.this.getClass();
                }
            }

            @Override // android.support.v4.media.session.b
            public void g2(boolean z) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void h() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void h0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void i1(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void j0(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void j1(int i, int i2, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void m1(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean n1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void next() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat o() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo o2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat p() {
                d dVar = d.this;
                return MediaSessionCompat.d(dVar.g, dVar.i);
            }

            @Override // android.support.v4.media.session.b
            public void p1(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void previous() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void q() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void r() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void s(int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean s0(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void s1(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void stop() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void t() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void v(int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void w0(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void x(long j) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public List z() {
                return null;
            }
        }

        d(Context context, String str, InterfaceC12954fS7 interfaceC12954fS7, Bundle bundle) {
            MediaSession mediaSessionA = a(context, str, bundle);
            this.a = mediaSessionA;
            this.b = new Token(mediaSessionA.getSessionToken(), new a(), interfaceC12954fS7);
            this.d = bundle;
            c(3);
        }

        public MediaSession a(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Token b() {
            return this.b;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void c(int i) {
            this.a.setFlags(i | 3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void d(b bVar, Handler handler) {
            synchronized (this.c) {
                try {
                    this.n = bVar;
                    this.a.setCallback(bVar == null ? null : bVar.b, handler);
                    if (bVar != null) {
                        bVar.g0(this, handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void e(MediaMetadataCompat mediaMetadataCompat) {
            this.i = mediaMetadataCompat;
            this.a.setMetadata(mediaMetadataCompat == null ? null : (MediaMetadata) mediaMetadataCompat.g());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void f(List list) {
            this.h = list;
            if (list == null) {
                this.a.setQueue(null);
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((MediaSession.QueueItem) ((QueueItem) it.next()).e());
            }
            this.a.setQueue(arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void g(PlaybackStateCompat playbackStateCompat) {
            this.g = playbackStateCompat;
            synchronized (this.c) {
                for (int iBeginBroadcast = this.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f.getBroadcastItem(iBeginBroadcast)).y2(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.f.finishBroadcast();
            }
            this.a.setPlaybackState(playbackStateCompat == null ? null : (PlaybackState) playbackStateCompat.f());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public String h() {
            try {
                return (String) this.a.getClass().getMethod("getCallingPackage", null).invoke(this.a, null);
            } catch (Exception e) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void i(PendingIntent pendingIntent) {
            this.a.setSessionActivity(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public b j() {
            b bVar;
            synchronized (this.c) {
                bVar = this.n;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void k(PendingIntent pendingIntent) {
            this.a.setMediaButtonReceiver(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void l(YY3 yy3) {
            synchronized (this.c) {
                this.o = yy3;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void m(boolean z) {
            this.a.setActive(z);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public YY3 n() {
            YY3 yy3;
            synchronized (this.c) {
                yy3 = this.o;
            }
            return yy3;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public PlaybackStateCompat p() {
            return this.g;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void release() throws NoSuchFieldException, SecurityException {
            this.e = true;
            this.f.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.a.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.a);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e) {
                    Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e);
                }
            }
            this.a.setCallback(null);
            this.a.release();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void s(int i) {
            if (this.l != i) {
                this.l = i;
                synchronized (this.c) {
                    for (int iBeginBroadcast = this.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                        try {
                            ((android.support.v4.media.session.a) this.f.getBroadcastItem(iBeginBroadcast)).J(i);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f.finishBroadcast();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void v(int i) {
            if (this.m != i) {
                this.m = i;
                synchronized (this.c) {
                    for (int iBeginBroadcast = this.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                        try {
                            ((android.support.v4.media.session.a) this.f.getBroadcastItem(iBeginBroadcast)).N0(i);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f.finishBroadcast();
                }
            }
        }
    }

    static class e extends d {
        e(Context context, String str, InterfaceC12954fS7 interfaceC12954fS7, Bundle bundle) {
            super(context, str, interfaceC12954fS7, bundle);
        }
    }

    static class g extends f {
        g(Context context, String str, InterfaceC12954fS7 interfaceC12954fS7, Bundle bundle) {
            super(context, str, interfaceC12954fS7, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d
        public MediaSession a(Context context, String str, Bundle bundle) {
            return WY3.a(context, str, bundle);
        }
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    static PlaybackStateCompat d(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long jF = -1;
        if (playbackStateCompat.g() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.h() != 3 && playbackStateCompat.h() != 4 && playbackStateCompat.h() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.d() <= 0) {
            return playbackStateCompat;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jE = ((long) (playbackStateCompat.e() * (jElapsedRealtime - r0))) + playbackStateCompat.g();
        if (mediaMetadataCompat != null && mediaMetadataCompat.a("android.media.metadata.DURATION")) {
            jF = mediaMetadataCompat.f("android.media.metadata.DURATION");
        }
        return new PlaybackStateCompat.d(playbackStateCompat).h(playbackStateCompat.h(), (jF < 0 || jE <= jF) ? jE < 0 ? 0L : jE : jF, playbackStateCompat.e(), jElapsedRealtime).a();
    }

    public static Bundle p(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public MediaControllerCompat b() {
        return this.b;
    }

    public Token c() {
        return this.a.b();
    }

    public void e() {
        this.a.release();
    }

    public void f(boolean z) {
        this.a.m(z);
        Iterator it = this.c.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    public void g(b bVar) {
        h(bVar, null);
    }

    public void h(b bVar, Handler handler) {
        if (bVar == null) {
            this.a.d(null, null);
            return;
        }
        c cVar = this.a;
        if (handler == null) {
            handler = new Handler();
        }
        cVar.d(bVar, handler);
    }

    public void i(int i) {
        this.a.c(i);
    }

    public void j(MediaMetadataCompat mediaMetadataCompat) {
        this.a.e(mediaMetadataCompat);
    }

    public void k(PlaybackStateCompat playbackStateCompat) {
        this.a.g(playbackStateCompat);
    }

    public void l(List list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                QueueItem queueItem = (QueueItem) it.next();
                if (queueItem == null) {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
                if (hashSet.contains(Long.valueOf(queueItem.d()))) {
                    Log.e("MediaSessionCompat", "Found duplicate queue id: " + queueItem.d(), new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet.add(Long.valueOf(queueItem.d()));
            }
        }
        this.a.f(list);
    }

    public void m(int i) {
        this.a.s(i);
    }

    public void n(PendingIntent pendingIntent) {
        this.a.i(pendingIntent);
    }

    public void o(int i) {
        this.a.v(i);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle, InterfaceC12954fS7 interfaceC12954fS7) {
        this.c = new ArrayList();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (componentName == null && (componentName = MediaButtonReceiver.a(context)) == null) {
                    Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
                if (componentName != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    this.a = new g(context, str, interfaceC12954fS7, bundle);
                } else if (i >= 28) {
                    this.a = new f(context, str, interfaceC12954fS7, bundle);
                } else {
                    this.a = new e(context, str, interfaceC12954fS7, bundle);
                }
                h(new a(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                this.a.k(pendingIntent);
                this.b = new MediaControllerCompat(context, this);
                if (d == 0) {
                    d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    static class f extends e {
        f(Context context, String str, InterfaceC12954fS7 interfaceC12954fS7, Bundle bundle) {
            super(context, str, interfaceC12954fS7, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.c
        public final YY3 n() {
            return new YY3(this.a.getCurrentControllerInfo());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.c
        public void l(YY3 yy3) {
        }
    }
}
