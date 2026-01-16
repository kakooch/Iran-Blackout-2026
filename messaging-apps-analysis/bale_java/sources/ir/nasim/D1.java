package ir.nasim;

/* loaded from: classes8.dex */
public abstract class D1 implements InterfaceC10239bJ5 {
    protected final AbstractC4099Dr3 a;
    private final InterfaceC10239bJ5 b;

    public D1(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC10239bJ5 interfaceC10239bJ5) {
        if (abstractC4099Dr3 == null) {
            a(0);
        }
        this.a = abstractC4099Dr3;
        this.b = interfaceC10239bJ5 == null ? this : interfaceC10239bJ5;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC10239bJ5
    public AbstractC4099Dr3 getType() {
        AbstractC4099Dr3 abstractC4099Dr3 = this.a;
        if (abstractC4099Dr3 == null) {
            a(1);
        }
        return abstractC4099Dr3;
    }
}
