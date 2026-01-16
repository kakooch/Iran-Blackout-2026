package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.protobuf.B;

/* renamed from: ir.nasim.gr3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC13810gr3 implements B.c {
    TransactionType_NONE(0),
    TransactionType_BUY(50),
    TransactionType_STATEMENT(SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER),
    TransactionType_REFUND(51),
    TransactionType_AUTHENTICATION(174),
    TransactionType_ISSUE(175),
    TransactionType_GETPROFILE(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER),
    TransactionType_EDITPROFILE(186),
    TransactionType_TRANSACTIONINQUIRY(185),
    TransactionType_WALLETSTATUSCHANGE(188),
    TransactionType_GETBALANCE(SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER),
    TransactionType_WITHDRAWALPERMISSION(SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER),
    TransactionType_DEPOSITPERMISSION(173),
    TransactionType_WITHDRAWAL(21),
    TransactionType_DEPOSIT(172),
    TransactionType_GETNAME(SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER),
    TransactionType_TRANSFER(184),
    TransactionType_CHARGEPERMISSION(176),
    TransactionType_CHARGE(SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER),
    TransactionType_DECHARGE(SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER),
    TransactionType_BILLPAYMENT(29),
    TransactionType_BUYECHARGE(30),
    TransactionType_BUYPREMIUMCONTENT(SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER),
    TransactionType_CREATEGIFTPACKET(SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER),
    TransactionType_REQUESTGIFTPACKET(197),
    TransactionType_SHAREDBUY(194),
    TransactionType_ISSUECASHACCOUNT(195),
    TransactionType_MERCHANTDECHARGE(249),
    TransactionType_MANUALMECHANTDECHARGE(254),
    UNRECOGNIZED(-1);

    private static final B.d J = new B.d() { // from class: ir.nasim.gr3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13810gr3 a(int i) {
            return EnumC13810gr3.j(i);
        }
    };
    private final int a;

    EnumC13810gr3(int i) {
        this.a = i;
    }

    public static EnumC13810gr3 j(int i) {
        if (i == 0) {
            return TransactionType_NONE;
        }
        if (i == 21) {
            return TransactionType_WITHDRAWAL;
        }
        if (i == 197) {
            return TransactionType_REQUESTGIFTPACKET;
        }
        if (i == 249) {
            return TransactionType_MERCHANTDECHARGE;
        }
        if (i == 254) {
            return TransactionType_MANUALMECHANTDECHARGE;
        }
        if (i == 29) {
            return TransactionType_BILLPAYMENT;
        }
        if (i == 30) {
            return TransactionType_BUYECHARGE;
        }
        if (i == 50) {
            return TransactionType_BUY;
        }
        if (i == 51) {
            return TransactionType_REFUND;
        }
        if (i == 194) {
            return TransactionType_SHAREDBUY;
        }
        if (i == 195) {
            return TransactionType_ISSUECASHACCOUNT;
        }
        switch (i) {
            case 172:
                return TransactionType_DEPOSIT;
            case 173:
                return TransactionType_DEPOSITPERMISSION;
            case 174:
                return TransactionType_AUTHENTICATION;
            case 175:
                return TransactionType_ISSUE;
            case 176:
                return TransactionType_CHARGEPERMISSION;
            case SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER /* 177 */:
                return TransactionType_GETBALANCE;
            case SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER /* 178 */:
                return TransactionType_CHARGE;
            case SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER /* 179 */:
                return TransactionType_GETNAME;
            case SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER /* 180 */:
                return TransactionType_GETPROFILE;
            case SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER /* 181 */:
                return TransactionType_STATEMENT;
            default:
                switch (i) {
                    case 184:
                        return TransactionType_TRANSFER;
                    case 185:
                        return TransactionType_TRANSACTIONINQUIRY;
                    case 186:
                        return TransactionType_EDITPROFILE;
                    case SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER /* 187 */:
                        return TransactionType_DECHARGE;
                    case 188:
                        return TransactionType_WALLETSTATUSCHANGE;
                    case SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER /* 189 */:
                        return TransactionType_WITHDRAWALPERMISSION;
                    case SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER /* 190 */:
                        return TransactionType_BUYPREMIUMCONTENT;
                    case SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER /* 191 */:
                        return TransactionType_CREATEGIFTPACKET;
                    default:
                        return null;
                }
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
