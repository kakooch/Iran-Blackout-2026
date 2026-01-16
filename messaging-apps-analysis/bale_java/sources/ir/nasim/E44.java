package ir.nasim;

/* loaded from: classes2.dex */
public class E44 implements InterfaceC9904al1 {
    private final String a;
    private final a b;
    private final boolean c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a j(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public E44(String str, a aVar, boolean z) {
        this.a = str;
        this.b = aVar;
        this.c = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        if (qVar.l0(SK3.MergePathsApi19)) {
            return new F44(this);
        }
        JI3.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
