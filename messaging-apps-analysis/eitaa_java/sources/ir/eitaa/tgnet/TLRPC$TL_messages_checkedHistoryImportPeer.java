package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_checkedHistoryImportPeer extends TLObject {
    public static int constructor = -1571952873;
    public String confirm_text;

    public static TLRPC$TL_messages_checkedHistoryImportPeer TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_checkedHistoryImportPeer", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_checkedHistoryImportPeer tLRPC$TL_messages_checkedHistoryImportPeer = new TLRPC$TL_messages_checkedHistoryImportPeer();
        tLRPC$TL_messages_checkedHistoryImportPeer.readParams(stream, exception);
        return tLRPC$TL_messages_checkedHistoryImportPeer;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.confirm_text = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.confirm_text);
    }
}
