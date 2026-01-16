package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.mL3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC17069mL3 {
    private final LinkedHashMap a;
    private final LinkedHashMap b;
    private int c;
    private int d;

    public AbstractC17069mL3(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.d = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
        this.b = new LinkedHashMap();
    }

    private int h(String str, Object obj) {
        int i = i(str, obj);
        if (i >= 0) {
            return i;
        }
        throw new IllegalStateException("Negative size: " + str + Separators.EQUALS + obj);
    }

    private void j(int i, String str) {
        ArrayList arrayList;
        synchronized (this) {
            try {
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext() && this.c > i && !this.a.isEmpty()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str2 = (String) entry.getKey();
                    if (str == null || !str.equals(str2)) {
                        Object value = entry.getValue();
                        this.c -= h(str2, value);
                        it.remove();
                        String[] strArrSplit = str2.split(Separators.AT);
                        if (strArrSplit.length > 1 && (arrayList = (ArrayList) this.b.get(strArrSplit[0])) != null) {
                            arrayList.remove(strArrSplit[1]);
                            if (arrayList.isEmpty()) {
                                this.b.remove(strArrSplit[0]);
                            }
                        }
                        b(true, str2, value, null);
                    }
                }
            } finally {
            }
        }
    }

    public boolean a(String str) {
        return this.a.containsKey(str);
    }

    public final void c() {
        j(-1, null);
    }

    public final Object d(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Object obj = this.a.get(str);
                if (obj != null) {
                    return obj;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(String str) {
        Object objRemove = this.a.remove(str);
        if (objRemove != null) {
            this.a.put(str, objRemove);
        }
    }

    public Object f(String str, Object obj) {
        Object objPut;
        if (str == null || obj == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.c += h(str, obj);
                objPut = this.a.put(str, obj);
                if (objPut != null) {
                    this.c -= h(str, objPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        String[] strArrSplit = str.split(Separators.AT);
        if (strArrSplit.length > 1) {
            ArrayList arrayList = (ArrayList) this.b.get(strArrSplit[0]);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.b.put(strArrSplit[0], arrayList);
            }
            if (!arrayList.contains(strArrSplit[1])) {
                arrayList.add(strArrSplit[1]);
            }
        }
        if (objPut != null) {
            b(false, str, objPut, obj);
        }
        j(this.d, str);
        return objPut;
    }

    public final Object g(String str) {
        Object objRemove;
        ArrayList arrayList;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                objRemove = this.a.remove(str);
                if (objRemove != null) {
                    this.c -= h(str, objRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objRemove != null) {
            String[] strArrSplit = str.split(Separators.AT);
            if (strArrSplit.length > 1 && (arrayList = (ArrayList) this.b.get(strArrSplit[0])) != null) {
                arrayList.remove(strArrSplit[1]);
                if (arrayList.isEmpty()) {
                    this.b.remove(strArrSplit[0]);
                }
            }
            b(false, str, objRemove, null);
        }
        return objRemove;
    }

    protected int i(String str, Object obj) {
        return 1;
    }

    protected void b(boolean z, String str, Object obj, Object obj2) {
    }
}
