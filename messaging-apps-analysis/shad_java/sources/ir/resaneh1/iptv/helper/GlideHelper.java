package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.File;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.ui.Components.BackupImageView;

/* loaded from: classes3.dex */
public class GlideHelper {
    public static void load(Context context, ImageView imageView, String str) {
        load(context, imageView, str, R.color.white);
    }

    public static void loadWithoutPlaceHolder(Context context, ImageView imageView, String str) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        requestOptions.centerCrop();
        try {
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            FirebaseEventSender.setKey("loadWithoutPlaceHolder", "url" + str);
            FirebaseEventSender.recordException(e);
        }
    }

    public static void loadWithoutCrop(Context context, ImageView imageView, String str) {
        try {
            Glide.with(context).load(str).into(imageView);
        } catch (Exception unused) {
        }
    }

    public static void loadPath(Context context, ImageView imageView, String str, int i) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(i);
        requestOptions.centerCrop();
        loadPath(context, imageView, str, requestOptions);
    }

    public static void loadPath(Context context, ImageView imageView, String str, RequestOptions requestOptions) {
        try {
            Glide.with(context).load(new File(str)).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception unused) {
        }
    }

    public static void load(Context context, ImageView imageView, String str, int i) {
        imageView.setImageResource(i);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        requestOptions.centerCrop();
        requestOptions.placeholder(i);
        try {
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadWithColorPlaceHolder(Context context, ImageView imageView, String str, int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        imageView.setImageDrawable(colorDrawable);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        requestOptions.placeholder(colorDrawable);
        try {
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static Target<Drawable> preload(Context context, String str) {
        if (str == null) {
            return null;
        }
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.DATA);
        try {
            return Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptions).preload();
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
            return null;
        }
    }

    public static void clearTarget(Context context, Target<Drawable> target) {
        if (target != null) {
            try {
                Glide.with(context).clear(target);
            } catch (Exception unused) {
            }
        }
    }

    public static void loadForStory(Context context, final ImageView imageView, String str, final int i) {
        imageView.setImageResource(i);
        try {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.transforms(new CenterCrop());
            requestOptions.placeholder(i);
            Glide.with(context).asBitmap().apply((BaseRequestOptions<?>) requestOptions).load(str).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: ir.resaneh1.iptv.helper.GlideHelper.2
                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    imageView.setImageBitmap(bitmap);
                }

                @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable drawable) {
                    imageView.setImageResource(i);
                }
            });
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadCircle(Context context, ImageView imageView, int i, int i2) {
        imageView.setImageResource(i2);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        requestOptions.placeholder(i2);
        try {
            Glide.with(context).load(Integer.valueOf(i)).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadResource(Context context, ImageView imageView, int i) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        requestOptions.dontAnimate();
        try {
            Glide.with(context).load(Integer.valueOf(i)).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadCircle(Context context, ImageView imageView, String str) {
        loadCircle(context, imageView, str, R.drawable.shape_white_circle);
    }

    public static void loadBlur(Context context, final ImageView imageView, String str) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        try {
            Glide.with(context).asBitmap().load(str).apply((BaseRequestOptions<?>) requestOptions).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: ir.resaneh1.iptv.helper.GlideHelper.4
                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    imageView.setImageBitmap(BlurBuilder.blur(ApplicationLoader.applicationContext, bitmap));
                }
            });
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadRoundedCorner(Context context, ImageView imageView, String str) {
        loadRoundedCorner(context, imageView, str, 8, R.color.white);
    }

    public static void loadRoundedCorner(Context context, ImageView imageView, String str, int i) {
        loadRoundedCorner(context, imageView, str, 8, i);
    }

    public static void loadRoundedCorner(Context context, ImageView imageView, String str, int i, int i2) {
        imageView.setImageResource(i2);
        try {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.transforms(new CenterCrop(), new RoundedCorners(DimensionHelper.dpToPx(context, i)));
            requestOptions.placeholder(i2);
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadForDynamicView(Context context, BackupImageView backupImageView, String str, int i, String str2) {
        loadRoundedCornerForDynamicView(context, backupImageView, str, 0, i, str2);
    }

    public static void loadForDynamicView(Context context, BackupImageView backupImageView, String str, int i) {
        loadRoundedCornerForDynamicView(context, backupImageView, str, 0, i, null);
    }

    public static void loadRoundedCornerForDynamicView(Context context, BackupImageView backupImageView, String str, int i, int i2) {
        loadRoundedCornerForDynamicView(context, backupImageView, str, i, i2, null);
    }

    public static void loadRoundedCornerForDynamicView(Context context, BackupImageView backupImageView, String str, int i, int i2, String str2) {
        try {
            if (str2 != null) {
                backupImageView.setImage(ImageLocation.getForPath(str), (String) null, ImageLocation.getForPath(str2), (String) null, -1, (Object) null);
            } else if (i2 != 0) {
                backupImageView.setImage(ImageLocation.getForPath(str), (String) null, ResourcesCompat.getDrawable(context.getResources(), i2, null), (Object) null);
            } else {
                backupImageView.setImage(ImageLocation.getForPath(str), (String) null, (ImageLocation) null, (String) null, -1, (Object) null);
            }
            backupImageView.setRoundRadius(AndroidUtilities.dp(i));
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadCircleForDynamicView(Context context, BackupImageView backupImageView, String str, int i) {
        loadCircleForDynamicView(context, backupImageView, str, i, null);
    }

    public static void loadCircleForDynamicView(Context context, BackupImageView backupImageView, String str, int i, String str2) {
        try {
            if (str2 != null) {
                backupImageView.setImage(ImageLocation.getForPath(str), (String) null, ImageLocation.getForPath(str2), (String) null, -1, (Object) null);
            } else if (i != 0) {
                backupImageView.setImage(ImageLocation.getForPath(str), (String) null, ResourcesCompat.getDrawable(context.getResources(), i, null), (Object) null);
            } else {
                backupImageView.setImage(ImageLocation.getForPath(str), (String) null, (ImageLocation) null, (String) null, -1, (Object) null);
            }
            try {
                backupImageView.setRoundRadius(backupImageView.getLayoutParams().width / 2);
            } catch (Exception unused) {
                backupImageView.setRoundRadius(AndroidUtilities.dp(300.0f));
            }
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadRoundedCornerFitCenter(Context context, ImageView imageView, String str, int i, int i2) {
        imageView.setImageResource(i2);
        try {
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) new RequestOptions().transforms(new FitCenter(), new RoundedCorners(DimensionHelper.dpToPx(context, i))).placeholder(i2).fitCenter()).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadFitCenter(Context context, ImageView imageView, String str, int i) {
        imageView.setImageResource(i);
        try {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.fitCenter();
            requestOptions.placeholder(i);
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void loadCircle(Context context, ImageView imageView, String str, int i) {
        imageView.setImageResource(i);
        try {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.circleCrop().placeholder(i);
            Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }

    public static void optimizedLoadWithSize(Context context, final ImageView imageView, String str, int i, int i2, int i3, final int i4) {
        imageView.setImageResource(i4);
        try {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.transforms(new CenterCrop(), new RoundedCorners(DimensionHelper.dpToPx(context, i3)));
            requestOptions.placeholder(i4);
            requestOptions.override(i, i2);
            Glide.with(context).asBitmap().apply((BaseRequestOptions<?>) requestOptions).load(str).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: ir.resaneh1.iptv.helper.GlideHelper.7
                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    imageView.setImageBitmap(bitmap);
                }

                @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable drawable) {
                    imageView.setImageResource(i4);
                }
            });
        } catch (Exception e) {
            MyLog.e("messsage GlideException", "Glide" + e.getMessage());
        }
    }
}
