package ir.nasim.features.settings;

import android.content.Intent;
import android.os.Bundle;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.R32;
import ir.nasim.ZN2;
import ir.nasim.designsystem.base.activity.BaseFragmentActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lir/nasim/features/settings/EditNameActivity;", "Lir/nasim/designsystem/base/activity/BaseFragmentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "K0", "Ljava/lang/String;", "titleString", "L0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class EditNameActivity extends BaseFragmentActivity {
    public static final int M0 = 8;

    /* renamed from: K0, reason: from kotlin metadata */
    private String titleString;

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int intExtra = getIntent().getIntExtra("edit_type", 0);
        int intExtra2 = getIntent().getIntExtra("edit_id", 0);
        ZN2 zn2 = (ZN2) getIntent().getSerializableExtra("extra_peer_id");
        if (intExtra == 0) {
            this.titleString = getResources().getString(AbstractC12217eE5.edit_name_title_you);
        } else if (intExtra == 1) {
            this.titleString = getResources().getString(AbstractC12217eE5.edit_name_title_contact);
        } else if (intExtra == 2) {
            this.titleString = AbstractC5969Lp4.a(getString(AbstractC12217eE5.edit_name_title_group), zn2);
        } else if (intExtra == 4) {
            this.titleString = getResources().getString(AbstractC12217eE5.edit_name_title_nick);
        } else if (intExtra == 5) {
            this.titleString = getResources().getString(AbstractC12217eE5.edit_name_title_bank_account);
        } else if (intExtra == 6) {
            this.titleString = AbstractC5969Lp4.a(getString(AbstractC12217eE5.edit_name_title_group_nick), zn2);
        } else if (intExtra == 8) {
            this.titleString = getResources().getString(AbstractC12217eE5.edit_name_title_card_number);
        }
        if (savedInstanceState == null) {
            R32 r32Ka = R32.ka(intExtra, intExtra2, this.titleString, zn2);
            AbstractC13042fc3.h(r32Ka, "editName(...)");
            j2(r32Ka);
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
    }
}
