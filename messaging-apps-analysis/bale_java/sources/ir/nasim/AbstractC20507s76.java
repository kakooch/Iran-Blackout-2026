package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.s76, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20507s76 {
    private static InterfaceC10343bV1 a;
    private static InterfaceC16767lp7 b;
    private static InterfaceC12905fN3 c;
    public static InterfaceC21014sz3 d;
    private static InterfaceC23591xA7 e;

    public static void A() {
        d.d();
    }

    public static void B(Intent intent) {
        d.e(intent);
    }

    public static void C(Runnable runnable) {
        D(runnable, 0L);
    }

    public static void D(Runnable runnable, long j) {
        c.b(runnable, j);
    }

    public static boolean E() {
        return d.c();
    }

    public static void F(int i, Intent intent) {
        C13923h3.a.f(i);
        B(intent);
    }

    public static void b(String str) {
        e.a(str);
    }

    public static void c(Runnable runnable) {
        c.e(runnable);
    }

    public static void d() {
        if (AbstractC21784u76.d() || !t()) {
            return;
        }
        C19406qI3.a("IO_ON_MAIN", "This operation is not permitted on mainThread " + q(Thread.currentThread().getStackTrace()), new Object[0]);
    }

    public static void e() {
        if (!AbstractC21784u76.d() && !c.c() && !c.a()) {
            throw new RuntimeException("Unable to perform operation not from Main Thread");
        }
    }

    public static RL f(int i) {
        return b.h(i);
    }

    public static TL g(long j) {
        return b.f(j);
    }

    public static YU1 h(String str) {
        return b.i(str);
    }

    public static U33 i(String str, EnumC9950ap7 enumC9950ap7) {
        return b.b(str, enumC9950ap7, -1);
    }

    public static AbstractC8114Uo7 j() {
        return b.a();
    }

    public static void k(Runnable runnable) {
        a.a(runnable);
    }

    public static void l() {
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.r76
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC20507s76.w();
            }
        });
    }

    public static long m() {
        return b.e();
    }

    public static int n() {
        return b.j();
    }

    public static long o() {
        return b.c();
    }

    public static long p() {
        return b.g();
    }

    public static String q(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (i > 20) {
                break;
            }
            sb.append(stackTraceElement.toString());
            sb.append(Separators.RETURN);
            i++;
        }
        return sb.toString();
    }

    public static String r() {
        return d.getVersion();
    }

    public static void s(InterfaceC10343bV1 interfaceC10343bV1, InterfaceC16767lp7 interfaceC16767lp7, InterfaceC12905fN3 interfaceC12905fN3, InterfaceC21014sz3 interfaceC21014sz3, InterfaceC23591xA7 interfaceC23591xA7) {
        a = interfaceC10343bV1;
        b = interfaceC16767lp7;
        c = interfaceC12905fN3;
        d = interfaceC21014sz3;
        e = interfaceC23591xA7;
    }

    public static boolean t() {
        return c.c() || c.a();
    }

    public static boolean u() {
        return c.c();
    }

    public static void v() {
        d.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w() {
        if (t()) {
            throw new RuntimeException(" this operation not permit on mainThread " + Arrays.toString(Thread.currentThread().getStackTrace()));
        }
    }

    public static InterfaceC22912w18 x() {
        return d.a();
    }

    public static void y() {
        d.b();
    }

    public static void z(Runnable runnable) {
        c.d(runnable);
    }
}
