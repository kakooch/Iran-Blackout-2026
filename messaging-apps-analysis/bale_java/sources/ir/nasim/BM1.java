package ir.nasim;

import ai.bale.proto.MessagingStruct$Dialog;
import ir.nasim.AbstractC25195zt3;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;

/* loaded from: classes5.dex */
public interface BM1 {
    AbstractC25195zt3.d a(String str);

    Object b(DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1);

    Object c(DialogLastMessage dialogLastMessage, String str, long j, InterfaceC20295rm1 interfaceC20295rm1);

    Object d(long j, ExPeerType exPeerType, InterfaceC20295rm1 interfaceC20295rm1);

    Object e(MessagingStruct$Dialog messagingStruct$Dialog, InterfaceC20295rm1 interfaceC20295rm1);

    Object f(MessagingStruct$Dialog messagingStruct$Dialog, InterfaceC20295rm1 interfaceC20295rm1);
}
