package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_botInlineMessageMediaGeo extends TLRPC$BotInlineMessage {
    public static int constructor = 85477117;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.geo = TLRPC$GeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.heading = stream.readInt32(exception);
        }
        if ((this.flags & 2) != 0) {
            this.period = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            this.proximity_notification_radius = stream.readInt32(exception);
        }
        if ((this.flags & 4) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.geo.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.heading);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.period);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.proximity_notification_radius);
        }
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(stream);
        }
    }
}
