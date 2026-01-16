package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$contacts_TopPeers extends TLObject {
    public static TLRPC$contacts_TopPeers TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$contacts_TopPeers tLRPC$TL_contacts_topPeers;
        if (constructor == -1255369827) {
            tLRPC$TL_contacts_topPeers = new TLRPC$contacts_TopPeers() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_topPeersDisabled
                public static int constructor = -1255369827;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else if (constructor != -567906571) {
            tLRPC$TL_contacts_topPeers = constructor != 1891070632 ? null : new TLRPC$TL_contacts_topPeers();
        } else {
            tLRPC$TL_contacts_topPeers = new TLRPC$contacts_TopPeers() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_topPeersNotModified
                public static int constructor = -567906571;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_contacts_topPeers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in contacts_TopPeers", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_contacts_topPeers != null) {
            tLRPC$TL_contacts_topPeers.readParams(stream, exception);
        }
        return tLRPC$TL_contacts_topPeers;
    }
}
