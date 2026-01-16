package ir.nasim;

import ir.nasim.InterfaceC24278yL5;
import ir.nasim.OL5;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class ML5 extends IL5 implements InterfaceC24278yL5, OL5, InterfaceC19648qi3 {
    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return InterfaceC24278yL5.a.c(this);
    }

    @Override // ir.nasim.OL5
    public int J() {
        return U().getModifiers();
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

    @Override // ir.nasim.InterfaceC19648qi3
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public CL5 Q() {
        Class<?> declaringClass = U().getDeclaringClass();
        AbstractC13042fc3.h(declaringClass, "member.declaringClass");
        return new CL5(declaringClass);
    }

    public abstract Member U();

    protected final List V(Type[] typeArr, Annotation[][] annotationArr, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String str;
        AbstractC13042fc3.i(typeArr, "parameterTypes");
        AbstractC13042fc3.i(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List listB = C3775Ch3.a.b(U());
        Integer numValueOf = listB == null ? null : Integer.valueOf(listB.size());
        int iIntValue = numValueOf == null ? 0 : numValueOf.intValue() - typeArr.length;
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                RL5 rl5A = RL5.a.a(typeArr[i]);
                if (listB == null) {
                    str = null;
                } else {
                    str = (String) AbstractC15401jX0.t0(listB, i + iIntValue);
                    if (str == null) {
                        throw new IllegalStateException(("No parameter with index " + i + '+' + iIntValue + " (name=" + getName() + " type=" + rl5A + ") in " + listB + "@ReflectJavaMember").toString());
                    }
                }
                arrayList.add(new TL5(rl5A, annotationArr[i], str, z && i == AbstractC10242bK.l0(typeArr)));
                if (i2 > length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ML5) && AbstractC13042fc3.d(U(), ((ML5) obj).U());
    }

    @Override // ir.nasim.InterfaceC22125ui3
    public C6432No4 getName() {
        String name = U().getName();
        C6432No4 c6432No4P = name == null ? null : C6432No4.p(name);
        if (c6432No4P != null) {
            return c6432No4P;
        }
        C6432No4 c6432No4 = AbstractC23662xI6.a;
        AbstractC13042fc3.h(c6432No4, "NO_NAME_PROVIDED");
        return c6432No4;
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public GY7 getVisibility() {
        return OL5.a.a(this);
    }

    public int hashCode() {
        return U().hashCode();
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public boolean i() {
        return OL5.a.d(this);
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public boolean isAbstract() {
        return OL5.a.b(this);
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public boolean isFinal() {
        return OL5.a.c(this);
    }

    @Override // ir.nasim.InterfaceC24278yL5
    public AnnotatedElement r() {
        return (AnnotatedElement) U();
    }

    public String toString() {
        return getClass().getName() + ": " + U();
    }
}
