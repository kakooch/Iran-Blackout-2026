package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatInviteImporter extends TLObject {
    public static int constructor = 190633460;
    public int date;
    public long user_id;

    public static TLRPC$TL_chatInviteImporter TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_chatInviteImporter", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_chatInviteImporter tLRPC$TL_chatInviteImporter = new TLRPC$TL_chatInviteImporter();
        tLRPC$TL_chatInviteImporter.readParams(stream, exception);
        return tLRPC$TL_chatInviteImporter;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeInt32(this.date);
    }
}
