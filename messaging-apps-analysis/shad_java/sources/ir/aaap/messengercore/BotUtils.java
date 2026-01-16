package ir.aaap.messengercore;

import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.model.AuxDataObject;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.api.BotModels;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.usecase.UpdateChatAndMessageUsecase;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class BotUtils {
    private CoreLog coreLog;
    Set<String> waitingForSendMessageCallback = new HashSet();

    public BotUtils(CoreLog coreLog) {
        this.coreLog = coreLog;
    }

    public int stopBot(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase) {
        BotModels.StopBotInput stopBotInput = new BotModels.StopBotInput();
        stopBotInput.bot_guid = str;
        try {
            return networkHelper.stopBot(str2, stopBotInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<BotModels.StopBotOutput>(this) { // from class: ir.aaap.messengercore.BotUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(BotModels.StopBotOutput stopBotOutput) {
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2;
                    if (stopBotOutput == null || (updateChatAndMessageUsecase2 = updateChatAndMessageUsecase) == null) {
                        return;
                    }
                    updateChatAndMessageUsecase2.processChatUpdate(stopBotOutput.chat_update);
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getSelection(String str, String str2, String str3, String str4, String str5, NetworkHelper networkHelper, final LoadListener<BotModels.GetBotSelectionOutput> loadListener) {
        BotModels.GetBotSelectionInput getBotSelectionInput = new BotModels.GetBotSelectionInput();
        getBotSelectionInput.bot_guid = str2;
        getBotSelectionInput.selection_id = str3;
        getBotSelectionInput.start_id = str4;
        try {
            return networkHelper.getSelection(str, str5, getBotSelectionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<BotModels.GetBotSelectionOutput>(this) { // from class: ir.aaap.messengercore.BotUtils.2
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(BotModels.GetBotSelectionOutput getBotSelectionOutput) {
                    if (getBotSelectionOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getBotSelectionOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int searchSelection(String str, String str2, String str3, String str4, int i, String str5, NetworkHelper networkHelper, final LoadListener<BotModels.SearchBotSelectionOutput> loadListener) {
        BotModels.SearchBotSelectionInput searchBotSelectionInput = new BotModels.SearchBotSelectionInput();
        searchBotSelectionInput.bot_guid = str2;
        searchBotSelectionInput.selection_id = str3;
        searchBotSelectionInput.search_text = str4;
        searchBotSelectionInput.limit = i;
        try {
            return networkHelper.searchSelection(str, str5, searchBotSelectionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<BotModels.SearchBotSelectionOutput>(this) { // from class: ir.aaap.messengercore.BotUtils.3
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(BotModels.SearchBotSelectionOutput searchBotSelectionOutput) {
                    if (searchBotSelectionOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(searchBotSelectionOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int sendMessageAPICall(String str, String str2, long j, String str3, FileInlineObject fileInlineObject, LocationObject locationObject, AuxDataObject auxDataObject, String str4, NetworkHelper networkHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<Integer> loadListener) {
        final String str5 = str2 + "_" + j + "_" + auxDataObject.button_id;
        if (this.waitingForSendMessageCallback.contains(str5)) {
            return 0;
        }
        this.waitingForSendMessageCallback.add(str5);
        BotModels.SendMessageApiCallInput sendMessageApiCallInput = new BotModels.SendMessageApiCallInput();
        sendMessageApiCallInput.object_guid = str2;
        sendMessageApiCallInput.message_id = j;
        sendMessageApiCallInput.text = str3;
        sendMessageApiCallInput.file_inline = fileInlineObject;
        sendMessageApiCallInput.location = locationObject;
        sendMessageApiCallInput.aux_data = auxDataObject;
        try {
            return networkHelper.sendMessageAPICall(str, str4, sendMessageApiCallInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<BotModels.SendMessageApiCallOutput>() { // from class: ir.aaap.messengercore.BotUtils.4
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(BotModels.SendMessageApiCallOutput sendMessageApiCallOutput) {
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2;
                    BotUtils.this.waitingForSendMessageCallback.remove(str5);
                    if (sendMessageApiCallOutput != null && (updateChatAndMessageUsecase2 = updateChatAndMessageUsecase) != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(sendMessageApiCallOutput.message_updates, sendMessageApiCallOutput.chat_update, false, true);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    BotUtils.this.waitingForSendMessageCallback.remove(str5);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.waitingForSendMessageCallback.remove(str5);
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }
}
