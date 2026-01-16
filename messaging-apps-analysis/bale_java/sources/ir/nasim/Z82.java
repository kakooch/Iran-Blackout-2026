package ir.nasim;

import android.text.TextUtils;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import ir.nasim.InterfaceC15297jL4;
import java.util.List;

/* loaded from: classes2.dex */
public class Z82 implements Runnable {
    private static final String c = HI3.f("EnqueueRunnable");
    private final Pa8 a;
    private final C18843pL4 b = new C18843pL4();

    public Z82(Pa8 pa8) {
        this.a = pa8;
    }

    private static boolean b(Pa8 pa8) {
        boolean zC = c(pa8.g(), pa8.f(), (String[]) Pa8.l(pa8).toArray(new String[0]), pa8.d(), pa8.b());
        pa8.k();
        return zC;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0137 A[PHI: r0 r8 r11 r12 r13
      0x0137: PHI (r0v1 java.lang.String[]) = 
      (r0v0 java.lang.String[])
      (r0v0 java.lang.String[])
      (r0v0 java.lang.String[])
      (r0v13 java.lang.String[])
      (r0v13 java.lang.String[])
     binds: [B:28:0x0063, B:29:0x0065, B:31:0x0073, B:80:0x0136, B:79:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r8v2 boolean) = (r8v1 boolean), (r8v1 boolean), (r8v1 boolean), (r8v5 boolean), (r8v6 boolean) binds: [B:28:0x0063, B:29:0x0065, B:31:0x0073, B:80:0x0136, B:79:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r11v2 boolean) = (r11v1 boolean), (r11v1 boolean), (r11v1 boolean), (r11v4 boolean), (r11v4 boolean) binds: [B:28:0x0063, B:29:0x0065, B:31:0x0073, B:80:0x0136, B:79:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r12v2 boolean) = (r12v1 boolean), (r12v1 boolean), (r12v1 boolean), (r12v5 boolean), (r12v5 boolean) binds: [B:28:0x0063, B:29:0x0065, B:31:0x0073, B:80:0x0136, B:79:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r13v2 boolean) = (r13v1 boolean), (r13v1 boolean), (r13v1 boolean), (r13v5 boolean), (r13v5 boolean) binds: [B:28:0x0063, B:29:0x0065, B:31:0x0073, B:80:0x0136, B:79:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c(ir.nasim.Za8 r16, java.util.List r17, java.lang.String[] r18, java.lang.String r19, ir.nasim.EnumC23850xd2 r20) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Z82.c(ir.nasim.Za8, java.util.List, java.lang.String[], java.lang.String, ir.nasim.xd2):boolean");
    }

    private static boolean e(Pa8 pa8) {
        List<Pa8> listE = pa8.e();
        boolean z = false;
        if (listE != null) {
            boolean zE = false;
            for (Pa8 pa82 : listE) {
                if (pa82.j()) {
                    HI3.c().h(c, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", pa82.c())), new Throwable[0]);
                } else {
                    zE |= e(pa82);
                }
            }
            z = zE;
        }
        return b(pa8) | z;
    }

    private static void g(C17810nb8 c17810nb8) {
        C18424oe1 c18424oe1 = c17810nb8.j;
        String str = c17810nb8.c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (c18424oe1.f() || c18424oe1.i()) {
            b.a aVar = new b.a();
            aVar.c(c17810nb8.e).h("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            c17810nb8.c = ConstraintTrackingWorker.class.getName();
            c17810nb8.e = aVar.a();
        }
    }

    public boolean a() {
        WorkDatabase workDatabaseO = this.a.g().o();
        workDatabaseO.e();
        try {
            boolean zE = e(this.a);
            workDatabaseO.F();
            return zE;
        } finally {
            workDatabaseO.j();
        }
    }

    public InterfaceC15297jL4 d() {
        return this.b;
    }

    public void f() {
        Za8 za8G = this.a.g();
        AbstractC10449bd6.b(za8G.i(), za8G.o(), za8G.n());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.h()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.a));
            }
            if (a()) {
                FS4.a(this.a.g().h(), RescheduleReceiver.class, true);
                f();
            }
            this.b.a(InterfaceC15297jL4.a);
        } catch (Throwable th) {
            this.b.a(new InterfaceC15297jL4.b.a(th));
        }
    }
}
