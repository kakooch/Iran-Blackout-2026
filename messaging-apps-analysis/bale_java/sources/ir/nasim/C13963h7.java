package ir.nasim;

/* renamed from: ir.nasim.h7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13963h7 implements InterfaceC19171pt7 {
    @Override // ir.nasim.InterfaceC19171pt7
    public void a(C9528a7 c9528a7, R92 r92, Exception exc) {
        C19406qI3.j("NASIM_SYSTEM", "Die(" + c9528a7.b() + ") by " + r92.b() + " with " + exc.getMessage(), new Object[0]);
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        C19406qI3.d("NASIM_SYSTEM", exc);
    }

    @Override // ir.nasim.InterfaceC19171pt7
    public void b(C9528a7 c9528a7, Object obj, K6 k6) {
        C19406qI3.j("NASIM_SYSTEM", "Drop: " + obj, new Object[0]);
    }

    @Override // ir.nasim.InterfaceC19171pt7
    public void c(R92 r92, long j) {
        if (j > 100) {
            C19406qI3.j("NASIM_SYSTEM", "Too long " + r92.c().e() + " {" + r92.b() + "} in " + j + " ms", new Object[0]);
        }
    }
}
