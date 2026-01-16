package ir.nasim;

import android.database.Cursor;
import ir.nasim.InterfaceC13330g27;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class J26 extends InterfaceC13330g27.a {
    public static final a g = new a(null);
    private C5822Kz1 c;
    private final b d;
    private final String e;
    private final String f;

    public static final class a {
        private a() {
        }

        public final boolean a(InterfaceC12694f27 interfaceC12694f27) throws IOException {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            Cursor cursorR1 = interfaceC12694f27.r1("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                Cursor cursor = cursorR1;
                boolean z = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) == 0) {
                        z = true;
                    }
                }
                YV0.a(cursorR1, null);
                return z;
            } finally {
            }
        }

        public final boolean b(InterfaceC12694f27 interfaceC12694f27) throws IOException {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            Cursor cursorR1 = interfaceC12694f27.r1("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                Cursor cursor = cursorR1;
                boolean z = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) != 0) {
                        z = true;
                    }
                }
                YV0.a(cursorR1, null);
                return z;
            } finally {
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static abstract class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }

        public abstract void a(InterfaceC12694f27 interfaceC12694f27);

        public abstract void b(InterfaceC12694f27 interfaceC12694f27);

        public abstract void c(InterfaceC12694f27 interfaceC12694f27);

        public abstract void d(InterfaceC12694f27 interfaceC12694f27);

        public abstract void e(InterfaceC12694f27 interfaceC12694f27);

        public abstract void f(InterfaceC12694f27 interfaceC12694f27);

        public abstract c g(InterfaceC12694f27 interfaceC12694f27);
    }

    public static class c {
        public final boolean a;
        public final String b;

        public c(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J26(C5822Kz1 c5822Kz1, b bVar, String str, String str2) {
        super(bVar.a);
        AbstractC13042fc3.i(c5822Kz1, "configuration");
        AbstractC13042fc3.i(bVar, "delegate");
        AbstractC13042fc3.i(str, "identityHash");
        AbstractC13042fc3.i(str2, "legacyHash");
        this.c = c5822Kz1;
        this.d = bVar;
        this.e = str;
        this.f = str2;
    }

    private final void h(InterfaceC12694f27 interfaceC12694f27) throws IOException {
        if (!g.b(interfaceC12694f27)) {
            c cVarG = this.d.g(interfaceC12694f27);
            if (cVarG.a) {
                this.d.e(interfaceC12694f27);
                j(interfaceC12694f27);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarG.b);
            }
        }
        Cursor cursorP1 = interfaceC12694f27.P1(new TC6("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            Cursor cursor = cursorP1;
            String string = cursor.moveToFirst() ? cursor.getString(0) : null;
            YV0.a(cursorP1, null);
            if (AbstractC13042fc3.d(this.e, string) || AbstractC13042fc3.d(this.f, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.e + ", found: " + string);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(cursorP1, th);
                throw th2;
            }
        }
    }

    private final void i(InterfaceC12694f27 interfaceC12694f27) {
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void j(InterfaceC12694f27 interfaceC12694f27) {
        i(interfaceC12694f27);
        interfaceC12694f27.O(I26.a(this.e));
    }

    @Override // ir.nasim.InterfaceC13330g27.a
    public void b(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        super.b(interfaceC12694f27);
    }

    @Override // ir.nasim.InterfaceC13330g27.a
    public void d(InterfaceC12694f27 interfaceC12694f27) throws IOException {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        boolean zA = g.a(interfaceC12694f27);
        this.d.a(interfaceC12694f27);
        if (!zA) {
            c cVarG = this.d.g(interfaceC12694f27);
            if (!cVarG.a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarG.b);
            }
        }
        j(interfaceC12694f27);
        this.d.c(interfaceC12694f27);
    }

    @Override // ir.nasim.InterfaceC13330g27.a
    public void e(InterfaceC12694f27 interfaceC12694f27, int i, int i2) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        g(interfaceC12694f27, i, i2);
    }

    @Override // ir.nasim.InterfaceC13330g27.a
    public void f(InterfaceC12694f27 interfaceC12694f27) throws IOException {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        super.f(interfaceC12694f27);
        h(interfaceC12694f27);
        this.d.d(interfaceC12694f27);
        this.c = null;
    }

    @Override // ir.nasim.InterfaceC13330g27.a
    public void g(InterfaceC12694f27 interfaceC12694f27, int i, int i2) {
        List listD;
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        C5822Kz1 c5822Kz1 = this.c;
        if (c5822Kz1 == null || (listD = c5822Kz1.d.d(i, i2)) == null) {
            C5822Kz1 c5822Kz12 = this.c;
            if (c5822Kz12 != null && !c5822Kz12.a(i, i2)) {
                this.d.b(interfaceC12694f27);
                this.d.a(interfaceC12694f27);
                return;
            }
            throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        this.d.f(interfaceC12694f27);
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            ((AbstractC9264Ze4) it.next()).a(interfaceC12694f27);
        }
        c cVarG = this.d.g(interfaceC12694f27);
        if (cVarG.a) {
            this.d.e(interfaceC12694f27);
            j(interfaceC12694f27);
        } else {
            throw new IllegalStateException("Migration didn't properly handle: " + cVarG.b);
        }
    }
}
