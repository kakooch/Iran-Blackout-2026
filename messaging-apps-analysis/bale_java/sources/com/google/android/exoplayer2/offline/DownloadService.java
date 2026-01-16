package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC22615vY1;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.FE4;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class DownloadService extends Service {
    private static final HashMap j = new HashMap();
    private final String a;
    private final int b;
    private final int c;
    private a d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    private static final class a {
        static /* synthetic */ AbstractC22615vY1 a(a aVar) {
            aVar.getClass();
            return null;
        }

        public abstract void b(DownloadService downloadService);

        public abstract void c(DownloadService downloadService);
    }

    protected abstract AbstractC22615vY1 a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.a;
        if (str != null) {
            FE4.a(this, str, this.b, this.c, 2);
        }
        int i = AbstractC9683aN7.a;
        a();
        throw null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.i = true;
        ((a) AbstractC20011rK.e(this.d)).c(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int onStartCommand(android.content.Intent r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.g = true;
    }
}
