package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$BotInlineResult extends TLObject {
    public TLRPC$WebDocument content;
    public String description;
    public TLRPC$Document document;
    public int flags;
    public String id;
    public TLRPC$Photo photo;
    public long query_id;
    public TLRPC$BotInlineMessage send_message;
    public TLRPC$WebDocument thumb;
    public String title;
    public String type;
    public String url;

    public static TLRPC$BotInlineResult TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$BotInlineResult tLRPC$BotInlineResult;
        if (constructor == 295067450) {
            tLRPC$BotInlineResult = new TLRPC$BotInlineResult() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineResult
                public static int constructor = 295067450;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.flags = stream2.readInt32(exception2);
                    this.id = stream2.readString(exception2);
                    this.type = stream2.readString(exception2);
                    if ((this.flags & 2) != 0) {
                        this.title = stream2.readString(exception2);
                    }
                    if ((this.flags & 4) != 0) {
                        this.description = stream2.readString(exception2);
                    }
                    if ((this.flags & 8) != 0) {
                        this.url = stream2.readString(exception2);
                    }
                    if ((this.flags & 16) != 0) {
                        this.thumb = TLRPC$WebDocument.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                    if ((this.flags & 32) != 0) {
                        this.content = TLRPC$WebDocument.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                    this.send_message = TLRPC$BotInlineMessage.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.flags);
                    stream2.writeString(this.id);
                    stream2.writeString(this.type);
                    if ((this.flags & 2) != 0) {
                        stream2.writeString(this.title);
                    }
                    if ((this.flags & 4) != 0) {
                        stream2.writeString(this.description);
                    }
                    if ((this.flags & 8) != 0) {
                        stream2.writeString(this.url);
                    }
                    if ((this.flags & 16) != 0) {
                        this.thumb.serializeToStream(stream2);
                    }
                    if ((this.flags & 32) != 0) {
                        this.content.serializeToStream(stream2);
                    }
                    this.send_message.serializeToStream(stream2);
                }
            };
        } else {
            tLRPC$BotInlineResult = constructor != 400266251 ? null : new TLRPC$BotInlineResult() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineMediaResult
                public static int constructor = 400266251;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.flags = stream2.readInt32(exception2);
                    this.id = stream2.readString(exception2);
                    this.type = stream2.readString(exception2);
                    if ((this.flags & 1) != 0) {
                        this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                    if ((this.flags & 2) != 0) {
                        this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                    if ((this.flags & 4) != 0) {
                        this.title = stream2.readString(exception2);
                    }
                    if ((this.flags & 8) != 0) {
                        this.description = stream2.readString(exception2);
                    }
                    this.send_message = TLRPC$BotInlineMessage.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.flags);
                    stream2.writeString(this.id);
                    stream2.writeString(this.type);
                    if ((this.flags & 1) != 0) {
                        this.photo.serializeToStream(stream2);
                    }
                    if ((this.flags & 2) != 0) {
                        this.document.serializeToStream(stream2);
                    }
                    if ((this.flags & 4) != 0) {
                        stream2.writeString(this.title);
                    }
                    if ((this.flags & 8) != 0) {
                        stream2.writeString(this.description);
                    }
                    this.send_message.serializeToStream(stream2);
                }
            };
        }
        if (tLRPC$BotInlineResult == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in BotInlineResult", Integer.valueOf(constructor)));
        }
        if (tLRPC$BotInlineResult != null) {
            tLRPC$BotInlineResult.readParams(stream, exception);
        }
        return tLRPC$BotInlineResult;
    }
}
