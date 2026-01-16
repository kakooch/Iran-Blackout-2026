package ir.nasim.sharedmedia.ui.state;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0005\u0006\u0007B\t\b\u0005¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "InvalidChannelInput", "InvalidChannelNick", "ForbiddenNick", "Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState$ForbiddenNick;", "Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState$InvalidChannelInput;", "Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState$InvalidChannelNick;", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public abstract class ChangeNickErrorState extends Exception {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState$ForbiddenNick;", "Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState;", "<init>", "()V", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", TokenNames.MESSAGE, "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
    public static final class ForbiddenNick extends ChangeNickErrorState {
        public static final ForbiddenNick a = new ForbiddenNick();

        /* renamed from: b, reason: from kotlin metadata */
        private static final String MESSAGE = "forbidden user nick name";

        private ForbiddenNick() {
            super(null);
        }

        public String a() {
            return MESSAGE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState$InvalidChannelInput;", "Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState;", "<init>", "()V", "", "b", "Ljava/lang/String;", "getMESSAGE", "()Ljava/lang/String;", TokenNames.MESSAGE, "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
    public static final class InvalidChannelInput extends ChangeNickErrorState {
        public static final InvalidChannelInput a = new InvalidChannelInput();

        /* renamed from: b, reason: from kotlin metadata */
        private static final String MESSAGE = "InvalidChannelInput";

        private InvalidChannelInput() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState$InvalidChannelNick;", "Lir/nasim/sharedmedia/ui/state/ChangeNickErrorState;", "<init>", "()V", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", TokenNames.MESSAGE, "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
    public static final class InvalidChannelNick extends ChangeNickErrorState {
        public static final InvalidChannelNick a = new InvalidChannelNick();

        /* renamed from: b, reason: from kotlin metadata */
        private static final String MESSAGE = "invalid user nick name";

        private InvalidChannelNick() {
            super(null);
        }

        public String a() {
            return MESSAGE;
        }
    }

    public /* synthetic */ ChangeNickErrorState(ED1 ed1) {
        this();
    }

    private ChangeNickErrorState() {
    }
}
