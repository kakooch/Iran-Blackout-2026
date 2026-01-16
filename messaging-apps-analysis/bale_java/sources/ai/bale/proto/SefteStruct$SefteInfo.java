package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21568tl6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SefteStruct$SefteInfo extends GeneratedMessageLite implements InterfaceC21568tl6 {
    public static final int CREATION_TIME_FIELD_NUMBER = 4;
    private static final SefteStruct$SefteInfo DEFAULT_INSTANCE;
    public static final int DU_TO_FIELD_NUMBER = 3;
    public static final int NUMBER_OF_GEMS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PAY_TO_FIELD_NUMBER = 1;
    private long numberOfGems_;
    private String payTo_ = "";
    private String duTo_ = "";
    private String creationTime_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21568tl6 {
        private a() {
            super(SefteStruct$SefteInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteStruct$SefteInfo sefteStruct$SefteInfo = new SefteStruct$SefteInfo();
        DEFAULT_INSTANCE = sefteStruct$SefteInfo;
        GeneratedMessageLite.registerDefaultInstance(SefteStruct$SefteInfo.class, sefteStruct$SefteInfo);
    }

    private SefteStruct$SefteInfo() {
    }

    private void clearCreationTime() {
        this.creationTime_ = getDefaultInstance().getCreationTime();
    }

    private void clearDuTo() {
        this.duTo_ = getDefaultInstance().getDuTo();
    }

    private void clearNumberOfGems() {
        this.numberOfGems_ = 0L;
    }

    private void clearPayTo() {
        this.payTo_ = getDefaultInstance().getPayTo();
    }

    public static SefteStruct$SefteInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteStruct$SefteInfo parseDelimitedFrom(InputStream inputStream) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteStruct$SefteInfo parseFrom(ByteBuffer byteBuffer) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCreationTime(String str) {
        str.getClass();
        this.creationTime_ = str;
    }

    private void setCreationTimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.creationTime_ = abstractC2383g.f0();
    }

    private void setDuTo(String str) {
        str.getClass();
        this.duTo_ = str;
    }

    private void setDuToBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.duTo_ = abstractC2383g.f0();
    }

    private void setNumberOfGems(long j) {
        this.numberOfGems_ = j;
    }

    private void setPayTo(String str) {
        str.getClass();
        this.payTo_ = str;
    }

    private void setPayToBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.payTo_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Q1.a[gVar.ordinal()]) {
            case 1:
                return new SefteStruct$SefteInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ", new Object[]{"payTo_", "numberOfGems_", "duTo_", "creationTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteStruct$SefteInfo.class) {
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

    public String getCreationTime() {
        return this.creationTime_;
    }

    public AbstractC2383g getCreationTimeBytes() {
        return AbstractC2383g.N(this.creationTime_);
    }

    public String getDuTo() {
        return this.duTo_;
    }

    public AbstractC2383g getDuToBytes() {
        return AbstractC2383g.N(this.duTo_);
    }

    public long getNumberOfGems() {
        return this.numberOfGems_;
    }

    public String getPayTo() {
        return this.payTo_;
    }

    public AbstractC2383g getPayToBytes() {
        return AbstractC2383g.N(this.payTo_);
    }

    public static a newBuilder(SefteStruct$SefteInfo sefteStruct$SefteInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteStruct$SefteInfo);
    }

    public static SefteStruct$SefteInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteStruct$SefteInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteStruct$SefteInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteStruct$SefteInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteStruct$SefteInfo parseFrom(byte[] bArr) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteStruct$SefteInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteStruct$SefteInfo parseFrom(InputStream inputStream) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteStruct$SefteInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteStruct$SefteInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteStruct$SefteInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteStruct$SefteInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
