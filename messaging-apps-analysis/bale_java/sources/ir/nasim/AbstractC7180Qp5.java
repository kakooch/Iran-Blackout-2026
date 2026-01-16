package ir.nasim;

import android.util.Log;

/* renamed from: ir.nasim.Qp5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7180Qp5 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.Qp5$a */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ void c(a aVar, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            aVar.b(str, th);
        }

        public final void a(String str, Throwable th) {
            Log.e("PreviewLogger", str, th);
        }

        public final void b(String str, Throwable th) {
            Log.w("PreviewLogger", str, th);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }
}
