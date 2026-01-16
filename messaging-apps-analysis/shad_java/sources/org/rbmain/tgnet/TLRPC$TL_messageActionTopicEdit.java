package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageActionTopicEdit extends TLRPC$MessageAction {
    public static int constructor = -1064024032;
    public boolean closed;
    public boolean hidden;
    public long icon_emoji_id;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.title = abstractSerializedData.readString(z);
        }
        if ((this.flags & 2) != 0) {
            this.icon_emoji_id = abstractSerializedData.readInt64(z);
        }
        if ((this.flags & 4) != 0) {
            this.closed = abstractSerializedData.readBool(z);
        }
        if ((this.flags & 8) != 0) {
            this.hidden = abstractSerializedData.readBool(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.title);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt64(this.icon_emoji_id);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeBool(this.closed);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeBool(this.hidden);
        }
    }
}
