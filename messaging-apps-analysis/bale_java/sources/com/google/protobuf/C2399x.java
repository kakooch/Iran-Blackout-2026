package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.C;
import com.google.protobuf.P;
import com.google.protobuf.r0;
import ir.nasim.U64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2399x {
    private static final C2399x d = new C2399x(true);
    private final h0 a;
    private boolean b;
    private boolean c;

    /* renamed from: com.google.protobuf.x$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[r0.b.values().length];
            b = iArr;
            try {
                iArr[r0.b.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[r0.b.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[r0.b.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[r0.b.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[r0.b.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[r0.b.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[r0.b.i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[r0.b.j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[r0.b.l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[r0.b.m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[r0.b.k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[r0.b.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[r0.b.o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[r0.b.q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[r0.b.r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[r0.b.s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[r0.b.t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[r0.b.p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[r0.c.values().length];
            a = iArr2;
            try {
                iArr2[r0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[r0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[r0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[r0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[r0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[r0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[r0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[r0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[r0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* renamed from: com.google.protobuf.x$b */
    public interface b extends Comparable {
        boolean b();

        r0.b e();

        boolean f();

        int getNumber();

        r0.c k();

        P.a l(P.a aVar, P p);
    }

    private C2399x() {
        this.a = h0.t(16);
    }

    public static C2399x A() {
        return new C2399x();
    }

    public static Object B(AbstractC2384h abstractC2384h, r0.b bVar, boolean z) {
        return z ? r0.d(abstractC2384h, bVar, r0.d.b) : r0.d(abstractC2384h, bVar, r0.d.a);
    }

    private void D(b bVar, Object obj) {
        if (!v(bVar.e(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.getNumber()), bVar.e().a(), obj.getClass().getName()));
        }
    }

    static void E(CodedOutputStream codedOutputStream, r0.b bVar, int i, Object obj) {
        if (bVar == r0.b.l) {
            codedOutputStream.x0(i, (P) obj);
        } else {
            codedOutputStream.T0(i, o(bVar, false));
            F(codedOutputStream, bVar, obj);
        }
    }

    static void F(CodedOutputStream codedOutputStream, r0.b bVar, Object obj) {
        switch (a.b[bVar.ordinal()]) {
            case 1:
                codedOutputStream.o0(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.w0(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.E0(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.X0(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.C0(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.u0(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.s0(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.i0(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.z0((P) obj);
                break;
            case 10:
                codedOutputStream.G0((P) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC2383g)) {
                    codedOutputStream.S0((String) obj);
                    break;
                } else {
                    codedOutputStream.m0((AbstractC2383g) obj);
                    break;
                }
            case 12:
                if (!(obj instanceof AbstractC2383g)) {
                    codedOutputStream.j0((byte[]) obj);
                    break;
                } else {
                    codedOutputStream.m0((AbstractC2383g) obj);
                    break;
                }
            case 13:
                codedOutputStream.V0(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.K0(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.M0(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.O0(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.Q0(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof B.c)) {
                    codedOutputStream.q0(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.q0(((B.c) obj).getNumber());
                    break;
                }
        }
    }

    private static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int d(r0.b bVar, int i, Object obj) {
        int iS = CodedOutputStream.S(i);
        if (bVar == r0.b.l) {
            iS *= 2;
        }
        return iS + e(bVar, obj);
    }

    static int e(r0.b bVar, Object obj) {
        switch (a.b[bVar.ordinal()]) {
            case 1:
                return CodedOutputStream.k(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.s(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.z(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.W(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.o(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.f(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.u((P) obj);
            case 10:
                return CodedOutputStream.E((P) obj);
            case 11:
                return obj instanceof AbstractC2383g ? CodedOutputStream.i((AbstractC2383g) obj) : CodedOutputStream.R((String) obj);
            case 12:
                return obj instanceof AbstractC2383g ? CodedOutputStream.i((AbstractC2383g) obj) : CodedOutputStream.g((byte[]) obj);
            case 13:
                return CodedOutputStream.U(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.J(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.L(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.N(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.P(((Long) obj).longValue());
            case 18:
                return obj instanceof B.c ? CodedOutputStream.m(((B.c) obj).getNumber()) : CodedOutputStream.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b bVar, Object obj) {
        r0.b bVarE = bVar.e();
        int number = bVar.getNumber();
        if (!bVar.b()) {
            return d(bVarE, number, obj);
        }
        List list = (List) obj;
        int iD = 0;
        if (!bVar.f()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iD += d(bVarE, number, it.next());
            }
            return iD;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iD += e(bVarE, it2.next());
        }
        return CodedOutputStream.S(number) + iD + CodedOutputStream.U(iD);
    }

    public static C2399x h() {
        return d;
    }

    private int k(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        return (bVar.k() != r0.c.MESSAGE || bVar.b() || bVar.f()) ? f(bVar, value) : CodedOutputStream.B(((b) entry.getKey()).getNumber(), (P) value);
    }

    static int o(r0.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.j();
    }

    private static boolean t(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        if (bVar.k() != r0.c.MESSAGE) {
            return true;
        }
        if (!bVar.b()) {
            return u(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!u(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean u(Object obj) {
        if (obj instanceof U64) {
            return ((U64) obj).isInitialized();
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean v(r0.b bVar, Object obj) {
        B.a(obj);
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
                return (obj instanceof AbstractC2383g) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof B.c);
            case 9:
                return obj instanceof P;
            default:
                return false;
        }
    }

    private void z(Map.Entry entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (bVar.b()) {
            Object objI = i(bVar);
            if (objI == null) {
                objI = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objI).add(c(it.next()));
            }
            this.a.put(bVar, objI);
            return;
        }
        if (bVar.k() != r0.c.MESSAGE) {
            this.a.put(bVar, c(value));
            return;
        }
        Object objI2 = i(bVar);
        if (objI2 == null) {
            this.a.put(bVar, c(value));
        } else {
            this.a.put(bVar, bVar.l(((P) objI2).toBuilder(), (P) value).a());
        }
    }

    public void C(b bVar, Object obj) {
        if (!bVar.b()) {
            D(bVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                D(bVar, it.next());
            }
            obj = arrayList;
        }
        this.a.put(bVar, obj);
    }

    public void a(b bVar, Object obj) {
        List arrayList;
        if (!bVar.b()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        D(bVar, obj);
        Object objI = i(bVar);
        if (objI == null) {
            arrayList = new ArrayList();
            this.a.put(bVar, arrayList);
        } else {
            arrayList = (List) objI;
        }
        arrayList.add(obj);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2399x clone() {
        C2399x c2399xA = A();
        for (int i = 0; i < this.a.l(); i++) {
            Map.Entry entryK = this.a.k(i);
            c2399xA.C((b) entryK.getKey(), entryK.getValue());
        }
        for (Map.Entry entry : this.a.o()) {
            c2399xA.C((b) entry.getKey(), entry.getValue());
        }
        c2399xA.c = this.c;
        return c2399xA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2399x) {
            return this.a.equals(((C2399x) obj).a);
        }
        return false;
    }

    Iterator g() {
        return this.c ? new C.b(this.a.i().iterator()) : this.a.i().iterator();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Object i(b bVar) {
        return this.a.get(bVar);
    }

    public int j() {
        int iK = 0;
        for (int i = 0; i < this.a.l(); i++) {
            iK += k(this.a.k(i));
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            iK += k((Map.Entry) it.next());
        }
        return iK;
    }

    public Object l(b bVar, int i) {
        if (!bVar.b()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object objI = i(bVar);
        if (objI != null) {
            return ((List) objI).get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int m(b bVar) {
        if (!bVar.b()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object objI = i(bVar);
        if (objI == null) {
            return 0;
        }
        return ((List) objI).size();
    }

    public int n() {
        int iF = 0;
        for (int i = 0; i < this.a.l(); i++) {
            Map.Entry entryK = this.a.k(i);
            iF += f((b) entryK.getKey(), entryK.getValue());
        }
        for (Map.Entry entry : this.a.o()) {
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean p(b bVar) {
        if (bVar.b()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.a.get(bVar) != null;
    }

    boolean q() {
        return this.a.isEmpty();
    }

    public boolean r() {
        return this.b;
    }

    public boolean s() {
        for (int i = 0; i < this.a.l(); i++) {
            if (!t(this.a.k(i))) {
                return false;
            }
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            if (!t((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator w() {
        return this.c ? new C.b(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public void x() {
        if (this.b) {
            return;
        }
        for (int i = 0; i < this.a.l(); i++) {
            Map.Entry entryK = this.a.k(i);
            if (entryK.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) entryK.getValue()).makeImmutable();
            }
        }
        this.a.s();
        this.b = true;
    }

    public void y(C2399x c2399x) {
        for (int i = 0; i < c2399x.a.l(); i++) {
            z(c2399x.a.k(i));
        }
        Iterator it = c2399x.a.o().iterator();
        while (it.hasNext()) {
            z((Map.Entry) it.next());
        }
    }

    private C2399x(boolean z) {
        this(h0.t(0));
        x();
    }

    private C2399x(h0 h0Var) {
        this.a = h0Var;
        x();
    }
}
