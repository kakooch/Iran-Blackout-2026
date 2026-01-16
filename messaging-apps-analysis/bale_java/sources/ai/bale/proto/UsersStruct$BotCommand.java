package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC14720iM7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$BotCommand extends GeneratedMessageLite implements InterfaceC14720iM7 {
    private static final UsersStruct$BotCommand DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int LOC_KEY_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SLASH_COMMAND_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue locKey_;
    private String slashCommand_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC14720iM7 {
        private a() {
            super(UsersStruct$BotCommand.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$BotCommand usersStruct$BotCommand = new UsersStruct$BotCommand();
        DEFAULT_INSTANCE = usersStruct$BotCommand;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$BotCommand.class, usersStruct$BotCommand);
    }

    private UsersStruct$BotCommand() {
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearLocKey() {
        this.locKey_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSlashCommand() {
        this.slashCommand_ = getDefaultInstance().getSlashCommand();
    }

    public static UsersStruct$BotCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLocKey(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.locKey_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.locKey_ = stringValue;
        } else {
            this.locKey_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.locKey_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$BotCommand parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$BotCommand parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setLocKey(StringValue stringValue) {
        stringValue.getClass();
        this.locKey_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setSlashCommand(String str) {
        str.getClass();
        this.slashCommand_ = str;
    }

    private void setSlashCommandBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.slashCommand_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$BotCommand();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "slashCommand_", "description_", "locKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$BotCommand.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public StringValue getLocKey() {
        StringValue stringValue = this.locKey_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getSlashCommand() {
        return this.slashCommand_;
    }

    public AbstractC2383g getSlashCommandBytes() {
        return AbstractC2383g.N(this.slashCommand_);
    }

    public boolean hasLocKey() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersStruct$BotCommand usersStruct$BotCommand) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$BotCommand);
    }

    public static UsersStruct$BotCommand parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$BotCommand parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$BotCommand parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$BotCommand parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$BotCommand parseFrom(byte[] bArr) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$BotCommand parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$BotCommand parseFrom(InputStream inputStream) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$BotCommand parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$BotCommand parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$BotCommand parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$BotCommand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
