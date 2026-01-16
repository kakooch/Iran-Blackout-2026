package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_inviteText extends TLObject {
    public static int constructor = 415997816;
    public String message;

    public static TLRPC$TL_help_inviteText TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_help_inviteText", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_help_inviteText tLRPC$TL_help_inviteText = new TLRPC$TL_help_inviteText();
        tLRPC$TL_help_inviteText.readParams(stream, exception);
        return tLRPC$TL_help_inviteText;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.message = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.message);
    }
}
