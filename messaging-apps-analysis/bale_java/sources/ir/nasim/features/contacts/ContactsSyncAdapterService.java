package ir.nasim.features.contacts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import ir.nasim.C5444Jj1;

/* loaded from: classes5.dex */
public class ContactsSyncAdapterService extends Service {
    private static C5444Jj1 a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return a.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public synchronized void onCreate() {
        if (a == null) {
            a = new C5444Jj1(getBaseContext(), true);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}
