package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_urlAuthResultRequest extends TLRPC$UrlAuthResult {
    public static int constructor = -1831650802;
    public TLRPC$User bot;
    public String domain;
    public int flags;
    public boolean request_write_access;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.request_write_access = (int32 & 1) != 0;
        this.bot = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.domain = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.request_write_access ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.bot.serializeToStream(stream);
        stream.writeString(this.domain);
    }
}
