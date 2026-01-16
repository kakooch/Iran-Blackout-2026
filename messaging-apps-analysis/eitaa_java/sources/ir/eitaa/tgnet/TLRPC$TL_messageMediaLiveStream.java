package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messageMediaLiveStream extends TLRPC$MessageMedia {
    public static int constructor = -873187034;
    public long access_hash;
    public boolean from_self;
    public long id;
    public TLRPC$LiveStreamState state;
    public ArrayList<TLRPC$PhotoSize> thumbs = new ArrayList<>();
    public int total_viewers;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.from_self = (int32 & 2) != 0;
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.total_viewers = stream.readInt32(exception);
        } else {
            this.total_viewers = -1;
        }
        this.state = TLRPC$LiveStreamState.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream, stream.readInt32(exception), exception);
                if (tLRPC$PhotoSizeTLdeserialize == null) {
                    return;
                }
                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.total_viewers);
        }
        this.state.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            stream.writeInt32(481674261);
            int size = this.thumbs.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.thumbs.get(i).serializeToStream(stream);
            }
        }
    }
}
