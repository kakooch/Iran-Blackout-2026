package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UpdateBoxStruct$NewSeqUpdate extends GeneratedMessageLite implements U64 {
    private static final UpdateBoxStruct$NewSeqUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int ROUTE_ID_FIELD_NUMBER = 5;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 2;
    public static final int UPDATE_FIELD_NUMBER = 4;
    public static final int UPDATE_HEADER_FIELD_NUMBER = 3;
    private int bitField0_;
    private Int32Value routeId_;
    private int seq_;
    private AbstractC2383g state_;
    private int updateHeader_;
    private AbstractC2383g update_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UpdateBoxStruct$NewSeqUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        UpdateBoxStruct$NewSeqUpdate updateBoxStruct$NewSeqUpdate = new UpdateBoxStruct$NewSeqUpdate();
        DEFAULT_INSTANCE = updateBoxStruct$NewSeqUpdate;
        GeneratedMessageLite.registerDefaultInstance(UpdateBoxStruct$NewSeqUpdate.class, updateBoxStruct$NewSeqUpdate);
    }

    private UpdateBoxStruct$NewSeqUpdate() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.state_ = abstractC2383g;
        this.update_ = abstractC2383g;
    }

    private void clearRouteId() {
        this.routeId_ = null;
        this.bitField0_ &= -2;
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

    public static UpdateBoxStruct$NewSeqUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRouteId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.routeId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.routeId_ = int32Value;
        } else {
            this.routeId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.routeId_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateBoxStruct$NewSeqUpdate parseDelimitedFrom(InputStream inputStream) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(ByteBuffer byteBuffer) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRouteId(Int32Value int32Value) {
        int32Value.getClass();
        this.routeId_ = int32Value;
        this.bitField0_ |= 1;
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
                return new UpdateBoxStruct$NewSeqUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002\n\u0003\u0004\u0004\n\u0005ဉ\u0000", new Object[]{"bitField0_", "seq_", "state_", "updateHeader_", "update_", "routeId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UpdateBoxStruct$NewSeqUpdate.class) {
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

    public Int32Value getRouteId() {
        Int32Value int32Value = this.routeId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
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

    public boolean hasRouteId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UpdateBoxStruct$NewSeqUpdate updateBoxStruct$NewSeqUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(updateBoxStruct$NewSeqUpdate);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(byte[] bArr) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(InputStream inputStream) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UpdateBoxStruct$NewSeqUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UpdateBoxStruct$NewSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
