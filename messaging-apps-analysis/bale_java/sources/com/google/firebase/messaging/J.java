package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.M;
import ir.nasim.ExecutorC4596Fu5;
import ir.nasim.WI4;

/* loaded from: classes3.dex */
class J extends Binder {
    private final a a;

    interface a {
        Task a(Intent intent);
    }

    J(a aVar) {
        this.a = aVar;
    }

    void c(final M.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        this.a.a(aVar.a).c(new ExecutorC4596Fu5(), new WI4() { // from class: com.google.firebase.messaging.I
            @Override // ir.nasim.WI4
            public final void onComplete(Task task) {
                aVar.d();
            }
        });
    }
}
