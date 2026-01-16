package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9833ae0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BcmsStruct$NSFWGroup extends GeneratedMessageLite implements InterfaceC9833ae0 {
    private static final BcmsStruct$NSFWGroup DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SEVERITY_FIELD_NUMBER = 2;
    private long id_;
    private float severity_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9833ae0 {
        private a() {
            super(BcmsStruct$NSFWGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        BcmsStruct$NSFWGroup bcmsStruct$NSFWGroup = new BcmsStruct$NSFWGroup();
        DEFAULT_INSTANCE = bcmsStruct$NSFWGroup;
        GeneratedMessageLite.registerDefaultInstance(BcmsStruct$NSFWGroup.class, bcmsStruct$NSFWGroup);
    }

    private BcmsStruct$NSFWGroup() {
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearSeverity() {
        this.severity_ = 0.0f;
    }

    public static BcmsStruct$NSFWGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BcmsStruct$NSFWGroup parseDelimitedFrom(InputStream inputStream) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$NSFWGroup parseFrom(ByteBuffer byteBuffer) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setSeverity(float f) {
        this.severity_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1885q.a[gVar.ordinal()]) {
            case 1:
                return new BcmsStruct$NSFWGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0001", new Object[]{"id_", "severity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BcmsStruct$NSFWGroup.class) {
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

    public long getId() {
        return this.id_;
    }

    public float getSeverity() {
        return this.severity_;
    }

    public static a newBuilder(BcmsStruct$NSFWGroup bcmsStruct$NSFWGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcmsStruct$NSFWGroup);
    }

    public static BcmsStruct$NSFWGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$NSFWGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BcmsStruct$NSFWGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BcmsStruct$NSFWGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BcmsStruct$NSFWGroup parseFrom(byte[] bArr) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BcmsStruct$NSFWGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BcmsStruct$NSFWGroup parseFrom(InputStream inputStream) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$NSFWGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$NSFWGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BcmsStruct$NSFWGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BcmsStruct$NSFWGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
