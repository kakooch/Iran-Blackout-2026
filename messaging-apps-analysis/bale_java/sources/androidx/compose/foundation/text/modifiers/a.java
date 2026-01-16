package androidx.compose.foundation.text.modifiers;

import ir.nasim.AbstractC23365wn7;
import ir.nasim.AbstractC23431wu3;
import ir.nasim.AbstractC24544yn6;
import ir.nasim.AbstractC9998au2;
import ir.nasim.C13245fu;
import ir.nasim.C9348Zn7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC11379cu3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC15687k02;
import ir.nasim.InterfaceC15868kJ2;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC8312Vk7;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.P73;
import ir.nasim.RG1;
import ir.nasim.UA2;
import ir.nasim.VX0;
import ir.nasim.ZV3;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class a extends RG1 implements InterfaceC21655tu3, InterfaceC15687k02, InterfaceC15868kJ2 {
    private AbstractC24544yn6 q;
    private UA2 r;
    private final b s;

    public /* synthetic */ a(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, UA2 ua2, int i, boolean z, int i2, int i3, List list, UA2 ua22, AbstractC24544yn6 abstractC24544yn6, VX0 vx0, InterfaceC8312Vk7 interfaceC8312Vk7, UA2 ua23, ED1 ed1) {
        this(c13245fu, c9348Zn7, bVar, ua2, i, z, i2, i3, list, ua22, abstractC24544yn6, vx0, interfaceC8312Vk7, ua23);
    }

    public final void B2(C13245fu c13245fu, C9348Zn7 c9348Zn7, List list, int i, int i2, boolean z, AbstractC9998au2.b bVar, int i3, UA2 ua2, UA2 ua22, AbstractC24544yn6 abstractC24544yn6, VX0 vx0, InterfaceC8312Vk7 interfaceC8312Vk7) {
        b bVar2 = this.s;
        bVar2.C2(bVar2.P2(vx0, c9348Zn7), this.s.R2(c13245fu), this.s.Q2(c9348Zn7, list, i, i2, z, bVar, i3, interfaceC8312Vk7), this.s.O2(ua2, ua22, abstractC24544yn6, this.r));
        AbstractC23431wu3.b(this);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.s.I2(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.s.L2(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        return this.s.K2(interfaceC12377eW3, zv3, j);
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        this.s.D2(interfaceC23919xk1);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.s.M2(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.s.J2(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    public /* synthetic */ a(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, UA2 ua2, int i, boolean z, int i2, int i3, List list, UA2 ua22, AbstractC24544yn6 abstractC24544yn6, VX0 vx0, InterfaceC8312Vk7 interfaceC8312Vk7, UA2 ua23, int i4, ED1 ed1) {
        this(c13245fu, c9348Zn7, bVar, (i4 & 8) != 0 ? null : ua2, (i4 & 16) != 0 ? AbstractC23365wn7.a.a() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : ua22, (i4 & 1024) != 0 ? null : abstractC24544yn6, (i4 & 2048) != 0 ? null : vx0, (i4 & 4096) != 0 ? null : interfaceC8312Vk7, (i4 & 8192) != 0 ? null : ua23, null);
    }

    private a(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, UA2 ua2, int i, boolean z, int i2, int i3, List list, UA2 ua22, AbstractC24544yn6 abstractC24544yn6, VX0 vx0, InterfaceC8312Vk7 interfaceC8312Vk7, UA2 ua23) {
        this.r = ua23;
        this.s = (b) v2(new b(c13245fu, c9348Zn7, bVar, ua2, i, z, i2, i3, list, ua22, this.q, vx0, interfaceC8312Vk7, this.r, null));
        P73.b("Do not use SelectionCapableStaticTextModifier unless selectionController != null");
        throw new KotlinNothingValueException();
    }

    @Override // ir.nasim.InterfaceC15868kJ2
    public void u(InterfaceC11379cu3 interfaceC11379cu3) {
    }
}
