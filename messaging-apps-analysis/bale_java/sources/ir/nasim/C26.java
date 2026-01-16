package ir.nasim;

import android.content.Context;
import ir.nasim.D26;

/* loaded from: classes2.dex */
public final class C26 {
    public static final C26 a = new C26();

    private C26() {
    }

    public static final D26.a a(Context context, Class cls, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(cls, "klass");
        if (true ^ (str == null || AbstractC20762sZ6.n0(str))) {
            return new D26.a(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    public static final Object b(Class cls, String str) throws ClassNotFoundException {
        String str2;
        AbstractC13042fc3.i(cls, "klass");
        AbstractC13042fc3.i(str, "suffix");
        Package r0 = cls.getPackage();
        AbstractC13042fc3.f(r0);
        String name = r0.getName();
        String canonicalName = cls.getCanonicalName();
        AbstractC13042fc3.f(canonicalName);
        AbstractC13042fc3.h(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            AbstractC13042fc3.h(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str3 = AbstractC20153rZ6.L(canonicalName, '.', '_', false, 4, null) + str;
        try {
            if (name.length() == 0) {
                str2 = str3;
            } else {
                str2 = name + '.' + str3;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            AbstractC13042fc3.g(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return cls2.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }

    public static final D26.a c(Context context, Class cls) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(cls, "klass");
        return new D26.a(context, cls, null);
    }
}
