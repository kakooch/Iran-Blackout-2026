package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_storage_filePartial extends TLRPC$storage_FileType {
    public static int constructor = 1086091090;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
