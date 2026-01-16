package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_sendMessageEmojiInteraction extends TLRPC$SendMessageAction {
    public static int constructor = 630664139;
    public String emoticon;
    public TLRPC$TL_dataJSON interaction;
    public int msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.emoticon = stream.readString(exception);
        this.msg_id = stream.readInt32(exception);
        this.interaction = TLRPC$TL_dataJSON.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.emoticon);
        stream.writeInt32(this.msg_id);
        this.interaction.serializeToStream(stream);
    }
}
