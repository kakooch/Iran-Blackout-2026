package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.gB1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13413gB1 extends AbstractC11996du implements InterfaceC12795fB1 {
    private final C6432No4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC13413gB1(InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4) {
        super(interfaceC4356Eu);
        if (interfaceC4356Eu == null) {
            x(0);
        }
        if (c6432No4 == null) {
            x(1);
        }
        this.b = c6432No4;
    }

    public static String M(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            x(4);
        }
        try {
            String str = FI1.j.r(interfaceC12795fB1) + "[" + interfaceC12795fB1.getClass().getSimpleName() + Separators.AT + Integer.toHexString(System.identityHashCode(interfaceC12795fB1)) + "]";
            if (str == null) {
                x(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = interfaceC12795fB1.getClass().getSimpleName() + Separators.SP + interfaceC12795fB1.getName();
            if (str2 == null) {
                x(6);
            }
            return str2;
        }
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (i != 5 && i != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC7638So4
    public C6432No4 getName() {
        C6432No4 c6432No4 = this.b;
        if (c6432No4 == null) {
            x(2);
        }
        return c6432No4;
    }

    public String toString() {
        return M(this);
    }

    public InterfaceC12795fB1 a() {
        return this;
    }
}
