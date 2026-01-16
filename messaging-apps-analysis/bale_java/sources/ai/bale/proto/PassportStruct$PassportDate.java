package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportDate extends GeneratedMessageLite implements U64 {
    private static final PassportStruct$PassportDate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UNIX_MILLI_FIELD_NUMBER = 1;
    private long unixMilli_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((PassportStruct$PassportDate) this.b).setUnixMilli(j);
            return this;
        }

        private a() {
            super(PassportStruct$PassportDate.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportStruct$PassportDate passportStruct$PassportDate = new PassportStruct$PassportDate();
        DEFAULT_INSTANCE = passportStruct$PassportDate;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportDate.class, passportStruct$PassportDate);
    }

    private PassportStruct$PassportDate() {
    }

    private void clearUnixMilli() {
        this.unixMilli_ = 0L;
    }

    public static PassportStruct$PassportDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportDate parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportDate parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnixMilli(long j) {
        this.unixMilli_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportDate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"unixMilli_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportDate.class) {
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

    public long getUnixMilli() {
        return this.unixMilli_;
    }

    public static a newBuilder(PassportStruct$PassportDate passportStruct$PassportDate) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportDate);
    }

    public static PassportStruct$PassportDate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportDate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportDate parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportStruct$PassportDate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportDate parseFrom(byte[] bArr) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportDate parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportDate parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportDate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportDate parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportDate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
