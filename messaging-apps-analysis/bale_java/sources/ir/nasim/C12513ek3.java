package ir.nasim;

import com.google.gson.reflect.TypeToken;

/* renamed from: ir.nasim.ek3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12513ek3 implements InterfaceC6537Nx7 {
    private final C20806se1 a;

    public C12513ek3(C20806se1 c20806se1) {
        this.a = c20806se1;
    }

    AbstractC6277Mx7 a(C20806se1 c20806se1, KS2 ks2, TypeToken typeToken, InterfaceC11901dk3 interfaceC11901dk3) {
        AbstractC6277Mx7 c10640bw7;
        Object objA = c20806se1.b(TypeToken.a(interfaceC11901dk3.value())).a();
        boolean zNullSafe = interfaceC11901dk3.nullSafe();
        if (objA instanceof AbstractC6277Mx7) {
            c10640bw7 = (AbstractC6277Mx7) objA;
        } else if (objA instanceof InterfaceC6537Nx7) {
            c10640bw7 = ((InterfaceC6537Nx7) objA).b(ks2, typeToken);
        } else {
            if (!(objA instanceof InterfaceC22145uk3)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            c10640bw7 = new C10640bw7(null, objA instanceof InterfaceC22145uk3 ? (InterfaceC22145uk3) objA : null, ks2, typeToken, null, zNullSafe);
            zNullSafe = false;
        }
        return (c10640bw7 == null || !zNullSafe) ? c10640bw7 : c10640bw7.a();
    }

    @Override // ir.nasim.InterfaceC6537Nx7
    public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
        InterfaceC11901dk3 interfaceC11901dk3 = (InterfaceC11901dk3) typeToken.c().getAnnotation(InterfaceC11901dk3.class);
        if (interfaceC11901dk3 == null) {
            return null;
        }
        return a(this.a, ks2, typeToken, interfaceC11901dk3);
    }
}
