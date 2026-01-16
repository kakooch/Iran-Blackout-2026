package ir.aaap.messengercore.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ProductMessageData {
    public int product_file_height;
    public String product_file_url;
    public int product_file_width;
    public String product_id;
    public String product_name;
    public ArrayList<ProductMessageVariety> product_varieties = new ArrayList<>();
    public String store_file_url;
    public String store_id;
    public String store_name;
    public ChatType toType;
    public long unit_price;

    public static class OtherVarietyData {
        public String value;
        public String variety_name;
    }

    public static class ProductMessageColor {
        public String color_code;
        public String id;
        public String name;
    }

    public static class ProductMessageVariety {
        public ProductMessageColor color_data;
        public OtherVarietyData other_data;
        public ProductMessageVarietyType type;
    }

    public enum ProductMessageVarietyType {
        Color,
        Other
    }
}
