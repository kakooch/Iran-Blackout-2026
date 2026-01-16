package ir.nasim.auth;

import android.os.Bundle;
import ir.nasim.C6011Lu2;
import ir.nasim.C6819Pc5;
import ir.nasim.designsystem.base.activity.BaseFragmentActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lir/nasim/auth/PickCountryActivity;", "Lir/nasim/designsystem/base/activity/BaseFragmentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "", "W1", "()Z", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes2.dex */
public final class PickCountryActivity extends BaseFragmentActivity {
    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        C6011Lu2.m(this);
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            j2(new C6819Pc5());
        }
    }
}
