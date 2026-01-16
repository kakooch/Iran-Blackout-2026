package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class Misc$ResponseSeqDate extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 2;
    private static final Misc$ResponseSeqDate DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 3;
    private long date_;
    private int seq_;
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private AbstractC2383g state_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Misc$ResponseSeqDate.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        Misc$ResponseSeqDate misc$ResponseSeqDate = new Misc$ResponseSeqDate();
        DEFAULT_INSTANCE = misc$ResponseSeqDate;
        GeneratedMessageLite.registerDefaultInstance(Misc$ResponseSeqDate.class, misc$ResponseSeqDate);
    }

    private Misc$ResponseSeqDate() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    public static Misc$ResponseSeqDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtMap() {
        return internalGetMutableExt();
    }

    private com.google.protobuf.J internalGetExt() {
        return this.ext_;
    }

    private com.google.protobuf.J internalGetMutableExt() {
        if (!this.ext_.n()) {
            this.ext_ = this.ext_.s();
        }
        return this.ext_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Misc$ResponseSeqDate parseDelimitedFrom(InputStream inputStream) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$ResponseSeqDate parseFrom(ByteBuffer byteBuffer) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    public boolean containsExt(String str) {
        str.getClass();
        return internalGetExt().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (N0.a[gVar.ordinal()]) {
            case 1:
                return new Misc$ResponseSeqDate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001\u0004\u0002\u0002\u0003\n\u00042", new Object[]{"seq_", "date_", "state_", "ext_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Misc$ResponseSeqDate.class) {
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

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExt() {
        return getExtMap();
    }

    public int getExtCount() {
        return internalGetExt().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtMap() {
        return Collections.unmodifiableMap(internalGetExt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        return jInternalGetExt.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExt.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        if (jInternalGetExt.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExt.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public static a newBuilder(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return (a) DEFAULT_INSTANCE.createBuilder(misc$ResponseSeqDate);
    }

    public static Misc$ResponseSeqDate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$ResponseSeqDate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Misc$ResponseSeqDate parseFrom(AbstractC2383g abstractC2383g) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Misc$ResponseSeqDate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Misc$ResponseSeqDate parseFrom(byte[] bArr) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Misc$ResponseSeqDate parseFrom(byte[] bArr, C2394s c2394s) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Misc$ResponseSeqDate parseFrom(InputStream inputStream) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$ResponseSeqDate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$ResponseSeqDate parseFrom(AbstractC2384h abstractC2384h) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Misc$ResponseSeqDate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Misc$ResponseSeqDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
