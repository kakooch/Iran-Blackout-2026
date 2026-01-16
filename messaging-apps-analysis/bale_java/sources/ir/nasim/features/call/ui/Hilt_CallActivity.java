package ir.nasim.features.call.ui;

import android.content.Context;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.InterfaceC4591Fu0;
import ir.nasim.ME2;
import ir.nasim.SB7;
import ir.nasim.designsystem.base.activity.BaseFragmentActivity;

/* loaded from: classes5.dex */
public abstract class Hilt_CallActivity extends BaseFragmentActivity {
    private boolean K0 = false;

    class a implements InterfaceC10854cJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            Hilt_CallActivity.this.q1();
        }
    }

    Hilt_CallActivity() {
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
        ((InterfaceC4591Fu0) ((ME2) SB7.a(this)).N2()).c((CallActivity) SB7.a(this));
    }
}
