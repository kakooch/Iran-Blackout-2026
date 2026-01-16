package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_documentAttributeAudio extends TLRPC$DocumentAttribute {
    public static int constructor = -1739392570;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.voice = (int32 & 1024) != 0;
        this.duration = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            this.title = abstractSerializedData.readString(z);
        }
        if ((this.flags & 2) != 0) {
            this.performer = abstractSerializedData.readString(z);
        }
        if ((this.flags & 4) != 0) {
            this.waveform = abstractSerializedData.readByteArray(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.voice ? this.flags | 1024 : this.flags & (-1025);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt32(this.duration);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.title);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.performer);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeByteArray(this.waveform);
        }
    }
}
