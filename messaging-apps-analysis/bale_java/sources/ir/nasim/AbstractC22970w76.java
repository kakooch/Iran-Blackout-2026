package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.w76, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22970w76 {
    public static final void a(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        throw new IllegalArgumentException(str);
    }

    public static final void b(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        throw new IllegalStateException(str);
    }

    public static final void c(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        throw new IndexOutOfBoundsException(str);
    }

    public static final void d(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        throw new NoSuchElementException(str);
    }
}
