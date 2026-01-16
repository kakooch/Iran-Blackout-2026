package ir.nasim;

import ir.nasim.C11540dA7;
import ir.nasim.C14599iA7;
import ir.nasim.C24771zA7;
import ir.nasim.C7743Sz7;
import ir.nasim.Q12;
import kotlinx.serialization.KSerializer;

/* renamed from: ir.nasim.om0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18503om0 {
    public static final KSerializer A(C7743Sz7.a aVar) {
        AbstractC13042fc3.i(aVar, "<this>");
        return C8447Vz7.a;
    }

    public static final KSerializer B(C11540dA7.a aVar) {
        AbstractC13042fc3.i(aVar, "<this>");
        return C13410gA7.a;
    }

    public static final KSerializer C(C14599iA7.a aVar) {
        AbstractC13042fc3.i(aVar, "<this>");
        return C16383lA7.a;
    }

    public static final KSerializer D(C24771zA7.a aVar) {
        AbstractC13042fc3.i(aVar, "<this>");
        return CA7.a;
    }

    public static final KSerializer E(C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(c19938rB7, "<this>");
        return C22414vB7.b;
    }

    public static final KSerializer a() {
        return kotlinx.serialization.internal.a.c;
    }

    public static final KSerializer b() {
        return kotlinx.serialization.internal.b.c;
    }

    public static final KSerializer c() {
        return kotlinx.serialization.internal.c.c;
    }

    public static final KSerializer d() {
        return kotlinx.serialization.internal.d.c;
    }

    public static final KSerializer e() {
        return kotlinx.serialization.internal.e.c;
    }

    public static final KSerializer f() {
        return kotlinx.serialization.internal.f.c;
    }

    public static final KSerializer g(KSerializer kSerializer) {
        AbstractC13042fc3.i(kSerializer, "elementSerializer");
        return new JJ(kSerializer);
    }

    public static final KSerializer h() {
        return kotlinx.serialization.internal.g.c;
    }

    public static final KSerializer i(KSerializer kSerializer, KSerializer kSerializer2) {
        AbstractC13042fc3.i(kSerializer, "keySerializer");
        AbstractC13042fc3.i(kSerializer2, "valueSerializer");
        return new C17570nB3(kSerializer, kSerializer2);
    }

    public static final KSerializer j() {
        return BC4.a;
    }

    public static final KSerializer k() {
        return kotlinx.serialization.internal.h.c;
    }

    public static final KSerializer l() {
        return kotlinx.serialization.internal.i.c;
    }

    public static final KSerializer m() {
        return kotlinx.serialization.internal.j.c;
    }

    public static final KSerializer n() {
        return kotlinx.serialization.internal.k.c;
    }

    public static final KSerializer o() {
        return kotlinx.serialization.internal.l.c;
    }

    public static final KSerializer p(KSerializer kSerializer) {
        AbstractC13042fc3.i(kSerializer, "<this>");
        return kSerializer.getDescriptor().b() ? kSerializer : new C21183tF4(kSerializer);
    }

    public static final KSerializer q(C7571Sh0 c7571Sh0) {
        AbstractC13042fc3.i(c7571Sh0, "<this>");
        return C8044Uh0.a;
    }

    public static final KSerializer r(C5488Jo0 c5488Jo0) {
        AbstractC13042fc3.i(c5488Jo0, "<this>");
        return C6922Po0.a;
    }

    public static final KSerializer s(YJ0 yj0) {
        AbstractC13042fc3.i(yj0, "<this>");
        return C13493gK0.a;
    }

    public static final KSerializer t(C15402jX1 c15402jX1) {
        AbstractC13042fc3.i(c15402jX1, "<this>");
        return C16584lX1.a;
    }

    public static final KSerializer u(Q12.a aVar) {
        AbstractC13042fc3.i(aVar, "<this>");
        return V12.a;
    }

    public static final KSerializer v(C9361Zp2 c9361Zp2) {
        AbstractC13042fc3.i(c9361Zp2, "<this>");
        return C15000iq2.a;
    }

    public static final KSerializer w(C15431ja3 c15431ja3) {
        AbstractC13042fc3.i(c15431ja3, "<this>");
        return C3712Ca3.a;
    }

    public static final KSerializer x(C10237bJ3 c10237bJ3) {
        AbstractC13042fc3.i(c10237bJ3, "<this>");
        return C20006rJ3.a;
    }

    public static final KSerializer y(C24660yz6 c24660yz6) {
        AbstractC13042fc3.i(c24660yz6, "<this>");
        return C3467Az6.a;
    }

    public static final KSerializer z(DY6 dy6) {
        AbstractC13042fc3.i(dy6, "<this>");
        return VY6.a;
    }
}
