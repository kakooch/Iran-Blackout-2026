package ir.nasim;

/* loaded from: classes8.dex */
public abstract class IQ7 extends GQ7 {
    private final boolean f;
    protected InterfaceC20580sF4 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IQ7(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, AbstractC4099Dr3 abstractC4099Dr3, boolean z, JH6 jh6) {
        super(interfaceC12795fB1, interfaceC4356Eu, c6432No4, abstractC4099Dr3, jh6);
        if (interfaceC12795fB1 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (c6432No4 == null) {
            x(2);
        }
        if (jh6 == null) {
            x(3);
        }
        this.f = z;
    }

    private static /* synthetic */ void x(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void J0(InterfaceC20580sF4 interfaceC20580sF4) {
        if (interfaceC20580sF4 == null) {
            x(4);
        }
        this.g = interfaceC20580sF4;
    }

    @Override // ir.nasim.FQ7
    public boolean P() {
        return this.f;
    }

    @Override // ir.nasim.FQ7
    public AbstractC7068Qd1 o0() {
        InterfaceC20580sF4 interfaceC20580sF4 = this.g;
        if (interfaceC20580sF4 != null) {
            return (AbstractC7068Qd1) interfaceC20580sF4.invoke();
        }
        return null;
    }
}
