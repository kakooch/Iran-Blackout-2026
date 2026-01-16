package ir.nasim;

import android.content.Context;
import java.io.File;

/* renamed from: ir.nasim.c27, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10696c27 {
    public static final C10696c27 a = new C10696c27();

    private C10696c27() {
    }

    public static final File a(Context context) {
        AbstractC13042fc3.i(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        AbstractC13042fc3.h(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
