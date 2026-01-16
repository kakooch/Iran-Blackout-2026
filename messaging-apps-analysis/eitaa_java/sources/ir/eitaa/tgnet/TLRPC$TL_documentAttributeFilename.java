package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_documentAttributeFilename extends TLRPC$DocumentAttribute {
    public static int constructor = 358154344;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.file_name = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.file_name);
    }
}
