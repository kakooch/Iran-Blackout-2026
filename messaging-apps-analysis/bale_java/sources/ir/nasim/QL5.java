package ir.nasim;

import java.util.Collection;

/* loaded from: classes8.dex */
public final class QL5 extends RL5 implements InterfaceC23901xi3 {
    private final Class b;
    private final Collection c;
    private final boolean d;

    public QL5(Class cls) {
        AbstractC13042fc3.i(cls, "reflectType");
        this.b = cls;
        this.c = AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RL5
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public Class R() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public Collection getAnnotations() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC23901xi3
    public EnumC4809Gq5 getType() {
        if (AbstractC13042fc3.d(R(), Void.TYPE)) {
            return null;
        }
        return EnumC7376Rl3.p(R().getName()).s();
    }
}
