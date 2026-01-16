package androidx.datastore.preferences.protobuf;

/* loaded from: classes2.dex */
abstract class O {
    private static final M a = c();
    private static final M b = new N();

    static M a() {
        return a;
    }

    static M b() {
        return b;
    }

    private static M c() {
        try {
            return (M) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
