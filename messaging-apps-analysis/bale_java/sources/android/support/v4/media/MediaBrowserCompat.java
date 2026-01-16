package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC22752vm0;
import ir.nasim.KJ;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    static final boolean b = Log.isLoggable("MediaBrowserCompat", 3);
    private final c a;

    private static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.p(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable != null && !(parcelable instanceof MediaItem)) {
                throw null;
            }
            throw null;
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();
        private final int a;
        private final MediaDescriptionCompat b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        }

        MediaItem(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.a + ", mDescription=" + this.b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            this.b.writeToParcel(parcel, i);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.p(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            parcelableArray.getClass();
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            throw null;
        }
    }

    private static class a extends Handler {
        private final WeakReference a;
        private WeakReference b;

        a(g gVar) {
            this.a = new WeakReference(gVar);
        }

        void a(Messenger messenger) {
            this.b = new WeakReference(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference weakReference = this.b;
            if (weakReference == null || weakReference.get() == null || this.a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            g gVar = (g) this.a.get();
            Messenger messenger = (Messenger) this.b.get();
            try {
                int i = message.what;
                if (i == 1) {
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    gVar.h(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                } else if (i == 2) {
                    gVar.j(messenger);
                } else if (i != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                    MediaSessionCompat.a(bundle3);
                    gVar.d(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    gVar.j(messenger);
                }
            }
        }
    }

    public static class b {
        final MediaBrowser.ConnectionCallback a = new a();
        InterfaceC0002b b;

        private class a extends MediaBrowser.ConnectionCallback {
            a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                InterfaceC0002b interfaceC0002b = b.this.b;
                if (interfaceC0002b != null) {
                    interfaceC0002b.f();
                }
                b.this.a();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                InterfaceC0002b interfaceC0002b = b.this.b;
                if (interfaceC0002b != null) {
                    interfaceC0002b.g();
                }
                b.this.b();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                InterfaceC0002b interfaceC0002b = b.this.b;
                if (interfaceC0002b != null) {
                    interfaceC0002b.i();
                }
                b.this.c();
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b, reason: collision with other inner class name */
        interface InterfaceC0002b {
            void f();

            void g();

            void i();
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        void d(InterfaceC0002b interfaceC0002b) {
            this.b = interfaceC0002b;
        }
    }

    interface c {
        boolean a();

        MediaSessionCompat.Token b();

        void c();

        void e();
    }

    static class d implements c, g, b.InterfaceC0002b {
        final Context a;
        protected final MediaBrowser b;
        protected final Bundle c;
        protected final a d = new a(this);
        private final KJ e = new KJ();
        protected int f;
        protected h g;
        protected Messenger h;
        private MediaSessionCompat.Token i;

        d(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            this.a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.c = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bundle2.putInt("extra_calling_pid", Process.myPid());
            bVar.d(this);
            this.b = new MediaBrowser(context, componentName, bVar.a, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public boolean a() {
            return this.b.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public MediaSessionCompat.Token b() {
            if (this.i == null) {
                this.i = MediaSessionCompat.Token.a(this.b.getSessionToken());
            }
            return this.i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void c() {
            Messenger messenger;
            h hVar = this.g;
            if (hVar != null && (messenger = this.h) != null) {
                try {
                    hVar.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.b.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void d(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.h != messenger) {
                return;
            }
            AbstractC18350oW3.a(this.e.get(str));
            if (MediaBrowserCompat.b) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void e() {
            this.b.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0002b
        public void f() {
            try {
                Bundle extras = this.b.getExtras();
                if (extras == null) {
                    return;
                }
                this.f = extras.getInt("extra_service_version", 0);
                IBinder iBinderA = AbstractC22752vm0.a(extras, "extra_messenger");
                if (iBinderA != null) {
                    this.g = new h(iBinderA, this.c);
                    Messenger messenger = new Messenger(this.d);
                    this.h = messenger;
                    this.d.a(messenger);
                    try {
                        this.g.a(this.a, this.h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                android.support.v4.media.session.b bVarB2 = b.a.B2(AbstractC22752vm0.a(extras, "extra_session_binder"));
                if (bVarB2 != null) {
                    this.i = MediaSessionCompat.Token.b(this.b.getSessionToken(), bVarB2);
                }
            } catch (IllegalStateException e) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0002b
        public void g() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void h(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0002b
        public void i() {
            this.g = null;
            this.h = null;
            this.i = null;
            this.d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void j(Messenger messenger) {
        }
    }

    static class e extends d {
        e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    static class f extends e {
        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    interface g {
        void d(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void h(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void j(Messenger messenger);
    }

    private static class h {
        private Messenger a;
        private Bundle b;

        public h(IBinder iBinder, Bundle bundle) {
            this.a = new Messenger(iBinder);
            this.b = bundle;
        }

        private void b(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.a.send(messageObtain);
        }

        void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.b);
            b(6, bundle, messenger);
        }

        void c(Messenger messenger) throws RemoteException {
            b(7, null, messenger);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new f(context, componentName, bVar, bundle);
        } else {
            this.a = new e(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.a.e();
    }

    public void b() {
        this.a.c();
    }

    public MediaSessionCompat.Token c() {
        return this.a.b();
    }

    public boolean d() {
        return this.a.a();
    }
}
