package ir.nasim;

/* renamed from: ir.nasim.pk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC19082pk8 {
    private static final Class a = a();

    private static Class a() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static C19673qk8 b() {
        Class cls = a;
        if (cls != null) {
            try {
                return (C19673qk8) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
            } catch (Exception unused) {
            }
        }
        return C19673qk8.c;
    }
}
