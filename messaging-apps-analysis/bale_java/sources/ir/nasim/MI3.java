package ir.nasim;

/* loaded from: classes3.dex */
public abstract class MI3 {
    public static MI3 a(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new C5028Hp(cls.getSimpleName()) : new C22745vl3(cls.getSimpleName());
    }

    public abstract void b(String str);
}
