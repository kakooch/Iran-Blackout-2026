package ir.nasim;

import ir.nasim.C12401eZ0;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.uF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21860uF7 extends AbstractC21707u0 {
    private C20378ru4 b;
    private final InterfaceC25225zw4[] c;
    private final C5126Hz7 d;
    private final D48[] e;
    private final FD7 f;

    public C21860uF7(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.b = new C20378ru4(c9057Yh4);
        this.c = new InterfaceC25225zw4[]{new C25243zy4(c9057Yh4), this.b, new C8890Xt4(c9057Yh4), new C7035Pz4(c9057Yh4), new C16213kt4(c9057Yh4), new B08(c9057Yh4), new C16814lu4(), new C5537Jt4(), new AN6(), new C3911Cw4(c9057Yh4)};
        C5126Hz7 c5126Hz7 = new C5126Hz7(c9057Yh4);
        this.d = c5126Hz7;
        this.e = new D48[]{c5126Hz7, new C22246uu4(c9057Yh4), new D08(c9057Yh4), new QZ0(c9057Yh4), new YH5(c9057Yh4), new K82(c9057Yh4)};
        this.f = ((InterfaceC13191fo5) I22.a(C5721Ko.b, InterfaceC13191fo5.class)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 K(C11458d25 c11458d25, List list) {
        return this.b.A(C9057Yh4.k(c11458d25), list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object M(Object obj) {
        return null;
    }

    public C6517Nv5 G(List list) {
        C12401eZ0 c12401eZ0A = MF2.a(new ArrayList(list));
        ArrayList arrayList = new ArrayList();
        for (C11458d25 c11458d25 : c12401eZ0A.e().keySet()) {
            final UE7 ue7 = new UE7(c11458d25, ((Long) c12401eZ0A.e().get(c11458d25)).longValue(), 0L);
            arrayList.add(new S17() { // from class: ir.nasim.oF7
                @Override // ir.nasim.S17
                public final Object get() {
                    return this.a.H(ue7);
                }
            });
        }
        for (C11458d25 c11458d252 : c12401eZ0A.c().keySet()) {
            final QE7 qe7 = new QE7(c11458d252, ((Long) c12401eZ0A.c().get(c11458d252)).longValue(), 0L);
            arrayList.add(new S17() { // from class: ir.nasim.pF7
                @Override // ir.nasim.S17
                public final Object get() {
                    return this.a.I(qe7);
                }
            });
        }
        for (C11458d25 c11458d253 : c12401eZ0A.d().keySet()) {
            C12401eZ0.a aVar = (C12401eZ0.a) c12401eZ0A.d().get(c11458d253);
            final RE7 re7 = new RE7(c11458d253, aVar.c(), Integer.valueOf(aVar.b()), Long.valueOf(aVar.d()));
            arrayList.add(new S17() { // from class: ir.nasim.qF7
                @Override // ir.nasim.S17
                public final Object get() {
                    return this.a.J(re7);
                }
            });
        }
        for (final C11458d25 c11458d254 : c12401eZ0A.a().keySet()) {
            final List list2 = (List) c12401eZ0A.a().get(c11458d254);
            if (list2 != null) {
                arrayList.add(new S17() { // from class: ir.nasim.rF7
                    @Override // ir.nasim.S17
                    public final Object get() {
                        return this.a.K(c11458d254, list2);
                    }
                });
            }
        }
        for (final AbstractC20556sC7 abstractC20556sC7 : c12401eZ0A.b()) {
            arrayList.add(new S17() { // from class: ir.nasim.sF7
                @Override // ir.nasim.S17
                public final Object get() {
                    return this.a.L(abstractC20556sC7);
                }
            });
        }
        return AbstractC7941Tv5.e(arrayList).h0(new InterfaceC17569nB2() { // from class: ir.nasim.tF7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C21860uF7.M(obj);
            }
        });
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C6517Nv5 L(AbstractC20556sC7 abstractC20556sC7) {
        if (abstractC20556sC7 instanceof CE7) {
            CE7 ce7 = (CE7) abstractC20556sC7;
            this.d.A(ce7.e(), ce7.i());
            this.f.d(abstractC20556sC7);
        }
        this.f.d(abstractC20556sC7);
        for (InterfaceC25225zw4 interfaceC25225zw4 : this.c) {
            C6517Nv5 c6517Nv5A = interfaceC25225zw4.a(abstractC20556sC7);
            if (c6517Nv5A != null) {
                return c6517Nv5A;
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    public void O(AbstractC20556sC7 abstractC20556sC7, long j) {
        this.f.d(abstractC20556sC7);
        D48[] d48Arr = this.e;
        int length = d48Arr.length;
        for (int i = 0; i < length && !d48Arr[i].d(abstractC20556sC7, j); i++) {
        }
    }
}
