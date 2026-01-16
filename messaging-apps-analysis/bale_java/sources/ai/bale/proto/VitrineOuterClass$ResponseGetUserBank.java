package ai.bale.proto;

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
public final class VitrineOuterClass$ResponseGetUserBank extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 2;
    private static final VitrineOuterClass$ResponseGetUserBank DEFAULT_INSTANCE;
    public static final int IS_CHANGED_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private String data_ = "";
    private boolean isChanged_;
    private long version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$ResponseGetUserBank.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$ResponseGetUserBank vitrineOuterClass$ResponseGetUserBank = new VitrineOuterClass$ResponseGetUserBank();
        DEFAULT_INSTANCE = vitrineOuterClass$ResponseGetUserBank;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$ResponseGetUserBank.class, vitrineOuterClass$ResponseGetUserBank);
    }

    private VitrineOuterClass$ResponseGetUserBank() {
    }

    private void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    private void clearIsChanged() {
        this.isChanged_ = false;
    }

    private void clearVersion() {
        this.version_ = 0L;
    }

    public static VitrineOuterClass$ResponseGetUserBank getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$ResponseGetUserBank parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(String str) {
        str.getClass();
        this.data_ = str;
    }

    private void setDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.data_ = abstractC2383g.f0();
    }

    private void setIsChanged(boolean z) {
        this.isChanged_ = z;
    }

    private void setVersion(long j) {
        this.version_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$ResponseGetUserBank();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0007", new Object[]{"version_", "data_", "isChanged_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$ResponseGetUserBank.class) {
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

    public String getData() {
        return this.data_;
    }

    public AbstractC2383g getDataBytes() {
        return AbstractC2383g.N(this.data_);
    }

    public boolean getIsChanged() {
        return this.isChanged_;
    }

    public long getVersion() {
        return this.version_;
    }

    public static a newBuilder(VitrineOuterClass$ResponseGetUserBank vitrineOuterClass$ResponseGetUserBank) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$ResponseGetUserBank);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(byte[] bArr) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$ResponseGetUserBank parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
