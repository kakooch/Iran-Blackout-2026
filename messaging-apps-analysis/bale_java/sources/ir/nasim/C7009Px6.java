package ir.nasim;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

/* renamed from: ir.nasim.Px6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7009Px6 {
    public static /* synthetic */ void b(C7009Px6 c7009Px6, Activity activity, String str, String str2, String str3, CharSequence charSequence, Integer num, int i, Object obj) {
        if ((i & 32) != 0) {
            num = null;
        }
        c7009Px6.a(activity, str, str2, str3, charSequence, num);
    }

    public final void a(Activity activity, String str, String str2, String str3, CharSequence charSequence, Integer num) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(str, "path");
        AbstractC13042fc3.i(str2, "mimeType");
        AbstractC13042fc3.i(str3, "chooserTitle");
        Uri uriH = FileProvider.h(activity, activity.getPackageName() + ".provider", new File(str));
        Intent intent = new Intent("android.intent.action.SEND");
        if (AbstractC20762sZ6.n0(str2)) {
            str2 = "*/*";
        }
        intent.setType(str2);
        intent.addFlags(1);
        intent.putExtra("android.intent.extra.STREAM", uriH);
        intent.putExtra("android.intent.extra.TEXT", charSequence);
        Intent intentCreateChooser = Intent.createChooser(intent, str3);
        if (num != null) {
            activity.startActivityForResult(intentCreateChooser, num.intValue());
        } else {
            activity.startActivity(intentCreateChooser);
        }
    }
}
