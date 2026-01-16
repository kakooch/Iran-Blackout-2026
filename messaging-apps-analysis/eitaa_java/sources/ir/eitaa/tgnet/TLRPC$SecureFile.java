package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$SecureFile extends TLObject {
    public static TLRPC$SecureFile TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$SecureFile tLRPC$TL_secureFile;
        if (constructor != -534283678) {
            tLRPC$TL_secureFile = constructor != 1679398724 ? null : new TLRPC$SecureFile() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureFileEmpty
                public static int constructor = 1679398724;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_secureFile = new TLRPC$TL_secureFile();
        }
        if (tLRPC$TL_secureFile == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in SecureFile", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_secureFile != null) {
            tLRPC$TL_secureFile.readParams(stream, exception);
        }
        return tLRPC$TL_secureFile;
    }
}
