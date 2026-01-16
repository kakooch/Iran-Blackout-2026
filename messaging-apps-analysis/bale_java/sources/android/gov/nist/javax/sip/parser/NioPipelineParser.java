package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.ContentLength;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel;
import android.gov.nist.javax.sip.stack.QueuedMessageDispatchBase;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

/* loaded from: classes.dex */
public class NioPipelineParser {
    private static final String CRLF = "\r\n";
    private static StackLogger logger = CommonLogger.getLogger(NioPipelineParser.class);
    String callId;
    int contentLength;
    int contentReadSoFar;
    boolean currentStreamEnded;
    boolean isRunning;
    private int maxMessageSize;
    StringBuilder message;
    byte[] messageBody;
    String partialLine;
    boolean partialLineRead;
    boolean readingHeaderLines;
    boolean readingMessageBodyContents;
    protected SIPMessageListener sipMessageListener;
    private SIPTransactionStack sipStack;
    private int sizeCounter;
    private MessageParser smp;

    public class Dispatch implements Runnable, QueuedMessageDispatchBase {
        String callId;
        long time = System.currentTimeMillis();
        UnparsedMessage unparsedMessage;

        public Dispatch(UnparsedMessage unparsedMessage, String str) {
            this.unparsedMessage = unparsedMessage;
            this.callId = str;
        }

        @Override // android.gov.nist.javax.sip.stack.QueuedMessageDispatchBase
        public long getReceptionTime() {
            return this.time;
        }

        @Override // java.lang.Runnable
        public void run() {
            NioPipelineParser.logger.logInfo("serving msg on call id " + this.callId);
            SIPMessage sIPMessage = null;
            try {
                try {
                    try {
                        if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                            NioPipelineParser.logger.logDebug("\nUnparsed message before parser is:\n" + this.unparsedMessage);
                        }
                        sIPMessage = NioPipelineParser.this.smp.parseSIPMessage(this.unparsedMessage.lines.getBytes("UTF-8"), false, false, null);
                        if (sIPMessage != null) {
                            byte[] bArr = this.unparsedMessage.body;
                            if (bArr.length > 0) {
                                sIPMessage.setMessageContent(bArr);
                            }
                        } else if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                            NioPipelineParser.logger.logDebug("parsed message is null, probably because of end of stream, empty packets or socket closed and we got CRLF to terminate cleanly, not processing message");
                        }
                        if (NioPipelineParser.this.sipStack.sipEventInterceptor != null && sIPMessage != null) {
                            NioPipelineParser.this.sipStack.sipEventInterceptor.beforeMessage(sIPMessage);
                        }
                        if (sIPMessage != null) {
                            NioPipelineParser.this.sipMessageListener.processMessage(sIPMessage);
                        }
                        if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                            NioPipelineParser.logger.logDebug("releasing semaphore for message " + sIPMessage);
                        }
                    } catch (Exception e) {
                        NioPipelineParser.logger.logError("Error occured processing message " + ((Object) NioPipelineParser.this.message), e);
                        if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                            NioPipelineParser.logger.logDebug("releasing semaphore for message " + sIPMessage);
                        }
                        if (NioPipelineParser.this.sipStack.sipEventInterceptor != null && sIPMessage != null) {
                        }
                    }
                } catch (ParseException e2) {
                    if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                        NioPipelineParser.logger.logDebug("Problem parsing message " + this.unparsedMessage + Separators.SP + e2.getMessage());
                    }
                    if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                        NioPipelineParser.logger.logDebug("releasing semaphore for message " + sIPMessage);
                    }
                    if (NioPipelineParser.this.sipStack.sipEventInterceptor != null && sIPMessage != null) {
                    }
                }
                if (NioPipelineParser.this.sipStack.sipEventInterceptor != null && sIPMessage != null) {
                    NioPipelineParser.this.sipStack.sipEventInterceptor.afterMessage(sIPMessage);
                }
                if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                    NioPipelineParser.logger.logDebug("dispatch task done on " + sIPMessage);
                }
            } catch (Throwable th) {
                if (NioPipelineParser.logger.isLoggingEnabled(32)) {
                    NioPipelineParser.logger.logDebug("releasing semaphore for message " + sIPMessage);
                }
                if (NioPipelineParser.this.sipStack.sipEventInterceptor != null && sIPMessage != null) {
                    NioPipelineParser.this.sipStack.sipEventInterceptor.afterMessage(sIPMessage);
                }
                throw th;
            }
        }
    }

    public static class UnparsedMessage {
        byte[] body;
        String lines;

        public UnparsedMessage(String str, byte[] bArr) {
            this.lines = str;
            this.body = bArr;
        }

        public String toString() {
            return super.toString() + Separators.RETURN + this.lines;
        }
    }

    protected NioPipelineParser() {
        this.smp = null;
        this.isRunning = false;
        this.currentStreamEnded = false;
        this.readingMessageBodyContents = false;
        this.readingHeaderLines = true;
        this.partialLineRead = false;
        this.partialLine = "";
        this.message = new StringBuilder();
        this.messageBody = null;
        this.contentLength = 0;
        this.contentReadSoFar = 0;
    }

    private void checkLimits() {
        if (this.maxMessageSize <= 0 || this.sizeCounter >= 0) {
            return;
        }
        throw new RuntimeException("Max Message Size Exceeded " + this.maxMessageSize);
    }

    private int readChunk(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = inputStream.read(bArr, i, i2);
        this.sizeCounter -= i3;
        checkLimits();
        return i3;
    }

    private String readLine(InputStream inputStream) {
        this.partialLineRead = false;
        int i = 1024;
        byte[] bArr = new byte[1024];
        byte[] bArr2 = new byte[2];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int singleByte = readSingleByte(inputStream);
            if (singleByte == -1) {
                this.partialLineRead = true;
                this.currentStreamEnded = true;
                break;
            }
            int i4 = singleByte & 255;
            char c = (char) i4;
            if (c != '\r') {
                bArr[i2] = (byte) i4;
                i2++;
            } else if (i2 == 0) {
                bArr2[i3] = 13;
                i3++;
            }
            if (c == '\n') {
                if (i2 == 1 && i3 > 0) {
                    bArr2[i3] = 10;
                    i3++;
                }
            } else if (i2 == i) {
                int i5 = i + 1024;
                byte[] bArr3 = new byte[i5];
                System.arraycopy(bArr, 0, bArr3, 0, i);
                i = i5;
                bArr = bArr3;
            }
        }
        if (i2 == 1 && i3 > 0) {
            return new String(bArr2, 0, i3, "UTF-8");
        }
        String str = new String(bArr, 0, i2, "UTF-8");
        if (i3 != 1) {
            return str;
        }
        return str + "\r";
    }

    private void readMessageBody(InputStream inputStream) throws IOException {
        int chunk;
        int i = this.contentLength;
        if (i > 0) {
            byte[] bArr = this.messageBody;
            int i2 = this.contentReadSoFar;
            chunk = readChunk(inputStream, bArr, i2, i - i2);
            if (chunk == -1) {
                this.currentStreamEnded = true;
                chunk = 0;
            }
        } else {
            chunk = 0;
        }
        int i3 = this.contentReadSoFar + chunk;
        this.contentReadSoFar = i3;
        if (i3 == this.contentLength) {
            this.sizeCounter = this.maxMessageSize;
            this.readingHeaderLines = true;
            this.readingMessageBodyContents = false;
            String string = this.message.toString();
            this.message = new StringBuilder();
            byte[] bArr2 = this.messageBody;
            if (this.sipStack.getSelfRoutingThreadpoolExecutor() != null) {
                String str = this.callId;
                if (str == null || str.trim().length() < 1) {
                    throw new IOException("received message with no Call-ID");
                }
                this.sipStack.getSelfRoutingThreadpoolExecutor().execute(new Dispatch(new UnparsedMessage(string, bArr2), str));
                return;
            }
            SIPMessage sIPMessage = null;
            try {
                sIPMessage = this.smp.parseSIPMessage(string.getBytes("UTF-8"), false, false, null);
                sIPMessage.setMessageContent(bArr2);
            } catch (ParseException e) {
                logger.logDebug("Parsing issue !  " + new String(string.getBytes("UTF-8")) + Separators.SP + e.getMessage());
            }
            this.contentLength = 0;
            processSIPMessage(sIPMessage);
        }
    }

    private boolean readMessageSipHeaderLines(InputStream inputStream, boolean z) {
        boolean z2;
        String line = readLine(inputStream);
        if (this.partialLineRead) {
            this.partialLine += line;
            return false;
        }
        String str = this.partialLine + line;
        this.partialLine = "";
        if (!str.equals("\r\n")) {
            this.message.append(str);
            String lowerCase = str.toLowerCase();
            String str2 = ContentLength.NAME_LOWER;
            if (lowerCase.startsWith(str2)) {
                this.contentLength = Integer.parseInt(str.substring(str2.length() + 1).trim());
                return false;
            }
            String str3 = CallID.NAME_LOWER;
            if (!lowerCase.startsWith(str3)) {
                return false;
            }
            this.callId = str.substring(str3.length() + 1).trim();
            return false;
        }
        if (z) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("KeepAlive Double CRLF received, sending single CRLF as defined per RFC 5626 Section 4.4.1");
                logger.logDebug("~~~ setting isPreviousLineCRLF=false");
            }
            try {
                this.sipMessageListener.sendSingleCLRF();
            } catch (Exception e) {
                logger.logError("A problem occured while trying to send a single CLRF in response to a double CLRF", e);
            }
            z2 = false;
        } else {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Received CRLF");
            }
            SIPMessageListener sIPMessageListener = this.sipMessageListener;
            if (sIPMessageListener != null && (sIPMessageListener instanceof ConnectionOrientedMessageChannel)) {
                ((ConnectionOrientedMessageChannel) sIPMessageListener).cancelPingKeepAliveTimeoutTaskIfStarted();
            }
            z2 = true;
        }
        if (this.message.length() > 0) {
            this.readingMessageBodyContents = true;
            this.readingHeaderLines = false;
            this.partialLineRead = false;
            this.message.append("\r\n");
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Content Length parsed is " + this.contentLength);
            }
            this.contentReadSoFar = 0;
            this.messageBody = new byte[this.contentLength];
        }
        return z2;
    }

    private int readSingleByte(InputStream inputStream) {
        this.sizeCounter--;
        checkLimits();
        return inputStream.read();
    }

    public synchronized void addBytes(byte[] bArr) {
        this.currentStreamEnded = false;
        readStream(new ByteArrayInputStream(bArr));
    }

    public void close() {
    }

    public void processSIPMessage(SIPMessage sIPMessage) {
        try {
            this.sipMessageListener.processMessage(sIPMessage);
        } catch (Exception e) {
            logger.logError("Can't process message", e);
        }
    }

    public void readStream(InputStream inputStream) throws IOException {
        boolean messageSipHeaderLines = false;
        while (!this.currentStreamEnded) {
            if (this.readingHeaderLines) {
                messageSipHeaderLines = readMessageSipHeaderLines(inputStream, messageSipHeaderLines);
            }
            if (this.readingMessageBodyContents) {
                readMessageBody(inputStream);
            }
        }
    }

    public void setMessageListener(SIPMessageListener sIPMessageListener) {
        this.sipMessageListener = sIPMessageListener;
    }

    public NioPipelineParser(SIPTransactionStack sIPTransactionStack, SIPMessageListener sIPMessageListener, boolean z, int i) {
        this();
        this.sipStack = sIPTransactionStack;
        this.smp = sIPTransactionStack.getMessageParserFactory().createMessageParser(sIPTransactionStack);
        this.sipMessageListener = sIPMessageListener;
        this.maxMessageSize = i;
        this.sizeCounter = i;
    }

    public NioPipelineParser(SIPTransactionStack sIPTransactionStack, SIPMessageListener sIPMessageListener, int i) {
        this(sIPTransactionStack, sIPMessageListener, false, i);
    }
}
