package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CollectionsStruct$MultiLanguageTag extends GeneratedMessageLite implements U64 {
    private static final CollectionsStruct$MultiLanguageTag DEFAULT_INSTANCE;
    public static final int EN_FIELD_NUMBER = 2;
    public static final int FA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$StringValue en_;
    private CollectionsStruct$StringValue fa_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CollectionsStruct$MultiLanguageTag.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag = new CollectionsStruct$MultiLanguageTag();
        DEFAULT_INSTANCE = collectionsStruct$MultiLanguageTag;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$MultiLanguageTag.class, collectionsStruct$MultiLanguageTag);
    }

    private CollectionsStruct$MultiLanguageTag() {
    }

    private void clearEn() {
        this.en_ = null;
        this.bitField0_ &= -3;
    }

    private void clearFa() {
        this.fa_ = null;
        this.bitField0_ &= -2;
    }

    public static CollectionsStruct$MultiLanguageTag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEn(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.en_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.en_ = collectionsStruct$StringValue;
        } else {
            this.en_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.en_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeFa(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.fa_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.fa_ = collectionsStruct$StringValue;
        } else {
            this.fa_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.fa_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$MultiLanguageTag parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEn(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.en_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    private void setFa(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.fa_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$MultiLanguageTag();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "fa_", "en_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$MultiLanguageTag.class) {
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

    public CollectionsStruct$StringValue getEn() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.en_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public CollectionsStruct$StringValue getFa() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.fa_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasEn() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFa() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$MultiLanguageTag);
    }

    public static CollectionsStruct$MultiLanguageTag parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(byte[] bArr) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(InputStream inputStream) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$MultiLanguageTag parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$MultiLanguageTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
