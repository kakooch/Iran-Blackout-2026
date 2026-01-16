package ir.nasim;

import android.database.Cursor;
import android.os.Bundle;

/* renamed from: ir.nasim.d27, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11460d27 {
    public static final C11460d27 a = new C11460d27();

    private C11460d27() {
    }

    public static final void a(Cursor cursor, Bundle bundle) {
        AbstractC13042fc3.i(cursor, "cursor");
        AbstractC13042fc3.i(bundle, "extras");
        cursor.setExtras(bundle);
    }
}
