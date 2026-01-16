package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.gD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC13429gD {
    NONE(1),
    BUY(51),
    STATEMENT(182),
    REFUND(52),
    AUTHENTICATION(175),
    ISSUE(176),
    GETPROFILE(SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER),
    EDITPROFILE(SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER),
    TRANSACTIONINQUIRY(186),
    WALLETSTATUSCHANGE(SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER),
    GETBALANCE(SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER),
    WITHDRAWALPERMISSION(SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER),
    DEPOSITPERMISSION(174),
    WITHDRAWAL(22),
    DEPOSIT(173),
    GETNAME(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER),
    TRANSFER(185),
    CHARGEPERMISSION(SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER),
    CHARGE(SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER),
    DECHARGE(188),
    BILLPAYMENT(30),
    BUYECHARGE(31),
    BUYPREMIUMCONTENT(SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER),
    CREATEGIFTPACKET(192),
    REQUESTGIFTPACKET(198),
    SHAREDBUY(195),
    ISSUECASHACCOUNT(196),
    MERCHANTDECHARGE(Type.TSIG),
    MANUALMECHANTDECHARGE(255),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC13429gD(int i) {
        this.a = i;
    }

    public static EnumC13429gD p(int i) {
        if (i == 1) {
            return NONE;
        }
        if (i == 22) {
            return WITHDRAWAL;
        }
        if (i == 198) {
            return REQUESTGIFTPACKET;
        }
        if (i == 250) {
            return MERCHANTDECHARGE;
        }
        if (i == 255) {
            return MANUALMECHANTDECHARGE;
        }
        if (i == 30) {
            return BILLPAYMENT;
        }
        if (i == 31) {
            return BUYECHARGE;
        }
        if (i == 51) {
            return BUY;
        }
        if (i == 52) {
            return REFUND;
        }
        if (i == 195) {
            return SHAREDBUY;
        }
        if (i == 196) {
            return ISSUECASHACCOUNT;
        }
        switch (i) {
            case 173:
                return DEPOSIT;
            case 174:
                return DEPOSITPERMISSION;
            case 175:
                return AUTHENTICATION;
            case 176:
                return ISSUE;
            case SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER /* 177 */:
                return CHARGEPERMISSION;
            case SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER /* 178 */:
                return GETBALANCE;
            case SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER /* 179 */:
                return CHARGE;
            case SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER /* 180 */:
                return GETNAME;
            case SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER /* 181 */:
                return GETPROFILE;
            case 182:
                return STATEMENT;
            default:
                switch (i) {
                    case 185:
                        return TRANSFER;
                    case 186:
                        return TRANSACTIONINQUIRY;
                    case SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER /* 187 */:
                        return EDITPROFILE;
                    case 188:
                        return DECHARGE;
                    case SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER /* 189 */:
                        return WALLETSTATUSCHANGE;
                    case SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER /* 190 */:
                        return WITHDRAWALPERMISSION;
                    case SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER /* 191 */:
                        return BUYPREMIUMCONTENT;
                    case 192:
                        return CREATEGIFTPACKET;
                    default:
                        return UNSUPPORTED_VALUE;
                }
        }
    }

    public int j() {
        return this.a;
    }
}
