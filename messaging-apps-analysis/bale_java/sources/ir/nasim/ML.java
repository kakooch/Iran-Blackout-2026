package ir.nasim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
abstract class ML {
    public final int a;

    static final class a extends ML {
        public final long b;
        public final List c;
        public final List d;

        public a(int i, long j) {
            super(i);
            this.b = j;
            this.c = new ArrayList();
            this.d = new ArrayList();
        }

        public void d(a aVar) {
            this.d.add(aVar);
        }

        public void e(b bVar) {
            this.c.add(bVar);
        }

        public a f(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.d.get(i2);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }

        public b g(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.c.get(i2);
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // ir.nasim.ML
        public String toString() {
            return ML.a(this.a) + " leaves: " + Arrays.toString(this.c.toArray()) + " containers: " + Arrays.toString(this.d.toArray());
        }
    }

    static final class b extends ML {
        public final EW4 b;

        public b(int i, EW4 ew4) {
            super(i);
            this.b = ew4;
        }
    }

    public ML(int i) {
        this.a = i;
    }

    public static String a(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public static int b(int i) {
        return i & 16777215;
    }

    public static int c(int i) {
        return (i >> 24) & 255;
    }

    public String toString() {
        return a(this.a);
    }
}
