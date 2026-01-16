package ir.nasim;

/* renamed from: ir.nasim.Hl7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5000Hl7 {
    public static final InterfaceC25129zm7 b(InterfaceC25129zm7 interfaceC25129zm7, InterfaceC25129zm7 interfaceC25129zm72, float f) {
        boolean z = interfaceC25129zm7 instanceof C15538jl0;
        return (z || (interfaceC25129zm72 instanceof C15538jl0)) ? (z && (interfaceC25129zm72 instanceof C15538jl0)) ? InterfaceC25129zm7.a.a((AbstractC12520el0) AbstractC13481gI6.d(((C15538jl0) interfaceC25129zm7).e(), ((C15538jl0) interfaceC25129zm72).e(), f), AbstractC18932pV3.b(interfaceC25129zm7.a(), interfaceC25129zm72.a(), f)) : (InterfaceC25129zm7) AbstractC13481gI6.d(interfaceC25129zm7, interfaceC25129zm72, f) : InterfaceC25129zm7.a.b(DX0.i(interfaceC25129zm7.d(), interfaceC25129zm72.d(), f));
    }

    public static final long c(long j, float f) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : C24381yX0.o(j, C24381yX0.r(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(float f, SA2 sa2) {
        return Float.isNaN(f) ? ((Number) sa2.invoke()).floatValue() : f;
    }
}
