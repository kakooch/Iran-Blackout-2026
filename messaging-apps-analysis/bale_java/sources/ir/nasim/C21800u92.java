package ir.nasim;

import android.database.sqlite.SQLiteConstraintException;

/* renamed from: ir.nasim.u92, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21800u92 {
    private final AbstractC21126t92 a;
    private final AbstractC19914r92 b;

    public C21800u92(AbstractC21126t92 abstractC21126t92, AbstractC19914r92 abstractC19914r92) {
        AbstractC13042fc3.i(abstractC21126t92, "insertionAdapter");
        AbstractC13042fc3.i(abstractC19914r92, "updateAdapter");
        this.a = abstractC21126t92;
        this.b = abstractC19914r92;
    }

    private final void a(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        }
        if (!AbstractC20762sZ6.V(message, "unique", true) && !AbstractC20762sZ6.X(message, "2067", false, 2, null) && !AbstractC20762sZ6.X(message, "1555", false, 2, null)) {
            throw sQLiteConstraintException;
        }
    }

    public final void b(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "entities");
        for (Object obj : iterable) {
            try {
                this.a.k(obj);
            } catch (SQLiteConstraintException e) {
                a(e);
                this.b.j(obj);
            }
        }
    }

    public final void c(Object obj) {
        try {
            this.a.k(obj);
        } catch (SQLiteConstraintException e) {
            a(e);
            this.b.j(obj);
        }
    }
}
