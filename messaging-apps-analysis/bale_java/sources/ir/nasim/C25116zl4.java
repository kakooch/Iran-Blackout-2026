package ir.nasim;

import ir.nasim.AbstractC9998au2;
import ir.nasim.C13245fu;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.zl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25116zl4 implements InterfaceC12378eW4 {
    private final C13245fu a;
    private final List b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;
    private final List e;

    /* renamed from: ir.nasim.zl4$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            Object obj;
            InterfaceC12378eW4 interfaceC12378eW4B;
            List listF = C25116zl4.this.f();
            if (listF.isEmpty()) {
                obj = null;
            } else {
                Object obj2 = listF.get(0);
                float fC = ((C11735dW4) obj2).b().c();
                int iO = AbstractC10360bX0.o(listF);
                int i = 1;
                if (1 <= iO) {
                    while (true) {
                        Object obj3 = listF.get(i);
                        float fC2 = ((C11735dW4) obj3).b().c();
                        if (Float.compare(fC, fC2) < 0) {
                            obj2 = obj3;
                            fC = fC2;
                        }
                        if (i == iO) {
                            break;
                        }
                        i++;
                    }
                }
                obj = obj2;
            }
            C11735dW4 c11735dW4 = (C11735dW4) obj;
            return Float.valueOf((c11735dW4 == null || (interfaceC12378eW4B = c11735dW4.b()) == null) ? 0.0f : interfaceC12378eW4B.c());
        }
    }

    /* renamed from: ir.nasim.zl4$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            Object obj;
            InterfaceC12378eW4 interfaceC12378eW4B;
            List listF = C25116zl4.this.f();
            if (listF.isEmpty()) {
                obj = null;
            } else {
                Object obj2 = listF.get(0);
                float fE = ((C11735dW4) obj2).b().e();
                int iO = AbstractC10360bX0.o(listF);
                int i = 1;
                if (1 <= iO) {
                    while (true) {
                        Object obj3 = listF.get(i);
                        float fE2 = ((C11735dW4) obj3).b().e();
                        if (Float.compare(fE, fE2) < 0) {
                            obj2 = obj3;
                            fE = fE2;
                        }
                        if (i == iO) {
                            break;
                        }
                        i++;
                    }
                }
                obj = obj2;
            }
            C11735dW4 c11735dW4 = (C11735dW4) obj;
            return Float.valueOf((c11735dW4 == null || (interfaceC12378eW4B = c11735dW4.b()) == null) ? 0.0f : interfaceC12378eW4B.e());
        }
    }

    public C25116zl4(C13245fu c13245fu, C9348Zn7 c9348Zn7, List list, WH1 wh1, AbstractC9998au2.b bVar) {
        this.a = c13245fu;
        this.b = list;
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.c = AbstractC13269fw3.b(enumC4870Gx3, new b());
        this.d = AbstractC13269fw3.b(enumC4870Gx3, new a());
        C15396jW4 c15396jW4M = c9348Zn7.M();
        List listJ = AbstractC13836gu.j(c13245fu, c15396jW4M);
        ArrayList arrayList = new ArrayList(listJ.size());
        int size = listJ.size();
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) listJ.get(i);
            C13245fu c13245fuK = AbstractC13836gu.k(c13245fu, dVar.h(), dVar.f());
            C15396jW4 c15396jW4H = h((C15396jW4) dVar.g(), c15396jW4M);
            String strK = c13245fuK.k();
            C9348Zn7 c9348Zn7I = c9348Zn7.I(c15396jW4H);
            List listC = c13245fuK.c();
            if (listC == null) {
                listC = AbstractC10360bX0.m();
            }
            arrayList.add(new C11735dW4(AbstractC12987fW4.a(strK, c9348Zn7I, listC, wh1, bVar, AbstractC3339Al4.b(g(), dVar.h(), dVar.f())), dVar.h(), dVar.f()));
        }
        this.e = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15396jW4 h(C15396jW4 c15396jW4, C15396jW4 c15396jW42) {
        return !C4049Dl7.j(c15396jW4.i(), C4049Dl7.b.f()) ? c15396jW4 : c15396jW4.a((509 & 1) != 0 ? c15396jW4.a : 0, (509 & 2) != 0 ? c15396jW4.b : c15396jW42.i(), (509 & 4) != 0 ? c15396jW4.c : 0L, (509 & 8) != 0 ? c15396jW4.d : null, (509 & 16) != 0 ? c15396jW4.e : null, (509 & 32) != 0 ? c15396jW4.f : null, (509 & 64) != 0 ? c15396jW4.g : 0, (509 & 128) != 0 ? c15396jW4.h : 0, (509 & 256) != 0 ? c15396jW4.i : null);
    }

    @Override // ir.nasim.InterfaceC12378eW4
    public boolean a() {
        List list = this.e;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((C11735dW4) list.get(i)).b().a()) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC12378eW4
    public float c() {
        return ((Number) this.d.getValue()).floatValue();
    }

    public final C13245fu d() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC12378eW4
    public float e() {
        return ((Number) this.c.getValue()).floatValue();
    }

    public final List f() {
        return this.e;
    }

    public final List g() {
        return this.b;
    }
}
