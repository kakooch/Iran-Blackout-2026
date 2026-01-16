package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_keyboardButtonRequestPeer extends TLRPC$KeyboardButton {
    public static int constructor = 218842764;
    public TLRPC$RequestPeerType peer_type;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.text = abstractSerializedData.readString(z);
        this.button_id = abstractSerializedData.readInt32(z);
        this.peer_type = TLRPC$RequestPeerType.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.text);
        abstractSerializedData.writeInt32(this.button_id);
        this.peer_type.serializeToStream(abstractSerializedData);
    }
}
