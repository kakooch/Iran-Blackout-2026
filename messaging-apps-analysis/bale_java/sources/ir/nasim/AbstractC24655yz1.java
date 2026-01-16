package ir.nasim;

import android.content.Context;
import java.io.File;

/* renamed from: ir.nasim.yz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24655yz1 {
    public static final File a(Context context, String str) {
        AbstractC13042fc3.i(context, "<this>");
        AbstractC13042fc3.i(str, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), AbstractC13042fc3.q("datastore/", str));
    }
}
