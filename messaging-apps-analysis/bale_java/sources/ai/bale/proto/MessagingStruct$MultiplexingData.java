package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC21409tc4;
import ir.nasim.InterfaceC20789sc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$MultiplexingData extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$MultiplexingData DEFAULT_INSTANCE;
    public static final int MULTIPLEXING_ROWS_FIELD_NUMBER = 2;
    public static final int MULTIPLEXING_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j multiplexingRows_ = GeneratedMessageLite.emptyProtobufList();
    private int multiplexingType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$MultiplexingData.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$MultiplexingData messagingStruct$MultiplexingData = new MessagingStruct$MultiplexingData();
        DEFAULT_INSTANCE = messagingStruct$MultiplexingData;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$MultiplexingData.class, messagingStruct$MultiplexingData);
    }

    private MessagingStruct$MultiplexingData() {
    }

    private void addAllMultiplexingRows(Iterable<? extends MessagingStruct$MultiplexingRow> iterable) {
        ensureMultiplexingRowsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.multiplexingRows_);
    }

    private void addMultiplexingRows(MessagingStruct$MultiplexingRow messagingStruct$MultiplexingRow) {
        messagingStruct$MultiplexingRow.getClass();
        ensureMultiplexingRowsIsMutable();
        this.multiplexingRows_.add(messagingStruct$MultiplexingRow);
    }

    private void clearMultiplexingRows() {
        this.multiplexingRows_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMultiplexingType() {
        this.multiplexingType_ = 0;
    }

    private void ensureMultiplexingRowsIsMutable() {
        B.j jVar = this.multiplexingRows_;
        if (jVar.u()) {
            return;
        }
        this.multiplexingRows_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$MultiplexingData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$MultiplexingData parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MultiplexingData parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMultiplexingRows(int i) {
        ensureMultiplexingRowsIsMutable();
        this.multiplexingRows_.remove(i);
    }

    private void setMultiplexingRows(int i, MessagingStruct$MultiplexingRow messagingStruct$MultiplexingRow) {
        messagingStruct$MultiplexingRow.getClass();
        ensureMultiplexingRowsIsMutable();
        this.multiplexingRows_.set(i, messagingStruct$MultiplexingRow);
    }

    private void setMultiplexingType(EnumC21409tc4 enumC21409tc4) {
        this.multiplexingType_ = enumC21409tc4.getNumber();
    }

    private void setMultiplexingTypeValue(int i) {
        this.multiplexingType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$MultiplexingData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"multiplexingType_", "multiplexingRows_", MessagingStruct$MultiplexingRow.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$MultiplexingData.class) {
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

    public MessagingStruct$MultiplexingRow getMultiplexingRows(int i) {
        return (MessagingStruct$MultiplexingRow) this.multiplexingRows_.get(i);
    }

    public int getMultiplexingRowsCount() {
        return this.multiplexingRows_.size();
    }

    public List<MessagingStruct$MultiplexingRow> getMultiplexingRowsList() {
        return this.multiplexingRows_;
    }

    public InterfaceC20789sc4 getMultiplexingRowsOrBuilder(int i) {
        return (InterfaceC20789sc4) this.multiplexingRows_.get(i);
    }

    public List<? extends InterfaceC20789sc4> getMultiplexingRowsOrBuilderList() {
        return this.multiplexingRows_;
    }

    public EnumC21409tc4 getMultiplexingType() {
        EnumC21409tc4 enumC21409tc4J = EnumC21409tc4.j(this.multiplexingType_);
        return enumC21409tc4J == null ? EnumC21409tc4.UNRECOGNIZED : enumC21409tc4J;
    }

    public int getMultiplexingTypeValue() {
        return this.multiplexingType_;
    }

    public static a newBuilder(MessagingStruct$MultiplexingData messagingStruct$MultiplexingData) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$MultiplexingData);
    }

    public static MessagingStruct$MultiplexingData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MultiplexingData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$MultiplexingData parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMultiplexingRows(int i, MessagingStruct$MultiplexingRow messagingStruct$MultiplexingRow) {
        messagingStruct$MultiplexingRow.getClass();
        ensureMultiplexingRowsIsMutable();
        this.multiplexingRows_.add(i, messagingStruct$MultiplexingRow);
    }

    public static MessagingStruct$MultiplexingData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$MultiplexingData parseFrom(byte[] bArr) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$MultiplexingData parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$MultiplexingData parseFrom(InputStream inputStream) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MultiplexingData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MultiplexingData parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$MultiplexingData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$MultiplexingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
