package ir.nasim;

/* renamed from: ir.nasim.fj4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC13140fj4 {
    static /* synthetic */ void a(InterfaceC13140fj4 interfaceC13140fj4, String str, String str2, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendError");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        interfaceC13140fj4.b(str, str2, th);
    }

    void b(String str, String str2, Throwable th);
}
