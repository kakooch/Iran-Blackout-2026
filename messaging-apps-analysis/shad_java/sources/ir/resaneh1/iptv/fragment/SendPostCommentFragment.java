package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.enums.EnumActionObject;
import ir.resaneh1.iptv.enums.EnumContentType;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.ActionOnObjectInput;
import org.rbmain.messenger.LocaleController;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class SendPostCommentFragment extends PresenterFragment {
    private String id;
    private EditText messageEditText;
    View.OnClickListener onClickListener;
    ProgressBar progressBar;
    View sendTextMessageButton;
    EnumContentType type;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.send_post_comment_dialog;
    }

    public SendPostCommentFragment(String str, EnumContentType enumContentType) {
        new Handler();
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.SendPostCommentFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SendPostCommentFragment sendPostCommentFragment = SendPostCommentFragment.this;
                if (view == sendPostCommentFragment.sendTextMessageButton) {
                    sendPostCommentFragment.sendTextMessage();
                }
            }
        };
        this.id = str;
        this.type = enumContentType;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.messageEditText = (EditText) findViewById(R.id.editTextMessage);
        View viewFindViewById = findViewById(R.id.sendMessageButton);
        this.sendTextMessageButton = viewFindViewById;
        viewFindViewById.setOnClickListener(this.onClickListener);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.back));
    }

    void sendTextMessage() {
        if (this.messageEditText.getText().length() == 0) {
            ToastiLikeSnack.showS(this.mContext, LocaleController.getString(R.string.enter_message_text));
            return;
        }
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).actionOnObject(new ActionOnObjectInput(this.id, this.type + BuildConfig.FLAVOR, EnumActionObject.add_comment, "0", ((Object) this.messageEditText.getText()) + BuildConfig.FLAVOR), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.SendPostCommentFragment.2
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                SendPostCommentFragment sendPostCommentFragment = SendPostCommentFragment.this;
                FirebaseEventSender.sendEvent(sendPostCommentFragment.mContext, "social_send_comment", sendPostCommentFragment.id);
                SendPostCommentFragment.this.progressBar.setVisibility(4);
                ToastiLikeSnack.showL(SendPostCommentFragment.this.mContext, LocaleController.getString(R.string.text_send_successfuly));
                ((Activity) SendPostCommentFragment.this.mContext).onBackPressed();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                SendPostCommentFragment.this.progressBar.setVisibility(4);
                ToastiLikeSnack.showL(SendPostCommentFragment.this.mContext, LocaleController.getString(R.string.error_on_send));
            }
        });
    }
}
