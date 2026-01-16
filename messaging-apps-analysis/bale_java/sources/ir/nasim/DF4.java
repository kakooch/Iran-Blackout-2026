package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class DF4 implements PW {
    private int a = -1;

    private void c(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
    }

    @Override // ir.nasim.PW
    public List a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    @Override // ir.nasim.PW
    public void b(Context context, ComponentName componentName, int i) {
        if (this.a == i) {
            return;
        }
        this.a = i;
        c(context, i);
    }
}
