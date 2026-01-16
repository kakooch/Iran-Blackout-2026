package ir.nasim.features.root;

import android.content.Context;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.InterfaceC12703f36;
import ir.nasim.ME2;
import ir.nasim.SB7;
import ir.nasim.designsystem.base.activity.PasscodeRequiredActivity;

/* loaded from: classes6.dex */
public abstract class Hilt_RootActivity extends PasscodeRequiredActivity {
    private boolean O0 = false;

    class a implements InterfaceC10854cJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            Hilt_RootActivity.this.q1();
        }
    }

    Hilt_RootActivity() {
        l1();
    }

    private void l1() {
        g0(new a());
    }

    @Override // ir.nasim.designsystem.base.activity.Hilt_BaseActivity
    protected void q1() {
        if (this.O0) {
            return;
        }
        this.O0 = true;
        ((InterfaceC12703f36) ((ME2) SB7.a(this)).N2()).l((RootActivity) SB7.a(this));
    }
}
