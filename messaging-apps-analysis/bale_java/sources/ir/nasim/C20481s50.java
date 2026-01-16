package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import java.util.List;

/* renamed from: ir.nasim.s50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20481s50 {
    private static String c;
    private static CardToCardConfig d;
    public static final C20481s50 a = new C20481s50();
    private static final KS2 b = new KS2();
    public static final int e = 8;

    private C20481s50() {
    }

    public final String a(String str) {
        AbstractC13042fc3.i(str, "name");
        List listM = new C20644sM5(":").m(str, 0);
        String strSubstring = ((String) listM.get(0)).substring(0, 4);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String strSubstring2 = ((String) listM.get(0)).substring(4, 6);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        return strSubstring + Separators.SP + strSubstring2 + "xx xxxx " + listM.get(1);
    }

    public final String b(String str) {
        AbstractC13042fc3.i(str, "cardNumber");
        if (str.length() != 16) {
            return null;
        }
        String strSubstring = str.substring(0, 4);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String strSubstring2 = str.substring(4, 6);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        String strSubstring3 = str.substring(12);
        AbstractC13042fc3.h(strSubstring3, "substring(...)");
        return strSubstring + Separators.SP + strSubstring2 + "xx xxxx " + strSubstring3;
    }

    public final Bank c(String str) {
        List<Bank> bankList;
        AbstractC13042fc3.i(str, "pattern");
        if (c == null || d == null) {
            String strB1 = AbstractC5969Lp4.d().o2().S().b1();
            c = strB1;
            d = (CardToCardConfig) b.k(strB1, CardToCardConfig.class);
        }
        Bank bank = null;
        try {
            CardToCardConfig cardToCardConfig = d;
            if (cardToCardConfig != null && (bankList = cardToCardConfig.getBankList()) != null) {
                for (Bank bank2 : bankList) {
                    if (bank2.getCardNumberPattern().contains(XY6.h(str))) {
                        try {
                            bank2.setDrawableId(a.e(bank2.getCardNumberPattern()));
                            bank = bank2;
                        } catch (Exception e2) {
                            e = e2;
                            bank = bank2;
                            C19406qI3.d("NON_FATAL_EXCEPTION", e);
                            return bank;
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return bank;
    }

    public final Integer d(String str) {
        AbstractC13042fc3.i(str, "patterns");
        if (AbstractC20762sZ6.X(str, "603799", false, 2, null)) {
            return Integer.valueOf(KB5.bank_melli);
        }
        if (AbstractC20762sZ6.X(str, "589210", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (AbstractC20762sZ6.X(str, "627961", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sanat_madan);
        }
        if (AbstractC20762sZ6.X(str, "603770", false, 2, null) || AbstractC20762sZ6.X(str, "639217", false, 2, null)) {
            return Integer.valueOf(KB5.bank_keshavarzi);
        }
        if (AbstractC20762sZ6.X(str, "627760", false, 2, null)) {
            return Integer.valueOf(KB5.bank_post_bank);
        }
        if (AbstractC20762sZ6.X(str, "627412", false, 2, null)) {
            return Integer.valueOf(KB5.bank_eghtesad_novin);
        }
        if (AbstractC20762sZ6.X(str, "622106", false, 2, null) || AbstractC20762sZ6.X(str, "639194", false, 2, null) || AbstractC20762sZ6.X(str, "627884", false, 2, null)) {
            return Integer.valueOf(KB5.bank_parsian);
        }
        if (AbstractC20762sZ6.X(str, "639347", false, 2, null) || AbstractC20762sZ6.X(str, "502229", false, 2, null)) {
            return Integer.valueOf(KB5.bank_pasargad);
        }
        if (AbstractC20762sZ6.X(str, "621986", false, 2, null)) {
            return Integer.valueOf(KB5.bank_saman);
        }
        if (AbstractC20762sZ6.X(str, "639346", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sina);
        }
        if (AbstractC20762sZ6.X(str, "639607", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sarmayeh);
        }
        if (AbstractC20762sZ6.X(str, "636214", false, 2, null)) {
            return Integer.valueOf(KB5.bank_ayandeh);
        }
        if (AbstractC20762sZ6.X(str, "504706", false, 2, null) || AbstractC20762sZ6.X(str, "502806", false, 2, null)) {
            return Integer.valueOf(KB5.bank_shahr);
        }
        if (AbstractC20762sZ6.X(str, "502938", false, 2, null)) {
            return Integer.valueOf(KB5.bank_dey);
        }
        if (AbstractC20762sZ6.X(str, "603769", false, 2, null)) {
            return Integer.valueOf(KB5.bank_saderat);
        }
        if (AbstractC20762sZ6.X(str, "610433", false, 2, null) || AbstractC20762sZ6.X(str, "991975", false, 2, null)) {
            return Integer.valueOf(KB5.bank_mellat);
        }
        if (AbstractC20762sZ6.X(str, "585983", false, 2, null) || AbstractC20762sZ6.X(str, "627353", false, 2, null)) {
            return Integer.valueOf(KB5.bank_tejarat);
        }
        if (AbstractC20762sZ6.X(str, "627381", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (AbstractC20762sZ6.X(str, "636949", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (AbstractC20762sZ6.X(str, "639370", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (AbstractC20762sZ6.X(str, "505785", false, 2, null)) {
            return Integer.valueOf(KB5.bank_iran_zamin);
        }
        if (AbstractC20762sZ6.X(str, "606256", false, 2, null)) {
            return Integer.valueOf(KB5.bank_melal);
        }
        if (AbstractC20762sZ6.X(str, "585947", false, 2, null)) {
            return Integer.valueOf(KB5.bank_khavarmianeh);
        }
        if (AbstractC20762sZ6.X(str, "505416", false, 2, null)) {
            return Integer.valueOf(KB5.bank_gardeshgari);
        }
        if (AbstractC20762sZ6.X(str, "502908", false, 2, null)) {
            return Integer.valueOf(KB5.bank_toseeh_teavon);
        }
        if (AbstractC20762sZ6.X(str, "627648", false, 2, null) || AbstractC20762sZ6.X(str, "207177", false, 2, null)) {
            return Integer.valueOf(KB5.bank_toseeh_saderat);
        }
        if (AbstractC20762sZ6.X(str, "589463", false, 2, null)) {
            return Integer.valueOf(KB5.bank_refah);
        }
        if (AbstractC20762sZ6.X(str, "504172", false, 2, null)) {
            return Integer.valueOf(KB5.bank_resalat);
        }
        if (AbstractC20762sZ6.X(str, "606373", false, 2, null)) {
            return Integer.valueOf(KB5.bank_mehr_iran);
        }
        if (AbstractC20762sZ6.X(str, "639599", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (AbstractC20762sZ6.X(str, "627488", false, 2, null) || AbstractC20762sZ6.X(str, "502910", false, 2, null)) {
            return Integer.valueOf(KB5.bank_karafarin);
        }
        if (AbstractC20762sZ6.X(str, "636795", false, 2, null)) {
            return Integer.valueOf(KB5.bank_markazi);
        }
        if (AbstractC20762sZ6.X(str, "628023", false, 2, null)) {
            return Integer.valueOf(KB5.bank_maskan);
        }
        if (AbstractC20762sZ6.X(str, "628157", false, 2, null)) {
            return Integer.valueOf(KB5.bank_toseeh);
        }
        if (AbstractC20762sZ6.X(str, "505801", false, 2, null)) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (AbstractC20762sZ6.X(str, "507677", false, 2, null)) {
            return Integer.valueOf(KB5.bank_noor);
        }
        return null;
    }

    public final Integer e(List list) {
        AbstractC13042fc3.i(list, "patterns");
        if (list.contains("603799")) {
            return Integer.valueOf(KB5.bank_melli);
        }
        if (list.contains("589210")) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (list.contains("627961")) {
            return Integer.valueOf(KB5.bank_sanat_madan);
        }
        if (list.contains("603770") || list.contains("639217")) {
            return Integer.valueOf(KB5.bank_keshavarzi);
        }
        if (list.contains("627760")) {
            return Integer.valueOf(KB5.bank_post_bank);
        }
        if (list.contains("627412")) {
            return Integer.valueOf(KB5.bank_eghtesad_novin);
        }
        if (list.contains("622106") || list.contains("639194") || list.contains("627884")) {
            return Integer.valueOf(KB5.bank_parsian);
        }
        if (list.contains("639347") || list.contains("502229")) {
            return Integer.valueOf(KB5.bank_pasargad);
        }
        if (list.contains("621986")) {
            return Integer.valueOf(KB5.bank_saman);
        }
        if (list.contains("639346")) {
            return Integer.valueOf(KB5.bank_sina);
        }
        if (list.contains("639607")) {
            return Integer.valueOf(KB5.bank_sarmayeh);
        }
        if (list.contains("636214")) {
            return Integer.valueOf(KB5.bank_ayandeh);
        }
        if (list.contains("504706") || list.contains("502806")) {
            return Integer.valueOf(KB5.bank_shahr);
        }
        if (list.contains("502938")) {
            return Integer.valueOf(KB5.bank_dey);
        }
        if (list.contains("603769")) {
            return Integer.valueOf(KB5.bank_saderat);
        }
        if (list.contains("610433") || list.contains("991975")) {
            return Integer.valueOf(KB5.bank_mellat);
        }
        if (list.contains("585983") || list.contains("627353")) {
            return Integer.valueOf(KB5.bank_tejarat);
        }
        if (list.contains("627381")) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (list.contains("636949")) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (list.contains("639370")) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (list.contains("505785")) {
            return Integer.valueOf(KB5.bank_iran_zamin);
        }
        if (list.contains("606256")) {
            return Integer.valueOf(KB5.bank_melal);
        }
        if (list.contains("585947")) {
            return Integer.valueOf(KB5.bank_khavarmianeh);
        }
        if (list.contains("505416")) {
            return Integer.valueOf(KB5.bank_gardeshgari);
        }
        if (list.contains("502908")) {
            return Integer.valueOf(KB5.bank_toseeh_teavon);
        }
        if (list.contains("627648") || list.contains("207177")) {
            return Integer.valueOf(KB5.bank_toseeh_saderat);
        }
        if (list.contains("589463")) {
            return Integer.valueOf(KB5.bank_refah);
        }
        if (list.contains("504172")) {
            return Integer.valueOf(KB5.bank_resalat);
        }
        if (list.contains("606373")) {
            return Integer.valueOf(KB5.bank_mehr_iran);
        }
        if (list.contains("639599")) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (list.contains("627488") || list.contains("502910")) {
            return Integer.valueOf(KB5.bank_karafarin);
        }
        if (list.contains("636795")) {
            return Integer.valueOf(KB5.bank_markazi);
        }
        if (list.contains("628023")) {
            return Integer.valueOf(KB5.bank_maskan);
        }
        if (list.contains("628157")) {
            return Integer.valueOf(KB5.bank_toseeh);
        }
        if (list.contains("505801")) {
            return Integer.valueOf(KB5.bank_sepah);
        }
        if (list.contains("507677")) {
            return Integer.valueOf(KB5.bank_noor);
        }
        return null;
    }

    public final String f(String str) {
        AbstractC13042fc3.i(str, "number");
        if (str.length() != 16) {
            return null;
        }
        String strSubstring = str.substring(0, 4);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String strSubstring2 = str.substring(4, 8);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        String strSubstring3 = str.substring(8, 12);
        AbstractC13042fc3.h(strSubstring3, "substring(...)");
        String strSubstring4 = str.substring(12, 16);
        AbstractC13042fc3.h(strSubstring4, "substring(...)");
        return strSubstring + Separators.SP + strSubstring2 + Separators.SP + strSubstring3 + Separators.SP + strSubstring4;
    }

    public final boolean g(String str) {
        AbstractC13042fc3.i(str, "cardNumber");
        return AbstractC20153rZ6.S(XY6.h(str), "2", false, 2, null) || AbstractC20153rZ6.S(XY6.h(str), "5", false, 2, null) || AbstractC20153rZ6.S(XY6.h(str), "6", false, 2, null) || AbstractC20153rZ6.S(XY6.h(str), "9", false, 2, null);
    }
}
