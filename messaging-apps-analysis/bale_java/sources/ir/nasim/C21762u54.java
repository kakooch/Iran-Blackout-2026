package ir.nasim;

import ai.bale.proto.MessagingStruct$MessageAttributes;

/* renamed from: ir.nasim.u54, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21762u54 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21088t54 a(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        AbstractC13042fc3.i(messagingStruct$MessageAttributes, "input");
        return new C21088t54(messagingStruct$MessageAttributes.getIsNotified().getValue(), messagingStruct$MessageAttributes.getIsMentioned().getValue(), messagingStruct$MessageAttributes.getIsOnlyForYou().getValue(), messagingStruct$MessageAttributes.getIsHighlighted().getValue());
    }
}
