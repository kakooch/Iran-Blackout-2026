package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapOuterClass$ResponseDeliverOtp extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$ResponseDeliverOtp DEFAULT_INSTANCE;
    public static final int IS_DONE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$BooleanValue isDone_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseDeliverOtp.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseDeliverOtp sapOuterClass$ResponseDeliverOtp = new SapOuterClass$ResponseDeliverOtp();
        DEFAULT_INSTANCE = sapOuterClass$ResponseDeliverOtp;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseDeliverOtp.class, sapOuterClass$ResponseDeliverOtp);
    }

    private SapOuterClass$ResponseDeliverOtp() {
    }

    private void clearIsDone() {
        this.isDone_ = null;
        this.bitField0_ &= -2;
    }

    public static SapOuterClass$ResponseDeliverOtp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsDone(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.isDone_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.isDone_ = collectionsStruct$BooleanValue;
        } else {
            this.isDone_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.isDone_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseDeliverOtp parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsDone(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.isDone_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseDeliverOtp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "isDone_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseDeliverOtp.class) {
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

    public CollectionsStruct$BooleanValue getIsDone() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.isDone_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public boolean hasIsDone() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SapOuterClass$ResponseDeliverOtp sapOuterClass$ResponseDeliverOtp) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseDeliverOtp);
    }

    public static SapOuterClass$ResponseDeliverOtp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseDeliverOtp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
