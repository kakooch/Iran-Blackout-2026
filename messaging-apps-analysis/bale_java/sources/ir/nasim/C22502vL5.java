package ir.nasim;

import ir.nasim.AbstractC23098wL5;
import ir.nasim.InterfaceC4009Dh3;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: ir.nasim.vL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22502vL5 extends IL5 implements InterfaceC4009Dh3 {
    private final Annotation a;

    public C22502vL5(Annotation annotation) {
        AbstractC13042fc3.i(annotation, "annotation");
        this.a = annotation;
    }

    @Override // ir.nasim.InterfaceC4009Dh3
    public boolean H() {
        return InterfaceC4009Dh3.a.a(this);
    }

    public final Annotation R() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC4009Dh3
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public CL5 t() {
        return new CL5(AbstractC4762Gl3.b(AbstractC4762Gl3.a(this.a)));
    }

    @Override // ir.nasim.InterfaceC4009Dh3
    public Collection d() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method[] declaredMethods = AbstractC4762Gl3.b(AbstractC4762Gl3.a(this.a)).getDeclaredMethods();
        AbstractC13042fc3.h(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            AbstractC23098wL5.a aVar = AbstractC23098wL5.b;
            Object objInvoke = method.invoke(R(), null);
            AbstractC13042fc3.h(objInvoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(objInvoke, C6432No4.p(method.getName())));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C22502vL5) && AbstractC13042fc3.d(this.a, ((C22502vL5) obj).a);
    }

    @Override // ir.nasim.InterfaceC4009Dh3
    public C24948zU0 f() {
        return AbstractC21912uL5.b(AbstractC4762Gl3.b(AbstractC4762Gl3.a(this.a)));
    }

    @Override // ir.nasim.InterfaceC4009Dh3
    public boolean g() {
        return InterfaceC4009Dh3.a.b(this);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return C22502vL5.class.getName() + ": " + this.a;
    }
}
