package com.google.android.gms.gcm;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import ir.nasim.AbstractC19122po8;
import ir.nasim.AbstractC19773qu8;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.C11364cs8;
import ir.nasim.Gq8;
import ir.nasim.InterfaceC16758lo8;
import ir.nasim.Ir8;
import ir.nasim.Kt8;
import ir.nasim.Mt8;
import ir.nasim.SA7;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public abstract class GcmTaskService extends Service {
    private final Object a = new Object();
    private int b;
    private ExecutorService c;
    private Messenger d;
    private ComponentName e;
    private com.google.android.gms.gcm.a f;
    private Ir8 g;

    class a extends Gq8 {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Messenger messenger;
            if (!SA7.b(GcmTaskService.this, message.sendingUid, "com.google.android.gms")) {
                Log.e("GcmTaskService", "unable to verify presence of Google Play Services");
                return;
            }
            int i = message.what;
            if (i == 1) {
                Bundle data = message.getData();
                if (data.isEmpty() || (messenger = message.replyTo) == null) {
                    return;
                }
                String string = data.getString(ParameterNames.TAG);
                ArrayList parcelableArrayList = data.getParcelableArrayList("triggered_uris");
                long j = data.getLong("max_exec_duration", 180L);
                if (GcmTaskService.this.k(string)) {
                    return;
                }
                GcmTaskService.this.e(GcmTaskService.this.new b(string, messenger, data.getBundle("extras"), j, parcelableArrayList));
                return;
            }
            if (i == 2) {
                if (Log.isLoggable("GcmTaskService", 3)) {
                    String strValueOf = String.valueOf(message);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 45);
                    sb.append("ignoring unimplemented stop message for now: ");
                    sb.append(strValueOf);
                    Log.d("GcmTaskService", sb.toString());
                    return;
                }
                return;
            }
            if (i == 4) {
                GcmTaskService.this.a();
                return;
            }
            String strValueOf2 = String.valueOf(message);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 31);
            sb2.append("Unrecognized message received: ");
            sb2.append(strValueOf2);
            Log.e("GcmTaskService", sb2.toString());
        }
    }

    private final void d(int i) {
        synchronized (this.a) {
            try {
                this.b = i;
                if (!this.f.d(this.e.getClassName())) {
                    stopSelf(this.b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(b bVar) {
        try {
            this.c.execute(bVar);
        } catch (RejectedExecutionException e) {
            Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", e);
            bVar.c(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(String str) {
        boolean z;
        synchronized (this.a) {
            try {
                z = !this.f.b(str, this.e.getClassName());
                if (z) {
                    String packageName = getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 44 + String.valueOf(str).length());
                    sb.append(packageName);
                    sb.append(Separators.SP);
                    sb.append(str);
                    sb.append(": Task already running, won't start another");
                    Log.w("GcmTaskService", sb.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void a() {
    }

    public abstract int b(com.google.android.gms.gcm.b bVar);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null && AbstractC3993Df5.f() && "com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            return this.d.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f = com.google.android.gms.gcm.a.a(this);
        this.c = AbstractC19122po8.a().b(10, new d(this), 10);
        this.d = new Messenger(new a(Looper.getMainLooper()));
        this.e = new ComponentName(this, getClass());
        C11364cs8.a();
        this.g = C11364cs8.a;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        List<Runnable> listShutdownNow = this.c.shutdownNow();
        if (listShutdownNow.isEmpty()) {
            return;
        }
        int size = listShutdownNow.size();
        StringBuilder sb = new StringBuilder(79);
        sb.append("Shutting down, but not all tasks are finished executing. Remaining: ");
        sb.append(size);
        Log.e("GcmTaskService", sb.toString());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        try {
            intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                String stringExtra = intent.getStringExtra(ParameterNames.TAG);
                Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                Bundle bundleExtra = intent.getBundleExtra("extras");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                long longExtra = intent.getLongExtra("max_exec_duration", 180L);
                if (!(parcelableExtra instanceof PendingCallback)) {
                    String packageName = getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 47 + String.valueOf(stringExtra).length());
                    sb.append(packageName);
                    sb.append(Separators.SP);
                    sb.append(stringExtra);
                    sb.append(": Could not process request, invalid callback.");
                    Log.e("GcmTaskService", sb.toString());
                    return 2;
                }
                if (k(stringExtra)) {
                    return 2;
                }
                e(new b(stringExtra, ((PendingCallback) parcelableExtra).a, bundleExtra, longExtra, parcelableArrayListExtra));
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                a();
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 37);
                sb2.append("Unknown action received ");
                sb2.append(action);
                sb2.append(", terminating");
                Log.e("GcmTaskService", sb2.toString());
            }
            return 2;
        } finally {
            d(i2);
        }
    }

    class b implements Runnable {
        private final String a;
        private final Bundle b;
        private final List c;
        private final long d;
        private final InterfaceC16758lo8 e;
        private final Messenger f;

        b(String str, IBinder iBinder, Bundle bundle, long j, List list) {
            InterfaceC16758lo8 eVar;
            this.a = str;
            if (iBinder == null) {
                eVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                eVar = iInterfaceQueryLocalInterface instanceof InterfaceC16758lo8 ? (InterfaceC16758lo8) iInterfaceQueryLocalInterface : new e(iBinder);
            }
            this.e = eVar;
            this.b = bundle;
            this.d = j;
            this.c = list;
            this.f = null;
        }

        private static /* synthetic */ void b(Throwable th, Kt8 kt8) {
            if (th == null) {
                kt8.close();
                return;
            }
            try {
                kt8.close();
            } catch (Throwable th2) {
                AbstractC19773qu8.b(th, th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(int i) {
            synchronized (GcmTaskService.this.a) {
                try {
                    try {
                        try {
                        } catch (RemoteException unused) {
                            String strValueOf = String.valueOf(this.a);
                            Log.e("GcmTaskService", strValueOf.length() != 0 ? "Error reporting result of operation to scheduler for ".concat(strValueOf) : new String("Error reporting result of operation to scheduler for "));
                            GcmTaskService.this.f.c(this.a, GcmTaskService.this.e.getClassName());
                            if (!d() && !GcmTaskService.this.f.d(GcmTaskService.this.e.getClassName())) {
                                GcmTaskService gcmTaskService = GcmTaskService.this;
                                gcmTaskService.stopSelf(gcmTaskService.b);
                            }
                        }
                        if (GcmTaskService.this.f.e(this.a, GcmTaskService.this.e.getClassName())) {
                            GcmTaskService.this.f.c(this.a, GcmTaskService.this.e.getClassName());
                            if (!d() && !GcmTaskService.this.f.d(GcmTaskService.this.e.getClassName())) {
                                GcmTaskService gcmTaskService2 = GcmTaskService.this;
                                gcmTaskService2.stopSelf(gcmTaskService2.b);
                            }
                            return;
                        }
                        if (d()) {
                            Messenger messenger = this.f;
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 3;
                            messageObtain.arg1 = i;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("component", GcmTaskService.this.e);
                            bundle.putString(ParameterNames.TAG, this.a);
                            messageObtain.setData(bundle);
                            messenger.send(messageObtain);
                        } else {
                            this.e.y(i);
                        }
                        GcmTaskService.this.f.c(this.a, GcmTaskService.this.e.getClassName());
                        if (!d() && !GcmTaskService.this.f.d(GcmTaskService.this.e.getClassName())) {
                            GcmTaskService gcmTaskService3 = GcmTaskService.this;
                            gcmTaskService3.stopSelf(gcmTaskService3.b);
                        }
                    } catch (Throwable th) {
                        GcmTaskService.this.f.c(this.a, GcmTaskService.this.e.getClassName());
                        if (!d() && !GcmTaskService.this.f.d(GcmTaskService.this.e.getClassName())) {
                            GcmTaskService gcmTaskService4 = GcmTaskService.this;
                            gcmTaskService4.stopSelf(gcmTaskService4.b);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        private final boolean d() {
            return this.f != null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String strValueOf = String.valueOf(this.a);
            Kt8 kt8 = new Kt8(strValueOf.length() != 0 ? "nts:client:onRunTask:".concat(strValueOf) : new String("nts:client:onRunTask:"));
            try {
                com.google.android.gms.gcm.b bVar = new com.google.android.gms.gcm.b(this.a, this.b, this.d, this.c);
                GcmTaskService.this.g.zzd("onRunTask", Mt8.a);
                try {
                    c(GcmTaskService.this.b(bVar));
                    b(null, kt8);
                } finally {
                }
            } finally {
            }
        }

        b(String str, Messenger messenger, Bundle bundle, long j, List list) {
            this.a = str;
            this.f = messenger;
            this.b = bundle;
            this.d = j;
            this.c = list;
            this.e = null;
        }
    }
}
