package ir.nasim;

/* renamed from: ir.nasim.sv7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C20982sv7 extends D1 {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C20982sv7(AbstractC4099Dr3 abstractC4099Dr3) {
        this(abstractC4099Dr3, null);
        if (abstractC4099Dr3 == null) {
            a(0);
        }
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C20982sv7(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC10239bJ5 interfaceC10239bJ5) {
        super(abstractC4099Dr3, interfaceC10239bJ5);
        if (abstractC4099Dr3 == null) {
            a(1);
        }
    }
}
