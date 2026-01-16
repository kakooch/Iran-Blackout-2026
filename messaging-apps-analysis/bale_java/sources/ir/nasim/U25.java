package ir.nasim;

import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class U25 implements InterfaceC14123hO3 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16311l35.values().length];
            try {
                iArr[EnumC16311l35.PeerType_PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C11458d25 a(PeersStruct$Peer peersStruct$Peer) {
        AbstractC13042fc3.i(peersStruct$Peer, "input");
        EnumC16311l35 type = peersStruct$Peer.getType();
        return new C11458d25((type == null ? -1 : a.a[type.ordinal()]) == 1 ? W25.a : W25.b, peersStruct$Peer.getId());
    }
}
