package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PeerLocated extends TLObject {
    public static TLRPC$PeerLocated TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PeerLocated tLRPC$TL_peerLocated;
        if (constructor != -901375139) {
            tLRPC$TL_peerLocated = constructor != -118740917 ? null : new TLRPC$TL_peerSelfLocated();
        } else {
            tLRPC$TL_peerLocated = new TLRPC$TL_peerLocated();
        }
        if (tLRPC$TL_peerLocated == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PeerLocated", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_peerLocated != null) {
            tLRPC$TL_peerLocated.readParams(stream, exception);
        }
        return tLRPC$TL_peerLocated;
    }
}
