package ir.nasim;

import ir.nasim.RL5;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* loaded from: classes8.dex */
public final class UL5 extends RL5 implements InterfaceC11891dj3 {
    private final WildcardType b;
    private final Collection c;
    private final boolean d;

    public UL5(WildcardType wildcardType) {
        AbstractC13042fc3.i(wildcardType, "reflectType");
        this.b = wildcardType;
        this.c = AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC11891dj3
    public boolean N() {
        AbstractC13042fc3.h(R().getUpperBounds(), "reflectType.upperBounds");
        return !AbstractC13042fc3.d(AbstractC10242bK.e0(r0), Object.class);
    }

    @Override // ir.nasim.InterfaceC11891dj3
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public RL5 w() {
        Type[] upperBounds = R().getUpperBounds();
        Type[] lowerBounds = R().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(AbstractC13042fc3.q("Wildcard types with many bounds are not yet supported: ", R()));
        }
        if (lowerBounds.length == 1) {
            RL5.a aVar = RL5.a;
            AbstractC13042fc3.h(lowerBounds, "lowerBounds");
            Object objN0 = AbstractC10242bK.N0(lowerBounds);
            AbstractC13042fc3.h(objN0, "lowerBounds.single()");
            return aVar.a((Type) objN0);
        }
        if (upperBounds.length == 1) {
            AbstractC13042fc3.h(upperBounds, "upperBounds");
            Type type = (Type) AbstractC10242bK.N0(upperBounds);
            if (!AbstractC13042fc3.d(type, Object.class)) {
                RL5.a aVar2 = RL5.a;
                AbstractC13042fc3.h(type, "ub");
                return aVar2.a(type);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RL5
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public WildcardType R() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public Collection getAnnotations() {
        return this.c;
    }
}
