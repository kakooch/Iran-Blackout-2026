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
public final class PushStruct$PlainNotifications extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final PushStruct$PlainNotifications DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j data_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$PlainNotifications.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$PlainNotifications pushStruct$PlainNotifications = new PushStruct$PlainNotifications();
        DEFAULT_INSTANCE = pushStruct$PlainNotifications;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$PlainNotifications.class, pushStruct$PlainNotifications);
    }

    private PushStruct$PlainNotifications() {
    }

    private void addAllData(Iterable<? extends PushStruct$NotificationData> iterable) {
        ensureDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.data_);
    }

    private void addData(PushStruct$NotificationData pushStruct$NotificationData) {
        pushStruct$NotificationData.getClass();
        ensureDataIsMutable();
        this.data_.add(pushStruct$NotificationData);
    }

    private void clearData() {
        this.data_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDataIsMutable() {
        B.j jVar = this.data_;
        if (jVar.u()) {
            return;
        }
        this.data_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PushStruct$PlainNotifications getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$PlainNotifications parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PlainNotifications parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeData(int i) {
        ensureDataIsMutable();
        this.data_.remove(i);
    }

    private void setData(int i, PushStruct$NotificationData pushStruct$NotificationData) {
        pushStruct$NotificationData.getClass();
        ensureDataIsMutable();
        this.data_.set(i, pushStruct$NotificationData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$PlainNotifications();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"data_", PushStruct$NotificationData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$PlainNotifications.class) {
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

    public PushStruct$NotificationData getData(int i) {
        return (PushStruct$NotificationData) this.data_.get(i);
    }

    public int getDataCount() {
        return this.data_.size();
    }

    public List<PushStruct$NotificationData> getDataList() {
        return this.data_;
    }

    public InterfaceC1884p1 getDataOrBuilder(int i) {
        return (InterfaceC1884p1) this.data_.get(i);
    }

    public List<? extends InterfaceC1884p1> getDataOrBuilderList() {
        return this.data_;
    }

    public static a newBuilder(PushStruct$PlainNotifications pushStruct$PlainNotifications) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$PlainNotifications);
    }

    public static PushStruct$PlainNotifications parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PlainNotifications parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$PlainNotifications parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addData(int i, PushStruct$NotificationData pushStruct$NotificationData) {
        pushStruct$NotificationData.getClass();
        ensureDataIsMutable();
        this.data_.add(i, pushStruct$NotificationData);
    }

    public static PushStruct$PlainNotifications parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$PlainNotifications parseFrom(byte[] bArr) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$PlainNotifications parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$PlainNotifications parseFrom(InputStream inputStream) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PlainNotifications parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PlainNotifications parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$PlainNotifications parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$PlainNotifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
