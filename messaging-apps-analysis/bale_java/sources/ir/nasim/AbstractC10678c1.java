package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.c1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10678c1 extends AbstractC13322g2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC10678c1(ON6 on6, InterfaceC12795fB1 interfaceC12795fB1, C6432No4 c6432No4, KQ7 kq7, boolean z, int i, JH6 jh6, M17 m17) {
        super(on6, interfaceC12795fB1, InterfaceC4356Eu.W.b(), c6432No4, kq7, z, i, jh6, m17);
        if (on6 == null) {
            x(0);
        }
        if (interfaceC12795fB1 == null) {
            x(1);
        }
        if (c6432No4 == null) {
            x(2);
        }
        if (kq7 == null) {
            x(3);
        }
        if (jh6 == null) {
            x(4);
        }
        if (m17 == null) {
            x(5);
        }
    }

    private static /* synthetic */ void x(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "variance";
        } else if (i == 4) {
            objArr[0] = "source";
        } else if (i != 5) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "supertypeLoopChecker";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // ir.nasim.AbstractC13413gB1
    public String toString() {
        String str = "";
        String str2 = w() ? "reified " : "";
        if (m() != KQ7.INVARIANT) {
            str = m() + Separators.SP;
        }
        return String.format("%s%s%s", str2, str, getName());
    }
}
