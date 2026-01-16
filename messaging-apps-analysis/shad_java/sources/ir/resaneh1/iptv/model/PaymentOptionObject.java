package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class PaymentOptionObject {
    public Card2CardTopOption card2cardtop_options;
    public ProviderEnum provider;
    public RubikaDialogPaymentOption rubika_payment_options;
    public TopOption top_options;
    public WebOption web_options;

    public static class Card2CardTopOption {
        public String token;
    }

    public enum ProviderEnum {
        Web,
        Top,
        Card2CardTop,
        Wallet,
        RubikaPayment
    }

    public static class RubikaDialogPaymentOption {
        public RubikaPaymentObject rubika_payment;
    }

    public static class TopOption {
        public String token;
        public String type;
    }

    public static class WebOption {
        public String url;
    }
}
