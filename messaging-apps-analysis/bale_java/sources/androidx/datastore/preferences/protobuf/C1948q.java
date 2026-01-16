package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.g0;
import ir.nasim.AbstractC18350oW3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1948q {
    private static final C1948q d = new C1948q(true);
    private final Y a;
    private boolean b;
    private boolean c;

    /* renamed from: androidx.datastore.preferences.protobuf.q$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[g0.b.values().length];
            b = iArr;
            try {
                iArr[g0.b.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[g0.b.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[g0.b.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[g0.b.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[g0.b.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[g0.b.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[g0.b.i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[g0.b.j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[g0.b.l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[g0.b.m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[g0.b.k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[g0.b.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[g0.b.o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[g0.b.q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[g0.b.r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[g0.b.s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[g0.b.t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[g0.b.p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[g0.c.values().length];
            a = iArr2;
            try {
                iArr2[g0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[g0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[g0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[g0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[g0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[g0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[g0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[g0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[g0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.q$b */
    public interface b extends Comparable {
        boolean b();

        g0.b e();

        boolean f();

        int getNumber();
    }

    private C1948q() {
        this.a = Y.t(16);
    }

    static int b(g0.b bVar, int i, Object obj) {
        int iP = CodedOutputStream.P(i);
        if (bVar == g0.b.l) {
            iP *= 2;
        }
        return iP + c(bVar, obj);
    }

    static int c(g0.b bVar, Object obj) {
        switch (a.b[bVar.ordinal()]) {
            case 1:
                return CodedOutputStream.i(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.q(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.x(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.T(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.v(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.o(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.m(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.d(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.s((I) obj);
            case 10:
                return CodedOutputStream.A((I) obj);
            case 11:
                return obj instanceof AbstractC1937f ? CodedOutputStream.g((AbstractC1937f) obj) : CodedOutputStream.O((String) obj);
            case 12:
                return obj instanceof AbstractC1937f ? CodedOutputStream.g((AbstractC1937f) obj) : CodedOutputStream.e((byte[]) obj);
            case 13:
                return CodedOutputStream.R(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.G(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.I(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.K(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.M(((Long) obj).longValue());
            case 18:
                return CodedOutputStream.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        g0.b bVarE = bVar.e();
        int number = bVar.getNumber();
        if (!bVar.b()) {
            return b(bVarE, number, obj);
        }
        int iB = 0;
        if (bVar.f()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iB += c(bVarE, it.next());
            }
            return CodedOutputStream.P(number) + iB + CodedOutputStream.E(iB);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iB += b(bVarE, number, it2.next());
        }
        return iB;
    }

    private int g(Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    static int i(g0.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.j();
    }

    private static boolean l(Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        throw null;
    }

    private static boolean m(g0.b bVar, Object obj) {
        AbstractC1952v.a(obj);
        switch (a.a[bVar.a().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof AbstractC1937f) || (obj instanceof byte[]);
            case 8:
                return obj instanceof Integer;
            case 9:
                return obj instanceof I;
            default:
                return false;
        }
    }

    private void q(Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public static C1948q r() {
        return new C1948q();
    }

    private void t(g0.b bVar, Object obj) {
        if (!m(bVar, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    static void u(CodedOutputStream codedOutputStream, g0.b bVar, int i, Object obj) {
        if (bVar == g0.b.l) {
            codedOutputStream.r0(i, (I) obj);
        } else {
            codedOutputStream.N0(i, i(bVar, false));
            v(codedOutputStream, bVar, obj);
        }
    }

    static void v(CodedOutputStream codedOutputStream, g0.b bVar, Object obj) {
        switch (a.b[bVar.ordinal()]) {
            case 1:
                codedOutputStream.i0(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.q0(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.y0(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.R0(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.w0(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.o0(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.m0(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.c0(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.t0((I) obj);
                break;
            case 10:
                codedOutputStream.A0((I) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC1937f)) {
                    codedOutputStream.M0((String) obj);
                    break;
                } else {
                    codedOutputStream.g0((AbstractC1937f) obj);
                    break;
                }
            case 12:
                if (!(obj instanceof AbstractC1937f)) {
                    codedOutputStream.d0((byte[]) obj);
                    break;
                } else {
                    codedOutputStream.g0((AbstractC1937f) obj);
                    break;
                }
            case 13:
                codedOutputStream.P0(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.E0(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.G0(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.I0(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.K0(((Long) obj).longValue());
                break;
            case 18:
                codedOutputStream.k0(((Integer) obj).intValue());
                break;
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1948q clone() {
        C1948q c1948qR = r();
        for (int i = 0; i < this.a.l(); i++) {
            Map.Entry entryK = this.a.k(i);
            AbstractC18350oW3.a(entryK.getKey());
            c1948qR.s(null, entryK.getValue());
        }
        for (Map.Entry entry : this.a.o()) {
            AbstractC18350oW3.a(entry.getKey());
            c1948qR.s(null, entry.getValue());
        }
        c1948qR.c = this.c;
        return c1948qR;
    }

    Iterator e() {
        return this.c ? new C1953w(this.a.i().iterator()) : this.a.i().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1948q) {
            return this.a.equals(((C1948q) obj).a);
        }
        return false;
    }

    public int f() {
        int iG = 0;
        for (int i = 0; i < this.a.l(); i++) {
            iG += g(this.a.k(i));
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            iG += g((Map.Entry) it.next());
        }
        return iG;
    }

    public int h() {
        int iD = 0;
        for (int i = 0; i < this.a.l(); i++) {
            Map.Entry entryK = this.a.k(i);
            AbstractC18350oW3.a(entryK.getKey());
            iD += d(null, entryK.getValue());
        }
        for (Map.Entry entry : this.a.o()) {
            AbstractC18350oW3.a(entry.getKey());
            iD += d(null, entry.getValue());
        }
        return iD;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    boolean j() {
        return this.a.isEmpty();
    }

    public boolean k() {
        for (int i = 0; i < this.a.l(); i++) {
            if (!l(this.a.k(i))) {
                return false;
            }
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return this.c ? new C1953w(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public void o() {
        if (this.b) {
            return;
        }
        this.a.s();
        this.b = true;
    }

    public void p(C1948q c1948q) {
        for (int i = 0; i < c1948q.a.l(); i++) {
            q(c1948q.a.k(i));
        }
        Iterator it = c1948q.a.o().iterator();
        while (it.hasNext()) {
            q((Map.Entry) it.next());
        }
    }

    public void s(b bVar, Object obj) {
        if (!bVar.b()) {
            t(bVar.e(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                t(bVar.e(), it.next());
            }
            obj = arrayList;
        }
        this.a.u(bVar, obj);
    }

    private C1948q(boolean z) {
        this(Y.t(0));
        o();
    }

    private C1948q(Y y) {
        this.a = y;
        o();
    }
}
