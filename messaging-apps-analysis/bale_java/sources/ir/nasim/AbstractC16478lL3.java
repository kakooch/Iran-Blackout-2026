package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.BitmapDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.lL3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC16478lL3 {
    private final LinkedHashMap a;
    private final LinkedHashMap b;
    private int c;
    private int d;

    public AbstractC16478lL3(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.d = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
        this.b = new LinkedHashMap();
    }

    private int f(String str, BitmapDrawable bitmapDrawable) {
        int iG = g(bitmapDrawable);
        if (iG >= 0) {
            return iG;
        }
        throw new IllegalStateException("Negative size: " + str + Separators.EQUALS + bitmapDrawable);
    }

    private void h(int i, String str) {
        ArrayList arrayList;
        synchronized (this) {
            try {
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext() && this.c > i && !this.a.isEmpty()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str2 = (String) entry.getKey();
                    if (str == null || !str.equals(str2)) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
                        this.c -= f(str2, bitmapDrawable);
                        it.remove();
                        String[] strArrSplit = str2.split(Separators.AT);
                        if (strArrSplit.length > 1 && (arrayList = (ArrayList) this.b.get(strArrSplit[0])) != null) {
                            arrayList.remove(strArrSplit[1]);
                            if (arrayList.isEmpty()) {
                                this.b.remove(strArrSplit[0]);
                            }
                        }
                        a(str2, bitmapDrawable);
                    }
                }
            } finally {
            }
        }
    }

    protected abstract void a(String str, BitmapDrawable bitmapDrawable);

    public final void b() {
        h(-1, null);
    }

    public final BitmapDrawable c(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) this.a.get(str);
                if (bitmapDrawable != null) {
                    return bitmapDrawable;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public BitmapDrawable d(String str, BitmapDrawable bitmapDrawable) {
        BitmapDrawable bitmapDrawable2;
        if (str == null || bitmapDrawable == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.c += f(str, bitmapDrawable);
                bitmapDrawable2 = (BitmapDrawable) this.a.put(str, bitmapDrawable);
                if (bitmapDrawable2 != null) {
                    this.c -= f(str, bitmapDrawable2);
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
        if (bitmapDrawable2 != null) {
            a(str, bitmapDrawable2);
        }
        h(this.d, str);
        return bitmapDrawable2;
    }

    public final BitmapDrawable e(String str) {
        BitmapDrawable bitmapDrawable;
        ArrayList arrayList;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                bitmapDrawable = (BitmapDrawable) this.a.remove(str);
                if (bitmapDrawable != null) {
                    this.c -= f(str, bitmapDrawable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bitmapDrawable != null) {
            String[] strArrSplit = str.split(Separators.AT);
            if (strArrSplit.length > 1 && (arrayList = (ArrayList) this.b.get(strArrSplit[0])) != null) {
                arrayList.remove(strArrSplit[1]);
                if (arrayList.isEmpty()) {
                    this.b.remove(strArrSplit[0]);
                }
            }
            a(str, bitmapDrawable);
        }
        return bitmapDrawable;
    }

    protected abstract int g(BitmapDrawable bitmapDrawable);
}
