package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$ChatParticipant extends TLObject {
    public int date;
    public long inviter_id;
    public long user_id;

    public static TLRPC$ChatParticipant TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChatParticipant tLRPC$TL_chatParticipantAdmin;
        switch (constructor) {
            case -1600962725:
                tLRPC$TL_chatParticipantAdmin = new TLRPC$TL_chatParticipantAdmin();
                break;
            case -1070776313:
                tLRPC$TL_chatParticipantAdmin = new TLRPC$TL_chatParticipant();
                break;
            case -925415106:
                tLRPC$TL_chatParticipantAdmin = new TLRPC$TL_chatParticipant() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatParticipant_layer131
                    public static int constructor = -925415106;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipant, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                        this.inviter_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipant, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32((int) this.inviter_id);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case -636267638:
                tLRPC$TL_chatParticipantAdmin = new TLRPC$TL_chatParticipantCreator() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatParticipantCreator_layer131
                    public static int constructor = -636267638;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                    }
                };
                break;
            case -489233354:
                tLRPC$TL_chatParticipantAdmin = new TLRPC$TL_chatParticipantAdmin() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin_layer131
                    public static int constructor = -489233354;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                        this.inviter_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32((int) this.inviter_id);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case -462696732:
                tLRPC$TL_chatParticipantAdmin = new TLRPC$TL_chatParticipantCreator();
                break;
            default:
                tLRPC$TL_chatParticipantAdmin = null;
                break;
        }
        if (tLRPC$TL_chatParticipantAdmin == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatParticipant", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_chatParticipantAdmin != null) {
            tLRPC$TL_chatParticipantAdmin.readParams(stream, exception);
        }
        return tLRPC$TL_chatParticipantAdmin;
    }
}
