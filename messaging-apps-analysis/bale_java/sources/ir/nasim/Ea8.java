package ir.nasim;

import android.view.View;
import ir.nasim.Ea8;

/* loaded from: classes2.dex */
public interface Ea8 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final Ea8 b = new Ea8() { // from class: ir.nasim.Da8
            @Override // ir.nasim.Ea8
            public final SJ5 a(View view) {
                return Ea8.a.b(view);
            }
        };

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SJ5 b(View view) {
            return Ga8.c(view, null, null, 3, null);
        }

        public final Ea8 c() {
            return b;
        }
    }

    SJ5 a(View view);
}
