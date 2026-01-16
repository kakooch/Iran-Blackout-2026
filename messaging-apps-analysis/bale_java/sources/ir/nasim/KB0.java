package ir.nasim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class KB0 {

    public static final class a extends JB0 {
        private final List a = new ArrayList();

        a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                JB0 jb0 = (JB0) it.next();
                if (!(jb0 instanceof b)) {
                    this.a.add(jb0);
                }
            }
        }

        @Override // ir.nasim.JB0
        public void a(int i) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((JB0) it.next()).a(i);
            }
        }

        @Override // ir.nasim.JB0
        public void b(int i, QB0 qb0) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((JB0) it.next()).b(i, qb0);
            }
        }

        @Override // ir.nasim.JB0
        public void c(int i, LB0 lb0) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((JB0) it.next()).c(i, lb0);
            }
        }

        @Override // ir.nasim.JB0
        public void d(int i) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((JB0) it.next()).d(i);
            }
        }

        public List e() {
            return this.a;
        }
    }

    static JB0 a(List list) {
        return list.isEmpty() ? c() : list.size() == 1 ? (JB0) list.get(0) : new a(list);
    }

    public static JB0 b(JB0... jb0Arr) {
        return a(Arrays.asList(jb0Arr));
    }

    public static JB0 c() {
        return new b();
    }

    static final class b extends JB0 {
        b() {
        }

        @Override // ir.nasim.JB0
        public void d(int i) {
        }

        @Override // ir.nasim.JB0
        public void b(int i, QB0 qb0) {
        }

        @Override // ir.nasim.JB0
        public void c(int i, LB0 lb0) {
        }
    }
}
