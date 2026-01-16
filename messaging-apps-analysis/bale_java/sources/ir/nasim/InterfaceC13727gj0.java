package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.gj0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC13727gj0 {
    static /* synthetic */ Object e(InterfaceC13727gj0 interfaceC13727gj0, int i, Integer num, String str, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitReview-BWLJW6A");
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        return interfaceC13727gj0.f(i, num, str, interfaceC20295rm1);
    }

    Object a(C11458d25 c11458d25, ExPeerType exPeerType, long j, long j2, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1);

    Object b(String str, int i, ExPeerType exPeerType, long j, long j2, Boolean bool, InterfaceC20295rm1 interfaceC20295rm1);

    Object c(String str, int i, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1);

    Object d(int i, String str, InterfaceC20295rm1 interfaceC20295rm1);

    Object f(int i, Integer num, String str, InterfaceC20295rm1 interfaceC20295rm1);
}
