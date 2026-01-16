package ir.nasim;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public final class HL5 extends ML5 implements InterfaceC9290Zh3 {
    private final Constructor a;

    public HL5(Constructor constructor) {
        AbstractC13042fc3.i(constructor, "member");
        this.a = constructor;
    }

    @Override // ir.nasim.ML5
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public Constructor U() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC7820Ti3
    public List getTypeParameters() {
        TypeVariable[] typeParameters = U().getTypeParameters();
        AbstractC13042fc3.h(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new SL5(typeVariable));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC9290Zh3
    public List h() {
        Type[] genericParameterTypes = U().getGenericParameterTypes();
        AbstractC13042fc3.h(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return AbstractC10360bX0.m();
        }
        Class declaringClass = U().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) AbstractC9648aK.s(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = U().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException(AbstractC13042fc3.q("Illegal generic signature: ", U()));
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            AbstractC13042fc3.h(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) AbstractC9648aK.s(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        AbstractC13042fc3.h(genericParameterTypes, "realTypes");
        AbstractC13042fc3.h(parameterAnnotations, "realAnnotations");
        return V(genericParameterTypes, parameterAnnotations, U().isVarArgs());
    }
}
