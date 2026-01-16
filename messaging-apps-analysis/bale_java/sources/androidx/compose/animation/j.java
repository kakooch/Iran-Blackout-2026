package androidx.compose.animation;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.C14638iE6;
import ir.nasim.C14865ic6;
import ir.nasim.C15866kJ0;
import ir.nasim.C22094uf2;
import ir.nasim.C3432Av7;
import ir.nasim.ED1;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class j {
    public static final a a = new a(null);
    private static final j b;
    private static final j c;

    public static final class a {
        private a() {
        }

        public final j a() {
            return j.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        ED1 ed1 = null;
        C22094uf2 c22094uf2 = null;
        C14638iE6 c14638iE6 = null;
        C15866kJ0 c15866kJ0 = null;
        C14865ic6 c14865ic6 = null;
        Map map = null;
        b = new k(new C3432Av7(c22094uf2, c14638iE6, c15866kJ0, c14865ic6, false, map, 63, ed1));
        c = new k(new C3432Av7(c22094uf2, c14638iE6, c15866kJ0, c14865ic6, true, map, 47, ed1));
    }

    public /* synthetic */ j(ED1 ed1) {
        this();
    }

    public abstract C3432Av7 b();

    public final j c(j jVar) {
        C22094uf2 c22094uf2C = jVar.b().c();
        if (c22094uf2C == null) {
            c22094uf2C = b().c();
        }
        C22094uf2 c22094uf2 = c22094uf2C;
        C14638iE6 c14638iE6F = jVar.b().f();
        if (c14638iE6F == null) {
            c14638iE6F = b().f();
        }
        C14638iE6 c14638iE6 = c14638iE6F;
        C15866kJ0 c15866kJ0A = jVar.b().a();
        if (c15866kJ0A == null) {
            c15866kJ0A = b().a();
        }
        C15866kJ0 c15866kJ0 = c15866kJ0A;
        C14865ic6 c14865ic6E = jVar.b().e();
        if (c14865ic6E == null) {
            c14865ic6E = b().e();
        }
        return new k(new C3432Av7(c22094uf2, c14638iE6, c15866kJ0, c14865ic6E, jVar.b().d() || b().d(), AbstractC20051rO3.t(b().b(), jVar.b().b())));
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && AbstractC13042fc3.d(((j) obj).b(), b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        if (AbstractC13042fc3.d(this, b)) {
            return "ExitTransition.None";
        }
        if (AbstractC13042fc3.d(this, c)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        C3432Av7 c3432Av7B = b();
        StringBuilder sb = new StringBuilder();
        sb.append("ExitTransition: \nFade - ");
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
        sb.append(",\nKeepUntilTransitionsFinished - ");
        sb.append(c3432Av7B.d());
        return sb.toString();
    }

    private j() {
    }
}
