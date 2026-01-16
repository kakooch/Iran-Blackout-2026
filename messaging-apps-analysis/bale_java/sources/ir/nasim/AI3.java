package ir.nasim;

import ir.nasim.C18319oT;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class AI3 {

    public static abstract class a {
        public abstract AI3 a();

        public abstract a b(AbstractC21997uV0 abstractC21997uV0);

        public abstract a c(List list);

        abstract a d(Integer num);

        abstract a e(String str);

        public abstract a f(EnumC23479wz5 enumC23479wz5);

        public abstract a g(long j);

        public abstract a h(long j);

        public a i(int i) {
            return d(Integer.valueOf(i));
        }

        public a j(String str) {
            return e(str);
        }
    }

    public static a a() {
        return new C18319oT.b();
    }

    public abstract AbstractC21997uV0 b();

    public abstract List c();

    public abstract Integer d();

    public abstract String e();

    public abstract EnumC23479wz5 f();

    public abstract long g();

    public abstract long h();
}
