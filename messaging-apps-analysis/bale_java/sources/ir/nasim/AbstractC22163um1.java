package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.um1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22163um1 extends E90 {
    private final InterfaceC11938do1 _context;
    private transient InterfaceC20295rm1 intercepted;

    public AbstractC22163um1(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC11938do1 interfaceC11938do1) {
        super(interfaceC20295rm1);
        this._context = interfaceC11938do1;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        InterfaceC11938do1 interfaceC11938do1 = this._context;
        AbstractC13042fc3.f(interfaceC11938do1);
        return interfaceC11938do1;
    }

    public final InterfaceC20295rm1 intercepted() {
        InterfaceC20295rm1 interfaceC20295rm1M0 = this.intercepted;
        if (interfaceC20295rm1M0 == null) {
            InterfaceC22753vm1 interfaceC22753vm1 = (InterfaceC22753vm1) getContext().a(InterfaceC22753vm1.g0);
            if (interfaceC22753vm1 == null || (interfaceC20295rm1M0 = interfaceC22753vm1.m0(this)) == null) {
                interfaceC20295rm1M0 = this;
            }
            this.intercepted = interfaceC20295rm1M0;
        }
        return interfaceC20295rm1M0;
    }

    @Override // ir.nasim.E90
    protected void releaseIntercepted() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.intercepted;
        if (interfaceC20295rm1 != null && interfaceC20295rm1 != this) {
            InterfaceC11938do1.b bVarA = getContext().a(InterfaceC22753vm1.g0);
            AbstractC13042fc3.f(bVarA);
            ((InterfaceC22753vm1) bVarA).u(interfaceC20295rm1);
        }
        this.intercepted = A01.a;
    }

    public AbstractC22163um1(InterfaceC20295rm1 interfaceC20295rm1) {
        this(interfaceC20295rm1, interfaceC20295rm1 != null ? interfaceC20295rm1.getContext() : null);
    }
}
