package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$KeyboardButton extends TLObject {
    public TLRPC$InputUser bot;
    public int button_id;
    public byte[] data;
    public int flags;
    public String fwd_text;
    public String query;
    public boolean quiz;
    public boolean request_write_access;
    public boolean requires_password;
    public boolean same_peer;
    public String text;
    public String url;

    public static TLRPC$KeyboardButton TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$KeyboardButton tLRPC$TL_keyboardButtonBuy;
        switch (constructor) {
            case -1560655744:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButton
                    public static int constructor = -1560655744;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.text = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.text);
                    }
                };
                break;
            case -1344716869:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$TL_keyboardButtonBuy();
                break;
            case -1318425559:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRequestPhone
                    public static int constructor = -1318425559;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.text = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.text);
                    }
                };
                break;
            case -1144565411:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRequestPoll
                    public static int constructor = -1144565411;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            this.quiz = stream2.readBool(exception2);
                        }
                        this.text = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            stream2.writeBool(this.quiz);
                        }
                        stream2.writeString(this.text);
                    }
                };
                break;
            case -802258988:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputKeyboardButtonUrlAuth
                    public static int constructor = -802258988;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.request_write_access = (int32 & 1) != 0;
                        this.text = stream2.readString(exception2);
                        if ((this.flags & 2) != 0) {
                            this.fwd_text = stream2.readString(exception2);
                        }
                        this.url = stream2.readString(exception2);
                        this.bot = TLRPC$InputUser.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.request_write_access ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeString(this.text);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.fwd_text);
                        }
                        stream2.writeString(this.url);
                        this.bot.serializeToStream(stream2);
                    }
                };
                break;
            case -59151553:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRequestGeoLocation
                    public static int constructor = -59151553;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.text = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.text);
                    }
                };
                break;
            case 90744648:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButtonSwitchInline
                    public static int constructor = 90744648;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.same_peer = (int32 & 1) != 0;
                        this.text = stream2.readString(exception2);
                        this.query = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.same_peer ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeString(this.text);
                        stream2.writeString(this.query);
                    }
                };
                break;
            case 280464681:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$TL_keyboardButtonUrlAuth();
                break;
            case 629866245:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButtonUrl
                    public static int constructor = 629866245;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.text = stream2.readString(exception2);
                        this.url = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.text);
                        stream2.writeString(this.url);
                    }
                };
                break;
            case 901503851:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$TL_keyboardButtonCallback();
                break;
            case 1358175439:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$KeyboardButton() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButtonGame
                    public static int constructor = 1358175439;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.text = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.text);
                    }
                };
                break;
            case 1748655686:
                tLRPC$TL_keyboardButtonBuy = new TLRPC$TL_keyboardButtonCallback() { // from class: ir.eitaa.tgnet.TLRPC$TL_keyboardButtonCallback_layer117
                    public static int constructor = 1748655686;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_keyboardButtonCallback, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.text = stream2.readString(exception2);
                        this.data = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_keyboardButtonCallback, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.text);
                        stream2.writeByteArray(this.data);
                    }
                };
                break;
            default:
                tLRPC$TL_keyboardButtonBuy = null;
                break;
        }
        if (tLRPC$TL_keyboardButtonBuy == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in KeyboardButton", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_keyboardButtonBuy != null) {
            tLRPC$TL_keyboardButtonBuy.readParams(stream, exception);
        }
        return tLRPC$TL_keyboardButtonBuy;
    }
}
