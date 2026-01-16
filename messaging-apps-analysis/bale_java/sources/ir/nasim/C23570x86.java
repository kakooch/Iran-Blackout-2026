package ir.nasim;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.gov.nist.core.Separators;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.x86, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23570x86 implements YB3 {
    private static final List f;
    private static final String g;
    private SQLiteStatement a;
    private SQLiteStatement b;
    private SQLiteDatabase c;
    private final String d;
    private boolean e = false;

    static {
        ArrayList arrayList = new ArrayList(Arrays.asList(new Pair("آ", "ا"), new Pair("\u200c", Separators.SP), new Pair("ً", ""), new Pair("ٌ", ""), new Pair("ٍ", ""), new Pair("َ", ""), new Pair("ُ", ""), new Pair("ِ", ""), new Pair("ّ", ""), new Pair("ْ", ""), new Pair("ٰ", ""), new Pair("ٓ", ""), new Pair("ٔ", ""), new Pair("ٕ", "")));
        f = arrayList;
        g = y(arrayList, "\"QUERY\"");
    }

    public C23570x86(SQLiteDatabase sQLiteDatabase, String str) {
        this.c = sQLiteDatabase;
        this.d = str;
    }

    private void s() {
        if (this.b == null) {
            this.b = this.c.compileStatement("DELETE FROM \"" + this.d + "\" WHERE \"ID\"=?");
        }
    }

    private void t() {
        if (this.a == null) {
            this.a = this.c.compileStatement("REPLACE INTO \"" + this.d + "\" (\"ID\",\"QUERY\",\"SORT_KEY\",\"BYTES\") VALUES (?,?,?,?)");
        }
    }

    private void u() throws SQLException {
        if (this.e) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseQ = AbstractC13215fr.q();
        this.c = sQLiteDatabaseQ;
        if (!AbstractC22384v86.a(sQLiteDatabaseQ, this.d)) {
            this.c.execSQL("CREATE TABLE IF NOT EXISTS \"" + this.d + "\" (\"ID\" INTEGER NOT NULL,\"SORT_KEY\" INTEGER NOT NULL,\"QUERY\" TEXT,\"BYTES\" BLOB NOT NULL,PRIMARY KEY(\"ID\"));");
            this.c.execSQL("CREATE INDEX IF NOT EXISTS IDX_ID_QUERY_SORT ON \"" + this.d + "\" (\"QUERY\", \"SORT_KEY\");");
            this.c.execSQL("CREATE INDEX IF NOT EXISTS IDX_ID_SORT ON \"" + this.d + "\" (\"SORT_KEY\");");
        }
        this.e = true;
    }

    private static String v(EnumC24659yz5 enumC24659yz5, boolean z) {
        return z ? enumC24659yz5 == EnumC24659yz5.a ? "<=?" : ">=?" : enumC24659yz5 == EnumC24659yz5.a ? "<?" : ">?";
    }

    private ArrayList w(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("ID");
            int columnIndex2 = cursor.getColumnIndex("SORT_KEY");
            int columnIndex3 = cursor.getColumnIndex("BYTES");
            int columnIndex4 = cursor.getColumnIndex("QUERY");
            try {
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(new IB3(cursor.getLong(columnIndex), cursor.getLong(columnIndex2), cursor.getString(columnIndex4), cursor.getBlob(columnIndex3)));
                    } while (cursor.moveToNext());
                }
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    private String x(String str) {
        int i = 0;
        while (true) {
            List list = f;
            if (i >= list.size()) {
                return str;
            }
            Pair pair = (Pair) list.get(i);
            str = str.replace((String) pair.first, (String) pair.second);
            i++;
        }
    }

    private static String y(List list, String str) {
        for (int i = 0; i < list.size(); i++) {
            Pair pair = (Pair) list.get(i);
            str = "REPLACE(" + str + ",'" + ((String) pair.first) + "','" + ((String) pair.second) + "')";
        }
        return str;
    }

    @Override // ir.nasim.YB3
    public List a(Long l, int i, boolean z) throws SQLException {
        Cursor cursorQuery;
        u();
        if (l == null) {
            cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"LIST_ID\"", "\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, null, null, null, null, "\"SORT_KEY\" ASC", String.valueOf(i));
        } else {
            String str = z ? "\"SORT_KEY\" >= ?" : "\"SORT_KEY\" > ?";
            cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, str, new String[]{String.valueOf(l)}, null, null, "\"SORT_KEY\" ASC", String.valueOf(i));
        }
        return w(cursorQuery);
    }

    @Override // ir.nasim.XB3
    public void b(long j) throws SQLException {
        u();
        s();
        this.b.bindLong(1, j);
        this.b.execute();
    }

    @Override // ir.nasim.XB3
    public IB3 c(long j) throws SQLException {
        u();
        Cursor cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, "\"ID\"=?", new String[]{String.valueOf(j)}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                return new IB3(j, cursorQuery.getLong(cursorQuery.getColumnIndex("SORT_KEY")), cursorQuery.getString(cursorQuery.getColumnIndex("QUERY")), cursorQuery.getBlob(cursorQuery.getColumnIndex("BYTES")));
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // ir.nasim.XB3
    public void clear() throws SQLException {
        u();
        this.c.execSQL("DELETE FROM \"" + this.d + Separators.DOUBLE_QUOTE);
    }

    @Override // ir.nasim.YB3
    public List d(Long l, int i) throws SQLException {
        Cursor cursorQuery;
        u();
        if (l == null) {
            cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"LIST_ID\"", "\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, null, null, null, null, "\"SORT_KEY\" DESC", String.valueOf(i));
        } else {
            cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, "\"SORT_KEY\" < ?", new String[]{String.valueOf(l)}, null, null, "\"SORT_KEY\" DESC", String.valueOf(i));
        }
        return w(cursorQuery);
    }

    @Override // ir.nasim.XB3
    public void e(long[] jArr) throws SQLException {
        u();
        s();
        this.c.beginTransactionNonExclusive();
        try {
            for (long j : jArr) {
                this.b.bindLong(1, j);
                this.b.execute();
            }
            this.c.setTransactionSuccessful();
            this.c.endTransaction();
        } catch (Throwable th) {
            this.c.endTransaction();
            throw th;
        }
    }

    @Override // ir.nasim.XB3
    public void f(List list) throws SQLException {
        u();
        t();
        this.c.beginTransactionNonExclusive();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                IB3 ib3 = (IB3) it.next();
                this.a.bindLong(1, ib3.b());
                this.a.bindString(2, ib3.d() != null ? ib3.d().toLowerCase() : null);
                this.a.bindLong(3, ib3.c());
                this.a.bindBlob(4, ib3.a());
                this.a.executeInsert();
            }
            this.c.setTransactionSuccessful();
            this.c.endTransaction();
        } catch (Throwable th) {
            this.c.endTransaction();
            throw th;
        }
    }

    @Override // ir.nasim.YB3
    public List g(String str, int i, int i2) throws SQLException {
        String str2;
        String[] strArr;
        u();
        if (str == null) {
            str2 = "";
        } else {
            str2 = "WHERE " + g + " LIKE ? ";
        }
        if (str == null) {
            strArr = null;
        } else {
            strArr = new String[]{Separators.PERCENT + x(str) + Separators.PERCENT};
        }
        return w(this.c.rawQuery("SELECT \"ID\", \"QUERY\", \"BYTES\", \"LIST_ID\", \"SORT_KEY\" FROM \"" + this.d + "\" " + str2 + "ORDER BY \"SORT_KEY\" DESC LIMIT " + i2 + " OFFSET " + i, strArr));
    }

    @Override // ir.nasim.XB3
    public int getCount() throws SQLException {
        u();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.c.rawQuery("SELECT COUNT(*) FROM \"" + this.d + Separators.DOUBLE_QUOTE, null);
            if (!cursorRawQuery.moveToFirst()) {
                cursorRawQuery.close();
                return 0;
            }
            int i = cursorRawQuery.getInt(0);
            cursorRawQuery.close();
            return i;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // ir.nasim.YB3
    public List h(Long l, int i) throws SQLException {
        u();
        if (l != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a(l, i, true));
            arrayList.addAll(d(l, i));
            return arrayList;
        }
        return w(this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"LIST_ID\"", "\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, null, null, null, null, "\"SORT_KEY\" DESC", String.valueOf(i)));
    }

    @Override // ir.nasim.XB3
    public void i(long j, EnumC24659yz5 enumC24659yz5) throws SQLException {
        u();
        this.c.beginTransactionNonExclusive();
        try {
            Object[] objArr = {Long.valueOf(j)};
            this.c.execSQL("DELETE FROM \"" + this.d + "\" WHERE \"SORT_KEY\"" + v(enumC24659yz5, false), objArr);
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // ir.nasim.XB3
    public void j(IB3 ib3) throws SQLException {
        u();
        t();
        this.a.bindLong(1, ib3.b());
        this.a.bindString(2, ib3.d() != null ? ib3.d().toLowerCase() : null);
        this.a.bindLong(3, ib3.c());
        this.a.bindBlob(4, ib3.a());
        this.a.executeInsert();
    }

    @Override // ir.nasim.XB3
    public IB3 k(Long l, Long l2) throws SQLException {
        u();
        Cursor cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, "\"SORT_KEY\" = ? AND \"ID\" = ?", new String[]{String.valueOf(l), String.valueOf(l2)}, null, null, "\"SORT_KEY\" DESC", String.valueOf(1));
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                return new IB3(cursorQuery.getColumnIndex("ID"), l.longValue(), cursorQuery.getString(cursorQuery.getColumnIndex("QUERY")), cursorQuery.getBlob(cursorQuery.getColumnIndex("BYTES")));
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // ir.nasim.XB3
    public int l(String str) throws SQLException {
        if (str == null) {
            return getCount();
        }
        u();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.c.rawQuery("SELECT COUNT(*) FROM \"" + this.d + "\" WHERE " + g + " LIKE ?", new String[]{Separators.PERCENT + x(str) + Separators.PERCENT});
            if (!cursorRawQuery.moveToFirst()) {
                cursorRawQuery.close();
                return 0;
            }
            int i = cursorRawQuery.getInt(0);
            cursorRawQuery.close();
            return i;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // ir.nasim.XB3
    public IB3 m(Long l, Boolean bool) throws SQLException {
        u();
        Cursor cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, bool.booleanValue() ? "\"SORT_KEY\" <= ?" : "\"SORT_KEY\" = ?", new String[]{String.valueOf(l)}, null, null, "\"SORT_KEY\" DESC", String.valueOf(1));
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                return new IB3(cursorQuery.getColumnIndex("ID"), l.longValue(), cursorQuery.getString(cursorQuery.getColumnIndex("QUERY")), cursorQuery.getBlob(cursorQuery.getColumnIndex("BYTES")));
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // ir.nasim.YB3
    public List n(String str, Long l, int i) throws SQLException {
        Cursor cursorQuery;
        u();
        String strX = x(str);
        if (l == null) {
            SQLiteDatabase sQLiteDatabase = this.c;
            StringBuilder sb = new StringBuilder();
            String str2 = g;
            sb.append(str2);
            sb.append(" LIKE ? OR ");
            sb.append(str2);
            sb.append(" LIKE ?");
            cursorQuery = sQLiteDatabase.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"LIST_ID\"", "\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, sb.toString(), new String[]{strX + Separators.PERCENT, Separators.PERCENT + strX + Separators.PERCENT}, null, null, "SORT_KEY DESC", String.valueOf(i));
        } else {
            SQLiteDatabase sQLiteDatabase2 = this.c;
            StringBuilder sb2 = new StringBuilder();
            String str3 = g;
            sb2.append(str3);
            sb2.append(" LIKE ? OR ");
            sb2.append(str3);
            sb2.append(" LIKE ?) AND \"SORT_KEY\" < ?");
            cursorQuery = sQLiteDatabase2.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, sb2.toString(), new String[]{strX + Separators.PERCENT, Separators.PERCENT + strX + Separators.PERCENT, String.valueOf(l)}, null, null, "\"SORT_KEY\" DESC", String.valueOf(i));
        }
        return w(cursorQuery);
    }

    @Override // ir.nasim.XB3
    public List o() throws SQLException {
        u();
        return w(this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"LIST_ID\"", "\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, null, null, null, null, "\"SORT_KEY\" DESC", null));
    }

    @Override // ir.nasim.YB3
    public List p(String str, Long l, int i) throws SQLException {
        Cursor cursorQuery;
        u();
        if (l == null) {
            SQLiteDatabase sQLiteDatabase = this.c;
            StringBuilder sb = new StringBuilder();
            String str2 = g;
            sb.append(str2);
            sb.append(" LIKE ? OR ");
            sb.append(str2);
            sb.append(" LIKE ?");
            cursorQuery = sQLiteDatabase.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"LIST_ID\"", "\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, sb.toString(), new String[]{str + Separators.PERCENT, Separators.PERCENT + str + Separators.PERCENT}, null, null, "SORT_KEY ASC", String.valueOf(i));
        } else {
            SQLiteDatabase sQLiteDatabase2 = this.c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Separators.LPAREN);
            String str3 = g;
            sb2.append(str3);
            sb2.append(" LIKE ? OR ");
            sb2.append(str3);
            sb2.append(" LIKE ?) AND \"SORT_KEY\" > ?");
            cursorQuery = sQLiteDatabase2.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, sb2.toString(), new String[]{str + Separators.PERCENT, Separators.PERCENT + str + Separators.PERCENT, String.valueOf(l)}, null, null, "\"SORT_KEY\" ASC", String.valueOf(i));
        }
        return w(cursorQuery);
    }

    @Override // ir.nasim.XB3
    public List q(long j, EnumC24659yz5 enumC24659yz5) throws SQLException {
        u();
        ArrayList arrayList = new ArrayList();
        if (j <= 0) {
            return arrayList;
        }
        Cursor cursorQuery = this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\""}, "\"SORT_KEY\"" + v(enumC24659yz5, false), new String[]{String.valueOf(j)}, null, null, null, null);
        try {
            if (cursorQuery.moveToFirst()) {
                int columnIndex = cursorQuery.getColumnIndex("ID");
                do {
                    arrayList.add(Long.valueOf(cursorQuery.getLong(columnIndex)));
                } while (cursorQuery.moveToNext());
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // ir.nasim.XB3
    public List r(String str, long j, EnumC24659yz5 enumC24659yz5, int i, boolean z) throws SQLException {
        u();
        if (str == null) {
            str = "";
        }
        String strReplace = str.replace((char) 8204, ' ').replace((char) 1570, (char) 1575);
        return w(this.c.query(Separators.DOUBLE_QUOTE + this.d + Separators.DOUBLE_QUOTE, new String[]{"\"ID\"", "\"SORT_KEY\"", "\"QUERY\"", "\"BYTES\""}, "(REPLACE(REPLACE(\"QUERY\", '\u200c', ' '),'آ','ا') LIKE ?) AND \"SORT_KEY\"" + v(enumC24659yz5, z), new String[]{Separators.PERCENT + strReplace + Separators.PERCENT, String.valueOf(j)}, null, null, "\"SORT_KEY\" ASC", String.valueOf(i)));
    }
}
