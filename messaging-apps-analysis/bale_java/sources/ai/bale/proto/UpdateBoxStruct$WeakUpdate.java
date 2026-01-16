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
public final class UpdateBoxStruct$WeakUpdate extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final UpdateBoxStruct$WeakUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPDATE_FIELD_NUMBER = 3;
    public static final int UPDATE_HEADER_FIELD_NUMBER = 2;
    private long date_;
    private int updateHeader_;
    private AbstractC2383g update_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UpdateBoxStruct$WeakUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        UpdateBoxStruct$WeakUpdate updateBoxStruct$WeakUpdate = new UpdateBoxStruct$WeakUpdate();
        DEFAULT_INSTANCE = updateBoxStruct$WeakUpdate;
        GeneratedMessageLite.registerDefaultInstance(UpdateBoxStruct$WeakUpdate.class, updateBoxStruct$WeakUpdate);
    }

    private UpdateBoxStruct$WeakUpdate() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearUpdate() {
        this.update_ = getDefaultInstance().getUpdate();
    }

    private void clearUpdateHeader() {
        this.updateHeader_ = 0;
    }

    public static UpdateBoxStruct$WeakUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateBoxStruct$WeakUpdate parseDelimitedFrom(InputStream inputStream) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(ByteBuffer byteBuffer) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
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
                return new UpdateBoxStruct$WeakUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\n", new Object[]{"date_", "updateHeader_", "update_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UpdateBoxStruct$WeakUpdate.class) {
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

    public long getDate() {
        return this.date_;
    }

    public AbstractC2383g getUpdate() {
        return this.update_;
    }

    public int getUpdateHeader() {
        return this.updateHeader_;
    }

    public static a newBuilder(UpdateBoxStruct$WeakUpdate updateBoxStruct$WeakUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(updateBoxStruct$WeakUpdate);
    }

    public static UpdateBoxStruct$WeakUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(byte[] bArr) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(InputStream inputStream) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UpdateBoxStruct$WeakUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UpdateBoxStruct$WeakUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
