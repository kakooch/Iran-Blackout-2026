package ir.nasim;

/* renamed from: ir.nasim.uU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21988uU0 extends E0 {
    private final InterfaceC12795fB1 f;
    private final JH6 g;
    private final boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected AbstractC21988uU0(ON6 on6, InterfaceC12795fB1 interfaceC12795fB1, C6432No4 c6432No4, JH6 jh6, boolean z) {
        super(on6, c6432No4);
        if (on6 == null) {
            i0(0);
        }
        if (interfaceC12795fB1 == null) {
            i0(1);
        }
        if (c6432No4 == null) {
            i0(2);
        }
        if (jh6 == null) {
            i0(3);
        }
        this.f = interfaceC12795fB1;
        this.g = jh6;
        this.h = z;
    }

    private static /* synthetic */ void i0(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC14004hB1, ir.nasim.InterfaceC12795fB1
    public InterfaceC12795fB1 b() {
        InterfaceC12795fB1 interfaceC12795fB1 = this.f;
        if (interfaceC12795fB1 == null) {
            i0(4);
        }
        return interfaceC12795fB1;
    }

    @Override // ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        JH6 jh6 = this.g;
        if (jh6 == null) {
            i0(5);
        }
        return jh6;
    }

    public boolean isExternal() {
        return this.h;
    }
}
