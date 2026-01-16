package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$DialogPeer extends TLObject {
    public static TLRPC$DialogPeer TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$DialogPeer tLRPC$TL_dialogPeer;
        if (constructor == -445792507) {
            tLRPC$TL_dialogPeer = new TLRPC$TL_dialogPeer();
        } else {
            tLRPC$TL_dialogPeer = constructor != 1363483106 ? null : new TLRPC$DialogPeer() { // from class: ir.eitaa.tgnet.TLRPC$TL_dialogPeerFolder
                public static int constructor = 1363483106;
                public int folder_id;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.folder_id = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.folder_id);
                }
            };
        }
        if (tLRPC$TL_dialogPeer == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in DialogPeer", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_dialogPeer != null) {
            tLRPC$TL_dialogPeer.readParams(stream, exception);
        }
        return tLRPC$TL_dialogPeer;
    }
}
