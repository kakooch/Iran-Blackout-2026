package ir.nasim;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class Iv8 {
    private static HashMap f;
    private static Object k;
    private static boolean l;
    private static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean e = new AtomicBoolean();
    private static final HashMap g = new HashMap();
    private static final HashMap h = new HashMap();
    private static final HashMap i = new HashMap();
    private static final HashMap j = new HashMap();
    private static String[] m = new String[0];

    public static long a(ContentResolver contentResolver, String str, long j2) throws NumberFormatException {
        Object objI = i(contentResolver);
        long j3 = 0;
        Long lValueOf = (Long) b(i, str, 0L);
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        String strC = c(contentResolver, str, null);
        if (strC != null) {
            try {
                long j4 = Long.parseLong(strC);
                lValueOf = Long.valueOf(j4);
                j3 = j4;
            } catch (NumberFormatException unused) {
            }
        }
        g(objI, i, str, lValueOf);
        return j3;
    }

    private static Object b(HashMap map, String str, Object obj) {
        synchronized (Iv8.class) {
            try {
                if (!map.containsKey(str)) {
                    return null;
                }
                Object obj2 = map.get(str);
                if (obj2 != null) {
                    obj = obj2;
                }
                return obj;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String c(ContentResolver contentResolver, String str, String str2) {
        synchronized (Iv8.class) {
            try {
                e(contentResolver);
                Object obj = k;
                if (f.containsKey(str)) {
                    String str3 = (String) f.get(str);
                    return str3 != null ? str3 : null;
                }
                for (String str4 : m) {
                    if (str.startsWith(str4)) {
                        if (!l || f.isEmpty()) {
                            f.putAll(d(contentResolver, m));
                            l = true;
                            if (f.containsKey(str)) {
                                String str5 = (String) f.get(str);
                                return str5 != null ? str5 : null;
                            }
                        }
                        return null;
                    }
                }
                Cursor cursorQuery = contentResolver.query(a, null, null, new String[]{str}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            f(obj, str, string);
                            String str6 = string != null ? string : null;
                            cursorQuery.close();
                            return str6;
                        }
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                f(obj, str, null);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } finally {
            }
        }
    }

    private static Map d(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery == null) {
            return treeMap;
        }
        while (cursorQuery.moveToNext()) {
            try {
                treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            } finally {
                cursorQuery.close();
            }
        }
        return treeMap;
    }

    private static void e(ContentResolver contentResolver) {
        if (f == null) {
            e.set(false);
            f = new HashMap();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(a, true, new Ov8(null));
            return;
        }
        if (e.getAndSet(false)) {
            f.clear();
            g.clear();
            h.clear();
            i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    private static void f(Object obj, String str, String str2) {
        synchronized (Iv8.class) {
            try {
                if (obj == k) {
                    f.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void g(Object obj, HashMap map, String str, Object obj2) {
        synchronized (Iv8.class) {
            try {
                if (obj == k) {
                    map.put(str, obj2);
                    f.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean h(ContentResolver contentResolver, String str, boolean z) {
        Object objI = i(contentResolver);
        HashMap map = g;
        Boolean bool = (Boolean) b(map, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String strC = c(contentResolver, str, null);
        if (strC != null && !strC.equals("")) {
            if (c.matcher(strC).matches()) {
                bool = Boolean.TRUE;
                z = true;
            } else if (d.matcher(strC).matches()) {
                bool = Boolean.FALSE;
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + strC + "\") as boolean");
            }
        }
        g(objI, map, str, bool);
        return z;
    }

    private static Object i(ContentResolver contentResolver) {
        Object obj;
        synchronized (Iv8.class) {
            e(contentResolver);
            obj = k;
        }
        return obj;
    }
}
