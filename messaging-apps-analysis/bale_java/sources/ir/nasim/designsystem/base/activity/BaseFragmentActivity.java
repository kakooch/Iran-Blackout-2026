package ir.nasim.designsystem.base.activity;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.BC5;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lir/nasim/designsystem/base/activity/BaseFragmentActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/fragment/app/Fragment;", "fragment", "k2", "(Landroidx/fragment/app/Fragment;)V", "j2", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public class BaseFragmentActivity extends BaseActivity {
    public void j2(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        B0().s().r(BC5.content_frame, fragment, null).h();
    }

    public void k2(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        B0().s().c(BC5.content_frame, fragment, null).g(null).h();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(AbstractC12208eD5.activity_base);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        AbstractC13042fc3.i(item, "item");
        if (item.getItemId() != 16908332) {
            return false;
        }
        super.onBackPressed();
        return true;
    }
}
