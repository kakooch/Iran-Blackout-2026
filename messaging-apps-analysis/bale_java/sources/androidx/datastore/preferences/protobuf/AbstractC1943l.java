package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC1943l {
    static final Class a = c();

    public static C1944m a() {
        if (a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return C1944m.e;
    }

    private static final C1944m b(String str) {
        return (C1944m) a.getDeclaredMethod(str, null).invoke(null, null);
    }

    static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
