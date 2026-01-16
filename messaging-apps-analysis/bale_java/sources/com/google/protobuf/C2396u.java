package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.P;
import com.google.protobuf.r0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2396u extends AbstractC2395t {

    /* renamed from: com.google.protobuf.u$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.b.values().length];
            a = iArr;
            try {
                iArr[r0.b.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.b.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r0.b.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r0.b.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r0.b.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r0.b.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r0.b.i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r0.b.j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r0.b.o.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r0.b.q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r0.b.r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r0.b.s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r0.b.t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r0.b.p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r0.b.n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r0.b.k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r0.b.l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[r0.b.m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    C2396u() {
    }

    @Override // com.google.protobuf.AbstractC2395t
    int a(Map.Entry entry) {
        return ((GeneratedMessageLite.e) entry.getKey()).getNumber();
    }

    @Override // com.google.protobuf.AbstractC2395t
    Object b(C2394s c2394s, P p, int i) {
        return c2394s.a(p, i);
    }

    @Override // com.google.protobuf.AbstractC2395t
    C2399x c(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    @Override // com.google.protobuf.AbstractC2395t
    C2399x d(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).ensureExtensionsAreMutable();
    }

    @Override // com.google.protobuf.AbstractC2395t
    boolean e(P p) {
        return p instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.google.protobuf.AbstractC2395t
    void f(Object obj) {
        c(obj).x();
    }

    @Override // com.google.protobuf.AbstractC2395t
    Object g(Object obj, d0 d0Var, Object obj2, C2394s c2394s, C2399x c2399x, Object obj3, l0 l0Var) {
        Object objValueOf;
        Object objI;
        ArrayList arrayList;
        GeneratedMessageLite.f fVar = (GeneratedMessageLite.f) obj2;
        int iF = fVar.f();
        if (fVar.d.b() && fVar.d.f()) {
            switch (a.a[fVar.d().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    d0Var.F(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    d0Var.B(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    d0Var.h(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    d0Var.f(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    d0Var.v(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    d0Var.p(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    d0Var.w(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    d0Var.l(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    d0Var.s(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    d0Var.b(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    d0Var.u(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    d0Var.q(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    d0Var.c(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    d0Var.i(arrayList);
                    obj3 = g0.z(obj, iF, arrayList, fVar.d.h(), obj3, l0Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + fVar.d.e());
            }
            c2399x.C(fVar.d, arrayList);
        } else {
            if (fVar.d() != r0.b.p) {
                switch (a.a[fVar.d().ordinal()]) {
                    case 1:
                        objValueOf = Double.valueOf(d0Var.readDouble());
                        break;
                    case 2:
                        objValueOf = Float.valueOf(d0Var.readFloat());
                        break;
                    case 3:
                        objValueOf = Long.valueOf(d0Var.G());
                        break;
                    case 4:
                        objValueOf = Long.valueOf(d0Var.r());
                        break;
                    case 5:
                        objValueOf = Integer.valueOf(d0Var.o());
                        break;
                    case 6:
                        objValueOf = Long.valueOf(d0Var.a());
                        break;
                    case 7:
                        objValueOf = Integer.valueOf(d0Var.t());
                        break;
                    case 8:
                        objValueOf = Boolean.valueOf(d0Var.d());
                        break;
                    case 9:
                        objValueOf = Integer.valueOf(d0Var.g());
                        break;
                    case 10:
                        objValueOf = Integer.valueOf(d0Var.D());
                        break;
                    case 11:
                        objValueOf = Long.valueOf(d0Var.e());
                        break;
                    case 12:
                        objValueOf = Integer.valueOf(d0Var.k());
                        break;
                    case 13:
                        objValueOf = Long.valueOf(d0Var.x());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        objValueOf = d0Var.n();
                        break;
                    case 16:
                        objValueOf = d0Var.y();
                        break;
                    case 17:
                        if (!fVar.g()) {
                            Object objI2 = c2399x.i(fVar.d);
                            if (objI2 instanceof GeneratedMessageLite) {
                                e0 e0VarD = a0.a().d(objI2);
                                if (!((GeneratedMessageLite) objI2).isMutable()) {
                                    Object objD = e0VarD.d();
                                    e0VarD.a(objD, objI2);
                                    c2399x.C(fVar.d, objD);
                                    objI2 = objD;
                                }
                                d0Var.N(objI2, e0VarD, c2394s);
                                return obj3;
                            }
                        }
                        objValueOf = d0Var.K(fVar.e().getClass(), c2394s);
                        break;
                    case 18:
                        if (!fVar.g()) {
                            Object objI3 = c2399x.i(fVar.d);
                            if (objI3 instanceof GeneratedMessageLite) {
                                e0 e0VarD2 = a0.a().d(objI3);
                                if (!((GeneratedMessageLite) objI3).isMutable()) {
                                    Object objD2 = e0VarD2.d();
                                    e0VarD2.a(objD2, objI3);
                                    c2399x.C(fVar.d, objD2);
                                    objI3 = objD2;
                                }
                                d0Var.O(objI3, e0VarD2, c2394s);
                                return obj3;
                            }
                        }
                        objValueOf = d0Var.M(fVar.e().getClass(), c2394s);
                        break;
                    default:
                        objValueOf = null;
                        break;
                }
            } else {
                int iO = d0Var.o();
                if (fVar.d.h().a(iO) == null) {
                    return g0.L(obj, iF, iO, obj3, l0Var);
                }
                objValueOf = Integer.valueOf(iO);
            }
            if (fVar.g()) {
                c2399x.a(fVar.d, objValueOf);
            } else {
                int i = a.a[fVar.d().ordinal()];
                if ((i == 17 || i == 18) && (objI = c2399x.i(fVar.d)) != null) {
                    objValueOf = B.h(objI, objValueOf);
                }
                c2399x.C(fVar.d, objValueOf);
            }
        }
        return obj3;
    }

    @Override // com.google.protobuf.AbstractC2395t
    void h(d0 d0Var, Object obj, C2394s c2394s, C2399x c2399x) {
        GeneratedMessageLite.f fVar = (GeneratedMessageLite.f) obj;
        c2399x.C(fVar.d, d0Var.M(fVar.e().getClass(), c2394s));
    }

    @Override // com.google.protobuf.AbstractC2395t
    void i(AbstractC2383g abstractC2383g, Object obj, C2394s c2394s, C2399x c2399x) {
        GeneratedMessageLite.f fVar = (GeneratedMessageLite.f) obj;
        P.a aVarNewBuilderForType = fVar.e().newBuilderForType();
        AbstractC2384h abstractC2384hV = abstractC2383g.V();
        aVarNewBuilderForType.h(abstractC2384hV, c2394s);
        c2399x.C(fVar.d, aVarNewBuilderForType.j());
        abstractC2384hV.a(0);
    }

    @Override // com.google.protobuf.AbstractC2395t
    void j(s0 s0Var, Map.Entry entry) {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) entry.getKey();
        if (!eVar.b()) {
            switch (a.a[eVar.e().ordinal()]) {
                case 1:
                    s0Var.p(eVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    s0Var.B(eVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    s0Var.u(eVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    s0Var.f(eVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    s0Var.h(eVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    s0Var.s(eVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    s0Var.c(eVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    s0Var.v(eVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    s0Var.o(eVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    s0Var.w(eVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    s0Var.i(eVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    s0Var.H(eVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    s0Var.m(eVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    s0Var.h(eVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    s0Var.L(eVar.getNumber(), (AbstractC2383g) entry.getValue());
                    break;
                case 16:
                    s0Var.e(eVar.getNumber(), (String) entry.getValue());
                    break;
                case 17:
                    s0Var.K(eVar.getNumber(), entry.getValue(), a0.a().c(entry.getValue().getClass()));
                    break;
                case 18:
                    s0Var.N(eVar.getNumber(), entry.getValue(), a0.a().c(entry.getValue().getClass()));
                    break;
            }
        }
        switch (a.a[eVar.e().ordinal()]) {
            case 1:
                g0.P(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 2:
                g0.T(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 3:
                g0.W(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 4:
                g0.e0(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 5:
                g0.V(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 6:
                g0.S(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 7:
                g0.R(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 8:
                g0.N(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 9:
                g0.d0(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 10:
                g0.Y(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 11:
                g0.Z(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 12:
                g0.a0(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 13:
                g0.b0(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 14:
                g0.V(eVar.getNumber(), (List) entry.getValue(), s0Var, eVar.f());
                break;
            case 15:
                g0.O(eVar.getNumber(), (List) entry.getValue(), s0Var);
                break;
            case 16:
                g0.c0(eVar.getNumber(), (List) entry.getValue(), s0Var);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    g0.U(eVar.getNumber(), (List) entry.getValue(), s0Var, a0.a().c(list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    g0.X(eVar.getNumber(), (List) entry.getValue(), s0Var, a0.a().c(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }
}
