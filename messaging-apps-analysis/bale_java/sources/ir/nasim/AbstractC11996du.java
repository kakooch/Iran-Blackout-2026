package ir.nasim;

/* renamed from: ir.nasim.du, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11996du implements InterfaceC10612bu {
    private final InterfaceC4356Eu a;

    public AbstractC11996du(InterfaceC4356Eu interfaceC4356Eu) {
        if (interfaceC4356Eu == null) {
            x(0);
        }
        this.a = interfaceC4356Eu;
    }

    private static /* synthetic */ void x(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        InterfaceC4356Eu interfaceC4356Eu = this.a;
        if (interfaceC4356Eu == null) {
            x(1);
        }
        return interfaceC4356Eu;
    }
}
