package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_upload_getWebFile extends TLObject {
    public static int constructor = 619086221;
    public int limit;
    public TLRPC$InputWebFileLocation location;
    public int offset;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_upload_webFile.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.location.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.offset);
        abstractSerializedData.writeInt32(this.limit);
    }
}
