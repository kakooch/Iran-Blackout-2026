package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.lD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16405lD2 implements InterfaceC15814kD2 {
    @Override // ir.nasim.InterfaceC15814kD2
    public com.google.android.material.bottomsheet.b a(long j, ExPeerType exPeerType, String str, TC2 tc2, boolean z) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(str, "galleryResultKey");
        AbstractC13042fc3.i(tc2, "galleryConfig");
        return C24784zC2.INSTANCE.a(j, exPeerType, str, tc2, z);
    }
}
