package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestLoadArchived extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestLoadArchived DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int NEXT_OFFSET_FIELD_NUMBER = 1;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private static final B.h.a optimizations_converter_ = new a();
    private int bitField0_;
    private int limit_;
    private BytesValue nextOffset_;
    private int optimizationsMemoizedSerializedSize;
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16902m35 a(Integer num) {
            EnumC16902m35 enumC16902m35J = EnumC16902m35.j(num.intValue());
            return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(MessagingOuterClass$RequestLoadArchived.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadArchived messagingOuterClass$RequestLoadArchived = new MessagingOuterClass$RequestLoadArchived();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadArchived;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadArchived.class, messagingOuterClass$RequestLoadArchived);
    }

    private MessagingOuterClass$RequestLoadArchived() {
    }

    private void addAllOptimizations(Iterable<? extends EnumC16902m35> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<? extends EnumC16902m35> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().getNumber());
        }
    }

    private void addAllOptimizationsValue(Iterable<Integer> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().intValue());
        }
    }

    private void addOptimizations(EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(enumC16902m35.getNumber());
    }

    private void addOptimizationsValue(int i) {
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(i);
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearNextOffset() {
        this.nextOffset_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MessagingOuterClass$RequestLoadArchived getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNextOffset(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.nextOffset_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.nextOffset_ = bytesValue;
        } else {
            this.nextOffset_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.nextOffset_).v(bytesValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadArchived parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLimit(int i) {
        this.limit_ = i;
    }

    private void setNextOffset(BytesValue bytesValue) {
        bytesValue.getClass();
        this.nextOffset_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setOptimizations(int i, EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, enumC16902m35.getNumber());
    }

    private void setOptimizationsValue(int i, int i2) {
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadArchived();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0004\u0003,", new Object[]{"bitField0_", "nextOffset_", "limit_", "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadArchived.class) {
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

    public int getLimit() {
        return this.limit_;
    }

    public BytesValue getNextOffset() {
        BytesValue bytesValue = this.nextOffset_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public EnumC16902m35 getOptimizations(int i) {
        EnumC16902m35 enumC16902m35J = EnumC16902m35.j(this.optimizations_.getInt(i));
        return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
    }

    public int getOptimizationsCount() {
        return this.optimizations_.size();
    }

    public List<EnumC16902m35> getOptimizationsList() {
        return new B.h(this.optimizations_, optimizations_converter_);
    }

    public int getOptimizationsValue(int i) {
        return this.optimizations_.getInt(i);
    }

    public List<Integer> getOptimizationsValueList() {
        return this.optimizations_;
    }

    public boolean hasNextOffset() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b newBuilder(MessagingOuterClass$RequestLoadArchived messagingOuterClass$RequestLoadArchived) {
        return (b) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadArchived);
    }

    public static MessagingOuterClass$RequestLoadArchived parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadArchived parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadArchived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
