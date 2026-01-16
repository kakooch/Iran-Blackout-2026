package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import ir.nasim.features.MainActivity;
import ir.nasim.features.forceupdate.ForceUpdateActivity;

/* renamed from: ir.nasim.Dp, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4077Dp extends AbstractC3843Cp {
    private final String a = "AndroidLifecycleProviderHandler";
    private String b;

    private void h() {
        C15788kA3.a.j();
    }

    private void i() {
        C16272kz6.a.d();
    }

    @Override // ir.nasim.AbstractC3843Cp
    public String a() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        if (this.b == null) {
            Context context = C5721Ko.b;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                C19406qI3.c("AndroidLifecycleProviderHandler", "getVersion :" + e.getMessage(), e);
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.b = packageInfo.versionName;
            }
        }
        return this.b;
    }

    @Override // ir.nasim.AbstractC3843Cp
    public void b() {
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    @Override // ir.nasim.AbstractC3843Cp
    public InterfaceC22912w18 c() {
        return new C11976ds();
    }

    @Override // ir.nasim.AbstractC3843Cp
    public synchronized void d() {
        try {
        } catch (Exception e) {
            C19406qI3.j("AndroidLifecycleProviderHandler", "onLogout :" + e.getMessage(), new Object[0]);
        }
        if (C13923h3.a.t()) {
            i();
            h();
            e();
        } else {
            C7183Qq.s().putString("build_serial", null);
            i();
            h();
            e();
        }
    }

    @Override // ir.nasim.AbstractC3843Cp
    public void e() {
        f(new Intent());
    }

    @Override // ir.nasim.AbstractC3843Cp
    public void f(Intent intent) {
        try {
            if (!AbstractC5969Lp4.d().i2().B()) {
                C19406qI3.a("AndroidLifecycleProviderHandler", "App is not open, Ignored restating just killing app.", new Object[0]);
                b();
                return;
            }
            if (AbstractC5969Lp4.d().i2().L()) {
                try {
                    Intent intent2 = new Intent(C5721Ko.b, (Class<?>) ForceUpdateActivity.class);
                    intent2.addFlags(335577088);
                    C5721Ko.b.startActivity(intent2);
                    b();
                    return;
                } catch (Exception e) {
                    C19406qI3.d("AndroidLifecycleProviderHandler", e);
                    return;
                }
            }
            try {
                Intent intent3 = new Intent(C5721Ko.b, (Class<?>) MainActivity.class);
                intent3.addFlags(335577088);
                intent3.putExtras(intent);
                C5721Ko.b.startActivity(intent3);
                b();
            } catch (Exception e2) {
                C19406qI3.d("AndroidLifecycleProviderHandler", e2);
            }
        } catch (Exception e3) {
            C19406qI3.d("AndroidLifecycleProviderHandler", e3);
        }
    }

    @Override // ir.nasim.AbstractC3843Cp
    public boolean g() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
