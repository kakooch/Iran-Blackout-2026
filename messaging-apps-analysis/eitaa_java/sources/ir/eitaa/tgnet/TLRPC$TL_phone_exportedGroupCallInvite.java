package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_exportedGroupCallInvite extends TLObject {
    public static int constructor = 541839704;
    public String link;

    public static TLRPC$TL_phone_exportedGroupCallInvite TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_phone_exportedGroupCallInvite", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_phone_exportedGroupCallInvite tLRPC$TL_phone_exportedGroupCallInvite = new TLRPC$TL_phone_exportedGroupCallInvite();
        tLRPC$TL_phone_exportedGroupCallInvite.readParams(stream, exception);
        return tLRPC$TL_phone_exportedGroupCallInvite;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.link = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.link);
    }
}
