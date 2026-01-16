package com.google.protobuf;

import com.google.protobuf.r0;

/* loaded from: classes3.dex */
public class I {
    private final a a;
    private final Object b;
    private final Object c;

    static class a {
        public final r0.b a;
        public final Object b;
        public final r0.b c;
        public final Object d;

        public a(r0.b bVar, Object obj, r0.b bVar2, Object obj2) {
            this.a = bVar;
            this.b = obj;
            this.c = bVar2;
            this.d = obj2;
        }
    }

    private I(r0.b bVar, Object obj, r0.b bVar2, Object obj2) {
        this.a = new a(bVar, obj, bVar2, obj2);
        this.b = obj;
        this.c = obj2;
    }

    static int b(a aVar, Object obj, Object obj2) {
        return C2399x.d(aVar.a, 1, obj) + C2399x.d(aVar.c, 2, obj2);
    }

    public static I d(r0.b bVar, Object obj, r0.b bVar2, Object obj2) {
        return new I(bVar, obj, bVar2, obj2);
    }

    static void e(CodedOutputStream codedOutputStream, a aVar, Object obj, Object obj2) {
        C2399x.E(codedOutputStream, aVar.a, 1, obj);
        C2399x.E(codedOutputStream, aVar.c, 2, obj2);
    }

    public int a(int i, Object obj, Object obj2) {
        return CodedOutputStream.S(i) + CodedOutputStream.A(b(this.a, obj, obj2));
    }

    a c() {
        return this.a;
    }
}
