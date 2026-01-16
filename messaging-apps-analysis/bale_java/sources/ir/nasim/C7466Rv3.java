package ir.nasim;

import ir.nasim.InterfaceC4356Eu;
import ir.nasim.PJ6;
import java.util.Iterator;

/* renamed from: ir.nasim.Rv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7466Rv3 implements InterfaceC4356Eu {
    private final C9182Yv3 a;
    private final InterfaceC5194Ih3 b;
    private final boolean c;
    private final J34 d;

    /* renamed from: ir.nasim.Rv3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21651tu invoke(InterfaceC4009Dh3 interfaceC4009Dh3) {
            AbstractC13042fc3.i(interfaceC4009Dh3, "annotation");
            return C4960Hh3.a.e(interfaceC4009Dh3, C7466Rv3.this.a, C7466Rv3.this.c);
        }
    }

    public C7466Rv3(C9182Yv3 c9182Yv3, InterfaceC5194Ih3 interfaceC5194Ih3, boolean z) {
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC5194Ih3, "annotationOwner");
        this.a = c9182Yv3;
        this.b = interfaceC5194Ih3;
        this.c = z;
        this.d = c9182Yv3.a().t().b(new a());
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean M1(C9424Zw2 c9424Zw2) {
        return InterfaceC4356Eu.b.b(this, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean isEmpty() {
        return this.b.getAnnotations().isEmpty() && !this.b.E();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return AbstractC11342cq6.t(AbstractC11342cq6.G(AbstractC11342cq6.C(AbstractC15401jX0.g0(this.b.getAnnotations()), this.d), C4960Hh3.a.a(PJ6.a.y, this.b, this.a))).iterator();
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public InterfaceC21651tu z(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        InterfaceC4009Dh3 interfaceC4009Dh3Z = this.b.z(c9424Zw2);
        InterfaceC21651tu interfaceC21651tu = interfaceC4009Dh3Z == null ? null : (InterfaceC21651tu) this.d.invoke(interfaceC4009Dh3Z);
        return interfaceC21651tu == null ? C4960Hh3.a.a(c9424Zw2, this.b, this.a) : interfaceC21651tu;
    }

    public /* synthetic */ C7466Rv3(C9182Yv3 c9182Yv3, InterfaceC5194Ih3 interfaceC5194Ih3, boolean z, int i, ED1 ed1) {
        this(c9182Yv3, interfaceC5194Ih3, (i & 4) != 0 ? false : z);
    }
}
