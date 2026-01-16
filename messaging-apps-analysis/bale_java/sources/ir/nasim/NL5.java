package ir.nasim;

import ir.nasim.InterfaceC20257ri3;
import ir.nasim.RL5;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public final class NL5 extends ML5 implements InterfaceC20257ri3 {
    private final Method a;

    public NL5(Method method) {
        AbstractC13042fc3.i(method, "member");
        this.a = method;
    }

    @Override // ir.nasim.InterfaceC20257ri3
    public boolean O() {
        return InterfaceC20257ri3.a.a(this);
    }

    @Override // ir.nasim.ML5
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public Method U() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC20257ri3
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public RL5 getReturnType() {
        RL5.a aVar = RL5.a;
        Type genericReturnType = U().getGenericReturnType();
        AbstractC13042fc3.h(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // ir.nasim.InterfaceC7820Ti3
    public List getTypeParameters() {
        TypeVariable<Method>[] typeParameters = U().getTypeParameters();
        AbstractC13042fc3.h(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new SL5(typeVariable));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC20257ri3
    public List h() {
        Type[] genericParameterTypes = U().getGenericParameterTypes();
        AbstractC13042fc3.h(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = U().getParameterAnnotations();
        AbstractC13042fc3.h(parameterAnnotations, "member.parameterAnnotations");
        return V(genericParameterTypes, parameterAnnotations, U().isVarArgs());
    }

    @Override // ir.nasim.InterfaceC20257ri3
    public InterfaceC4243Eh3 o() {
        Object defaultValue = U().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return AbstractC23098wL5.b.a(defaultValue, null);
    }
}
