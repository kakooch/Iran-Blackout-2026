package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

/* loaded from: classes2.dex */
public final class OW5 implements InterfaceC14734iO3 {
    private final boolean b(int i, Context context) {
        try {
            return context.getResources().getResourceEntryName(i) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    @Override // ir.nasim.InterfaceC14734iO3
    public /* bridge */ /* synthetic */ Object a(Object obj, IL4 il4) {
        return c(((Number) obj).intValue(), il4);
    }

    public Uri c(int i, IL4 il4) {
        if (!b(i, il4.g())) {
            return null;
        }
        return Uri.parse("android.resource://" + il4.g().getPackageName() + '/' + i);
    }
}
