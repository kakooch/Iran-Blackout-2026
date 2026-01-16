package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_paymentSavedCredentialsCard extends TLObject {
    public static int constructor = -842892769;
    public String id;
    public String title;

    public static TLRPC$TL_paymentSavedCredentialsCard TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_paymentSavedCredentialsCard", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_paymentSavedCredentialsCard tLRPC$TL_paymentSavedCredentialsCard = new TLRPC$TL_paymentSavedCredentialsCard();
        tLRPC$TL_paymentSavedCredentialsCard.readParams(stream, exception);
        return tLRPC$TL_paymentSavedCredentialsCard;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readString(exception);
        this.title = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.id);
        stream.writeString(this.title);
    }
}
