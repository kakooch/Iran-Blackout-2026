package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.IOException;
import java.util.List;

/* renamed from: ir.nasim.jM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15307jM5 {
    public static final C15307jM5 b = new C15307jM5();
    private static final FI1 a = FI1.g;

    /* renamed from: ir.nasim.jM5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(InterfaceC24919zQ7 interfaceC24919zQ7) {
            C15307jM5 c15307jM5 = C15307jM5.b;
            AbstractC13042fc3.h(interfaceC24919zQ7, "it");
            AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
            AbstractC13042fc3.h(type, "it.type");
            return c15307jM5.h(type);
        }
    }

    /* renamed from: ir.nasim.jM5$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(InterfaceC24919zQ7 interfaceC24919zQ7) {
            C15307jM5 c15307jM5 = C15307jM5.b;
            AbstractC13042fc3.h(interfaceC24919zQ7, "it");
            AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
            AbstractC13042fc3.h(type, "it.type");
            return c15307jM5.h(type);
        }
    }

    private C15307jM5() {
    }

    private final void a(StringBuilder sb, ZI5 zi5) {
        if (zi5 != null) {
            AbstractC4099Dr3 type = zi5.getType();
            AbstractC13042fc3.h(type, "receiver.type");
            sb.append(h(type));
            sb.append(Separators.DOT);
        }
    }

    private final void b(StringBuilder sb, InterfaceC14592iA0 interfaceC14592iA0) {
        ZI5 zi5F = AbstractC14729iN7.f(interfaceC14592iA0);
        ZI5 zi5Q = interfaceC14592iA0.Q();
        a(sb, zi5F);
        boolean z = (zi5F == null || zi5Q == null) ? false : true;
        if (z) {
            sb.append(Separators.LPAREN);
        }
        a(sb, zi5Q);
        if (z) {
            sb.append(Separators.RPAREN);
        }
    }

    private final String c(InterfaceC14592iA0 interfaceC14592iA0) {
        if (interfaceC14592iA0 instanceof InterfaceC20989sw5) {
            return g((InterfaceC20989sw5) interfaceC14592iA0);
        }
        if (interfaceC14592iA0 instanceof AB2) {
            return d((AB2) interfaceC14592iA0);
        }
        throw new IllegalStateException(("Illegal callable: " + interfaceC14592iA0).toString());
    }

    public final String d(AB2 ab2) throws IOException {
        AbstractC13042fc3.i(ab2, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        C15307jM5 c15307jM5 = b;
        c15307jM5.b(sb, ab2);
        FI1 fi1 = a;
        C6432No4 name = ab2.getName();
        AbstractC13042fc3.h(name, "descriptor.name");
        sb.append(fi1.w(name, true));
        List listH = ab2.h();
        AbstractC13042fc3.h(listH, "descriptor.valueParameters");
        AbstractC15401jX0.x0(listH, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : Separators.LPAREN, (124 & 8) == 0 ? Separators.RPAREN : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : a.e);
        sb.append(": ");
        AbstractC4099Dr3 returnType = ab2.getReturnType();
        AbstractC13042fc3.f(returnType);
        AbstractC13042fc3.h(returnType, "descriptor.returnType!!");
        sb.append(c15307jM5.h(returnType));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String e(AB2 ab2) throws IOException {
        AbstractC13042fc3.i(ab2, "invoke");
        StringBuilder sb = new StringBuilder();
        C15307jM5 c15307jM5 = b;
        c15307jM5.b(sb, ab2);
        List listH = ab2.h();
        AbstractC13042fc3.h(listH, "invoke.valueParameters");
        AbstractC15401jX0.x0(listH, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : Separators.LPAREN, (124 & 8) == 0 ? Separators.RPAREN : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : b.e);
        sb.append(" -> ");
        AbstractC4099Dr3 returnType = ab2.getReturnType();
        AbstractC13042fc3.f(returnType);
        AbstractC13042fc3.h(returnType, "invoke.returnType!!");
        sb.append(c15307jM5.h(returnType));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String f(C3586Bm3 c3586Bm3) {
        AbstractC13042fc3.i(c3586Bm3, "parameter");
        StringBuilder sb = new StringBuilder();
        int i = AbstractC14718iM5.a[c3586Bm3.f().ordinal()];
        if (i == 1) {
            sb.append("extension receiver parameter");
        } else if (i == 2) {
            sb.append("instance parameter");
        } else if (i == 3) {
            sb.append("parameter #" + c3586Bm3.j() + ' ' + c3586Bm3.getName());
        }
        sb.append(" of ");
        sb.append(b.c(c3586Bm3.h().D()));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String g(InterfaceC20989sw5 interfaceC20989sw5) {
        AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(interfaceC20989sw5.P() ? "var " : "val ");
        C15307jM5 c15307jM5 = b;
        c15307jM5.b(sb, interfaceC20989sw5);
        FI1 fi1 = a;
        C6432No4 name = interfaceC20989sw5.getName();
        AbstractC13042fc3.h(name, "descriptor.name");
        sb.append(fi1.w(name, true));
        sb.append(": ");
        AbstractC4099Dr3 type = interfaceC20989sw5.getType();
        AbstractC13042fc3.h(type, "descriptor.type");
        sb.append(c15307jM5.h(type));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String h(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        return a.x(abstractC4099Dr3);
    }
}
