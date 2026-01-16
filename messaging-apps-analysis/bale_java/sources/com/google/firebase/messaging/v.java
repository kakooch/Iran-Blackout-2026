package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import ir.nasim.InterfaceC20886sm1;
import ir.nasim.KJ;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
class v {
    private final Executor a;
    private final Map b = new KJ();

    interface a {
        Task start();
    }

    v(Executor executor) {
        this.a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task c(String str, Task task) {
        synchronized (this) {
            this.b.remove(str);
        }
        return task;
    }

    synchronized Task b(final String str, a aVar) {
        Task task = (Task) this.b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Making new request for: " + str);
        }
        Task taskJ = aVar.start().j(this.a, new InterfaceC20886sm1() { // from class: com.google.firebase.messaging.u
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task2) {
                return this.a.c(str, task2);
            }
        });
        this.b.put(str, taskJ);
        return taskJ;
    }
}
