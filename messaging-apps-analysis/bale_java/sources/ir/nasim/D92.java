package ir.nasim;

/* loaded from: classes3.dex */
public abstract class D92 {
    public static Object a(Object obj, Class cls) {
        if (obj instanceof KE2) {
            return cls.cast(obj);
        }
        if (obj instanceof LE2) {
            return a(((LE2) obj).N2(), cls);
        }
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", obj.getClass(), KE2.class, LE2.class));
    }
}
