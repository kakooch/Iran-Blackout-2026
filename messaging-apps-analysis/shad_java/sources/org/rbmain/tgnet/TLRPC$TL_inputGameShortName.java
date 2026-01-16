package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputGameShortName extends TLRPC$InputGame {
    public static int constructor = -1020139510;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.bot_id = TLRPC$InputUser.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.short_name = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.bot_id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.short_name);
    }
}
