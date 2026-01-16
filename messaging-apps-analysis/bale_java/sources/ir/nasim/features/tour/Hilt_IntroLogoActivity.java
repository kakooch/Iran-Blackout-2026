package ir.nasim.features.tour;

import android.content.Context;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.InterfaceC3964Dc3;
import ir.nasim.ME2;
import ir.nasim.SB7;
import ir.nasim.designsystem.base.activity.BaseActivity;

/* loaded from: classes6.dex */
public abstract class Hilt_IntroLogoActivity extends BaseActivity {
    private boolean K0 = false;

    class a implements InterfaceC10854cJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            Hilt_IntroLogoActivity.this.q1();
        }
    }

    Hilt_IntroLogoActivity() {
        l1();
    }

    private void l1() {
        g0(new a());
    }

    @Override // ir.nasim.designsystem.base.activity.Hilt_BaseActivity
    protected void q1() {
        if (this.K0) {
            return;
        }
        this.K0 = true;
        ((InterfaceC3964Dc3) ((ME2) SB7.a(this)).N2()).g((IntroLogoActivity) SB7.a(this));
    }
}
