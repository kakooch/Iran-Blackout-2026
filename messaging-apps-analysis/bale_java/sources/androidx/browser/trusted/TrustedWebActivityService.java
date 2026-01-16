package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import androidx.browser.trusted.d;
import ir.nasim.AD4;
import ir.nasim.InterfaceC15097j03;
import ir.nasim.InterfaceC23995xr7;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class TrustedWebActivityService extends Service {
    private NotificationManager a;
    int b = -1;
    private final InterfaceC15097j03.a c = new a();

    class a extends InterfaceC15097j03.a {
        a() {
        }

        private void B2() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int i = trustedWebActivityService.b;
            if (i != -1) {
                if (i != Binder.getCallingUid()) {
                    throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
                }
            } else {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                TrustedWebActivityService.this.c();
                throw null;
            }
        }

        @Override // ir.nasim.InterfaceC15097j03
        public Bundle L0(Bundle bundle) {
            B2();
            d.C0016d c0016dA = d.C0016d.a(bundle);
            return new d.e(TrustedWebActivityService.this.j(c0016dA.a, c0016dA.b, c0016dA.c, c0016dA.d)).a();
        }

        @Override // ir.nasim.InterfaceC15097j03
        public int Z1() {
            B2();
            return TrustedWebActivityService.this.i();
        }

        @Override // ir.nasim.InterfaceC15097j03
        public Bundle c2(Bundle bundle) {
            B2();
            return new d.e(TrustedWebActivityService.this.d(d.c.a(bundle).a)).a();
        }

        @Override // ir.nasim.InterfaceC15097j03
        public Bundle i0(String str, Bundle bundle, IBinder iBinder) {
            B2();
            return TrustedWebActivityService.this.f(str, bundle, c.a(iBinder));
        }

        @Override // ir.nasim.InterfaceC15097j03
        public void k2(Bundle bundle) {
            B2();
            d.b bVarA = d.b.a(bundle);
            TrustedWebActivityService.this.e(bVarA.a, bVarA.b);
        }

        @Override // ir.nasim.InterfaceC15097j03
        public Bundle q1() {
            B2();
            return new d.a(TrustedWebActivityService.this.g()).a();
        }

        @Override // ir.nasim.InterfaceC15097j03
        public Bundle y0() {
            B2();
            return TrustedWebActivityService.this.h();
        }
    }

    private static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    private void b() {
        if (this.a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract InterfaceC23995xr7 c();

    public boolean d(String str) {
        b();
        if (!AD4.e(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return b.b(this.a, a(str));
    }

    public void e(String str, int i) {
        b();
        this.a.cancel(str, i);
    }

    public Bundle f(String str, Bundle bundle, c cVar) {
        return null;
    }

    public Parcelable[] g() {
        b();
        return androidx.browser.trusted.a.a(this.a);
    }

    public Bundle h() {
        int i = i();
        Bundle bundle = new Bundle();
        if (i == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i));
        return bundle;
    }

    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean j(String str, int i, Notification notification, String str2) {
        b();
        if (!AD4.e(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String strA = a(str2);
            notification = b.a(this, this.a, notification, strA, str2);
            if (!b.b(this.a, strA)) {
                return false;
            }
        }
        this.a.notify(str, i, notification);
        return true;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.c;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.b = -1;
        return super.onUnbind(intent);
    }
}
