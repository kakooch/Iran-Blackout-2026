package ir.resaneh1.iptv.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.aaap.messengercore.utilites.Objects;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DataGenerator;
import ir.resaneh1.iptv.model.Rubino;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.tgnet.TLRPC$PhotoSize;

/* loaded from: classes3.dex */
public class ShopModels {

    public static class AddProductInput {
        public String description;
        public HashMap<String, String> features;
        public boolean is_visible;
        public ArrayList<InputFile> media = new ArrayList<>();
        public String product_category_id;
        public String product_name;
        public ArrayList<ProductVariety> product_variety;
        public String store_id;
        public long unit_price;
    }

    public static class AddProductOutput {
        public Product product;
    }

    public static class City {
        public String id;
        public String name;
    }

    public static class DeleteProductInput {
        public String product_id;
        public String store_id;
    }

    public static class DeleteProductOutput {
    }

    public static class EditProductInput {
        public String description;
        public HashMap<String, String> features;
        public Boolean is_visible;
        public ArrayList<InputFile> media;
        public String product_category_id;
        public String product_id;
        public String product_name;
        public ArrayList<ProductVariety> product_variety;
        public String store_id;
        public Long unit_price;
        public ArrayList<String> updated_parameters;
    }

    public static class EmptyInput {
    }

    public enum FileType {
        Picture,
        Video
    }

    public static class GetColorsOutput {
        public ArrayList<ColorObject> colors;
    }

    public static class GetPostLinkedProductsInput {
        public ArrayList<String> product_ids;
        public String store_id;
    }

    public static class GetPostLinkedProductsOutput {
        public ArrayList<ProductSummaryObject> products;
    }

    public static class GetProductCategoriesOutput {
        public ArrayList<ProductCategory> product_categories;
    }

    public static class GetProductMessageLinkInput {
        public boolean get_address_info;
        public String product_id;
        public ArrayList<ProductMessageData.ProductMessageVariety> product_varieties;
        public String store_id;
    }

    public static class GetProductMessageLinkOutput {
        public Link link;
    }

    public static class GetStoreLinkInput {
        public String store_id;
    }

    public enum OutputFileType {
        Picture,
        Video
    }

    public static class Product {
        public ArrayList<ColorObject> colors;
        public String description;
        public HashMap<String, String> features;
        public String id;
        public boolean is_visible;
        public ArrayList<InputFile> media;
        public ProductCategory product_category;
        public String product_name;
        public ArrayList<ProductVariety> product_variety = new ArrayList<>();
        public String store_id;
        public long unit_price;
    }

    public static class ProductSummaryObject {
        public String id;
        public boolean is_visible;
        public InputFile media;
        public String product_name;
        public String store_id;
        public long unit_price;
    }

    public enum ProductVarietyTypeEnum {
        Color,
        Size
    }

    public static class Province {
        public String id;
        public String name;
    }

    public static class ShopImage {
        public TLRPC$PhotoSize bigPhoto;
        public InputFile inputFile;
        public InputFile outputFile;
        int rnd = AndroidUtilities.getNextRnd();
        public TLRPC$PhotoSize smallPhoto;
        public UploadingStateEnum state;
    }

    public static class ShopRequestUploadFileOutput {
        public String file_id;
        public String hash_file_request;
        public String server_url;
    }

    public static class ShopSelectableItem {
        public boolean isSelected;

        public String getId() {
            return BuildConfig.FLAVOR;
        }

        public Drawable getImage(Context context) {
            return null;
        }

        public String getName() {
            return BuildConfig.FLAVOR;
        }

        public boolean hasImage() {
            return false;
        }
    }

    public static class Store {
        public Link chat_link;
        public City city;
        public String id;
        public String image_url;
        public Province province;
        public ProductCategory store_category;
        public String store_name;
    }

    public enum UpdateParametersEnum {
        unit_price,
        is_visible,
        product_name,
        description,
        product_category_id,
        media,
        features,
        product_variety
    }

    public enum UploadingStateEnum {
        uploading,
        error,
        finished
    }

    public static class InputFile {
        public EmbeddedInputFile main_file;
        public EmbeddedInputFile thumbnail_file;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputFile)) {
                return false;
            }
            InputFile inputFile = (InputFile) obj;
            return Objects.equals(this.thumbnail_file, inputFile.thumbnail_file) && Objects.equals(this.main_file, inputFile.main_file);
        }
    }

    public static class ProductCategory extends ShopSelectableItem {
        public String category_name;
        public String id;

        @Override // ir.resaneh1.iptv.model.ShopModels.ShopSelectableItem
        public String getId() {
            return this.id;
        }

        @Override // ir.resaneh1.iptv.model.ShopModels.ShopSelectableItem
        public String getName() {
            return this.category_name;
        }

        public static ProductCategory generate() {
            ProductCategory productCategory = new ProductCategory();
            productCategory.id = DataGenerator.randomName();
            productCategory.category_name = DataGenerator.randomName();
            return productCategory;
        }
    }

    public static class ColorObject extends ShopSelectableItem {
        public String color_code;
        public String id;
        public String name;

        @Override // ir.resaneh1.iptv.model.ShopModels.ShopSelectableItem
        public boolean hasImage() {
            return true;
        }

        @Override // ir.resaneh1.iptv.model.ShopModels.ShopSelectableItem
        public String getId() {
            return this.id;
        }

        @Override // ir.resaneh1.iptv.model.ShopModels.ShopSelectableItem
        public String getName() {
            return this.name;
        }

        @Override // ir.resaneh1.iptv.model.ShopModels.ShopSelectableItem
        public Drawable getImage(Context context) throws Resources.NotFoundException {
            Drawable drawable = context.getResources().getDrawable(R.drawable.shape_white_circle);
            drawable.setColorFilter(new PorterDuffColorFilter(getColor(), PorterDuff.Mode.MULTIPLY));
            return drawable;
        }

        public int getColor() {
            return Color.parseColor(this.color_code);
        }

        public static ColorObject generate() {
            ColorObject colorObject = new ColorObject();
            colorObject.id = DataGenerator.randomName();
            colorObject.name = DataGenerator.randomName();
            colorObject.color_code = DataGenerator.randomInt(0, 9) + BuildConfig.FLAVOR + DataGenerator.randomInt(0, 9) + BuildConfig.FLAVOR + DataGenerator.randomInt(0, 9) + BuildConfig.FLAVOR + DataGenerator.randomInt(0, 9) + BuildConfig.FLAVOR + DataGenerator.randomInt(0, 9) + BuildConfig.FLAVOR + DataGenerator.randomInt(0, 9);
            return colorObject;
        }
    }

    public static class ProductVariety {
        public ProductVarietyTypeEnum type;
        public ArrayList<String> variety_values;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProductVariety)) {
                return false;
            }
            ProductVariety productVariety = (ProductVariety) obj;
            return Objects.equalsArray(this.variety_values, productVariety.variety_values) && this.type == productVariety.type;
        }
    }

    public static class ShopRequestUploadFileInput extends Rubino.BaseInput {
        public String file_name;
        public Long file_size;
        public FileType file_type;

        public ShopRequestUploadFileInput(String str) {
            super(str);
            this.file_type = FileType.Picture;
        }
    }

    public static class EmbeddedInputFile {
        public String access_hash_rec;
        public int duration;
        public String file_id;
        public FileType file_type;
        public String file_url;
        public int height;
        public int width;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EmbeddedInputFile)) {
                return false;
            }
            EmbeddedInputFile embeddedInputFile = (EmbeddedInputFile) obj;
            return this.width == embeddedInputFile.width && this.height == embeddedInputFile.height && this.duration == embeddedInputFile.duration && Objects.equals(this.file_url, embeddedInputFile.file_url) && Objects.equals(this.file_id, embeddedInputFile.file_id) && Objects.equals(this.access_hash_rec, embeddedInputFile.access_hash_rec) && this.file_type == embeddedInputFile.file_type;
        }
    }

    public static class PersonalDetail {
        public String address;
        public String name;
        public String phone;
        public String postalCode;

        public String getJsonString() {
            return ApplicationLoader.getGson().toJson(this);
        }

        public static PersonalDetail parseJson(String str) {
            try {
                return (PersonalDetail) ApplicationLoader.getGson().fromJson(str, PersonalDetail.class);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
