package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_wallPapers extends TLRPC$account_WallPapers {
    public static int constructor = -842824308;
    public long hash;
    public ArrayList<TLRPC$WallPaper> wallpapers = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.hash = stream.readInt64(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$WallPaper tLRPC$WallPaperTLdeserialize = TLRPC$WallPaper.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$WallPaperTLdeserialize == null) {
                return;
            }
            this.wallpapers.add(tLRPC$WallPaperTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
        stream.writeInt32(481674261);
        int size = this.wallpapers.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.wallpapers.get(i).serializeToStream(stream);
        }
    }
}
