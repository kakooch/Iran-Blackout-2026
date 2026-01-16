package ir.nasim;

import android.net.Uri;

/* renamed from: ir.nasim.bI7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10232bI7 implements InterfaceC23971xp3 {
    @Override // ir.nasim.InterfaceC23971xp3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(Uri uri, IL4 il4) {
        if (!AbstractC13042fc3.d(uri.getScheme(), "android.resource")) {
            return uri.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append('-');
        sb.append(AbstractC18638p.l(il4.g().getResources().getConfiguration()));
        return sb.toString();
    }
}
