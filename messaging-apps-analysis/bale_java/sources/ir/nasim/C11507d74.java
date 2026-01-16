package ir.nasim;

import java.util.ArrayList;
import java.util.Objects;

/* renamed from: ir.nasim.d74, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C11507d74 extends J44 implements Comparable {
    public String y;
    public ArrayList z;

    public C11507d74(J44 j44) {
        super(j44.i(), j44.W(), j44.h(), j44.U(), j44.L(), j44.F(), j44.R(), j44.G(), j44.Q());
        this.y = "";
        this.z = new ArrayList();
    }

    public static boolean w0(AbstractC18939pW1 abstractC18939pW1) {
        String str;
        return (abstractC18939pW1 == null || (str = abstractC18939pW1.d) == null || !C25056zf4.c(str)) ? false : true;
    }

    public static boolean y0(AbstractC18939pW1 abstractC18939pW1) {
        if (abstractC18939pW1 == null) {
            return false;
        }
        try {
            String str = abstractC18939pW1.d;
            if (str != null) {
                return C25056zf4.b(str);
            }
            return false;
        } catch (Exception e) {
            C19406qI3.d("MessageObject", e);
            return false;
        }
    }

    @Override // ir.nasim.J44
    public C24967zW1 H() {
        return F().f();
    }

    public String getFileName() {
        return C4044Dl2.n(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public int compareTo(C11507d74 c11507d74) {
        return Long.compare(W(), c11507d74.W());
    }

    public int q0() {
        if (v0()) {
            return 2;
        }
        if (x0()) {
            return 1;
        }
        if (F() instanceof C13388g85) {
            return 0;
        }
        return ((F() instanceof C24967zW1) || (F() instanceof C22149uk7)) ? 3 : 4;
    }

    public long r0() {
        return i();
    }

    public String s0() {
        if (H() == null) {
            return null;
        }
        return H().x();
    }

    public boolean t0() {
        if (H() == null) {
            return false;
        }
        try {
            if (H() instanceof J08) {
                return false;
            }
            C24967zW1 c24967zW1H = H();
            Objects.requireNonNull(c24967zW1H);
            return C25056zf4.b(c24967zW1H.x());
        } catch (Exception e) {
            C19406qI3.d("MessageObject", e);
            return false;
        }
    }

    public boolean u0() {
        return H() instanceof C13388g85;
    }

    public boolean v0() {
        if (H() == null) {
            return false;
        }
        return (H() instanceof GS7) || (H() instanceof XG2);
    }

    public boolean x0() {
        if (H() == null) {
            return false;
        }
        return H() instanceof J08;
    }

    public C11507d74(C18823pJ2 c18823pJ2) {
        super(c18823pJ2.i(), c18823pJ2.u(), c18823pJ2.r().longValue(), c18823pJ2.s(), EnumC23558x74.SENT, c18823pJ2.q(), new ArrayList(), 0, null);
        this.y = "";
        this.z = new ArrayList();
    }
}
