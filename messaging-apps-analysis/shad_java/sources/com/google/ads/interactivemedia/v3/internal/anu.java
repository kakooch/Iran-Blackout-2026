package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class anu implements Handler.Callback {
    protected final long a;
    protected boolean b;
    protected final ContentProgressProvider c;
    private final ans d;
    private final List<ant> e;

    anu(ContentProgressProvider contentProgressProvider) {
        this();
        this.c = contentProgressProvider;
    }

    final void a(ant antVar) {
        this.e.add(antVar);
    }

    final void b(ant antVar) {
        this.e.remove(antVar);
    }

    final void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.d.b();
    }

    final void d() {
        if (this.b) {
            this.b = false;
            this.d.c();
        }
    }

    public VideoProgressUpdate e() {
        VideoProgressUpdate contentProgress = this.c.getContentProgress();
        if (contentProgress != null) {
            return contentProgress;
        }
        Log.w("IMASDK", "ContentProgressProvider.getContentProgress() is null. Use VideoProgressUpdate.VIDEO_TIME_NOT_READY instead.");
        return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0 || i == 1) {
            VideoProgressUpdate videoProgressUpdateE = e();
            Iterator<ant> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().a(videoProgressUpdateE);
            }
            this.d.d(this.a);
        } else if (i == 2) {
            this.d.a();
        }
        return true;
    }

    anu() {
        this.b = false;
        this.e = new ArrayList(1);
        this.a = 200L;
        this.d = new ans(new Handler(this));
    }
}
