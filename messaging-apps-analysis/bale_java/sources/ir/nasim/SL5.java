package ir.nasim;

import ir.nasim.InterfaceC24278yL5;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public final class SL5 extends IL5 implements InterfaceC24278yL5, InterfaceC7583Si3 {
    private final TypeVariable a;

    public SL5(TypeVariable typeVariable) {
        AbstractC13042fc3.i(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return InterfaceC24278yL5.a.c(this);
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public C22502vL5 z(C9424Zw2 c9424Zw2) {
        return InterfaceC24278yL5.a.a(this, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public List getAnnotations() {
        return InterfaceC24278yL5.a.b(this);
    }

    @Override // ir.nasim.InterfaceC7583Si3
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public List getUpperBounds() {
        Type[] bounds = this.a.getBounds();
        AbstractC13042fc3.h(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new GL5(type));
        }
        GL5 gl5 = (GL5) AbstractC15401jX0.X0(arrayList);
        return AbstractC13042fc3.d(gl5 == null ? null : gl5.R(), Object.class) ? AbstractC10360bX0.m() : arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof SL5) && AbstractC13042fc3.d(this.a, ((SL5) obj).a);
    }

    @Override // ir.nasim.InterfaceC22125ui3
    public C6432No4 getName() {
        C6432No4 c6432No4P = C6432No4.p(this.a.getName());
        AbstractC13042fc3.h(c6432No4P, "identifier(typeVariable.name)");
        return c6432No4P;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC24278yL5
    public AnnotatedElement r() {
        TypeVariable typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    public String toString() {
        return SL5.class.getName() + ": " + this.a;
    }
}
