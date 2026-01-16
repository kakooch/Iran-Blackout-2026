package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ml4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17315ml4 implements InterfaceC10970cW3 {
    private final InterfaceC16724ll4 a;

    public C17315ml4(InterfaceC16724ll4 interfaceC16724ll4) {
        this.a = interfaceC16724ll4;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return this.a.a(interfaceC10436bc3, AbstractC13604gW3.a(interfaceC10436bc3), i);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        return this.a.b(interfaceC12377eW3, AbstractC13604gW3.a(interfaceC12377eW3), j);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return this.a.d(interfaceC10436bc3, AbstractC13604gW3.a(interfaceC10436bc3), i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C17315ml4) && AbstractC13042fc3.d(this.a, ((C17315ml4) obj).a);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return this.a.h(interfaceC10436bc3, AbstractC13604gW3.a(interfaceC10436bc3), i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return this.a.i(interfaceC10436bc3, AbstractC13604gW3.a(interfaceC10436bc3), i);
    }

    public String toString() {
        return "MultiContentMeasurePolicyImpl(measurePolicy=" + this.a + ')';
    }
}
