package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC14720iM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$UpdateUserBotCommandsChanged extends GeneratedMessageLite implements U64 {
    public static final int COMMANDS_FIELD_NUMBER = 2;
    private static final UsersOuterClass$UpdateUserBotCommandsChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private B.j commands_ = GeneratedMessageLite.emptyProtobufList();
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateUserBotCommandsChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateUserBotCommandsChanged usersOuterClass$UpdateUserBotCommandsChanged = new UsersOuterClass$UpdateUserBotCommandsChanged();
        DEFAULT_INSTANCE = usersOuterClass$UpdateUserBotCommandsChanged;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateUserBotCommandsChanged.class, usersOuterClass$UpdateUserBotCommandsChanged);
    }

    private UsersOuterClass$UpdateUserBotCommandsChanged() {
    }

    private void addAllCommands(Iterable<? extends UsersStruct$BotCommand> iterable) {
        ensureCommandsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.commands_);
    }

    private void addCommands(UsersStruct$BotCommand usersStruct$BotCommand) {
        usersStruct$BotCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.add(usersStruct$BotCommand);
    }

    private void clearCommands() {
        this.commands_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    private void ensureCommandsIsMutable() {
        B.j jVar = this.commands_;
        if (jVar.u()) {
            return;
        }
        this.commands_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCommands(int i) {
        ensureCommandsIsMutable();
        this.commands_.remove(i);
    }

    private void setCommands(int i, UsersStruct$BotCommand usersStruct$BotCommand) {
        usersStruct$BotCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.set(i, usersStruct$BotCommand);
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateUserBotCommandsChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002\u001b", new Object[]{"uid_", "commands_", UsersStruct$BotCommand.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateUserBotCommandsChanged.class) {
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

    public UsersStruct$BotCommand getCommands(int i) {
        return (UsersStruct$BotCommand) this.commands_.get(i);
    }

    public int getCommandsCount() {
        return this.commands_.size();
    }

    public List<UsersStruct$BotCommand> getCommandsList() {
        return this.commands_;
    }

    public InterfaceC14720iM7 getCommandsOrBuilder(int i) {
        return (InterfaceC14720iM7) this.commands_.get(i);
    }

    public List<? extends InterfaceC14720iM7> getCommandsOrBuilderList() {
        return this.commands_;
    }

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(UsersOuterClass$UpdateUserBotCommandsChanged usersOuterClass$UpdateUserBotCommandsChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateUserBotCommandsChanged);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCommands(int i, UsersStruct$BotCommand usersStruct$BotCommand) {
        usersStruct$BotCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.add(i, usersStruct$BotCommand);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateUserBotCommandsChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserBotCommandsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
