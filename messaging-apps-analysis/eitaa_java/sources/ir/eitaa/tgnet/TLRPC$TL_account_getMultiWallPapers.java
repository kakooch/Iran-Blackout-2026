package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getMultiWallPapers extends TLObject {
    public static int constructor = 1705865692;
    public ArrayList<TLRPC$InputWallPaper> wallpapers = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            TLRPC$WallPaper tLRPC$WallPaperTLdeserialize = TLRPC$WallPaper.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$WallPaperTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$WallPaperTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.wallpapers.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.wallpapers.get(i).serializeToStream(stream);
        }
    }
}
