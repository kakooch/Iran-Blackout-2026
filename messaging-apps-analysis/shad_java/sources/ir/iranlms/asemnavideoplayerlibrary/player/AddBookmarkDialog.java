package ir.iranlms.asemnavideoplayerlibrary.player;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class AddBookmarkDialog extends Dialog {
    MyPlaybackControlView myPlaybackControlView;
    View.OnClickListener onClickListener;

    public AddBookmarkDialog(Activity activity, MyPlaybackControlView myPlaybackControlView) {
        super(activity);
        this.onClickListener = new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.AddBookmarkDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditText editText = (EditText) AddBookmarkDialog.this.findViewById(R.id.editText);
                AddBookmarkDialog.this.myPlaybackControlView.addBookMark(((Object) editText.getText()) + BuildConfig.FLAVOR);
                AddBookmarkDialog.this.dismiss();
            }
        };
        this.myPlaybackControlView = myPlaybackControlView;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.add_bookmark_dialog);
        findViewById(R.id.buttonSubmit).setOnClickListener(this.onClickListener);
    }
}
