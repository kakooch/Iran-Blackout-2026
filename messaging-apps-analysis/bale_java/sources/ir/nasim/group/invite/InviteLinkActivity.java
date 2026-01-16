package ir.nasim.group.invite;

import android.os.Bundle;
import ir.nasim.C6011Lu2;
import ir.nasim.C9020Yd3;
import ir.nasim.ZN2;
import ir.nasim.designsystem.base.activity.BaseFragmentActivity;

/* loaded from: classes6.dex */
public class InviteLinkActivity extends BaseFragmentActivity {
    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C6011Lu2.m(this);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("group_id", 0);
        ZN2 zn2ValueOf = ZN2.valueOf(getIntent().getStringExtra("group_type"));
        boolean booleanExtra = getIntent().getBooleanExtra("is_group_admin", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("is_group_owner", false);
        if (bundle == null) {
            j2(C9020Yd3.Z9(intExtra, zn2ValueOf, booleanExtra, booleanExtra2));
        }
    }
}
