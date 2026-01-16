package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$ArrayValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$ResponseGetBotWhiteList extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$ResponseGetBotWhiteList DEFAULT_INSTANCE;
    public static final int LIST_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$ArrayValue list_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetBotWhiteList.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseGetBotWhiteList ketfOuterClass$ResponseGetBotWhiteList = new KetfOuterClass$ResponseGetBotWhiteList();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetBotWhiteList;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetBotWhiteList.class, ketfOuterClass$ResponseGetBotWhiteList);
    }

    private KetfOuterClass$ResponseGetBotWhiteList() {
    }

    private void clearList() {
        this.list_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfOuterClass$ResponseGetBotWhiteList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeList(CollectionsStruct$ArrayValue collectionsStruct$ArrayValue) {
        collectionsStruct$ArrayValue.getClass();
        CollectionsStruct$ArrayValue collectionsStruct$ArrayValue2 = this.list_;
        if (collectionsStruct$ArrayValue2 == null || collectionsStruct$ArrayValue2 == CollectionsStruct$ArrayValue.getDefaultInstance()) {
            this.list_ = collectionsStruct$ArrayValue;
        } else {
            this.list_ = (CollectionsStruct$ArrayValue) ((CollectionsStruct$ArrayValue.a) CollectionsStruct$ArrayValue.newBuilder(this.list_).v(collectionsStruct$ArrayValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setList(CollectionsStruct$ArrayValue collectionsStruct$ArrayValue) {
        collectionsStruct$ArrayValue.getClass();
        this.list_ = collectionsStruct$ArrayValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetBotWhiteList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "list_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetBotWhiteList.class) {
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

    public CollectionsStruct$ArrayValue getList() {
        CollectionsStruct$ArrayValue collectionsStruct$ArrayValue = this.list_;
        return collectionsStruct$ArrayValue == null ? CollectionsStruct$ArrayValue.getDefaultInstance() : collectionsStruct$ArrayValue;
    }

    public boolean hasList() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$ResponseGetBotWhiteList ketfOuterClass$ResponseGetBotWhiteList) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetBotWhiteList);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetBotWhiteList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
