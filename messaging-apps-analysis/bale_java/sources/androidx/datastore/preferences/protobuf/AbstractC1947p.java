package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC1947p {
    private static final AbstractC1945n a = new C1946o();
    private static final AbstractC1945n b = c();

    static AbstractC1945n a() {
        AbstractC1945n abstractC1945n = b;
        if (abstractC1945n != null) {
            return abstractC1945n;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static AbstractC1945n b() {
        return a;
    }

    private static AbstractC1945n c() {
        try {
            return (AbstractC1945n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
