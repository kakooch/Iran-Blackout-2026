package ir.nasim.auth.auth.main;

import android.content.Context;
import ir.nasim.HP;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.ME2;
import ir.nasim.SB7;
import ir.nasim.designsystem.base.activity.BaseFragmentActivity;

/* loaded from: classes4.dex */
public abstract class Hilt_AuthActivity extends BaseFragmentActivity {
    private boolean K0 = false;

    class a implements InterfaceC10854cJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            Hilt_AuthActivity.this.q1();
        }
    }

    Hilt_AuthActivity() {
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
        ((HP) ((ME2) SB7.a(this)).N2()).r((AuthActivity) SB7.a(this));
    }
}
