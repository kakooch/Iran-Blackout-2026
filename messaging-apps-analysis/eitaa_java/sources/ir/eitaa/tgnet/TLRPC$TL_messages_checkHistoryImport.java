package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_checkHistoryImport extends TLObject {
    public static int constructor = 1140726259;
    public String import_head;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_historyImportParsed.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.import_head);
    }
}
