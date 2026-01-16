package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.C2367d;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.ExecutorC4596Fu5;
import ir.nasim.InterfaceC20886sm1;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.messaging.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2367d {
    private static final Object c = new Object();
    private static M d;
    private final Context a;
    private final Executor b = new ExecutorC4596Fu5();

    public C2367d(Context context) {
        this.a = context;
    }

    private static Task d(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        if (w.b().e(context)) {
            H.f(context, e(context, "com.google.firebase.MESSAGING_EVENT"), intent);
        } else {
            e(context, "com.google.firebase.MESSAGING_EVENT").c(intent);
        }
        return AbstractC9078Yj7.e(-1);
    }

    private static M e(Context context, String str) {
        M m;
        synchronized (c) {
            try {
                if (d == null) {
                    d = new M(context, str);
                }
                m = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer f(Context context, Intent intent) {
        return Integer.valueOf(w.b().g(context, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer g(Task task) {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task h(Context context, Intent intent, Task task) {
        return (AbstractC3993Df5.h() && ((Integer) task.l()).intValue() == 402) ? d(context, intent).h(new ExecutorC4596Fu5(), new InterfaceC20886sm1() { // from class: ir.nasim.Fg2
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task2) {
                return C2367d.g(task2);
            }
        }) : task;
    }

    public Task i(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return j(this.a, intent);
    }

    public Task j(final Context context, final Intent intent) {
        return (!(AbstractC3993Df5.h() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? AbstractC9078Yj7.c(this.b, new Callable() { // from class: ir.nasim.Dg2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C2367d.f(context, intent);
            }
        }).j(this.b, new InterfaceC20886sm1() { // from class: ir.nasim.Eg2
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task) {
                return C2367d.h(context, intent, task);
            }
        }) : d(context, intent);
    }
}
