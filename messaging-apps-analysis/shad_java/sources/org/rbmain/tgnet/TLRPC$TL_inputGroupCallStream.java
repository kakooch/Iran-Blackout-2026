package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputGroupCallStream extends TLRPC$InputFileLocation {
    public static int constructor = -1146808775;
    public TLRPC$TL_inputGroupCall call;
    public int scale;
    public long time_ms;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.time_ms = abstractSerializedData.readInt64(z);
        this.scale = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt64(this.time_ms);
        abstractSerializedData.writeInt32(this.scale);
    }
}
