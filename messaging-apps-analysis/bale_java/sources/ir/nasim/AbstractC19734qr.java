package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;

/* renamed from: ir.nasim.qr, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19734qr implements InterfaceC23591xA7 {
    private Uri b(String str) {
        String str2 = str.startsWith("tel:") ? "" : "tel:";
        for (char c : str.toCharArray()) {
            str2 = c == '#' ? str2 + Uri.encode(Separators.POUND) : str2 + c;
        }
        return Uri.parse(str2);
    }

    @Override // ir.nasim.InterfaceC23591xA7
    public Void a(String str) {
        if (str == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setFlags(268435456);
        intent.setData(b(str));
        try {
            C5721Ko.b.startActivity(intent);
        } catch (SecurityException e) {
            C19406qI3.d("AndroidUSSDProvider", e);
        }
        return null;
    }
}
