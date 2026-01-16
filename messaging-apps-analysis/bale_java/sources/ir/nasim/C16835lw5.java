package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.lw5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16835lw5 {
    private C6517Nv5 a;

    private C16835lw5(C6517Nv5 c6517Nv5) {
        this.a = c6517Nv5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(ArrayList arrayList, int i, Boolean[] boolArr, C6517Nv5[] c6517Nv5Arr, JB3 jb3, C7234Qv5 c7234Qv5, Object obj) {
        arrayList.set(i, obj);
        boolArr[i] = Boolean.TRUE;
        for (int i2 = 0; i2 < c6517Nv5Arr.length; i2++) {
            Boolean bool = boolArr[i2];
            if (bool == null || !bool.booleanValue()) {
                return;
            }
        }
        ((C6517Nv5) jb3.a(arrayList)).i0(c7234Qv5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(final JB3 jb3, final C7234Qv5 c7234Qv5, final C6517Nv5[] c6517Nv5Arr) {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c6517Nv5Arr.length; i++) {
            arrayList.add(null);
        }
        final Boolean[] boolArr = new Boolean[c6517Nv5Arr.length];
        for (int i2 = 0; i2 < c6517Nv5Arr.length; i2++) {
            final int i3 = i2;
            c6517Nv5Arr[i2].m0(new InterfaceC24449ye1() { // from class: ir.nasim.Uv5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C16835lw5.D(arrayList, i3, boolArr, c6517Nv5Arr, jb3, c7234Qv5, obj);
                }
            });
            c6517Nv5Arr[i2].E(new InterfaceC24449ye1() { // from class: ir.nasim.cw5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    c7234Qv5.a((Exception) obj);
                }
            });
        }
        if (c6517Nv5Arr.length == 0) {
            ((C6517Nv5) jb3.a(arrayList)).i0(c7234Qv5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(final JB3 jb3, final C7234Qv5 c7234Qv5) {
        this.a.m0(new InterfaceC24449ye1() { // from class: ir.nasim.aw5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C16835lw5.F(jb3, c7234Qv5, (C6517Nv5[]) obj);
            }
        });
        this.a.E(new InterfaceC24449ye1() { // from class: ir.nasim.bw5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    private C16835lw5 J(final InterfaceC17569nB2 interfaceC17569nB2) {
        return new C16835lw5(new InterfaceC6990Pv5() { // from class: ir.nasim.Xv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.y(interfaceC17569nB2, c7234Qv5);
            }
        });
    }

    public static C16835lw5 K(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(C6517Nv5.l0(it.next()));
        }
        final C6517Nv5[] c6517Nv5Arr = (C6517Nv5[]) arrayList.toArray(new C6517Nv5[arrayList.size()]);
        return new C16835lw5(new InterfaceC6990Pv5() { // from class: ir.nasim.Zv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                c7234Qv5.b(c6517Nv5Arr);
            }
        });
    }

    public static C16835lw5 L(C6517Nv5... c6517Nv5Arr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, c6517Nv5Arr);
        final C6517Nv5[] c6517Nv5Arr2 = (C6517Nv5[]) arrayList.toArray(new C6517Nv5[arrayList.size()]);
        return new C16835lw5(new InterfaceC6990Pv5() { // from class: ir.nasim.jw5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                c7234Qv5.b(c6517Nv5Arr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5, Object obj) {
        C6517Nv5 c6517Nv5 = (C6517Nv5) interfaceC17569nB2.apply(obj);
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.hw5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                c7234Qv5.b(obj2);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.iw5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                c7234Qv5.a((Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(C6517Nv5 c6517Nv5, final InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5) {
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.fw5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C16835lw5.t(interfaceC17569nB2, c7234Qv5, obj);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.gw5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 w(final InterfaceC17569nB2 interfaceC17569nB2, final C6517Nv5 c6517Nv5) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Yv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C16835lw5.v(c6517Nv5, interfaceC17569nB2, c7234Qv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(final InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5) {
        this.a.m0(new InterfaceC24449ye1() { // from class: ir.nasim.dw5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C16835lw5.z(interfaceC17569nB2, c7234Qv5, (C6517Nv5[]) obj);
            }
        });
        this.a.E(new InterfaceC24449ye1() { // from class: ir.nasim.ew5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(InterfaceC17569nB2 interfaceC17569nB2, C7234Qv5 c7234Qv5, C6517Nv5[] c6517Nv5Arr) {
        int length = c6517Nv5Arr.length;
        C6517Nv5[] c6517Nv5Arr2 = new C6517Nv5[length];
        for (int i = 0; i < length; i++) {
            c6517Nv5Arr2[i] = (C6517Nv5) interfaceC17569nB2.apply(c6517Nv5Arr[i]);
        }
        c7234Qv5.b(c6517Nv5Arr2);
    }

    public C16835lw5 I(final InterfaceC17569nB2 interfaceC17569nB2) {
        return J(new InterfaceC17569nB2() { // from class: ir.nasim.Vv5
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C16835lw5.w(interfaceC17569nB2, (C6517Nv5) obj);
            }
        });
    }

    public C6517Nv5 M() {
        return N(new JB3() { // from class: ir.nasim.kw5
            @Override // ir.nasim.JB3
            public final Object a(List list) {
                return C6517Nv5.l0(list);
            }
        });
    }

    public C6517Nv5 N(final JB3 jb3) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Wv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.H(jb3, c7234Qv5);
            }
        });
    }

    private C16835lw5(InterfaceC6990Pv5 interfaceC6990Pv5) {
        this(new C6517Nv5(interfaceC6990Pv5));
    }
}
