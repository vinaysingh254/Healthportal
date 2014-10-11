package com.healthvision.client.layout;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class HeaderPresenter extends Presenter<HeaderPresenter.MyView, HeaderPresenter.MyProxy> {

    // for nested presenters
    @ContentSlot public static final Type<RevealContentHandler<?>> SLOT_content = new Type<RevealContentHandler<?>>();

    public interface MyView extends View {}
    @ProxyCodeSplit
    public interface MyProxy extends Proxy<HeaderPresenter> {}

    @Inject
    public HeaderPresenter(
            final EventBus eventBus,
            final MyView view,
            final MyProxy proxy) {
        super(eventBus, view, proxy);
    }
    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
    @Override
    protected void onBind() {
        super.onBind();
    }
}
