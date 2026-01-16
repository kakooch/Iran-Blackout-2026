package ir.nasim;

import android.media.AudioAttributes;
import android.os.Build;
import ir.nasim.AbstractC24902zP;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class KN {
    public static final KN a = new KN();

    private KN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(C11434d01 c11434d01) {
        c11434d01.g();
    }

    public final IN b(InterfaceC7720Sx5 interfaceC7720Sx5, IN in, AbstractC24902zP abstractC24902zP) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "audioSwitchHandler");
        AbstractC13042fc3.i(abstractC24902zP, "audioOutputType");
        if (in != null) {
            return in;
        }
        Object obj = interfaceC7720Sx5.get();
        C21268tP c21268tP = (C21268tP) obj;
        c21268tP.h(abstractC24902zP.b());
        c21268tP.f(abstractC24902zP.a().getContentType());
        c21268tP.g(abstractC24902zP.a().getUsage());
        c21268tP.i(abstractC24902zP.c());
        AbstractC13042fc3.h(obj, "apply(...)");
        return (IN) obj;
    }

    public final AudioAttributes c(AbstractC24902zP abstractC24902zP) {
        AbstractC13042fc3.i(abstractC24902zP, "audioType");
        return abstractC24902zP.a();
    }

    public final AbstractC24902zP d(AbstractC24902zP abstractC24902zP) {
        return abstractC24902zP == null ? new AbstractC24902zP.a() : abstractC24902zP;
    }

    public final InterfaceC10670c01 e(boolean z, AbstractC24902zP abstractC24902zP, ZV0 zv0, InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(abstractC24902zP, "audioType");
        AbstractC13042fc3.i(zv0, "closeableManager");
        AbstractC13042fc3.i(interfaceC7720Sx5, "commWorkaroundImplProvider");
        if (z || Build.VERSION.SDK_INT < 30 || abstractC24902zP.b() != 3) {
            return new C19353qC4();
        }
        Object obj = interfaceC7720Sx5.get();
        final C11434d01 c11434d01 = (C11434d01) obj;
        zv0.a(new Closeable() { // from class: ir.nasim.JN
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                KN.f(c11434d01);
            }
        });
        AbstractC13042fc3.f(obj);
        return (InterfaceC10670c01) obj;
    }
}
