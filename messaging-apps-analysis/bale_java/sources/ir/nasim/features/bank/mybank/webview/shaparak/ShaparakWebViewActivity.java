package ir.nasim.features.bank.mybank.webview.shaparak;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C5495Jo7;
import ir.nasim.ED1;
import ir.nasim.designsystem.base.activity.BaseActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lir/nasim/features/bank/mybank/webview/shaparak/ShaparakWebViewActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "<init>", "()V", "", "W1", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "L0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ShaparakWebViewActivity extends Hilt_ShaparakWebViewActivity {

    /* renamed from: L0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ir.nasim.features.bank.mybank.webview.shaparak.ShaparakWebViewActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Intent a(Context context, String str, String str2) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "cardNumber");
            AbstractC13042fc3.i(str2, "url");
            Intent intent = new Intent(context, (Class<?>) ShaparakWebViewActivity.class);
            intent.putExtra("card_number", str);
            intent.putExtra("url", str2);
            return intent;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        AbstractC7426Rr.a.Q(this, C5495Jo7.a.e2());
        setContentView(AbstractC12208eD5.activity_shaparak_web_view);
        Bundle extras = getIntent().getExtras();
        String str = "";
        if (extras == null || (string = extras.getString("card_number", "")) == null) {
            string = "";
        }
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null && (string2 = extras2.getString("url", "")) != null) {
            str = string2;
        }
        BaseActivity.d2(this, BC5.webView_container, a.INSTANCE.a(string, str), null, 4, null);
    }
}
