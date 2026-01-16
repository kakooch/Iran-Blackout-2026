package ir.nasim;

import android.content.Context;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Mn1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6181Mn1 {
    private final Context a;

    public C6181Mn1(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    public final boolean a(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        return KV0.a(this.a, C64.c(this.a, new J44[]{j44}, false, 4, null));
    }
}
