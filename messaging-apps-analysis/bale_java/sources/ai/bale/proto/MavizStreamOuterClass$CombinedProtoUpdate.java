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
public final class MavizStreamOuterClass$CombinedProtoUpdate extends GeneratedMessageLite implements U64 {
    private static final MavizStreamOuterClass$CombinedProtoUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPDATES_FIELD_NUMBER = 1;
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MavizStreamOuterClass$CombinedProtoUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$CombinedProtoUpdate mavizStreamOuterClass$CombinedProtoUpdate = new MavizStreamOuterClass$CombinedProtoUpdate();
        DEFAULT_INSTANCE = mavizStreamOuterClass$CombinedProtoUpdate;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$CombinedProtoUpdate.class, mavizStreamOuterClass$CombinedProtoUpdate);
    }

    private MavizStreamOuterClass$CombinedProtoUpdate() {
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

    public static MavizStreamOuterClass$CombinedProtoUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
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
                return new MavizStreamOuterClass$CombinedProtoUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"updates_", SetUpdatesStruct$ComposedUpdates.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$CombinedProtoUpdate.class) {
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

    public static a newBuilder(MavizStreamOuterClass$CombinedProtoUpdate mavizStreamOuterClass$CombinedProtoUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$CombinedProtoUpdate);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUpdates(int i, SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, setUpdatesStruct$ComposedUpdates);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$CombinedProtoUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$CombinedProtoUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
