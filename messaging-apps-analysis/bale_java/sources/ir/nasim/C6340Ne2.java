package ir.nasim;

/* renamed from: ir.nasim.Ne2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C6340Ne2 extends D1 implements InterfaceC10239bJ5 {
    private final InterfaceC14592iA0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6340Ne2(InterfaceC14592iA0 interfaceC14592iA0, AbstractC4099Dr3 abstractC4099Dr3, InterfaceC10239bJ5 interfaceC10239bJ5) {
        super(abstractC4099Dr3, interfaceC10239bJ5);
        if (interfaceC14592iA0 == null) {
            a(0);
        }
        if (abstractC4099Dr3 == null) {
            a(1);
        }
        this.c = interfaceC14592iA0;
    }

    private static /* synthetic */ void a(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "receiverType";
        } else if (i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(str2);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.c + "}";
    }
}
