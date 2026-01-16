package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.enums.EnumActionObject;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.ActionOnObjectInput;
import ir.resaneh1.iptv.model.TagObject;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class SendCommentFragment extends PresenterFragment {
    private final String id;
    private EditText messageEditText;
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.SendCommentFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SendCommentFragment sendCommentFragment = SendCommentFragment.this;
            if (view != sendCommentFragment.sendTextMessageButton || sendCommentFragment.type == TagObject.TagType.app) {
                return;
            }
            SendCommentFragment.this.sendTextMessage();
        }
    };
    ProgressBar progressBar;
    RatingBar ratingBar;
    View sendTextMessageButton;
    private final TagObject.TagType type;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.send_comment_dialog;
    }

    public SendCommentFragment(String str, TagObject.TagType tagType) {
        this.id = str;
        this.type = tagType;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.messageEditText = (EditText) findViewById(R.id.editTextMessage);
        View viewFindViewById = findViewById(R.id.buttonSend);
        this.sendTextMessageButton = viewFindViewById;
        viewFindViewById.setOnClickListener(this.onClickListener);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.ratingBar = (RatingBar) findViewById(R.id.ratingbar);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "بازگشت");
    }

    void sendTextMessage() {
        ActionOnObjectInput actionOnObjectInput;
        if (this.ratingBar.getRating() == 0.0f && this.type != TagObject.TagType.vchannel_item) {
            ToastiLikeSnack.showS(this.mContext, "لطفا امتیاز دهید");
            return;
        }
        if (this.type == TagObject.TagType.vchannel_item && this.messageEditText.getText().toString().trim().length() == 0) {
            ToastiLikeSnack.showS(this.mContext, "لطفا متن نظر را وارد کنید");
            return;
        }
        this.progressBar.setVisibility(0);
        ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.getInstance(this.currentAccount);
        if (this.type == TagObject.TagType.app) {
            actionOnObjectInput = new ActionOnObjectInput(this.id, "comment", EnumActionObject.add_comment, ((int) this.ratingBar.getRating()) + BuildConfig.FLAVOR, ((Object) this.messageEditText.getText()) + BuildConfig.FLAVOR);
        } else {
            actionOnObjectInput = new ActionOnObjectInput(this.id, this.type + BuildConfig.FLAVOR, EnumActionObject.add_comment, ((int) this.ratingBar.getRating()) + BuildConfig.FLAVOR, ((Object) this.messageEditText.getText()) + BuildConfig.FLAVOR);
        }
        this.sendTextMessageButton.setEnabled(false);
        apiRequestIPTV.actionOnObject(actionOnObjectInput, new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.SendCommentFragment.2
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                SendCommentFragment.this.progressBar.setVisibility(4);
                SendCommentFragment.this.sendTextMessageButton.setEnabled(true);
                ToastiLikeSnack.showL(SendCommentFragment.this.mContext, "با تشکر، نظر شما با موفقیت ارسال شد.");
                ((Activity) SendCommentFragment.this.mContext).onBackPressed();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                SendCommentFragment.this.progressBar.setVisibility(4);
                SendCommentFragment.this.sendTextMessageButton.setEnabled(true);
                ToastiLikeSnack.showL(SendCommentFragment.this.mContext, "خطا در ارسال");
            }
        });
    }
}
