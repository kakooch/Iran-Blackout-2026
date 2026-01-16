package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MavizStreamOuterClass$GroupEvents extends GeneratedMessageLite implements U64 {
    private static final MavizStreamOuterClass$GroupEvents DEFAULT_INSTANCE;
    public static final int LAST_SEQUENCE_FIELD_NUMBER = 2;
    public static final int NEED_MORE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TOO_LONG_FIELD_NUMBER = 5;
    public static final int UPDATES_FIELD_NUMBER = 4;
    private int bitField0_;
    private int lastSequence_;
    private boolean needMore_;
    private BoolValue tooLong_;
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MavizStreamOuterClass$GroupEvents.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$GroupEvents mavizStreamOuterClass$GroupEvents = new MavizStreamOuterClass$GroupEvents();
        DEFAULT_INSTANCE = mavizStreamOuterClass$GroupEvents;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$GroupEvents.class, mavizStreamOuterClass$GroupEvents);
    }

    private MavizStreamOuterClass$GroupEvents() {
    }

    private void addAllUpdates(Iterable<? extends SetUpdatesStruct$ComposedUpdates> iterable) {
        ensureUpdatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.updates_);
    }

    private void addUpdates(SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(setUpdatesStruct$ComposedUpdates);
    }

    private void clearLastSequence() {
        this.lastSequence_ = 0;
    }

    private void clearNeedMore() {
        this.needMore_ = false;
    }

    private void clearTooLong() {
        this.tooLong_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUpdates() {
        this.updates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUpdatesIsMutable() {
        B.j jVar = this.updates_;
        if (jVar.u()) {
            return;
        }
        this.updates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MavizStreamOuterClass$GroupEvents getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTooLong(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.tooLong_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.tooLong_ = boolValue;
        } else {
            this.tooLong_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.tooLong_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$GroupEvents parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
    }

    private void setLastSequence(int i) {
        this.lastSequence_ = i;
    }

    private void setNeedMore(boolean z) {
        this.needMore_ = z;
    }

    private void setTooLong(BoolValue boolValue) {
        boolValue.getClass();
        this.tooLong_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setUpdates(int i, SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.set(i, setUpdatesStruct$ComposedUpdates);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$GroupEvents();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0001\u0000\u0002\u0004\u0003\u0007\u0004\u001b\u0005ဉ\u0000", new Object[]{"bitField0_", "lastSequence_", "needMore_", "updates_", SetUpdatesStruct$ComposedUpdates.class, "tooLong_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$GroupEvents.class) {
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

    public int getLastSequence() {
        return this.lastSequence_;
    }

    public boolean getNeedMore() {
        return this.needMore_;
    }

    public BoolValue getTooLong() {
        BoolValue boolValue = this.tooLong_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public SetUpdatesStruct$ComposedUpdates getUpdates(int i) {
        return (SetUpdatesStruct$ComposedUpdates) this.updates_.get(i);
    }

    public int getUpdatesCount() {
        return this.updates_.size();
    }

    public List<SetUpdatesStruct$ComposedUpdates> getUpdatesList() {
        return this.updates_;
    }

    public Y1 getUpdatesOrBuilder(int i) {
        return (Y1) this.updates_.get(i);
    }

    public List<? extends Y1> getUpdatesOrBuilderList() {
        return this.updates_;
    }

    public boolean hasTooLong() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MavizStreamOuterClass$GroupEvents mavizStreamOuterClass$GroupEvents) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$GroupEvents);
    }

    public static MavizStreamOuterClass$GroupEvents parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUpdates(int i, SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, setUpdatesStruct$ComposedUpdates);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$GroupEvents parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$GroupEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
