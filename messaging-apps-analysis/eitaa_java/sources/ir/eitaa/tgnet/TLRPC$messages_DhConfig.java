package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_DhConfig extends TLObject {
    public int g;
    public byte[] p;
    public byte[] random;
    public int version;

    public static TLRPC$messages_DhConfig TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_DhConfig tLRPC$messages_DhConfig;
        if (constructor == -1058912715) {
            tLRPC$messages_DhConfig = new TLRPC$messages_DhConfig() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_dhConfigNotModified
                public static int constructor = -1058912715;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.random = stream2.readByteArray(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeByteArray(this.random);
                }
            };
        } else {
            tLRPC$messages_DhConfig = constructor != 740433629 ? null : new TLRPC$messages_DhConfig() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_dhConfig
                public static int constructor = 740433629;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.g = stream2.readInt32(exception2);
                    this.p = stream2.readByteArray(exception2);
                    this.version = stream2.readInt32(exception2);
                    this.random = stream2.readByteArray(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.g);
                    stream2.writeByteArray(this.p);
                    stream2.writeInt32(this.version);
                    stream2.writeByteArray(this.random);
                }
            };
        }
        if (tLRPC$messages_DhConfig == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_DhConfig", Integer.valueOf(constructor)));
        }
        if (tLRPC$messages_DhConfig != null) {
            tLRPC$messages_DhConfig.readParams(stream, exception);
        }
        return tLRPC$messages_DhConfig;
    }
}
