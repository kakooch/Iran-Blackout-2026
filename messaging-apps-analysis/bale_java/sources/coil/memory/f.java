package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.ED1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f implements h {
    public static final a c = new a(null);
    private final LinkedHashMap a = new LinkedHashMap();
    private int b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private final int a;
        private final WeakReference b;
        private final Map c;
        private final int d;

        public b(int i, WeakReference weakReference, Map map, int i2) {
            this.a = i;
            this.b = weakReference;
            this.c = map;
            this.d = i2;
        }

        public final WeakReference a() {
            return this.b;
        }

        public final Map b() {
            return this.c;
        }

        public final int c() {
            return this.a;
        }

        public final int d() {
            return this.d;
        }
    }

    private final void e() {
        int i = this.b;
        this.b = i + 1;
        if (i >= 10) {
            d();
        }
    }

    @Override // coil.memory.h
    public synchronized void a(int i) {
        if (i >= 10 && i != 20) {
            d();
        }
    }

    @Override // coil.memory.h
    public synchronized MemoryCache.b b(MemoryCache.Key key) {
        try {
            ArrayList arrayList = (ArrayList) this.a.get(key);
            MemoryCache.b bVar = null;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                b bVar2 = (b) arrayList.get(i);
                Bitmap bitmap = (Bitmap) bVar2.a().get();
                MemoryCache.b bVar3 = bitmap != null ? new MemoryCache.b(bitmap, bVar2.b()) : null;
                if (bVar3 != null) {
                    bVar = bVar3;
                    break;
                }
                i++;
            }
            e();
            return bVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil.memory.h
    public synchronized void c(MemoryCache.Key key, Bitmap bitmap, Map map, int i) {
        try {
            LinkedHashMap linkedHashMap = this.a;
            Object arrayList = linkedHashMap.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(key, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            b bVar = new b(iIdentityHashCode, new WeakReference(bitmap), map, i);
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    arrayList2.add(bVar);
                    break;
                }
                b bVar2 = (b) arrayList2.get(i2);
                if (i < bVar2.d()) {
                    i2++;
                } else if (bVar2.c() == iIdentityHashCode && bVar2.a().get() == bitmap) {
                    arrayList2.set(i2, bVar);
                } else {
                    arrayList2.add(i2, bVar);
                }
            }
            e();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void d() {
        WeakReference weakReferenceA;
        this.b = 0;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                b bVar = (b) AbstractC15401jX0.s0(arrayList);
                if (((bVar == null || (weakReferenceA = bVar.a()) == null) ? null : (Bitmap) weakReferenceA.get()) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = i2 - i;
                    if (((b) arrayList.get(i3)).a().get() == null) {
                        arrayList.remove(i3);
                        i++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }
}
