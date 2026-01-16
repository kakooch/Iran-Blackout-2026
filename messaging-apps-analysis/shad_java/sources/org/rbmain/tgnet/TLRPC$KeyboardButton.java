package org.rbmain.tgnet;

import ir.aaap.messengercore.model.MiniFunctionObject;

/* loaded from: classes4.dex */
public abstract class TLRPC$KeyboardButton extends TLObject {
    public TLRPC$InputUser bot;
    public int button_id;
    public byte[] data;
    public int flags;
    public String fwd_text;
    public MiniFunctionObject miniFunctionObject;
    public String query;
    public boolean quiz;
    public boolean request_write_access;
    public boolean requires_password;
    public boolean same_peer;
    public String text;
    public String url;
    public long user_id;

    public static TLRPC$KeyboardButton TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$KeyboardButton tLRPC$TL_keyboardButton;
        switch (i) {
            case -1816527947:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonSwitchInline
                    public static int constructor = 90744648;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.same_peer = (int32 & 1) != 0;
                        this.text = abstractSerializedData2.readString(z2);
                        this.query = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.same_peer ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeString(this.text);
                        abstractSerializedData2.writeString(this.query);
                    }
                };
                break;
            case -1560655744:
                tLRPC$TL_keyboardButton = new TLRPC$TL_keyboardButton();
                break;
            case -1344716869:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonBuy
                    public static int constructor = -1344716869;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.text = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.text);
                    }
                };
                break;
            case -1318425559:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestPhone
                    public static int constructor = -1318425559;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.text = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.text);
                    }
                };
                break;
            case -1144565411:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestPoll
                    public static int constructor = -1144565411;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            this.quiz = abstractSerializedData2.readBool(z2);
                        }
                        this.text = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeBool(this.quiz);
                        }
                        abstractSerializedData2.writeString(this.text);
                    }
                };
                break;
            case -802258988:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_inputKeyboardButtonUrlAuth
                    public static int constructor = -802258988;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.request_write_access = (int32 & 1) != 0;
                        this.text = abstractSerializedData2.readString(z2);
                        if ((this.flags & 2) != 0) {
                            this.fwd_text = abstractSerializedData2.readString(z2);
                        }
                        this.url = abstractSerializedData2.readString(z2);
                        this.bot = TLRPC$InputUser.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.request_write_access ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeString(this.text);
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeString(this.fwd_text);
                        }
                        abstractSerializedData2.writeString(this.url);
                        this.bot.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case -59151553:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestGeoLocation
                    public static int constructor = -59151553;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.text = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.text);
                    }
                };
                break;
            case 218842764:
                tLRPC$TL_keyboardButton = new TLRPC$TL_keyboardButtonRequestPeer();
                break;
            case 280464681:
                tLRPC$TL_keyboardButton = new TLRPC$TL_keyboardButtonUrlAuth();
                break;
            case 629866245:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonUrl
                    public static int constructor = 629866245;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.text = abstractSerializedData2.readString(z2);
                        this.url = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.text);
                        abstractSerializedData2.writeString(this.url);
                    }
                };
                break;
            case 814112961:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonUserProfile
                    public static int constructor = 814112961;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.text = abstractSerializedData2.readString(z2);
                        this.user_id = abstractSerializedData2.readInt64(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.text);
                        abstractSerializedData2.writeInt64(this.user_id);
                    }
                };
                break;
            case 901503851:
                tLRPC$TL_keyboardButton = new TLRPC$TL_keyboardButtonCallback();
                break;
            case 1358175439:
                tLRPC$TL_keyboardButton = new TLRPC$KeyboardButton() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonGame
                    public static int constructor = 1358175439;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.text = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.text);
                    }
                };
                break;
            case 1748655686:
                tLRPC$TL_keyboardButton = new TLRPC$TL_keyboardButtonCallback() { // from class: org.rbmain.tgnet.TLRPC$TL_keyboardButtonCallback_layer117
                    public static int constructor = 1748655686;

                    @Override // org.rbmain.tgnet.TLRPC$TL_keyboardButtonCallback, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.text = abstractSerializedData2.readString(z2);
                        this.data = abstractSerializedData2.readByteArray(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_keyboardButtonCallback, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.text);
                        abstractSerializedData2.writeByteArray(this.data);
                    }
                };
                break;
            default:
                tLRPC$TL_keyboardButton = null;
                break;
        }
        if (tLRPC$TL_keyboardButton == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in KeyboardButton", Integer.valueOf(i)));
        }
        if (tLRPC$TL_keyboardButton != null) {
            tLRPC$TL_keyboardButton.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_keyboardButton;
    }
}
