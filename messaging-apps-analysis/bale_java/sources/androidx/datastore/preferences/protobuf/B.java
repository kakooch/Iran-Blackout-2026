package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.g0;

/* loaded from: classes2.dex */
public class B {
    private final a a;
    private final Object b;
    private final Object c;

    static class a {
        public final g0.b a;
        public final Object b;
        public final g0.b c;
        public final Object d;

        public a(g0.b bVar, Object obj, g0.b bVar2, Object obj2) {
            this.a = bVar;
            this.b = obj;
            this.c = bVar2;
            this.d = obj2;
        }
    }

    private B(g0.b bVar, Object obj, g0.b bVar2, Object obj2) {
        this.a = new a(bVar, obj, bVar2, obj2);
        this.b = obj;
        this.c = obj2;
    }

    static int b(a aVar, Object obj, Object obj2) {
        return C1948q.b(aVar.a, 1, obj) + C1948q.b(aVar.c, 2, obj2);
    }

    public static B d(g0.b bVar, Object obj, g0.b bVar2, Object obj2) {
        return new B(bVar, obj, bVar2, obj2);
    }

    static void e(CodedOutputStream codedOutputStream, a aVar, Object obj, Object obj2) {
        C1948q.u(codedOutputStream, aVar.a, 1, obj);
        C1948q.u(codedOutputStream, aVar.c, 2, obj2);
    }

    public int a(int i, Object obj, Object obj2) {
        return CodedOutputStream.P(i) + CodedOutputStream.y(b(this.a, obj, obj2));
    }

    a c() {
        return this.a;
    }
}
