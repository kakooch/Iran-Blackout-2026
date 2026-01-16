package com.google.android.gms.internal.clearcut;

/* loaded from: classes3.dex */
final class K implements T {
    private T[] a;

    K(T... tArr) {
        this.a = tArr;
    }

    @Override // com.google.android.gms.internal.clearcut.T
    public final boolean a(Class cls) {
        for (T t : this.a) {
            if (t.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.T
    public final S b(Class cls) {
        for (T t : this.a) {
            if (t.a(cls)) {
                return t.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
