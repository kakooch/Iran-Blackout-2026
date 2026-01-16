package ir.nasim;

import ir.nasim.AbstractC5698Kl3;
import ir.nasim.AbstractC6165Ml3;
import ir.nasim.AbstractC7610Sl3;
import ir.nasim.AbstractC7849Tl3;
import ir.nasim.PJ6;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: classes8.dex */
public final class A76 {
    private static final C24948zU0 a;
    public static final A76 b = new A76();

    static {
        C24948zU0 c24948zU0M = C24948zU0.m(new C9424Zw2("java.lang.Void"));
        AbstractC13042fc3.h(c24948zU0M, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        a = c24948zU0M;
    }

    private A76() {
    }

    private final EnumC4809Gq5 a(Class cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        EnumC7376Rl3 enumC7376Rl3P = EnumC7376Rl3.p(cls.getSimpleName());
        AbstractC13042fc3.h(enumC7376Rl3P, "JvmPrimitiveType.get(simpleName)");
        return enumC7376Rl3P.s();
    }

    private final boolean b(AB2 ab2) {
        if (AbstractC23657xI1.m(ab2) || AbstractC23657xI1.n(ab2)) {
            return true;
        }
        return AbstractC13042fc3.d(ab2.getName(), RV0.e.a()) && ab2.h().isEmpty();
    }

    private final AbstractC5698Kl3.e d(AB2 ab2) {
        return new AbstractC5698Kl3.e(new AbstractC6165Ml3.b(e(ab2), AbstractC6597Oe4.c(ab2, false, false, 1, null)));
    }

    private final String e(InterfaceC15194jA0 interfaceC15194jA0) {
        String strB = AbstractC21886uI6.b(interfaceC15194jA0);
        if (strB != null) {
            return strB;
        }
        if (interfaceC15194jA0 instanceof InterfaceC22266uw5) {
            String strH = PI1.o(interfaceC15194jA0).getName().h();
            AbstractC13042fc3.h(strH, "descriptor.propertyIfAccessor.name.asString()");
            return C23341wl3.a(strH);
        }
        if (interfaceC15194jA0 instanceof InterfaceC4146Dw5) {
            String strH2 = PI1.o(interfaceC15194jA0).getName().h();
            AbstractC13042fc3.h(strH2, "descriptor.propertyIfAccessor.name.asString()");
            return C23341wl3.d(strH2);
        }
        String strH3 = interfaceC15194jA0.getName().h();
        AbstractC13042fc3.h(strH3, "descriptor.name.asString()");
        return strH3;
    }

    public final C24948zU0 c(Class cls) {
        AbstractC13042fc3.i(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            AbstractC13042fc3.h(componentType, "klass.componentType");
            EnumC4809Gq5 enumC4809Gq5A = a(componentType);
            if (enumC4809Gq5A != null) {
                return new C24948zU0(PJ6.m, enumC4809Gq5A.j());
            }
            C24948zU0 c24948zU0M = C24948zU0.m(PJ6.a.i.l());
            AbstractC13042fc3.h(c24948zU0M, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return c24948zU0M;
        }
        if (AbstractC13042fc3.d(cls, Void.TYPE)) {
            return a;
        }
        EnumC4809Gq5 enumC4809Gq5A2 = a(cls);
        if (enumC4809Gq5A2 != null) {
            return new C24948zU0(PJ6.m, enumC4809Gq5A2.q());
        }
        C24948zU0 c24948zU0B = AbstractC21912uL5.b(cls);
        if (!c24948zU0B.k()) {
            C5203Ii3 c5203Ii3 = C5203Ii3.a;
            C9424Zw2 c9424Zw2B = c24948zU0B.b();
            AbstractC13042fc3.h(c9424Zw2B, "classId.asSingleFqName()");
            C24948zU0 c24948zU0N = c5203Ii3.n(c9424Zw2B);
            if (c24948zU0N != null) {
                return c24948zU0N;
            }
        }
        return c24948zU0B;
    }

    public final AbstractC7610Sl3 f(InterfaceC20989sw5 interfaceC20989sw5) {
        AbstractC13042fc3.i(interfaceC20989sw5, "possiblyOverriddenProperty");
        InterfaceC15194jA0 interfaceC15194jA0L = OI1.L(interfaceC20989sw5);
        AbstractC13042fc3.h(interfaceC15194jA0L, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        InterfaceC20989sw5 interfaceC20989sw5A = ((InterfaceC20989sw5) interfaceC15194jA0L).a();
        AbstractC13042fc3.h(interfaceC20989sw5A, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (interfaceC20989sw5A instanceof C16458lJ1) {
            C16458lJ1 c16458lJ1 = (C16458lJ1) interfaceC20989sw5A;
            C9193Yw5 c9193Yw5A1 = c16458lJ1.g0();
            h.f fVar = AbstractC7849Tl3.d;
            AbstractC13042fc3.h(fVar, "JvmProtoBuf.propertySignature");
            AbstractC7849Tl3.d dVar = (AbstractC7849Tl3.d) AbstractC15662jx5.a(c9193Yw5A1, fVar);
            if (dVar != null) {
                return new AbstractC7610Sl3.c(interfaceC20989sw5A, c9193Yw5A1, dVar, c16458lJ1.K(), c16458lJ1.E());
            }
        } else if (interfaceC20989sw5A instanceof C24491yi3) {
            JH6 jh6I = ((C24491yi3) interfaceC20989sw5A).i();
            if (!(jh6I instanceof InterfaceC4486Fi3)) {
                jh6I = null;
            }
            InterfaceC4486Fi3 interfaceC4486Fi3 = (InterfaceC4486Fi3) jh6I;
            InterfaceC13720gi3 interfaceC13720gi3C = interfaceC4486Fi3 != null ? interfaceC4486Fi3.c() : null;
            if (interfaceC13720gi3C instanceof KL5) {
                return new AbstractC7610Sl3.a(((KL5) interfaceC13720gi3C).U());
            }
            if (!(interfaceC13720gi3C instanceof NL5)) {
                throw new C25175zr3("Incorrect resolution sequence for Java field " + interfaceC20989sw5A + " (source = " + interfaceC13720gi3C + ')');
            }
            Method methodW = ((NL5) interfaceC13720gi3C).U();
            InterfaceC4146Dw5 interfaceC4146Dw5J = interfaceC20989sw5A.J();
            JH6 jh6I2 = interfaceC4146Dw5J != null ? interfaceC4146Dw5J.i() : null;
            if (!(jh6I2 instanceof InterfaceC4486Fi3)) {
                jh6I2 = null;
            }
            InterfaceC4486Fi3 interfaceC4486Fi32 = (InterfaceC4486Fi3) jh6I2;
            InterfaceC13720gi3 interfaceC13720gi3C2 = interfaceC4486Fi32 != null ? interfaceC4486Fi32.c() : null;
            if (!(interfaceC13720gi3C2 instanceof NL5)) {
                interfaceC13720gi3C2 = null;
            }
            NL5 nl5 = (NL5) interfaceC13720gi3C2;
            return new AbstractC7610Sl3.b(methodW, nl5 != null ? nl5.U() : null);
        }
        InterfaceC22266uw5 interfaceC22266uw5G = interfaceC20989sw5A.g();
        AbstractC13042fc3.f(interfaceC22266uw5G);
        AbstractC5698Kl3.e eVarD = d(interfaceC22266uw5G);
        InterfaceC4146Dw5 interfaceC4146Dw5J2 = interfaceC20989sw5A.J();
        return new AbstractC7610Sl3.d(eVarD, interfaceC4146Dw5J2 != null ? d(interfaceC4146Dw5J2) : null);
    }

    public final AbstractC5698Kl3 g(AB2 ab2) {
        Method methodW;
        AbstractC6165Ml3.b bVarB;
        AbstractC6165Ml3.b bVarE;
        AbstractC13042fc3.i(ab2, "possiblySubstitutedFunction");
        InterfaceC15194jA0 interfaceC15194jA0L = OI1.L(ab2);
        AbstractC13042fc3.h(interfaceC15194jA0L, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        AB2 ab2A = ((AB2) interfaceC15194jA0L).a();
        AbstractC13042fc3.h(ab2A, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (ab2A instanceof ZI1) {
            ZI1 zi1 = (ZI1) ab2A;
            kotlin.reflect.jvm.internal.impl.protobuf.l lVarG0 = zi1.g0();
            if ((lVarG0 instanceof C7950Tw5) && (bVarE = C8083Ul3.a.e((C7950Tw5) lVarG0, zi1.K(), zi1.E())) != null) {
                return new AbstractC5698Kl3.e(bVarE);
            }
            if (!(lVarG0 instanceof C6765Ow5) || (bVarB = C8083Ul3.a.b((C6765Ow5) lVarG0, zi1.K(), zi1.E())) == null) {
                return d(ab2A);
            }
            InterfaceC12795fB1 interfaceC12795fB1B = ab2.b();
            AbstractC13042fc3.h(interfaceC12795fB1B, "possiblySubstitutedFunction.containingDeclaration");
            return R73.b(interfaceC12795fB1B) ? new AbstractC5698Kl3.e(bVarB) : new AbstractC5698Kl3.d(bVarB);
        }
        if (ab2A instanceof C20848si3) {
            JH6 jh6I = ((C20848si3) ab2A).i();
            if (!(jh6I instanceof InterfaceC4486Fi3)) {
                jh6I = null;
            }
            InterfaceC4486Fi3 interfaceC4486Fi3 = (InterfaceC4486Fi3) jh6I;
            InterfaceC13720gi3 interfaceC13720gi3C = interfaceC4486Fi3 != null ? interfaceC4486Fi3.c() : null;
            NL5 nl5 = (NL5) (interfaceC13720gi3C instanceof NL5 ? interfaceC13720gi3C : null);
            if (nl5 != null && (methodW = nl5.U()) != null) {
                return new AbstractC5698Kl3.c(methodW);
            }
            throw new C25175zr3("Incorrect resolution sequence for Java method " + ab2A);
        }
        if (!(ab2A instanceof C7340Rh3)) {
            if (b(ab2A)) {
                return d(ab2A);
            }
            throw new C25175zr3("Unknown origin of " + ab2A + " (" + ab2A.getClass() + ')');
        }
        JH6 jh6I2 = ((C7340Rh3) ab2A).i();
        if (!(jh6I2 instanceof InterfaceC4486Fi3)) {
            jh6I2 = null;
        }
        InterfaceC4486Fi3 interfaceC4486Fi32 = (InterfaceC4486Fi3) jh6I2;
        InterfaceC13720gi3 interfaceC13720gi3C2 = interfaceC4486Fi32 != null ? interfaceC4486Fi32.c() : null;
        if (interfaceC13720gi3C2 instanceof HL5) {
            return new AbstractC5698Kl3.b(((HL5) interfaceC13720gi3C2).U());
        }
        if (interfaceC13720gi3C2 instanceof CL5) {
            CL5 cl5 = (CL5) interfaceC13720gi3C2;
            if (cl5.n()) {
                return new AbstractC5698Kl3.a(cl5.r());
            }
        }
        throw new C25175zr3("Incorrect resolution sequence for Java constructor " + ab2A + " (" + interfaceC13720gi3C2 + ')');
    }
}
