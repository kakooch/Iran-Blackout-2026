package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputDialogPeer extends TLObject {
    public static TLRPC$InputDialogPeer TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputDialogPeer tLRPC$TL_inputDialogPeer;
        if (constructor == -55902537) {
            tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
        } else {
            tLRPC$TL_inputDialogPeer = constructor != 1684014375 ? null : new TLRPC$InputDialogPeer() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputDialogPeerFolder
                public static int constructor = 1684014375;
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
        if (tLRPC$TL_inputDialogPeer == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputDialogPeer", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputDialogPeer != null) {
            tLRPC$TL_inputDialogPeer.readParams(stream, exception);
        }
        return tLRPC$TL_inputDialogPeer;
    }
}
