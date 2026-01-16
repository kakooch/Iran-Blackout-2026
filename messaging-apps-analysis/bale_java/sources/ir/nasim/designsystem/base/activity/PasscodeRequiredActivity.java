package ir.nasim.designsystem.base.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C16731lm1;
import ir.nasim.C19406qI3;
import ir.nasim.C23073wI7;
import ir.nasim.C5721Ko;
import ir.nasim.designsystem.PasscodeView;
import ir.nasim.features.media.components.PhotoViewerAbs;
import java.util.Date;

/* loaded from: classes5.dex */
public class PasscodeRequiredActivity extends BaseFragmentActivity {
    public PasscodeView K0;
    protected Runnable L0;
    protected FrameLayout M0;
    private boolean N0 = true;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PasscodeRequiredActivity.this.L0 == this) {
                if (AbstractC7426Rr.L(true)) {
                    System.out.println("lock app");
                    PasscodeRequiredActivity passcodeRequiredActivity = PasscodeRequiredActivity.this;
                    if (passcodeRequiredActivity.K0 == null) {
                        passcodeRequiredActivity.q2();
                    }
                    PasscodeRequiredActivity.this.E2();
                } else {
                    System.out.println("didn't pass lock check");
                }
                PasscodeRequiredActivity.this.L0 = null;
            }
        }
    }

    private void A2() {
        if (C23073wI7.g.length() != 0) {
            C23073wI7.k = new Date().getTime();
            a aVar = new a();
            this.L0 = aVar;
            if (C23073wI7.i) {
                AbstractC7426Rr.Q(aVar, 1000L);
            } else {
                AbstractC7426Rr.Q(aVar, 61000L);
            }
        } else {
            C23073wI7.k = 0L;
        }
        C23073wI7.e();
    }

    private void B2() {
        Runnable runnable = this.L0;
        if (runnable != null) {
            AbstractC7426Rr.w(runnable);
            this.L0 = null;
        }
        if (AbstractC7426Rr.L(true)) {
            if (this.K0 == null) {
                q2();
            }
            E2();
        }
        if (C23073wI7.k != 0) {
            C23073wI7.k = 0L;
            C23073wI7.e();
        }
        PasscodeView passcodeView = this.K0;
        if (passcodeView == null || passcodeView.getVisibility() != 0) {
            return;
        }
        this.K0.o();
    }

    private void D2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        if (this.M0 == null) {
            return;
        }
        PasscodeView passcodeView = new PasscodeView(this);
        this.K0 = passcodeView;
        this.M0.addView(passcodeView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.K0.setLayoutParams(layoutParams);
    }

    private void r2() {
        PasscodeView passcodeView = this.K0;
        if (passcodeView == null) {
            return;
        }
        passcodeView.setVisibility(8);
    }

    private boolean v2(Intent intent) {
        ComponentName componentNameResolveActivity = intent.resolveActivity(getPackageManager());
        return componentNameResolveActivity != null && componentNameResolveActivity.getPackageName().equals(getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2() {
        C23073wI7.j = false;
        r2();
        D2();
    }

    public void C2(boolean z) {
        this.N0 = z;
    }

    protected void E2() {
        if (this.K0 == null) {
            return;
        }
        C23073wI7.i = true;
        if (PhotoViewerAbs.getInstance().isVisible()) {
            PhotoViewerAbs.getInstance().closePhoto(false, true);
        }
        this.K0.p();
        C23073wI7.j = true;
        this.K0.setDelegate(new PasscodeView.n() { // from class: ir.nasim.qX4
            @Override // ir.nasim.designsystem.PasscodeView.n
            public final void a() {
                this.a.x2();
            }
        });
    }

    public boolean o2() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (p2()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Runnable runnable = this.L0;
        if (runnable != null) {
            AbstractC7426Rr.w(runnable);
            this.L0 = null;
        }
        if (this.N0) {
            C5721Ko.c = true;
            A2();
            PasscodeView passcodeView = this.K0;
            if (passcodeView != null) {
                passcodeView.n();
            }
        }
        if (this.N0) {
            return;
        }
        this.N0 = true;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C5721Ko.c = false;
        if (C23073wI7.n) {
            B2();
        }
    }

    public boolean p2() {
        PasscodeView passcodeView = this.K0;
        if (passcodeView == null || passcodeView.getVisibility() != 0) {
            return false;
        }
        try {
            finishAffinity();
            return true;
        } catch (Exception e) {
            C19406qI3.d("PasscodeRequiredActivity", e);
            return true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        FrameLayout frameLayout = new FrameLayout(new C16731lm1(this, AbstractC23035wE5.Theme_Bale_Base));
        this.M0 = frameLayout;
        super.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.M0.addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(i, (ViewGroup) null), 0, C14433hu3.b(-1, -1.0f, 48, 0.0f, 0.0f, 0.0f, 0.0f));
        if (o2() && C23073wI7.d()) {
            q2();
            E2();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        C2(!v2(intent));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
        C2(!v2(intent));
    }
}
