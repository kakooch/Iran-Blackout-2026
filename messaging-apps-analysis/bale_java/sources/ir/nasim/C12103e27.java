package ir.nasim;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;

/* renamed from: ir.nasim.e27, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12103e27 {
    public static final C12103e27 a = new C12103e27();

    private C12103e27() {
    }

    public static final List a(Cursor cursor) {
        AbstractC13042fc3.i(cursor, "cursor");
        List<Uri> notificationUris = cursor.getNotificationUris();
        AbstractC13042fc3.f(notificationUris);
        return notificationUris;
    }

    public static final void b(Cursor cursor, ContentResolver contentResolver, List list) {
        AbstractC13042fc3.i(cursor, "cursor");
        AbstractC13042fc3.i(contentResolver, "cr");
        AbstractC13042fc3.i(list, "uris");
        cursor.setNotificationUris(contentResolver, list);
    }
}
