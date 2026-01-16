package ir.nasim;

import ir.nasim.DU3;

/* loaded from: classes.dex */
public interface DU3 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int c(float f, WH1 wh1, int i, int i2) {
            return AbstractC20723sV3.d(f * i2);
        }

        public final DU3 b(final float f) {
            return new DU3() { // from class: ir.nasim.CU3
                @Override // ir.nasim.DU3
                public final int a(WH1 wh1, int i, int i2) {
                    return DU3.a.c(f, wh1, i, i2);
                }
            };
        }
    }

    int a(WH1 wh1, int i, int i2);
}
