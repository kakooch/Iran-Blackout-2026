package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaPoll extends TLRPC$InputMedia {
    public static int constructor = 261416433;
    public TLRPC$Poll poll;
    public String solution;
    public ArrayList<byte[]> correct_answers = new ArrayList<>();
    public ArrayList<TLRPC$MessageEntity> solution_entities = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.poll = TLRPC$Poll.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            } else {
                int int322 = stream.readInt32(exception);
                for (int i = 0; i < int322; i++) {
                    this.correct_answers.add(stream.readByteArray(exception));
                }
            }
        }
        if ((this.flags & 2) != 0) {
            this.solution = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            int int323 = stream.readInt32(exception);
            if (int323 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                }
                return;
            }
            int int324 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int324; i2++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.solution_entities.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.poll.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.correct_answers.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                stream.writeByteArray(this.correct_answers.get(i));
            }
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.solution);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.solution_entities.size();
            stream.writeInt32(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                this.solution_entities.get(i2).serializeToStream(stream);
            }
        }
    }
}
