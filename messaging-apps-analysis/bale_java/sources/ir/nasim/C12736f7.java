package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.HashMap;

/* renamed from: ir.nasim.f7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C12736f7 {
    private static final C12736f7 c = new C12736f7();
    private final HashMap a;
    private final InterfaceC19171pt7 b;

    public C12736f7() {
        this(true);
    }

    public static C12736f7 n() {
        return c;
    }

    public C9528a7 c(C4614Fw5 c4614Fw5, String str) {
        C23972xp4 c23972xp4;
        String strE = c4614Fw5.e() == null ? "D_default" : c4614Fw5.e();
        synchronized (this.a) {
            if (!this.a.containsKey(strE)) {
                throw new RuntimeException("Unknown dispatcherId '" + strE + Separators.QUOTE);
            }
            c23972xp4 = (C23972xp4) this.a.get(strE);
        }
        return c23972xp4.i(str, c4614Fw5);
    }

    public C9528a7 d(String str, V6 v6) {
        return c(C4614Fw5.d(v6), str);
    }

    public C9528a7 e(final String str, V6 v6, boolean z) {
        return !z ? d(str, v6) : f(str, C4614Fw5.d(v6).b(new InterfaceC10738c7() { // from class: ir.nasim.d7
            @Override // ir.nasim.InterfaceC10738c7
            public final void a(C4614Fw5 c4614Fw5, C9528a7 c9528a7) {
                this.a.k(str, c4614Fw5, c9528a7);
            }
        }));
    }

    public C9528a7 f(String str, C4614Fw5 c4614Fw5) {
        return c(c4614Fw5, str);
    }

    public C9528a7 g(final String str, C4614Fw5 c4614Fw5, boolean z) {
        return !z ? f(str, c4614Fw5) : f(str, c4614Fw5.b(new InterfaceC10738c7() { // from class: ir.nasim.e7
            @Override // ir.nasim.InterfaceC10738c7
            public final void a(C4614Fw5 c4614Fw52, C9528a7 c9528a7) {
                this.a.l(str, c4614Fw52, c9528a7);
            }
        }));
    }

    public void h(String str) {
        i(str, AbstractC7641So7.a(AbstractC20507s76.n()));
    }

    public void i(String str, int i) {
        synchronized (this.a) {
            try {
                if (this.a.containsKey(str)) {
                    return;
                }
                EnumC9950ap7 enumC9950ap7 = EnumC9950ap7.LOW;
                if (AbstractC20507s76.u()) {
                    i = 1;
                }
                this.a.put(str, new C23972xp4(str, enumC9950ap7, i, this.b));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public InterfaceC19171pt7 j() {
        return this.b;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void l(C9528a7 c9528a7, String str, C4614Fw5 c4614Fw5) {
        C23972xp4 c23972xp4;
        String strE = c4614Fw5.e() == null ? "D_default" : c4614Fw5.e();
        synchronized (this.a) {
            if (!this.a.containsKey(strE)) {
                throw new RuntimeException("Unknown dispatcherId '" + strE + Separators.QUOTE);
            }
            c23972xp4 = (C23972xp4) this.a.get(strE);
        }
        c23972xp4.j(c9528a7, str, c4614Fw5);
    }

    public C12736f7(boolean z) {
        this.a = new HashMap();
        this.b = new C13963h7();
        if (z) {
            h("D_default");
        }
    }
}
