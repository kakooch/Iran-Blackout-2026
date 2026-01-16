package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_peerNotifySettings extends TLRPC$PeerNotifySettings {
    public static int constructor = -1353671392;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.show_previews = abstractSerializedData.readBool(z);
        }
        if ((this.flags & 2) != 0) {
            this.silent = abstractSerializedData.readBool(z);
        }
        if ((this.flags & 4) != 0) {
            this.mute_until = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8) != 0) {
            this.sound = abstractSerializedData.readString(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeBool(this.show_previews);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeBool(this.silent);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.mute_until);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeString(this.sound);
        }
    }
}
