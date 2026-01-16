package ir.nasim.developermode;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC18204oG1;
import ir.nasim.C12726f6;
import ir.nasim.C6317Nb6;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.LE2;
import ir.nasim.LJ1;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes5.dex */
public abstract class Hilt_DeveloperModeActivity extends ComponentActivity implements ME2 {
    private C6317Nb6 w;
    private volatile C12726f6 x;
    private final Object y = new Object();
    private boolean z = false;

    class a implements InterfaceC10854cJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            Hilt_DeveloperModeActivity.this.A0();
        }
    }

    Hilt_DeveloperModeActivity() {
        v0();
    }

    private void v0() {
        g0(new a());
    }

    private void z0() {
        if (getApplication() instanceof LE2) {
            C6317Nb6 c6317Nb6B = E4().b();
            this.w = c6317Nb6B;
            if (c6317Nb6B.b()) {
                this.w.c(p3());
            }
        }
    }

    protected void A0() {
        if (this.z) {
            return;
        }
        this.z = true;
        ((LJ1) N2()).s((DeveloperModeActivity) SB7.a(this));
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.h
    public G.c n3() {
        return AbstractC18204oG1.a(this, super.n3());
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z0();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6317Nb6 c6317Nb6 = this.w;
        if (c6317Nb6 != null) {
            c6317Nb6.a();
        }
    }

    @Override // ir.nasim.ME2
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public final C12726f6 E4() {
        if (this.x == null) {
            synchronized (this.y) {
                try {
                    if (this.x == null) {
                        this.x = y0();
                    }
                } finally {
                }
            }
        }
        return this.x;
    }

    protected C12726f6 y0() {
        return new C12726f6(this);
    }
}
