package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.LongSparseArray;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.V23;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class a {
    private final Object a = new Object();
    private final LongSparseArray b = new LongSparseArray();
    Map c = new HashMap();
    private final LongSparseArray d = new LongSparseArray();
    InterfaceC0018a e;

    /* renamed from: androidx.camera.extensions.internal.sessionprocessor.a$a, reason: collision with other inner class name */
    interface InterfaceC0018a {
    }

    a() {
    }

    private void a(LongSparseArray longSparseArray, long j, Object obj) {
        List arrayList = (List) longSparseArray.get(j);
        if (arrayList == null) {
            arrayList = new ArrayList();
            longSparseArray.put(j, arrayList);
        }
        arrayList.add(obj);
    }

    private long f(TotalCaptureResult totalCaptureResult) {
        Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    private void h() {
        synchronized (this.a) {
            try {
                int size = this.b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    List list = (List) this.b.valueAt(size);
                    if (!list.isEmpty()) {
                        TotalCaptureResult totalCaptureResult = (TotalCaptureResult) list.get(0);
                        long jF = f(totalCaptureResult);
                        AbstractC4980Hj5.i(jF == this.b.keyAt(size));
                        List list2 = (List) this.d.get(jF);
                        if (list2 != null && !list2.isEmpty()) {
                            AbstractC18350oW3.a(list2.get(0));
                            i(this.d, jF, null);
                            list.remove(totalCaptureResult);
                            if (list.isEmpty()) {
                                this.b.removeAt(size);
                            }
                        }
                    }
                    size--;
                }
                j();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void i(LongSparseArray longSparseArray, long j, Object obj) {
        List list = (List) longSparseArray.get(j);
        if (list != null) {
            list.remove(obj);
            if (list.isEmpty()) {
                longSparseArray.remove(j);
            }
        }
    }

    private void j() {
        synchronized (this.a) {
            try {
                if (this.d.size() != 0 && this.b.size() != 0) {
                    long jKeyAt = this.d.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.b.keyAt(0);
                    AbstractC4980Hj5.a(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.d.size() - 1; size >= 0; size--) {
                            if (this.d.keyAt(size) < jKeyAt2) {
                                Iterator it = ((List) this.d.valueAt(size)).iterator();
                                if (it.hasNext()) {
                                    AbstractC18350oW3.a(it.next());
                                    throw null;
                                }
                                this.d.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
                            if (this.b.keyAt(size2) < jKeyAt) {
                                this.b.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    void b(TotalCaptureResult totalCaptureResult) {
        c(totalCaptureResult, 0);
    }

    void c(TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.a) {
            try {
                long jF = f(totalCaptureResult);
                if (jF == -1) {
                    return;
                }
                a(this.b, jF, totalCaptureResult);
                this.c.put(totalCaptureResult, Integer.valueOf(i));
                h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void d() {
        synchronized (this.a) {
            try {
                this.b.clear();
                for (int i = 0; i < this.d.size(); i++) {
                    Iterator it = ((List) this.d.get(this.d.keyAt(i))).iterator();
                    if (it.hasNext()) {
                        AbstractC18350oW3.a(it.next());
                        throw null;
                    }
                }
                this.d.clear();
                this.c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void e() {
        synchronized (this.a) {
            this.e = null;
        }
    }

    void g(V23 v23) {
        synchronized (this.a) {
            a(this.d, v23.get().getTimestamp(), v23);
        }
        h();
    }

    void k(InterfaceC0018a interfaceC0018a) {
        synchronized (this.a) {
            this.e = interfaceC0018a;
        }
    }
}
