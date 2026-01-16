package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C18810pH7;
import ir.nasim.InterfaceC10839cH7;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Yy7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9213Yy7 {
    private static final a e = new a(null);
    public static final int f = 8;
    private final C18810pH7 a;
    private final C18810pH7 b;
    private final HashMap c;
    private final HashMap d;

    /* renamed from: ir.nasim.Yy7$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C9213Yy7(C18810pH7 c18810pH7, C18810pH7 c18810pH72) {
        AbstractC13042fc3.i(c18810pH7, "smallQueue");
        AbstractC13042fc3.i(c18810pH72, "bigQueue");
        this.a = c18810pH7;
        this.b = c18810pH72;
        this.c = new HashMap();
        this.d = new HashMap();
    }

    private final C18810pH7 d(InterfaceC10839cH7 interfaceC10839cH7) {
        if (AbstractC13042fc3.d(interfaceC10839cH7, InterfaceC10839cH7.b.a)) {
            return this.a;
        }
        if (AbstractC13042fc3.d(interfaceC10839cH7, InterfaceC10839cH7.a.a)) {
            return this.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final C18810pH7 e(long j) {
        return (C18810pH7) this.c.get(Long.valueOf(j));
    }

    private final C18810pH7 f(long j) {
        return (C18810pH7) this.d.get(Long.valueOf(j));
    }

    public final void a(C4890Gz5 c4890Gz5) {
        AbstractC13042fc3.i(c4890Gz5, "item");
        C19406qI3.j("UploadQueue", "addToQueue(" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5.o())) + Separators.RPAREN, new Object[0]);
        C18810pH7 c18810pH7D = d(c4890Gz5.j());
        this.c.put(Long.valueOf(c4890Gz5.o()), c18810pH7D);
        this.d.put(Long.valueOf(c4890Gz5.l()), c18810pH7D);
        c18810pH7D.b(c4890Gz5);
    }

    public final C4890Gz5 b(long j) {
        C18810pH7 c18810pH7F = f(j);
        C4890Gz5 c4890Gz5C = c18810pH7F != null ? c18810pH7F.c(j) : null;
        if (c4890Gz5C == null) {
            C19406qI3.j("UploadQueue", "Failed to find the item by rid(" + AbstractC24249yI3.a(Long.valueOf(j)) + Separators.RPAREN, new Object[0]);
        }
        return c4890Gz5C;
    }

    public final C4890Gz5 c(long j) {
        C18810pH7 c18810pH7E = e(j);
        C4890Gz5 c4890Gz5D = c18810pH7E != null ? c18810pH7E.d(j) : null;
        if (c4890Gz5D == null) {
            C19406qI3.j("UploadQueue", "Failed to find the item by rid(" + AbstractC24249yI3.a(Long.valueOf(j)) + Separators.RPAREN, new Object[0]);
        }
        return c4890Gz5D;
    }

    public final C18810pH7.a g() {
        return this.b.e();
    }

    public final C18810pH7.a h() {
        return this.a.e();
    }

    public final void i(C4890Gz5 c4890Gz5) {
        AbstractC13042fc3.i(c4890Gz5, "item");
        C19406qI3.j("UploadQueue", "removeFromQueue(" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5.o())) + Separators.RPAREN, new Object[0]);
        this.c.remove(Long.valueOf(c4890Gz5.o()));
        this.d.remove(Long.valueOf(c4890Gz5.l()));
        d(c4890Gz5.j()).h(c4890Gz5);
    }
}
