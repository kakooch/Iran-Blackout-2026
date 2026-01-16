package ir.nasim;

import ir.nasim.AbstractC5698Kl3;
import ir.nasim.AbstractC6165Ml3;
import ir.nasim.AbstractC7849Tl3;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.Sl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7610Sl3 {

    /* renamed from: ir.nasim.Sl3$a */
    public static final class a extends AbstractC7610Sl3 {
        private final Field a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            AbstractC13042fc3.i(field, "field");
            this.a = field;
        }

        @Override // ir.nasim.AbstractC7610Sl3
        public String a() {
            StringBuilder sb = new StringBuilder();
            String name = this.a.getName();
            AbstractC13042fc3.h(name, "field.name");
            sb.append(C23341wl3.a(name));
            sb.append("()");
            Class<?> type = this.a.getType();
            AbstractC13042fc3.h(type, "field.type");
            sb.append(AbstractC21912uL5.c(type));
            return sb.toString();
        }

        public final Field b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Sl3$b */
    public static final class b extends AbstractC7610Sl3 {
        private final Method a;
        private final Method b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method, Method method2) {
            super(null);
            AbstractC13042fc3.i(method, "getterMethod");
            this.a = method;
            this.b = method2;
        }

        @Override // ir.nasim.AbstractC7610Sl3
        public String a() {
            return B76.b(this.a);
        }

        public final Method b() {
            return this.a;
        }

        public final Method c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Sl3$c */
    public static final class c extends AbstractC7610Sl3 {
        private final String a;
        private final InterfaceC20989sw5 b;
        private final C9193Yw5 c;
        private final AbstractC7849Tl3.d d;
        private final InterfaceC6692Oo4 e;
        private final C7029Py7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC20989sw5 interfaceC20989sw5, C9193Yw5 c9193Yw5, AbstractC7849Tl3.d dVar, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7) {
            String string;
            super(null);
            AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
            AbstractC13042fc3.i(c9193Yw5, "proto");
            AbstractC13042fc3.i(dVar, "signature");
            AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
            AbstractC13042fc3.i(c7029Py7, "typeTable");
            this.b = interfaceC20989sw5;
            this.c = c9193Yw5;
            this.d = dVar;
            this.e = interfaceC6692Oo4;
            this.f = c7029Py7;
            if (dVar.G()) {
                StringBuilder sb = new StringBuilder();
                AbstractC7849Tl3.c cVarC = dVar.C();
                AbstractC13042fc3.h(cVarC, "signature.getter");
                sb.append(interfaceC6692Oo4.getString(cVarC.y()));
                AbstractC7849Tl3.c cVarC2 = dVar.C();
                AbstractC13042fc3.h(cVarC2, "signature.getter");
                sb.append(interfaceC6692Oo4.getString(cVarC2.w()));
                string = sb.toString();
            } else {
                AbstractC6165Ml3.a aVarD = C8083Ul3.d(C8083Ul3.a, c9193Yw5, interfaceC6692Oo4, c7029Py7, false, 8, null);
                if (aVarD == null) {
                    throw new C25175zr3("No field signature for property: " + interfaceC20989sw5);
                }
                String strD = aVarD.d();
                string = C23341wl3.a(strD) + c() + "()" + aVarD.e();
            }
            this.a = string;
        }

        private final String c() {
            String string;
            InterfaceC12795fB1 interfaceC12795fB1B = this.b.b();
            AbstractC13042fc3.h(interfaceC12795fB1B, "descriptor.containingDeclaration");
            if (AbstractC13042fc3.d(this.b.getVisibility(), QI1.d) && (interfaceC12795fB1B instanceof C10851cJ1)) {
                C6526Nw5 c6526Nw5W0 = ((C10851cJ1) interfaceC12795fB1B).W0();
                h.f fVar = AbstractC7849Tl3.i;
                AbstractC13042fc3.h(fVar, "JvmProtoBuf.classModuleName");
                Integer num = (Integer) AbstractC15662jx5.a(c6526Nw5W0, fVar);
                if (num == null || (string = this.e.getString(num.intValue())) == null) {
                    string = "main";
                }
                return "$" + C7404Ro4.a(string);
            }
            if (!AbstractC13042fc3.d(this.b.getVisibility(), QI1.a) || !(interfaceC12795fB1B instanceof InterfaceC24340yS4)) {
                return "";
            }
            InterfaceC20989sw5 interfaceC20989sw5 = this.b;
            if (interfaceC20989sw5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            }
            InterfaceC12258eJ1 interfaceC12258eJ1L = ((C16458lJ1) interfaceC20989sw5).L();
            if (!(interfaceC12258eJ1L instanceof C6898Pl3)) {
                return "";
            }
            C6898Pl3 c6898Pl3 = (C6898Pl3) interfaceC12258eJ1L;
            if (c6898Pl3.e() == null) {
                return "";
            }
            return "$" + c6898Pl3.g().h();
        }

        @Override // ir.nasim.AbstractC7610Sl3
        public String a() {
            return this.a;
        }

        public final InterfaceC20989sw5 b() {
            return this.b;
        }

        public final InterfaceC6692Oo4 d() {
            return this.e;
        }

        public final C9193Yw5 e() {
            return this.c;
        }

        public final AbstractC7849Tl3.d f() {
            return this.d;
        }

        public final C7029Py7 g() {
            return this.f;
        }
    }

    /* renamed from: ir.nasim.Sl3$d */
    public static final class d extends AbstractC7610Sl3 {
        private final AbstractC5698Kl3.e a;
        private final AbstractC5698Kl3.e b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC5698Kl3.e eVar, AbstractC5698Kl3.e eVar2) {
            super(null);
            AbstractC13042fc3.i(eVar, "getterSignature");
            this.a = eVar;
            this.b = eVar2;
        }

        @Override // ir.nasim.AbstractC7610Sl3
        public String a() {
            return this.a.a();
        }

        public final AbstractC5698Kl3.e b() {
            return this.a;
        }

        public final AbstractC5698Kl3.e c() {
            return this.b;
        }
    }

    private AbstractC7610Sl3() {
    }

    public abstract String a();

    public /* synthetic */ AbstractC7610Sl3(ED1 ed1) {
        this();
    }
}
