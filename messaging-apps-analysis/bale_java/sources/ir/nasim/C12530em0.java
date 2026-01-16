package ir.nasim;

import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.em0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12530em0 extends AbstractC3625Bq6 {
    public static final C12530em0 n = new C12530em0();

    /* JADX WARN: Illegal instructions before constructor call */
    private C12530em0() {
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarD = kotlin.reflect.jvm.internal.impl.protobuf.f.d();
        AbstractC16139km0.a(fVarD);
        C19938rB7 c19938rB7 = C19938rB7.a;
        AbstractC13042fc3.h(fVarD, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        h.f fVar = AbstractC16139km0.a;
        AbstractC13042fc3.h(fVar, "packageFqName");
        h.f fVar2 = AbstractC16139km0.c;
        AbstractC13042fc3.h(fVar2, "constructorAnnotation");
        h.f fVar3 = AbstractC16139km0.b;
        AbstractC13042fc3.h(fVar3, "classAnnotation");
        h.f fVar4 = AbstractC16139km0.d;
        AbstractC13042fc3.h(fVar4, "functionAnnotation");
        h.f fVar5 = AbstractC16139km0.e;
        AbstractC13042fc3.h(fVar5, "propertyAnnotation");
        h.f fVar6 = AbstractC16139km0.f;
        AbstractC13042fc3.h(fVar6, "propertyGetterAnnotation");
        h.f fVar7 = AbstractC16139km0.g;
        AbstractC13042fc3.h(fVar7, "propertySetterAnnotation");
        h.f fVar8 = AbstractC16139km0.i;
        AbstractC13042fc3.h(fVar8, "enumEntryAnnotation");
        h.f fVar9 = AbstractC16139km0.h;
        AbstractC13042fc3.h(fVar9, "compileTimeValue");
        h.f fVar10 = AbstractC16139km0.j;
        AbstractC13042fc3.h(fVar10, "parameterAnnotation");
        h.f fVar11 = AbstractC16139km0.k;
        AbstractC13042fc3.h(fVar11, "typeAnnotation");
        h.f fVar12 = AbstractC16139km0.l;
        AbstractC13042fc3.h(fVar12, "typeParameterAnnotation");
        super(fVarD, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12);
    }

    private final String o(C9424Zw2 c9424Zw2) {
        if (c9424Zw2.d()) {
            return "default-package";
        }
        String strH = c9424Zw2.g().h();
        AbstractC13042fc3.h(strH, "fqName.shortName().asString()");
        return strH;
    }

    public final String m(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return AbstractC13042fc3.q(o(c9424Zw2), ".kotlin_builtins");
    }

    public final String n(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        StringBuilder sb = new StringBuilder();
        String strB = c9424Zw2.b();
        AbstractC13042fc3.h(strB, "fqName.asString()");
        sb.append(AbstractC20153rZ6.L(strB, '.', '/', false, 4, null));
        sb.append('/');
        sb.append(m(c9424Zw2));
        return sb.toString();
    }
}
