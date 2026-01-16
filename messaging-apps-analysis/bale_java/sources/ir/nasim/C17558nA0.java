package ir.nasim;

import android.graphics.Typeface;
import android.os.Handler;
import ir.nasim.AbstractC20376ru2;
import ir.nasim.AbstractC6245Mu2;

/* renamed from: ir.nasim.nA0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C17558nA0 {
    private final AbstractC6245Mu2.c a;
    private final Handler b;

    /* renamed from: ir.nasim.nA0$a */
    class a implements Runnable {
        final /* synthetic */ AbstractC6245Mu2.c a;
        final /* synthetic */ Typeface b;

        a(AbstractC6245Mu2.c cVar, Typeface typeface) {
            this.a = cVar;
            this.b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    /* renamed from: ir.nasim.nA0$b */
    class b implements Runnable {
        final /* synthetic */ AbstractC6245Mu2.c a;
        final /* synthetic */ int b;

        b(AbstractC6245Mu2.c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    C17558nA0(AbstractC6245Mu2.c cVar, Handler handler) {
        this.a = cVar;
        this.b = handler;
    }

    private void a(int i) {
        this.b.post(new b(this.a, i));
    }

    private void c(Typeface typeface) {
        this.b.post(new a(this.a, typeface));
    }

    void b(AbstractC20376ru2.e eVar) {
        if (eVar.a()) {
            c(eVar.a);
        } else {
            a(eVar.b);
        }
    }
}
