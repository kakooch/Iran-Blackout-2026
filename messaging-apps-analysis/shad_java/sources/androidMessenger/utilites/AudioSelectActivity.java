package androidMessenger.utilites;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidMessenger.utilites.AudioCell;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LocaleController;
import ir.appp.rghapp.RGHMediaHelper$AudioEntry;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.FragmentType;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeFilename;
import org.rbmain.tgnet.TLRPC$TL_message;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.PickerBottomLayout;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes.dex */
public class AudioSelectActivity extends BaseFragment {
    private PickerBottomLayout bottomLayout;
    private AudioSelectActivityDelegate delegate;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private DispatchQueue loaderQueue;
    private boolean loadingAudio;
    private EmptyTextProgressView progressView;
    private ArrayList<RGHMediaHelper$AudioEntry> audioEntries = new ArrayList<>();
    private LongSparseArray<RGHMediaHelper$AudioEntry> selectedAudios = new LongSparseArray<>();

    public interface AudioSelectActivityDelegate {
        void didSelectAudio(ArrayList<MessageObject> arrayList);
    }

    public AudioSelectActivity() {
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "AudioSelectActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        this.loaderQueue = new DispatchQueue("musicLoaderQueue");
        loadAudio();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        this.loaderQueue.cleanupQueue();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle("موسیقی");
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: androidMessenger.utilites.AudioSelectActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    AudioSelectActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.progressView = emptyTextProgressView;
        emptyTextProgressView.setText("هیچ موسیقی بر روی دستگاه شما موجود نمیباشد");
        frameLayout2.addView(this.progressView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setEmptyView(this.progressView);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: androidMessenger.utilites.AudioSelectActivity.2
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int i) {
                AudioCell audioCell = (AudioCell) view;
                RGHMediaHelper$AudioEntry audioEntry = audioCell.getAudioEntry();
                if (AudioSelectActivity.this.selectedAudios.indexOfKey(audioEntry.id) >= 0) {
                    AudioSelectActivity.this.selectedAudios.remove(audioEntry.id);
                    audioCell.setChecked(false);
                } else {
                    AudioSelectActivity.this.selectedAudios.put(audioEntry.id, audioEntry);
                    audioCell.setChecked(true);
                }
                AudioSelectActivity.this.updateBottomLayoutCount();
            }
        });
        PickerBottomLayout pickerBottomLayout = new PickerBottomLayout(context, false);
        this.bottomLayout = pickerBottomLayout;
        frameLayout2.addView(pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 80));
        this.bottomLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: androidMessenger.utilites.AudioSelectActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AudioSelectActivity.this.finishFragment();
            }
        });
        this.bottomLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: androidMessenger.utilites.AudioSelectActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AudioSelectActivity.this.delegate != null) {
                    ArrayList<MessageObject> arrayList = new ArrayList<>();
                    for (int i = 0; i < AudioSelectActivity.this.selectedAudios.size(); i++) {
                        arrayList.add(((RGHMediaHelper$AudioEntry) AudioSelectActivity.this.selectedAudios.valueAt(i)).messageObject);
                    }
                    AudioSelectActivity.this.delegate.didSelectAudio(arrayList);
                }
                AudioSelectActivity.this.finishFragment();
            }
        });
        View view = new View(context);
        view.setBackgroundResource(R.drawable.header_shadow_reverse);
        frameLayout2.addView(view, LayoutHelper.createFrame(-1, 3.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        if (this.loadingAudio) {
            this.progressView.showProgress();
        } else {
            this.progressView.showTextView();
        }
        updateBottomLayoutCount();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBottomLayoutCount() {
        this.bottomLayout.updateSelectedCount(this.selectedAudios.size(), true);
    }

    public void setDelegate(AudioSelectActivityDelegate audioSelectActivityDelegate) {
        this.delegate = audioSelectActivityDelegate;
    }

    private void loadAudio() {
        this.loadingAudio = true;
        EmptyTextProgressView emptyTextProgressView = this.progressView;
        if (emptyTextProgressView != null) {
            emptyTextProgressView.showProgress();
        }
        this.loaderQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.AudioSelectActivity.5
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                int i = 2;
                int i2 = 4;
                int i3 = 5;
                String[] strArr = {"_id", "artist", "title", "_data", "duration", "album"};
                final ArrayList arrayList = new ArrayList();
                Cursor cursorQuery = null;
                try {
                    cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, strArr, "is_music != 0", null, "title");
                    long j = -2000000000;
                    while (cursorQuery.moveToNext()) {
                        try {
                            RGHMediaHelper$AudioEntry rGHMediaHelper$AudioEntry = new RGHMediaHelper$AudioEntry();
                            rGHMediaHelper$AudioEntry.id = cursorQuery.getInt(0);
                            rGHMediaHelper$AudioEntry.author = cursorQuery.getString(1);
                            rGHMediaHelper$AudioEntry.title = cursorQuery.getString(i);
                            rGHMediaHelper$AudioEntry.path = cursorQuery.getString(3);
                            rGHMediaHelper$AudioEntry.duration = (int) (cursorQuery.getLong(i2) / 1000);
                            rGHMediaHelper$AudioEntry.genre = cursorQuery.getString(i3);
                            File file = new File(rGHMediaHelper$AudioEntry.path);
                            TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                            tLRPC$TL_message.out = true;
                            tLRPC$TL_message.id = j;
                            tLRPC$TL_message.peer_id = new TLRPC$TL_peerUser();
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
                            TLRPC$Peer tLRPC$Peer = tLRPC$TL_message.peer_id;
                            int clientUserId = UserConfig.getInstance(((BaseFragment) AudioSelectActivity.this).currentAccount).getClientUserId();
                            tLRPC$TL_peerUser.user_id = clientUserId;
                            tLRPC$Peer.user_id = clientUserId;
                            Cursor cursor = cursorQuery;
                            try {
                                tLRPC$TL_message.date = (int) (System.currentTimeMillis() / 1000);
                                tLRPC$TL_message.message = BuildConfig.FLAVOR;
                                tLRPC$TL_message.attachPath = rGHMediaHelper$AudioEntry.path;
                                TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
                                tLRPC$TL_message.media = tLRPC$TL_messageMediaDocument;
                                tLRPC$TL_messageMediaDocument.flags |= 3;
                                tLRPC$TL_messageMediaDocument.document = new TLRPC$TL_document();
                                tLRPC$TL_message.flags |= 768;
                                String fileExtension = FileLoader.getFileExtension(file);
                                TLRPC$Document tLRPC$Document = tLRPC$TL_message.media.document;
                                tLRPC$Document.id = 0L;
                                tLRPC$Document.access_hash = 0L;
                                tLRPC$Document.file_reference = new byte[0];
                                tLRPC$Document.date = tLRPC$TL_message.date;
                                StringBuilder sb = new StringBuilder();
                                sb.append("audio/");
                                if (fileExtension.length() <= 0) {
                                    fileExtension = "mp3";
                                }
                                sb.append(fileExtension);
                                tLRPC$Document.mime_type = sb.toString();
                                tLRPC$TL_message.media.document.size = (int) file.length();
                                tLRPC$TL_message.media.document.dc_id = 0;
                                TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio = new TLRPC$TL_documentAttributeAudio();
                                tLRPC$TL_documentAttributeAudio.duration = rGHMediaHelper$AudioEntry.duration;
                                tLRPC$TL_documentAttributeAudio.title = rGHMediaHelper$AudioEntry.title;
                                tLRPC$TL_documentAttributeAudio.performer = rGHMediaHelper$AudioEntry.author;
                                tLRPC$TL_documentAttributeAudio.flags |= 3;
                                tLRPC$TL_message.media.document.attributes.add(tLRPC$TL_documentAttributeAudio);
                                TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
                                tLRPC$TL_documentAttributeFilename.file_name = file.getName();
                                tLRPC$TL_message.media.document.attributes.add(tLRPC$TL_documentAttributeFilename);
                                rGHMediaHelper$AudioEntry.messageObject = new MessageObject(((BaseFragment) AudioSelectActivity.this).currentAccount, tLRPC$TL_message, false, true);
                                arrayList.add(rGHMediaHelper$AudioEntry);
                                j--;
                                cursorQuery = cursor;
                                i = 2;
                                i2 = 4;
                                i3 = 5;
                            } catch (Exception unused) {
                                cursorQuery = cursor;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.AudioSelectActivity.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AudioSelectActivity.this.audioEntries = arrayList;
                                        AudioSelectActivity.this.progressView.showTextView();
                                        AudioSelectActivity.this.listViewAdapter.notifyDataSetChanged();
                                    }
                                });
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery = cursor;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    cursorQuery.close();
                } catch (Exception unused3) {
                } catch (Throwable th3) {
                    th = th3;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.AudioSelectActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioSelectActivity.this.audioEntries = arrayList;
                        AudioSelectActivity.this.progressView.showTextView();
                        AudioSelectActivity.this.listViewAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AudioSelectActivity.this.audioEntries.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            AudioCell audioCell = new AudioCell(this.mContext);
            audioCell.setDelegate(new AudioCell.AudioCellDelegate(this) { // from class: androidMessenger.utilites.AudioSelectActivity.ListAdapter.1
            });
            return new RecyclerListView.Holder(audioCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
            ((AudioCell) viewHolder.itemView).setAudio((RGHMediaHelper$AudioEntry) AudioSelectActivity.this.audioEntries.get(i), i != AudioSelectActivity.this.audioEntries.size() - 1, AudioSelectActivity.this.selectedAudios.indexOfKey(((RGHMediaHelper$AudioEntry) AudioSelectActivity.this.audioEntries.get(i)).id) >= 0);
        }
    }
}
