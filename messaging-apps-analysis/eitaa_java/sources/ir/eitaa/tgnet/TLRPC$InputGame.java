package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputGame extends TLObject {
    public long access_hash;
    public TLRPC$InputUser bot_id;
    public long id;
    public String short_name;

    public static TLRPC$InputGame TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputGame tLRPC$TL_inputGameShortName;
        if (constructor == -1020139510) {
            tLRPC$TL_inputGameShortName = new TLRPC$TL_inputGameShortName();
        } else {
            tLRPC$TL_inputGameShortName = constructor != 53231223 ? null : new TLRPC$InputGame() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputGameID
                public static int constructor = 53231223;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.id = stream2.readInt64(exception2);
                    this.access_hash = stream2.readInt64(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.id);
                    stream2.writeInt64(this.access_hash);
                }
            };
        }
        if (tLRPC$TL_inputGameShortName == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputGame", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputGameShortName != null) {
            tLRPC$TL_inputGameShortName.readParams(stream, exception);
        }
        return tLRPC$TL_inputGameShortName;
    }
}
