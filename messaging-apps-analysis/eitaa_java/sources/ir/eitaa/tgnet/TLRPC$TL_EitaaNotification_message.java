package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_EitaaNotification_message extends TLObject {
    public static int constructor = -2120836403;
    public TLRPC$PhotoSize banner;
    public int flags;
    public String message;
    public TLRPC$PhotoSize photo;
    public String title;
    public ArrayList<TLRPC$MessageEntity> entity = new ArrayList<>();
    public ArrayList<TLRPC$TL_EitaaNotification_button> button = new ArrayList<>();

    public static TLRPC$TL_EitaaNotification_message TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_message_notification", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_EitaaNotification_message tLRPC$TL_EitaaNotification_message = new TLRPC$TL_EitaaNotification_message();
        tLRPC$TL_EitaaNotification_message.readParams(stream, exception);
        return tLRPC$TL_EitaaNotification_message;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.title = stream.readString(exception);
        this.message = stream.readString(exception);
        if ((this.flags & 1) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.entity.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
        if ((this.flags & 2) != 0) {
            this.photo = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 4) != 0) {
            int int323 = stream.readInt32(exception);
            if (int323 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                }
                return;
            }
            int int324 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int324; i2++) {
                TLRPC$TL_EitaaNotification_button tLRPC$TL_EitaaNotification_buttonTLdeserialize = TLRPC$TL_EitaaNotification_button.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$TL_EitaaNotification_buttonTLdeserialize == null) {
                    return;
                }
                this.button.add(tLRPC$TL_EitaaNotification_buttonTLdeserialize);
            }
        }
        if ((this.flags & 8) != 0) {
            this.banner = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.title);
        stream.writeString(this.message);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.entity.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.entity.get(i).serializeToStream(stream);
            }
        }
        if ((this.flags & 2) != 0) {
            this.photo.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.button.size();
            stream.writeInt32(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                this.button.get(i2).serializeToStream(stream);
            }
        }
        if ((this.flags & 8) != 0) {
            this.banner.serializeToStream(stream);
        }
    }
}
