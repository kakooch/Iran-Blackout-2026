package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputFolderPeer extends TLObject {
    public static int constructor = -70073706;
    public int folder_id;
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.folder_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.folder_id);
    }
}
