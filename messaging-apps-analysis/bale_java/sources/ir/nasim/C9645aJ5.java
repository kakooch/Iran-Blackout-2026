package ir.nasim;

/* renamed from: ir.nasim.aJ5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C9645aJ5 extends C1 {
    private final InterfaceC12795fB1 d;
    private final InterfaceC10239bJ5 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9645aJ5(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC4356Eu interfaceC4356Eu) {
        super(interfaceC4356Eu);
        if (interfaceC12795fB1 == null) {
            x(0);
        }
        if (interfaceC10239bJ5 == null) {
            x(1);
        }
        if (interfaceC4356Eu == null) {
            x(2);
        }
        this.d = interfaceC12795fB1;
        this.e = interfaceC10239bJ5;
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "value";
        } else if (i == 2) {
            objArr[0] = "annotations";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 3 && i != 4) {
            if (i != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public InterfaceC12795fB1 b() {
        InterfaceC12795fB1 interfaceC12795fB1 = this.d;
        if (interfaceC12795fB1 == null) {
            x(4);
        }
        return interfaceC12795fB1;
    }

    @Override // ir.nasim.ZI5
    public InterfaceC10239bJ5 getValue() {
        InterfaceC10239bJ5 interfaceC10239bJ5 = this.e;
        if (interfaceC10239bJ5 == null) {
            x(3);
        }
        return interfaceC10239bJ5;
    }
}
