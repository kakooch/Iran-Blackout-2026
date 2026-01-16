package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19870r48;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class WarriorOuterClass$ResponseGetPacketsStatus extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$ResponseGetPacketsStatus DEFAULT_INSTANCE;
    public static final int PACKETS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j packets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$ResponseGetPacketsStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$ResponseGetPacketsStatus warriorOuterClass$ResponseGetPacketsStatus = new WarriorOuterClass$ResponseGetPacketsStatus();
        DEFAULT_INSTANCE = warriorOuterClass$ResponseGetPacketsStatus;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$ResponseGetPacketsStatus.class, warriorOuterClass$ResponseGetPacketsStatus);
    }

    private WarriorOuterClass$ResponseGetPacketsStatus() {
    }

    private void addAllPackets(Iterable<? extends WarriorStruct$RewardPacket> iterable) {
        ensurePacketsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.packets_);
    }

    private void addPackets(WarriorStruct$RewardPacket warriorStruct$RewardPacket) {
        warriorStruct$RewardPacket.getClass();
        ensurePacketsIsMutable();
        this.packets_.add(warriorStruct$RewardPacket);
    }

    private void clearPackets() {
        this.packets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePacketsIsMutable() {
        B.j jVar = this.packets_;
        if (jVar.u()) {
            return;
        }
        this.packets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePackets(int i) {
        ensurePacketsIsMutable();
        this.packets_.remove(i);
    }

    private void setPackets(int i, WarriorStruct$RewardPacket warriorStruct$RewardPacket) {
        warriorStruct$RewardPacket.getClass();
        ensurePacketsIsMutable();
        this.packets_.set(i, warriorStruct$RewardPacket);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$ResponseGetPacketsStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"packets_", WarriorStruct$RewardPacket.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$ResponseGetPacketsStatus.class) {
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

    public WarriorStruct$RewardPacket getPackets(int i) {
        return (WarriorStruct$RewardPacket) this.packets_.get(i);
    }

    public int getPacketsCount() {
        return this.packets_.size();
    }

    public List<WarriorStruct$RewardPacket> getPacketsList() {
        return this.packets_;
    }

    public InterfaceC19870r48 getPacketsOrBuilder(int i) {
        return (InterfaceC19870r48) this.packets_.get(i);
    }

    public List<? extends InterfaceC19870r48> getPacketsOrBuilderList() {
        return this.packets_;
    }

    public static a newBuilder(WarriorOuterClass$ResponseGetPacketsStatus warriorOuterClass$ResponseGetPacketsStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$ResponseGetPacketsStatus);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPackets(int i, WarriorStruct$RewardPacket warriorStruct$RewardPacket) {
        warriorStruct$RewardPacket.getClass();
        ensurePacketsIsMutable();
        this.packets_.add(i, warriorStruct$RewardPacket);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(byte[] bArr) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$ResponseGetPacketsStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
