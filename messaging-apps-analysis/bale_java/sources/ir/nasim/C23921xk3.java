package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.xk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23921xk3 {
    private final A52 a;
    private boolean b;

    /* renamed from: ir.nasim.xk3$a */
    /* synthetic */ class a extends EB2 implements InterfaceC14603iB2 {
        a(Object obj) {
            super(2, obj, C23921xk3.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return y((SerialDescriptor) obj, ((Number) obj2).intValue());
        }

        public final Boolean y(SerialDescriptor serialDescriptor, int i) {
            AbstractC13042fc3.i(serialDescriptor, "p0");
            return Boolean.valueOf(((C23921xk3) this.receiver).e(serialDescriptor, i));
        }
    }

    public C23921xk3(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        this.a = new A52(serialDescriptor, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(SerialDescriptor serialDescriptor, int i) {
        boolean z = !serialDescriptor.j(i) && serialDescriptor.h(i).b();
        this.b = z;
        return z;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(int i) {
        this.a.a(i);
    }

    public final int d() {
        return this.a.d();
    }
}
