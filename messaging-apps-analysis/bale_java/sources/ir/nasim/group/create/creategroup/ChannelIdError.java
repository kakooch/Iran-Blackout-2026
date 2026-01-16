package ir.nasim.group.create.creategroup;

import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00060\u0002j\u0002`\u0001:\u0004\u0005\u0006\u0007\bB\t\b\u0005¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lir/nasim/group/create/creategroup/ChannelIdError;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "<init>", "()V", "InvalidChannelInput", "UsingAppName", "InvalidChannelNick", "ForbiddenNick", "Lir/nasim/group/create/creategroup/ChannelIdError$ForbiddenNick;", "Lir/nasim/group/create/creategroup/ChannelIdError$InvalidChannelInput;", "Lir/nasim/group/create/creategroup/ChannelIdError$InvalidChannelNick;", "Lir/nasim/group/create/creategroup/ChannelIdError$UsingAppName;", "group_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class ChannelIdError extends Exception {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lir/nasim/group/create/creategroup/ChannelIdError$ForbiddenNick;", "Lir/nasim/group/create/creategroup/ChannelIdError;", "<init>", "()V", "group_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ForbiddenNick extends ChannelIdError {
        public ForbiddenNick() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lir/nasim/group/create/creategroup/ChannelIdError$InvalidChannelInput;", "Lir/nasim/group/create/creategroup/ChannelIdError;", "<init>", "()V", "group_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InvalidChannelInput extends ChannelIdError {
        public InvalidChannelInput() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lir/nasim/group/create/creategroup/ChannelIdError$InvalidChannelNick;", "Lir/nasim/group/create/creategroup/ChannelIdError;", "<init>", "()V", "group_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InvalidChannelNick extends ChannelIdError {
        public InvalidChannelNick() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lir/nasim/group/create/creategroup/ChannelIdError$UsingAppName;", "Lir/nasim/group/create/creategroup/ChannelIdError;", "<init>", "()V", "group_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UsingAppName extends ChannelIdError {
        public UsingAppName() {
            super(null);
        }
    }

    public /* synthetic */ ChannelIdError(ED1 ed1) {
        this();
    }

    private ChannelIdError() {
    }
}
