package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1949s implements H {
    private static final C1949s a = new C1949s();

    private C1949s() {
    }

    public static C1949s c() {
        return a;
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public G a(Class cls) {
        if (!AbstractC1950t.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (G) AbstractC1950t.p(cls.asSubclass(AbstractC1950t.class)).h();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public boolean b(Class cls) {
        return AbstractC1950t.class.isAssignableFrom(cls);
    }
}
