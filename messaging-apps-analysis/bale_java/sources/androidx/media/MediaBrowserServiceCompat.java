package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import ir.nasim.AbstractC18941pW3;
import ir.nasim.AbstractC22752vm0;
import ir.nasim.KJ;
import ir.nasim.YV4;
import ir.nasim.YY3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean h = Log.isLoggable("MBServiceCompat", 3);
    private g a;
    f e;
    MediaSessionCompat.Token g;
    final f b = new f("android.media.session.MediaController", -1, -1, null, null);
    final ArrayList c = new ArrayList();
    final KJ d = new KJ();
    final q f = new q();

    class a extends l {
        final /* synthetic */ f f;
        final /* synthetic */ String g;
        final /* synthetic */ Bundle h;
        final /* synthetic */ Bundle i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f = fVar;
            this.g = str;
            this.h = bundle;
            this.i = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if (MediaBrowserServiceCompat.this.d.get(this.f.f.asBinder()) != this.f) {
                if (MediaBrowserServiceCompat.h) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f.a + " id=" + this.g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.h);
            }
            try {
                this.f.f.a(this.g, list, this.h, this.i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.g + " package=" + this.f.a);
            }
        }
    }

    class b extends l {
        final /* synthetic */ ResultReceiver f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f.b(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f.b(0, bundle);
        }
    }

    class c extends l {
        final /* synthetic */ ResultReceiver f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if ((a() & 4) != 0 || list == null) {
                this.f.b(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f.b(0, bundle);
        }
    }

    class d extends l {
        final /* synthetic */ ResultReceiver f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        void c(Bundle bundle) {
            this.f.b(-1, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(Bundle bundle) {
            this.f.b(0, bundle);
        }
    }

    public static final class e {
        private final String a;
        private final Bundle b;

        public e(String str, Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
            }
            this.a = str;
            this.b = bundle;
        }

        public Bundle c() {
            return this.b;
        }

        public String d() {
            return this.a;
        }
    }

    private class f implements IBinder.DeathRecipient {
        public final String a;
        public final int b;
        public final int c;
        public final YY3 d;
        public final Bundle e;
        public final o f;
        public final HashMap g = new HashMap();
        public e h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.d.remove(fVar.f.asBinder());
            }
        }

        f(String str, int i, int i2, Bundle bundle, o oVar) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = new YY3(str, i, i2);
            this.e = bundle;
            this.f = oVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f.post(new a());
        }
    }

    interface g {
        void a(MediaSessionCompat.Token token);

        IBinder b(Intent intent);

        void onCreate();
    }

    class h implements g {
        final List a = new ArrayList();
        MediaBrowserService b;
        Messenger c;

        class a implements Runnable {
            final /* synthetic */ MediaSessionCompat.Token a;

            a(MediaSessionCompat.Token token) {
                this.a = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.e(this.a);
            }
        }

        class b extends l {
            final /* synthetic */ m f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Object obj, m mVar) {
                super(obj);
                this.f = mVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f.b(arrayList);
            }
        }

        class c extends MediaBrowserService {
            c(Context context) {
                attachBaseContext(context);
            }

            @Override // android.service.media.MediaBrowserService
            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                e eVarC = h.this.c(str, i, bundle == null ? null : new Bundle(bundle));
                if (eVarC == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(eVarC.a, eVarC.b);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result result) {
                h.this.d(str, new m(result));
            }
        }

        h() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void a(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f.a(new a(token));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder b(Intent intent) {
            return this.b.onBind(intent);
        }

        public e c(String str, int i, Bundle bundle) {
            Bundle bundleC;
            int i2 = -1;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundleC = null;
            } else {
                bundle.remove("extra_client_version");
                this.c = new Messenger(MediaBrowserServiceCompat.this.f);
                bundleC = new Bundle();
                bundleC.putInt("extra_service_version", 2);
                AbstractC22752vm0.b(bundleC, "extra_messenger", this.c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.g;
                if (token != null) {
                    android.support.v4.media.session.b bVarC = token.c();
                    AbstractC22752vm0.b(bundleC, "extra_session_binder", bVarC == null ? null : bVarC.asBinder());
                } else {
                    this.a.add(bundleC);
                }
                i2 = bundle.getInt("extra_calling_pid", -1);
                bundle.remove("extra_calling_pid");
            }
            f fVar = MediaBrowserServiceCompat.this.new f(str, i2, i, bundle, null);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = fVar;
            e eVarE = mediaBrowserServiceCompat.e(str, i, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat2.e = null;
            if (eVarE == null) {
                return null;
            }
            if (this.c != null) {
                mediaBrowserServiceCompat2.c.add(fVar);
            }
            if (bundleC == null) {
                bundleC = eVarE.c();
            } else if (eVarE.c() != null) {
                bundleC.putAll(eVarE.c());
            }
            return new e(eVarE.d(), bundleC);
        }

        public void d(String str, m mVar) {
            b bVar = new b(str, mVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
            mediaBrowserServiceCompat.f(str, bVar);
            MediaBrowserServiceCompat.this.e = null;
        }

        void e(MediaSessionCompat.Token token) {
            if (!this.a.isEmpty()) {
                android.support.v4.media.session.b bVarC = token.c();
                if (bVarC != null) {
                    Iterator it = this.a.iterator();
                    while (it.hasNext()) {
                        AbstractC22752vm0.b((Bundle) it.next(), "extra_session_binder", bVarC.asBinder());
                    }
                }
                this.a.clear();
            }
            this.b.setSessionToken((MediaSession.Token) token.e());
        }
    }

    class i extends h {

        class a extends l {
            final /* synthetic */ m f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, m mVar) {
                super(obj);
                this.f = mVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f.b(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                this.f.b(parcelObtain);
            }
        }

        class b extends h.c {
            b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadItem(String str, MediaBrowserService.Result result) {
                i.this.f(str, new m(result));
            }
        }

        i() {
            super();
        }

        public void f(String str, m mVar) {
            a aVar = new a(str, mVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
            mediaBrowserServiceCompat.h(str, aVar);
            MediaBrowserServiceCompat.this.e = null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void onCreate() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.b = bVar;
            bVar.onCreate();
        }
    }

    class j extends i {

        class a extends l {
            final /* synthetic */ m f;
            final /* synthetic */ Bundle g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, m mVar, Bundle bundle) {
                super(obj);
                this.f = mVar;
                this.g = bundle;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                if (list == null) {
                    this.f.b(null);
                    return;
                }
                if ((a() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.b(list, this.g);
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (MediaBrowserCompat.MediaItem mediaItem : list) {
                    Parcel parcelObtain = Parcel.obtain();
                    mediaItem.writeToParcel(parcelObtain, 0);
                    arrayList.add(parcelObtain);
                }
                this.f.b(arrayList);
            }
        }

        class b extends i.b {
            b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                j jVar = j.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
                jVar.g(str, new m(result), bundle);
                MediaBrowserServiceCompat.this.e = null;
            }
        }

        j() {
            super();
        }

        public void g(String str, m mVar, Bundle bundle) {
            a aVar = new a(str, mVar, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.e = mediaBrowserServiceCompat.b;
            mediaBrowserServiceCompat.g(str, aVar, bundle);
            MediaBrowserServiceCompat.this.e = null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.i, androidx.media.MediaBrowserServiceCompat.g
        public void onCreate() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.b = bVar;
            bVar.onCreate();
        }
    }

    class k extends j {
        k() {
            super();
        }
    }

    public static class l {
        private final Object a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;

        l(Object obj) {
            this.a = obj;
        }

        int a() {
            return this.e;
        }

        boolean b() {
            return this.b || this.c || this.d;
        }

        void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.a);
        }

        abstract void d(Object obj);

        public void e(Bundle bundle) {
            if (!this.c && !this.d) {
                this.d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.a);
            }
        }

        public void f(Object obj) {
            if (!this.c && !this.d) {
                this.c = true;
                d(obj);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.a);
            }
        }

        void g(int i) {
            this.e = i;
        }
    }

    static class m {
        MediaBrowserService.Result a;

        m(MediaBrowserService.Result result) {
            this.a = result;
        }

        List a(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Parcel parcel = (Parcel) it.next();
                parcel.setDataPosition(0);
                arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void b(Object obj) {
            if (obj instanceof List) {
                this.a.sendResult(a((List) obj));
                return;
            }
            if (!(obj instanceof Parcel)) {
                this.a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) obj;
            parcel.setDataPosition(0);
            this.a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    private class n {

        class a implements Runnable {
            final /* synthetic */ o a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;
            final /* synthetic */ int d;
            final /* synthetic */ Bundle e;

            a(o oVar, String str, int i, int i2, Bundle bundle) {
                this.a = oVar;
                this.b = str;
                this.c = i;
                this.d = i2;
                this.e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() throws RemoteException {
                IBinder iBinderAsBinder = this.a.asBinder();
                MediaBrowserServiceCompat.this.d.remove(iBinderAsBinder);
                f fVar = MediaBrowserServiceCompat.this.new f(this.b, this.c, this.d, this.e, this.a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.e = fVar;
                e eVarE = mediaBrowserServiceCompat.e(this.b, this.d, this.e);
                fVar.h = eVarE;
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat2.e = null;
                if (eVarE != null) {
                    try {
                        mediaBrowserServiceCompat2.d.put(iBinderAsBinder, fVar);
                        iBinderAsBinder.linkToDeath(fVar, 0);
                        if (MediaBrowserServiceCompat.this.g != null) {
                            this.a.c(fVar.h.d(), MediaBrowserServiceCompat.this.g, fVar.h.c());
                            return;
                        }
                        return;
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.b);
                        MediaBrowserServiceCompat.this.d.remove(iBinderAsBinder);
                        return;
                    }
                }
                Log.i("MBServiceCompat", "No root for client " + this.b + " from service " + getClass().getName());
                try {
                    this.a.b();
                } catch (RemoteException unused2) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.b);
                }
            }
        }

        class b implements Runnable {
            final /* synthetic */ o a;

            b(o oVar) {
                this.a = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.d.remove(this.a.asBinder());
                if (fVar != null) {
                    fVar.f.asBinder().unlinkToDeath(fVar, 0);
                }
            }
        }

        class c implements Runnable {
            final /* synthetic */ o a;
            final /* synthetic */ String b;
            final /* synthetic */ IBinder c;
            final /* synthetic */ Bundle d;

            c(o oVar, String str, IBinder iBinder, Bundle bundle) {
                this.a = oVar;
                this.b = str;
                this.c = iBinder;
                this.d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.d.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.a(this.b, fVar, this.c, this.d);
                    return;
                }
                Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.b);
            }
        }

        class d implements Runnable {
            final /* synthetic */ o a;
            final /* synthetic */ String b;
            final /* synthetic */ IBinder c;

            d(o oVar, String str, IBinder iBinder) {
                this.a = oVar;
                this.b = str;
                this.c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.d.get(this.a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.b);
                    return;
                }
                if (MediaBrowserServiceCompat.this.p(this.b, fVar, this.c)) {
                    return;
                }
                Log.w("MBServiceCompat", "removeSubscription called for " + this.b + " which is not subscribed");
            }
        }

        class e implements Runnable {
            final /* synthetic */ o a;
            final /* synthetic */ String b;
            final /* synthetic */ ResultReceiver c;

            e(o oVar, String str, ResultReceiver resultReceiver) {
                this.a = oVar;
                this.b = str;
                this.c = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.d.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.n(this.b, fVar, this.c);
                    return;
                }
                Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.b);
            }
        }

        class f implements Runnable {
            final /* synthetic */ o a;
            final /* synthetic */ int b;
            final /* synthetic */ String c;
            final /* synthetic */ int d;
            final /* synthetic */ Bundle e;

            f(o oVar, int i, String str, int i2, Bundle bundle) {
                this.a = oVar;
                this.b = i;
                this.c = str;
                this.d = i2;
                this.e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() throws RemoteException {
                f fVar;
                IBinder iBinderAsBinder = this.a.asBinder();
                MediaBrowserServiceCompat.this.d.remove(iBinderAsBinder);
                Iterator it = MediaBrowserServiceCompat.this.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f fVar2 = (f) it.next();
                    if (fVar2.c == this.b) {
                        fVar = (TextUtils.isEmpty(this.c) || this.d <= 0) ? MediaBrowserServiceCompat.this.new f(fVar2.a, fVar2.b, fVar2.c, this.e, this.a) : null;
                        it.remove();
                    }
                }
                if (fVar == null) {
                    fVar = MediaBrowserServiceCompat.this.new f(this.c, this.d, this.b, this.e, this.a);
                }
                MediaBrowserServiceCompat.this.d.put(iBinderAsBinder, fVar);
                try {
                    iBinderAsBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        class g implements Runnable {
            final /* synthetic */ o a;

            g(o oVar) {
                this.a = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.a.asBinder();
                f fVar = (f) MediaBrowserServiceCompat.this.d.remove(iBinderAsBinder);
                if (fVar != null) {
                    iBinderAsBinder.unlinkToDeath(fVar, 0);
                }
            }
        }

        class h implements Runnable {
            final /* synthetic */ o a;
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;
            final /* synthetic */ ResultReceiver d;

            h(o oVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.a = oVar;
                this.b = str;
                this.c = bundle;
                this.d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.d.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.o(this.b, this.c, fVar, this.d);
                    return;
                }
                Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.b);
            }
        }

        class i implements Runnable {
            final /* synthetic */ o a;
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;
            final /* synthetic */ ResultReceiver d;

            i(o oVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.a = oVar;
                this.b = str;
                this.c = bundle;
                this.d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.d.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.l(this.b, this.c, fVar, this.d);
                    return;
                }
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.b + ", extras=" + this.c);
            }
        }

        n() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, o oVar) {
            MediaBrowserServiceCompat.this.f.a(new c(oVar, str, iBinder, bundle));
        }

        public void b(String str, int i2, int i3, Bundle bundle, o oVar) {
            if (MediaBrowserServiceCompat.this.c(str, i3)) {
                MediaBrowserServiceCompat.this.f.a(new a(oVar, str, i2, i3, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + str);
        }

        public void c(o oVar) {
            MediaBrowserServiceCompat.this.f.a(new b(oVar));
        }

        public void d(String str, ResultReceiver resultReceiver, o oVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f.a(new e(oVar, str, resultReceiver));
        }

        public void e(o oVar, String str, int i2, int i3, Bundle bundle) {
            MediaBrowserServiceCompat.this.f.a(new f(oVar, i3, str, i2, bundle));
        }

        public void f(String str, IBinder iBinder, o oVar) {
            MediaBrowserServiceCompat.this.f.a(new d(oVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, o oVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f.a(new h(oVar, str, bundle, resultReceiver));
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, o oVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f.a(new i(oVar, str, bundle, resultReceiver));
        }

        public void i(o oVar) {
            MediaBrowserServiceCompat.this.f.a(new g(oVar));
        }
    }

    private interface o {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b();

        void c(String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    private static class p implements o {
        final Messenger a;

        p(Messenger messenger) {
            this.a = messenger;
        }

        private void d(int i, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.a.send(messageObtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public void a(String str, List list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public IBinder asBinder() {
            return this.a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public void b() throws RemoteException {
            d(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            d(1, bundle2);
        }
    }

    private final class q extends Handler {
        private final n a;

        q() {
            this.a = MediaBrowserServiceCompat.this.new n();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    this.a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new p(message.replyTo));
                    break;
                case 2:
                    this.a.c(new p(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    this.a.a(data.getString("data_media_item_id"), AbstractC22752vm0.a(data, "data_callback_token"), bundle2, new p(message.replyTo));
                    break;
                case 4:
                    this.a.f(data.getString("data_media_item_id"), AbstractC22752vm0.a(data, "data_callback_token"), new p(message.replyTo));
                    break;
                case 5:
                    this.a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new p(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    this.a.e(new p(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    break;
                case 7:
                    this.a.i(new p(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    this.a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new p(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    this.a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new p(message.replyTo));
                    break;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j);
        }
    }

    void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<YV4> arrayList = (List) fVar.g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        for (YV4 yv4 : arrayList) {
            if (iBinder == yv4.a && AbstractC18941pW3.a(bundle, (Bundle) yv4.b)) {
                return;
            }
        }
        arrayList.add(new YV4(iBinder, bundle));
        fVar.g.put(str, arrayList);
        m(str, fVar, bundle, null);
        this.e = fVar;
        j(str, bundle);
        this.e = null;
    }

    List b(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i2 == -1 && i3 == -1) {
            return list;
        }
        int i4 = i3 * i2;
        int size = i4 + i3;
        if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
            return Collections.emptyList();
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i4, size);
    }

    boolean c(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i2)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, l lVar) {
        lVar.e(null);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract e e(String str, int i2, Bundle bundle);

    public abstract void f(String str, l lVar);

    public void g(String str, l lVar, Bundle bundle) {
        lVar.g(1);
        f(str, lVar);
    }

    public void h(String str, l lVar) {
        lVar.g(2);
        lVar.f(null);
    }

    public void i(String str, Bundle bundle, l lVar) {
        lVar.g(4);
        lVar.f(null);
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str) {
    }

    void l(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.e = fVar;
        d(str, bundle, dVar);
        this.e = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void m(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.e = fVar;
        if (bundle == null) {
            f(str, aVar);
        } else {
            g(str, aVar, bundle);
        }
        this.e = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.a + " id=" + str);
    }

    void n(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.e = fVar;
        h(str, bVar);
        this.e = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void o(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.e = fVar;
        i(str, bundle, cVar);
        this.e = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a.b(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.a = new k();
        } else if (i2 >= 26) {
            this.a = new j();
        } else {
            this.a = new i();
        }
        this.a.onCreate();
    }

    boolean p(String str, f fVar, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder != null) {
                List list = (List) fVar.g.get(str);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == ((YV4) it.next()).a) {
                            it.remove();
                            z = true;
                        }
                    }
                    if (list.size() == 0) {
                        fVar.g.remove(str);
                    }
                }
            } else if (fVar.g.remove(str) != null) {
                z = true;
            }
            return z;
        } finally {
            this.e = fVar;
            k(str);
            this.e = null;
        }
    }

    public void q(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if (this.g != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.g = token;
        this.a.a(token);
    }
}
