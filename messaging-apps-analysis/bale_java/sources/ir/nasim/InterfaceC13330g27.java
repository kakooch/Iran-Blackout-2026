package ir.nasim;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.g27, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC13330g27 extends Closeable {

    /* renamed from: ir.nasim.g27$a */
    public static abstract class a {
        public static final C1247a b = new C1247a(null);
        public final int a;

        /* renamed from: ir.nasim.g27$a$a, reason: collision with other inner class name */
        public static final class C1247a {
            private C1247a() {
            }

            public /* synthetic */ C1247a(ED1 ed1) {
                this();
            }
        }

        public a(int i) {
            this.a = i;
        }

        private final void a(String str) {
            if (AbstractC20153rZ6.D(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (str.subSequence(i, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                C9486a27.c(new File(str));
            } catch (Exception e) {
                Log.w("SupportSQLite", "delete failed: ", e);
            }
        }

        public void b(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
        }

        public void c(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + interfaceC12694f27 + ".path");
            if (!interfaceC12694f27.isOpen()) {
                String strA = interfaceC12694f27.A();
                if (strA != null) {
                    a(strA);
                    return;
                }
                return;
            }
            List listN = null;
            try {
                try {
                    listN = interfaceC12694f27.N();
                } catch (SQLiteException unused) {
                }
                try {
                    interfaceC12694f27.close();
                } catch (IOException unused2) {
                }
                if (listN != null) {
                    return;
                }
            } finally {
                if (listN != null) {
                    Iterator it = listN.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        AbstractC13042fc3.h(obj, "p.second");
                        a((String) obj);
                    }
                } else {
                    String strA2 = interfaceC12694f27.A();
                    if (strA2 != null) {
                        a(strA2);
                    }
                }
            }
        }

        public abstract void d(InterfaceC12694f27 interfaceC12694f27);

        public abstract void e(InterfaceC12694f27 interfaceC12694f27, int i, int i2);

        public void f(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
        }

        public abstract void g(InterfaceC12694f27 interfaceC12694f27, int i, int i2);
    }

    /* renamed from: ir.nasim.g27$b */
    public static final class b {
        public static final C1248b f = new C1248b(null);
        public final Context a;
        public final String b;
        public final a c;
        public final boolean d;
        public final boolean e;

        /* renamed from: ir.nasim.g27$b$a */
        public static class a {
            private final Context a;
            private String b;
            private a c;
            private boolean d;
            private boolean e;

            public a(Context context) {
                AbstractC13042fc3.i(context, "context");
                this.a = context;
            }

            public b a() {
                String str;
                a aVar = this.c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
                }
                if (this.d && ((str = this.b) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
                }
                return new b(this.a, this.b, aVar, this.d, this.e);
            }

            public a b(a aVar) {
                AbstractC13042fc3.i(aVar, "callback");
                this.c = aVar;
                return this;
            }

            public a c(String str) {
                this.b = str;
                return this;
            }

            public a d(boolean z) {
                this.d = z;
                return this;
            }
        }

        /* renamed from: ir.nasim.g27$b$b, reason: collision with other inner class name */
        public static final class C1248b {
            private C1248b() {
            }

            public final a a(Context context) {
                AbstractC13042fc3.i(context, "context");
                return new a(context);
            }

            public /* synthetic */ C1248b(ED1 ed1) {
                this();
            }
        }

        public b(Context context, String str, a aVar, boolean z, boolean z2) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(aVar, "callback");
            this.a = context;
            this.b = str;
            this.c = aVar;
            this.d = z;
            this.e = z2;
        }

        public static final a a(Context context) {
            return f.a(context);
        }
    }

    /* renamed from: ir.nasim.g27$c */
    public interface c {
        InterfaceC13330g27 a(b bVar);
    }

    InterfaceC12694f27 E();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z);
}
