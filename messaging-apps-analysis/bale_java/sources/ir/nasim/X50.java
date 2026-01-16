package ir.nasim;

import ai.bale.proto.MessagingStruct$BankEx;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import android.content.Context;
import ir.nasim.UO1;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class X50 implements Z64 {
    private final Context a;
    private final MessagingStruct$Message.b b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessagingStruct$BankEx.b.values().length];
            try {
                iArr[MessagingStruct$BankEx.b.BANK_MONEY_TRANSFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessagingStruct$BankEx.b.BANK_TRANSACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessagingStruct$BankEx.b.BANK_REMAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessagingStruct$BankEx.b.RECEIPT_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessagingStruct$BankEx.b.DEPRECATED_RECEIPT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessagingStruct$BankEx.b.DEPRECATED_RECEIPT_MESSAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MessagingStruct$BankEx.b.TRAIT_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public X50(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = MessagingStruct$Message.b.BANK_MESSAGE;
    }

    private final DialogLastMessage e(MessagingStruct$BankEx.b bVar, int i, MessageState messageState) {
        String string = this.a.getString(f(bVar));
        AbstractC13042fc3.h(string, "getString(...)");
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, i == AbstractC5969Lp4.f(), i, messageState, (Set) null, (MessagingStruct$ServiceEx.b) null, 398, (ED1) null);
    }

    private final int f(MessagingStruct$BankEx.b bVar) {
        switch (bVar == null ? -1 : a.a[bVar.ordinal()]) {
            case -1:
            case 5:
            case 6:
            case 7:
                UO1.b bVar2 = UO1.b.a;
                String strName = bVar != null ? bVar.name() : null;
                if (strName == null) {
                    strName = "";
                }
                UO1.b.b(bVar2, "Attempted to map non-BankContent type, so Using fallback", strName, null, 4, null);
                return FD5.message_holder_content_bank;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return FD5.message_holder_content_bank_transaction;
            case 2:
                return FD5.message_holder_content_bank_transaction;
            case 3:
                return FD5.message_holder_content_bank_remain;
            case 4:
                return FD5.message_holder_content_bank_receipt;
        }
    }

    private final MessagingStruct$BankEx.b g(E50 e50) {
        if (e50 instanceof C5672Ki4) {
            return MessagingStruct$BankEx.b.BANK_MONEY_TRANSFER;
        }
        if (e50 instanceof C11383cu7) {
            return MessagingStruct$BankEx.b.BANK_TRANSACTION;
        }
        if (e50 instanceof NI5) {
            return MessagingStruct$BankEx.b.RECEIPT_MESSAGE;
        }
        if (e50 instanceof QM5) {
            return MessagingStruct$BankEx.b.BANK_REMAIN;
        }
        UO1.b.b(UO1.b.a, "Unsupported BankContent type, so map to TRAIT_NOT_SET:", null, e50.getClass().getSimpleName(), 2, null);
        return MessagingStruct$BankEx.b.TRAIT_NOT_SET;
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return e(messagingStruct$Message.getBankMessage().getBankEx().getTraitCase(), i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        if (abstractC17457n0 instanceof E50) {
            return e(g((E50) abstractC17457n0), i, messageState);
        }
        UO1.b.b(UO1.b.a, "Attempted to map non-BankContent type, soUsing fallback.", null, abstractC17457n0.getClass().getSimpleName(), 2, null);
        String string = this.a.getString(FD5.message_holder_content_template);
        AbstractC13042fc3.h(string, "getString(...)");
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, i == AbstractC5969Lp4.f(), i, messageState, (Set) null, (MessagingStruct$ServiceEx.b) null, 398, (ED1) null);
    }

    @Override // ir.nasim.Z64
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.b;
    }
}
