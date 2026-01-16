package ir.nasim;

/* renamed from: ir.nasim.cv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C11389cv3 extends C1 {
    private final InterfaceC21331tU0 d;
    private final C16319l43 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11389cv3(InterfaceC21331tU0 interfaceC21331tU0) {
        super(InterfaceC4356Eu.W.b());
        if (interfaceC21331tU0 == null) {
            x(0);
        }
        this.d = interfaceC21331tU0;
        this.e = new C16319l43(interfaceC21331tU0, null);
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public InterfaceC12795fB1 b() {
        InterfaceC21331tU0 interfaceC21331tU0 = this.d;
        if (interfaceC21331tU0 == null) {
            x(2);
        }
        return interfaceC21331tU0;
    }

    @Override // ir.nasim.ZI5
    public InterfaceC10239bJ5 getValue() {
        C16319l43 c16319l43 = this.e;
        if (c16319l43 == null) {
            x(1);
        }
        return c16319l43;
    }

    @Override // ir.nasim.AbstractC13413gB1
    public String toString() {
        return "class " + this.d.getName() + "::this";
    }
}
