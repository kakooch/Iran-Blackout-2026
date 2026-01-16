package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_EitaaNotification_button {
    public static int constructor = 1988797784;
    public String buttonText;
    public String url;

    public static TLRPC$TL_EitaaNotification_button TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_message_notification", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_EitaaNotification_button tLRPC$TL_EitaaNotification_button = new TLRPC$TL_EitaaNotification_button();
        tLRPC$TL_EitaaNotification_button.readParams(stream, exception);
        return tLRPC$TL_EitaaNotification_button;
    }

    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
        this.buttonText = stream.readString(exception);
    }

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeString(this.url);
        stream.writeString(this.buttonText);
    }
}
