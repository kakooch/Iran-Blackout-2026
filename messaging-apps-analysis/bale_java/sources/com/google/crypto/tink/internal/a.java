package com.google.crypto.tink.internal;

/* loaded from: classes3.dex */
public abstract class a {
    private final Class a;
    private final Class b;

    /* renamed from: com.google.crypto.tink.internal.a$a, reason: collision with other inner class name */
    class C0193a extends a {
        final /* synthetic */ b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0193a(Class cls, Class cls2, b bVar) {
            super(cls, cls2, null);
            this.c = bVar;
        }
    }

    public interface b {
    }

    /* synthetic */ a(Class cls, Class cls2, C0193a c0193a) {
        this(cls, cls2);
    }

    public static a a(b bVar, Class cls, Class cls2) {
        return new C0193a(cls, cls2, bVar);
    }

    public Class b() {
        return this.a;
    }

    public Class c() {
        return this.b;
    }

    private a(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }
}
