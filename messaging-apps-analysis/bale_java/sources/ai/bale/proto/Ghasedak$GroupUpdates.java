package ai.bale.proto;

import ai.bale.proto.Ghasedak$RouteSeqState;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.JG2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Ghasedak$GroupUpdates extends GeneratedMessageLite implements JG2 {
    private static final Ghasedak$GroupUpdates DEFAULT_INSTANCE;
    public static final int NEED_MORE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    public static final int TOO_LONG_FIELD_NUMBER = 4;
    public static final int UPDATES_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean needMore_;
    private Ghasedak$RouteSeqState state_;
    private BoolValue tooLong_;
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements JG2 {
        private a() {
            super(Ghasedak$GroupUpdates.DEFAULT_INSTANCE);
        }
    }

    static {
        Ghasedak$GroupUpdates ghasedak$GroupUpdates = new Ghasedak$GroupUpdates();
        DEFAULT_INSTANCE = ghasedak$GroupUpdates;
        GeneratedMessageLite.registerDefaultInstance(Ghasedak$GroupUpdates.class, ghasedak$GroupUpdates);
    }

    private Ghasedak$GroupUpdates() {
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

    private void clearNeedMore() {
        this.needMore_ = false;
    }

    private void clearState() {
        this.state_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTooLong() {
        this.tooLong_ = null;
        this.bitField0_ &= -3;
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

    public static Ghasedak$GroupUpdates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeState(Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
        ghasedak$RouteSeqState.getClass();
        Ghasedak$RouteSeqState ghasedak$RouteSeqState2 = this.state_;
        if (ghasedak$RouteSeqState2 == null || ghasedak$RouteSeqState2 == Ghasedak$RouteSeqState.getDefaultInstance()) {
            this.state_ = ghasedak$RouteSeqState;
        } else {
            this.state_ = (Ghasedak$RouteSeqState) ((Ghasedak$RouteSeqState.a) Ghasedak$RouteSeqState.newBuilder(this.state_).v(ghasedak$RouteSeqState)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTooLong(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.tooLong_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.tooLong_ = boolValue;
        } else {
            this.tooLong_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.tooLong_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ghasedak$GroupUpdates parseDelimitedFrom(InputStream inputStream) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$GroupUpdates parseFrom(ByteBuffer byteBuffer) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
    }

    private void setNeedMore(boolean z) {
        this.needMore_ = z;
    }

    private void setState(Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
        ghasedak$RouteSeqState.getClass();
        this.state_ = ghasedak$RouteSeqState;
        this.bitField0_ |= 1;
    }

    private void setTooLong(BoolValue boolValue) {
        boolValue.getClass();
        this.tooLong_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setUpdates(int i, SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.set(i, setUpdatesStruct$ComposedUpdates);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1862i0.a[gVar.ordinal()]) {
            case 1:
                return new Ghasedak$GroupUpdates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u0007\u0004ဉ\u0001", new Object[]{"bitField0_", "state_", "updates_", SetUpdatesStruct$ComposedUpdates.class, "needMore_", "tooLong_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ghasedak$GroupUpdates.class) {
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

    public boolean getNeedMore() {
        return this.needMore_;
    }

    public Ghasedak$RouteSeqState getState() {
        Ghasedak$RouteSeqState ghasedak$RouteSeqState = this.state_;
        return ghasedak$RouteSeqState == null ? Ghasedak$RouteSeqState.getDefaultInstance() : ghasedak$RouteSeqState;
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

    public boolean hasState() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTooLong() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(Ghasedak$GroupUpdates ghasedak$GroupUpdates) {
        return (a) DEFAULT_INSTANCE.createBuilder(ghasedak$GroupUpdates);
    }

    public static Ghasedak$GroupUpdates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$GroupUpdates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ghasedak$GroupUpdates parseFrom(AbstractC2383g abstractC2383g) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUpdates(int i, SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, setUpdatesStruct$ComposedUpdates);
    }

    public static Ghasedak$GroupUpdates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ghasedak$GroupUpdates parseFrom(byte[] bArr) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ghasedak$GroupUpdates parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ghasedak$GroupUpdates parseFrom(InputStream inputStream) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$GroupUpdates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$GroupUpdates parseFrom(AbstractC2384h abstractC2384h) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ghasedak$GroupUpdates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ghasedak$GroupUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
