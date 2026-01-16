package io.appmetrica.analytics.coreutils.internal.io;

import android.database.Cursor;
import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljava/io/Closeable;", "Lir/nasim/rB7;", "closeSafely", "(Ljava/io/Closeable;)V", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "core-utils_release"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class CloseableUtilsKt {
    public static final void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static final void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }
}
