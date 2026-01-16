package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import ir.nasim.AbstractC9683aN7;

/* renamed from: com.google.android.exoplayer2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C2019b {
    private final Context a;
    private final a b;
    private boolean c;

    /* renamed from: com.google.android.exoplayer2.b$a */
    private final class a extends BroadcastReceiver implements Runnable {
        private final InterfaceC0159b a;
        private final Handler b;

        public a(Handler handler, InterfaceC0159b interfaceC0159b) {
            this.b = handler;
            this.a = interfaceC0159b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2019b.this.c) {
                this.a.e();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.b$b, reason: collision with other inner class name */
    public interface InterfaceC0159b {
        void e();
    }

    public C2019b(Context context, Handler handler, InterfaceC0159b interfaceC0159b) {
        this.a = context.getApplicationContext();
        this.b = new a(handler, interfaceC0159b);
    }

    public void b(boolean z) {
        if (z && !this.c) {
            AbstractC9683aN7.L0(this.a, this.b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.c = true;
        } else {
            if (z || !this.c) {
                return;
            }
            this.a.unregisterReceiver(this.b);
            this.c = false;
        }
    }
}
