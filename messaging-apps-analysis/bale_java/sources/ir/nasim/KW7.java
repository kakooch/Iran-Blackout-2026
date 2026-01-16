package ir.nasim;

import android.database.Cursor;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class KW7 {
    public static final a c = new a(null);
    public final String a;
    public final String b;

    public static final class a {
        private a() {
        }

        public final KW7 a(InterfaceC12694f27 interfaceC12694f27, String str) throws IOException {
            KW7 kw7;
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            AbstractC13042fc3.i(str, "viewName");
            Cursor cursorR1 = interfaceC12694f27.r1("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
            try {
                Cursor cursor = cursorR1;
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    AbstractC13042fc3.h(string, "cursor.getString(0)");
                    kw7 = new KW7(string, cursor.getString(1));
                } else {
                    kw7 = new KW7(str, null);
                }
                YV0.a(cursorR1, null);
                return kw7;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    YV0.a(cursorR1, th);
                    throw th2;
                }
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public KW7(String str, String str2) {
        AbstractC13042fc3.i(str, "name");
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KW7)) {
            return false;
        }
        KW7 kw7 = (KW7) obj;
        if (AbstractC13042fc3.d(this.a, kw7.a)) {
            String str = this.b;
            String str2 = kw7.b;
            if (str != null ? AbstractC13042fc3.d(str, str2) : str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ViewInfo{name='" + this.a + "', sql='" + this.b + "'}";
    }
}
