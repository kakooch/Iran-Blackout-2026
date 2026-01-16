package ir.nasim;

import ir.nasim.AbstractC6165Ml3;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.Kl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5698Kl3 {

    /* renamed from: ir.nasim.Kl3$a */
    public static final class a extends AbstractC5698Kl3 {
        private final List a;
        private final Class b;

        /* renamed from: ir.nasim.Kl3$a$a, reason: collision with other inner class name */
        public static final class C0469a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                Method method = (Method) obj;
                AbstractC13042fc3.h(method, "it");
                String name = method.getName();
                Method method2 = (Method) obj2;
                AbstractC13042fc3.h(method2, "it");
                return AbstractC18050o01.d(name, method2.getName());
            }
        }

        /* renamed from: ir.nasim.Kl3$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            public static final b e = new b();

            b() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Method method) {
                AbstractC13042fc3.h(method, "it");
                Class<?> returnType = method.getReturnType();
                AbstractC13042fc3.h(returnType, "it.returnType");
                return AbstractC21912uL5.c(returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls) throws SecurityException {
            super(null);
            AbstractC13042fc3.i(cls, "jClass");
            this.b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            AbstractC13042fc3.h(declaredMethods, "jClass.declaredMethods");
            this.a = AbstractC10242bK.R0(declaredMethods, new C0469a());
        }

        @Override // ir.nasim.AbstractC5698Kl3
        public String a() {
            return AbstractC15401jX0.A0(this.a, "", "<init>(", ")V", 0, null, b.e, 24, null);
        }

        public final List b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Kl3$b */
    public static final class b extends AbstractC5698Kl3 {
        private final Constructor a;

        /* renamed from: ir.nasim.Kl3$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Class cls) {
                AbstractC13042fc3.h(cls, "it");
                return AbstractC21912uL5.c(cls);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(null);
            AbstractC13042fc3.i(constructor, "constructor");
            this.a = constructor;
        }

        @Override // ir.nasim.AbstractC5698Kl3
        public String a() {
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            AbstractC13042fc3.h(parameterTypes, "constructor.parameterTypes");
            return AbstractC10242bK.D0(parameterTypes, "", "<init>(", ")V", 0, null, a.e, 24, null);
        }

        public final Constructor b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Kl3$c */
    public static final class c extends AbstractC5698Kl3 {
        private final Method a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            AbstractC13042fc3.i(method, "method");
            this.a = method;
        }

        @Override // ir.nasim.AbstractC5698Kl3
        public String a() {
            return B76.b(this.a);
        }

        public final Method b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Kl3$d */
    public static final class d extends AbstractC5698Kl3 {
        private final String a;
        private final AbstractC6165Ml3.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC6165Ml3.b bVar) {
            super(null);
            AbstractC13042fc3.i(bVar, "signature");
            this.b = bVar;
            this.a = bVar.a();
        }

        @Override // ir.nasim.AbstractC5698Kl3
        public String a() {
            return this.a;
        }

        public final String b() {
            return this.b.b();
        }
    }

    /* renamed from: ir.nasim.Kl3$e */
    public static final class e extends AbstractC5698Kl3 {
        private final String a;
        private final AbstractC6165Ml3.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbstractC6165Ml3.b bVar) {
            super(null);
            AbstractC13042fc3.i(bVar, "signature");
            this.b = bVar;
            this.a = bVar.a();
        }

        @Override // ir.nasim.AbstractC5698Kl3
        public String a() {
            return this.a;
        }

        public final String b() {
            return this.b.b();
        }

        public final String c() {
            return this.b.c();
        }
    }

    private AbstractC5698Kl3() {
    }

    public abstract String a();

    public /* synthetic */ AbstractC5698Kl3(ED1 ed1) {
        this();
    }
}
