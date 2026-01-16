package ir.nasim;

import android.database.Cursor;
import android.os.CancellationSignal;
import ir.nasim.YT4;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public abstract class L26 {
    private static final YT4.b.C0792b a = new YT4.b.C0792b();

    public static final Integer a(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "<this>");
        Integer numC = zt4.c();
        if (numC != null) {
            return Integer.valueOf(Math.max(0, numC.intValue() - (zt4.d().d / 2)));
        }
        return null;
    }

    public static final YT4.b.C0792b b() {
        return a;
    }

    public static final int c(YT4.a aVar, int i) {
        AbstractC13042fc3.i(aVar, "params");
        return aVar instanceof YT4.a.c ? i < aVar.b() ? i : aVar.b() : aVar.b();
    }

    public static final int d(YT4.a aVar, int i, int i2) {
        AbstractC13042fc3.i(aVar, "params");
        if (aVar instanceof YT4.a.c) {
            if (i < aVar.b()) {
                return 0;
            }
            return i - aVar.b();
        }
        if (aVar instanceof YT4.a.C0790a) {
            return i;
        }
        if (aVar instanceof YT4.a.d) {
            return i >= i2 ? Math.max(0, i2 - aVar.b()) : i;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final YT4.b e(YT4.a aVar, O26 o26, D26 d26, int i, CancellationSignal cancellationSignal, UA2 ua2) {
        AbstractC13042fc3.i(aVar, "params");
        AbstractC13042fc3.i(o26, "sourceQuery");
        AbstractC13042fc3.i(d26, "db");
        AbstractC13042fc3.i(ua2, "convertRows");
        Integer num = (Integer) aVar.a();
        int iIntValue = num != null ? num.intValue() : 0;
        int iC = c(aVar, iIntValue);
        int iD = d(aVar, iIntValue, i);
        O26 o26A = O26.i.a("SELECT * FROM ( " + o26.a() + " ) LIMIT " + iC + " OFFSET " + iD, o26.e());
        o26A.d(o26);
        Cursor cursorD = d26.D(o26A, cancellationSignal);
        try {
            List list = (List) ua2.invoke(cursorD);
            cursorD.close();
            o26A.j();
            int size = list.size() + iD;
            Integer numValueOf = null;
            Integer numValueOf2 = (list.isEmpty() || list.size() < iC || size >= i) ? null : Integer.valueOf(size);
            if (iD > 0 && !list.isEmpty()) {
                numValueOf = Integer.valueOf(iD);
            }
            return new YT4.b.c(list, numValueOf, numValueOf2, iD, Math.max(0, i - size));
        } catch (Throwable th) {
            cursorD.close();
            o26A.j();
            throw th;
        }
    }

    public static /* synthetic */ YT4.b f(YT4.a aVar, O26 o26, D26 d26, int i, CancellationSignal cancellationSignal, UA2 ua2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            cancellationSignal = null;
        }
        return e(aVar, o26, d26, i, cancellationSignal, ua2);
    }

    public static final int g(O26 o26, D26 d26) {
        AbstractC13042fc3.i(o26, "sourceQuery");
        AbstractC13042fc3.i(d26, "db");
        O26 o26A = O26.i.a("SELECT COUNT(*) FROM ( " + o26.a() + " )", o26.e());
        o26A.d(o26);
        Cursor cursorE = D26.E(d26, o26A, null, 2, null);
        try {
            if (cursorE.moveToFirst()) {
                return cursorE.getInt(0);
            }
            return 0;
        } finally {
            cursorE.close();
            o26A.j();
        }
    }
}
