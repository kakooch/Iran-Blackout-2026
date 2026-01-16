package ir.nasim;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ty7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C7970Ty7 implements TypeVariable, Type {
    private final InterfaceC6907Pm3 a;

    public C7970Ty7(InterfaceC6907Pm3 interfaceC6907Pm3) {
        AbstractC13042fc3.i(interfaceC6907Pm3, "typeParameter");
        this.a = interfaceC6907Pm3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (AbstractC13042fc3.d(getName(), typeVariable.getName()) && AbstractC13042fc3.d(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        List upperBounds = this.a.getUpperBounds();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC22891vz7.c((InterfaceC5941Lm3) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new C22420vC4("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.a));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.a.getName();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
