package ir.nasim.features.payment.view.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.G;
import ir.nasim.AbstractC18204oG1;
import ir.nasim.C12726f6;
import ir.nasim.C6317Nb6;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.InterfaceC13848gv1;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.LE2;
import ir.nasim.ME2;
import ir.nasim.SB7;
import ir.nasim.features.payment.base.BaseActivity;

/* loaded from: classes6.dex */
public abstract class Hilt_CrowdfundingActivity<B extends InterfaceC9764aW7> extends BaseActivity<B> implements ME2 {
    private C6317Nb6 Y;
    private volatile C12726f6 Z;
    private final Object z0 = new Object();
    private boolean A0 = false;

    class a implements InterfaceC10854cJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            Hilt_CrowdfundingActivity.this.t1();
        }
    }

    Hilt_CrowdfundingActivity() {
        p1();
    }

    private void p1() {
        g0(new a());
    }

    private void s1() {
        if (getApplication() instanceof LE2) {
            C6317Nb6 c6317Nb6B = E4().b();
            this.Y = c6317Nb6B;
            if (c6317Nb6B.b()) {
                this.Y.c(p3());
            }
        }
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.h
    public G.c n3() {
        return AbstractC18204oG1.a(this, super.n3());
    }

    @Override // ir.nasim.features.payment.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6317Nb6 c6317Nb6 = this.Y;
        if (c6317Nb6 != null) {
            c6317Nb6.a();
        }
    }

    @Override // ir.nasim.ME2
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public final C12726f6 E4() {
        if (this.Z == null) {
            synchronized (this.z0) {
                try {
                    if (this.Z == null) {
                        this.Z = r1();
                    }
                } finally {
                }
            }
        }
        return this.Z;
    }

    protected C12726f6 r1() {
        return new C12726f6(this);
    }

    protected void t1() {
        if (this.A0) {
            return;
        }
        this.A0 = true;
        ((InterfaceC13848gv1) N2()).n((CrowdfundingActivity) SB7.a(this));
    }
}
