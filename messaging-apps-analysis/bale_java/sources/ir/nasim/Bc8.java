package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class Bc8 implements PW {
    @Override // ir.nasim.PW
    public List a() {
        return new ArrayList(0);
    }

    @Override // ir.nasim.PW
    public void b(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        bundle.putString("app_badge_component_name", componentName.flattenToString());
        context.getContentResolver().call(Uri.parse("content://com.android.launcher3.cornermark.unreadbadge"), "setAppUnreadCount", (String) null, bundle);
    }
}
