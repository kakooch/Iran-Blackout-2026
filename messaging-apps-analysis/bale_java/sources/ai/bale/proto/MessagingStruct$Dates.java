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
public final class MessagingStruct$Dates extends GeneratedMessageLite implements U64 {
    public static final int DATES_FIELD_NUMBER = 1;
    private static final MessagingStruct$Dates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int datesMemoizedSerializedSize = -1;
    private B.i dates_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$Dates.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$Dates messagingStruct$Dates = new MessagingStruct$Dates();
        DEFAULT_INSTANCE = messagingStruct$Dates;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$Dates.class, messagingStruct$Dates);
    }

    private MessagingStruct$Dates() {
    }

    private void addAllDates(Iterable<? extends Long> iterable) {
        ensureDatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dates_);
    }

    private void addDates(long j) {
        ensureDatesIsMutable();
        this.dates_.l1(j);
    }

    private void clearDates() {
        this.dates_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureDatesIsMutable() {
        B.i iVar = this.dates_;
        if (iVar.u()) {
            return;
        }
        this.dates_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static MessagingStruct$Dates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$Dates parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Dates parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDates(int i, long j) {
        ensureDatesIsMutable();
        this.dates_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$Dates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001%", new Object[]{"dates_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$Dates.class) {
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

    public long getDates(int i) {
        return this.dates_.getLong(i);
    }

    public int getDatesCount() {
        return this.dates_.size();
    }

    public List<Long> getDatesList() {
        return this.dates_;
    }

    public static a newBuilder(MessagingStruct$Dates messagingStruct$Dates) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$Dates);
    }

    public static MessagingStruct$Dates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Dates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$Dates parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$Dates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$Dates parseFrom(byte[] bArr) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$Dates parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$Dates parseFrom(InputStream inputStream) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Dates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Dates parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$Dates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$Dates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
