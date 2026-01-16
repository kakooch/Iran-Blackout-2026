package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11027cc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseGetPins extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$ResponseGetPins DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PINS_FIELD_NUMBER = 1;
    private int count_;
    private B.j pins_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseGetPins.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseGetPins groupsOuterClass$ResponseGetPins = new GroupsOuterClass$ResponseGetPins();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseGetPins;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseGetPins.class, groupsOuterClass$ResponseGetPins);
    }

    private GroupsOuterClass$ResponseGetPins() {
    }

    private void addAllPins(Iterable<? extends MessagingStruct$MessageContainer> iterable) {
        ensurePinsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pins_);
    }

    private void addPins(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensurePinsIsMutable();
        this.pins_.add(messagingStruct$MessageContainer);
    }

    private void clearCount() {
        this.count_ = 0;
    }

    private void clearPins() {
        this.pins_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePinsIsMutable() {
        B.j jVar = this.pins_;
        if (jVar.u()) {
            return;
        }
        this.pins_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$ResponseGetPins getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseGetPins parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePins(int i) {
        ensurePinsIsMutable();
        this.pins_.remove(i);
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    private void setPins(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensurePinsIsMutable();
        this.pins_.set(i, messagingStruct$MessageContainer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseGetPins();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"pins_", MessagingStruct$MessageContainer.class, "count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseGetPins.class) {
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

    public int getCount() {
        return this.count_;
    }

    public MessagingStruct$MessageContainer getPins(int i) {
        return (MessagingStruct$MessageContainer) this.pins_.get(i);
    }

    public int getPinsCount() {
        return this.pins_.size();
    }

    public List<MessagingStruct$MessageContainer> getPinsList() {
        return this.pins_;
    }

    public InterfaceC11027cc4 getPinsOrBuilder(int i) {
        return (InterfaceC11027cc4) this.pins_.get(i);
    }

    public List<? extends InterfaceC11027cc4> getPinsOrBuilderList() {
        return this.pins_;
    }

    public static a newBuilder(GroupsOuterClass$ResponseGetPins groupsOuterClass$ResponseGetPins) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseGetPins);
    }

    public static GroupsOuterClass$ResponseGetPins parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPins(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensurePinsIsMutable();
        this.pins_.add(i, messagingStruct$MessageContainer);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseGetPins parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
