package ir.nasim;

/* loaded from: classes.dex */
public interface CT4 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final CT4 a(int i) {
            if (!(i >= 0)) {
                P73.a("pages should be greater than or equal to 0. You have used " + i + '.');
            }
            return new DT4(i);
        }
    }

    int a(int i, int i2, float f, int i3, int i4);
}
