package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.kD2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC15814kD2 {
    static /* synthetic */ com.google.android.material.bottomsheet.b b(InterfaceC15814kD2 interfaceC15814kD2, long j, ExPeerType exPeerType, String str, TC2 tc2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGalleryBottomSheetFragment");
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return interfaceC15814kD2.a(j, exPeerType, str, tc2, z);
    }

    com.google.android.material.bottomsheet.b a(long j, ExPeerType exPeerType, String str, TC2 tc2, boolean z);
}
