package ir.nasim;

import java.util.Collections;
import java.util.Map;

/* renamed from: ir.nasim.qk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19673qk8 {
    private static final Class b = a();
    static final C19673qk8 c = new C19673qk8(true);
    private final Map a = Collections.emptyMap();

    private C19673qk8(boolean z) {
    }

    private static Class a() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static C19673qk8 b() {
        return AbstractC19082pk8.b();
    }
}
