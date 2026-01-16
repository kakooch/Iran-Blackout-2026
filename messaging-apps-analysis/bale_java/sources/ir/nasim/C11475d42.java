package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.IOException;
import java.util.List;

/* renamed from: ir.nasim.d42, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11475d42 {
    private C23945xm7 a = new C23945xm7(AbstractC13836gu.e(), C4301En7.b.a(), (C4301En7) null, (ED1) null);
    private M42 b = new M42(this.a.e(), this.a.g(), null);

    /* renamed from: ir.nasim.d42$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC18081o32 e;
        final /* synthetic */ C11475d42 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC18081o32 interfaceC18081o32, C11475d42 c11475d42) {
            super(1);
            this.e = interfaceC18081o32;
            this.f = c11475d42;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(InterfaceC18081o32 interfaceC18081o32) {
            return (this.e == interfaceC18081o32 ? " > " : "   ") + this.f.e(interfaceC18081o32);
        }
    }

    private final String c(List list, InterfaceC18081o32 interfaceC18081o32) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.b.h() + ", composition=" + this.b.d() + ", selection=" + ((Object) C4301En7.q(this.b.i())) + "):");
        AbstractC13042fc3.h(sb, "append(...)");
        sb.append('\n');
        AbstractC13042fc3.h(sb, "append(...)");
        AbstractC15401jX0.x0(list, sb, (124 & 2) != 0 ? ", " : Separators.RETURN, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new a(interfaceC18081o32, this));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(InterfaceC18081o32 interfaceC18081o32) {
        if (interfaceC18081o32 instanceof UZ0) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommitTextCommand(text.length=");
            UZ0 uz0 = (UZ0) interfaceC18081o32;
            sb.append(uz0.c().length());
            sb.append(", newCursorPosition=");
            sb.append(uz0.b());
            sb.append(')');
            return sb.toString();
        }
        if (interfaceC18081o32 instanceof C15043iu6) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SetComposingTextCommand(text.length=");
            C15043iu6 c15043iu6 = (C15043iu6) interfaceC18081o32;
            sb2.append(c15043iu6.c().length());
            sb2.append(", newCursorPosition=");
            sb2.append(c15043iu6.b());
            sb2.append(')');
            return sb2.toString();
        }
        if (interfaceC18081o32 instanceof C14436hu6) {
            return interfaceC18081o32.toString();
        }
        if (interfaceC18081o32 instanceof KH1) {
            return interfaceC18081o32.toString();
        }
        if (interfaceC18081o32 instanceof LH1) {
            return interfaceC18081o32.toString();
        }
        if (interfaceC18081o32 instanceof C24024xu6) {
            return interfaceC18081o32.toString();
        }
        if (interfaceC18081o32 instanceof C4539Fo2) {
            return interfaceC18081o32.toString();
        }
        if (interfaceC18081o32 instanceof C16440lH1) {
            return interfaceC18081o32.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Unknown EditCommand: ");
        String strP = AbstractC10882cM5.b(interfaceC18081o32.getClass()).p();
        if (strP == null) {
            strP = "{anonymous EditCommand}";
        }
        sb3.append(strP);
        return sb3.toString();
    }

    public final C23945xm7 b(List list) {
        InterfaceC18081o32 interfaceC18081o32;
        Exception e;
        InterfaceC18081o32 interfaceC18081o322;
        try {
            int size = list.size();
            int i = 0;
            interfaceC18081o32 = null;
            while (i < size) {
                try {
                    interfaceC18081o322 = (InterfaceC18081o32) list.get(i);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    interfaceC18081o322.a(this.b);
                    i++;
                    interfaceC18081o32 = interfaceC18081o322;
                } catch (Exception e3) {
                    e = e3;
                    interfaceC18081o32 = interfaceC18081o322;
                    throw new RuntimeException(c(list, interfaceC18081o32), e);
                }
            }
            C13245fu c13245fuS = this.b.s();
            long jI = this.b.i();
            C4301En7 c4301En7B = C4301En7.b(jI);
            c4301En7B.r();
            C4301En7 c4301En7 = C4301En7.m(this.a.g()) ? null : c4301En7B;
            C23945xm7 c23945xm7 = new C23945xm7(c13245fuS, c4301En7 != null ? c4301En7.r() : AbstractC4535Fn7.b(C4301En7.k(jI), C4301En7.l(jI)), this.b.d(), (ED1) null);
            this.a = c23945xm7;
            return c23945xm7;
        } catch (Exception e4) {
            interfaceC18081o32 = null;
            e = e4;
        }
    }

    public final void d(C23945xm7 c23945xm7, C8564Wm7 c8564Wm7) {
        boolean z = true;
        boolean z2 = !AbstractC13042fc3.d(c23945xm7.f(), this.b.d());
        boolean z3 = false;
        if (!AbstractC13042fc3.d(this.a.e().k(), c23945xm7.e().k())) {
            this.b = new M42(c23945xm7.e(), c23945xm7.g(), null);
        } else if (C4301En7.g(this.a.g(), c23945xm7.g())) {
            z = false;
        } else {
            this.b.p(C4301En7.l(c23945xm7.g()), C4301En7.k(c23945xm7.g()));
            z3 = true;
            z = false;
        }
        if (c23945xm7.f() == null) {
            this.b.a();
        } else if (!C4301En7.h(c23945xm7.f().r())) {
            this.b.n(C4301En7.l(c23945xm7.f().r()), C4301En7.k(c23945xm7.f().r()));
        }
        if (z || (!z3 && z2)) {
            this.b.a();
            c23945xm7 = C23945xm7.c(c23945xm7, null, 0L, null, 3, null);
        }
        C23945xm7 c23945xm72 = this.a;
        this.a = c23945xm7;
        if (c8564Wm7 != null) {
            c8564Wm7.d(c23945xm72, c23945xm7);
        }
    }

    public final C23945xm7 f() {
        return this.a;
    }
}
