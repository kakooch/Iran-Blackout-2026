package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PushStruct$EncryptedNotifications extends GeneratedMessageLite implements U64 {
    private static final PushStruct$EncryptedNotifications DEFAULT_INSTANCE;
    public static final int ENCRYPTED_DATA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j encryptedData_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$EncryptedNotifications.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$EncryptedNotifications pushStruct$EncryptedNotifications = new PushStruct$EncryptedNotifications();
        DEFAULT_INSTANCE = pushStruct$EncryptedNotifications;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$EncryptedNotifications.class, pushStruct$EncryptedNotifications);
    }

    private PushStruct$EncryptedNotifications() {
    }

    private void addAllEncryptedData(Iterable<? extends AbstractC2383g> iterable) {
        ensureEncryptedDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.encryptedData_);
    }

    private void addEncryptedData(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        ensureEncryptedDataIsMutable();
        this.encryptedData_.add(abstractC2383g);
    }

    private void clearEncryptedData() {
        this.encryptedData_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureEncryptedDataIsMutable() {
        B.j jVar = this.encryptedData_;
        if (jVar.u()) {
            return;
        }
        this.encryptedData_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PushStruct$EncryptedNotifications getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$EncryptedNotifications parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$EncryptedNotifications parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEncryptedData(int i, AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        ensureEncryptedDataIsMutable();
        this.encryptedData_.set(i, abstractC2383g);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$EncryptedNotifications();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001c", new Object[]{"encryptedData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$EncryptedNotifications.class) {
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

    public AbstractC2383g getEncryptedData(int i) {
        return (AbstractC2383g) this.encryptedData_.get(i);
    }

    public int getEncryptedDataCount() {
        return this.encryptedData_.size();
    }

    public List<AbstractC2383g> getEncryptedDataList() {
        return this.encryptedData_;
    }

    public static a newBuilder(PushStruct$EncryptedNotifications pushStruct$EncryptedNotifications) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$EncryptedNotifications);
    }

    public static PushStruct$EncryptedNotifications parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$EncryptedNotifications parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$EncryptedNotifications parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$EncryptedNotifications parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$EncryptedNotifications parseFrom(byte[] bArr) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$EncryptedNotifications parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$EncryptedNotifications parseFrom(InputStream inputStream) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$EncryptedNotifications parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$EncryptedNotifications parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$EncryptedNotifications parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$EncryptedNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
