package ir.nasim;

import java.util.Collection;

/* renamed from: ir.nasim.jA0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC15194jA0 extends InterfaceC14592iA0, InterfaceC21058t24 {

    /* renamed from: ir.nasim.jA0$a */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean a() {
            return this != FAKE_OVERRIDE;
        }
    }

    void D0(Collection collection);

    @Override // ir.nasim.InterfaceC14592iA0, ir.nasim.InterfaceC12795fB1
    InterfaceC15194jA0 a();

    @Override // ir.nasim.InterfaceC14592iA0
    Collection d();

    a f();

    InterfaceC15194jA0 u(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, a aVar, boolean z);
}
