package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ir.nasim.DW5;

/* loaded from: classes2.dex */
class u {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((DW5) message.obj).a();
            return true;
        }
    }

    u() {
    }

    synchronized void a(DW5 dw5, boolean z) {
        try {
            if (this.a || z) {
                this.b.obtainMessage(1, dw5).sendToTarget();
            } else {
                this.a = true;
                dw5.a();
                this.a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
