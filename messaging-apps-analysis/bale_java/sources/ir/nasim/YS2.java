package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class YS2 {
    private final String[] a;

    private YS2(String[] strArr) {
        this.a = strArr;
    }

    public static YS2 b(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("Expected map with header names and values");
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("HTTPHeader cannot be null");
            }
            String strTrim = ((String) entry.getKey()).trim();
            for (String str : (List) entry.getValue()) {
                if (strTrim.length() == 0 || strTrim.indexOf(0) != -1 || str.indexOf(0) != -1) {
                    throw new IllegalArgumentException("Unexpected header: " + strTrim + ": " + str);
                }
                arrayList.add(strTrim);
                arrayList.add(str);
            }
        }
        return new YS2((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public String a(int i) {
        int i2 = i * 2;
        if (i2 < 0) {
            return null;
        }
        String[] strArr = this.a;
        if (i2 >= strArr.length) {
            return null;
        }
        return strArr[i2];
    }

    public int c() {
        return this.a.length / 2;
    }

    public String d(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0) {
            return null;
        }
        String[] strArr = this.a;
        if (i2 >= strArr.length) {
            return null;
        }
        return strArr[i2];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iC = c();
        for (int i = 0; i < iC; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(d(i));
            sb.append(Separators.RETURN);
        }
        return sb.toString();
    }
}
