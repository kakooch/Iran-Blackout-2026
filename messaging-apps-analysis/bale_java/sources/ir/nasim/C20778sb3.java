package ir.nasim;

import android.content.Intent;
import android.net.Uri;

/* renamed from: ir.nasim.sb3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20778sb3 {
    public static final C20778sb3 a = new C20778sb3();

    private C20778sb3() {
    }

    public final Intent a(String str, String str2) {
        AbstractC13042fc3.i(str, "phoneNumber");
        AbstractC13042fc3.i(str2, "msg");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("smsto:" + str));
        intent.putExtra("address", str);
        intent.putExtra("sms_body", str2);
        intent.putExtra("exit_on_sent", true);
        return intent;
    }
}
