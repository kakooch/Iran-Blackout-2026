package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class bd implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ bf a;
    private final Handler b;

    public bd(bf bfVar, Handler handler) {
        this.a = bfVar;
        this.b = handler;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(final int i) {
        this.b.post(new Runnable(this, i) { // from class: com.google.ads.interactivemedia.v3.internal.bc
            private final bd a;
            private final int b;

            {
                this.a = this;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                bd bdVar = this.a;
                bf.e(bdVar.a, this.b);
            }
        });
    }
}
