package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class Zc8 implements PW {
    private final Uri a = Uri.parse("content://com.android.badge/badge");

    @Override // ir.nasim.PW
    public List a() {
        return Collections.singletonList("com.zui.launcher");
    }

    @Override // ir.nasim.PW
    public void b(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(this.a, "setAppBadgeCount", (String) null, bundle);
    }
}
