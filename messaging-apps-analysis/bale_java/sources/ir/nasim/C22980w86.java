package ir.nasim;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.w86, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22980w86 extends AbstractC9119Yo3 {
    private SQLiteStatement g;
    private SQLiteStatement h;

    public C22980w86(C86 c86, String str, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7) {
        super(c86 == C86.b ? AbstractC13215fr.r() : AbstractC13215fr.q(), str, "CREATE TABLE IF NOT EXISTS NAME (\"ID\" INTEGER NOT NULL,\"BYTES\" BLOB NOT NULL,PRIMARY KEY(\"ID\"));".replace("NAME", str), interfaceC17311ml0, interfaceC15345jQ7);
    }

    private void i() {
        if (this.h == null) {
            this.h = this.a.compileStatement("DELETE FROM \"" + this.b + "\" WHERE \"ID\"=?");
        }
    }

    private void j() {
        if (this.g == null) {
            this.g = this.a.compileStatement("INSERT OR REPLACE INTO \"" + this.b + "\" (\"ID\",\"BYTES\") VALUES (?,?)");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.AbstractC9119Yo3
    public void a(List list) throws SQLException {
        super.a(list);
        j();
        this.a.beginTransactionNonExclusive();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) it.next();
                this.g.bindLong(1, ((InterfaceC8844Xo3) abstractC17902nl0).a());
                this.g.bindBlob(2, abstractC17902nl0.toByteArray());
                this.g.executeInsert();
            }
            this.a.setTransactionSuccessful();
            this.a.endTransaction();
        } catch (Throwable th) {
            this.a.endTransaction();
            throw th;
        }
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public List e() throws SQLException {
        InterfaceC15345jQ7 interfaceC15345jQ7;
        super.e();
        Cursor cursorQuery = this.a.query(Separators.DOUBLE_QUOTE + this.b + Separators.DOUBLE_QUOTE, new String[]{"\"BYTES\"", "\"ID\""}, "", null, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            try {
                long j = cursorQuery.getLong(1);
                byte[] blob = cursorQuery.getBlob(0);
                AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) this.e.a();
                if (blob != null) {
                    try {
                        abstractC17902nl0.parse(new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(blob))));
                    } catch (Exception unused) {
                    }
                }
                if (abstractC17902nl0 == null && (interfaceC15345jQ7 = this.f) != null) {
                    abstractC17902nl0 = (AbstractC17902nl0) interfaceC15345jQ7.a(j);
                }
                if (abstractC17902nl0 != null) {
                    arrayList.add(abstractC17902nl0);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public AbstractC17902nl0 f(long j) throws SQLException {
        super.f(j);
        Cursor cursorQuery = this.a.query(Separators.DOUBLE_QUOTE + this.b + Separators.DOUBLE_QUOTE, new String[]{"\"BYTES\""}, "\"ID\" = ?", new String[]{"" + j}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                InterfaceC15345jQ7 interfaceC15345jQ7 = this.f;
                if (interfaceC15345jQ7 != null) {
                    return (AbstractC17902nl0) interfaceC15345jQ7.a(j);
                }
                return null;
            }
            byte[] blob = cursorQuery.getBlob(0);
            if (blob != null) {
                AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) this.e.a();
                abstractC17902nl0.parse(new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(blob))));
                return abstractC17902nl0;
            }
            InterfaceC15345jQ7 interfaceC15345jQ72 = this.f;
            if (interfaceC15345jQ72 != null) {
                return (AbstractC17902nl0) interfaceC15345jQ72.a(j);
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public List g(long[] jArr) throws SQLException {
        super.g(jArr);
        if (jArr == null || jArr.length == 0) {
            return new ArrayList();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jArr.length - 1; i++) {
            sb.append(jArr[i]);
            sb.append(",");
        }
        sb.append(jArr[jArr.length - 1]);
        Cursor cursorRawQuery = this.a.rawQuery("select BYTES, ID from " + this.b + " where ID in (" + ((Object) sb) + Separators.RPAREN, null);
        if (cursorRawQuery == null) {
            return null;
        }
        HashMap map = new HashMap();
        while (cursorRawQuery.moveToNext()) {
            try {
                long j = cursorRawQuery.getLong(1);
                byte[] blob = cursorRawQuery.getBlob(0);
                if (blob != null) {
                    try {
                        AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) this.e.a();
                        abstractC17902nl0.parse(new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(blob))));
                        map.put(Long.valueOf(j), abstractC17902nl0);
                    } catch (Exception unused) {
                    }
                }
            } finally {
                cursorRawQuery.close();
            }
        }
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            AbstractC17902nl0 abstractC17902nl02 = (AbstractC17902nl0) map.get(Long.valueOf(j2));
            if (abstractC17902nl02 != null) {
                arrayList.add(abstractC17902nl02);
            } else {
                InterfaceC15345jQ7 interfaceC15345jQ7 = this.f;
                if (interfaceC15345jQ7 != null) {
                    arrayList.add((AbstractC17902nl0) interfaceC15345jQ7.a(j2));
                }
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public void h(long j) throws SQLException {
        super.h(j);
        i();
        this.a.beginTransactionNonExclusive();
        try {
            this.h.bindLong(1, j);
            this.h.execute();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
