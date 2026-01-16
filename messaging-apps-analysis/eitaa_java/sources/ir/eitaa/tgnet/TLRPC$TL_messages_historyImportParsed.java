package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_historyImportParsed extends TLObject {
    public static int constructor = 1578088377;
    public int flags;
    public boolean group;
    public boolean pm;
    public String title;

    public static TLRPC$TL_messages_historyImportParsed TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_historyImportParsed", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_historyImportParsed tLRPC$TL_messages_historyImportParsed = new TLRPC$TL_messages_historyImportParsed();
        tLRPC$TL_messages_historyImportParsed.readParams(stream, exception);
        return tLRPC$TL_messages_historyImportParsed;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.pm = (int32 & 1) != 0;
        this.group = (int32 & 2) != 0;
        if ((int32 & 4) != 0) {
            this.title = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.pm ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.group ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        if ((this.flags & 4) != 0) {
            stream.writeString(this.title);
        }
    }
}
