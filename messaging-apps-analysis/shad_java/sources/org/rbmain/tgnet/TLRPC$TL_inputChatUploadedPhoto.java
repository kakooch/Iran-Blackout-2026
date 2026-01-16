package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputChatUploadedPhoto extends TLRPC$InputChatPhoto {
    public static int constructor = -968723890;
    public TLRPC$InputFile file;
    public int flags;
    public TLRPC$InputFile video;
    public double video_start_ts;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.file = TLRPC$InputFile.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 2) != 0) {
            this.video = TLRPC$InputFile.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 4) != 0) {
            this.video_start_ts = abstractSerializedData.readDouble(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            this.file.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 2) != 0) {
            this.video.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeDouble(this.video_start_ts);
        }
    }
}
