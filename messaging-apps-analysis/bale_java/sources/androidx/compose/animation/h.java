package androidx.compose.animation;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.C14638iE6;
import ir.nasim.C14865ic6;
import ir.nasim.C15866kJ0;
import ir.nasim.C22094uf2;
import ir.nasim.C3432Av7;
import ir.nasim.ED1;

/* loaded from: classes.dex */
public abstract class h {
    public static final a a = new a(null);
    private static final h b = new i(new C3432Av7(null, null, null, null, false, null, 63, null));

    public static final class a {
        private a() {
        }

        public final h a() {
            return h.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ h(ED1 ed1) {
        this();
    }

    public abstract C3432Av7 b();

    public final h c(h hVar) {
        C22094uf2 c22094uf2C = hVar.b().c();
        if (c22094uf2C == null) {
            c22094uf2C = b().c();
        }
        C22094uf2 c22094uf2 = c22094uf2C;
        C14638iE6 c14638iE6F = hVar.b().f();
        if (c14638iE6F == null) {
            c14638iE6F = b().f();
        }
        C14638iE6 c14638iE6 = c14638iE6F;
        C15866kJ0 c15866kJ0A = hVar.b().a();
        if (c15866kJ0A == null) {
            c15866kJ0A = b().a();
        }
        C15866kJ0 c15866kJ0 = c15866kJ0A;
        C14865ic6 c14865ic6E = hVar.b().e();
        if (c14865ic6E == null) {
            c14865ic6E = b().e();
        }
        return new i(new C3432Av7(c22094uf2, c14638iE6, c15866kJ0, c14865ic6E, false, AbstractC20051rO3.t(b().b(), hVar.b().b()), 16, null));
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && AbstractC13042fc3.d(((h) obj).b(), b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        if (AbstractC13042fc3.d(this, b)) {
            return "EnterTransition.None";
        }
        C3432Av7 c3432Av7B = b();
        StringBuilder sb = new StringBuilder();
        sb.append("EnterTransition: \nFade - ");
        C22094uf2 c22094uf2C = c3432Av7B.c();
        sb.append(c22094uf2C != null ? c22094uf2C.toString() : null);
        sb.append(",\nSlide - ");
        C14638iE6 c14638iE6F = c3432Av7B.f();
        sb.append(c14638iE6F != null ? c14638iE6F.toString() : null);
        sb.append(",\nShrink - ");
        C15866kJ0 c15866kJ0A = c3432Av7B.a();
        sb.append(c15866kJ0A != null ? c15866kJ0A.toString() : null);
        sb.append(",\nScale - ");
        C14865ic6 c14865ic6E = c3432Av7B.e();
        sb.append(c14865ic6E != null ? c14865ic6E.toString() : null);
        return sb.toString();
    }

    private h() {
    }
}
