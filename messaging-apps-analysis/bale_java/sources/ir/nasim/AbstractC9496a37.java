package ir.nasim;

import android.util.Size;
import java.util.Map;

/* renamed from: ir.nasim.a37, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9496a37 {
    AbstractC9496a37() {
    }

    public static AbstractC9496a37 a(Size size, Map map, Size size2, Map map2, Size size3, Map map3, Map map4) {
        return new JT(size, map, size2, map2, size3, map3, map4);
    }

    public abstract Size b();

    public Size c(int i) {
        return (Size) d().get(Integer.valueOf(i));
    }

    public abstract Map d();

    public abstract Size e();

    public abstract Size f();

    public Size g(int i) {
        return (Size) h().get(Integer.valueOf(i));
    }

    public abstract Map h();

    public Size i(int i) {
        return (Size) j().get(Integer.valueOf(i));
    }

    public abstract Map j();

    public Size k(int i) {
        return (Size) l().get(Integer.valueOf(i));
    }

    public abstract Map l();
}
