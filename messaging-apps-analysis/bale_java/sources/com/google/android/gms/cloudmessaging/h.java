package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C3264Ad1;
import ir.nasim.HandlerC23956xn8;
import ir.nasim.Or8;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class h implements ServiceConnection {
    i c;
    final /* synthetic */ m f;
    int a = 0;
    final Messenger b = new Messenger(new HandlerC23956xn8(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.b
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            h hVar = this.a;
            int i = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Received response to request: ");
                sb.append(i);
                Log.d("MessengerIpcClient", sb.toString());
            }
            synchronized (hVar) {
                try {
                    k kVar = (k) hVar.e.get(i);
                    if (kVar == null) {
                        StringBuilder sb2 = new StringBuilder(50);
                        sb2.append("Received response for unknown request: ");
                        sb2.append(i);
                        Log.w("MessengerIpcClient", sb2.toString());
                        return true;
                    }
                    hVar.e.remove(i);
                    hVar.f();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        kVar.c(new zzq(4, "Not supported by GmsCore", null));
                        return true;
                    }
                    kVar.a(data);
                    return true;
                } finally {
                }
            }
        }
    }));
    final Queue d = new ArrayDeque();
    final SparseArray e = new SparseArray();

    /* synthetic */ h(m mVar, Or8 or8) {
        this.f = mVar;
    }

    final synchronized void a(int i, String str) {
        b(i, str, null);
    }

    final synchronized void b(int i, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(str);
                Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
            }
            int i2 = this.a;
            if (i2 == 0) {
                throw new IllegalStateException();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.a = 4;
            C3264Ad1.b().c(this.f.a, this);
            zzq zzqVar = new zzq(i, str, th);
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((k) it.next()).c(zzqVar);
            }
            this.d.clear();
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                ((k) this.e.valueAt(i3)).c(zzqVar);
            }
            this.e.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    final void c() {
        this.f.b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.d
            @Override // java.lang.Runnable
            public final void run() {
                final k kVar;
                final h hVar = this.a;
                while (true) {
                    synchronized (hVar) {
                        try {
                            if (hVar.a != 2) {
                                return;
                            }
                            if (hVar.d.isEmpty()) {
                                hVar.f();
                                return;
                            } else {
                                kVar = (k) hVar.d.poll();
                                hVar.e.put(kVar.a, kVar);
                                hVar.f.b.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.g
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        hVar.e(kVar.a);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String strValueOf = String.valueOf(kVar);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
                        sb.append("Sending ");
                        sb.append(strValueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    Context context = hVar.f.a;
                    Messenger messenger = hVar.b;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = kVar.c;
                    messageObtain.arg1 = kVar.a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", kVar.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", kVar.d);
                    messageObtain.setData(bundle);
                    try {
                        hVar.c.a(messageObtain);
                    } catch (RemoteException e) {
                        hVar.a(2, e.getMessage());
                    }
                }
            }
        });
    }

    final synchronized void d() {
        if (this.a == 1) {
            a(1, "Timed out while binding");
        }
    }

    final synchronized void e(int i) {
        k kVar = (k) this.e.get(i);
        if (kVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.e.remove(i);
            kVar.c(new zzq(3, "Timed out waiting for response", null));
            f();
        }
    }

    final synchronized void f() {
        try {
            if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.a = 3;
                C3264Ad1.b().c(this.f.a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized boolean g(k kVar) {
        int i = this.a;
        if (i != 0) {
            if (i == 1) {
                this.d.add(kVar);
                return true;
            }
            if (i != 2) {
                return false;
            }
            this.d.add(kVar);
            c();
            return true;
        }
        this.d.add(kVar);
        AbstractC3795Cj5.m(this.a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (C3264Ad1.b().a(this.f.a, intent, this, 1)) {
                this.f.b.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e) {
            b(0, "Unable to bind to service", e);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f.b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.f
            @Override // java.lang.Runnable
            public final void run() {
                h hVar = this.a;
                IBinder iBinder2 = iBinder;
                synchronized (hVar) {
                    if (iBinder2 == null) {
                        hVar.a(0, "Null service connection");
                        return;
                    }
                    try {
                        hVar.c = new i(iBinder2);
                        hVar.a = 2;
                        hVar.c();
                    } catch (RemoteException e) {
                        hVar.a(0, e.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f.b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(2, "Service disconnected");
            }
        });
    }
}
