package androidx.datastore.preferences.protobuf;

/* loaded from: classes2.dex */
abstract class F {
    private static final D a = c();
    private static final D b = new E();

    static D a() {
        return a;
    }

    static D b() {
        return b;
    }

    private static D c() {
        try {
            return (D) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
