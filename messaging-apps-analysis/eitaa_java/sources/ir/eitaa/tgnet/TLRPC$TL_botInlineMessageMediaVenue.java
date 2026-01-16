package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_botInlineMessageMediaVenue extends TLRPC$BotInlineMessage {
    public static int constructor = -1970903652;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.geo = TLRPC$GeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.title = stream.readString(exception);
        this.address = stream.readString(exception);
        this.provider = stream.readString(exception);
        this.venue_id = stream.readString(exception);
        this.venue_type = stream.readString(exception);
        if ((this.flags & 4) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.geo.serializeToStream(stream);
        stream.writeString(this.title);
        stream.writeString(this.address);
        stream.writeString(this.provider);
        stream.writeString(this.venue_id);
        stream.writeString(this.venue_type);
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(stream);
        }
    }
}
