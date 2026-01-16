package ir.nasim;

import ir.nasim.AbstractC19428qK7;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.cs2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11358cs2 implements InterfaceC8121Up5 {
    private final InterfaceC23384wp6 a;

    public C11358cs2() {
        EnumC12613eu3 enumC12613eu3 = EnumC12613eu3.a;
        ExPeerType exPeerType = ExPeerType.UNKNOWN;
        AbstractC19428qK7.c cVar = AbstractC19428qK7.c.c;
        XV4 xv4A = AbstractC4616Fw7.a(enumC12613eu3, new RM1(1L, exPeerType, "Approved User", cVar, false, false, false, "", null, 64, null));
        EnumC12613eu3 enumC12613eu32 = EnumC12613eu3.b;
        ExPeerType exPeerType2 = ExPeerType.PRIVATE;
        this.a = AbstractC9962aq6.k(xv4A, AbstractC4616Fw7.a(enumC12613eu32, new RM1(1L, exPeerType2, "کاربر تایید شده", cVar, false, false, false, "", null, 64, null)), AbstractC4616Fw7.a(enumC12613eu3, new RM1(1L, exPeerType2, "User", AbstractC19428qK7.d.c, true, false, false, "", null, 64, null)), AbstractC4616Fw7.a(enumC12613eu32, new RM1(1L, exPeerType2, "کاربر", AbstractC19428qK7.b.c, false, false, false, "", null, 64, null)));
    }

    @Override // ir.nasim.InterfaceC8121Up5
    public InterfaceC23384wp6 a() {
        return this.a;
    }
}
