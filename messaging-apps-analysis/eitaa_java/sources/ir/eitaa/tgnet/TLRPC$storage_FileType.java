package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$storage_FileType extends TLObject {
    public static TLRPC$storage_FileType TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$storage_FileType tLRPC$storage_FileType;
        switch (constructor) {
            case -1432995067:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_fileUnknown
                    public static int constructor = -1432995067;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1373745011:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_filePdf
                    public static int constructor = -1373745011;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1278304028:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_fileMp4
                    public static int constructor = -1278304028;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -891180321:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_fileGif
                    public static int constructor = -891180321;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 8322574:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_fileJpeg
                    public static int constructor = 8322574;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 172975040:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_filePng
                    public static int constructor = 172975040;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 276907596:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_fileWebp
                    public static int constructor = 276907596;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1086091090:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_filePartial
                    public static int constructor = 1086091090;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1258941372:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_fileMov
                    public static int constructor = 1258941372;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1384777335:
                tLRPC$storage_FileType = new TLRPC$storage_FileType() { // from class: ir.eitaa.tgnet.TLRPC$TL_storage_fileMp3
                    public static int constructor = 1384777335;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$storage_FileType = null;
                break;
        }
        if (tLRPC$storage_FileType == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in storage_FileType", Integer.valueOf(constructor)));
        }
        if (tLRPC$storage_FileType != null) {
            tLRPC$storage_FileType.readParams(stream, exception);
        }
        return tLRPC$storage_FileType;
    }
}
