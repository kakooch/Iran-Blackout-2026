package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$contacts_TopPeers extends TLObject {
    public static TLRPC$contacts_TopPeers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$contacts_TopPeers tLRPC$TL_contacts_topPeers;
        if (i == -1255369827) {
            tLRPC$TL_contacts_topPeers = new TLRPC$contacts_TopPeers() { // from class: org.rbmain.tgnet.TLRPC$TL_contacts_topPeersDisabled
                public static int constructor = -1255369827;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else if (i != -567906571) {
            tLRPC$TL_contacts_topPeers = i != 1891070632 ? null : new TLRPC$TL_contacts_topPeers();
        } else {
            tLRPC$TL_contacts_topPeers = new TLRPC$contacts_TopPeers() { // from class: org.rbmain.tgnet.TLRPC$TL_contacts_topPeersNotModified
                public static int constructor = -567906571;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_contacts_topPeers == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in contacts_TopPeers", Integer.valueOf(i)));
        }
        if (tLRPC$TL_contacts_topPeers != null) {
            tLRPC$TL_contacts_topPeers.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_contacts_topPeers;
    }
}
