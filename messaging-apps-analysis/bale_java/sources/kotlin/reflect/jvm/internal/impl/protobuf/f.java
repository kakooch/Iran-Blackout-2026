package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: classes8.dex */
public class f {
    private static final f b = new f(true);
    private final Map a;

    private static final class a {
        private final Object a;
        private final int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    f() {
        this.a = new HashMap();
    }

    public static f c() {
        return b;
    }

    public static f d() {
        return new f();
    }

    public final void a(h.f fVar) {
        this.a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public h.f b(l lVar, int i) {
        return (h.f) this.a.get(new a(lVar, i));
    }

    private f(boolean z) {
        this.a = Collections.emptyMap();
    }
}
