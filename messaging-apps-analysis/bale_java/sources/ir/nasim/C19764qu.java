package ir.nasim;

import ir.nasim.InterfaceC18740pA0;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.qu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19764qu implements InterfaceC18740pA0 {
    private final List a;
    private final List b;
    private final List c;
    private final Class d;
    private final List e;
    private final a f;
    private final List g;

    /* renamed from: ir.nasim.qu$a */
    public enum a {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* renamed from: ir.nasim.qu$b */
    public enum b {
        JAVA,
        KOTLIN
    }

    public C19764qu(Class cls, List list, a aVar, b bVar, List list2) {
        AbstractC13042fc3.i(cls, "jClass");
        AbstractC13042fc3.i(list, "parameterNames");
        AbstractC13042fc3.i(aVar, "callMode");
        AbstractC13042fc3.i(bVar, "origin");
        AbstractC13042fc3.i(list2, "methods");
        this.d = cls;
        this.e = list;
        this.f = aVar;
        this.g = list2;
        List list3 = list2;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.a = arrayList;
        List list4 = this.g;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list4, 10));
        Iterator it2 = list4.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            AbstractC13042fc3.h(returnType, "it");
            Class<?> clsH = AbstractC21912uL5.h(returnType);
            if (clsH != null) {
                returnType = clsH;
            }
            arrayList2.add(returnType);
        }
        this.b = arrayList2;
        List list5 = this.g;
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(list5, 10));
        Iterator it3 = list5.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.c = arrayList3;
        if (this.f == a.POSITIONAL_CALL && bVar == b.JAVA && (!AbstractC15401jX0.O0(this.e, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public List a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public /* bridge */ /* synthetic */ Member b() {
        return (Member) d();
    }

    public void c(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "args");
        InterfaceC18740pA0.a.a(this, objArr);
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public Object call(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "args");
        c(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            Object objF = (obj == null && this.f == a.CALL_BY_NAME) ? this.c.get(i2) : AbstractC20373ru.f(obj, (Class) this.b.get(i2));
            if (objF == null) {
                AbstractC20373ru.e(i2, (String) this.e.get(i2), (Class) this.b.get(i2));
                throw null;
            }
            arrayList.add(objF);
            i++;
            i2 = i3;
        }
        return AbstractC20373ru.c(this.d, AbstractC20051rO3.w(AbstractC15401jX0.v1(this.e, arrayList)), this.g);
    }

    public Void d() {
        return null;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public Type getReturnType() {
        return this.d;
    }

    public /* synthetic */ C19764qu(Class cls, List list, a aVar, b bVar, List list2, int i, ED1 ed1) {
        List list3;
        if ((i & 16) != 0) {
            List list4 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list4, 10));
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list3 = arrayList;
        } else {
            list3 = list2;
        }
        this(cls, list, aVar, bVar, list3);
    }
}
