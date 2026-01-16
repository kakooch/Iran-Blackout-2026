package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$NotificationData extends GeneratedMessageLite implements InterfaceC1884p1 {
    private static final PushStruct$NotificationData DEFAULT_INSTANCE;
    public static final int LEGACY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int dataCase_ = 0;
    private Object data_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1884p1 {
        private a() {
            super(PushStruct$NotificationData.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        LEGACY(1),
        DATA_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return DATA_NOT_SET;
            }
            if (i != 1) {
                return null;
            }
            return LEGACY;
        }
    }

    static {
        PushStruct$NotificationData pushStruct$NotificationData = new PushStruct$NotificationData();
        DEFAULT_INSTANCE = pushStruct$NotificationData;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$NotificationData.class, pushStruct$NotificationData);
    }

    private PushStruct$NotificationData() {
    }

    private void clearData() {
        this.dataCase_ = 0;
        this.data_ = null;
    }

    private void clearLegacy() {
        if (this.dataCase_ == 1) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    public static PushStruct$NotificationData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$NotificationData parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$NotificationData parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLegacy(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.dataCase_ = 1;
        this.data_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$NotificationData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001=\u0000", new Object[]{"data_", "dataCase_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$NotificationData.class) {
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

    public b getDataCase() {
        return b.j(this.dataCase_);
    }

    public AbstractC2383g getLegacy() {
        return this.dataCase_ == 1 ? (AbstractC2383g) this.data_ : AbstractC2383g.b;
    }

    public boolean hasLegacy() {
        return this.dataCase_ == 1;
    }

    public static a newBuilder(PushStruct$NotificationData pushStruct$NotificationData) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$NotificationData);
    }

    public static PushStruct$NotificationData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$NotificationData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$NotificationData parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$NotificationData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$NotificationData parseFrom(byte[] bArr) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$NotificationData parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$NotificationData parseFrom(InputStream inputStream) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$NotificationData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$NotificationData parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$NotificationData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$NotificationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
