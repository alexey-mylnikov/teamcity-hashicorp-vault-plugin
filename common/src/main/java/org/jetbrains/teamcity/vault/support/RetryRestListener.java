package org.jetbrains.teamcity.vault.support;

import com.intellij.openapi.diagnostic.Logger;
import jetbrains.buildServer.log.Loggers;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

public class RetryRestListener extends RetryListenerSupport {

    protected final static Logger LOG = Logger.getInstance(Loggers.AGENT_CATEGORY + "." + "RetryRestListener");

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        LOG.warn("Vault query failed. Retrying..", throwable);
        super.onError(context, callback, throwable);
    }
}
