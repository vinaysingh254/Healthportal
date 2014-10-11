package com.healthvision.client.home;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.healthvision.client.TokenParameter;
import com.healthvision.client.layout.HeaderPresenter;
import com.healthvision.client.place.NameTokens;

public class SignupPresenter extends Presenter<SignupPresenter.MyView, SignupPresenter.MyProxy> {

    public interface MyView extends View {

        public Label getSignUpLabel();
    }
    @ProxyCodeSplit
    @NameToken(NameTokens.signup)
    public interface MyProxy extends ProxyPlace<SignupPresenter> {}

    private String name;

    @Inject
    public SignupPresenter(
            final EventBus eventBus,
            final MyView view,
            final MyProxy proxy) {
        super(eventBus, view, proxy);
    }
    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);
        name = request.getParameter(TokenParameter.NAME, "defaultValue");
    }
    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, HeaderPresenter.SLOT_content, this);
    }
    @Override
    protected void onBind() {
        super.onBind();
    }
    @Override
    protected void onReset() {
        super.onReset();
        getView().getSignUpLabel().setText(name);
    }
}
