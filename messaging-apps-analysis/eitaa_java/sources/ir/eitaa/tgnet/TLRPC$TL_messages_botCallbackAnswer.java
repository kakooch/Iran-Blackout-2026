package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_botCallbackAnswer extends TLObject {
    public static int constructor = 911761060;
    public boolean alert;
    public int cache_time;
    public int flags;
    public boolean has_url;
    public String message;
    public boolean native_ui;
    public String url;

    public static TLRPC$TL_messages_botCallbackAnswer TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_botCallbackAnswer", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_botCallbackAnswer tLRPC$TL_messages_botCallbackAnswer = new TLRPC$TL_messages_botCallbackAnswer();
        tLRPC$TL_messages_botCallbackAnswer.readParams(stream, exception);
        return tLRPC$TL_messages_botCallbackAnswer;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.alert = (int32 & 2) != 0;
        this.has_url = (int32 & 8) != 0;
        this.native_ui = (int32 & 16) != 0;
        if ((int32 & 1) != 0) {
            this.message = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.url = stream.readString(exception);
        }
        this.cache_time = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.alert ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.has_url ? i | 8 : i & (-9);
        this.flags = i2;
        int i3 = this.native_ui ? i2 | 16 : i2 & (-17);
        this.flags = i3;
        stream.writeInt32(i3);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.message);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.url);
        }
        stream.writeInt32(this.cache_time);
    }
}
