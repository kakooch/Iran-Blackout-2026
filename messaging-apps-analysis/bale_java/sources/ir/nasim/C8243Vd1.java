package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.EH6;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: ir.nasim.Vd1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8243Vd1 {
    private int b;
    private boolean c;
    public final C16651le1 d;
    public final b e;
    public C8243Vd1 f;
    EH6 i;
    private HashSet a = null;
    public int g = 0;
    int h = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: ir.nasim.Vd1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* renamed from: ir.nasim.Vd1$b */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public C8243Vd1(C16651le1 c16651le1, b bVar) {
        this.d = c16651le1;
        this.e = bVar;
    }

    public boolean a(C8243Vd1 c8243Vd1, int i) {
        return b(c8243Vd1, i, RecyclerView.UNDEFINED_DURATION, false);
    }

    public boolean b(C8243Vd1 c8243Vd1, int i, int i2, boolean z) {
        if (c8243Vd1 == null) {
            q();
            return true;
        }
        if (!z && !p(c8243Vd1)) {
            return false;
        }
        this.f = c8243Vd1;
        if (c8243Vd1.a == null) {
            c8243Vd1.a = new HashSet();
        }
        HashSet hashSet = this.f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
        return true;
    }

    public void c(int i, ArrayList arrayList, C14590i98 c14590i98) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AbstractC19459qO2.a(((C8243Vd1) it.next()).d, i, arrayList, c14590i98);
            }
        }
    }

    public HashSet d() {
        return this.a;
    }

    public int e() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public int f() {
        C8243Vd1 c8243Vd1;
        if (this.d.W() == 8) {
            return 0;
        }
        return (this.h == Integer.MIN_VALUE || (c8243Vd1 = this.f) == null || c8243Vd1.d.W() != 8) ? this.g : this.h;
    }

    public final C8243Vd1 g() {
        switch (a.a[this.e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.d.S;
            case 3:
                return this.d.Q;
            case 4:
                return this.d.T;
            case 5:
                return this.d.R;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public C16651le1 h() {
        return this.d;
    }

    public EH6 i() {
        return this.i;
    }

    public C8243Vd1 j() {
        return this.f;
    }

    public b k() {
        return this.e;
    }

    public boolean l() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((C8243Vd1) it.next()).g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet hashSet = this.a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.f != null;
    }

    public boolean p(C8243Vd1 c8243Vd1) {
        if (c8243Vd1 == null) {
            return false;
        }
        b bVarK = c8243Vd1.k();
        b bVar = this.e;
        if (bVarK == bVar) {
            return bVar != b.BASELINE || (c8243Vd1.h().a0() && h().a0());
        }
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return (bVarK == b.BASELINE || bVarK == b.CENTER_X || bVarK == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = bVarK == b.LEFT || bVarK == b.RIGHT;
                if (c8243Vd1.h() instanceof NS2) {
                    return z || bVarK == b.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = bVarK == b.TOP || bVarK == b.BOTTOM;
                if (c8243Vd1.h() instanceof NS2) {
                    return z2 || bVarK == b.CENTER_Y;
                }
                return z2;
            case 6:
                return (bVarK == b.LEFT || bVarK == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public void q() {
        HashSet hashSet;
        C8243Vd1 c8243Vd1 = this.f;
        if (c8243Vd1 != null && (hashSet = c8243Vd1.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = RecyclerView.UNDEFINED_DURATION;
        this.c = false;
        this.b = 0;
    }

    public void r() {
        this.c = false;
        this.b = 0;
    }

    public void s(C13196fp0 c13196fp0) {
        EH6 eh6 = this.i;
        if (eh6 == null) {
            this.i = new EH6(EH6.a.UNRESTRICTED, null);
        } else {
            eh6.o();
        }
    }

    public void t(int i) {
        this.b = i;
        this.c = true;
    }

    public String toString() {
        return this.d.v() + ":" + this.e.toString();
    }

    public void u(int i) {
        if (o()) {
            this.h = i;
        }
    }
}
