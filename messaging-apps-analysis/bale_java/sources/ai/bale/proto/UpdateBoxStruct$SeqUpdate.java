package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UpdateBoxStruct$SeqUpdate extends GeneratedMessageLite implements U64 {
    private static final UpdateBoxStruct$SeqUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 2;
    public static final int UPDATE_FIELD_NUMBER = 4;
    public static final int UPDATE_HEADER_FIELD_NUMBER = 3;
    private int seq_;
    private AbstractC2383g state_;
    private int updateHeader_;
    private AbstractC2383g update_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UpdateBoxStruct$SeqUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        UpdateBoxStruct$SeqUpdate updateBoxStruct$SeqUpdate = new UpdateBoxStruct$SeqUpdate();
        DEFAULT_INSTANCE = updateBoxStruct$SeqUpdate;
        GeneratedMessageLite.registerDefaultInstance(UpdateBoxStruct$SeqUpdate.class, updateBoxStruct$SeqUpdate);
    }

    private UpdateBoxStruct$SeqUpdate() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.state_ = abstractC2383g;
        this.update_ = abstractC2383g;
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    private void clearUpdate() {
        this.update_ = getDefaultInstance().getUpdate();
    }

    private void clearUpdateHeader() {
        this.updateHeader_ = 0;
    }

    public static UpdateBoxStruct$SeqUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateBoxStruct$SeqUpdate parseDelimitedFrom(InputStream inputStream) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(ByteBuffer byteBuffer) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    private void setUpdate(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.update_ = abstractC2383g;
    }

    private void setUpdateHeader(int i) {
        this.updateHeader_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (o2.a[gVar.ordinal()]) {
            case 1:
                return new UpdateBoxStruct$SeqUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\n\u0003\u0004\u0004\n", new Object[]{"seq_", "state_", "updateHeader_", "update_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UpdateBoxStruct$SeqUpdate.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public AbstractC2383g getUpdate() {
        return this.update_;
    }

    public int getUpdateHeader() {
        return this.updateHeader_;
    }

    public static a newBuilder(UpdateBoxStruct$SeqUpdate updateBoxStruct$SeqUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(updateBoxStruct$SeqUpdate);
    }

    public static UpdateBoxStruct$SeqUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(byte[] bArr) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(InputStream inputStream) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UpdateBoxStruct$SeqUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
