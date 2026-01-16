package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$BotInlineMessage extends TLObject {
    public String address;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public String first_name;
    public int flags;
    public TLRPC$GeoPoint geo;
    public int heading;
    public String last_name;
    public String message;
    public boolean no_webpage;
    public int period;
    public String phone_number;
    public String provider;
    public int proximity_notification_radius;
    public TLRPC$ReplyMarkup reply_markup;
    public String title;
    public String vcard;
    public String venue_id;
    public String venue_type;

    public static TLRPC$BotInlineMessage TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$BotInlineMessage tLRPC$TL_botInlineMessageMediaVenue;
        switch (constructor) {
            case -1970903652:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaVenue();
                break;
            case -1937807902:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$BotInlineMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineMessageText
                    public static int constructor = -1937807902;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.no_webpage = (int32 & 1) != 0;
                        this.message = stream2.readString(exception2);
                        if ((this.flags & 2) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.no_webpage ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeString(this.message);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                this.entities.get(i2).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1222451611:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaGeo() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaGeo_layer119
                    public static int constructor = -1222451611;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaGeo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.geo = TLRPC$GeoPoint.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.period = stream2.readInt32(exception2);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaGeo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        this.geo.serializeToStream(stream2);
                        stream2.writeInt32(this.period);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 85477117:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaGeo();
                break;
            case 175419739:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaAuto() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaAuto_layer74
                    public static int constructor = 175419739;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaAuto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaAuto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeString(this.message);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 416402882:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaContact();
                break;
            case 894081801:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaInvoice();
                break;
            case 904770772:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaContact() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaContact_layer81
                    public static int constructor = 904770772;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaContact, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.phone_number = stream2.readString(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaContact, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeString(this.phone_number);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 982505656:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaGeo() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaGeo_layer71
                    public static int constructor = 982505656;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaGeo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.geo = TLRPC$GeoPoint.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaGeo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        this.geo.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1130767150:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaVenue() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaVenue_layer77
                    public static int constructor = 1130767150;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaVenue, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.geo = TLRPC$GeoPoint.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.title = stream2.readString(exception2);
                        this.address = stream2.readString(exception2);
                        this.provider = stream2.readString(exception2);
                        this.venue_id = stream2.readString(exception2);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaVenue, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        this.geo.serializeToStream(stream2);
                        stream2.writeString(this.title);
                        stream2.writeString(this.address);
                        stream2.writeString(this.provider);
                        stream2.writeString(this.venue_id);
                        if ((this.flags & 4) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1984755728:
                tLRPC$TL_botInlineMessageMediaVenue = new TLRPC$TL_botInlineMessageMediaAuto();
                break;
            default:
                tLRPC$TL_botInlineMessageMediaVenue = null;
                break;
        }
        if (tLRPC$TL_botInlineMessageMediaVenue == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in BotInlineMessage", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_botInlineMessageMediaVenue != null) {
            tLRPC$TL_botInlineMessageMediaVenue.readParams(stream, exception);
        }
        return tLRPC$TL_botInlineMessageMediaVenue;
    }
}
