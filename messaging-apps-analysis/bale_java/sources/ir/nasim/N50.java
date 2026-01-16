package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class N50 {
    public static final C6297b e = new C6297b(null);
    public static final int f = 8;
    private final String a;
    private final String b;
    private final List c;
    private final Integer d;

    public static final class A extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public A(String str) {
            super("شهر", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4293473332L)), C24381yX0.k(DX0.d(4293412422L)), C24381yX0.k(DX0.d(4292960866L)), C24381yX0.k(DX0.d(4293887365L)), C24381yX0.k(DX0.d(4293626249L))), Integer.valueOf(KB5.ic_bank_shahr), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof A) && AbstractC13042fc3.d(this.g, ((A) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "ShahrCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class B extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public B(String str) {
            super("سینا", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4290088769L)), C24381yX0.k(DX0.d(4290614345L)), C24381yX0.k(DX0.d(4291734100L)), C24381yX0.k(DX0.d(4292787555L)), C24381yX0.k(DX0.d(4293184385L))), Integer.valueOf(KB5.ic_bank_sina), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof B) && AbstractC13042fc3.d(this.g, ((B) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "SinaCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class C extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C(String str) {
            super("تجارت", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4281881498L)), C24381yX0.k(DX0.d(4282605744L)), C24381yX0.k(DX0.d(4284711375L)), C24381yX0.k(DX0.d(4287539697L)), C24381yX0.k(DX0.d(4291746036L))), Integer.valueOf(KB5.ic_bank_tejarat), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C) && AbstractC13042fc3.d(this.g, ((C) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "TejaratCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class D extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public D(String str) {
            super("توسعه صادرات ایران", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4284971845L)), C24381yX0.k(DX0.d(4280376357L)), C24381yX0.k(DX0.d(4282872650L)), C24381yX0.k(DX0.d(4285964162L)), C24381yX0.k(DX0.d(4287673239L))), Integer.valueOf(KB5.ic_bank_tosee_saderat), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof D) && AbstractC13042fc3.d(this.g, ((D) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "ToseeSaderatCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class E extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public E(String str) {
            super("توسعه تعاون", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4284194780L)), C24381yX0.k(DX0.d(4284194265L)), C24381yX0.k(DX0.d(4286888682L)), C24381yX0.k(DX0.d(4288596202L)), C24381yX0.k(DX0.d(4291813615L))), null, null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof E) && AbstractC13042fc3.d(this.g, ((E) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "ToseeTaavonCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.N50$a, reason: case insensitive filesystem */
    public static final class C6296a extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6296a(String str) {
            super("آینده", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4285744415L)), C24381yX0.k(DX0.d(4287258120L)), C24381yX0.k(DX0.d(4289626394L)), C24381yX0.k(DX0.d(4290945365L)), C24381yX0.k(DX0.d(4291999868L))), Integer.valueOf(KB5.ic_bank_ayande), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C6296a) && AbstractC13042fc3.d(this.g, ((C6296a) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "AyandeCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.N50$b, reason: case insensitive filesystem */
    public static final class C6297b {
        private C6297b() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final N50 a(BankCreditCard bankCreditCard) {
            AbstractC13042fc3.i(bankCreditCard, "bankCreditCard");
            Bank bank = bankCreditCard.getBank();
            if (bank == null) {
                return null;
            }
            String name = bank.getName();
            switch (name.hashCode()) {
                case -1952539777:
                    if (name.equals("خاورمیانه")) {
                        return new k(bankCreditCard.getNumber());
                    }
                    return null;
                case -1745597377:
                    if (name.equals("توسعه صادرات ایران")) {
                        return new D(bankCreditCard.getNumber());
                    }
                    return null;
                case -1642669884:
                    if (name.equals("رفاه کارگران")) {
                        return new u(bankCreditCard.getNumber());
                    }
                    return null;
                case -904940285:
                    if (name.equals("پاسارگاد")) {
                        return new s(bankCreditCard.getNumber());
                    }
                    return null;
                case -527883699:
                    if (name.equals("پست بانک")) {
                        return new t(bankCreditCard.getNumber());
                    }
                    return null;
                case -297013157:
                    if (name.equals("سرمایه")) {
                        return new y(bankCreditCard.getNumber());
                    }
                    return null;
                case -277094584:
                    if (name.equals("قرض الحسنه رسالت")) {
                        return new g(bankCreditCard.getNumber());
                    }
                    return null;
                case -249641001:
                    if (name.equals("صادرات")) {
                        return new v(bankCreditCard.getNumber());
                    }
                    return null;
                case -41468735:
                    if (name.equals("صنعت و معدن")) {
                        return new x(bankCreditCard.getNumber());
                    }
                    return null;
                case -30076389:
                    if (name.equals("موسسه اعتباری ملل")) {
                        return new n(bankCreditCard.getNumber());
                    }
                    return null;
                case -30075323:
                    if (name.equals("موسسه اعتباری نور")) {
                        return new q(bankCreditCard.getNumber());
                    }
                    return null;
                case 50813:
                    if (name.equals("دی")) {
                        return new C6298c(bankCreditCard.getNumber());
                    }
                    return null;
                case 1577470:
                    if (name.equals("شهر")) {
                        return new A(bankCreditCard.getNumber());
                    }
                    return null;
                case 1578236:
                    if (name.equals("سپه")) {
                        return new z(bankCreditCard.getNumber());
                    }
                    return null;
                case 1593707:
                    if (name.equals("ملت")) {
                        return new o(bankCreditCard.getNumber());
                    }
                    return null;
                case 1593869:
                    if (name.equals("ملی")) {
                        return new p(bankCreditCard.getNumber());
                    }
                    return null;
                case 49001818:
                    if (name.equals("سینا")) {
                        return new B(bankCreditCard.getNumber());
                    }
                    return null;
                case 49394123:
                    if (name.equals("مسکن")) {
                        return new m(bankCreditCard.getNumber());
                    }
                    return null;
                case 130681410:
                    if (name.equals("ایران زمین")) {
                        return new h(bankCreditCard.getNumber());
                    }
                    return null;
                case 959944889:
                    if (name.equals("کارآفرین")) {
                        return new i(bankCreditCard.getNumber());
                    }
                    return null;
                case 1087763039:
                    if (name.equals("کشاورزی")) {
                        return new j(bankCreditCard.getNumber());
                    }
                    return null;
                case 1216389536:
                    if (name.equals("پارسیان")) {
                        return new r(bankCreditCard.getNumber());
                    }
                    return null;
                case 1356593943:
                    if (name.equals("قرض الحسنه مهر ایران")) {
                        return new f(bankCreditCard.getNumber());
                    }
                    return null;
                case 1503358356:
                    if (name.equals("آینده")) {
                        return new C6296a(bankCreditCard.getNumber());
                    }
                    return null;
                case 1505950206:
                    if (name.equals("تجارت")) {
                        return new C(bankCreditCard.getNumber());
                    }
                    return null;
                case 1514141488:
                    if (name.equals("سامان")) {
                        return new w(bankCreditCard.getNumber());
                    }
                    return null;
                case 1531159351:
                    if (name.equals("مرکزی")) {
                        return new l(bankCreditCard.getNumber());
                    }
                    return null;
                case 1695722969:
                    if (name.equals("توسعه تعاون")) {
                        return new E(bankCreditCard.getNumber());
                    }
                    return null;
                case 2038843779:
                    if (name.equals("گردشگری")) {
                        return new C6300e(bankCreditCard.getNumber());
                    }
                    return null;
                case 2073090862:
                    if (name.equals("اقتصاد نوین")) {
                        return new C6299d(bankCreditCard.getNumber());
                    }
                    return null;
                default:
                    return null;
            }
        }

        public /* synthetic */ C6297b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.N50$c, reason: case insensitive filesystem */
    public static final class C6298c extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6298c(String str) {
            super("دی", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4284194780L)), C24381yX0.k(DX0.d(4284194265L)), C24381yX0.k(DX0.d(4286888682L)), C24381yX0.k(DX0.d(4288596202L)), C24381yX0.k(DX0.d(4291813615L))), Integer.valueOf(KB5.ic_bank_dey), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C6298c) && AbstractC13042fc3.d(this.g, ((C6298c) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "DeyCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.N50$d, reason: case insensitive filesystem */
    public static final class C6299d extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6299d(String str) {
            super("اقتصاد نوین", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4286991789L)), C24381yX0.k(DX0.d(4287850928L)), C24381yX0.k(DX0.d(4289430216L)), C24381yX0.k(DX0.d(4290482648L)), C24381yX0.k(DX0.d(4291273952L))), Integer.valueOf(KB5.ic_bank_eghtesad_novin), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C6299d) && AbstractC13042fc3.d(this.g, ((C6299d) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "EghtesadNovinCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.N50$e, reason: case insensitive filesystem */
    public static final class C6300e extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6300e(String str) {
            super("گردشگری", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4284194780L)), C24381yX0.k(DX0.d(4284194265L)), C24381yX0.k(DX0.d(4286888682L)), C24381yX0.k(DX0.d(4288596202L)), C24381yX0.k(DX0.d(4291813615L))), null, null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C6300e) && AbstractC13042fc3.d(this.g, ((C6300e) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "GardeshgariCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class f extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super("قرض الحسنه مهر ایران", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4283274520L)), C24381yX0.k(DX0.d(4283602974L)), C24381yX0.k(DX0.d(4285379890L)), C24381yX0.k(DX0.d(4288661879L)), C24381yX0.k(DX0.d(4291353761L))), Integer.valueOf(KB5.ic_bank_mehr_iran), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && AbstractC13042fc3.d(this.g, ((f) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "GharzolhasanehMehrIranCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class g extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super("قرض الحسنه رسالت", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4287615974L)), C24381yX0.k(DX0.d(4284194265L)), C24381yX0.k(DX0.d(4286888682L)), C24381yX0.k(DX0.d(4288596202L)), C24381yX0.k(DX0.d(4291813615L))), Integer.valueOf(KB5.ic_bank_resalat), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && AbstractC13042fc3.d(this.g, ((g) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "GharzolhasanehResalatCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class h extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super("ایران زمین", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4283896742L)), C24381yX0.k(DX0.d(4286464448L)), C24381yX0.k(DX0.d(4287852733L)), C24381yX0.k(DX0.d(4288115643L)), C24381yX0.k(DX0.d(4292461546L))), Integer.valueOf(KB5.ic_bank_iran_zamin), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && AbstractC13042fc3.d(this.g, ((h) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "IranZaminCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class i extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super("کارآفرین", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4291132689L)), C24381yX0.k(DX0.d(4290875463L)), C24381yX0.k(DX0.d(4289892447L)), C24381yX0.k(DX0.d(4288384636L)), C24381yX0.k(DX0.d(4290227874L))), null, null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && AbstractC13042fc3.d(this.g, ((i) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "KarafarinCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class j extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super("کشاورزی", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4292264051L)), C24381yX0.k(DX0.d(4292527482L)), C24381yX0.k(DX0.d(4290357072L)), C24381yX0.k(DX0.d(4290158926L)), C24381yX0.k(DX0.d(4288513313L))), Integer.valueOf(KB5.ic_bank_keshavarzi), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && AbstractC13042fc3.d(this.g, ((j) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "KeshavarziCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class k extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str) {
            super("خاورمیانه", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4291132689L)), C24381yX0.k(DX0.d(4290875463L)), C24381yX0.k(DX0.d(4289892447L)), C24381yX0.k(DX0.d(4288384636L)), C24381yX0.k(DX0.d(4290227874L))), Integer.valueOf(KB5.ic_bank_khavarmiane), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && AbstractC13042fc3.d(this.g, ((k) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "KhavarmianeCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class l extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super("مرکزی", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4285744415L)), C24381yX0.k(DX0.d(4287258120L)), C24381yX0.k(DX0.d(4289626394L)), C24381yX0.k(DX0.d(4290945365L)), C24381yX0.k(DX0.d(4291999868L))), null, null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && AbstractC13042fc3.d(this.g, ((l) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "MarkaziCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class m extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super("مسکن", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4292371472L)), C24381yX0.k(DX0.d(4292634903L)), C24381yX0.k(DX0.d(4294152771L)), C24381yX0.k(DX0.d(4294158418L)), C24381yX0.k(DX0.d(4294227054L))), Integer.valueOf(KB5.ic_bank_maskan), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && AbstractC13042fc3.d(this.g, ((m) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "MaskanCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class n extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super("موسسه اعتباری ملل", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4292785509L)), C24381yX0.k(DX0.d(4291274855L)), C24381yX0.k(DX0.d(4290287707L)), C24381yX0.k(DX0.d(4290484051L)), C24381yX0.k(DX0.d(4291203652L))), Integer.valueOf(KB5.ic_bank_melal), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof n) && AbstractC13042fc3.d(this.g, ((n) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "MelalCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class o extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(String str) {
            super("ملّت", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4294576978L)), C24381yX0.k(DX0.d(4293087865L)), C24381yX0.k(DX0.d(4293297545L)), C24381yX0.k(DX0.d(4293630127L)), C24381yX0.k(DX0.d(4294894583L))), Integer.valueOf(KB5.ic_bank_mellat), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && AbstractC13042fc3.d(this.g, ((o) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "MellatCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class p extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(String str) {
            super("ملّی", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4287588898L)), C24381yX0.k(DX0.d(4287459356L)), C24381yX0.k(DX0.d(4289562923L)), C24381yX0.k(DX0.d(4291866985L)), C24381yX0.k(DX0.d(4293709449L))), Integer.valueOf(KB5.ic_bank_melli), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && AbstractC13042fc3.d(this.g, ((p) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "MelliCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class q extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(String str) {
            super("موسسه اعتباری نور", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4283896742L)), C24381yX0.k(DX0.d(4286464448L)), C24381yX0.k(DX0.d(4287852733L)), C24381yX0.k(DX0.d(4288115643L)), C24381yX0.k(DX0.d(4292461546L))), null, null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && AbstractC13042fc3.d(this.g, ((q) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "NoorCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class r extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(String str) {
            super("پارسیان", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4289560152L)), C24381yX0.k(DX0.d(4291592760L)), C24381yX0.k(DX0.d(4292847453L)), C24381yX0.k(DX0.d(4292458363L)), C24381yX0.k(DX0.d(4292989099L))), Integer.valueOf(KB5.ic_bank_parsian), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && AbstractC13042fc3.d(this.g, ((r) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "ParsianCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class s extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(String str) {
            super("پاسارگاد", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4281547323L)), C24381yX0.k(DX0.d(4282073153L)), C24381yX0.k(DX0.d(4283192147L)), C24381yX0.k(DX0.d(4284508007L)), C24381yX0.k(DX0.d(4285890175L))), Integer.valueOf(KB5.ic_bank_pasargad), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && AbstractC13042fc3.d(this.g, ((s) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "PasargadCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class t extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(String str) {
            super("پست بانک", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4286991789L)), C24381yX0.k(DX0.d(4287850928L)), C24381yX0.k(DX0.d(4289430216L)), C24381yX0.k(DX0.d(4290482648L)), C24381yX0.k(DX0.d(4291273952L))), null, null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof t) && AbstractC13042fc3.d(this.g, ((t) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "PostBankCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class u extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(String str) {
            super("رفاه کارگران", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4282931096L)), C24381yX0.k(DX0.d(4281747605L)), C24381yX0.k(DX0.d(4284773304L)), C24381yX0.k(DX0.d(4286153908L)), C24381yX0.k(DX0.d(4286284714L))), Integer.valueOf(KB5.ic_bank_refah), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof u) && AbstractC13042fc3.d(this.g, ((u) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "RefahKargaranCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class v extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(String str) {
            super("صادرات", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4287989439L)), C24381yX0.k(DX0.d(4287463620L)), C24381yX0.k(DX0.d(4288385222L)), C24381yX0.k(DX0.d(4289373650L)), C24381yX0.k(DX0.d(4289769433L))), Integer.valueOf(KB5.ic_bank_saderat), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof v) && AbstractC13042fc3.d(this.g, ((v) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "SaderatCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class w extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(String str) {
            super("سامان", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4293588989L)), C24381yX0.k(DX0.d(4285517560L)), C24381yX0.k(DX0.d(4278364904L)), C24381yX0.k(DX0.d(4278218680L)), C24381yX0.k(DX0.d(4278218680L))), Integer.valueOf(KB5.ic_bank_saman), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof w) && AbstractC13042fc3.d(this.g, ((w) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "SamanCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class x extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(String str) {
            super("صنعت و معدن", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4287865549L)), C24381yX0.k(DX0.d(4286418617L)), C24381yX0.k(DX0.d(4283457681L)), C24381yX0.k(DX0.d(4282011523L)), C24381yX0.k(DX0.d(4282538893L))), Integer.valueOf(KB5.ic_bank_sanat_madan), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof x) && AbstractC13042fc3.d(this.g, ((x) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "SanatOMadanCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class y extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(String str) {
            super("سرمایه", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4282335072L)), C24381yX0.k(DX0.d(4282400872L)), C24381yX0.k(DX0.d(4284572032L)), C24381yX0.k(DX0.d(4285953680L)), C24381yX0.k(DX0.d(4287072163L))), Integer.valueOf(KB5.ic_bank_sarmayeh), null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof y) && AbstractC13042fc3.d(this.g, ((y) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "SarmayehCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public static final class z extends N50 {
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(String str) {
            super("سپه", str, AbstractC10360bX0.p(C24381yX0.k(DX0.d(4283896742L)), C24381yX0.k(DX0.d(4286464448L)), C24381yX0.k(DX0.d(4287852733L)), C24381yX0.k(DX0.d(4288115643L)), C24381yX0.k(DX0.d(4292461546L))), null, null);
            AbstractC13042fc3.i(str, "cardNumber");
            this.g = str;
        }

        @Override // ir.nasim.N50
        public String c() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof z) && AbstractC13042fc3.d(this.g, ((z) obj).g);
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public String toString() {
            return "SepahCreditCardUI(cardNumber=" + this.g + Separators.RPAREN;
        }
    }

    public /* synthetic */ N50(String str, String str2, List list, Integer num, ED1 ed1) {
        this(str, str2, list, num);
    }

    public final String a() {
        return this.a;
    }

    public final List b() {
        return this.c;
    }

    public abstract String c();

    public final Integer d() {
        return this.d;
    }

    private N50(String str, String str2, List list, Integer num) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = num;
    }
}
