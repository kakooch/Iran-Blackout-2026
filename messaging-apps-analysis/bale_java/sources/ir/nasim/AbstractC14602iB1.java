package ir.nasim;

/* renamed from: ir.nasim.iB1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14602iB1 extends AbstractC13413gB1 implements InterfaceC14004hB1 {
    private final InterfaceC12795fB1 c;
    private final JH6 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected AbstractC14602iB1(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, JH6 jh6) {
        super(interfaceC4356Eu, c6432No4);
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
        this.c = interfaceC12795fB1;
        this.d = jh6;
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5 && i != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public InterfaceC12795fB1 b() {
        InterfaceC12795fB1 interfaceC12795fB1 = this.c;
        if (interfaceC12795fB1 == null) {
            x(5);
        }
        return interfaceC12795fB1;
    }

    public JH6 i() {
        JH6 jh6 = this.d;
        if (jh6 == null) {
            x(6);
        }
        return jh6;
    }

    @Override // ir.nasim.AbstractC13413gB1, ir.nasim.InterfaceC12795fB1
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public InterfaceC16386lB1 a() {
        InterfaceC16386lB1 interfaceC16386lB1 = (InterfaceC16386lB1) super.a();
        if (interfaceC16386lB1 == null) {
            x(4);
        }
        return interfaceC16386lB1;
    }
}
