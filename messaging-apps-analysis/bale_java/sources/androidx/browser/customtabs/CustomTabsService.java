package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import ir.nasim.AZ2;
import ir.nasim.BZ2;
import ir.nasim.C24792zC6;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class CustomTabsService extends Service {
    final C24792zC6 a = new C24792zC6();
    private BZ2.a b = new a();

    class a extends BZ2.a {
        a() {
        }

        private PendingIntent C2(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D2(b bVar) {
            CustomTabsService.this.a(bVar);
        }

        private boolean E2(AZ2 az2, PendingIntent pendingIntent) {
            final b bVar = new b(az2, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.a
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        this.a.D2(bVar);
                    }
                };
                synchronized (CustomTabsService.this.a) {
                    az2.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.a.put(az2.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.d(bVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // ir.nasim.BZ2
        public boolean A0(AZ2 az2) {
            return E2(az2, null);
        }

        @Override // ir.nasim.BZ2
        public boolean A2(AZ2 az2, int i, Uri uri, Bundle bundle) {
            return CustomTabsService.this.i(new b(az2, C2(bundle)), i, uri, bundle);
        }

        @Override // ir.nasim.BZ2
        public boolean C1(AZ2 az2, Bundle bundle) {
            return E2(az2, C2(bundle));
        }

        @Override // ir.nasim.BZ2
        public boolean M1(long j) {
            return CustomTabsService.this.j(j);
        }

        @Override // ir.nasim.BZ2
        public boolean O(AZ2 az2, Uri uri) {
            return CustomTabsService.this.g(new b(az2, null), uri);
        }

        @Override // ir.nasim.BZ2
        public Bundle c0(String str, Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        @Override // ir.nasim.BZ2
        public boolean d1(AZ2 az2, Uri uri, int i, Bundle bundle) {
            return CustomTabsService.this.f(new b(az2, C2(bundle)), uri, i, bundle);
        }

        @Override // ir.nasim.BZ2
        public int k0(AZ2 az2, String str, Bundle bundle) {
            return CustomTabsService.this.e(new b(az2, C2(bundle)), str, bundle);
        }

        @Override // ir.nasim.BZ2
        public boolean l0(AZ2 az2, Uri uri, Bundle bundle) {
            return CustomTabsService.this.g(new b(az2, C2(bundle)), uri);
        }

        @Override // ir.nasim.BZ2
        public boolean l2(AZ2 az2, Bundle bundle) {
            return CustomTabsService.this.h(new b(az2, C2(bundle)), bundle);
        }

        @Override // ir.nasim.BZ2
        public boolean t1(AZ2 az2, Uri uri, Bundle bundle, List list) {
            return CustomTabsService.this.c(new b(az2, C2(bundle)), uri, bundle, list);
        }
    }

    protected boolean a(b bVar) {
        try {
            synchronized (this.a) {
                try {
                    IBinder iBinderA = bVar.a();
                    if (iBinderA == null) {
                        return false;
                    }
                    iBinderA.unlinkToDeath((IBinder.DeathRecipient) this.a.get(iBinderA), 0);
                    this.a.remove(iBinderA);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    protected abstract Bundle b(String str, Bundle bundle);

    protected abstract boolean c(b bVar, Uri uri, Bundle bundle, List list);

    protected abstract boolean d(b bVar);

    protected abstract int e(b bVar, String str, Bundle bundle);

    protected abstract boolean f(b bVar, Uri uri, int i, Bundle bundle);

    protected abstract boolean g(b bVar, Uri uri);

    protected abstract boolean h(b bVar, Bundle bundle);

    protected abstract boolean i(b bVar, int i, Uri uri, Bundle bundle);

    protected abstract boolean j(long j);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.b;
    }
}
