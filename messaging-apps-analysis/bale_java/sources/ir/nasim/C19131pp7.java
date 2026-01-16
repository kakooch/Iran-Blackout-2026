package ir.nasim;

import ir.nasim.EX1;
import ir.nasim.file.download.model.exception.DownloadErrorException;

/* renamed from: ir.nasim.pp7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19131pp7 implements InterfaceC14123hO3 {
    public static final C19131pp7 a = new C19131pp7();

    private C19131pp7() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EX1 a(Throwable th) {
        AbstractC13042fc3.i(th, "input");
        if (th instanceof DownloadErrorException) {
            return ((DownloadErrorException) th).getDownloadError();
        }
        EX1.c cVarA = C20331rp7.a.a(th);
        return cVarA != null ? cVarA : C19722qp7.a.a(th);
    }
}
