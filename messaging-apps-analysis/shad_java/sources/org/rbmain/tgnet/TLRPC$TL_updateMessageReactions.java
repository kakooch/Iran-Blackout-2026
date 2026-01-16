package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_updateMessageReactions extends TLRPC$Update {
    public static int constructor = 357013699;
    public long msg_id;
    public TLRPC$Peer peer;
    public TLRPC$TL_messageReactions reactions;
    public boolean updateUnreadState;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.msg_id = abstractSerializedData.readInt32(z);
        this.reactions = TLRPC$MessageReactions.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt64(this.msg_id);
        this.reactions.serializeToStream(abstractSerializedData);
    }
}
