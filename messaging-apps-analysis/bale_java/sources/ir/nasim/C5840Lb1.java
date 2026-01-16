package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Lb1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5840Lb1 implements InterfaceC4356Eu {
    private final List a;

    /* renamed from: ir.nasim.Lb1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9424Zw2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C9424Zw2 c9424Zw2) {
            super(1);
            this.e = c9424Zw2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21651tu invoke(InterfaceC4356Eu interfaceC4356Eu) {
            AbstractC13042fc3.i(interfaceC4356Eu, "it");
            return interfaceC4356Eu.z(this.e);
        }
    }

    /* renamed from: ir.nasim.Lb1$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC23384wp6 invoke(InterfaceC4356Eu interfaceC4356Eu) {
            AbstractC13042fc3.i(interfaceC4356Eu, "it");
            return AbstractC15401jX0.g0(interfaceC4356Eu);
        }
    }

    public C5840Lb1(List list) {
        AbstractC13042fc3.i(list, "delegates");
        this.a = list;
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean M1(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        Iterator it = AbstractC15401jX0.g0(this.a).iterator();
        while (it.hasNext()) {
            if (((InterfaceC4356Eu) it.next()).M1(c9424Zw2)) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean isEmpty() {
        List list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((InterfaceC4356Eu) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return AbstractC11342cq6.w(AbstractC15401jX0.g0(this.a), b.e).iterator();
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public InterfaceC21651tu z(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return (InterfaceC21651tu) AbstractC11342cq6.v(AbstractC11342cq6.E(AbstractC15401jX0.g0(this.a), new a(c9424Zw2)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5840Lb1(InterfaceC4356Eu... interfaceC4356EuArr) {
        this(AbstractC10242bK.f1(interfaceC4356EuArr));
        AbstractC13042fc3.i(interfaceC4356EuArr, "delegates");
    }
}
