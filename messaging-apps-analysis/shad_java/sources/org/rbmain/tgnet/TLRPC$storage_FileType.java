package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$storage_FileType extends TLObject {
    public static TLRPC$storage_FileType TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$storage_FileType tLRPC$TL_storage_filePng;
        switch (i) {
            case -1432995067:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_fileUnknown
                    public static int constructor = -1432995067;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1373745011:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_filePdf
                    public static int constructor = -1373745011;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1278304028:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_fileMp4
                    public static int constructor = -1278304028;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -891180321:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_fileGif
                    public static int constructor = -891180321;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 8322574:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_fileJpeg
                    public static int constructor = 8322574;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 172975040:
                tLRPC$TL_storage_filePng = new TLRPC$TL_storage_filePng();
                break;
            case 276907596:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_fileWebp
                    public static int constructor = 276907596;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1086091090:
                tLRPC$TL_storage_filePng = new TLRPC$TL_storage_filePartial();
                break;
            case 1258941372:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_fileMov
                    public static int constructor = 1258941372;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1384777335:
                tLRPC$TL_storage_filePng = new TLRPC$storage_FileType() { // from class: org.rbmain.tgnet.TLRPC$TL_storage_fileMp3
                    public static int constructor = 1384777335;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_storage_filePng = null;
                break;
        }
        if (tLRPC$TL_storage_filePng == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in storage_FileType", Integer.valueOf(i)));
        }
        if (tLRPC$TL_storage_filePng != null) {
            tLRPC$TL_storage_filePng.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_storage_filePng;
    }
}
