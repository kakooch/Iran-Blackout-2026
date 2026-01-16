package ir.nasim;

import android.content.Context;
import android.content.Intent;
import com.airbnb.android.showkase.ui.ShowkaseBrowserActivity;

/* renamed from: ir.nasim.i10, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14497i10 {
    public static final Intent a(C14009hB6 c14009hB6, Context context) {
        AbstractC13042fc3.i(c14009hB6, "<this>");
        AbstractC13042fc3.i(context, "context");
        Intent intent = new Intent(context, (Class<?>) ShowkaseBrowserActivity.class);
        intent.putExtra("SHOWKASE_ROOT_MODULE", "ir.nasim.app.showkase.BaleShowkaseRootModule");
        return intent;
    }
}
