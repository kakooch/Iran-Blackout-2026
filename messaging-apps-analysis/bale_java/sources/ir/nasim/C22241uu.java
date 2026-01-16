package ir.nasim;

import ir.nasim.InterfaceC21651tu;
import java.util.Map;

/* renamed from: ir.nasim.uu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C22241uu implements InterfaceC21651tu {
    private final AbstractC4099Dr3 a;
    private final Map b;
    private final JH6 c;

    public C22241uu(AbstractC4099Dr3 abstractC4099Dr3, Map map, JH6 jh6) {
        if (abstractC4099Dr3 == null) {
            a(0);
        }
        if (map == null) {
            a(1);
        }
        if (jh6 == null) {
            a(2);
        }
        this.a = abstractC4099Dr3;
        this.b = map;
        this.c = jh6;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC21651tu
    public C9424Zw2 e() {
        return InterfaceC21651tu.a.a(this);
    }

    @Override // ir.nasim.InterfaceC21651tu
    public AbstractC4099Dr3 getType() {
        AbstractC4099Dr3 abstractC4099Dr3 = this.a;
        if (abstractC4099Dr3 == null) {
            a(3);
        }
        return abstractC4099Dr3;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public JH6 i() {
        JH6 jh6 = this.c;
        if (jh6 == null) {
            a(5);
        }
        return jh6;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public Map j() {
        Map map = this.b;
        if (map == null) {
            a(4);
        }
        return map;
    }

    public String toString() {
        return FI1.g.s(this, null);
    }
}
