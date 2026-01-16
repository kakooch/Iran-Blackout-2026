package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_reactionEmoji extends TLRPC$Reaction {
    public static int constructor = 455247544;
    public String emoticon;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.emoticon = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.emoticon);
    }
}
