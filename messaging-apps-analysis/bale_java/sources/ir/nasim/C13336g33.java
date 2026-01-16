package ir.nasim;

import android.content.res.Configuration;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.g33, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13336g33 {
    private final HashMap a = new HashMap();

    /* renamed from: ir.nasim.g33$a */
    public static final class a {
        private final C12700f33 a;
        private final int b;

        public a(C12700f33 c12700f33, int i) {
            this.a = c12700f33;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public final C12700f33 b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "ImageVectorEntry(imageVector=" + this.a + ", configFlags=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.g33$b */
    public static final class b {
        private final Resources.Theme a;
        private final int b;

        public b(Resources.Theme theme, int i) {
            this.a = theme;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "Key(theme=" + this.a + ", id=" + this.b + ')';
        }
    }

    public final void a() {
        this.a.clear();
    }

    public final a b(b bVar) {
        WeakReference weakReference = (WeakReference) this.a.get(bVar);
        if (weakReference != null) {
            return (a) weakReference.get();
        }
        return null;
    }

    public final void c(int i) {
        Iterator it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
            if (aVar == null || Configuration.needNewResources(i, aVar.a())) {
                it.remove();
            }
        }
    }

    public final void d(b bVar, a aVar) {
        this.a.put(bVar, new WeakReference(aVar));
    }
}
