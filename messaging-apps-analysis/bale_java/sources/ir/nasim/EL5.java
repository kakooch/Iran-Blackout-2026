package ir.nasim;

/* loaded from: classes8.dex */
public abstract class EL5 {
    public static final Class a(ClassLoader classLoader, String str) {
        AbstractC13042fc3.i(classLoader, "<this>");
        AbstractC13042fc3.i(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
