package androidMessenger.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidMessenger.utilites.MyLog;
import androidMessenger.utilites.ToastiLikeSnack;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes.dex */
public class GlideHelper {

    public interface Delegate {
        void onDone(Bitmap bitmap);
    }

    public static void load(Context context, ImageView imageView, String str) {
        load(context, imageView, str, -1);
    }

    public static void load(Context context, ImageView imageView, String str, int i) {
        imageView.setImageResource(i);
        try {
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) new RequestOptions().centerCrop().placeholder(i)).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadResourceFitCenter(Context context, ImageView imageView, int i) {
        try {
            Glide.with(context).load(Integer.valueOf(i)).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter().dontAnimate()).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadRoundedCornerParallax(Context context, ImageView imageView, String str) {
        loadRoundedCorner(context, imageView, str, 8, R.drawable.transparent);
    }

    public static void loadRoundedCorner(Context context, ImageView imageView, String str, int i, int i2) {
        imageView.setImageResource(i2);
        try {
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(AndroidUtilities.dp(i))).placeholder(i2)).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadRoundedCornerNoCropCenter(Context context, ImageView imageView, String str, int i, int i2) {
        imageView.setImageResource(i2);
        try {
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) new RequestOptions().transform(new RoundedCorners(AndroidUtilities.dp(i))).placeholder(i2)).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadCircle(Context context, String str, int i, int i2, final Delegate delegate) {
        RequestBuilder<Bitmap> requestBuilderLoad;
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transforms(new CircleCrop(), new RoundedCorners(AndroidUtilities.dp(4.0f)));
        try {
            RequestBuilder<Bitmap> requestBuilderApply = Glide.with(context).asBitmap().apply((BaseRequestOptions<?>) requestOptions.placeholder(i));
            if (str == null || str.isEmpty()) {
                requestBuilderLoad = requestBuilderApply.load(Integer.valueOf(i2));
            } else {
                requestBuilderLoad = requestBuilderApply.load(str);
            }
            requestBuilderLoad.into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: androidMessenger.helper.GlideHelper.4
                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    delegate.onDone(bitmap);
                }

                @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable drawable) {
                    ToastiLikeSnack.showMessageLikeToast("فرآیند اضافه کردن میانبر با خطا مواجه شد لطفا مجددا تلاش نمایید");
                }
            });
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }
}
