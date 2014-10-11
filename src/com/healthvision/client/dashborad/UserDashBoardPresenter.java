package com.healthvision.client.dashborad;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.healthvision.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.healthvision.client.layout.HeaderPresenter;

public class UserDashBoardPresenter extends Presenter<UserDashBoardPresenter.MyView, UserDashBoardPresenter.MyProxy> {

    public interface MyView extends View {}

    @ProxyCodeSplit
    @NameToken(NameTokens.dashboard)
    public interface MyProxy extends ProxyPlace<UserDashBoardPresenter> {}

    @Inject
    public UserDashBoardPresenter(
            final EventBus eventBus,
            final MyView view,
            final MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, HeaderPresenter.SLOT_content, this);
    }

    @Override
    protected void onBind() {
        super.onBind();
    }}
