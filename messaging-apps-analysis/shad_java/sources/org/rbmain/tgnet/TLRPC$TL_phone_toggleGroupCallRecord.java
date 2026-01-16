package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_phone_toggleGroupCallRecord extends TLObject {
    public static int constructor = -1070962985;
    public TLRPC$TL_inputGroupCall call;
    public int flags;
    public boolean start;
    public String title;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.start ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        this.call.serializeToStream(abstractSerializedData);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.title);
        }
    }
}
