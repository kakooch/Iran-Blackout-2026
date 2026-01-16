package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_historyImport extends TLObject {
    public static int constructor = 375566091;
    public long id;

    public static TLRPC$TL_messages_historyImport TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_historyImport", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_historyImport tLRPC$TL_messages_historyImport = new TLRPC$TL_messages_historyImport();
        tLRPC$TL_messages_historyImport.readParams(stream, exception);
        return tLRPC$TL_messages_historyImport;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
    }
}
