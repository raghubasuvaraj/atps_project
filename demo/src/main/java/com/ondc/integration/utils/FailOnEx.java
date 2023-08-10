package com.ondc.integration.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@RequiredArgsConstructor
public class FailOnEx<T> implements ListenableFutureCallback<T> {
    private final SuccessCallback<T> successCb;
    private final FailureCallback failureCb;

    @Override
    public void onFailure(Throwable ex) {
        failureCb.onFailure(ex);
    }

    @Override
    public void onSuccess(T result) {
        try {
            successCb.onSuccess(result);
        } catch (Throwable e) {
            failureCb.onFailure(e);
        }
    }
}
