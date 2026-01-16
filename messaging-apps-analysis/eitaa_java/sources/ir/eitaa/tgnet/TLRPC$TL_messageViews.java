package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageViews extends TLObject {
    public static int constructor = 1163625789;
    public int flags;
    public int forwards;
    public TLRPC$MessageReplies replies;
    public int views;

    public static TLRPC$TL_messageViews TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messageViews", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messageViews tLRPC$TL_messageViews = new TLRPC$TL_messageViews();
        tLRPC$TL_messageViews.readParams(stream, exception);
        return tLRPC$TL_messageViews;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.views = stream.readInt32(exception);
        }
        if ((this.flags & 2) != 0) {
            this.forwards = stream.readInt32(exception);
        }
        if ((this.flags & 4) != 0) {
            this.replies = TLRPC$MessageReplies.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.views);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.forwards);
        }
        if ((this.flags & 4) != 0) {
            this.replies.serializeToStream(stream);
        }
    }
}
