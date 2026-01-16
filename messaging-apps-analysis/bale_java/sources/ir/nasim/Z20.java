package ir.nasim;

/* loaded from: classes3.dex */
public interface Z20 {

    public static final class a {
        public static /* synthetic */ void a(Z20 z20, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAlignBottom");
            }
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            z20.c(i, i2);
        }

        public static /* synthetic */ void b(Z20 z20, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAlignEnd");
            }
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            z20.a(i, i2);
        }
    }

    void a(int i, int i2);

    void c(int i, int i2);
}
