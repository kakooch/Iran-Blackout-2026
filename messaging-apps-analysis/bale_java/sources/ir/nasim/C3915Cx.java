package ir.nasim;

import ai.bale.proto.MessagingStruct$DialogShort;
import ai.bale.proto.PeersStruct$ExInfo;
import ai.bale.proto.PeersStruct$Peer;

/* renamed from: ir.nasim.Cx, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3915Cx implements InterfaceC14123hO3 {
    private final C24763zA a;
    private final C8187Ux b;

    public C3915Cx(C24763zA c24763zA, C8187Ux c8187Ux) {
        AbstractC13042fc3.i(c24763zA, "peerMapper");
        AbstractC13042fc3.i(c8187Ux, "exInfoMapper");
        this.a = c24763zA;
        this.b = c8187Ux;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C3681Bx a(MessagingStruct$DialogShort messagingStruct$DialogShort) {
        C7714Sx c7714SxA;
        AbstractC13042fc3.i(messagingStruct$DialogShort, "input");
        C24763zA c24763zA = this.a;
        PeersStruct$Peer peer = messagingStruct$DialogShort.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C22993wA c22993wAA = c24763zA.a(peer);
        int counter = messagingStruct$DialogShort.getCounter();
        long date = messagingStruct$DialogShort.getDate();
        if (messagingStruct$DialogShort.hasExInfo()) {
            C8187Ux c8187Ux = this.b;
            PeersStruct$ExInfo exInfo = messagingStruct$DialogShort.getExInfo();
            AbstractC13042fc3.h(exInfo, "getExInfo(...)");
            c7714SxA = c8187Ux.a(exInfo);
        } else {
            c7714SxA = null;
        }
        return new C3681Bx(c22993wAA, counter, date, c7714SxA, messagingStruct$DialogShort.hasFirstUnreadDate() ? Long.valueOf(messagingStruct$DialogShort.getFirstUnreadDate().getValue()) : null, messagingStruct$DialogShort.hasMarkedAsUnread() ? Boolean.valueOf(messagingStruct$DialogShort.getMarkedAsUnread().getValue()) : null);
    }
}
