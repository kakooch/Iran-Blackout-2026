package ir.nasim;

import android.content.ContentResolver;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class TJ1 implements SJ1 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final ContentResolver a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public TJ1(ContentResolver contentResolver) {
        AbstractC13042fc3.i(contentResolver, "resolver");
        this.a = contentResolver;
    }

    private final void b(Map map, boolean z) throws IOException {
        Cursor cursorH;
        if (map == null || map.isEmpty() || (cursorH = h(map.keySet(), z)) == null) {
            return;
        }
        Cursor cursor = cursorH;
        try {
            Cursor cursor2 = cursor;
            int columnIndex = cursor2.getColumnIndex("contact_id");
            int columnIndex2 = cursor2.getColumnIndex("data1");
            while (cursor2.moveToNext()) {
                long j = cursor2.getLong(columnIndex);
                L75 l75 = (L75) map.get(Long.valueOf(j));
                if (l75 != null) {
                    Long lB = X75.b(X75.a, cursor2.getString(columnIndex2), null, 2, null);
                    if (lB != null) {
                        long jLongValue = lB.longValue();
                        if (!i(l75, jLongValue)) {
                            l75.q().add(new O75(j, jLongValue));
                        }
                    }
                }
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(cursor, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(cursor, th);
                throw th2;
            }
        }
    }

    private final Cursor c(String str, int i, int i2) {
        String strF = f(str);
        String[] strArrE = e(str);
        String strG = g(i, i2);
        return this.a.query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id", "display_name", "has_phone_number"}, strF, strArrE, strG);
    }

    private final String d(int i) {
        StringBuilder sb = new StringBuilder(" IN ");
        sb.append(Separators.LPAREN);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("?,");
        }
        sb.setLength(sb.length() - 1);
        sb.append(Separators.RPAREN);
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    private final String[] e(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{Separators.PERCENT + str + Separators.PERCENT};
    }

    private final String f(String str) {
        return str == null ? "has_phone_number = 1" : "display_name LIKE ? AND has_phone_number = 1";
    }

    private final String g(int i, int i2) {
        if (i2 == -1) {
            return "display_name";
        }
        return "display_name LIMIT " + i2 + " OFFSET " + i;
    }

    private final Cursor h(Set set, boolean z) {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] strArr = {"contact_id", "data1"};
        if (z) {
            return this.a.query(uri, strArr, null, null, null);
        }
        String str = "contact_id" + d(set.size());
        Set set2 = set;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set2, 10));
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        return this.a.query(uri, strArr, str, (String[]) arrayList.toArray(new String[0]), null);
    }

    private final boolean i(L75 l75, long j) {
        List listQ = l75.q();
        AbstractC13042fc3.h(listQ, "getPhones(...)");
        List list = listQ;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((O75) it.next()).q()));
        }
        return arrayList.contains(Long.valueOf(j));
    }

    private final XV4 j(Cursor cursor) {
        String string;
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("display_name");
        ArrayList arrayList = new ArrayList(cursor.getCount());
        HashMap map = new HashMap(cursor.getCount());
        while (cursor.moveToNext()) {
            long j = cursor.getLong(columnIndex);
            String string2 = cursor.getString(columnIndex2);
            if (string2 != null) {
                int length = string2.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = AbstractC13042fc3.k(string2.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                string = string2.subSequence(i, length + 1).toString();
            } else {
                string = null;
            }
            if (string != null && string.length() != 0) {
                L75 l75 = new L75(j, string, new ArrayList());
                arrayList.add(l75);
                map.put(Long.valueOf(j), l75);
            }
        }
        return new XV4(map, arrayList);
    }

    @Override // ir.nasim.SJ1
    public List a() throws IOException {
        Cursor cursorC = c(null, 0, -1);
        if (cursorC == null) {
            return AbstractC10360bX0.m();
        }
        XV4 xv4J = j(cursorC);
        HashMap map = (HashMap) xv4J.a();
        List list = (List) xv4J.b();
        b(map, true);
        return list;
    }
}
