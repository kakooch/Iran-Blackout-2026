package ir.nasim;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.cp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC11334cp8 {
    static HashMap f;
    private static Object k;
    private static boolean l;
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean e = new AtomicBoolean();
    static final HashMap g = new HashMap();
    static final HashMap h = new HashMap();
    static final HashMap i = new HashMap();
    static final HashMap j = new HashMap();
    static final String[] m = new String[0];

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (AbstractC11334cp8.class) {
            try {
                if (f == null) {
                    e.set(false);
                    f = new HashMap();
                    k = new Object();
                    l = false;
                    contentResolver.registerContentObserver(a, true, new Io8(null));
                } else if (e.getAndSet(false)) {
                    f.clear();
                    g.clear();
                    h.clear();
                    i.clear();
                    j.clear();
                    k = new Object();
                    l = false;
                }
                Object obj = k;
                if (f.containsKey(str)) {
                    String str3 = (String) f.get(str);
                    if (str3 != null) {
                        str = str3;
                    }
                    return str;
                }
                int length = m.length;
                Cursor cursorQuery = contentResolver.query(a, null, null, new String[]{str}, null);
                if (cursorQuery == null) {
                    return null;
                }
                try {
                    if (!cursorQuery.moveToFirst()) {
                        c(obj, str, null);
                        return null;
                    }
                    String string = cursorQuery.getString(1);
                    if (string != null && string.equals(null)) {
                        string = null;
                    }
                    c(obj, str, string);
                    return string != null ? string : null;
                } finally {
                    cursorQuery.close();
                }
            } finally {
            }
        }
    }

    private static void c(Object obj, String str, String str2) {
        synchronized (AbstractC11334cp8.class) {
            try {
                if (obj == k) {
                    f.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
