package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_botCommand extends TLObject {
    public static int constructor = -1032140601;
    public String command;
    public String description;

    public static TLRPC$TL_botCommand TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_botCommand", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_botCommand tLRPC$TL_botCommand = new TLRPC$TL_botCommand();
        tLRPC$TL_botCommand.readParams(stream, exception);
        return tLRPC$TL_botCommand;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.command = stream.readString(exception);
        this.description = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.command);
        stream.writeString(this.description);
    }
}
