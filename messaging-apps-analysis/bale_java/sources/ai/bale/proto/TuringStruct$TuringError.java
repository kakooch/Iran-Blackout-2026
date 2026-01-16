package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TuringStruct$TuringError extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final TuringStruct$TuringError DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int code_;
    private CollectionsStruct$MapValue details_;
    private String message_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TuringStruct$TuringError.DEFAULT_INSTANCE);
        }
    }

    static {
        TuringStruct$TuringError turingStruct$TuringError = new TuringStruct$TuringError();
        DEFAULT_INSTANCE = turingStruct$TuringError;
        GeneratedMessageLite.registerDefaultInstance(TuringStruct$TuringError.class, turingStruct$TuringError);
    }

    private TuringStruct$TuringError() {
    }

    private void clearCode() {
        this.code_ = 0;
    }

    private void clearDetails() {
        this.details_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    public static TuringStruct$TuringError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDetails(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.details_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.details_ = collectionsStruct$MapValue;
        } else {
            this.details_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.details_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TuringStruct$TuringError parseDelimitedFrom(InputStream inputStream) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$TuringError parseFrom(ByteBuffer byteBuffer) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(int i) {
        this.code_ = i;
    }

    private void setDetails(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.details_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    private void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    private void setMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (n2.a[gVar.ordinal()]) {
            case 1:
                return new TuringStruct$TuringError();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "code_", "message_", "details_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TuringStruct$TuringError.class) {
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

    public int getCode() {
        return this.code_;
    }

    public CollectionsStruct$MapValue getDetails() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.details_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public boolean hasDetails() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(TuringStruct$TuringError turingStruct$TuringError) {
        return (a) DEFAULT_INSTANCE.createBuilder(turingStruct$TuringError);
    }

    public static TuringStruct$TuringError parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$TuringError parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TuringStruct$TuringError parseFrom(AbstractC2383g abstractC2383g) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TuringStruct$TuringError parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TuringStruct$TuringError parseFrom(byte[] bArr) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TuringStruct$TuringError parseFrom(byte[] bArr, C2394s c2394s) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TuringStruct$TuringError parseFrom(InputStream inputStream) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$TuringError parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$TuringError parseFrom(AbstractC2384h abstractC2384h) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TuringStruct$TuringError parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TuringStruct$TuringError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
