package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
interface C {

    public static class a implements C {
        SparseArray a = new SparseArray();
        int b = 0;

        /* renamed from: androidx.recyclerview.widget.C$a$a, reason: collision with other inner class name */
        class C0109a implements c {
            private SparseIntArray a = new SparseIntArray(1);
            private SparseIntArray b = new SparseIntArray(1);
            final r c;

            C0109a(r rVar) {
                this.c = rVar;
            }

            @Override // androidx.recyclerview.widget.C.c
            public int a(int i) {
                int iIndexOfKey = this.b.indexOfKey(i);
                if (iIndexOfKey >= 0) {
                    return this.b.valueAt(iIndexOfKey);
                }
                throw new IllegalStateException("requested global type " + i + " does not belong to the adapter:" + this.c.c);
            }

            @Override // androidx.recyclerview.widget.C.c
            public int b(int i) {
                int iIndexOfKey = this.a.indexOfKey(i);
                if (iIndexOfKey > -1) {
                    return this.a.valueAt(iIndexOfKey);
                }
                int iC = a.this.c(this.c);
                this.a.put(i, iC);
                this.b.put(iC, i);
                return iC;
            }

            @Override // androidx.recyclerview.widget.C.c
            public void dispose() {
                a.this.d(this.c);
            }
        }

        @Override // androidx.recyclerview.widget.C
        public r a(int i) {
            r rVar = (r) this.a.get(i);
            if (rVar != null) {
                return rVar;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i);
        }

        @Override // androidx.recyclerview.widget.C
        public c b(r rVar) {
            return new C0109a(rVar);
        }

        int c(r rVar) {
            int i = this.b;
            this.b = i + 1;
            this.a.put(i, rVar);
            return i;
        }

        void d(r rVar) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                if (((r) this.a.valueAt(size)) == rVar) {
                    this.a.removeAt(size);
                }
            }
        }
    }

    public static class b implements C {
        SparseArray a = new SparseArray();

        class a implements c {
            final r a;

            a(r rVar) {
                this.a = rVar;
            }

            @Override // androidx.recyclerview.widget.C.c
            public int a(int i) {
                return i;
            }

            @Override // androidx.recyclerview.widget.C.c
            public int b(int i) {
                List arrayList = (List) b.this.a.get(i);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    b.this.a.put(i, arrayList);
                }
                if (!arrayList.contains(this.a)) {
                    arrayList.add(this.a);
                }
                return i;
            }

            @Override // androidx.recyclerview.widget.C.c
            public void dispose() {
                b.this.c(this.a);
            }
        }

        @Override // androidx.recyclerview.widget.C
        public r a(int i) {
            List list = (List) this.a.get(i);
            if (list != null && !list.isEmpty()) {
                return (r) list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i);
        }

        @Override // androidx.recyclerview.widget.C
        public c b(r rVar) {
            return new a(rVar);
        }

        void c(r rVar) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                List list = (List) this.a.valueAt(size);
                if (list.remove(rVar) && list.isEmpty()) {
                    this.a.removeAt(size);
                }
            }
        }
    }

    public interface c {
        int a(int i);

        int b(int i);

        void dispose();
    }

    r a(int i);

    c b(r rVar);
}
