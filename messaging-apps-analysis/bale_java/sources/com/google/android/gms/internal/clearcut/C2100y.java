package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;

/* renamed from: com.google.android.gms.internal.clearcut.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2100y implements T {
    private static final C2100y a = new C2100y();

    private C2100y() {
    }

    public static C2100y c() {
        return a;
    }

    @Override // com.google.android.gms.internal.clearcut.T
    public final boolean a(Class cls) {
        return AbstractC2101z.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.clearcut.T
    public final S b(Class cls) {
        if (!AbstractC2101z.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (S) AbstractC2101z.o(cls.asSubclass(AbstractC2101z.class)).i(AbstractC2101z.c.c, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
